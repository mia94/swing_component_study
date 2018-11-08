package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class TebbedPanelEx extends JFrame {

	private JPanel contentPane;
	private String imgPath;

	/**
	 * Create the frame.
	 */
	public TebbedPanelEx() {
		imgPath = System.getProperty("user.dir")+"\\images\\";
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLabel lbltab1 = new JLabel(new ImageIcon(imgPath+"img2.jpg"));
		tabbedPane.addTab("tab1", null, lbltab1, "원더우먼");
		
		JLabel lbltab2 = new JLabel(new ImageIcon(imgPath+"img1.jpg"));
		tabbedPane.addTab("tab2", null, lbltab2, "슈퍼맨");
		
		JLabel lbltab3 = new JLabel(new ImageIcon(imgPath+"img.jpg"));
		tabbedPane.addTab("tab3", null, lbltab3, "튤립");
		
		TblPanel panel = new TblPanel();
		tabbedPane.addTab("tab4", null, panel, "테이블");
	}

}
