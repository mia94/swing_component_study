package swing_component_study.event;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EventListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListenerEx frame = new EventListenerEx();
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
	public EventListenerEx() {
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
		btn1.addActionListener(new MyActionListener());//btn1을 클릭하면 actionPerformed가 호출되도록
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("내부클래스");
		btn2.addActionListener(new MyActionInnerListener());
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("익명클래스");//익명은 1회성
		btn3.addActionListener(new ActionListener() {//annoymous자동완성으로 나오는 거 선택시 만들어짐
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, e.getActionCommand());
			}
		});
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("필드를 이용");
		btn4.addActionListener(fieldListener);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("부모클래스 이용");
		btn5.addActionListener(this);
		contentPane.add(btn5);
	}
	//필드를 이용
	ActionListener fieldListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
	};

	// 내부클래스
	class MyActionInnerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e.getActionCommand());

		}

	}

//독립클래스
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
		
		}
	
	}
//부모클래스 이용
	@Override
	public void actionPerformed(ActionEvent e) {//부모클래스이용시 생성
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}























