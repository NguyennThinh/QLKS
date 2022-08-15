package Views;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dEmployee;
import Model.mEmployee;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class EmployeeManager extends JPanel {
	DefaultTableModel dataModel = new DefaultTableModel();
	private JTable table;
	public static EmployeeManager p;
	private JTextField txtTimNhanVien;
	int cmnd;
	String name;
	String chucvu;

	/**
	 * Create the panel.
	 */
	public EmployeeManager() {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		p = this;
		JScrollPane scrollPane = new JScrollPane();

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee eem =new AddEmployee();
				eem.setLocationRelativeTo(null);
				eem.setVisible(true);
			
			}
		});

		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});

		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});

		txtTimNhanVien = new JTextField();
		txtTimNhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataModel.setRowCount(0);
				if (txtTimNhanVien.getText().equals("")) {
						ShowEmployee();
				}else {
				Tim(txtTimNhanVien.getText());
				}
			}
		});
		txtTimNhanVien.setColumns(10);

		JLabel lblTimNhanVien = new JLabel("Nhập vào tên nhân viên cần tìm");
		lblTimNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		JButton btnDangKy = new JButton("Thêm tài khoản");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccount ac = new AddAccount(name, cmnd, chucvu);
				ac.setLocationRelativeTo(null);
				ac.setVisible(true);
			}
		});
		
		JLabel lblQunLNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQunLNhn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JButton btnThemCV = new JButton("Thêm chức vụ");
		btnThemCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPosition po = new AddPosition();
				po.setLocationRelativeTo(null);
				po.setVisible(true);
			}
		});
		
		JButton btnXoaCV = new JButton("Xoá chức vụ");
		btnXoaCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePosition dp = new DeletePosition();
				dp.setLocationRelativeTo(null);
				dp.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(355)
					.addComponent(lblQunLNhn, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
					.addGap(138))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTimNhanVien, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtTimNhanVien, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 349, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnDangKy, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAdd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdate, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnThemCV, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnXoaCV, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addGap(41))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQunLNhn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(btnAdd)
							.addGap(27)
							.addComponent(btnDelete)
							.addGap(28)
							.addComponent(btnUpdate)
							.addGap(30)
							.addComponent(btnDangKy)
							.addGap(26)
							.addComponent(btnThemCV)
							.addGap(18)
							.addComponent(btnXoaCV))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(lblTimNhanVien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtTimNhanVien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		String[] headers = { "STT", "Họ và tên", "Giới tính", "Ngày sinh", "Quê quán", "Số CMND", "Số điện thoại",
				"Email", "Chức vụ" };
		dataModel = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table = new JTable(dataModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				cmnd = (int) table.getValueAt(row, 5);
				name = (String) table.getValueAt(row, 1);
				chucvu = (String) table.getValueAt(row, 8);
			}
		});
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		ShowEmployee();
	}

	public void ShowEmployee() {
		dEmployee emp = new dEmployee();
		ArrayList<mEmployee> arrEmp = emp.GetAllEmployee();
		for (mEmployee s : arrEmp) {
			dataModel.addRow(new Object[] { s.getId(), s.getFullName(), s.getGender(), s.getBirthDay(), s.getHomeTowm(),
					s.getPassPort(), s.getPhone(), s.getEmail(), s.getPosition() });
		}
	}

	public void Delete() {
		dEmployee emp = new dEmployee();
		int row = table.getSelectedRow();
		int CMND = (int) table.getValueAt(row, 5);
		if (emp.Delete(CMND)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
			dataModel.setRowCount(0);
			ShowEmployee();
		}
	}

	public void Update() {
		int row = table.getSelectedRow();
		int id = (int) table.getValueAt(row, 0);
		String FullName = (String) table.getValueAt(row, 1);
		String Gender = (String) table.getValueAt(row, 2);
		String BirthDay = String.valueOf(table.getValueAt(row, 3));
		String HomeTown = (String) table.getValueAt(row, 4);
		int Passport = (int) table.getValueAt(row, 5);
		int Phone = (int) table.getValueAt(row, 6);
		String Email = (String) table.getValueAt(row, 7);
		String Position = (String) table.getValueAt(row, 8);

		new UpdateEmployee(id, FullName, Gender, BirthDay, Passport, Email, HomeTown, Phone, Position).setVisible(true);

	}

	public void Tim(String name) {
		dEmployee emp = new dEmployee();
		ArrayList<mEmployee> arrEmp = emp.GetAll(name);
		for (mEmployee s : arrEmp) {
			dataModel.addRow(new Object[] { s.getId(), s.getFullName(), s.getGender(), s.getBirthDay(), s.getHomeTowm(),
					s.getPassPort(), s.getPhone(), s.getEmail(), s.getPosition() });
		}
	}
}
