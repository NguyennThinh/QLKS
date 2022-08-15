package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import AppPackage.AnimationClass;
import Dao.Dao_Login;
import Dao.dEmployee;
import Model.mEmployee;
import Model.mLogin;

public class Login extends JFrame {

	/**
	 * @author My Love
	 */
	private static final long serialVersionUID = -4986565701543183465L;
	private JPanel contentPane;
	AnimationClass at = new AnimationClass();
	private JLabel img1, img2, img3;
	private JLabel lblNewLabel;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;
	private JTextField txtTaiKhoan;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.print("Khong the chay");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 1198, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pLeft = new JPanel();
		pLeft.setBounds(0, 46, 591, 400);
		contentPane.add(pLeft);
		pLeft.setLayout(null);

		img1 = new JLabel("");
		img1.setIcon(new ImageIcon("D:\\java\\Nhom8_QLKS\\Image\\KS1.jpg"));
		img1.setBounds(0, 0, 591, 400);
		pLeft.add(img1);

		img2 = new JLabel("");
		img2.setIcon(new ImageIcon("Image\\KS2.jpg"));
		img2.setBounds(0, 0, 591, 400);
		pLeft.add(img2);

		img3 = new JLabel("");
		img3.setIcon(new ImageIcon("Image\\KS3.jpg"));
		img3.setBounds(1200, 0, 591, 429);
		pLeft.add(img3);

		JPanel pRight = new JPanel();
		pRight.setBounds(592, 0, 591, 446);
		contentPane.add(pRight);
		pRight.setLayout(null);

		lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setIcon(new ImageIcon("Image\\Username.png"));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTaiKhoan.setBounds(85, 140, 110, 31);
		pRight.add(lblTaiKhoan);

		lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMatKhau.setIcon(new ImageIcon("Image\\Password.png"));
		lblMatKhau.setBounds(85, 203, 99, 31);
		pRight.add(lblMatKhau);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(239, 140, 209, 31);
		pRight.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dangnhap();
			}
		});
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDangNhap.setBounds(261, 274, 135, 39);
		btnDangNhap.setIcon(new ImageIcon("Image\\login.png"));
		pRight.add(btnDangNhap);

		passwordField = new JPasswordField();
		passwordField.setBounds(239, 203, 209, 31);
		pRight.add(passwordField);

		JLabel lblTieuDe = new JLabel("ĐĂNG NHẬP");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTieuDe.setBounds(236, 41, 189, 31);
		pRight.add(lblTieuDe);

		lblNewLabel = new JLabel("KHÁCH SẠN SỐ 1 VIỆT NAM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 591, 48);
		contentPane.add(lblNewLabel);
		SlideShow();
	}

	public void SlideShow() {
		new Thread(new Runnable() {
			int key;

			public void run() {
				try {
					while (true) {
						switch (key) {
						case 0:
							Thread.sleep(2000);
							at.jLabelXLeft(0, -600, 12, 10, img1);
							at.jLabelXLeft(600, 0, 12, 10, img2);
							at.jLabelXLeft(1200, 600, 12, 10, img3);
							key++;

						case 1:
							Thread.sleep(2000);
							at.jLabelXLeft(-600, -1200, 12, 10, img1);
							at.jLabelXLeft(0, -600, 12, 10, img2);
							at.jLabelXLeft(600, 0, 12, 10, img3);
							key++;

						case 2:
							Thread.sleep(2000);
							at.jLabelXRight(-1200, -600, 12, 10, img1);
							at.jLabelXRight(-600, 0, 12, 10, img2);
							at.jLabelXRight(0, 600, 12, 10, img3);
							key++;

						case 3:
							Thread.sleep(2000);
							at.jLabelXRight(-600, 0, 12, 10, img1);
							at.jLabelXRight(0, 600, 12, 10, img2);
							at.jLabelXRight(600, 1200, 12, 10, img3);
							key = 0;

						}

					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
@SuppressWarnings("deprecation")
public void Dangnhap() {
		
		Dao_Login dao = new Dao_Login();
		mLogin lg = new mLogin();
		lg.setUserName(Integer.parseInt(txtTaiKhoan.getText()));
		lg.setPassWord(passwordField.getText());
		mEmployee nv = new mEmployee();
		nv.setPassPort(Integer.parseInt(txtTaiKhoan.getText()));
		boolean check = dao.CheckLogin(lg);
		
		boolean checkTen = new dEmployee().GetNhanVien(nv);
		//String chucvu = new dEmployee().GetChucVu(Integer.parseInt(txtTaiKhoan.getText()));
		Index Run = new Index();
		if (check == true) {
		//	if(chucvu.equals("Nhân viên")) {
			//	new IndexNhanVien().setVisible(true);
			//}else {
			Run.setVisible(true);
			this.setVisible(false);
			//}
		} else {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập", "Error massage",
					JOptionPane.ERROR_MESSAGE);
		}
		if(txtTaiKhoan.getText().equals("123456789")) {
			Run.p.Ten("Admin");
		}else if(checkTen == true) {
			Run.p.Ten(nv.getFullName());
		
	}
		
	}
}
