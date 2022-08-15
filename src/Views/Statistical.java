package Views;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Dao.dBill;
import Dao.dCustomer;
import Dao.dListServiceUse;
import Dao.dRoom;
import Dao.dService;
import Model.mBill;
import Model.mCustomer;
import Model.mListServiceUse;
import Model.mRoom;
import Model.mService;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class Statistical extends JPanel {
	/**
	 *@author My Love
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSum, lblSumByRent, lblSumCustomerRent, lblSumCustomeOld;
	private JTable table1, table2;
	private JDateChooser dateFrom, dateTo;
	DefaultTableModel dataModel1 = new DefaultTableModel();
	DefaultTableModel dataModel2 = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public Statistical() {

		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		String[] headers = { "Mã hóa đơn", "Phòng", "Ngày đến", "Ngày đi", "Tổng tiền" };
		dataModel1 = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table1 = new JTable(dataModel1));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		String[] header = { "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Tổng tiền"  };
		dataModel2 = new DefaultTableModel(header, 0);
		scrollPane_1.setViewportView(table2 = new JTable(dataModel2));

		JLabel lblSumRoom = new JLabel("Tổng số phòng hiện có:");

		lblSum = new JLabel("");

		JLabel lblSumRoomByRent = new JLabel("Số phòng đang thuê:");

		lblSumByRent = new JLabel("");

		JLabel lblSumCustomer = new JLabel("Số khách đang thuê:");

		lblSumCustomerRent = new JLabel("");

		lblSumCustomeOld = new JLabel("");

		JLabel lblSumCustomerOld = new JLabel("Số khách đã thuê:");

		JLabel lblTitle1 = new JLabel("Thống kê theo hóa đơn");

		JLabel lblTitle2 = new JLabel("Thống kê theo dịch vụ");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addComponent(lblSumRoom, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSum, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(lblSumRoomByRent, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSumByRent, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSumCustomer, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSumCustomerRent, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSumCustomerOld, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSumCustomeOld, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(98, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(panel, GroupLayout.DEFAULT_SIZE,
						908, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 446,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblTitle1, GroupLayout.PREFERRED_SIZE, 379,
														GroupLayout.PREFERRED_SIZE)
												.addGap(73)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblTitle2, GroupLayout.PREFERRED_SIZE, 379,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(68, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING,
												groupLayout
														.createSequentialGroup().addComponent(scrollPane_1,
																GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
														.addGap(1)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE).addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitle1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitle2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 237,
										GroupLayout.PREFERRED_SIZE))
						.addGap(133)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSumCustomer, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSumRoomByRent, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSumCustomeOld, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSumRoom, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSum, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSumByRent, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSumCustomerRent, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSumCustomerOld, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))));

		 dateFrom = new JDateChooser();
		 dateFrom.setDateFormatString("yyyy-MM-dd");
		dateFrom.setBounds(522, 10, 129, 19);

		 dateTo = new JDateChooser();
		 dateTo.setDateFormatString("yyyy-MM-dd");
		dateTo.setBounds(714, 10, 129, 19);

		JLabel lblFrom = new JLabel("Đến");
		lblFrom.setBounds(553, 10, 41, 18);
		lblFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JButton btnStatis = new JButton("Thống kê");
		btnStatis.setBorder(UIManager.getBorder("RadioButton.border"));
		btnStatis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel1.setRowCount(0);
				dataModel2.setRowCount(0);
				StatisticalByBill();
				StatisticalByService();
			}
		});
		btnStatis.setBounds(639, 39, 94, 21);
		panel.setLayout(null);
		panel.add(dateFrom);
		panel.add(lblFrom);
		panel.add(dateTo);
		panel.add(btnStatis);
		setLayout(groupLayout);

		CountRoom();
		CountRoomRent();
		CountCustomerRent();
		CountCustomerRentOld();
	}

	public void CountRoom() {
		dRoom room = new dRoom();
		ArrayList<mRoom> arrRoom = room.GetAllRoom();
		lblSum.setText(String.valueOf(arrRoom.size()) + " phòng");
	}

	public void CountRoomRent() {
		dRoom room = new dRoom();
		ArrayList<mRoom> arrRoom = room.GetAllRoomByStatus("Đang thuê");
		lblSumByRent.setText(String.valueOf(arrRoom.size()) + " phòng");
	}

	public void CountCustomerRent() {
		dCustomer cus = new dCustomer();
		ArrayList<mCustomer> arrCus = cus.FindCusByStatus("Đang thuê");
		lblSumCustomerRent.setText(String.valueOf(arrCus.size()));
	}

	public void CountCustomerRentOld() {
		dCustomer cus = new dCustomer();
		ArrayList<mCustomer> arrCus = cus.FindCusByStatus("Đã thanh toán");
		lblSumCustomeOld.setText(String.valueOf(arrCus.size()));
	}
	public void StatisticalByBill() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:a");
		String s1 = String.format("%1$tY-%1$tm-%1$td", dateFrom.getDate());
	    String s2 = String.format("%1$tY-%1$tm-%1$td", dateTo.getDate()); 
		dBill bill = new dBill();
		ArrayList<mBill> arrBill = bill.GetAllBill(s1, s2);
		for(mBill s : arrBill) {
			dataModel1.addRow(new Object[] {s.getId(), s.getRoomNumber(), df.format(s.getTimeFrom()), df.format(s.getTimeTo()), s.getTotalMoney()});
		}
	}
	public void StatisticalByService() {
		dService ser = new dService();
		dListServiceUse serUse = new dListServiceUse();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:a");
		String s1 = String.format("%1$tY-%1$tm-%1$td", dateFrom.getDate());
	    String s2 = String.format("%1$tY-%1$tm-%1$td", dateTo.getDate()); 
		ArrayList<mService> arrList = ser.GetChiTietMonByMa();
		if(arrList.size()>0) {
			int quanTum1 = 0;
			int price = 0;
			for(mService s :arrList) {
				ArrayList<mListServiceUse> arrLisstUse = serUse.GetListService(s1, s2, s.getId());
				if(arrLisstUse.size()>0) {
					int quanTum2 = 0;
					for(mListServiceUse i : arrLisstUse) {
						quanTum2 += i.getQuantum();
						price = i.getPrice()*quanTum2;					
					}
					dataModel2.addRow(new Object [] {arrLisstUse.get(0).getServiceId(), arrLisstUse.get(0).getServiceName(), quanTum2, price});
				}
			}
		}
	}
}
