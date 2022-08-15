package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Dao.dCustomer;
import Dao.dRoom;
import Model.mCustomer;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomerManager extends JPanel {
	private JTable table;
	DefaultTableModel dataModel = new DefaultTableModel();
	dCustomer cus = new dCustomer(); 
	private JComboBox cmbCustomer;
	public static CustomerManager p;
	private JTextField txtTenKhachHang;
	private JTextField txtCMND;
	/**
	 * Create the panel.
	 */
	public CustomerManager() {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.BLACK));
		p = this;
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});
		
		JButton btnDelete = new JButton("Xóa");
		
		JLabel lblChoose = new JLabel("Chọn");
		
		 cmbCustomer = new JComboBox();
		cmbCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataModel.setRowCount(0);
				if(cmbCustomer.getSelectedItem().toString().equals("Tất cả")) {
					GetAll();
				}else {
				GetAllCustomerByStatus(cmbCustomer.getSelectedItem().toString());
				}
			}
		});
		cmbCustomer.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Đang thuê", "Đặt phòng", "Đã thanh toán", "Hủy phòng"}));
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataModel.setRowCount(0);
				if(txtTenKhachHang.getText().equals("")) {
					GetAll();
				}else {
					Tim(txtTenKhachHang.getText());
				}
			}
		});
		txtTenKhachHang.setColumns(10);
		
		JLabel lblTimKhachhang = new JLabel("Nhập vào tên khách hàng cần tìm");
		lblTimKhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		txtCMND = new JTextField(); 
		txtCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataModel.setRowCount(0);
				if(txtCMND.getText().equals("")) {
					GetAll();
				}else {
					Tim1(Integer.parseInt(txtCMND.getText()));
				}
			}
		});
		txtCMND.setColumns(10);
		
		JLabel lblTimCMND = new JLabel("Nhập vào CMND or SDT cần tìm");
		lblTimCMND.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ KHÁCH HÀNG ");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAdd)
								.addComponent(btnDelete)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblChoose, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmbCustomer, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTimKhachhang, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblTimCMND, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(30)))
					.addGap(7))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(266)
					.addComponent(lblTieuDe, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(cmbCustomer, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblChoose))
									.addGap(18)
									.addComponent(lblTimKhachhang, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(1)
											.addComponent(lblTimCMND, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTenKhachHang, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdd)
									.addGap(18)
									.addComponent(btnDelete))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTieuDe, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		
		String[] headers = {"Họ và tên", "Giới tính","Ngày sinh","Số CMND","Số điện thoại","Email", "Trạng thái", "Số phòng","Ngày đến","Ngày đi"};
		dataModel = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table = new JTable(dataModel));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
	public void GetAllCustomerByStatus(String Status) {
		ArrayList<mCustomer> arrCus = cus.FindCusByStatus(Status);
		for(mCustomer s : arrCus) {
			
			dataModel.addRow(new Object[] {s.getFullName(), s.getGrender(), s.getBirthDay(), s.getPassPort(), s.getPhone()
					,s.getEmail(),s.getStatus(),s.getRoomNumber(),s.getDateTimeFrom(),s.getDateTimeTo()});
		}
	}
	public void GetAll() {
		ArrayList<mCustomer> arrCus = cus.GetAll();
		
		for(mCustomer s : arrCus) {
		
			dataModel.addRow(new Object[] {s.getFullName(), s.getGrender(), s.getBirthDay(), s.getPassPort(), s.getPhone()
					,s.getEmail(),s.getStatus(),s.getRoomNumber(),s.getDateTimeFrom(),s.getDateTimeTo()});
		}
	}
	public void addCustomer() {
		int row = table.getSelectedRow();
		dCustomer dao = new dCustomer();
		dRoom daoP = new dRoom();

		if (cmbCustomer.getSelectedItem().equals("Đang thuê")) {
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn trong bảng");
			} else {
				String Room = (String) dataModel.getValueAt(row, 7);
				Timestamp NgayDen = (Timestamp) dataModel.getValueAt(row, 8);
				Timestamp NgayDi = (Timestamp) dataModel.getValueAt(row, 9);
				ArrayList<mCustomer> arrPhong = dao.GetAllCustomerByRoom(Room);
				int b = arrPhong.size();
				int a = daoP.GetSoNguoi(Room);
				int Price = daoP.GetRoomPrice(Room);
				if (b >= a) {
					JOptionPane.showMessageDialog(null, "Phòng quá số người cho phép");

				} else {
					new AddCustomer(NgayDen, NgayDi,Room ,Price).setVisible(true);

				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Chỉ khách hàng đang thuê mới thêm khách vào phòng phòng");
		}
	}
	public void Tim(String name) {
		ArrayList<mCustomer> arrCus = cus.GetCustomer(name);
		for(mCustomer s : arrCus) {
			
			dataModel.addRow(new Object[] {s.getFullName(), s.getGrender(), s.getBirthDay(), s.getPassPort(), s.getPhone()
					,s.getEmail(),s.getStatus(),s.getRoomNumber(),s.getDateTimeFrom(),s.getDateTimeTo()});
		}
	}
	public void Tim1(int pasphone) {
		ArrayList<mCustomer> arrCus = cus.GetCustomers(pasphone);
		for(mCustomer s : arrCus) {
			
			dataModel.addRow(new Object[] {s.getFullName(), s.getGrender(), s.getBirthDay(), s.getPassPort(), s.getPhone()
					,s.getEmail(),s.getStatus(),s.getRoomNumber(),s.getDateTimeFrom(),s.getDateTimeTo()});
		}
	}
}
