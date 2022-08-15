package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import Dao.dBill;
import Dao.dCustomer;
import Dao.dListServiceUse;
import Dao.dRoom;
import Dao.dService;
import Model.mCustomer;
import Model.mListServiceUse;
import Model.mRoom;
import Model.mService;

public class Room extends JPanel {
	/**
	 * @author My Love
	 */
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm ");
	private static final long serialVersionUID = 1L;
	dRoom room = new dRoom();
	dService service = new dService();
	dListServiceUse ListService = new dListServiceUse();
	private JPanel pListRoom, pInfo, pService, pType, pListService, p3, p2, p1, pListServiceUse;
	private JButton btn2;
	private JLabel lblRoomNumber, lblRoomStatus, lblPriceRoom;
	NumberFormat nf = new DecimalFormat("#,###,###");
	public static Room p;
	int RoomPrice;
	String RoomNum;
	private JTextField txtSearch;


	/**
	 * Create the panel.
	 */
	public Room() {
		p = this;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		pInfo = new JPanel();
		pInfo.setVisible(false);
		pInfo.setBorder(new TitledBorder(null, "Thông tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		pService = new JPanel();
		pService.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pInfo, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pService, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pService, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE))
						.addComponent(pInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
					.addContainerGap())
		);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		JLabel lblSearch = new JLabel("Tìm ngày giờ :");

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllRoomInHotelByDate();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(btnSearch)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

