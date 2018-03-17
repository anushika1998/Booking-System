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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author verma
 */
public class UserClass {
    
    private String Name;
    private String Email;
    private String type;
    
    private static final String USERNAME="root";
    private static final String PASSWORD="anushika";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/Management?useSSL=false";
    Connection con=null;
    public UserClass() throws ClassNotFoundException, SQLException{
        
          
        con=DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);  
       
    }
    
    public boolean Booking(String room_no, String purpose, int capacity, String date, String start, String end){
        try{
            
        Statement stmt=con.createStatement();  
        int rs=stmt.executeUpdate("insert into RoomsBooked( name, email, number, purpose, capacity, day, start_at, end_at) Values('"+this.Name+"','"+this.Email+"','"+room_no+"','"+purpose+"',"+capacity+",'"+date+"','"+start+"','"+end+"');"); 
        if(rs==1){
            System.out.println("done");
            return true;
        }
               
        }
        catch(SQLException e){
            System.out.println("notDone");
            return false;
            //System.err.println(e);
        }
        return false;    
    }
    
    public boolean StudentBooking(String room_no, String purpose, int capacity, String date, String start, String end){
        try{
            
        Statement stmt=con.createStatement();  
        int rs=stmt.executeUpdate("insert into Requests( name, email, number, purpose, capacity, day, start_at, end_at) Values('"+this.Name+"','"+this.Email+"','"+room_no+"','"+purpose+"',"+capacity+",'"+date+"','"+start+"','"+end+"');"); 
        if(rs==1){
            System.out.println("done");
            return true;
        }
               
        }
        catch(SQLException e){
            System.out.println("notDone");
            return false;
            //System.err.println(e);
        }
        return false;    
    }
    
    
    public boolean acceptingRequests(String s){
        System.out.println("hfxh");
        //String s="room: C32 , day: 2017-11-12 , from: 11:21:22 , till: 21:22:21";
        String segments[] = s.split(" ");
        String name=segments[1];
        String email=segments[3];    
        String room=segments[5];
        String purpose=segments[7];
        String capacity=segments[9];
        String day=segments[11];
        String from=segments[13];
        String till=segments[15];
        
        System.out.println(room+" "+day+" "+from+" "+till);
        try{
                
        Statement stmt=con.createStatement();  
        
        int rs1=stmt.executeUpdate("delete from Requests where number='"+room+"' AND day='"+day+"' AND start_at='"+from+"' AND end_at='"+till+"';");  
        int rs2=stmt.executeUpdate("insert into RoomsBooked( name, email, number, purpose, capacity, day, start_at, end_at) Values('"+this.Name+"','"+this.Email+"','"+room+"','"+purpose+"',"+capacity+",'"+day+"','"+from+"','"+till+"');");  
        System.out.println("ksjbfkask");
        if(rs1==1 && rs2==1){
            System.out.println("done");
            return true;
        }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            System.out.println("null");
        }
        return false;
    }
    
    
    public boolean isUserThere(String uname, String pwd) {
        try{
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select password from Login where email='"+uname.trim()+"';");  
        String answer=null;
        while(rs.next()){  
            answer=rs.getString(1);    

            if(answer.equals(pwd)){
                return true;
            }
            else{
                return false;
            }
        }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            return false;
        }
        return false;
    
    }
    
    
    
    public boolean rejectingRequests(String s){
        System.out.println("hfxh");
        //String s=""name: Anu email: jns@jns.com room: C11 purpose: testing capacity: y+" day: "+day+" from: "+start_at+" till: "+end_at";
        String segments[] = s.split(" ");
        String name=segments[1];
        String email=segments[3];    
        String room=segments[5];
        String purpose=segments[7];
        String capacity=segments[9];
        String day=segments[11];
        String from=segments[13];
        String till=segments[15];
        
        System.out.println(room+" "+day+" "+from+" "+till);
        try{
                
        Statement stmt=con.createStatement();  
        
        int rs1=stmt.executeUpdate("delete from Requests where number='"+room+"' AND day='"+day+"' AND start_at='"+from+"' AND end_at='"+till+"';");  
          
        System.out.println("ksjbfkask");
        if(rs1==1){
            System.out.println("done");
            return true;
        }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            System.out.println("null");
        }
        return false;
    }
    
    
    public ArrayList<String> UserRoomsBooked(){
        ArrayList<String> list=new ArrayList();
        try{
                
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select number, day,start_at,end_at from RoomsBooked where email='"+this.Email+"';");  
        
        
        while(rs.next()){  
            String room=rs.getString(1);
            String day=rs.getString(2);    
            String st=rs.getString(3);
            String end=rs.getString(4);
            
            if(day==null){
                System.out.println("no");
            }
            else{
                String answer= "room: "+room+" , day: "+day+" , from: "+st+" , till: "+end;
                list.add(answer);
            }
        }
        
        System.out.println(list.toString());
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            System.out.println("null");
        }
        return list;
        
    }
    
    
    public ArrayList<String> ShowRequests(){
        ArrayList<String> list=new ArrayList();
        try{
                
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select name, email, number, purpose, capacity, day, start_at, end_at from Requests ;");  
        
        
        while(rs.next()){  
            String name=rs.getString(1);
            String email=rs.getString(2);    
            String number=rs.getString(3);
            String purpose=rs.getString(4);
            String capacity=rs.getString(5);
            String day=rs.getString(6);
            String start_at=rs.getString(7);
            String end_at=rs.getString(8);
            
            if(day==null){
                System.out.println("no");
            }
            else{
                String answer= "name: "+name+" email: "+email+" room: "+number+" purpose: "+purpose+" capacity: "+capacity+" day: "+day+" from: "+start_at+" till: "+end_at;
                list.add(answer);
            }
        }
        
        System.out.println(list.toString());
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            System.out.println("null");
        }
        return list;
        
    }
    
    
    public boolean isRoomAvailable(String room,String day,String from,String till) {
        
            
                Date on_day=null;
                Date st_at=null,ed_at=null;
                Time startU=null,endU=null;
                try {
                    on_day=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(day);
                    DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    long ms = sdf.parse(from).getTime();
                    long ms2 = sdf.parse(till).getTime();
                    st_at =  sdf.parse(from);
                    ed_at =  sdf.parse(till);
                    startU = new Time(ms);
                    
                    endU = new Time(ms2);
                } catch (ParseException ex) {
                    System.out.println("parsing bc");
                }
                
        try{
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select day,start_at,end_at from RoomsBooked where number='"+room.trim()+"';");  
        String answer=null;
        
        
        while(rs.next()){  
            answer=rs.getString(1);    
            
            if(answer==null){
                return true;
            }
            else{
                SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
                Date date=rs.getDate(1);
                String d=sdfr.format(date);
                Time startD=rs.getTime(2);
                Time endD=rs.getTime(3);
                System.out.println(d+" dc "+day);
                if(d.equals(day)){
                    System.out.println("ashba");
                    if((startU.after(startD)&& endU.before(endD))||(startU.after(startD)&&endU.after(endD))||(startU.before(startD)&&endU.after(startD)) || (startU.equals(startD)&& endU.after(startD))||(startU.equals(startD)&& endU.equals(endD)) || (startU.after(startD) && endU.equals(endD))){
                        System.out.println("room not available");
                        return false;
                    }

                }
            }
        }
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            return true;
        }
        return true;
    
    }
    
    public boolean cancelRoom(String s){
        System.out.println("hfxh");
        //String s="room: C32 , day: 2017-11-12 , from: 11:21:22 , till: 21:22:21";
        String segments[] = s.split(" ");
        String room=segments[1];
        String day=segments[4];
        String from=segments[7];
        String till=segments[10];
        
        System.out.println(room+" "+day+" "+from+" "+till);
        try{
                
        Statement stmt=con.createStatement();  
        int rs=stmt.executeUpdate("delete from RoomsBooked where number='"+room+"' AND day='"+day+"' AND start_at='"+from+"' AND end_at='"+till+"';");  
        System.out.println("ksjbfkask");
        if(rs==1){
            System.out.println("done");
            return true;
        }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            System.out.println("null");
        }
        return false;
    }
    
    public boolean addUser(String email, String pwd, String type, String name){
        try{
        Statement stmt=con.createStatement();  
        int rs=stmt.executeUpdate("insert into Login( name, email, password, type) Values('"+name+"','"+email+"','"+pwd+"','"+type+"');"); 
        if(rs==1){
            System.out.println("done");
            return true;
        }
               
        }
        catch(SQLException e){
            System.out.println("notDone");
            return false;
            //System.err.println(e);
        }
        return false;        
    }
    
    
    
    public String getName(){
        return this.Name;
    }
    
    public String getEmail(){
        return this.Email;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(){
        String t=null;
        try{
            Statement stmt=con.createStatement();
            ResultSet rs;
            rs=stmt.executeQuery("select type from Login where email='"+this.Email+"';");  
            while(rs.next()){  
                t=rs.getString(1);    
            }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        
        this.type=t.trim();
    }
    
    public void setName(){
        String n=null;
        try{
            Statement stmt=con.createStatement();
            ResultSet rs;
            rs=stmt.executeQuery("select name from Login where email='"+this.Email+"';");  
            while(rs.next()){  
                n=rs.getString(1);    
            }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        
        this.Name=n.trim();
    }
    
    public void setEmail(String e){
        this.Email=e.trim();
    }
    
    public String getPassword(){
        
        String password=null;
        try{
            Statement stmt=con.createStatement();
            ResultSet rs;
            rs=stmt.executeQuery("select password from Login where email='"+this.Email+"';");  
            while(rs.next()){  
                password=rs.getString(1);    
            }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        return password;       
            
    }

    public boolean addCourse(String[] details) {
        String course=details[2];
        try{
        Statement stmt=con.createStatement();
        ResultSet result=stmt.executeQuery("select * from CoursesTaken where course='"+course+"' AND email='"+this.Email+"';");
        if(!result.next()){
            int rs=stmt.executeUpdate("insert into CoursesTaken( name, email, course) Values('"+this.Name+"','"+this.Email+"','"+course+"');"); 
            if(rs==1){
                System.out.println("done");
                return true;
            }
        }
        else{
            return false;
        }
               
        }
        catch(SQLException e){
            System.out.println("notDone");
            return false;
            //System.err.println(e);
        }
        return false;     
    }

    public boolean dropCourse(String[] details) {
        String course=details[2];        
        try{
        Statement stmt=con.createStatement();  
        int rs=stmt.executeUpdate("delete from CoursesTaken where course='"+course+"' AND email='"+this.Email+"';");  
        System.out.println("ksjbfkask");
        if(rs==1){
            System.out.println("done");
            return true;
        }
        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        catch(NullPointerException e){
            System.out.println("null");
        }
        return false;
    }
    
}
