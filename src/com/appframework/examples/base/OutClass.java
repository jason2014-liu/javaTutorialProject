/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: OutClass.java
 * @Package com.appframework.examples.base
 * @author jason.liu
 * @Date 2014-10-21 下午3:49:14
 * @Version v1.0
 */
package com.appframework.examples.base;

/**
 * TODO
 * 
 * @ClassName: OutClass
 * @author jason.liu
 */
/**
 * compiled file :OutClass.class OutClass$InnerClass.class OutClass$StaticNestedClass.class
* TODO
* @ClassName: OutClass
* @author jason.liu
 */
public class OutClass {
	private String id;
	private static String staticID;

	public String getID() {

		InnerClass ic = new InnerClass();
		id = ic.fieldA;
		id = ic.getA();
		return id;
	}

	public static String getStaticID() {
		// Cannot make a static reference to the non-static field id
		// staticID = id;
		/**
		 * No enclosing instance of type OutClass is accessible. Must qualify
		 * the allocation with an enclosing instance of type OutClass (e.g.
		 * x.new A() where x is an instance of OutClass).
		 */
		// InnerClass ic = new InnerClass();
		// staticID = ic.getA();
		return staticID;
	}

	/**
	 * As with instance methods and variables, an inner class is associated with
	 * an instance of its enclosing class and has direct access to that object's
	 * methods and fields. Also, because an inner class is associated with an
	 * instance, it cannot define any static members itself. TODO
	 */
	class InnerClass {
		private String fieldA;
		/**
		 * The field fieldB cannot be declared static in a non-static inner
		 * type, unless initialized with a constant expression(final)
		 */
		// private static String fieldB;
		private static final String fieldC = "111";// need initialed

		public String getA() {

			fieldA = id;
			fieldA = getID();

			fieldA = getStaticID();

			return fieldA;
		}
	}

	/**
	 * As with class methods and variables, a static nested class is associated
	 * with its outer class. And like static class methods, a static nested
	 * class cannot refer directly to instance variables or methods defined in
	 * its enclosing class: it can use them only through an object reference.
	 */
	static class StaticNestedClass {
		private String strA;
		private static String strB;

		public String getStrA(){
			//Cannot make a static reference to the non-static field id
			//strA = id;
			strA = staticID;
			
			OutClass oc = new OutClass();
			strA = oc.id;
			return strA;
		}

		public static String getStrB() {
			//Cannot make a static reference to the non-static field id
			//strB = id;
			strB = staticID;
			
			OutClass oc = new OutClass();
			strB = oc.id;
			return strB;
		}

	}

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OutClass oc = new OutClass();
		/**
		 * No enclosing instance of type OutClass is accessible. Must qualify
		 * the allocation with an enclosing instance of type OutClass (e.g.
		 * x.new A() where x is an instance of OutClass).
		 */
		// InnerClass ic = new InnerClass();
		InnerClass ic = oc.new InnerClass();
		
		StaticNestedClass snc = new StaticNestedClass();
		
		OutClass.StaticNestedClass osnc = new OutClass.StaticNestedClass();

	}

}
