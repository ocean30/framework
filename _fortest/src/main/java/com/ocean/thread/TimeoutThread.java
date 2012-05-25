package com.ocean.thread;

/***
 * ���߳�������һ����ʱʱ��
 * 
 * ���߳̿�ʼ���к󣬾���ָ����ʱʱ�䣬
 * 
 * ���̻߳��׳�һ��δ����쳣֪ͨ���ø��̵߳ĳ���ʱ
 * 
 * �ڳ�ʱ����ǰ���Ե��ø����cancel����ȡ����ʱ* 
 * 
 * @author solonote
 */
public class TimeoutThread extends Thread {
	/***
	 * ��ʱ����ʱʱ��
	 */
	private long timeout;
	/***
	 * ��ʱ�Ƿ�ȡ��
	 */
	private boolean isCanceled = false;
	/***
	 * ����ʱ����ʱʱ�׳����쳣
	 */
	private TimeoutException timeoutException;

	/***
	 * ������
	 * 
	 * @param timeout
	 *            ָ����ʱ��ʱ��
	 */
	public TimeoutThread(long timeout,TimeoutException timeoutErr) {
		super();
		this.timeout = timeout;

		this.timeoutException = timeoutErr;// ���ñ��߳�Ϊ�ػ��߳�this.setDaemon(true);

	}

	/*** ȡ����ʱ */
	public synchronized void cancel()

	{
		isCanceled = true;
	}

	/***
	 * ������ʱ��ʱ��
	 */
	public void run() {
		try {
			Thread.sleep(timeout);

			if (!isCanceled)
				throw timeoutException;
		} catch (InterruptedException e)

		{
			e.printStackTrace();
		}
	}
}