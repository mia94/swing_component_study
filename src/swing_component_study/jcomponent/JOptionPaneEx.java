package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

public class JOptionPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneEx frame = new JOptionPaneEx();
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
	public JOptionPaneEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ShowInputDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		btn1 = new JButton("Input");
		panel.add(btn1);
		
		JButton btn2 = new JButton("");
		panel.add(btn2);
		
		JButton btn3 = new JButton("New button");
		panel.add(btn3);
		btn1.addActionListener(this);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "ShowConfirmDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "ShowMessageDialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		button = new JButton("New button");
		panel_2.add(button);
		
		button_1 = new JButton("New button");
		panel_2.add(button_1);
		
		button_2 = new JButton("New button");
		panel_2.add(button_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			do_btn1_actionPerformed(e);
		}
	}
	protected void do_btn1_actionPerformed(ActionEvent e) {
		String[] selectionValues = {"가","나","다"};
		Object res = JOptionPane.showInputDialog(null, "showInputDialog", "showInputDialog", JOptionPane.INFORMATION_MESSAGE, null, selectionValues, selectionValues[0]);
		JOptionPane.showMessageDialog(null, res);
	}
}
