package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.dRoomType;
import Model.mRoomType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRoomType extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRoomType;
	private JTextField txtPrice;
	dRoomType rType = new dRoomType();


	/**
	 * Create the dialog.
	 */
	public AddRoomType() {
		setBounds(100, 100, 450, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRoomtype = new JLabel("LoaiPhong");
		lblRoomtype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoomtype.setBounds(74, 69, 85, 22);
		contentPanel.add(lblRoomtype);
		
		JLabel lblTitle = new JLabel("Room Type");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(143, 10, 150, 39);
		contentPanel.add(lblTitle);
		
		txtRoomType = new JTextField();
		txtRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtRoomType.setBounds(182, 63, 175, 28);
		contentPanel.add(txtRoomType);
		txtRoomType.setColumns(10);
		
		JLabel lblPrice = new JLabel("Giá phòng");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPrice.setBounds(74, 121, 85, 22);
		contentPanel.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPrice.setColumns(10);
		txtPrice.setBounds(182, 115, 175, 28);
		contentPanel.add(txtPrice);
		
		JButton btnConfim = new JButton("Xác nhận");
		btnConfim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnConfim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRoomtype();
			}
		});
		btnConfim.setBounds(158, 165, 105, 28);
		contentPanel.add(btnConfim);
	}
	public void addRoomtype() {
		mRoomType type = new mRoomType();
		type.setPrice(Integer.parseInt(txtPrice.getText()));
		type.setRoomType(txtRoomType.getText());
		if(rType.Insert(type)) {
			JOptionPane.showMessageDialog(null, "Thêm mới loại phòng thành công");
			RoomTypeManager.p.dataModel.setRowCount(0);
			RoomTypeManager.p.GetAllType();;
		}
	}
}
