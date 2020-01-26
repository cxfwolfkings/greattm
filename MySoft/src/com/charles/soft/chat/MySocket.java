package com.charles.soft.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ����ͻ��� 
 * 1.����Socket��ָ�������IP�Լ�����˵ķ���˿ڣ�������Socket��ͬʱ��ʵ�����Ѿ����ӵ��˷���� ����û�д����ɹ��ǻᱨ���
 * 2.ͨ��Socket�����ȡ�����������������Ϣ������� 
 * 3.ͨ��Socket�����ȡ��������������ȡ���Է���˵���Ϣ
 */
public class MySocket {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 8088);
		OutputStream out = socket.getOutputStream();
		SendInfoToServer thread = new SendInfoToServer(out);
		thread.start();
		/**************************** �����ָ��� ********************************/
		InputStream in = socket.getInputStream();
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		String str;
		while ((str = br.readLine()) != null) {
			System.out.print("�����˵:");
			System.out.println(str);
		}
	}
}
