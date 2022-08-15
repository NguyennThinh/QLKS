package Views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dRoomType;
import Model.mRoomType;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RoomTypeManager extends JPanel {
	private JTable table;
	DefaultTableModel dataModel = new DefaultTableModel();
	public static RoomTypeManager p;
	private JTextField txtTimPhong;

	/**
	 * Create the panel.
	 */
	public RoomTypeManager() {
		p = this;
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.BLACK));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRoomType rt = new AddRoomType();
				rt.setLocationRelativeTo(null);
				rt.setVisible(true);
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

		txtTimPhong = new JTextField();
		txtTimPhong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataModel.setRowCount(0);
				Tim(txtTimPhong.getText());
			}
		});
		txtTimPhong.setColumns(10);

		JLabel lblTimPhong = new JLabel("Nhập vào loại phòng cần tìm");
		lblTimPhong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblQunLLoi = new JLabel("QUẢN LÝ LOẠI PHÒNG");
		lblQunLLoi.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTimPhong, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtTimPhong, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(433))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAdd))
								.addComponent(btnUpdate))))
					.addGap(106))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(416)
					.addComponent(lblQunLLoi, GroupLayout.PREFERRED_SIZE, 274, Short.MAX_VALUE)
					.addGap(175))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQunLLoi, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTimPhong, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTimPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUpdate))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
					.addGap(100))
		);

		String[] headers = { "ID", "Loại phong", "Giá phòng" };
		dataModel = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table = new JTable(dataModel));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		GetAllType();
	}

	public void GetAllType() {
		NumberFormat nf = new DecimalFormat("#,###,###");
		dRoomType type = new dRoomType();
		ArrayList<mRoomType> arrType = type.GetAllLoaiPhong();
		for (mRoomType s : arrType) {
			dataModel.addRow(new Object[] { s.getId(), s.getRoomType(), nf.format(s.getPrice()) + " VND" });
		}
	}

	public void Delete() {
		dRoomType type = new dRoomType();
		int row = table.getSelectedRow();
		int id = (int) table.getValueAt(row, 0);
		if (type.Delete(id)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
			dataModel.setRowCount(0);
			GetAllType();
		}
	}

	public void Update() {
		int row = table.getSelectedRow();
		int id = (int) table.getValueAt(row, 0);
		String RoomType = (String) table.getValueAt(row, 1);
		String Price = (String) table.getValueAt(row, 2);
		UpdateRoomType up = new UpdateRoomType(id, RoomType, Price);
		up.setLocationRelativeTo(null);
		up.setVisible(true);
		
	}

	public void Tim(String loai) {
		NumberFormat nf = new DecimalFormat("#,###,###");
		dRoomType type = new dRoomType();
		ArrayList<mRoomType> arrType = type.GetPriceByLoai(loai);
		for (mRoomType s : arrType) {
			dataModel.addRow(new Object[] { s.getId(), s.getRoomType(), nf.format(s.getPrice()) + " VND" });
		}
	}
}
