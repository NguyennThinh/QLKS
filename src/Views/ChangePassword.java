package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Dao_Login;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTk;
	private JTextField txtPass;
	private JTextField txtPasss;
	private JLabel lbliMtKhu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	public ChangePassword(int tk) {
		setBounds(100, 100, 450, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lbliMtKhu = new JLabel("ĐỔI MẬT KHẨU");
			lbliMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			lbliMtKhu.setBounds(127, 10, 162, 33);
			contentPanel.add(lbliMtKhu);
		}
		{
			txtTk = new JTextField();
			txtTk.setText("0");
			txtTk.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtTk.setColumns(10);
			txtTk.setBounds(140, 77, 223, 33);
			txtTk.setText(String.valueOf(tk));
			contentPanel.add(txtTk);
		}
		{
			JLabel lblTaiKhoan = new JLabel("Tài khoản");
			lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTaiKhoan.setBounds(38, 77, 92, 33);
			contentPanel.add(lblTaiKhoan);
		}
		{
			JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
			lblMtKhuMi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblMtKhuMi.setBounds(38, 120, 107, 33);
			contentPanel.add(lblMtKhuMi);
		}
		{
			txtPass = new JTextField();
			txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtPass.setColumns(10);
			txtPass.setBounds(140, 120, 223, 33);
			contentPanel.add(txtPass);
		}
		{
			txtPasss = new JTextField();
			txtPasss.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtPasss.setColumns(10);
			txtPasss.setBounds(140, 163, 223, 33);
			contentPanel.add(txtPasss);
		}
		{
			JLabel lblRPass = new JLabel("Nhập lại");
			lblRPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblRPass.setBounds(38, 163, 92, 33);
			contentPanel.add(lblRPass);
		}
		{
			JButton btni = new JButton("Đổi");
			btni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtPass.getText().equals(txtPasss.getText())) {
						Dao_Login lg =new Dao_Login();
						if(lg.Update(tk, txtPass.getText())) {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
							AccountManager.p.dataModel.setRowCount(0);
							AccountManager.p.GetAll();
						}else {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công");
						}
					}
				}
			});
			btni.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btni.setBounds(150, 212, 137, 33);
			contentPanel.add(btni);
		}
	}

}
