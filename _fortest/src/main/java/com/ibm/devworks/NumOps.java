package com.ibm.devworks;

import java.util.ArrayList;
import java.util.List;

public class NumOps {
	private List<Operation> ops = new ArrayList<Operation>();

	public NumOps() {
		ops.add(new AddOps());
	}

	public Operation getOp(int i) {
		Operation retval;
		if (i > ops.size()) {
			retval = null;
		} else {
			retval = (Operation) ops.get(i);
		}
		return retval;
	}

	public int size() {
		return ops.size();
	}

	public static void main(String[] args) {
		NumOps nop = new NumOps();
		for (int i = 0; i < nop.size(); i++) {
			System.out.println("2 " + nop.getOp(i).getDesc() + " 1 is " + nop.getOp(i).op(2, 1));
		}
	}
}