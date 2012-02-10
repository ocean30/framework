package com.ibm.devworks;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class NumOpsTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public NumOpsTest(String testName) {
		super(testName);
	}

	public void testNumOps() {
		NumOps nops = new NumOps();
		assertTrue(nops.size() == 1);
		assertTrue(nops.getOp(0).getDesc().equals("plus"));
		assertTrue(nops.getOp(0).op(2, 1) == 3);

	}
}