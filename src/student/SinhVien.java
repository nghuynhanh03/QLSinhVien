/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private String maSV;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String lop;
    private int maCN;
    private String tenCN;
    private String tenKhoa;
    private String email;
    private Double GPA;
    private InputStream hinhAnh;
    public SinhVien() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
    public int getMaCN() {
        return maCN;
    }

    public void setMaCN (int maCN) {
        this.maCN = maCN;
    }
    
    public String getTenCN() {
        return tenCN;
    }

    public void setTenCN (String tenCN) {
        this.tenCN = tenCN;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public InputStream getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(InputStream hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public SinhVien(String maSV, String hoTen, String gioiTinh, Date ngaySinh, String lop, int maCN, String tenCN, String tenKhoa, String email, Double GPA, InputStream hinhAnh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.maCN = maCN;
        this.tenCN = tenCN;
        this.tenKhoa = tenKhoa;
        this.email = email;
        this.GPA = GPA;
        this.hinhAnh = hinhAnh;
    }

    
    
    public SinhVien(String lop, String tenCN, String tenKhoa) {
        this.lop = lop;
        this.tenCN = tenCN;
        this.tenKhoa = tenKhoa;
    }
}
