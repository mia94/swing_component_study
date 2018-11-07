package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")//노란줄 없애기
public class RadioBtnItemEventEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn3;
	
	String imgPath = System.getProperty("user.dir") + "\\images\\fruits\\";
	
	private String [] text = {"사과","배","체리"};
	private ImageIcon [] image = {
			new ImageIcon(imgPath + "apple.jpg"),
			new ImageIcon(imgPath + "pear.jpg"),
			new ImageIcon(imgPath + "cherry.jpg")};
	private JLabel imageLabel = new JLabel();

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioBtnItemEventEx frame = new RadioBtnItemEventEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RadioBtnItemEventEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		rdbtn1 = new JRadioButton("사과");
		
		rdbtn1.addItemListener(this);
		rdbtn1.setSelected(true);
		buttonGroup.add(rdbtn1);
		panel.add(rdbtn1);
		
		rdbtn2 = new JRadioButton("배");
		rdbtn2.addItemListener(this);
		buttonGroup.add(rdbtn2);
		panel.add(rdbtn2);
		
		rdbtn3 = new JRadioButton("체리");
		rdbtn3.addItemListener(this);
		buttonGroup.add(rdbtn3);
		panel.add(rdbtn3);
		
//		JLabel lblNewLabel = new JLabel("");
//		imageLabel.setIcon(image[0]);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(imageLabel, BorderLayout.CENTER);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtn3) {
			do_rdbtn3_itemStateChanged(e);
		}
		if (e.getSource() == rdbtn1) {
			do_rdbtn1_itemStateChanged(e);
		}
		if (e.getSource() == rdbtn2) {
			do_rdbtn2_itemStateChanged(e);
		}
	}
	protected void do_rdbtn2_itemStateChanged(ItemEvent e) {
		imageLabel.setIcon(image[1]);
	}
	protected void do_rdbtn1_itemStateChanged(ItemEvent e) {
		imageLabel.setIcon(image[0]);
	}
	protected void do_rdbtn3_itemStateChanged(ItemEvent e) {
		imageLabel.setIcon(image[2]);
	}
}