		pListService = new JPanel();
		pListService.setBorder(new TitledBorder(null, "Danh s\u00E1ch d\u1ECBch v\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		pType = new JPanel();
		pType.setBorder(new TitledBorder(null, "Lo\u1EA1i d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		GroupLayout gl_pService = new GroupLayout(pService);
		gl_pService.setHorizontalGroup(
			gl_pService.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pService.createSequentialGroup()
					.addContainerGap()
					.addComponent(pType, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pListService, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
		);
		gl_pService.setVerticalGroup(
			gl_pService.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pService.createSequentialGroup()
					.addGroup(gl_pService.createParallelGroup(Alignment.BASELINE)
						.addComponent(pType, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
						.addComponent(pListService, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		pService.setLayout(gl_pService);

		JLabel lblRoom = new JLabel("Phòng:");

		JLabel lblStatus = new JLabel("Trạng thái:");

		JLabel lblPrice = new JLabel("Giá phòng:");

		lblRoomNumber = new JLabel("");

		lblRoomStatus = new JLabel("");

		lblPriceRoom = new JLabel("");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBorder(new TitledBorder(null, "Dịch vụ đã sử dụng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btn2 = new JButton("");
		btn2.setBounds(140, 345, 33, 9);

		pListServiceUse = new JPanel();
		scrollPane_1.setViewportView(pListServiceUse);
		pListServiceUse.setLayout(new GridLayout(0, 1, 10, 10));

		p1 = new JPanel();
		p1.setVisible(false);

		p2 = new JPanel();
		p2.setVisible(false);

		p3 = new JPanel();
		p3.setVisible(false);

		JButton btnCheckout = new JButton("Trả");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checkout();
			}
		});
		p3.add(btnCheckout);

		JButton btnService = new JButton("Dịch vụ");
		btnService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServiceType();
			}
		});
		p3.add(btnService);
		GroupLayout gl_pInfo = new GroupLayout(pInfo);
		gl_pInfo.setHorizontalGroup(gl_pInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_pInfo
				.createSequentialGroup()
				.addGroup(gl_pInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_pInfo.createSequentialGroup()
						.addComponent(lblRoom, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblRoomNumber, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pInfo.createSequentialGroup()
								.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblRoomStatus, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
						.addGroup(gl_pInfo.createSequentialGroup()
								.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblPriceRoom, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addComponent(p1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(p2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(p3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_pInfo.setVerticalGroup(gl_pInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_pInfo
				.createSequentialGroup().addGap(10)
				.addGroup(gl_pInfo.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblRoom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblRoomNumber, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
				.addGap(18)
				.addGroup(gl_pInfo.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblRoomStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
				.addGap(18)
				.addGroup(gl_pInfo.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPriceRoom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
				.addGap(42).addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(p1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(p2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(p3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(157)));

		JButton btnCheckIn = new JButton("Nhận phòng");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dCustomer daKH = new dCustomer();
				dBill daoHD = new dBill();
				dRoom daoRoom = new dRoom();
				ArrayList<mCustomer> arrKhach = daKH.GetAllCustomerByRoom(lblRoomNumber.getText(), "Đặt phòng");
				int CMND  = 0;
				for(mCustomer s : arrKhach) { 
					CMND  = s.getPassPort();
					
				}
				if(daKH.UpdateKhach(CMND, lblRoomNumber.getText(), "Đang thuê") && daoRoom.UpdateRoom(lblRoomNumber.getText(), "Đang hoạt động") &&
						daoHD.UpdateStatusOfBill(lblRoomNumber.getText(),"Chưa thanh toán")) {
					JOptionPane.showMessageDialog(null, "Nhận phòng thành công");
					panel.removeAll();
					Index.p.Panels(new Room());
				}else {
					System.err.println("eror");
				}
			}
		});
		p2.add(btnCheckIn);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelRoom();
			}
		});
		p2.add(btnCancel);

		JButton btnRent = new JButton("Thuê");
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentRoom rt = new RentRoom(lblRoomNumber.getText(), RoomPrice);
				rt.setLocationRelativeTo(null);
				rt.setVisible(true);
			}
		});
		p1.add(btnRent);

		JButton btnBookRoom = new JButton("Đặt");
		btnBookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookinRoom bk = new BookinRoom(lblRoomNumber.getText(), RoomPrice);
				bk.setLocationRelativeTo(null);
				bk.setVisible(true);
			}
		});
		p1.add(btnBookRoom);
		pInfo.setLayout(gl_pInfo);

		pListRoom = new JPanel();
		pListRoom.setBorder(
				new TitledBorder(null, "Danh sách phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(pListRoom);
		pListRoom.setLayout(new GridLayout(0, 4, 10, 10));
		panel.setLayout(gl_panel);
		ShowAllRoomInHotel();
		ShowAllRoom();

	}
	public void delete() {
		pListRoom.removeAll();
	}
	public void ShowAllRoom() {
		
		ArrayList<mRoom> arrRoom = room.GetAllRoom();
		if (arrRoom != null) {
			pListRoom.removeAll();
			JButton[] btnRoom = new JButton[arrRoom.size()];
			for (int i = 0; i < arrRoom.size(); i++) {
				btnRoom[i] = new JButton();
				btnRoom[i].setText(arrRoom.get(i).getRoomNumber());
				btnRoom[i].setForeground(Color.decode("#7a2048"));
				btnRoom[i].setBorder(BorderFactory.createLineBorder(Color.decode("#79a7d3"), 8));
				btnRoom[i].setBackground(Color.decode("#6883bc"));
				btnRoom[i].setPreferredSize(new Dimension(100, 120));
				btnRoom[i].setIcon(new ImageIcon("Image/Hotel1.png"));
				String Status = arrRoom.get(i).getStatus();
				String RoomNumber = arrRoom.get(i).getRoomNumber();
				int RommPrice = arrRoom.get(i).getPrice();
				if (arrRoom.get(i).getStatus().equals("Đang hoạt động")) {
					btnRoom[i].setBackground(Color.red);

				} else if (arrRoom.get(i).getStatus().equals("Đã đặt trước")) {
					btnRoom[i].setBackground(Color.ORANGE);
				}
				btnRoom[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						RoomPrice = RommPrice;
						RoomNum = RoomNumber;
						pInfo.setVisible(true);
						lblRoomNumber.setText(RoomNumber);
						lblRoomStatus.setText(Status);
						lblPriceRoom.setText(String.valueOf(nf.format(RommPrice)) + " VND");
						if (Status.equals("Đang hoạt động")) {
							dBill bill = new dBill();
							int Billid = bill.GetMaHD(RoomNumber);
							p3.setVisible(true);
							p1.setVisible(false);
							p2.setVisible(false);
							pListServiceUse.removeAll();
							ListServiceUse(Billid);

						} else if (Status.equals("Phòng trống")) {
							p1.setVisible(true);
							p2.setVisible(false);
							p3.setVisible(false);
							pListServiceUse.removeAll();
						} else {
							pListServiceUse.removeAll();
							p2.setVisible(true);
							p1.setVisible(false);
							p3.setVisible(false);
						}
					}
				});
				pListRoom.add(btnRoom[i]);
			}

		}
		
	}

	public void ServiceType() {
		pService.setVisible(true);
		pType.removeAll();
		ArrayList<mService> arrService = service.GetServiceType();
		if (arrService != null) {
			JButton[] btnService = new JButton[arrService.size()];
			for (int i = 0; i < arrService.size(); i++) {
				btnService[i] = new JButton();
				btnService[i].setText(arrService.get(i).getServiceType());
				btnService[i].setForeground(Color.decode("#7a2048"));
				btnService[i].setBorder(BorderFactory.createLineBorder(Color.decode("#79a7d3"), 8));
				btnService[i].setBackground(Color.decode("#6883bc"));
				btnService[i].setPreferredSize(new Dimension(200, 50));
				String ServiceType = arrService.get(i).getServiceType();
				btnService[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Service(ServiceType);

					}
				});
				pType.add(btnService[i]);

			}
		}
	}

	public void Service(String ServiceType) {
		pListService.removeAll();
		ArrayList<mService> arrServiceType = service.GetAllServiceByServiceType(ServiceType);

		if (arrServiceType != null) {
			JButton[] btnServices = new JButton[arrServiceType.size()];
			for (int i = 0; i < arrServiceType.size(); i++) {
				String ServiceName = arrServiceType.get(i).getServiceName();
				String Unit = arrServiceType.get(i).getUnit();
				int price1 = arrServiceType.get(i).getServicePrice();
				int ServiceId = arrServiceType.get(i).getId();
				btnServices[i] = new JButton();
				btnServices[i].setText(arrServiceType.get(i).getServiceName());
				btnServices[i].setForeground(Color.decode("#7a2048"));
				btnServices[i].setBorder(BorderFactory.createLineBorder(Color.decode("#79a7d3"), 8));
				btnServices[i].setBackground(Color.decode("#6883bc"));
				btnServices[i].setPreferredSize(new Dimension(200, 50));
				btnServices[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						UseService us = new UseService(RoomNum, ServiceName, price1, Unit, ServiceId);
						us.setLocationRelativeTo(null);
						us.setVisible(true);
					}
				});
				pListService.add(btnServices[i]); 
				pListService.updateUI();

			}
		}
	}

