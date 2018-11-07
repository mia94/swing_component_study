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
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JListAndJComboEx extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JList list_1;
	private ImageIcon[] icons;
	private JTextField tfName;
	private JList<String> listName;
	private List<String> listArrayListNames;
	
	private String imgPath = System.getProperty("user.dir") + "\\images\\fruits\\";
	private ImageIcon [] fruitImg = {
			new ImageIcon(imgPath + "apple.jpg"),
			new ImageIcon(imgPath + "banana.jpg"),
			new ImageIcon(imgPath + "cherry.jpg"),
			new ImageIcon(imgPath + "kiwi.jpg"),
			new ImageIcon(imgPath + "mango.jpg"),
			new ImageIcon(imgPath + "pear.jpg")
			};
	private JComboBox<String> cmb3;
	private JLabel lblImg;

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
		listArrayListNames = new ArrayList<>();
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
		System.out.println(lblNewLabel);
		pInput.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
//				String name = listJListName.getselectedValue;
				JOptionPane.showMessageDialog(null, "선택된 이름:"+"선택한 인덱스");
			}
			
		});
		
		tfName = new JTextField();
		tfName.addActionListener(this);
		pInput.add(tfName);
		tfName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		listName = new JList();
		scrollPane.setViewportView(listName);
		
		JPanel pJCombo = new JPanel();
		pJCombo.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJCombo);
		pJCombo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel subPjcombo1 = new JPanel();
		pJCombo.add(subPjcombo1);
		
		String[] strArr1 = {"apple","banana","charry"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(strArr1);
		
		JComboBox<String> cmb1 = new JComboBox<>(model);
		subPjcombo1.add(cmb1);
		//데이터 입력
		String[] strArr2 = {"김보민","우선미","황경수","이준민"};
		JComboBox<String> cmb2 = new JComboBox<>();

		for(int i=0;i<strArr2.length;i++) {
			cmb2.addItem(strArr2[i]);
		}
		cmb2.setSelectedIndex(-1);//인덱스가 -1인것 가져오기, 데이터가 들어가고나서 리스너 이전에 호출
		//리스너 달기
		cmb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택된 것 가져오기
				String name = (String)cmb2.getSelectedItem();//
				int index = cmb2.getSelectedIndex();//선택된 인덱스를 돌려줌
				JOptionPane.showMessageDialog(null,index+"번째 선택된 이름"+ name);
			}
		});
		

		
		subPjcombo1.add(cmb2);
		
		//-----------------------------과일 콤보
		
		JPanel subPjcombo2 = new JPanel();
		pJCombo.add(subPjcombo2);
		subPjcombo2.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel panel_1 = new JPanel();
		subPjcombo2.add(panel_1);
		//과일 배열
		String[] strArr3 = {"apple","banana","charry","kiwi","mango","pear"};
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(strArr3);
		
		cmb3 = new JComboBox<>(model2);
		cmb3.addItemListener(this);
		panel_1.add(cmb3);
		
		
		//----------------------------------------이미지 추가
		
		lblImg = new JLabel("");
		lblImg.setIcon(null);
		subPjcombo2.add(lblImg);
		//인덱스 가져와서 해당 이미지 매치??
		int index = cmb3.getSelectedIndex();
		
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfName) {
			do_tfName_actionPerformed(e);
		}
	}
	//엔터치면 내용 추가
	protected void do_tfName_actionPerformed(ActionEvent e) {
		//listNames.add tfName에 있는 값을 List<String>에 추가
		System.out.println(listArrayListNames);
		listArrayListNames.add(tfName.getText().trim());
		listName.setListData(new Vector<>(listArrayListNames));
		tfName.setText("");
		tfName.requestFocus();
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmb3) {
			do_cmb3_itemStateChanged(e);
		}
	}
	//아이템 리스너 달기
	protected void do_cmb3_itemStateChanged(ItemEvent e) {
		int index = cmb3.getSelectedIndex();
		lblImg.setIcon(fruitImg[index]);
	}
}
