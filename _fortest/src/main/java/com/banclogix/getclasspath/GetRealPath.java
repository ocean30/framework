package com.banclogix.getclasspath;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class GetRealPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����·��,���а�Ŀ¼·��
//		file:/D:/git/git/trunk/_fortest/target/classes/com/banclogix/getclasspath/
//		/D:/git/git/trunk/_fortest/target/classes/com/banclogix/getclasspath/
		System.out.println(GetRealPath.class.getResource(""));
		System.out.println(GetRealPath.class.getResource("").getPath());
		
		//���·�������ĸ�Ŀ¼
//		file:/D:/git/git/trunk/_fortest/target/classes/			��ֱ����explorer�򿪵�·��URL,������new URL();
//		/D:/git/git/trunk/_fortest/target/classes/				�޷���explorer�򿪵�·����������new File()
		System.out.println(GetRealPath.class.getResource("/"));
		System.out.println(GetRealPath.class.getResource("/").getPath());
		
//		Map<String, String> env = System.getenv();
//		Set<String> keys = env.keySet();
//		for(String key : keys)
//			System.out.println(key);
				
//		Set<Object> props = System.getProperties().keySet() ;
//		for(Object o : props)
//				System.out.println(o);
		
		System.out.println(System.getProperty("user.dir"));
	}

}