	public void ShowAllRoomInHotel() {
		dCustomer cus = new dCustomer();
		dRoom room = new dRoom();
		ArrayList<mCustomer> arrCus = cus.FindCusByStatus("Đặt phòng");

		for (mCustomer s : arrCus) {
			Date date = new Date();
			try {
				Timestamp dateFrom = s.getDateTimeFrom();
				Timestamp dateTo = s.getDateTimeTo();

				if (df.format(dateFrom).compareTo(df.format(date)) <= 0
						&& df.format(dateTo).compareTo(df.format(date)) >= 0) {
					
					room.UpdateStatus(s.getRoomNumber(), "Đã đặt trước");
				} else {
					room.UpdateStatus(s.getRoomNumber(), "Phòng trống");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void ListServiceUse(int Billid) {
		pListServiceUse.removeAll();
		ArrayList<mListServiceUse> ListServiceUse = ListService.GetDsOrder(Billid);
	
		if (ListServiceUse != null) {
			JPanel[] pServices = new JPanel[ListServiceUse.size()];
			for (int i = 0; i < ListServiceUse.size(); i++) {
				String ServiceName = ListServiceUse.get(i).getServiceName();
				String Unit = ListServiceUse.get(i).getUnit();
				int ServiceId = ListServiceUse.get(i).getServiceId();
				pServices[i] = new JPanel();
				pServices[i].setLayout(new BorderLayout());

				JLabel lblServiceName = new JLabel("Tên dịch vụ: " + ServiceName);
				JLabel lblQuanTum = new JLabel(Unit + ": " + String.valueOf(ListServiceUse.get(i).getQuantum()));
				JLabel lblPrice = new JLabel("Giá:" + String.valueOf(ListServiceUse.get(i).getPrice()));

				pServices[i].add(lblServiceName, BorderLayout.NORTH);
				pServices[i].add(lblQuanTum, BorderLayout.CENTER);
				pServices[i].add(lblPrice, BorderLayout.SOUTH);

				pServices[i].setForeground(Color.decode("#7a2048"));
				pServices[i].setBorder(BorderFactory.createLineBorder(Color.decode("#79a7d3"), 8));
				pServices[i].setBackground(Color.decode("#6883bc"));
				pServices[i].setPreferredSize(new Dimension(80, 65));

				pServices[i].addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						UseService us = new UseService(RoomNum, ServiceName, RoomPrice, Unit, ServiceId);
						us.setVisible(true);
					}

				});
				pListServiceUse.add(pServices[i]);
				pListServiceUse.updateUI();

			}
		}
	}

	public void ShowAllRoomInHotelByDate() {
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dCustomer cus = new dCustomer();
		dRoom room = new dRoom();
		Date parsedDate;
		try {
			parsedDate = dt.parse(txtSearch.getText());

			Timestamp timestamp = new Timestamp(parsedDate.getTime());
			ArrayList<mCustomer> arrCus = cus.FindCusByStatus("Đặt phòng");

			for (mCustomer s : arrCus) {

				Timestamp dateFrom = s.getDateTimeFrom();
				Timestamp dateTo = s.getDateTimeTo();

				if (dt.format(dateFrom).compareTo(dt.format(timestamp)) <= 0
						&& dt.format(dateTo).compareTo(dt.format(timestamp)) >= 0) {
					pListRoom.updateUI();
					room.UpdateStatus(s.getRoomNumber(), "Đã đặt trước");
					
					ShowAllRoom();
				} else {
					pListRoom.updateUI();
					room.UpdateStatus(s.getRoomNumber(), "Phòng trống");
					ShowAllRoom();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	public void Checkout() {
		dBill bill = new dBill();
		
		CheckOut ck = new CheckOut(RoomNum, bill.GetPrice(RoomNum));
		ck.setLocationRelativeTo(null);
		ck.setVisible(true); 
	}
	public void CancelRoom() {
		dCustomer cus = new dCustomer();
		dBill bill = new dBill();
		dRoom room = new dRoom();
		int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy " +lblRoomNumber.getText() +" không?", "Yes or no message", JOptionPane.YES_NO_OPTION );
		if(a == JOptionPane.YES_OPTION) {
			if(cus.UpdateStatusofKhachHang(lblRoomNumber.getText(), "Hủy đặt") && bill.UpdateStatusOfBill(lblRoomNumber.getText(), "Đã hủy")
					&& room.UpdateStatus(lblRoomNumber.getText(), "Phòng trống")) {
				JOptionPane.showMessageDialog(null, "Hủy đặt phòng thành công");
				ShowAllRoom();
			}
		}else {
			return;
		}
	}
}
