/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin1
 */
public class FileIO {
	public static <T> List<T> readFile(String fname){
		try {
			FileInputStream fileInputStream=new FileInputStream(fname);
			ObjectInputStream inputStream=new ObjectInputStream(fileInputStream);
			List<T> l=(List<T>)inputStream.readObject();
			inputStream.close();
			fileInputStream.close();
			return l;
		} catch (FileNotFoundException e) {
			List<T> l=new ArrayList<>();
			saveFile(fname, l);
			return l;
		} catch(IOException e){
			System.out.println(e);
		} catch(ClassNotFoundException e){
			System.out.println(e);
		}
		
		return null;
	}
	
	public static <T> void saveFile(String name,List<T> l){
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(name);
			ObjectOutputStream o=new ObjectOutputStream(fileOutputStream);
			o.writeObject(l);
			o.close();
			fileOutputStream.close();
		} catch(Exception e){
			System.out.println(e);
		}
	}
}
