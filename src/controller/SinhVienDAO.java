/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.FileIO;
import model.SinhVien;

/**
 *
 * @author admin
 */
public class SinhVienDAO {
   public static List<SinhVien> ls = new ArrayList<>();
   private static String name="./sv.dat";
   
    public int add(SinhVien sv){
      ls.add(sv);
	  FileIO.saveFile(name, ls);
      return 1;
    }

	public SinhVienDAO() {
		ls=FileIO.readFile(name);
	}
    
	
    public List<SinhVien> getAllSinhVien(){
      return ls;
    }
    
    public int delSinhVienByID(String ma){
       for(SinhVien sv : ls){
         if(sv.getMaSV().equalsIgnoreCase(ma)) {
           ls.remove(sv);
		   FileIO.saveFile(name, ls);
           return 1;
         }
       }
       return -1;
    }
    
    public SinhVien getSinhVienByID(String id){
        for (SinhVien sv : ls) {
            if (sv.getMaSV().equalsIgnoreCase(id)){
              return sv;
            }
        }
        return null;
    }
    
    public int updateSinhVienByID(SinhVien svNew){
        for (SinhVien sv : ls) {
            if(sv.getMaSV().equalsIgnoreCase(svNew.getMaSV())){
              sv.setDiaChi(svNew.getDiaChi());
              sv.setGioiTinh(svNew.isGioiTinh());
              sv.setHinhAnh(svNew.getHinhAnh());
              sv.setNgaySinh(svNew.getNgaySinh());
              sv.setTenSV(svNew.getTenSV());
			  FileIO.saveFile(name, ls);
              return 1;
            }          
        }
        return -1;
    }
}
