package com.ocean.design.abstractfactory;

// Abstract Factory classes are often implemented with Factory Methods, but they
// can also be implemented using Prototype. [GOF, p95]   Abstract Factory might
// store a set of Prototypes from which to clone and return product objects.
// [GOF, p126]  Factory Method: creation through inheritance. Protoype: creation
// through delegation.  Virtual constructor: defer choice of object to create
// until run-time.

public class FactoryFmProto {

	static class Expression {
		protected String str;

		public Expression(String s) {
			str = s;
		}

		public Expression cloan() {
			return null;
		}

		public String toString() {
			return str;
		}
	}

	static abstract class Factory {
		protected Expression prototype = null;

		public Expression makePhrase() {
			return prototype.cloan();
		}

		public abstract Expression makeCompromise();

		public abstract Expression makeGrade();
	}

	static class PCFactory extends Factory {
		public PCFactory() {
			prototype = new PCPhrase();
		}

		public Expression makeCompromise() {
			return new Expression("\"do it your way, any way, or no way\"");
		}

		public Expression makeGrade() {
			return new Expression("\"you pass, self-esteem intact\"");
		}
	}

	static class NotPCFactory extends Factory {
		public NotPCFactory() {
			prototype = new NotPCPhrase();
		}

		public Expression makeCompromise() {
			return new Expression("\"my way, or the highway\"");
		}

		public Expression makeGrade() {
			return new Expression("\"take test, deal with the results\"");
		}
	}

	public static void main(String[] args) {
		Factory factory;
		if (args.length > 0)
			factory = new PCFactory();
		else
			factory = new NotPCFactory();
		for (int i = 0; i < 3; i++)
			System.out.print(factory.makePhrase() + "  ");
		System.out.println();
		System.out.println(factory.makeCompromise());
		System.out.println(factory.makeGrade());
	}

	// D:\Java\patterns> java FactoryFmProto
	// "short" "lie" "old"
	// "my way, or the highway"
	// "take test, deal with the results"
	//
	// D:\Java\patterns> java FactoryFmProto 1
	// "vertically challenged" "factually inaccurate" "chronologically gifted"
	// "do it your way, any way, or no way"
	// "you pass, self-esteem intact"

	static class PCPhrase extends Expression {
		static String[] list = { "\"animal companion\"", "\"vertically challenged\"", "\"factually inaccurate\"",
				"\"chronologically gifted\"" };
		private static int next = 0;

		public PCPhrase() {
			super(list[next]);
			next = (next + 1) % list.length;
		}

		public Expression cloan() {
			return new PCPhrase();
		}
	}

	static class NotPCPhrase extends Expression {
		private static String[] list = { "\"pet\"", "\"short\"", "\"lie\"", "\"old\"" };
		private static int next = 0;

		public NotPCPhrase() {
			super(list[next]);
			next = (next + 1) % list.length;
		}

		public Expression cloan() {
			return new NotPCPhrase();
		}
	}
}