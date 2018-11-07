package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class JListAndJComboEx extends JFrame {

	private JPanel contentPane;
	private JList list_1;
	private ImageIcon[] icons;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListAndJComboEx frame = new JListAndJComboEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public JListAndJComboEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("JListAndJComboEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel pJList = new JPanel();
		pJList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJList);
		pJList.setLayout(new GridLayout(0, 3, 10, 0));
		// 과일
		JList<String> list = new JList<>(/*fruits*/);//<>안에 제네릭(타입)선언
		list.setListData(getStringData());
		pJList.add(list);

		list_1 = new JList();
		list_1.setListData(getImgIcons());
		pJList.add(list_1);
		
		JPanel panel = new JPanel();
		pJList.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pInput = new JPanel();
		panel.add(pInput, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("이름입력 후 <Enter>키");
		pInput.add(lblNewLabel);
		
		tfName = new JTextField();
		pInput.add(tfName);
		tfName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JList listName = new JList();
		scrollPane.setViewportView(listName);
		
		JPanel pJCombo = new JPanel();
		pJCombo.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJCombo);
	}

	private Object[] getImgIcons() {
		String imgPath = System.getProperty("user.dir")+"\\images\\";
		icons = new ImageIcon[] {
				new ImageIcon(imgPath + "icon1.png"),
				new ImageIcon(imgPath + "icon2.png"),
				new ImageIcon(imgPath + "icon3.png"),
				new ImageIcon(imgPath + "icon4.png"),
		};
		return icons;
	}

	private String[] getStringData() {
		return new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	}

}
