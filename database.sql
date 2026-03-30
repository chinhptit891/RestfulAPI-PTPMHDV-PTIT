CREATE DATABASE IF NOT EXISTS quanlydienthoai DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE quanlydienthoai;

-- Bang Hang Dien Thoai
CREATE TABLE IF NOT EXISTS Hang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tenHang VARCHAR(100) NOT NULL UNIQUE
);

-- Bang Nguoi Dung
CREATE TABLE IF NOT EXISTS NguoiDung (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tenDangNhap VARCHAR(50) NOT NULL UNIQUE,
    matKhau VARCHAR(255) NOT NULL,
    hoTen VARCHAR(100) NOT NULL,
    soDienThoai VARCHAR(20)
);

-- Bang Dien Thoai
CREATE TABLE IF NOT EXISTS DienThoai (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idHang INT NOT NULL,
    tenDienThoai VARCHAR(200) NOT NULL,
    gia INT NOT NULL,
    moTa TEXT,
    anhDaiDien TEXT,
    FOREIGN KEY (idHang) REFERENCES Hang(id) ON DELETE CASCADE
);

-- Bang Don Hang
CREATE TABLE IF NOT EXISTS DonHang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idNguoiDung INT NOT NULL,
    idDienThoai INT NOT NULL,
    ngayDat DATETIME DEFAULT CURRENT_TIMESTAMP,
    tongTien INT NOT NULL,
    trangThai VARCHAR(50) DEFAULT 'Cho Xu Ly',
    FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(id) ON DELETE CASCADE,
    FOREIGN KEY (idDienThoai) REFERENCES DienThoai(id) ON DELETE CASCADE
);

-- Chen du lieu mau Hang
INSERT INTO Hang (tenHang) VALUES ('Apple'), ('Samsung'), ('Xiaomi'), ('Oppo'), ('Vivo');

-- Chen du lieu mau Nguoi Dung
INSERT INTO NguoiDung (tenDangNhap, matKhau, hoTen, soDienThoai) VALUES 
('khachhang1', '123456', 'Nguyen Van A', '0912345678'),
('khuyenmai2026', '123456', 'Tran Thi B', '0987654321');

-- Chen du lieu mau Dien Thoai (30 san pham)
INSERT INTO DienThoai (idHang, tenDienThoai, gia, moTa, anhDaiDien) VALUES
(1, 'iPhone 15 Pro Max', 34000000, 'Khung titan, chip A17 Pro, camera tele 5x.', 'https://my-test-11.slatic.net/p/3bf4f4a34bcdc8e3ed3adfb0ced2e825.jpg'),
(1, 'iPhone 15 Pro', 28000000, 'Khung titan, chip A17 Pro.', 'https://my-test-11.slatic.net/p/6e0f31c4f4a9b5f4be8d3cb6ecdf06a7.png'),
(1, 'iPhone 15', 21000000, 'Dynamic island, mau sac moi, chip A16.', 'https://my-test-11.slatic.net/p/dbfbae393da047da3edca31d5bda90cf.png'),
(1, 'iPhone 15 Plus', 24000000, 'Man hinh lon, pin trau, mau sac tuoi tre.', 'https://my-test-11.slatic.net/p/8786938a1cb2bd06a4b16dcea56efdc9.jpg'),
(1, 'iPhone 14 Pro Max', 26000000, 'Chip A16, Dynamic island hien dai.', 'https://my-test-11.slatic.net/p/4e2fc7dc9a9b0c2a59a7a6fcacb50b7b.jpg'),
(1, 'iPhone 14 Pro', 24000000, 'Thiet ke cao cap, camera 48MP.', 'https://my-test-11.slatic.net/p/2d88ad9abfdcce6c1e55d5ac2ae53199.jpg'),
(1, 'iPhone 14', 18000000, 'Hieu nang manh me, pin to.', 'https://my-test-11.slatic.net/p/3a4dc7ebbfcc2c1a5b4a5d3fccdd296c.jpg'),
(1, 'iPhone 13', 15000000, 'Man hinh Super Retina, A15 tich hop mạnh.', 'https://my-test-11.slatic.net/p/f2bcf7eb9adc2aca8df15d2fbccc289c.jpg'),

