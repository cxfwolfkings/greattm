package com.charles.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

/**
 * ����һ��������Ϸ����ƽ̨ ����������
 * 
 * @author Charles
 * @date 2016-05-23
 */
public class CasualGames extends JFrame {

	private static final long serialVersionUID = -6799504992718560718L;
	private static CasualGames games;
	// �˵���
	private JMenuBar bar = new JMenuBar();
	// �˵�������4���˵�
	private JMenu mGame = new JMenu("��Ϸ"), mControl = new JMenu("����"), mInfo = new JMenu("����");

	// 4���˵��зֱ�����Ĳ˵���
	private JMenuItem miErsBlock = new JMenuItem("����˹����"), 
			miSave = new JMenuItem("�浵"), miLoad = new JMenuItem("����"),
			miAuthor = new JMenuItem("���� : Charles"), miSourceInfo = new JMenuItem("�汾��1.0");

	public static void main(String[] args) {
		games = new CasualGames();
	}

	public CasualGames() {
		super("������Ϸ����ƽ̨");
		//��ʼ���ڵĴ�С���û��ɵ���
		setSize(315, 392);
		//����Ϸ����������Ļ����
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrSize.width - getSize().width) / 2, (scrSize.height - getSize().height) / 2);
		//�����˵�
		createMenu();
		Container container = getContentPane();
		// ���ֵ�ˮƽ����֮����6�����صľ���
		container.setLayout(new BorderLayout(6, 0));

		super.setVisible(true);//setVisiable
	}
	
	/**
	 * ���������ô��ڲ˵�
	 */
	private void createMenu() {
		bar.add(mGame);
		bar.add(mControl);
		bar.add(mInfo);

		mGame.add(miErsBlock);
		//mGame.addSeparator();

		mControl.add(miSave);
		mControl.add(miLoad);;

		mInfo.add(miAuthor);
		mInfo.add(miSourceInfo);

		setJMenuBar(bar);

		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		miLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		
		miSave.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dialog = new JDialog(games, "ϵͳ��Ϣ", true);
				dialog.setSize(60, 60);
				dialog.setLayout(new BorderLayout());
				JLabel label = new JLabel("����");
				label.setHorizontalAlignment(JTextField.CENTER);
				label.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
				dialog.add(new JLabel("����"), BorderLayout.CENTER);
				dialog.setVisible(true);
			}
		});
	}

}