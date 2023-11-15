/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.FileIO;
import model.User;

/**
 *
 * @author admin
 */
public class UserDAO {
    List<User> ls = new ArrayList<>();
	private static String name="./user.dat";

    public UserDAO() {
	ls = FileIO.readFile(name);
        ls.add(new User("admin", "123456", true));
        ls.add(new User("B19DCVT327", "123456", true));
        ls.add(new User("B19DCVT103", "123456", true));
        ls.add(new User("TINHTE227", "123456", true));
        ls.add(new User("TINHTE159", "123456", true));
	FileIO.saveFile(name, ls);
    }
   public boolean checkLogin(String username, String password){
       for (User u : ls) {
           if(u.getUsername().equals(username) && u.getPassword().equals(password)){
              return true;
           }
       }
       return false;
   }
}
