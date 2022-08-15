package Views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Dao.Dao_Login;
import Dao.dBill;
import Dao.dRoomType;
import Model.mBill;
import Model.mLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class AccountManager extends JPanel {
	private JTextField txtTaiKhoan;
	private JTable table;
	DefaultTableModel dataModel = new DefaultTableModel();
	int tk;
	public static AccountManager p;
	/**
	 * Create the panel.
	 */
	public AccountManager() {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		p=this;
		JScrollPane scrollPane = new JScrollPane();

		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setColumns(10);

		JLabel lblTaiKhoan = new JLabel("Nhập vào tài khoản cần tìm");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		JButton btnDoi = new JButton("Đổi mật khẩu");
		btnDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePassword(tk).setVisible(true);;
			}
		});
		
		JLabel lblQunLTi = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblQunLTi.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTaiKhoan, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(98))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(286)
					.addComponent(lblQunLTi, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addGap(159))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblQunLTi, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTaiKhoan, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(btnDelete)
							.addGap(18)
							.addComponent(btnDoi)))
					.addGap(151))
		);

		String[] headers = { "STT", "Tài khoản", "Mật khẩu", "Chức vụ" };
		dataModel = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table = new JTable(dataModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				tk = (int) table.getValueAt(row, 1);
			}
		});
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		GetAll();

	}
	public void Delete() {
		Dao_Login type = new Dao_Login();
		int row = table.getSelectedRow();
		int id = (int) table.getValueAt(row, 1);
		if (type.DeleteLoaiByCMND(id)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
			dataModel.setRowCount(0);
			GetAll();
		}
	}
	public void GetAll() {
		Dao_Login lg = new Dao_Login();
		ArrayList<mLogin> arrBill = lg.GetAll();
		
		//for (mLogin s : arrBill) {
			for(int i = 0; i <arrBill.size(); i++ ) {
			dataModel.addRow(new Object[] {i+1, arrBill.get(i).getUserName(), arrBill.get(i).getPassWord(), arrBill.get(i).getChucVu() });
		}
	//	}
	}
}
