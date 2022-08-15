create database sqlQLKS
use sqlQLKS
create table loaiphong(
	id int Identity(1,1),
	loaiphong nvarchar(50) primary key,
	gia int,
)
create table Phong(
	id int IDENTITY(1,1) ,
	sophong nvarchar(30)primary key,
	trangthai nvarchar(200),
	loaiphong nvarchar(50),
	songuoio int,
	giaphong int,
		FOREIGN KEY (loaiphong)
  REFERENCES loaiphong (loaiphong)
)
create table KhachHang(
	hoten nvarchar(50),
	gioitinh nvarchar(20),
	ngaysinh datetime,
	socmnd int primary key,
	sodienthoai int,
	email nvarchar(100),
	trangthai nvarchar(50),
	sophong nvarchar(30),
	ngayden datetime,
	ngaydi datetime,
	FOREIGN KEY (sophong)
  REFERENCES Phong (sophong)
)
create table DichVu(
	madichvu int IDENTITY(1,1)primary key,
	tendichvu nvarchar(50) ,
	loaidichvu nvarchar(100),
	gia int,
	donvitinh nvarchar(50),
	)
create table hoadon(
	mahoadon int IDENTITY(1,1) primary key,
	phong nvarchar(30),
	ngayden datetime,
	ngaydi datetime,
	trangthai nvarchar(60),
	tongtien int,
	FOREIGN KEY (phong)
  REFERENCES Phong (sophong)
)
create table chitietHD(
	machitiet int IDENTITY(1,1) primary key,
	mahoadon int,
	madichvu int,
	sl int,
	gia int,
	FOREIGN KEY (mahoadon)
  REFERENCES hoadon (mahoadon)
)

create table DSDichVu(
	tendichvu nvarchar(50),
	madichvu int,
	mahoadon int,
	sl int,
	gia int,
		FOREIGN KEY (madichvu)
  REFERENCES DichVu (madichvu),
  		FOREIGN KEY (mahoadon)
  REFERENCES hoadon (mahoadon)
)
create table login(
	username int primary key,
	password nvarchar(50),
	chucvu nvarchar(50),
)
create table ChucVu(
	maChucVu nvarchar(20),
	chucvu nvarchar(50)primary key
)
create table nhanvien(
	manv int IDENTITY(1,1),
	hoten nvarchar (50),
	gioitinh nvarchar(20),
	ngaysinh date,
	socmnd int primary key,
	email nvarchar(100),
	quequan nvarchar(100),
	sodienthoai int,
	chucvu nvarchar(50),
			FOREIGN KEY (chucvu)
  REFERENCES ChucVu (chucvu),
)

go
select * from nhanvien where socmnd LIKE N'%Nguyễn%' or sodienthoai LIKE N'%968737246%'
GO
insert into loaiphong(loaiphong, gia) values
(N'Tổng thống',250000),
(N'Thương gia',180000),
(N'Phòng thường',100000)
iNSERT into Phong (sophong, trangthai, loaiphong, songuoio, giaphong) values
('Phòng 1', N'Phòng trống', N'Tổng thống', 4, 250000),
('Phòng 2', N'Phòng trống', N'Tổng thống', 2, 250000),
('Phòng 3', N'Phòng trống', N'Thương gia', 2, 180000),
('Phòng 4', N'Phòng trống', N'Thương gia', 3, 180000),
('Phòng 5', N'Phòng trống', N'Thương gia', 4, 180000),
('Phòng 6', N'Phòng trống', N'Thương gia', 4, 180000),
('Phòng 7', N'Phòng trống', N'Thương gia', 4, 180000),
('Phòng 8', N'Phòng trống', N'Phòng thường', 2, 100000),
('Phòng 9', N'Phòng trống', N'Phòng thường', 2, 100000),
('Phòng 10', N'Phòng trống', N'Phòng thường', 2, 100000),
('Phòng 11', N'Phòng trống', N'Phòng thường', 3, 100000),
('Phòng 12', N'Phòng trống', N'Phòng thường', 2, 100000),
('Phòng 13', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 14', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 15', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 16', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 17', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 18', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 19', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 20', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 21', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 22', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 23', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 24', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 25', N'Phòng trống', N'Phòng thường', 4, 100000),
('Phòng 26', N'Phòng trống', N'Phòng thường', 4, 100000)


Go
insert into DichVu(tendichvu, loaidichvu ,gia, donvitinh) values
(N'Massage', N'Làm đẹp', 790000, N'Lần'),
(N'Giặt ủi',N'Dọn dẹp', 50000,N'Lần'),
(N'Tắm bùn', N'Làm đẹp', 800000,N'Lần')
