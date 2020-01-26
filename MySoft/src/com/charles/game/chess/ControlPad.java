package com.charles.game.chess;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 * ����Panel
 * ��Panel�ϵİ�ť�������������Ӧ�Ĺ���
 * @author Charles
 * @date   2016��6��23�� ����5:37:05
 */
public class ControlPad extends Panel {

	private static final long serialVersionUID = -7061394710289057124L;
	public Label IPlabel = new Label("������IP:", Label.LEFT);
	public TextField inputIP = new TextField("localhost", 10);
	public Button connectButton = new Button("��������");
	public Button creatGameButton = new Button("������Ϸ");
	public Button joinGameButton = new Button("������Ϸ");
	public Button cancelGameButton = new Button("������Ϸ");
	public Button exitGameButton = new Button("�رճ���");

	// ���캯��������Panel�ĳ�ʼ���֡�
	public ControlPad() {
		// ���ò��ֹ�����,�ͱ�����ɫ
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(new Color(204, 204, 204));
		// �����Ӧ�ؼ�
		add(IPlabel);
		add(inputIP);
		add(connectButton);
		add(creatGameButton);
		add(joinGameButton);
		add(cancelGameButton);
		add(exitGameButton);
	}
}
