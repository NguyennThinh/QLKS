package Views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Dao.dRoom;
import Dao.dRoomType;
import Model.mRoom;
import Model.mRoomType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddRoom extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -851731817354149194L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRoomNumber;
	private JTextField txtNumberPeople;
	private JTextField txtRoomPrice;
	private JComboBox<String> cmbRoomType;
	dRoom droom= new dRoom();
	int RoomPrice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddRoom dialog = new AddRoom();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddRoom() {
		
		setBounds(100, 100, 382, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 382, 293);
		contentPanel.add(panel);
		
		JLabel lblRoomNumber = new JLabel("Số phòng");
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Loại phòng");
		
		JLabel lblNumberPeople = new JLabel("Số người");
		
		txtNumberPeople = new JTextField();
		txtNumberPeople.setColumns(10);
		
		JLabel lblRoomPrice = new JLabel("Giá phòng");
		
		txtRoomPrice = new JTextField();
		txtRoomPrice.setColumns(10);
		
		JLabel lblTitle = new JLabel("Thêm Phòng");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRoom();
			}
		});
		
		 cmbRoomType = new JComboBox();
		 cmbRoomType.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		GetPrice();
		 	}
		 });
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(111)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblRoomNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtRoomNumber, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblRoomType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cmbRoomType, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addGap(1))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNumberPeople, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblRoomPrice, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
											.addGap(10)))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtRoomPrice)
										.addComponent(txtNumberPeople, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(162)
							.addComponent(btnAdd)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(txtRoomNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addComponent(lblRoomNumber)))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRoomType)
						.addComponent(cmbRoomType, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNumberPeople))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(txtNumberPeople, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRoomPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnAdd))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRoomPrice)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		GetListRoomType();
	}
	public void addRoom() {
		mRoom room = new mRoom();
		room.setRoomNumber(txtRoomNumber.getText());
		room.setAmountPeople(Integer.parseInt(txtNumberPeople.getText()));
		room.setPrice(RoomPrice);
		room.setStatus("Phòng trống");
		room.setRoomType(cmbRoomType.getSelectedItem().toString());
		if(droom.Insert(room)) {
			JOptionPane.showMessageDialog(null, "Thêm mới phòng thành công");
			RoomManager.p.dataModel.setRowCount(0);
		}
	}
	public void GetListRoomType() {
		dRoomType roomtype = new dRoomType();
		
		ArrayList<mRoomType> arrRommType = roomtype.GetAllLoaiPhong();
		for(mRoomType s :arrRommType) {
			cmbRoomType.addItem(s.getRoomType());
		
		}
	}
	public void GetPrice() {
		dRoomType roomtype = new dRoomType();
		ArrayList<mRoomType> arrPrice = roomtype.GetPriceByLoai(cmbRoomType.getSelectedItem().toString());
		for (mRoomType s : arrPrice) {
			NumberFormat chuyentien = new DecimalFormat("#,###,###");
			txtRoomPrice.setText(chuyentien.format(s.getPrice())+" "+"VND/h");
			RoomPrice = s.getPrice();
		}
	}
}
