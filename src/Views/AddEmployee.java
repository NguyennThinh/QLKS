package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;

import Dao.dEmployee;
import Dao.dPosition;
import Model.mEmployee;
import Model.mPosition;

import javax.swing.JComboBox;

public class AddEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFullName;
	private JTextField txtPassport;
	private JTextField txtEmail;
	private JTextField txtHomeTown;
	private JTextField txtPhone;
	private JDateChooser dateChooser;
	private JRadioButton radMan, radWoman;
	private JComboBox cmbPosition;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * Create the dialog.
	 */
	public AddEmployee() {
		setBounds(100, 100, 450, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("THÊM NHÂN VIÊN");
		lblTitle.setBounds(78, 10, 280, 35);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPanel.add(lblTitle);
		
		JLabel lblFullName = new JLabel("Họ và tên");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFullName.setBounds(62, 66, 79, 23);
		contentPanel.add(lblFullName);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtFullName.setBounds(180, 63, 167, 26);
		contentPanel.add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblGender = new JLabel("Giới tính");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGender.setBounds(62, 104, 79, 23);
		contentPanel.add(lblGender);
		
		JLabel lblBirthDay = new JLabel("Ngày sinh");
		lblBirthDay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBirthDay.setBounds(62, 140, 79, 23);
		contentPanel.add(lblBirthDay);
		
		JLabel lblPassport = new JLabel("CMND");
		lblPassport.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassport.setBounds(62, 176, 73, 23);
		contentPanel.add(lblPassport);
		
		txtPassport = new JTextField();
		txtPassport.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPassport.setColumns(10);
		txtPassport.setBounds(180, 173, 167, 26);
		contentPanel.add(txtPassport);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(62, 212, 73, 23);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(180, 209, 167, 26);
		contentPanel.add(txtEmail);
		
		JLabel lblHomeTown = new JLabel("Quê quán");
		lblHomeTown.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHomeTown.setBounds(62, 248, 85, 23);
		contentPanel.add(lblHomeTown);
		
		txtHomeTown = new JTextField();
		txtHomeTown.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHomeTown.setColumns(10);
		txtHomeTown.setBounds(180, 245, 167, 26);
		contentPanel.add(txtHomeTown);
		
		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhone.setBounds(62, 284, 96, 23);
		contentPanel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(180, 281, 167, 26);
		contentPanel.add(txtPhone);
		
		JLabel lblPosition = new JLabel("Chức vụ");
		lblPosition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPosition.setBounds(62, 320, 85, 23);
		contentPanel.add(lblPosition);
		
		JButton btnConFim = new JButton("Xác nhận");
		btnConFim.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnConFim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployee();
			}
		});
		btnConFim.setBounds(180, 353, 96, 27);
		contentPanel.add(btnConFim);
		
		 radMan = new JRadioButton("Nam");
		 radMan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(radMan);
		radMan.setBounds(180, 105, 61, 21);
		contentPanel.add(radMan);
		
		 radWoman = new JRadioButton("Nữ");
		 radWoman.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(radWoman);
		radWoman.setBounds(254, 105, 103, 21);
		contentPanel.add(radWoman);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(181, 140, 166, 23);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		contentPanel.add(dateChooser);
		
		 cmbPosition = new JComboBox();
		cmbPosition.setBounds(180, 317, 168, 26);
		contentPanel.add(cmbPosition);
		doc();

	}
	public void addEmployee() {
		mEmployee em = new mEmployee();
		dEmployee emp = new dEmployee();
		em.setFullName(txtFullName.getText());
		em.setBirthDay(String.format("%1$tY-%1$tm-%1$td", dateChooser.getDate()));
		if(radMan.isSelected()) {
			em.setGender("Nam");
		}else {
			em.setGender("Nữ");
		}
		em.setPassPort(Integer.parseInt(txtPassport.getText()));
		em.setEmail(txtEmail.getText());
		em.setHomeTowm(txtHomeTown.getText());
		em.setPhone(Integer.parseInt(txtPhone.getText()));
		em.setPosition(cmbPosition.getSelectedItem().toString());
		if(emp.Insert(em)) {
			JOptionPane.showMessageDialog(null, "Thêm mới nhân viên thành công");
			EmployeeManager.p.dataModel.setRowCount(0);
			EmployeeManager.p.ShowEmployee();
		}
	}
	public void doc() {
		ArrayList<mPosition> arrP = new dPosition().GetAll();
		for(mPosition s : arrP) {
			cmbPosition.addItem(s.getTenCV());
		}
	}
}
