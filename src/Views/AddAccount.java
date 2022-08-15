package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Dao_Login;
import Model.mLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddAccount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTaiKhoan;
	private JTextField txtTen;
	private JTextField txtChucVu;
	private JButton btnDangKy;
	private JPasswordField txtPass;
	private JPasswordField txtPasss;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public AddAccount(String ten, int CMND, String ChucVu) {
		setBounds(100, 100, 548, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTieuDe = new JLabel("Thêm tài khoản");
			lblTieuDe.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			lblTieuDe.setBounds(180, 10, 162, 33);
			contentPanel.add(lblTieuDe);
		}
		{
			JLabel lblTaiKhoan = new JLabel("Tài khoản");
			lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTaiKhoan.setBounds(91, 77, 92, 33);
			contentPanel.add(lblTaiKhoan);
		}
		{
			txtTaiKhoan = new JTextField();
			txtTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtTaiKhoan.setBounds(193, 77, 223, 33);
			contentPanel.add(txtTaiKhoan);
			txtTaiKhoan.setColumns(10);
			txtTaiKhoan.setText(String.valueOf(CMND));
		}
		{
			txtTen = new JTextField();
			txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtTen.setColumns(10);
			txtTen.setBounds(193, 120, 223, 33);
			contentPanel.add(txtTen);
			txtTen.setText(ten);
		}
		{
			JLabel lblTen = new JLabel("Chủ tài khoản");
			lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTen.setBounds(91, 120, 108, 33);
			contentPanel.add(lblTen);
		}
		{
			JLabel lblPass = new JLabel("Mật khẩu");
			lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblPass.setBounds(91, 206, 92, 33);
			contentPanel.add(lblPass);
		}
		{
			JLabel lblRPass = new JLabel("Nhập lại");
			lblRPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblRPass.setBounds(91, 249, 92, 33);
			contentPanel.add(lblRPass);
		}
		{
			 btnDangKy = new JButton("Đăng ký");
			btnDangKy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtPass.getText().equals( txtPasss.getText())) {
						Dao_Login lg = new Dao_Login();
						mLogin lgg = new mLogin(); 
						lgg.setUserName(CMND);
						lgg.setPassWord(txtPass.getText());
						lgg.setChucVu(ChucVu);
						if(lg.Insert(lgg)) {
							JOptionPane.showMessageDialog(null, "Đăng ký thành công");
						}else {
							JOptionPane.showMessageDialog(null, "Đăng ký không thành công");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Mật khẩu không giống nhau");
					}
				}
			});
			btnDangKy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btnDangKy.setBounds(203, 298, 137, 33);
			contentPanel.add(btnDangKy);
		}
		{
			txtChucVu = new JTextField();
			txtChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtChucVu.setColumns(10);
			txtChucVu.setBounds(193, 163, 223, 33);
			contentPanel.add(txtChucVu);
			txtChucVu.setText(ChucVu);
		}
		{
			JLabel lblChucVu = new JLabel("Chức vụ");
			lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblChucVu.setBounds(91, 163, 92, 33);
			contentPanel.add(lblChucVu);
		}
		
		txtPass = new JPasswordField();
		txtPass.setBounds(193, 207, 223, 33);
		contentPanel.add(txtPass);
		
		txtPasss = new JPasswordField();
		txtPasss.setBounds(193, 249, 223, 33);
		contentPanel.add(txtPasss);
	}
}
