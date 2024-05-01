/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud_operation;

import java.net.ConnectException;
import java.sql.*;
import OurConnection.getconnect;
import com.entity.GetSet_Edit_Profile;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author ASUS
 */
public class Edit_profile$uploadimage {
    public boolean insertdata(GetSet_Edit_Profile GSEP)
    {
        try{
            File imagefile=new File(GSEP.getFilePath());
            FileInputStream fis=new FileInputStream(imagefile);
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="INSERT INTO user_profile (Profile_picture, E_mail, MOBILE_NO, username, Current_Location) VALUES (?, ?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setBinaryStream(1, fis,(int)(imagefile.length()));
            ps.setString(2, GSEP.getEmail());
            ps.setString(3, GSEP.getMobileNO());
            ps.setString(4, GSEP.getUsername());
            ps.setString(5, GSEP.getLocation());
            ps.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    public GetSet_Edit_Profile fetchdata(String email)
    {
      GetSet_Edit_Profile GEP=new GetSet_Edit_Profile();
        try{
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="select * from user_profile where E_mail=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
               GEP.setProfilepicture(rs.getBinaryStream(1).readAllBytes());
               GEP.setEmail(rs.getString(2));
               GEP.setMobileNO(rs.getString(3));
               GEP.setUsername(rs.getString(4));
               GEP.setLocation(rs.getString(5));
               return GEP;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
    }
        return GEP;
    
}
    
    public boolean updatedetails(GetSet_Edit_Profile GEP,String email)
    {
        try{
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="update user_profile set MOBILE_NO=?,username=?,Current_Location=? where E_mail=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, GEP.getMobileNO());
            ps.setString(2, GEP.getUsername());
            ps.setString(3, GEP.getLocation());
            ps.setString(4, email);
            ps.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
}