package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ItemEvent;

public class CheckBoxItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private int sum;
	private JLabel sumLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
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
	public CheckBoxItemEventEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("사과 100원, 배500원,체리20000원");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		chckbxNewCheckBox = new JCheckBox("사과");
		chckbxNewCheckBox.addItemListener(this);//생성된 메소드
		panel.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("배");
		chckbxNewCheckBox_1.addItemListener(this);
		panel.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("체리");
		chckbxNewCheckBox_2.addItemListener(this);
		panel.add(chckbxNewCheckBox_2);
		
		
		sumLabel = new JLabel("현재 0원 입니다.");//생성중복안되도록 주의하기!
		sumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(sumLabel);
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == chckbxNewCheckBox_2) {
			do_chckbxNewCheckBox_2_itemStateChanged(e);
		}
		if (e.getSource() == chckbxNewCheckBox_1) {
			do_chckbxNewCheckBox_1_itemStateChanged(e);
		}
		if (e.getSource() == chckbxNewCheckBox) {
			do_chckbxNewCheckBox_itemStateChanged(e);
		}
//		sumLabel.setText("현재"+sum+"원 입니다.");
	}
	//자동 생성된 메소드
	protected void do_chckbxNewCheckBox_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 100;
		}else {
			sum -= 100;
		}
		sumLabel.setText("현재"+sum+"원 입니다.");
	}
	protected void do_chckbxNewCheckBox_1_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 500;
		}else {
			sum -= 500;
		}
		sumLabel.setText("현재"+sum+"원 입니다.");
	}
	protected void do_chckbxNewCheckBox_2_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 20000;
		}else {
			sum -= 20000;
		}
		sumLabel.setText("현재"+sum+"원 입니다.");
	}
}

















