package swing_component_study;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JButton btnClose;//필드로 빠짐
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);//this는 actionListener을 이야기함
		contentPane.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);//로컬인상태에서 액션
		contentPane.add(btnCancel);
		
		btnClose = new JButton("Close");
		contentPane.add(btnClose);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		
		if (e.getSource() == btnCancel) {//어떤버튼을 눌렀는지 구분하는 역할
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());//ActionCommand()==toString비슷,ActionCommand()도 문자열임
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}
