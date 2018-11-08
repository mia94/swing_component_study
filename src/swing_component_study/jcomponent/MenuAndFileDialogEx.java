package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class MenuAndFileDialogEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmOpen;
	private JLabel lblImage;
	private JMenuItem mntmSave;
	private JMenuItem mntmFileOpen;
	private JPanel panel;
	private JSlider slider;


	/**
	 * Create the frame.
	 */
	public MenuAndFileDialogEx() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(this);
		mnNewMenu.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(this);
		mnNewMenu.add(mntmSave);
		
		mntmFileOpen = new JMenuItem("FileOpen");
		mntmFileOpen.addActionListener(this);
		mnNewMenu.add(mntmFileOpen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblImage = new JLabel("");
		contentPane.add(lblImage, BorderLayout.CENTER);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		panel.add(slider);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmFileOpen) {
			do_mntmRead_actionPerformed(e);
		}
		if (e.getSource() == mntmSave) {
			do_mntmSave_actionPerformed(e);
		}
		if (e.getSource() == mntmOpen) {
			do_mntmNewMenuItem_actionPerformed(e);
		}
	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		String currentDirectoryPath = System.getProperty("user.dir")+"\\images";
		
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg","gif");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		System.out.println("ret : "+ret);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		lblImage.setIcon(new ImageIcon(filePath));
	}
	protected void do_mntmSave_actionPerformed(ActionEvent e) {
		String currentDirectoryPath = System.getProperty("user.dir") + "\\backup";
		//파일로 만들기
		File backupDir = new File(currentDirectoryPath);
		if(!backupDir.exists()) {//백업파일이 존재하지 않는다면
			backupDir.mkdir();
		}
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		
		int ret = chooser.showSaveDialog(null);
		System.out.println("ret : "+ret);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		String fileName = chooser.getSelectedFile().getName();
		
		JOptionPane.showMessageDialog(null, filePath + ":" + fileName);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
			bw.write("김보민, 우선미, 황경수, 서동준, 김재영, 박수완, 이천희, 이준민");
			bw.flush();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "저장완료");
	}
	protected void do_mntmRead_actionPerformed(ActionEvent e) {
		String currentDirectoryPath = System.getProperty("user.dir") + "\\backup";
		JFileChooser chooser = new JFileChooser(currentDirectoryPath);
		
		int ret = chooser.showOpenDialog(null);
		System.out.println("ret : "+ret);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();

		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			lblImage.setText(line);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}














