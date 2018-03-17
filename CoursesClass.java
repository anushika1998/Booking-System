/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roommanagement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author verma
 */
public class CoursesClass {
    
    String fName = "/home/verma/NetBeansProjects/RoomManagement/src/roommanagement/TimeTable.csv";
    
    public CoursesClass(){
        
    }
    
    public ArrayList<String> getCourses(){
        
	    
	    ArrayList<String> Courses = new ArrayList<String>();
	    
		try {
			BufferedReader br = new BufferedReader(new FileReader(fName));
                        String line;
		    while ((line = br.readLine()) !=null) {
		        String strar[] = line.split(",");
		        Courses.add(strar[1]);
		        System.out.println(strar[1]);
		                        // Here column 2
                        
		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
                System.out.println(Courses.toString());
                return Courses;
                
    }
    
    public int searchCourse(String course){
        ArrayList<String> list= this.getCourses();
        int len=list.size();
        for(int i =0 ; i<len ;i++){
            if(isRelated(list.get(i),course)){
                return i;
            }
        }
        return -1;
    }
    
    public boolean isRelated(String course1, String keyword){
        return course1.toLowerCase().contains(keyword.toLowerCase());
        
    }
    
    public String[] getDetails(int ind){
        String [] temp=new String[0];
	    
		try {
			BufferedReader br = new BufferedReader(new FileReader(fName));
                        String line;
                        int i=0;
		    while ((line = br.readLine()) !=null) {
		        String strar[] = line.split(",");
		        if(i==ind){
                            return strar;
                        }
		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return temp;
    }
    
    public String getDetailsText(int ind){
        String [] temp=this.getDetails(ind);
        //Mandatory/Elective,Course Name ,Course Code,Instructor,Credits,Acronym,Monday Time$Venue,Tueday Time$Venue,Wednesday Time$Venue,Thurday Time$Venue,Friday Time$Venue,Tut Day$Time$Venue,Lab Day$Time$Venue
        return (""+temp[0]+" "+temp[1]+" "+temp[2]+" Instructor: "+temp[3]+" Credits: "+temp[4]);
    }
    
}
