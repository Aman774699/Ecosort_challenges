/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud_operation;

import com.entity.Getset_Reg;
import java.sql.*;
import OurConnection.getconnect;

/**
 *
 * @author ASUS
 */
public class Registration$login {

    public boolean newRegistration(Getset_Reg Reg) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            con = getconnect.Getconnect();
            String sql = "insert into newuser values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, Reg.getFullname());
            ps.setString(2, Reg.getEmail());
            ps.setString(3, Reg.getMobile_No());
            ps.setString(4, Reg.getGender());
            ps.setString(5, Reg.getPassword());
            ps.setString(6, Reg.getConform_password());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void newLogin(Getset_Reg reg) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            con = getconnect.Getconnect();
            String sql = "Insert into Login  values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getEmail());
            ps.setString(2, reg.getConform_password());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean checkLogin(String Email,String Password)
    {
        try{
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="select * from login where E_mail=? and Password_=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, Password);
            ResultSet rs=ps.executeQuery();
          if(rs.next())
          {
                  return true;
          }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean checkMail(String Email)
    {
        try{
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="Select * from newuser where Email=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, Email);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    public boolean updatepassword(String Email,String password)
    {
        int n=0;
        try{
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="Update login set Password_=? where E_mail=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, Email);
             n=ps.executeUpdate();
            if(n>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    public boolean updatepassword1(String email,String password)
    {
        int n=0;
        try{
            Connection con=null;
            PreparedStatement ps=null;
            con=getconnect.Getconnect();
            String sql="update newuser set Password_=?,Conform_password=? where Email=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, password);
            ps.setString(3, email);
            n=ps.executeUpdate();
            if(n>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    public Getset_Reg getdata(String email)
    {
        Getset_Reg GR=new Getset_Reg();
        try{
            PreparedStatement ps=null;
            Connection con=null;
            con=getconnect.Getconnect();
            String sql="Select * from newuser where Email=?";
             ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                GR.setFullname(rs.getString(1));
                GR.setEmail(rs.getString(2));
//                GR.setMobile_No(rs.getInt(3));
                GR.setGender(rs.getString(4));
                return GR;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return GR;
    }
}
