package swing_component_study.jcomponent;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JTextFieldOtherEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JButton btnOk;
	private JPasswordField tfPwd;
	private JPasswordField tfPwd2;
	private JLabel lblConfirm;//필드로 변환
	private JFormattedTextField tfDate;
	private JTextArea textArea;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldOtherEx frame = new JTextFieldOtherEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public JTextFieldOtherEx() throws ParseException {
		initComponents();
	}
	private void initComponents() throws ParseException {
		setTitle("field");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel pContent = new JPanel();
		pContent.setBorder(new TitledBorder(null, "Textfield \uC0AC\uC6A9\uC608", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pContent);
		pContent.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblId = new JLabel("ID:");
		pContent.add(lblId);
		
		tfId = new JTextField();
		pContent.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblpwd = new JLabel("PASSWORD:");
		pContent.add(lblpwd);
		
		tfPwd = new JPasswordField();
		pContent.add(tfPwd);
		
		JLabel lblDate = new JLabel("PASSWORD 확인:");
		pContent.add(lblDate);
		
		tfPwd2 = new JPasswordField();
		pContent.add(tfPwd2);
		
		JPanel pBlank = new JPanel();
		pContent.add(pBlank);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.RED);
		pContent.add(lblConfirm);
		
		JLabel lblDate_1 = new JLabel("DATE:");
		pContent.add(lblDate_1);
		
		MaskFormatter mf = new MaskFormatter("####-##-##");
		mf.setPlaceholderCharacter('_');//언더바로 표시지정
		tfDate = new JFormattedTextField(mf);
		tfDate.setValue(LocalDate.now());
		pContent.add(tfDate);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pContent.add(btnOk);
		
		btnCancel = new JButton("초기화");
		btnCancel.addActionListener(this);
		pContent.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		try {//예외가 발생하지 않을 경우 수행하는 메소드 입력
			validCheck();
			String pwd1 = new String(tfPwd.getPassword());
			String pwd2 = new String(tfPwd2.getPassword());
			//패스워드 같은지 확인
			if(pwd1.equals(pwd2)) {
				lblConfirm.setText("일치");
			}else {
				lblConfirm.setText("불일치");
			}
			//아이디입력값 먼저 가져오기
			//데이트 가져옴
			String date = tfDate.getText();
			String message = String.format(
					"id = %s%n"
					+ "passwd1 = %s%n"
					+ "passwd1 = %s%n"
					+ "date = %s%n", tfId.getText().trim(),pwd1,pwd2,date);
//			JOptionPane.showMessageDialog(null, message);
			textArea.append(message);
			tfId.requestFocus();//전체선택이 됨
			tfId.selectAll();
	/*		tfPwd.requestFocus();
			tfPwd.selectAll();
			tfPwd2.requestFocus();
			tfPwd2.selectAll(); 모두입력시 마지막게 선택됨*/
			textArea.setCaretPosition(textArea.getDocument().getLength());
			//setCaretPosition : 아래에 추가되도록 함
		} catch (Exception e1) {//예외가 발생할 경우 실행하는 메소드 작성
			JOptionPane.showMessageDialog(null, e1.getMessage());
			this.requestFocus();
		}
		
		
	}
	//초기화
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		tfId.setText("");
		tfPwd.setText("");
		tfPwd2.setText("");
//		lblConfirm.setText("");
		tfDate.setValue(LocalDate.now());
		tfId.requestFocus();
//		textArea.setText("");
	}
	
	private void validCheck() throws Exception {//이 메소드가 호출된 곳으로 책임전가
		if(tfId.getText().equals("")) {
			throw new Exception("ID기 비어있음");
/*			JOptionPane.showMessageDialog(null, "아이디 비어있음");
			tfId.requestFocus();*/
		}
		String pwd1 = new String(tfPwd.getPassword());
		String pwd2 = new String(tfPwd2.getPassword());
		if(pwd1.equals("")) {
			throw new Exception("password가 비어있음");
/*			JOptionPane.showMessageDialog(null, "password 비어있음");
			tfPwd.requestFocus();*/
		}
		if(pwd2.equals("")) {
			throw new Exception("password2가 비어있음");
/*			JOptionPane.showMessageDialog(null, "password2 비어있음");
			tfPwd2.requestFocus();*/
		}
	}
}












