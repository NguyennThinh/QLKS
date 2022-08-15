package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Dao.dBill;
import Dao.dDetailBill;
import Model.mDetailBill;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;


public class UseService extends JDialog {

	/**
	 * @author My Love
	 */
	private static final long serialVersionUID = 2122669165922148034L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtQuatum;
	private JTextField txtTotalPrice;
	dBill dao  =new dBill();
	int PriceSer;
	String Room;
	String Service;
	int ServiceId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 */
	public UseService(String RoomNumer, String ServiceName, int Price, String Unit, int ServiceID) {
		PriceSer = Price;
		Room = RoomNumer;
		Service = ServiceName;
		ServiceId = ServiceID;
		
	
		setBounds(100, 100, 450, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(Color.decode("#3d84b8")));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRoomNumber = new JLabel("");
		lblRoomNumber.setText(RoomNumer);
		lblRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblRoomNumber.setBounds(10, 10, 137, 42);
		contentPanel.add(lblRoomNumber);
		
		JLabel lblServiceName = new JLabel("");
		lblServiceName.setText(ServiceName);
		lblServiceName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblServiceName.setBounds(157, 10, 221, 42);
		contentPanel.add(lblServiceName);
		
		JLabel lblUnit = new JLabel("");
		lblUnit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnit.setText(Unit); 
		lblUnit.setBounds(66, 83, 105, 39);
		contentPanel.add(lblUnit);
		
		txtQuatum = new JTextField();
		txtQuatum.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtQuatum.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuatum.setText("1");
		
		txtQuatum.setBounds(226, 89, 34, 25);
		contentPanel.add(txtQuatum);
		txtQuatum.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("Thành tiền");
		lblTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTotalPrice.setBounds(66, 132, 105, 33);
		contentPanel.add(lblTotalPrice);
		
		txtTotalPrice = new JTextField();
		txtTotalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTotalPrice.setText(String.valueOf(Price));
		txtTotalPrice.setBounds(181, 132, 181, 33);
		contentPanel.add(txtTotalPrice);
		txtTotalPrice.setColumns(10);
		
		JButton btnPlus = new JButton("");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plus();
			}
		});
		btnPlus.setBackground(Color.WHITE);
		btnPlus.setIcon(new ImageIcon("Image\\plus.png"));
		btnPlus.setBounds(181, 89, 27, 25);
		contentPanel.add(btnPlus);
		
		JButton btnMinus = new JButton("");
		btnMinus.setBackground(Color.WHITE);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minus();
			}
		});
		btnMinus.setIcon(new ImageIcon("Image\\minus.png"));
		btnMinus.setBounds(270, 91, 27, 25);
		contentPanel.add(btnMinus);
		
		JButton btnConfim = new JButton("Xác nhận");
		btnConfim.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnConfim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confim();
			}
		});
		btnConfim.setBounds(157, 175, 105, 33);
		contentPanel.add(btnConfim);
	}
	public void Plus() {
		int tong = 0;
		tong = Integer.parseInt(txtQuatum.getText());
		if (tong < 30) {
			tong++;
			txtQuatum.setText(String.valueOf(tong));
			txtTotalPrice.setText(String.valueOf(tong * PriceSer));
		}
	}
	public void Minus() {
		int tong = 0;
		tong = Integer.parseInt(txtQuatum.getText());
		if (tong >=1) {
			tong--;
			txtQuatum.setText(String.valueOf(tong));
			txtTotalPrice.setText(String.valueOf(tong * PriceSer));
		}
	}
	public void Confim() {
		dDetailBill dao = new dDetailBill();
		dBill daoHD = new dBill();
		mDetailBill chitietHD;
		int Billid = daoHD.GetMaHD(Room);
		chitietHD = dao.DetailBill(Room, ServiceId);
		if(chitietHD != null) {
			mDetailBill ct = new mDetailBill();
			ct.setQuantum(Integer.parseInt(txtQuatum.getText()));
			ct.setPrice(Integer.parseInt(txtTotalPrice.getText()));
			ct.setId(chitietHD.getId());
			int update = dao.UpdateChiTiet(ct);
		}if(chitietHD==null) {
			
			mDetailBill ct = new mDetailBill();
			ct.setIdBill(daoHD.GetMaHD(Room));
			ct.setIdService(ServiceId);
			ct.setQuantum(Integer.parseInt(txtQuatum.getText()));
			ct.setPrice(Integer.parseInt(txtTotalPrice.getText()));
			int insert  = dao.Insert(ct);
		}
		
		Views.Room.p.ListServiceUse(Billid);
	}
}
