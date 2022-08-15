package Views;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dBill;
import Model.mBill;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class BillManager extends JPanel {
	private JTable table;
	DefaultTableModel dataModel = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public BillManager() {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDanhSchHa = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblDanhSchHa.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addGap(212))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(313)
					.addComponent(lblDanhSchHa, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addGap(169))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDanhSchHa, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
					.addGap(149))
		);
		
		String[] headers = {"ID", "Số phòng","Ngày đến","Ngày đi","trạng thái","Tổng"};
		dataModel = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table = new JTable(dataModel));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		GetBill();
	}
	public void GetBill() {
		dBill bill = new dBill();
		ArrayList<mBill> arrBill = bill.GetAllBill();
		for(mBill s : arrBill) {
			dataModel.addRow(new Object[] {s.getId(), s.getRoomNumber(), s.getTimeFrom(), s.getTimeTo(), s.getStatus(),s.getTotalMoney()});
		}
	}
}
