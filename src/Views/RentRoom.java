package Views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Dao.dBill;
import Dao.dCustomer;
import Dao.dRoom;
import Model.mBill;
import Model.mCustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class RentRoom extends JDialog implements ActionListener {

	/**
	 *@author My Love
	 */
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final long serialVersionUID = -6418805104344202009L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFullName;
	private JTextField txtPassport;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtDateTimeFrom;
	private JTextField txtPrice;
	private JTextField txtDateTimeTo;
	private JLabel lblRoomNumber;
	private JRadioButton radMan, radWoman;
	private JButton btnRent;
	private JDateChooser dateBirthDay;
	dCustomer customer = new dCustomer();
	dBill bill= new dBill();
	dRoom room = new dRoom();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/** 
	 * Create the dialog.
	 */
	public RentRoom(String RoomNumber, int Price) {
		
		setBounds(100, 100, 417, 501);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.decode("#3d84b8")));
		panel.setBounds(0, 0, 416, 500);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblRentRoom = new JLabel("THUÊ PHÒNG");
		lblRentRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentRoom.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblRentRoom.setBounds(79, 10, 220, 33);
		panel.add(lblRentRoom);
		
		 lblRoomNumber = new JLabel("<dynamic>");
		 lblRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 lblRoomNumber.setText(RoomNumber);
		lblRoomNumber.setBounds(173, 63, 83, 19);
		panel.add(lblRoomNumber);
		
		JLabel lblRoom = new JLabel("Phòng:");
		lblRoom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoom.setBounds(37, 63, 83, 19);
		panel.add(lblRoom);
		
		JLabel lblName = new JLabel("Tên khách hàng");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblName.setBounds(37, 95, 126, 19);
		panel.add(lblName);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtFullName.setColumns(10);
		txtFullName.setBounds(155, 95, 172, 19);
		panel.add(txtFullName);
		
		 radWoman = new JRadioButton("Nữ");
		 radWoman.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		radWoman.setBounds(240, 127, 58, 21);
		panel.add(radWoman);
		
		 radMan = new JRadioButton("Nam");
		 radMan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		radMan.setBounds(172, 127, 58, 21);
		panel.add(radMan);
		
		JLabel lblGender = new JLabel("Giới tính");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGender.setBounds(37, 128, 83, 19);
		panel.add(lblGender);
		
		JLabel lblBirthday = new JLabel("Ngày sinh:");
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblBirthday.setBounds(37, 157, 83, 19);
		panel.add(lblBirthday);
		
		 dateBirthDay = new JDateChooser();
		dateBirthDay.setBounds(155, 157, 172, 23);
		dateBirthDay.setDateFormatString("yyyy-MM-dd");
		panel.add(dateBirthDay);
		
		JLabel lblPassPort = new JLabel("CMND");
		lblPassPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassPort.setBounds(37, 189, 83, 19);
		panel.add(lblPassPort);
		
		txtPassport = new JTextField();
		txtPassport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPassport.setColumns(10);
		txtPassport.setBounds(155, 186, 172, 23);
		panel.add(txtPassport);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(155, 218, 172, 24);
		panel.add(txtPhone);
		
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(37, 218, 106, 24);
		panel.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(37, 252, 83, 24);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(155, 252, 172, 24);
		panel.add(txtEmail);
		
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		Date date = new Date();
		txtDateTimeFrom = new JTextField();
		txtDateTimeFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDateTimeFrom.setColumns(10);
		txtDateTimeFrom.setText(dt.format(date));
		txtDateTimeFrom.setBounds(155, 286, 172, 27);
		panel.add(txtDateTimeFrom);
		
		JLabel lblDateTimeFrom = new JLabel("Ngày, giờ đến");
		lblDateTimeFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateTimeFrom.setBounds(37, 286, 106, 27);
		panel.add(lblDateTimeFrom);
		
		JLabel lblDateTimeTo = new JLabel("Ngày, giờ đi:");
		lblDateTimeTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateTimeTo.setBounds(37, 323, 106, 26);
		panel.add(lblDateTimeTo);
		
		JLabel lblPrice = new JLabel("Thanh toán:");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPrice.setBounds(37, 360, 94, 24);
		panel.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPrice.setColumns(10);
		txtPrice.setEditable(false);
		txtPrice.setBounds(155, 359, 172, 25);
		panel.add(txtPrice);
		
		txtDateTimeTo = new JTextField();
		txtDateTimeTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDateTimeTo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PriceBookin( txtDateTimeFrom.getText(), txtDateTimeTo.getText(), Price);
			}
		});
		txtDateTimeTo.setColumns(10);
		txtDateTimeTo.setBounds(155, 323, 172, 26);
		panel.add(txtDateTimeTo);
		
		 btnRent = new JButton("Xác nhận");
		 btnRent.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnRent.setBounds(155, 405, 101, 26);
		panel.add(btnRent);
		btnRent.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRent)) {

			try {
				Date parsedDateTo = df.parse(txtDateTimeTo.getText());
				Date parsedDateFrom = df.parse(txtDateTimeFrom.getText());
				Timestamp timestampFrom = new Timestamp(parsedDateFrom.getTime());
				Timestamp timestampTo = new Timestamp(parsedDateTo.getTime());

				mCustomer c = new mCustomer();
				mBill b = new mBill();
				c.setFullName(txtFullName.getText());
				if (radMan.isSelected()) {
					c.setGrender("Nam");
				} else {
					c.setGrender("Nữ");
				}
				c.setBirthDay(getName());
				c.setBirthDay(String.format("%1$tY-%1$tm-%1$td", dateBirthDay.getDate()));
				c.setPassPort(Integer.parseInt(txtPassport.getText()));
				c.setPhone(Integer.parseInt(txtPhone.getText()));
				c.setRoomNumber(lblRoomNumber.getText());
				c.setDateTimeFrom(timestampFrom);
				c.setDateTimeTo(timestampTo);
				c.setStatus("Đang thuê");
				c.setEmail(txtEmail.getText());
				b.setRoomNumber(lblRoomNumber.getText());
				b.setTotalMoney(Integer.parseInt(txtPrice.getText()));
				b.setStatus("Chưa thanh toán");
				b.setTimeFrom(timestampFrom);
				b.setTimeTo(timestampTo);

				if (customer.Insert(c) && bill.Insert(b)
						&& room.UpdateStatus(lblRoomNumber.getText(), "Đang hoạt động")) {
					JOptionPane.showMessageDialog(null, "Thuê phòng thành công ");
					
					Index.p.Panels(new Room());
				} else {
					JOptionPane.showMessageDialog(null, "Đặt phòng thành công", "Error message",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	public void PriceBookin(String DateFrom, String DateTo, int Price) {
		String dateStart = DateFrom;
		String dateStop = DateTo;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			long diff = d2.getTime() - d1.getTime();
			long diffHours = diff / (60 * 60 * 1000);
			if (diffHours == 0) {
				txtPrice.setText(String.valueOf(1 * Price));
			} else if (diffHours < 0) {
				txtPrice.setText("Vui lòng kiểm tra lại ngày đến và ngày đi");
			} else {
				txtPrice.setText(String.valueOf(diffHours * Price));
			}

		} catch (ParseException e) {

		}
	}

}
