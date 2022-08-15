package Views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
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

public class BookinRoom extends JDialog implements ActionListener {

	/**
	 * @author My Love
	 */
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtPassport;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtDateTimeFrom;
	private JTextField txtDateTimeTo;
	private JTextField txtPrice;
	private JRadioButton radMan, radWoman;
	private JButton btnBook;
	private JDateChooser dateBirthDay;
	private JLabel lblRoomNumber;
	dCustomer customer = new dCustomer();
	dBill bill = new dBill();
	dRoom room = new dRoom();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public BookinRoom(String RoomNumber, int Price) {
		
		setBounds(100, 100, 458, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 458, 491);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblExit.setIcon(new ImageIcon("Image\\close.png"));
		lblExit.setBounds(440, 0, 16, 23);
		panel.add(lblExit);

		JLabel lblName = new JLabel("Tên khách hàng");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblName.setBounds(63, 92, 97, 25);
		panel.add(lblName);

		txtName = new JTextField(); 
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtName.setBounds(185, 92, 154, 25);
		panel.add(txtName);
		txtName.setColumns(10);

		JLabel lblTieuDe = new JLabel("ĐẶT PHÒNG");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setBounds(119, 10, 220, 33);
		panel.add(lblTieuDe);

		JLabel lblGender = new JLabel("Giới tính");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGender.setBounds(63, 124, 97, 19);
		panel.add(lblGender);

		JLabel lblBirthday = new JLabel("Ngày sinh:");
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblBirthday.setBounds(63, 153, 97, 19);
		panel.add(lblBirthday);

		txtPassport = new JTextField();
		txtPassport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPassport.setColumns(10);
		txtPassport.setBounds(185, 182, 154, 26);
		panel.add(txtPassport);

		JLabel lblPassPort = new JLabel("CMND");
		lblPassPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassPort.setBounds(63, 182, 97, 26);
		panel.add(lblPassPort);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(185, 218, 154, 26);
		panel.add(txtPhone);

		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(63, 218, 97, 26);
		panel.add(lblPhone);

		radMan = new JRadioButton("Nam");
		radMan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonGroup.add(radMan);
		radMan.setBounds(184, 123, 58, 21);
		panel.add(radMan);

		radWoman = new JRadioButton("Nữ");
		radWoman.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonGroup.add(radWoman);
		radWoman.setBounds(252, 123, 58, 21);
		panel.add(radWoman);

		dateBirthDay = new JDateChooser();
		dateBirthDay.setBounds(185, 153, 154, 23);
		dateBirthDay.setDateFormatString("yyyy-MM-dd");
		panel.add(dateBirthDay);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(185, 254, 154, 26);
		panel.add(txtEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(63, 254, 97, 26);
		panel.add(lblEmail);

		txtDateTimeFrom = new JTextField();
		txtDateTimeFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDateTimeFrom.setColumns(10);
		txtDateTimeFrom.setBounds(185, 290, 154, 26);
		panel.add(txtDateTimeFrom);

		JLabel lblDateTimeFrom = new JLabel("Ngày, giờ đến");
		lblDateTimeFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateTimeFrom.setBounds(63, 290, 97, 26);
		panel.add(lblDateTimeFrom);

		txtDateTimeTo = new JTextField();
		txtDateTimeTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDateTimeTo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PriceBookin(txtDateTimeFrom.getText(), txtDateTimeTo.getText(), Price);
			}
		});
		txtDateTimeTo.setColumns(10);
		txtDateTimeTo.setBounds(185, 326, 154, 26);
		panel.add(txtDateTimeTo);

		JLabel lblDateTimeTo = new JLabel("Ngày, giờ đi:");
		lblDateTimeTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateTimeTo.setBounds(63, 326, 97, 26);
		panel.add(lblDateTimeTo);

		JLabel lblPrice = new JLabel("Thanh toán:");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPrice.setBounds(73, 362, 87, 26);
		panel.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPrice.setColumns(10);
		txtPrice.setEditable(false);
		txtPrice.setBounds(185, 362, 154, 26);
		panel.add(txtPrice);

		btnBook = new JButton("Đặt");
		btnBook.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBook.setBounds(185, 398, 85, 25);
		panel.add(btnBook);

		JLabel lblRoom = new JLabel("Phòng:");
		lblRoom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoom.setBounds(63, 63, 97, 19);
		panel.add(lblRoom);

		lblRoomNumber = new JLabel("");
		lblRoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoomNumber.setBounds(185, 63, 83, 19);
		panel.add(lblRoomNumber);
		lblRoomNumber.setText(RoomNumber);
		btnBook.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnBook)) {

			try {
				Date parsedDateTo = df.parse(txtDateTimeTo.getText());
				Date parsedDateFrom = df.parse(txtDateTimeFrom.getText());
				Timestamp timestampFrom = new Timestamp(parsedDateFrom.getTime());
				Timestamp timestampTo = new Timestamp(parsedDateTo.getTime());

				mCustomer c = new mCustomer();
				mBill b = new mBill();
				c.setFullName(txtName.getText());
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
				c.setStatus("Đặt phòng");
				c.setEmail(txtEmail.getText());
				b.setRoomNumber(lblRoomNumber.getText());
				b.setTotalMoney(Integer.parseInt(txtPrice.getText()));
				b.setStatus("Đặt trước");
				b.setTimeFrom(timestampFrom);
				b.setTimeTo(timestampTo);
				b.setStatus("Đặt trước");
				if (customer.Insert(c) && bill.Insert(b)
						&& room.UpdateStatus(lblRoomNumber.getText(),"Đã đặt phòng")) {
					JOptionPane.showMessageDialog(null, "Dat phong thanh cong");
					Index.p.Panels(new Room());
				} else {
					JOptionPane.showMessageDialog(null, "Dat phong không thanh cong", "Error message",
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
