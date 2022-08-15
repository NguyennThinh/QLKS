package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.dPosition;
import Model.mPosition;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPosition extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMa;
	private JTextField txtTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPosition dialog = new AddPosition();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPosition() {
		setBounds(100, 100, 450, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = txtMa.getText();
				String ten = txtTen.getText();
				mPosition p = new mPosition(ma, ten);
				if(new dPosition().Insert(p)) {
					JOptionPane.showMessageDialog(null, "Thêm chức vụ thành công");
				}
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThem.setBounds(142, 196, 137, 33);
		contentPanel.add(btnThem);
		
		JLabel lblThmChcV = new JLabel("Thêm chức vụ");
		lblThmChcV.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblThmChcV.setBounds(129, 0, 162, 33);
		contentPanel.add(lblThmChcV);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMa.setColumns(10);
		txtMa.setBounds(142, 67, 223, 33);
		contentPanel.add(txtMa);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(142, 117, 223, 33);
		contentPanel.add(txtTen);
		
		JLabel lblMa = new JLabel("Mã chức vụ");
		lblMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMa.setBounds(40, 67, 92, 33);
		contentPanel.add(lblMa);
		
		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblChucVu.setBounds(40, 117, 92, 33);
		contentPanel.add(lblChucVu);
	}
}
