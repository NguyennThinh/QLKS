package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Dao.dBill;
import Dao.dCustomer;
import Dao.dDetailBill;
import Dao.dRoom;
import Model.mCustomer;
import Model.mDetailBill;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRoomNumber;
	private JTextField txtTotal;
	private JComboBox<String> cmbPayMoney;
	int Price =0;
	int GiaTien = 0;
	dRoom roomm = new dRoom();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public CheckOut(String RoomNumber, int RoomPrice) {
	 
		Price = RoomPrice;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRoomNumber = new JLabel("Số phòng");
		lblRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoomNumber.setBounds(56, 70, 73, 25);
		contentPanel.add(lblRoomNumber);
		
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtRoomNumber.setBounds(139, 67, 207, 28);
		contentPanel.add(txtRoomNumber);
		txtRoomNumber.setText(RoomNumber);
		txtRoomNumber.setColumns(10);
		
		JLabel lblTitle = new JLabel("THANH TOÁN");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(102, 10, 232, 40);
		contentPanel.add(lblTitle);
		
		JLabel lblPayMoney = new JLabel("Người trả");
		lblPayMoney.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPayMoney.setBounds(56, 121, 73, 25);
		contentPanel.add(lblPayMoney);
		
		JLabel lblTotal = new JLabel("Tổng tiền");
		lblTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTotal.setBounds(56, 167, 73, 25);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTotal.setColumns(10);
		txtTotal.setBounds(139, 164, 207, 28);
		contentPanel.add(txtTotal);
		
		 cmbPayMoney = new JComboBox();
		cmbPayMoney.setBounds(139, 119, 207, 28);
		contentPanel.add(cmbPayMoney);
		
		JButton btnPay = new JButton("Thanh toán");
		btnPay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pay( RoomNumber, GiaTien+RoomPrice);
				Index.p.Panels(new Room());
				dispose();
			}
		});
		btnPay.setBackground(Color.WHITE);
		btnPay.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPay.setBounds(162, 202, 100, 28);
		contentPanel.add(btnPay);
		PayMoney();
		Total(RoomNumber);
	}
	public void Total(String Phong) {
		dDetailBill dao = new dDetailBill();
		ArrayList<mDetailBill> arrCT  = dao.DetailBillDByRoom(Phong);
		
		for(mDetailBill s : arrCT) {
			GiaTien  += s.getPrice();
			
		}
		NumberFormat chuyentien = new DecimalFormat("#,###,###,###");
		txtTotal.setText(String.valueOf(chuyentien.format(GiaTien+Price))+" "+"VND" );;
	}
	public void PayMoney() {
		dCustomer dao = new dCustomer();
		ArrayList<mCustomer> arrKH  = dao.GetAllCustomerByRoom(txtRoomNumber.getText());
		for(mCustomer s : arrKH) {
			cmbPayMoney.addItem(s.getFullName());
		}
	}
	public void Pay(String RoomNumber, int money) {
		dBill bill = new dBill();
		dCustomer cus = new dCustomer();
		dRoom room = new dRoom();
		if(bill.UpdateBill(RoomNumber, money) && cus.UpdateKhachHang(RoomNumber, "Đã thanh toán") && room.UpdateStatus(RoomNumber, "Phòng trống")) {
			JOptionPane.showMessageDialog(null, "Trả phòng thanh công");
			Room.p.ShowAllRoom();
		}else {
			
		}
	}
}
