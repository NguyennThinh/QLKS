package Views;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dRoom;
import Model.mRoom;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RoomManager extends JPanel {
	/**
	 * @author My Love
	 */
	private static final long serialVersionUID = 6037787428830873700L;
	private JTable table;
	DefaultTableModel dataModel = new DefaultTableModel();
	public static RoomManager p;
	dRoom room = new dRoom();
	private JTextField txtTimSoPhong;

	/**
	 * Create the panel.
	 */
	public RoomManager() {
		setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.BLACK));

		p = this;
		JScrollPane scrollPane = new JScrollPane();

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRoom r = new AddRoom();
				r.setLocationRelativeTo(null);
				r.setVisible(true);
			} 
		});

		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteRoom();
			}
		});

		JLabel lblTimSoPhong = new JLabel("Nhập vào số phòng cần tìm");
		lblTimSoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		txtTimSoPhong = new JTextField();
		txtTimSoPhong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				dataModel.setRowCount(0);
				Tim(txtTimSoPhong.getText());
			}
		});

		txtTimSoPhong.setColumns(10);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ PHÒNG");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAdd)
								.addComponent(btnDelete)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTimSoPhong, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTimSoPhong, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(281)))
					.addGap(36))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(397)
					.addComponent(lblTieuDe, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
					.addGap(44))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTieuDe, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimSoPhong, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimSoPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.RELATED, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
					.addGap(117))
		);

		String[] headers = { "ID", "Số phòng", "Trạng thái", "Loại phòng", "Số người ở", "Giá phòng" };
		dataModel = new DefaultTableModel(headers, 0);
		scrollPane.setViewportView(table = new JTable(dataModel));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		GetListRoom();
	}

	public void GetListRoom() {
		ArrayList<mRoom> arrRoom = room.GetAllRoom();
		for (mRoom s : arrRoom) {
			dataModel.addRow(new Object[] { s.getId(), s.getRoomNumber(), s.getStatus(), s.getRoomType(),
					s.getAmountPeople(), s.getPrice() });
		}
	}

	public void DeleteRoom() {
		int row = table.getSelectedRow();
		int id = (int) table.getValueAt(row, 0);
		if (room.DeleteRoomByID(id)) {
			JOptionPane.showMessageDialog(null, "Xóa phòng thành công");
			dataModel.setRowCount(0);
			GetListRoom();
		}
	}

	public void Tim(String rom) {
		ArrayList<mRoom> arrRoom = room.GetRoom(rom);
		for (mRoom s : arrRoom) {
			dataModel.addRow(new Object[] { s.getId(), s.getRoomNumber(), s.getStatus(), s.getRoomType(),
					s.getAmountPeople(), s.getPrice() });
		}
	}
}
