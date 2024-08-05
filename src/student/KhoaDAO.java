/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

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
public class KhoaDAO {
    Statement statement;
    Connection con = MyConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int status;

    public ResultSet displayKhoa() {
        try {
            String sql = "select MAKHOA, TENKHOA from KHOA";
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int addKhoa(Khoa khoa) {
        try {
            String sql = "INSERT INTO KHOA(TENKHOA) VALUES(?)";
            //con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(sql);
            if (!khoa.getTenKhoa().isEmpty() && !isDuplicate(khoa.getTenKhoa())) {
                ps.setString(1, khoa.getTenKhoa());
                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    status = 1;
                } else {
                    status = -1;
                }
            } else {
                if (khoa.getTenKhoa().isEmpty()) {
                    status = -2;
                } else {
                    status = -3;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        return status;
    }

    private boolean isDuplicate(String cate) throws SQLException {
        String sql = "select TENKHOA from KHOA";
        statement = con.createStatement();
        rs = statement.executeQuery(sql);
        while (rs.next()) {
            if (cate.equalsIgnoreCase(rs.getString("TENKHOA"))) {
                return true;
            }
        }
        return false;
    }

    public int deleteKhoa(Khoa khoa) {
        String sql = "DELETE FROM KHOA where MAKHOA = ?";
        try {
            // con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, khoa.getMaKhoa());
            ps.executeUpdate();
            ps.close();
            status = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            status = -1;
        }
        return status;
    }

    public int updateKhoa(Khoa khoa) {
        String query = "UPDATE KHOA "
                + "SET TENKHOA = ? "
                + "WHERE MAKHOA = ?";
        //con = ConnectionFactory.getConnection();
        try {
            ps = con.prepareStatement(query);
            // set parameter values
            ps.setString(1, khoa.getTenKhoa());
            ps.setInt(2, khoa.getMaKhoa());
            ps.executeUpdate();
            status = 1;
        } catch (SQLException e) {
            status = -1;
        }
        return status;
    }
}
