package com.charles.soft.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ����ServerSocket 
 * 1.����ServerSocketʵ����ͬʱָ������˿� 
 * 2.�ȴ��ͻ���Socket����
 * 3.���Ϻ󣬻�ȡSocket������������ڷ�����Ϣ����ȡSocket�������������ڽ�����Ϣ
 */
public class MyServerSocket {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8088);
		System.out.println("ServerSocket�������");
		System.out.println("ServerSocket�ȴ��ͻ�������...");
		Socket socket = serverSocket.accept();
		System.out.println("һ���ͻ�������,׼�������ʺ���.");
		InputStream in = socket.getInputStream();
		GetClientInfoThread thread = new GetClientInfoThread(in);
		thread.start();
		/********************************** �����ķָ��� **************************************/
		Scanner scanner = new Scanner(System.in);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(out);
		PrintWriter pw = new PrintWriter(writer);
		String info;
		while ((info = scanner.nextLine()) != null) {
			pw.println(info);
			pw.flush();
		}
		// pw.write("�ͻ��ˣ���ã����Ƿ����!");
		// pw.flush();
		System.out.println("�ʺ��﷢����ϣ��Ͽ��ͻ���");
		socket.close();
	}
}
