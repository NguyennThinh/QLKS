package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Index extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pMenuItem1, pMenuItem2, pMenuItem3;
	private JPanel contentPane, pDisplay;
	private JLabel pListRoom,pQuanLy,pThongKe;
	private JLabel lblSayHelo;
	private JLabel lblTenNV;
	public static Index p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Login().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		
		p = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel pMenu = new JPanel();
		pMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		pMenu.setBackground(Color.decode("#3d84b8"));	
		pDisplay = new JPanel();
		pDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(pDisplay, GroupLayout.DEFAULT_SIZE, 1376, Short.MAX_VALUE)
				.addComponent(pMenu, GroupLayout.DEFAULT_SIZE, 1376, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pMenu, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pDisplay, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pDisplay.setLayout(new BorderLayout(0, 0));
		pMenu.setLayout(null);

		pMenuItem1 = new JPanel();
		pMenuItem1.setBounds(0, 0, 232, 88);
		pMenu.add(pMenuItem1);
		pMenuItem1.setLayout(new BorderLayout(0, 0));
		pMenuItem1.setBackground(Color.decode("#3d84b8"));
		
		JLabel lblicon1 = new JLabel("");
		lblicon1.setIcon(new ImageIcon("Image\\Hotel.png"));
		pMenuItem1.add(lblicon1, BorderLayout.WEST);

		pMenuItem2 = new JPanel();
		pMenuItem2.setBounds(242, 0, 243, 88);
		pMenu.add(pMenuItem2);
		pMenuItem2.setLayout(new BorderLayout(0, 0));
		pMenuItem2.setBackground(Color.decode("#3d84b8"));
		JLabel lblicon2 = new JLabel("");
		lblicon2.setIcon(new ImageIcon("Image\\Manager.png"));
		pMenuItem2.add(lblicon2, BorderLayout.WEST);

		 pQuanLy = new JLabel("QUẢN LÝ");
		pQuanLy.setForeground(Color.WHITE);
		pQuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		pQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pMenuItem2.add(pQuanLy, BorderLayout.CENTER);

		pMenuItem3 = new JPanel();
		pMenuItem3.setBounds(495, 0, 257, 88);
		pMenu.add(pMenuItem3);
		pMenuItem3.setLayout(new BorderLayout(0, 0));
		pMenuItem3.setBackground(Color.decode("#3d84b8"));
		JLabel lblicon3 = new JLabel("");
		lblicon3.setIcon(new ImageIcon("Image\\Statical.png"));
		pMenuItem3.add(lblicon3, BorderLayout.WEST);

		pThongKe = new JLabel("THỐNG KÊ");
		pThongKe.setForeground(Color.WHITE);
		pThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		pThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pMenuItem3.add(pThongKe, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
		pMenuItem1.addMouseListener(new panelButton(pMenuItem1));
		
		 pListRoom = new JLabel("DANH SÁCH PHÒNG");
		pListRoom.setForeground(Color.WHITE);
		
		pListRoom.setBackground(getForeground());
		pListRoom.setHorizontalAlignment(SwingConstants.CENTER);
		pListRoom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pMenuItem1.add(pListRoom, BorderLayout.CENTER);
		pMenuItem2.addMouseListener(new panelButton(pMenuItem2));
		pMenuItem3.addMouseListener(new panelButton(pMenuItem3));
		
				JLabel pThuePhong = new JLabel("DANH SÁCH PHÒNG");
				pThuePhong.setBounds(10, 10, 222, 78);
				pMenu.add(pThuePhong);
				pThuePhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				lblSayHelo = new JLabel("Xin chào:");
				lblSayHelo.setForeground(Color.WHITE);
				lblSayHelo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				lblSayHelo.setBounds(1104, 10, 262, 24);
				pMenu.add(lblSayHelo);
				
				lblTenNV = new JLabel("");
				lblTenNV.setForeground(Color.WHITE);
				lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				lblTenNV.setBounds(1188, 10, 178, 24);
			
				pMenu.add(lblTenNV);
				
				pDisplay.add(new Room());
	}

	public void Panels(JPanel s) {
		pDisplay.removeAll();
		pDisplay.add(s, BorderLayout.CENTER);
		pDisplay.validate();
	}

	private class panelButton extends MouseAdapter {
		private JPanel pane;

		public panelButton(JPanel pane) {
			this.pane = pane;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			pane.setBackground(Color.white);
			pListRoom.setForeground(Color.black);
			pQuanLy.setForeground(Color.black);
			pThongKe.setForeground(Color.black);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			pane.setBackground(Color.white);
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			pane.setBackground(Color.decode("#3d84b8"));
			pListRoom.setForeground(Color.white);
			pQuanLy.setForeground(Color.white);
			pThongKe.setForeground(Color.white);
		
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			pane.setBackground(Color.decode("#3d84b8"));
		
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(pMenuItem1)) {
				Panels(new Room());
			}
			if (e.getSource().equals(pMenuItem2)) {
				Panels(new Manager());
			}
			if (e.getSource().equals(pMenuItem3)) {
				Panels(new Statistical());
			}
			
		}
	}
	public void Ten(String ten) {

		lblTenNV.setText(ten);
	}
}
