/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;

import fr.solutec.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelg
 */
public class UserDao {
    
    public static void insertUser(User user) throws SQLException{
        String sql = "INSERT INTO person (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
        
        Connection connexion = AccessBd.getConnexion();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, user.getNom());
        requete.setString(2, user.getPrenom());
        requete.setString(3, user.getLogin());
        requete.setString(4, user.getPassword());
        
        requete.execute();
    }
    
    public static User getByLoginAndPassword(String login, String password) throws  SQLException {
        User u = null;
        String sql = "SELECT * FROM person WHERE login=? AND password=?";
        
        Connection connexion = AccessBd.getConnexion();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, login);
        requete.setString(2, password);
        ResultSet rs = requete.executeQuery();
        if(rs.next()){
            u = new User();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setLogin(rs.getString("login"));
        }
        return u;
    }
    
    
    public static List<User> getAll() throws  SQLException {
        List<User> users = new ArrayList<>() ;
        String sql = "SELECT * FROM person";
        
        Connection connexion = AccessBd.getConnexion();
        Statement requete = connexion.createStatement();
        
        ResultSet rs = requete.executeQuery(sql);
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setLogin(rs.getString("login"));
            
            users.add(u);
        }
        return users;
    }
    
}
