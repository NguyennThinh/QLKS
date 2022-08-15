package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.dPosition;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePosition extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXoa;


	/**
	 * Create the dialog.
	 */
	public DeletePosition() {
		
		setBounds(100, 100, 483, 99);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblten = new JLabel("Nhập vào tên chức vụ cần xóa");
			lblten.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblten.setBounds(10, 14, 201, 27);
			contentPanel.add(lblten);
		}
		{
			txtXoa = new JTextField();
			txtXoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			txtXoa.setBounds(209, 14, 174, 27);
			contentPanel.add(txtXoa);
			txtXoa.setColumns(10);
		}
		{
			JButton btnOK = new JButton("Xóa");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cv = txtXoa.getText();
					if(new dPosition().Delete(cv)) {
						JOptionPane.showMessageDialog(null, "Xóa chức vụ thành công");
					}
				}
			});
			btnOK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			btnOK.setBounds(393, 18, 70, 23);
			contentPanel.add(btnOK);
		}
	}

}
