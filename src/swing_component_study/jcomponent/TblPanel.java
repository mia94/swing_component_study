package swing_component_study.jcomponent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TblPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TblPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, "김보민", 90, 90, 90, 270, 90},
				{2, "우선미", 90, 90, 90, 270, 90},
				{3, "박수완", 90, 90, 90, 270, 90},
			},
			new String[] {
				"학번", "성명", "국어", "영어", "수학", "총점", "평균"
			}
		));
		scrollPane.setViewportView(table);
		//정렬
		setAlignWidth();
	}
	public void setAlignWidth() {
		//정렬
		tableCellAlignment(SwingConstants.CENTER,0,1);
		tableCellAlignment(SwingConstants.RIGHT,2,3,4,5,6);
		//폭
		tableSetWidth(100,200,100,100,100,150,150);
	}
	//정렬, 외우는 수밖에 없음
	private void tableCellAlignment(int align,int...idx) {//가변배열 사용
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();//셀을 랜더링하기위해 가져옴
		dtcr.setHorizontalAlignment(align);//상수값이 들어가야함
		
		System.out.println(Arrays.toString(idx));//[0,1],[2,3,4,5,6]
		
		TableColumnModel tcm = table.getColumnModel();//컬럼을 참조
		//tcm은 컬럼의 갯수를 알수있기에 반복문에 사용가능
		for(int i=0;i<idx.length;i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	//폭 조정
	
	private void tableSetWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0;i<width.length;i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

}






