create database dbStudent;
use dbStudent;

CREATE TABLE USER (
  IDUSER int primary key NOT NULL AUTO_INCREMENT,
  USERNAME varchar(50),
  PASSWORD varchar(100),
  ROLE varchar(50));

create table KHOA(
    MAKHOA int primary key NOT NULL AUTO_INCREMENT,
    TENKHOA text);

create table NGHANH(
    MACN int primary key NOT NULL AUTO_INCREMENT,
    TENCN text,
    MAKHOA int,
    FOREIGN KEY (MAKHOA) REFERENCES KHOA(MAKHOA));
    
create table SINHVIEN(
    MASV int primary key NOT NULL AUTO_INCREMENT,
    HOTEN text,
    GIOITINH enum('Nam','Nữ'),
    NGAYSINH date,
    LOP text,
    TENCN text,
    TENKHOA text,
    EMAIL text,
    GPA double,
    HINHANH blob);

insert into USER
values	(1,'admin','admin','user'),
	(2,'user','user','user'),
	(3,'teacher','teacher','user');

insert into SINHVIEN
values	(1, 'Nguyễn Thị Huỳnh Anh', 'Nữ', '2003/05/24', 'TH1', 'Công nghệ phần mềm', 'Công nghệ thông tin', 'huynhanh@gmail.com', 3.0, 'user.png'),
	(2, 'Đậu Đăng Huy', 'Nam', '2003/08/24', 'TH1', 'Công nghệ phần mềm', 'Công nghệ thông tin', 'huy@gmail.com', 3.0, 'user.png'),
        (3, 'Phạm Thị Hoài Thương', 'Nữ', '2003/01/20', 'TH1', 'Hệ thống thông tin', 'Công nghệ thông tin', 'thuong@gmail.com', 3.2, 'user.png'),
        (4, 'Lê Ngọc Tú', 'Nữ', '2003/03/21', 'TH1', 'Hệ thống thông tin', 'Công nghệ thông tin', 'tu@gmail.com', 2.8, 'user.png'),
        (5, 'Trần Diễm My', 'Nữ', '2003/03/03', 'TH1', 'Hệ thống thông tin', 'Công nghệ thông tin', 'my@gmail.com', 3.0, 'user.png'),
        (6, 'Nguyễn Thị Hồng Thủy', 'Nữ', '2003/02/24', 'TH1', 'Quản trị kinh doanh', 'Quản trị kinh doanh', 'thuy@gmail.com', 2.5, 'user.png'),
        (7, 'Nguyễn Trương Quốc Minh', 'Nam', '2003/09/26', 'TH1', 'Luật kinh tế', 'Luật', 'minh@gmail.com', 2.3, 'user.png'),
        (8, 'Nguyễn Thiện Nhơn', 'Nam', '2003/05/11', 'TH1', 'Ngôn ngữ Anh', 'Ngoại ngữ', 'nhon@gmail.com', 3.0, 'user.png'),
        (9, 'Nguyễn Tiến Đạt', 'Nam', '2003/10/24', 'TH1', 'An ninh mạng', 'Công nghệ thông tin', 'dat@gmail.com', 3.4, 'user.png'),
        (10, 'Vương Thư Huệ', 'Nữ', '2003/05/24', 'TH1', 'Kinh doanh quốc tế', 'Quản trị kinh doanh', 'hue@gmail.com', 3.0, 'user.png');

insert into KHOA values	(1, 'Công nghệ thông tin'),
			(2, 'Ngoại ngữ'),
                        (3, 'Quản trị kinh doanh'),
                        (4, 'Luật');

insert into NGHANH values (1, 'Công nghệ phần mềm', 1),
			  (2, 'An ninh mạng', 1),
                          (3, 'Hệ thống thông tin', 1),
                          (4, 'Ngôn ngữ Anh', 2),
                          (5, 'Ngôn ngữ Trung Quốc', 2),
                          (6, 'Kinh doanh quốc tế', 3),
                          (7, 'Quản trị kinh doanh', 3),
                          (8, 'Luật kinh doanh', 4),
                          (9, 'Luật thương mại quốc tế', 4);
select * from USER;
select * from KHOA;
select * from NGHANH;
select * from SINHVIEN;

    