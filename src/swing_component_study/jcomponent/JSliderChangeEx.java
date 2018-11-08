package swing_component_study.jcomponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class JSliderChangeEx extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JSlider slider;
	private JSlider slider_R;
	private JSlider slider_G;
	private JSlider slider_B;
	private JLabel lblVaule;
	private JLabel lblColor;
	private int value_R;
	private int value_G;
	private int value_B;

	/**
	 * Create the frame.
	 */
	public JSliderChangeEx() {
		initComponents();
	}
	private void initComponents() {
		setTitle("JSliderChangeEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pBasicSlider = new JPanel();
		pBasicSlider.setBorder(new TitledBorder(null, "\uC2AC\uB77C\uC774\uB354 \uCEF4\uD3EC\uB10C\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pBasicSlider);
		
		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		pBasicSlider.add(slider);
		
		btnOk = new JButton("슬라이더값 확인");
		btnOk.addActionListener(this);
		pBasicSlider.add(btnOk);
		
		lblVaule = new JLabel("");
		pBasicSlider.add(lblVaule);
		
		JPanel pAdvenceSlider = new JPanel();
		pAdvenceSlider.setBorder(new TitledBorder(null, "\uC774\uBCA4\uD2B8\uB97C \uC801\uC6A9\uD55C \uC2AC\uB77C\uC774\uB354", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pAdvenceSlider);
		pAdvenceSlider.setLayout(new GridLayout(0, 1, 0, 0));
		//선언을 먼저하지 않으면 호출이 먼저 일어나버려서 null에러
		lblColor = new JLabel("");
		
		slider_R = new JSlider();
		slider_R.setValue(128);
		slider_R.addChangeListener(this);
		slider_R.setForeground(Color.RED);
		slider_R.setPaintLabels(true);
		slider_R.setPaintTicks(true);
		slider_R.setMinorTickSpacing(10);
		slider_R.setMajorTickSpacing(50);
		slider_R.setMaximum(255);
		pAdvenceSlider.add(slider_R);
		
		slider_G = new JSlider();
		slider_G.addChangeListener(this);
		slider_G.setForeground(Color.GREEN);
		slider_G.setPaintTicks(true);
		slider_G.setPaintLabels(true);
		slider_G.setMinorTickSpacing(10);
		slider_G.setMaximum(255);
		slider_G.setMajorTickSpacing(50);
		pAdvenceSlider.add(slider_G);
		
		slider_B = new JSlider();
		slider_B.addChangeListener(this);
		slider_B.setForeground(Color.BLUE);
		slider_B.setPaintLabels(true);
		slider_B.setPaintTicks(true);
		slider_B.setMajorTickSpacing(50);
		slider_B.setMinorTickSpacing(10);
		slider_B.setMaximum(255);
		pAdvenceSlider.add(slider_B);
		

		lblColor.setText("r:"+ value_R+"g: "+value_G+"b:"+value_B);
		lblColor.setOpaque(true);
		value_R = slider_R.getValue();
		value_G = slider_G.getValue();
		value_B = slider_B.getValue();
//		lblColor.setBackground(new Color(value_R,value_G,value_B));
		pAdvenceSlider.add(lblColor);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			do_btnOk_actionPerformed(e);
		}
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		int value = slider.getValue();
		JOptionPane.showMessageDialog(null, "슬라이더의 값은 " + value);
	}
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider_B) {
			do_slider_B_stateChanged(e);
		}
		if (e.getSource() == slider_G) {
			do_slider_G_stateChanged(e);
		}
		if (e.getSource() == slider_R) {
			do_slider_R_stateChanged(e);
		}
		if (e.getSource() == slider) {
			do_slider_stateChanged(e);
		}
		
	}
	protected void do_slider_stateChanged(ChangeEvent e) {
		int value = slider.getValue();
		lblVaule.setText(value + "");//setText에 숫자값이 들어가면 에러남
	}
	protected void do_slider_R_stateChanged(ChangeEvent e) {
		value_R = slider_R.getValue();
		lblColor.setBackground(new Color(value_R,value_G,value_B));
		lblColor.setText("r:"+ value_R+"g: "+value_G+"b:"+value_B);
	}
	protected void do_slider_G_stateChanged(ChangeEvent e) {
		value_G = slider_G.getValue();
		lblColor.setBackground(new Color(value_R,value_G,value_B));
		lblColor.setText("r:"+ value_R+"g: "+value_G+"b:"+value_B);
	}
	protected void do_slider_B_stateChanged(ChangeEvent e) {
		value_B = slider_B.getValue();
		lblColor.setBackground(new Color(value_R,value_G,value_B));
		lblColor.setText("r:"+ value_R+"g: "+value_G+"b:"+value_B);
	}
}
