package Views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Dao.dEmployee;
import Model.mEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFullName;
	private JTextField txtPassport;
	private JTextField txtEmail;
	private JTextField txtHomeTown;
	private JTextField txtPhone;
	private JTextField txtPosition;
	private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public UpdateEmployee(int Id, String FullName, String Gender, String BirthDay, int PassPort, String Email,
			String HomeTown, int Phone, String Position) {
		setBounds(100, 100, 450, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitle = new JLabel("Employee");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(162, 10, 146, 35);
		contentPanel.add(lblTitle);

		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtFullName.setColumns(10);
		txtFullName.setBounds(152, 89, 167, 26);
		contentPanel.add(txtFullName);

		JLabel lblFullName = new JLabel("Họ và tên");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblFullName.setBounds(50, 92, 92, 23);
		contentPanel.add(lblFullName);

		JLabel lblGender = new JLabel("Giới tính");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGender.setBounds(50, 130, 92, 23);
		contentPanel.add(lblGender);

		JRadioButton radMan = new JRadioButton("Nam");
		radMan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		radMan.setBounds(152, 131, 61, 21);
		contentPanel.add(radMan);

		JRadioButton radWoman = new JRadioButton("Nữ");
		radWoman.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		radWoman.setBounds(226, 131, 103, 21);
		contentPanel.add(radWoman);

		JLabel lblBirthDay = new JLabel("Ngày sinh");
		lblBirthDay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblBirthDay.setBounds(50, 166, 92, 23);
		contentPanel.add(lblBirthDay);

		JLabel lblPassport = new JLabel("CMND");
		lblPassport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassport.setBounds(50, 202, 92, 23);
		contentPanel.add(lblPassport);

		txtPassport = new JTextField();
		txtPassport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPassport.setColumns(10);
		txtPassport.setBounds(152, 199, 167, 26);
		contentPanel.add(txtPassport);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(152, 235, 167, 26);
		contentPanel.add(txtEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(50, 238, 63, 23);
		contentPanel.add(lblEmail);

		JLabel lblHomeTown = new JLabel("Quê quán");
		lblHomeTown.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHomeTown.setBounds(50, 274, 92, 23);
		contentPanel.add(lblHomeTown);

		txtHomeTown = new JTextField();
		txtHomeTown.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtHomeTown.setColumns(10);
		txtHomeTown.setBounds(152, 271, 167, 26);
		contentPanel.add(txtHomeTown);

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(152, 307, 167, 26);
		contentPanel.add(txtPhone);

		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(50, 310, 103, 23);
		contentPanel.add(lblPhone);

		JLabel lblPosition = new JLabel("Chức vụ");
		lblPosition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPosition.setBounds(50, 346, 79, 23);
		contentPanel.add(lblPosition);

		txtPosition = new JTextField();
		txtPosition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPosition.setColumns(10);
		txtPosition.setBounds(152, 343, 167, 26);
		contentPanel.add(txtPosition);

		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblID.setBounds(50, 56, 79, 23);
		contentPanel.add(lblID);

		JLabel lblIDEmployee = new JLabel("");
		lblIDEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblIDEmployee.setBounds(152, 55, 61, 23);
		contentPanel.add(lblIDEmployee);
		lblIDEmployee.setText(String.valueOf(Id));
		txtFullName.setText(FullName);
		txtEmail.setText(Email);
		txtHomeTown.setText(HomeTown);
		txtPassport.setText(String.valueOf(PassPort));
		txtPhone.setText(String.valueOf(Phone));
		txtPosition.setText(Position);
		if (Gender.equals("Nam")) {
			radMan.setSelected(true);
		} else {
			radWoman.setSelected(true);
		}
		JButton btnConFim = new JButton("Xác nhận");
		btnConFim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnConFim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				dEmployee em = new dEmployee(); 
				mEmployee emp = new mEmployee();
				emp.setFullName(txtFullName.getText());
				emp.setBirthDay(String.format("%1$tY-%1$tm-%1$td", dateChooser.getDate()));
				emp.setEmail(txtEmail.getText());
				emp.setHomeTowm(txtHomeTown.getText());
				emp.setPassPort(Integer.parseInt(txtPassport.getText()));
				emp.setId(Integer.parseInt(lblIDEmployee.getText()));
				emp.setPhone(Integer.parseInt(txtPhone.getText()));
				emp.setPosition(txtPosition.getText());
				if(radMan.isSelected()) {
					emp.setGender("Nam");
				}else {
					emp.setGender("Nữ");
				}
				if(em.Update(emp)) {
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					EmployeeManager.p.dataModel.setRowCount(0);
					EmployeeManager.p.ShowEmployee();
				}
			}
		});
		btnConFim.setBounds(163, 395, 120, 31);
		contentPanel.add(btnConFim);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(154, 163, 165, 26);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateChooser.setDateFormatString("yyyy-MM-dd");
			dateChooser.setDate(df.parse(BirthDay));
		} catch (ParseException e1) {
		
			e1.printStackTrace();
		}
		contentPanel.add(dateChooser);
	}
}