(2, 'Samsung Galaxy S24 Ultra', 31000000, 'Galaxy AI, khung Titan siêu bền, camera 200MP.', 'https://vn-test-11.slatic.net/p/dfdfa1b2d45b54afcac1821eb1db5de4.jpg'),
(2, 'Samsung Galaxy S24 Plus', 24000000, 'Galaxy AI, pin 4900mAh, Exynos 2400.', 'https://vn-test-11.slatic.net/p/cfcfa1b2d45b54afcac1821eb1eb5de4.jpg'),
(2, 'Samsung Galaxy S24', 21000000, 'Man hinh nho gon, hieu nang cuc tot.', 'https://vn-test-11.slatic.net/p/efcfa1b2d45b54afcdcf821eb1fb5de4.jpg'),
(2, 'Samsung Galaxy Z Fold5', 38000000, 'Man hinh gap doc dao, Snapdragon 8 Gen 2.', 'https://vn-test-11.slatic.net/p/a1b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(2, 'Samsung Galaxy Z Flip5', 24000000, 'Gap vo so cuc xin, man hinh phu lon.', 'https://vn-test-11.slatic.net/p/b1b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(2, 'Samsung Galaxy A55', 10500000, 'Thiet ke metal, chong nuoc bui IP67.', 'https://vn-test-11.slatic.net/p/c1b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(2, 'Samsung Galaxy A35', 8500000, 'Man hinh Super AMOLED, pin 5000mAh.', 'https://vn-test-11.slatic.net/p/d1b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(2, 'Samsung Galaxy M14', 4000000, 'Pin 6000mAh siêu khong.', 'https://vn-test-11.slatic.net/p/e1b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),

(3, 'Xiaomi 14 Ultra', 32000000, 'Camera Leica, khung kim loai sieu ben.', 'https://sg-test-11.slatic.net/p/e2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(3, 'Xiaomi 14', 21000000, 'Snapdragon 8 Gen 3 mạnh mẽ.', 'https://sg-test-11.slatic.net/p/f2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(3, 'Xiaomi Redmi Note 13 Pro Plus', 10500000, 'Camera 200MP, sac nhanh 120W.', 'https://sg-test-11.slatic.net/p/g2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(3, 'Xiaomi Redmi Note 13', 5000000, 'Gia re hieu nang ngon trong phan khuc.', 'https://sg-test-11.slatic.net/p/h2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(3, 'Xiaomi POCO X6 Pro', 8500000, 'Lien quan den gaming muot ma, chip manh.', 'https://sg-test-11.slatic.net/p/i2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(3, 'Xiaomi POCO M6 Pro', 5500000, 'Pin trau, gia hoc sinh sinh vien.', 'https://sg-test-11.slatic.net/p/j2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(3, 'Xiaomi 13T Pro', 15000000, 'Leica Camera 50MP, sac sieu nhanh 120W.', 'https://sg-test-11.slatic.net/p/k2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),

(4, 'Oppo Find N3', 44000000, 'Man hinh gap chong chanh phang nhat.', 'https://sg-test-11.slatic.net/p/l2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(4, 'Oppo Find N3 Flip', 22000000, 'Camera Hasselblad cho mau sieu ao.', 'https://sg-test-11.slatic.net/p/m2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(4, 'Oppo Reno11 Pro', 16000000, 'Chuyen gia chan dung, thiet ke doc quuyen.', 'https://sg-test-11.slatic.net/p/n2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(4, 'Oppo Reno11', 11000000, 'Camera dac sac phuc vu quay vlog.', 'https://sg-test-11.slatic.net/p/o2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),

(5, 'Vivo X100 Pro', 25000000, 'Nhiep anh di dong vivo ZEISS dac sac.', 'https://sg-test-11.slatic.net/p/p2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(5, 'Vivo V30', 10500000, 'Thiet ke vong sang Aura.', 'https://sg-test-11.slatic.net/p/q2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg'),
(5, 'Vivo Y100', 7000000, 'Sac nhanh 80W, AMOLED 120Hz.', 'https://sg-test-11.slatic.net/p/r2b2dcfcfa1b2d45b54afcac1821eb1eb.jpg');
