package swing_component_study.event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class EventListenerWindowBuilder extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn5;//필드로 뺌(ctrl+1)
	private JButton btn6;
	private JButton btn7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListenerWindowBuilder frame = new EventListenerWindowBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventListenerWindowBuilder() {//따로 나눠짐 code generation init설정때문
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton btn1 = new JButton("독립클래스");
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("내부클래스");
		btn2.addActionListener(new Btn2ActionListener());
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("익명클래스");
		//익명클래스
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}
		});
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("필드");
		btn4.addActionListener(new Btn4ActionListener());
		contentPane.add(btn4);
		
		btn5 = new JButton("부모");
		btn5.addActionListener(this);//impl하고 action하니까 생겼음
		contentPane.add(btn5);
		
		btn6 = new JButton("부모2");
		btn6.addActionListener(this);//5번이랑 구분X
		contentPane.add(btn6);
		
		btn7 = new JButton("부모3");
		btn7.addActionListener(this);
		contentPane.add(btn7);
		//마우스리스너 달기
		JButton btn8 = new JButton("어뎁터1");
		btn8.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "mousePressed");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("어뎁터2");
		btn9.addMouseListener(new MouseAdapter() {
		//alt+shift+s : override implment 이용해서 pressed만 선택
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "mousePressed2");
			}
			
		});
		contentPane.add(btn9);
	}
	
	//내부클래스
	private class Btn2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
	}
	//필드
	private class Btn4ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
	}
	//같은 메소드 구분하기
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn7) {
			do_btn7_actionPerformed(e);
		}
		if(e.getSource() == btn5) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
		if(e.getSource() == btn6) {//부모3에 action perfomed 했을때 알아서 구분됨
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
	}
	//부모3에 action perfomed 했을때 알아서 구분됨
	protected void do_btn7_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}







