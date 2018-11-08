package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JComponentMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentMain frame = new JComponentMain();
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
	public JComponentMain() {
		initComponents();
	}
	private void initComponents() {
		setTitle("모든 JComponent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));
		
		btn1 = new JButton("CheckBoxItemEventEx");
		btn1.addActionListener(this);
		contentPane.add(btn1);
		
		btn2 = new JButton("JComponentEx");
		btn2.addActionListener(this);
		contentPane.add(btn2);
		
		btn3 = new JButton("JLabel");
		btn3.addActionListener(this);
		contentPane.add(btn3);
		
		btn4 = new JButton("JButton");
		btn4.addActionListener(this);
		contentPane.add(btn4);
		
		btn5 = new JButton("JListAndJComboEx");
		btn5.addActionListener(this);
		contentPane.add(btn5);
		
		btn6 = new JButton("JTextFieldOtherEx");
		btn6.addActionListener(this);
		contentPane.add(btn6);
		
		btn7 = new JButton("RadioBtnItemEventEx");
		btn7.addActionListener(this);
		contentPane.add(btn7);
		
		btn8 = new JButton("JSilderEx");
		btn8.addActionListener(this);
		contentPane.add(btn8);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn8) {
			do_btn8_actionPerformed(e);
		}
		if (e.getSource() == btn7) {
			do_btn7_actionPerformed(e);
		}
		if (e.getSource() == btn6) {
			try {
				showFrame(new JTextFieldOtherEx());
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "error");
			}
		}
		if (e.getSource() == btn5) {
			do_btn5_actionPerformed(e);
		}
		if (e.getSource() == btn4) {
			do_btn4_actionPerformed(e);
		}
		if (e.getSource() == btn3) {
			do_btn3_actionPerformed(e);
		}
		if (e.getSource() == btn2) {
			do_btn2_actionPerformed(e);
		}
		if (e.getSource() == btn1) {
			do_btn1_actionPerformed(e);
		}
	}
	//actionPerformed
	protected void do_btn1_actionPerformed(ActionEvent e) {
		showFrame(new CheckBoxItemEventEx());
	}
	protected void do_btn2_actionPerformed(ActionEvent e) {
		showFrame(new JComponentEx());
	}
	protected void do_btn3_actionPerformed(ActionEvent e) {
		showFrame(new JLableEx());
	}
	protected void do_btn4_actionPerformed(ActionEvent e) {
		showFrame(new JButtonEx());
	}
	protected void do_btn5_actionPerformed(ActionEvent e) {
		showFrame(new JListAndJComboEx());
	}
	protected void do_btn6_actionPerformed(ActionEvent e) throws ParseException {
		//예외처리
	}
	protected void do_btn7_actionPerformed(ActionEvent e) {
		showFrame(new RadioBtnItemEventEx());
	}
	protected void do_btn8_actionPerformed(ActionEvent e) {
		showFrame(new JSliderChangeEx());
	}
	//화면을 띄어주는 메소드 생성
	private void showFrame(JFrame frame) {
		frame.setVisible(true);
	}
	
}
