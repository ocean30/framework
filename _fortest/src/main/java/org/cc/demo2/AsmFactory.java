package org.cc.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 * 
 * <p>
 * asm 代理工厂
 * </p>
 * 
 * @author dixingxing
 * @date Apr 29, 2012
 */
public class AsmFactory {
	public static final String SUFIX = "$EnhancedByCc";
	public static BytecodeLoader classLoader = new BytecodeLoader();

	/**
	 * 
	 * <p>
	 * 根据字节码加载class
	 * </p>
	 * 
	 * @author dixingxing
	 * @date Apr 29, 2012
	 */
	public static class BytecodeLoader extends ClassLoader {
		public Class<?> defineClass(String className, byte[] byteCodes) {
			return super.defineClass(className, byteCodes, 0, byteCodes.length);
		}
	}

	
	/**
	 * 
	 * <p>
	 * 返回代理类
	 * </p>
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected static <T> Class<T> getEnhancedClass(Class<T> clazz){
		String enhancedClassName = clazz.getName() + SUFIX;
		try {
			return (Class<T>) classLoader.loadClass(enhancedClassName);
		} catch (ClassNotFoundException classNotFoundException) {
			ClassReader reader = null;
			try {
				reader = new ClassReader(clazz.getName());
			} catch (IOException ioexception) {
				throw new RuntimeException(ioexception);
			}
			ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			ClassVisitor visitor = new ClassAdapter(enhancedClassName, clazz,
					writer);
			reader.accept(visitor, 0);
			byte[] byteCodes = writer.toByteArray();
			writeClazz(enhancedClassName, byteCodes);
			Class<T> result = (Class<T>) classLoader.defineClass(
					enhancedClassName, byteCodes);
			return result;
		}
	}
	
	/**
	 * 
	 * <p>
	 * 把java字节码写入class文件
	 * </p>
	 * 
	 * @param <T>
	 * @param name
	 * @param data
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static <T> void writeClazz(String name, byte[] data) {
		try {
			File file = new File("C:/TEMP/" + name + ".class");
			FileOutputStream fout = new FileOutputStream(file);

			fout.write(data);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class<RoleService> rsCls = getEnhancedClass(RoleService.class);
		rsCls.newInstance().executeOuter(1);
	}

}
