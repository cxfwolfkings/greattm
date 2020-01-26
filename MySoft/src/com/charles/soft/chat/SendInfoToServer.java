package com.charles.soft.chat;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ����̵߳������ǻ�ȡ�������������ͨ����������͸������
 */
public class SendInfoToServer extends Thread {
	private OutputStream out;

	public SendInfoToServer(OutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(System.in);
			OutputStreamWriter writer = new OutputStreamWriter(out);
			PrintWriter pw = new PrintWriter(writer);
			String info;
			while ((info = scanner.nextLine()) != null) {
				pw.println(info);
				pw.flush();
			}
		} catch (Exception e) {
		}
	}
}
