/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;

import fr.solutec.model.Memo;
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
public class MemoDao {
    
    public static List<Memo> getAllMemoPrive(User user) throws SQLException {
        List<Memo> noteRapidePrive = new ArrayList<>();
        
        String sql = "SELECT * FROM note_rapide n INNER JOIN person p ON n.idperson = p.idperson WHERE n.idperson = ?";
        
        Connection connexion = AccessBd.getConnexion();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setInt(1, user.getId());
        
        ResultSet rs = prepare.executeQuery();
        while (rs.next()) {            
            Memo m = new Memo();
            m.setId(rs.getInt("id"));
            m.setContenu(rs.getString("contenu"));
            m.setDateCreation(rs.getDate("date_creation"));
            m.setPrive(rs.getBoolean("prive"));
            
            User u = new User();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setLogin(rs.getString("login"));
            
            m.setCreateur(u);
            noteRapidePrive.add(m);
        }
        return noteRapidePrive;
    }
    
    public static List<Memo> getAllMemoPublic() throws SQLException {
        List<Memo> noteRapidePublic = new ArrayList<>();
        
        String sql = "SELECT * FROM note_rapide n INNER JOIN person p ON n.idperson = p.idperson WHERE n.prive = 0";
        
        Connection connexion = AccessBd.getConnexion();
        Statement requete = connexion.createStatement();
        
        ResultSet rs = requete.executeQuery(sql);
        while (rs.next()) {            
            Memo m = new Memo();
            m.setId(rs.getInt("id"));
            m.setContenu(rs.getString("contenu"));
            m.setDateCreation(rs.getDate("date_creation"));
            m.setPrive(rs.getBoolean("prive"));
            
            User u = new User();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setLogin(rs.getString("login"));
            
            m.setCreateur(u);
            noteRapidePublic.add(m);
        }
        return noteRapidePublic;
    }
}
