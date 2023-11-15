/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Grade implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private SinhVien sv;
    private double OOP,CNPM,CTDL;

    public Grade() {
    }

    public Grade(int id, SinhVien sv, double OOP, double CNPM, double CTDL) {
        this.id = id;
        this.sv = sv;
        this.OOP = OOP;
        this.CNPM = CNPM;
        this.CTDL = CTDL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public double getOOP() {
        return OOP;
    }

    public void setOOP(double OOP) {
        this.OOP = OOP;
    }

    public double getCNPM() {
        return CNPM;
    }

    public void setCNPM(double CNPM) {
        this.CNPM = CNPM;
    }

    public double getCTDL() {
        return CTDL;
    }

    public void setCTDL(double CTDL) {
        this.CTDL = CTDL;
    }
    
    public double getTBC(){
      return (getOOP()+getCNPM()+getCTDL())/3;
    }
    
    public String getXepLoai(){
      String xl = "";
      double tbc = getTBC();
      if(tbc>8){
        xl="Giỏi";
      }else if(tbc >=7){
        xl="Khá";
      }else if(tbc>=5){
        xl="Trung Bình";
      }
      else{
        xl="Yếu";
      }
      return xl;
    }
}
