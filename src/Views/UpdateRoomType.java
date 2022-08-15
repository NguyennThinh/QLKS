package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.dRoomType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoomType extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRoomType;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * Create the dialog.
	 */
	public UpdateRoomType(int id, String RoomType, String Price) {
		setBounds(100, 100, 450, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblRoomType = new JLabel("Loại phòng:");
			lblRoomType.setBounds(53, 60, 80, 27);
			contentPanel.add(lblRoomType);
		
		
			txtRoomType = new JTextField();
			txtRoomType.setBounds(143, 57, 215, 30);
			contentPanel.add(txtRoomType);
			txtRoomType.setText(RoomType);
			txtRoomType.setColumns(10);
		
			txtPrice = new JTextField();
			txtPrice.setColumns(10);
			txtPrice.setBounds(143, 109, 215, 30);
			contentPanel.add(txtPrice);
			JLabel lblPrice = new JLabel("Giá:");
			txtPrice.setText(Price);
			lblPrice.setBounds(53, 112, 80, 27);
			contentPanel.add(lblPrice);
	
			JLabel lblIdRoomType = new JLabel("ID:");
			lblIdRoomType.setBounds(53, 13, 80, 27);
			contentPanel.add(lblIdRoomType);
	
			JButton btnConFim = new JButton("Xác nhận");
			btnConFim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dRoomType type = new dRoomType();
					int price = Integer.parseInt(txtPrice.getText());
					String Type = txtRoomType.getText();
					if(type.UpdateChiTiet(id, Type, Integer.parseInt(txtPrice.getText()))) {
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						RoomTypeManager.p.dataModel.setRowCount(0);
						RoomTypeManager.p.GetAllType();
					}
				}
			});
			btnConFim.setBounds(178, 157, 85, 21);
			contentPanel.add(btnConFim);
			
			JLabel lblID = new JLabel("");
			lblID.setBounds(143, 13, 80, 27);
			lblID.setText(String.valueOf(id));
			contentPanel.add(lblID);
		
	}

}
