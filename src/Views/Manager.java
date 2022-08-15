package Views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Manager extends JPanel {
	
	/**
	 * @author My Love
	 */
	private static final long serialVersionUID = -6209875533450551574L;
	private JPanel pDisplay;
	private JButton btnRoomType,btnBill,btnEmployee,btnSetting,btnCustomer,btnRoom;
	/**
	 * Create the panel.
	 */
	public Manager() {
		
		JPanel panel = new JPanel();
		
		 pDisplay = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup( 
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pDisplay, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
				.addComponent(pDisplay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
		);
		pDisplay.setLayout(new BorderLayout(0, 0));
		
		 btnCustomer = new JButton("KHÁCH HÀNG");
		 btnCustomer.setIcon(new ImageIcon("Image\\customer-feedback.png"));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panels(new CustomerManager());
			}
		});
		btnCustomer.setBorder(new LineBorder(Color.decode("#79a7d3"), 8));
		btnCustomer.setBackground(Color.decode("#6883bc"));
		
		 btnRoom = new JButton("QUẢN LÝ PHÒNG");
		 btnRoom.setIcon(new ImageIcon("Image\\two-keys-on-keychain.png"));
		btnRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panels(new RoomManager());
			}
		});
		btnRoom.setBorder(new LineBorder(Color.decode("#79a7d3"), 8));
		btnRoom.setBackground(Color.decode("#6883bc"));
		
		 btnRoomType = new JButton("QUẢN LÝ LOẠI PHÒNG");
		 btnRoomType.setIcon(new ImageIcon("Image\\select.png"));
		btnRoomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panels(new RoomTypeManager());
			}
		});
		btnRoomType.setBorder(new LineBorder(Color.decode("#79a7d3"), 8));
		btnRoomType.setBackground(Color.decode("#6883bc"));
		
		 btnBill = new JButton("XEM DANH SÁCH HÓA ĐƠN");
		 btnBill.setIcon(new ImageIcon("Image\\receipt.png"));
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panels(new BillManager());
			}
		});
		btnBill.setBorder(new LineBorder(Color.decode("#79a7d3"), 8));
		btnBill.setBackground(Color.decode("#6883bc"));
		
		 btnEmployee = new JButton("NHÂN VIÊN");
		 btnEmployee.setIcon(new ImageIcon("Image\\call-center-agent.png"));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panels(new EmployeeManager());
			}
		});
		btnEmployee.setBorder(new LineBorder(Color.decode("#79a7d3"), 8));
		btnEmployee.setBackground(Color.decode("#6883bc"));
		
		 btnSetting = new JButton("TÀI KHOẢN");
		 btnSetting.setIcon(new ImageIcon("Image\\setting.png"));
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panels(new AccountManager());
			}
		});
		btnSetting.setBorder(new LineBorder(Color.decode("#79a7d3"), 8));
		btnSetting.setBackground(new Color(104, 131, 188));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnRoom, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
							.addComponent(btnRoomType, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
							.addComponent(btnBill, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
							.addComponent(btnEmployee, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
						.addComponent(btnCustomer, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
						.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRoom, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRoomType, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBill, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEmployee, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSetting, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	public void Panels(JPanel s) {
		pDisplay.removeAll();
		pDisplay.add(s, BorderLayout.CENTER);
		pDisplay.validate();
	}
	
}
