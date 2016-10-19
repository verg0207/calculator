package com.hanxu.cal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.RescaleOp;

public class Calculator extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private boolean firstDigit=true;
	private String operator="=";
	private boolean operateValidFlag=true;
	private double resultNum=0.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 10, 246, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(23, 79, 93, 23);
		frame.getContentPane().add(btn7);
		btn7.addActionListener(this);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(126, 79, 93, 23);
		frame.getContentPane().add(btn8);
		btn8.addActionListener(this);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(229, 79, 93, 23);
		frame.getContentPane().add(btn9);
		btn9.addActionListener(this);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(23, 125, 93, 23);
		frame.getContentPane().add(btn4);
		btn4.addActionListener(this);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(126, 125, 93, 23);
		frame.getContentPane().add(btn5);
		btn5.addActionListener(this);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(229, 125, 93, 23);
		frame.getContentPane().add(btn6);
		btn6.addActionListener(this);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(23, 170, 93, 23);
		frame.getContentPane().add(btn1);
		btn1.addActionListener(this);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(126, 170, 93, 23);
		frame.getContentPane().add(btn2);
		btn2.addActionListener(this);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(229, 170, 93, 23);
		frame.getContentPane().add(btn3);
		btn3.addActionListener(this);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(23, 214, 93, 23);
		frame.getContentPane().add(btn0);
		btn0.addActionListener(this);
		
		JButton btndian = new JButton(".");
		btndian.setBounds(126, 214, 93, 23);
		frame.getContentPane().add(btndian);
		btndian.addActionListener(this);
		
		JButton btndengyu = new JButton("=");
		btndengyu.setBounds(229, 214, 93, 23);
		frame.getContentPane().add(btndengyu);
		btndengyu.addActionListener(this);
		
		
		
		JButton btnclear = new JButton("clear");
		btnclear.setBounds(302, 18, 74, 23);
		frame.getContentPane().add(btnclear);
		btnclear.addActionListener(this);
		
		JButton btndivid = new JButton("/");
		btndivid.setBounds(331, 79, 93, 23);
		frame.getContentPane().add(btndivid);
		btndivid.addActionListener(this);
		
		JButton btnmuti = new JButton("*");
		btnmuti.setBounds(331, 125, 93, 23);
		frame.getContentPane().add(btnmuti);
		btnmuti.addActionListener(this);
		
		JButton btnjian = new JButton("-");
		btnjian.setBounds(332, 170, 93, 23);
		frame.getContentPane().add(btnjian);
		btnjian.addActionListener(this);
		
		JButton btnjia = new JButton("+");
		btnjia.setBounds(331, 214, 93, 23);
		frame.getContentPane().add(btnjia);
		btnjia.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		String label=e.getActionCommand();
		if(label.equals("clear")) handleclear();
		else if("0123456789.".indexOf(label)>=0) handleNumber(label);
		else if("+-*/=".indexOf(label)>=0) handleOperator(label);
	}
	
	private void handleclear(){
		textField.setText("0");
		
		firstDigit=true;
		operator="=";
	}
	
	private void handleNumber (String key){
		if(firstDigit){
			textField.setText(key);
		}
		else if(key.equals(".")&&textField.getText().indexOf(".")<0) textField.setText(textField.getText()+".");
		else if(!key.equals(".")) textField.setText(textField.getText()+key);
	    firstDigit=false;
	}
	
	private void handleOperator(String key){
		if(operator.equals("/")){
			if(getNumber()==0.0){
				operateValidFlag=false;
				textField.setText("除数不能为0");
			}else{
				resultNum/=getNumber();
			}
		}
			else if(operator.equals("*")){
				resultNum*=getNumber();
			}
			else if(operator.equals("+")){
				resultNum+=getNumber();
			}
			else if(operator.equals("-")){
				resultNum-=getNumber();
			}
			else if(operator.equals("=")){
				resultNum=getNumber();
			}
			/*if(operateValidFlag){
				long t1;
				double t2;
				t1=(long)resultNum;
				t2=resultNum-t1;
				if(t2==0) textField.setText(String.valueOf(t1));
				else textField.setText(String.valueOf(resultNum));
				
			}*/
		
			operator=key;
			firstDigit=true;
			operateValidFlag=true;

		}
	
	
	private double getNumber(){
		double result=Double.valueOf(textField.getText()).doubleValue();
		return result;
	}
}
