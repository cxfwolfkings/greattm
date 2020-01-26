package com.charles.soft.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ���ڻ�ȡ���Կͻ�����Ϣ���̣߳�����̵߳������Ǽ������Կͻ��˵����ݣ���ӡ������˵Ŀ���̨��
 */
public class GetClientInfoThread extends Thread {
	// �����������ServerSocket�����
	private InputStream in;

	// GetClientInfoThread t = new GetClientInfoThread();
	public GetClientInfoThread(InputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		String info;
		try {
			while ((info = br.readLine()) != null) {
				System.out.println("�ͻ���˵:" + info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
