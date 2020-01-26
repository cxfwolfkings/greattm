package com.charles.game.chess;

import java.awt.*;

/**
 * �û��б�Panel
 * ��Panelά��һ���������ĵ�ǰ�û��б� ���е��û���������ʾ���б���
 * @author Charles
 * @date   2016��6��23�� ����5:31:13
 */
public class UserPad extends Panel {

	private static final long serialVersionUID = 7157806746832831193L;
	// �û��б�
	public List userList = new List(10);

	public UserPad() {
		// ���ò��ֹ������������Ϣ
		setLayout(new BorderLayout());
		for (int i = 0; i < 30; i++) {
			userList.add(i + ". ��ǰ�����û�");
		}
		// ��ӵ�Panel
		add(userList, BorderLayout.CENTER);
	}
}
