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
public class NghanhDAO {
    Statement statement;
    Connection con = MyConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int status;
    
    public ResultSet displayNghanh() {
        try {
            String sql = "select MACN, TENCN from NGHANH";
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private boolean isDuplicate(String cate) throws SQLException {
        String sql = "select TENCN from NGHANH";
        statement = con.createStatement();
        rs = statement.executeQuery(sql);
        while (rs.next()) {
            if (cate.equalsIgnoreCase(rs.getString("TENCN"))) {
                return true;
            }
        }
        return false;
    }
    public int addCN(Nghanh n) {
        try {
            String sql = "INSERT INTO NGHANH(TENCN) VALUES(?)";
            //con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(sql);
            if (!n.getTenCN().isEmpty() && !isDuplicate(n.getTenCN())) {
                ps.setString(1, n.getTenCN());
                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    status = 1;
                } else {
                    status = -1;
                }
            } else {
                if (n.getTenCN().isEmpty()) {
                    status = -2;
                } else {
                    status = -3;
                }
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        return status;
    }
    public int updateTenCN(Nghanh n) {
        String query = "UPDATE NGHANH "
                + "SET TENCN = ? "
                + "WHERE MACN = ?";
        try {
            ps = con.prepareStatement(query);
            // set parameter values
            ps.setString(1, n.getTenCN());
            ps.setInt(2, n.getMaCN());
            ps.executeUpdate();
            status = 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            status = -1;
        }
        return status;
    }
    public int deleteTenCN(Nghanh n) {
        String sql = "DELETE FROM NGHANH where MACN = ?";
         try {
            //con = ConnectionFactory.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, n.getMaCN());
            ps.executeUpdate();
            ps.close();
            status = 1;
        } catch (SQLException e) {
            status = -1;
        }
        return status;
    }
}
