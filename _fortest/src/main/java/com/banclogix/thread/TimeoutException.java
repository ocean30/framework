package com.banclogix.thread;

public class TimeoutException extends RuntimeException

{
	/*** ���л��� */

	private static final long serialVersionUID = -8078853655388692688L;

	public TimeoutException(String errMessage) {
		super(errMessage);

	}
}