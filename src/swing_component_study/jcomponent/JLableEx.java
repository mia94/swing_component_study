package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JLableEx extends JFrame {

	private JPanel contnentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLableEx frame = new JLableEx();
					frame.setVisible(true);
					
					//test
					String dir = System.getProperty("user.dir")+"\\images";
					System.out.println(dir);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JLableEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 583);
		contnentPane = new JPanel();
		contnentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contnentPane);
		contnentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel txt_label = new JLabel("사랑합니다.");
		contnentPane.add(txt_label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		String imagesPath = System.getProperty("user.dir")+"\\images\\";
		lblNewLabel_1.setIcon(new ImageIcon(imagesPath+"beauty.jpg"));
		contnentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("보고싶으면 카톡하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(imagesPath+"normalIcon.gif"));
		contnentPane.add(lblNewLabel);
	}

}
