package com.charles.soft.chap;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

/**
 * ����������
 * @author Charles
 * @date 2013-09-12
 */
public class ComputerPad extends Frame implements ActionListener
{
	private static final long serialVersionUID = 9104075093913196293L;
	NumberButton numberButton[];
	OperationButton oprationButton[];
	Button С���㰴ť, �����Ű�ť, �˸�ť, ������ť, �ȺŰ�ť, ���㰴ť;
	Panel panel;
	JTextField resultShow;
	String �������[] = { "+", "-", "*", "/" };
	LinkedList ����;
	boolean �Ƿ��µȺ� = false;

	public ComputerPad() {
		super("������");
		���� = new LinkedList();
		numberButton = new NumberButton[10];
		for (int i = 0; i <= 9; i++) {
			numberButton[i] = new NumberButton(i);
			numberButton[i].addActionListener(this);
		}
		oprationButton = new OperationButton[4];
		for (int i = 0; i < 4; i++) {
			oprationButton[i] = new OperationButton(�������[i]);
			oprationButton[i].addActionListener(this);
		}
		С���㰴ť = new Button(".");
		�����Ű�ť = new Button("+/-");
		�ȺŰ�ť = new Button("=");
		������ť = new Button("1/x");
		�˸�ť = new Button("�˸�");
		���㰴ť = new Button("C");
		���㰴ť.setForeground(Color.red);
		�˸�ť.setForeground(Color.red);
		�ȺŰ�ť.setForeground(Color.red);
		������ť.setForeground(Color.blue);
		�����Ű�ť.setForeground(Color.blue);
		С���㰴ť.setForeground(Color.blue);
		�˸�ť.addActionListener(this);
		���㰴ť.addActionListener(this);
		�ȺŰ�ť.addActionListener(this);
		С���㰴ť.addActionListener(this);
		�����Ű�ť.addActionListener(this);
		������ť.addActionListener(this);
		resultShow = new JTextField(10);
		resultShow.setHorizontalAlignment(JTextField.RIGHT);
		resultShow.setForeground(Color.blue);
		resultShow.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		resultShow.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		resultShow.setBackground(Color.white);
		resultShow.setEditable(false);
		panel = new Panel();
		panel.setLayout(new GridLayout(4, 5));

		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(oprationButton[0]);
		panel.add(���㰴ť);

		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(oprationButton[1]);
		panel.add(�˸�ť);

		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(oprationButton[2]);
		panel.add(������ť);

		panel.add(numberButton[0]);
		panel.add(�����Ű�ť);
		panel.add(С���㰴ť);
		panel.add(oprationButton[3]);
		panel.add(�ȺŰ�ť);
		add(panel, BorderLayout.CENTER);
		add(resultShow, BorderLayout.NORTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(100, 50, 240, 180);
		setResizable(false);
		validate();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof NumberButton) {
			NumberButton b = (NumberButton) e.getSource();
			if (����.size() == 0) {
				int number = b.getNumber();
				����.add("" + number);
				resultShow.setText("" + number);
				�Ƿ��µȺ� = false;
			}

			else if (����.size() == 1 && �Ƿ��µȺ� == false) {
				int number = b.getNumber();
				String num = (String) ����.getFirst();
				String s = num.concat("" + number);
				����.set(0, s);
				resultShow.setText(s);
			} else if (����.size() == 1 && �Ƿ��µȺ� == true) {
				int number = b.getNumber();
				����.removeFirst();
				����.add("" + number);
				�Ƿ��µȺ� = false;
				resultShow.setText("" + number);
			} else if (����.size() == 2) {
				int number = b.getNumber();
				����.add("" + number);

				resultShow.setText("" + number);
			} else if (����.size() == 3) {
				int number = b.getNumber();
				String num = (String) ����.getLast();
				String s = num.concat("" + number);
				����.set(2, s);
				resultShow.setText(s);
			}
		} else if (e.getSource() instanceof OperationButton) {
			OperationButton b = (OperationButton) e.getSource();
			if (����.size() == 1) {
				String fuhao = b.get�������();

				����.add(fuhao);
			} else if (����.size() == 2) {
				String fuhao = b.get�������();
				����.set(1, fuhao);
			} else if (����.size() == 3) {
				String fuhao = b.get�������();
				String number1 = (String) ����.getFirst();
				String number2 = (String) ����.getLast();
				String ������� = (String) ����.get(1);
				try {
					double n1 = Double.parseDouble(number1);
					double n2 = Double.parseDouble(number2);
					double n = 0;
					if (�������.equals("+")) {
						n = n1 + n2;
					} else if (�������.equals("-")) {
						n = n1 - n2;
					} else if (�������.equals("*")) {
						n = n1 * n2;
					} else if (�������.equals("/")) {
						n = n1 / n2;
					}
					����.clear();
					����.add("" + n);
					����.add(fuhao);
					resultShow.setText("" + n);
				} catch (Exception ee) {
				}
			}
		} else if (e.getSource() == �ȺŰ�ť) {
			�Ƿ��µȺ� = true;
			if (����.size() == 1 || ����.size() == 2) {
				String num = (String) ����.getFirst();
				resultShow.setText("" + num);
			} else if (����.size() == 3) {
				String number1 = (String) ����.getFirst();
				String number2 = (String) ����.getLast();
				String ������� = (String) ����.get(1);
				try {
					double n1 = Double.parseDouble(number1);
					double n2 = Double.parseDouble(number2);
					double n = 0;
					if (�������.equals("+")) {
						n = n1 + n2;
					} else if (�������.equals("-")) {
						n = n1 - n2;
					} else if (�������.equals("*")) {
						n = n1 * n2;
					} else if (�������.equals("/")) {
						n = n1 / n2;
					}
					resultShow.setText("" + n);
					����.set(0, "" + n);
					����.removeLast();
					����.removeLast();

				} catch (Exception ee) {
				}
			}
		} else if (e.getSource() == С���㰴ť) {
			if (����.size() == 0) {
				�Ƿ��µȺ� = false;
			} else if (����.size() == 1) {
				String dot = С���㰴ť.getLabel();
				String num = (String) ����.getFirst();
				String s = null;
				if (num.indexOf(dot) == -1) {
					s = num.concat(dot);
					����.set(0, s);
				} else {
					s = num;
				}
				����.set(0, s);
				resultShow.setText(s);
			}

			else if (����.size() == 3) {
				String dot = С���㰴ť.getLabel();
				String num = (String) ����.getLast();
				String s = null;
				if (num.indexOf(dot) == -1) {
					s = num.concat(dot);
					����.set(2, s);
				} else {
					s = num;
				}
				resultShow.setText(s);
			}
		} else if (e.getSource() == �˸�ť) {
			if (����.size() == 1) {
				String num = (String) ����.getFirst();
				if (num.length() >= 1) {
					num = num.substring(0, num.length() - 1);
					����.set(0, num);
					resultShow.setText(num);
				} else {
					����.removeLast();
					resultShow.setText("0");
				}
			} else if (����.size() == 3) {
				String num = (String) ����.getLast();
				if (num.length() >= 1) {
					num = num.substring(0, num.length() - 1);
					����.set(2, num);
					resultShow.setText(num);
				} else {
					����.removeLast();
					resultShow.setText("0");
				}
			}
		} else if (e.getSource() == �����Ű�ť) {
			if (����.size() == 1) {
				String number1 = (String) ����.getFirst();
				try {
					double d = Double.parseDouble(number1);
					d = -1 * d;
					String str = String.valueOf(d);
					����.set(0, str);
					resultShow.setText(str);
				} catch (Exception ee) {
				}
			} else if (����.size() == 3) {
				String number2 = (String) ����.getLast();
				try {
					double d = Double.parseDouble(number2);
					d = -1 * d;
					String str = String.valueOf(d);
					����.set(2, str);
					resultShow.setText(str);
				} catch (Exception ee) {
				}
			}
		} else if (e.getSource() == ������ť) {
			if (����.size() == 1 || ����.size() == 2) {
				String number1 = (String) ����.getFirst();
				try {
					double d = Double.parseDouble(number1);
					d = 1.0 / d;
					String str = String.valueOf(d);
					����.set(0, str);
					resultShow.setText(str);
				} catch (Exception ee) {
				}
			} else if (����.size() == 3) {
				String number2 = (String) ����.getLast();
				try {
					double d = Double.parseDouble(number2);
					d = 1.0 / d;
					String str = String.valueOf(d);
					����.set(0, str);
					resultShow.setText(str);
				} catch (Exception ee) {
				}
			}
		} else if (e.getSource() == ���㰴ť) {
			�Ƿ��µȺ� = false;
			resultShow.setText("0");
			����.clear();
		}
	}

	public static void main(String args[]) {
		new ComputerPad();
	}
}
