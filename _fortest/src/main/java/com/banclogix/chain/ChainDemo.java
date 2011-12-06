package com.banclogix.chain;

// Purpose.  Chain of Responsibility design pattern

// 1. Put a "next" pointer in the base class
// 2. The "chain" method in the base class always delegates to the next object
// 3. If the derived classes cannot handle, they delegate to the base class

abstract class Component {
	private int value;
	private Component next; // 1. "next" pointer in the base class

	public Component(int v) {
		this(v, null);
	}

	public Component(int v, Component n) {
		value = v;
		next = n;
	}

	public void setNext(Component n) {
		next = n;
	}

	public void traverse() {
		System.out.print(value + " ");
	}

	// 2. The "chain" method in the base class always delegates to the next obj
	public void volunteer() {
		next.volunteer();
	}
}

class Primitive extends Component {
	public Primitive(int val) {
		this(val, null);
	}

	public Primitive(int val, Component n) {
		super(val, n);
	}

	public void volunteer() {
		super.traverse();
		// 3. Primitive objects don't handle volunteer requests 5 times out of 6
		if ((int) (Math.random() * 100) % 6 != 0)
			// 3. Delegate to the base class
			super.volunteer();
	}
}

class Composite extends Component {
	private Component[] children = new Component[9];
	private int total = 0;

	public Composite(int val) {
		this(val, null);
	}

	public Composite(int val, Component n) {
		super(val, n);
	}

	public void add(Component c) {
		children[total++] = c;
	}

	public void traverse() {
		super.traverse(); // 1
		for (int i = 0; i < total; i++)
			// |
			children[i].traverse(); // +-- 2
	} // | |

	// 3. Composite objects never handle volunteer // | +-- 4 5
	public void volunteer() { // requests // |
		super.volunteer(); // +-- 3
	}
} // | |
// | +-- 6 7

public class ChainDemo { // |
	public static void main(String[] args) { // +-- 8 9
		Component seven = new Primitive(7); //
		Component six = new Primitive(6, seven); // tra: 1 2 4 5 3 6 7 8 9
		Composite three = new Composite(3, six); // 4
		three.add(six);
		three.add(seven); // 4 5 6 7
		Component five = new Primitive(5, three); // 4 5 6 7 8 9
		Component four = new Primitive(4, five); // 4 5 6 7 8
		Composite two = new Composite(2, four); // 4 5 6 7
		two.add(four);
		two.add(five); // 4 5 6 7 8 9 4 5 6 7
		Composite one = new Composite(1, two); // 4
		Component nine = new Primitive(9, one); // 4 5 6 7 8 9 4 5 6 7 8
		Component eight = new Primitive(8, nine);
		one.add(two);
		one.add(three);
		one.add(eight);
		one.add(nine);
		seven.setNext(eight);
		System.out.print("tra: ");
		one.traverse();
		System.out.println();
		for (int i = 0; i < 8; i++) {
			one.volunteer();
			System.out.println();
		}
	}
}