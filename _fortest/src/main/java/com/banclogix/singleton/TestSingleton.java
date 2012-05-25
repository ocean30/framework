package com.banclogix.singleton;
import java.lang.reflect.Constructor;
/**
 * ����Singleton�Ŀɿ��ԡ�
 * 
 * @author ������(laozizhu.com)
 */
public class TestSingleton {
  public static void main(String[] args) {
    testSingleton1();
    testSingleton2();
    testSingleton3();
    testSingleton4();
  }
  public static void testSingleton1() {
    try {
      // ����Singletom1
      // �õ���һ��ʵ��
      TestSingleton1 s1 = TestSingleton1.getInstance();
      // �����õ��ڶ���ʵ��
      Class c1 = Class.forName("com.banclogix.singleton.TestSingleton1");
      Constructor[] cons = c1.getDeclaredConstructors();
      Constructor cc1 = cons[0];
      System.out.println("1cons[0]: " + cons[0]);
      
      cc1.setAccessible(true);		//���ÿ��Է���˽��Ȩ��
      
      TestSingleton1 s2 = (TestSingleton1) cc1.newInstance(null);
      System.out.println(s1 + "/" + s2);
      System.out.println("s1 == s2: " + (s1 == s2));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public static void testSingleton2() {
    try {
      // ����Singletom1
      // �õ���һ��ʵ��
      TestSingleton2 s1 = TestSingleton2.getInstance();
      // �����õ��ڶ���ʵ��
      Class c1 = Class.forName("com.banclogix.singleton.TestSingleton2");
      Constructor[] cons = c1.getDeclaredConstructors();
      Constructor cc1 = cons[0];
      
      System.out.println("2cons[0]: " + cons[0]);
      cc1.setAccessible(true);
      TestSingleton2 s2 = (TestSingleton2) cc1.newInstance(null);
      System.out.println(s1 + "/" + s2);
      System.out.println("s1 == s2: " + (s1 == s2));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public static void testSingleton3() {
    try {
      // ����Singletom1
      // �õ���һ��ʵ��
      TestSingleton3 s1 = TestSingleton3.getInstance();
      // �����õ��ڶ���ʵ��
      Class c1 = Class.forName("com.banclogix.singleton.TestSingleton3");
      Constructor[] cons = c1.getDeclaredConstructors();
      Constructor cc1 = cons[0];
      
      System.out.println("3cons[0]: " + cons[0]);
      cc1.setAccessible(true);
      TestSingleton3 s2 = (TestSingleton3) cc1.newInstance(null);
      System.out.println(s1 + "/" + s2);
      System.out.println("s1 == s2: " + (s1 == s2));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public static void testSingleton4() {
	  try {
		  // ����Singletom1
		  // �õ���һ��ʵ��
		  TestSingleton4 s1 = TestSingleton4.getInstance();
//		  System.out.println("s41: " +s1);
		  // �����õ��ڶ���ʵ��
		  Class c1 = Class.forName("com.banclogix.singleton.TestSingleton4");
		  Constructor[] cons = c1.getDeclaredConstructors();
		  Constructor cc1 = cons[0];
		  
		  System.out.println("4cons[0]: " + cons[0]);
		  cc1.setAccessible(true);
		  TestSingleton4 s2 = (TestSingleton4) cc1.newInstance(null);
		  System.out.println(s1 + "/" + s2);
		  System.out.println("s1 == s2: " + (s1 == s2));
	  } catch (Exception ex) {
		  ex.printStackTrace();
	  }
  }
}
/**
 * һ����ͨ��Singletoneʵ�֡�
 * 
 * @author ������(laozizhu.com)
 */
class TestSingleton1 {
  private static final TestSingleton1 INSTANCE = new TestSingleton1();
  public static TestSingleton1 getInstance() {
    return INSTANCE;
  }
  private TestSingleton1() {
  }
}
class TestSingleton4 {
	private static TestSingleton4 INSTANCE = null;
	public synchronized static TestSingleton4 getInstance() {
		return INSTANCE=new TestSingleton4();
	}
	private TestSingleton4() {
	}
}
/**
 * һ�����쳣ǿ���˵�Singletoneʵ�֡�
 * 
 * @author ������(laozizhu.com)
 */
class TestSingleton2 {
  private static final TestSingleton2 INSTANCE = new TestSingleton2();
  public static TestSingleton2 getInstance() {
    return INSTANCE;
  }
  private static boolean initSign;
  private TestSingleton2() {
    if (initSign) {
      throw new RuntimeException("ʵ��ֻ�ܽ���һ��");
    }
    initSign = true;
  }
}
/**
 * ö��ʵ�ֵ�Singleton
 * 
 * @author ������(laozizhu.com)
 */
enum TestSingleton3 {
  INSTANCE;
  public static TestSingleton3 getInstance() {
    return INSTANCE;
  }
}