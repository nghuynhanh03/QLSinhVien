/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author Admin
 */
public class Nghanh {
    private int maCN;
    private String tenCN;

    public Nghanh(int maCN, String tenCN) {
        this.maCN = maCN;
        this.tenCN = tenCN;
    }

    public Nghanh() {
    }

    public Nghanh(String tenCN) {
        this.tenCN = tenCN;
    }

    public int getMaCN() {
        return maCN;
    }

    public void setMaCN(int maCN) {
        this.maCN = maCN;
    }

    public String getTenCN() {
        return tenCN;
    }

    public void setTenCN(String tenCN) {
        this.tenCN = tenCN;
    }
}
