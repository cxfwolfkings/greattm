package com.charles.game.chess;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.TextArea;

/**
 * ������ϢPanel
 * Panel�ϵ��ı��������ʾ�û�������Ϣ
 * @author Charles
 * @date   2016��6��23�� ����5:35:19
 */
public class ChatPad extends Panel {

	private static final long serialVersionUID = 7729381485931271396L;
	// �����յ��ı���
	public TextArea chatLineArea = new TextArea(
			"", 18, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);

	public ChatPad() {
		// �����Ű��ʽ
		setLayout(new BorderLayout());
		// ���ı�����ӵ�Panel����
		add(chatLineArea, BorderLayout.CENTER);
	}
}
