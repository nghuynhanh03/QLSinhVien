/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SinhVienDAO {
    Statement statement;
    Connection con = MyConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int status;

    public ResultSet displayLop() {
        try {
            String sql = "select LOP, TENCN, TENKHOA from SINHVIEN";
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ResultSet displaySinhVien() {
        try {
            String sql = "select HOTEN, GIOITINH, NGAYSINH, LOP, TENCN, TENKHOA, EMAIL, GPA, HINHANH, MASV from SINHVIEN";
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int addSinhVien(SinhVien sv) {
        String sql = "INSERT INTO SINHVIEN(HOTEN, GIOITINH, NGAYSINH, LOP, TENCN, TENKHOA, EMAIL, GPA, HINHANH) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getGioiTinh());
            //
            java.util.Date utilDate = sv.getNgaySinh();
            java.sql.Date ngaySinh = new java.sql.Date(utilDate.getTime());
            ps.setDate(3, ngaySinh);
            //
            ps.setString(4, sv.getLop());
            ps.setString(5, sv.getTenCN());
            ps.setString(6, sv.getTenKhoa());
            ps.setString(7, sv.getEmail());
            ps.setDouble(8, sv.getGPA());
            ps.setBlob(9, sv.getHinhAnh());
            ps.executeUpdate();
            status = 1;

        } catch (SQLException e) {
            status = -1;
        } catch (NullPointerException ex) {
            status = -2;
        }
        return status;
    }

    public int deleteSinhVien(SinhVien sv) {
        String sql = "DELETE FROM SINHVIEN where MASV = ?";
        try {
            //con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.executeUpdate();
            ps.close();
            status = 1;
        } catch (SQLException e) {
            status = -1;
        }
        return status;
    }

    public int updateSinhVien(SinhVien sv) {
        String query = "UPDATE SINHVIEN "
                + "SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, LOP = ? , TENCN = ?, TENKHOA = ?, EMAIL = ?, GPA = ?"
                + "WHERE MASV = ?";
        try {
            ps = con.prepareStatement(query);
            // set parameter values
            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getGioiTinh());
            //
            java.util.Date utilDate = sv.getNgaySinh();
            java.sql.Date ngaySinh = new java.sql.Date(utilDate.getTime());
            ps.setDate(3, ngaySinh);
            //
            ps.setString(4, sv.getLop());
            ps.setString(5, sv.getTenCN());
            ps.setString(6, sv.getTenKhoa());
            ps.setString(7, sv.getEmail());
            ps.setDouble(8, sv.getGPA());
            ps.setBlob(9, sv.getHinhAnh());
            ps.setString(9, sv.getMaSV());
            ps.executeUpdate();
            status = 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            status = -1;
        }
        return status;
    }
    
}
