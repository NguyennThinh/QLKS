package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;

import Dao.dBill;
import Dao.dCustomer;
import Model.mBill;
import Model.mCustomer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCustomer extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPassport;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JButton btnRent;
	String  RoomNumberr;
	Timestamp DateFrom, DateTo;
	private JRadioButton radMan, radWoman;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private JDateChooser dateBirthday;
	private int Pricee;
	dCustomer customer = new dCustomer();
	dBill bill = new  dBill();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * Create the dialog.
	 */
	public AddCustomer(Timestamp DateTimeFrom , Timestamp DateTimeTo , String RoomNumber, int Price ) {
		DateFrom= DateTimeFrom;
		DateTo = DateTimeTo;
		RoomNumberr = RoomNumber;
		Pricee = Price; 
		setBounds(100, 100, 450, 521);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Họ và tên");
		lblName.setBounds(118, 109, 45, 25);
		contentPanel.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(187, 109, 139, 25);
		contentPanel.add(txtName);
		
		JLabel lblGender = new JLabel("Giới tính");
		lblGender.setBounds(118, 157, 45, 25);
		contentPanel.add(lblGender);
		
		JLabel lblBirthday = new JLabel("Ngày sinh");
		lblBirthday.setBounds(118, 206, 45, 25);
		contentPanel.add(lblBirthday);
		
		JLabel lblPassport = new JLabel("CMND");
		lblPassport.setBounds(118, 259, 45, 25);
		contentPanel.add(lblPassport);
		
		txtPassport = new JTextField();
		txtPassport.setColumns(10);
		txtPassport.setBounds(187, 259, 139, 25);
		contentPanel.add(txtPassport);
		
		 radMan = new JRadioButton("Nam");
		buttonGroup.add(radMan);
		radMan.setBounds(188, 159, 63, 21);
		contentPanel.add(radMan);
		
		 radWoman = new JRadioButton("Nữ");
		buttonGroup.add(radWoman);
		radWoman.setBounds(253, 159, 45, 21);
		contentPanel.add(radWoman);
		
		dateBirthday = new JDateChooser();
		dateBirthday.setBounds(187, 206, 139, 21);
		contentPanel.add(dateBirthday);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(118, 309, 45, 25);
		contentPanel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(187, 309, 139, 25);
		contentPanel.add(txtPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(118, 361, 45, 25);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 361, 139, 25);
		contentPanel.add(txtEmail);
		
		 btnRent = new JButton("Thuê");
		btnRent.setBounds(187, 436, 85, 21);
		contentPanel.add(btnRent);
		
		JLabel lblTitle = new JLabel("Thêm khách hàng");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setBounds(118, 35, 215, 47);
		contentPanel.add(lblTitle);
		btnRent.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRent)) {

			try {
//				Date parsedDateTo = df.parse(DateTo);
//				Date parsedDateFrom = df.parse(DateFrom);
//				Timestamp timestampFrom = new Timestamp(parsedDateFrom.getTime());
//				Timestamp timestampTo = new Timestamp(parsedDateTo.getTime());

				mCustomer c = new mCustomer();
				mBill b = new mBill();
				c.setFullName(txtName.getText());
				if (radMan.isSelected()) {
					c.setGrender("Nam");
				} else {
					c.setGrender("Nữ");
				}
				c.setBirthDay(getName());
				c.setBirthDay(String.format("%1$tY-%1$tm-%1$td", dateBirthday.getDate()));
				c.setPassPort(Integer.parseInt(txtPassport.getText()));
				c.setPhone(Integer.parseInt(txtPhone.getText()));
				c.setRoomNumber(RoomNumberr);
				c.setDateTimeFrom(DateFrom);
				c.setDateTimeTo(DateTo);
				
				c.setStatus("Đang thuê");
				c.setEmail(txtEmail.getText());
				b.setRoomNumber(RoomNumberr);
				long diff =(DateTo.getTime()-DateFrom.getTime())/(60 * 60 * 1000);
				int Total = (int) (diff*Pricee);
				b.setTotalMoney(Total);
				b.setStatus("Chưa thanh toán");

				if (customer.Insert(c) && bill.Insert(b)) {
					JOptionPane.showMessageDialog(null, "Thêm khách thành công");
					CustomerManager.p.dataModel.setRowCount(0);
					CustomerManager.p.GetAllCustomerByStatus(RoomNumberr);
				} else {
					JOptionPane.showMessageDialog(null, "Dat phong thanh cong", "Error message",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		}
		
	}
}
