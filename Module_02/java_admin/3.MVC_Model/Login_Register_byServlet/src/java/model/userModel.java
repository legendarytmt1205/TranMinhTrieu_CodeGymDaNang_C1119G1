/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.aptech.ulti.MSSQLConnection;
import entity.User;

/**
 *
 * @author Trung
 */
public class userModel {

    public User user = new User();
    public MSSQLConnection db = new MSSQLConnection();

    public userModel(User user) {
        this.user.setUsername(user.getUsername());
        this.user.setPassword(user.getPassword());

    }
    
    public void insert(){
        String query = "Insert into dbo.login (userName,password) Values('"+ user.getUsername() 
                + "','" + user.getPassword()+"'" + ")";
        System.out.println(query);
        try{
            db.execute(query);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
