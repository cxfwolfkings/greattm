package com.charles.soft.chap;
import java.awt.Button;
import java.awt.Color;

//Download by http://www.codefans.net
public class OperationButton extends Button {
	
	private static final long serialVersionUID = -770298999916295931L;
	String �������;

	public OperationButton(String s) {
		super(s);
		������� = s;
		setForeground(Color.red);
	}

	public String get�������() {
		return �������;
	}
}
