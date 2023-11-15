/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.FileIO;
import model.Grade;

/**
 *
 * @author admin
 */
public class GradeDAO {
    List<Grade> ls = new ArrayList<>();
    private static String name="./grade.dat";
	
    public int add(Grade d){
      ls.add(d);
	  FileIO.saveFile(name, ls);
      return 1;
    }

	public GradeDAO() {
		ls = FileIO.readFile(name);
	}
    
    public List<Grade> getAllGrade(){
     return ls;
    }
    
    public Grade getOneGradeByMaSV(String masv){
        for (Grade d : ls) {
            if(d.getSv().getMaSV().equalsIgnoreCase(masv)){
              return d;
            }
        }
        return null;
    }
    
    public int updateGrade(Grade dNew){
        for (Grade d : ls) {
            if(d.getSv().getMaSV().equalsIgnoreCase(dNew.getSv().getMaSV())){
              d.setOOP(dNew.getOOP());
              d.setCNPM(dNew.getCNPM());
              d.setCTDL(dNew.getCTDL());
			  FileIO.saveFile(name, ls);
              return 1;
            }        
        }
        return -1;
    }
    
    public int delGrade(String masv){
      Grade d =  getOneGradeByMaSV(masv);
      if(d!=null){
        ls.remove(d);
		FileIO.saveFile(name, ls);
        return 1;
      }
      return -1;
    }
}
