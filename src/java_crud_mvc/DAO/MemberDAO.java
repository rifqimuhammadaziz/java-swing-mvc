/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_crud_mvc.DAO;

import java.util.List;
import java_crud_mvc.DAOImplement.MemberImpl;
import java_crud_mvc.Model.MemberModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_crud_mvc.Connection.DatabaseConnection;

/**
 *
 * @author Lenovo
 */
public class MemberDAO implements MemberImpl{
    
    Connection connection;
    
    final String INSERT = "INSERT INTO member (name, phonenumber, address, membertype) VALUES(?, ?, ?, ?);";
    final String UPDATE = "UPDATE member SET name=?, phonenumber=?, address=?, membertype=? WHERE id=?;";
    final String DELETE = "DELETE FROM member WHERE id=?;";
    final String SELECT = "SELECT * FROM member;";
    final String SEARCH = "SELECT * FROM member WHERE name LIKE ?;";

    public MemberDAO() {
        connection = (Connection) DatabaseConnection.connection();
    }

    @Override
    public void insert(MemberModel member) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, member.getName());
            statement.setString(2, member.getPhoneNumber());
            statement.setString(3, member.getAddress());
            statement.setString(4, member.getMemberType());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(MemberModel member) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, member.getName());
            statement.setString(2, member.getPhoneNumber());
            statement.setString(3, member.getAddress());
            statement.setString(4, member.getMemberType());
            statement.setInt(5, member.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<MemberModel> getAll() {
        List<MemberModel> listMember = null;
        try {
            listMember = new ArrayList<MemberModel>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT);
            while (result.next()) {
                MemberModel member = new MemberModel();
                member.setId(result.getInt("id"));
                member.setName(result.getString("name"));
                member.setPhoneNumber(result.getString("phonenumber"));
                member.setAddress(result.getString("address"));
                member.setMemberType(result.getString("membertype"));
                listMember.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMember;
    }

    @Override
    public List<MemberModel> getMember(String name) {
        List<MemberModel> listMember = null;
        try {
            listMember = new ArrayList<MemberModel>();
            PreparedStatement statement = connection.prepareStatement(SEARCH);
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                MemberModel member = new MemberModel();
                member.setId(result.getInt("id"));
                member.setName(result.getString("name"));
                member.setPhoneNumber(result.getString("phonenumber"));
                member.setAddress(result.getString("address"));
                member.setMemberType(result.getString("membertype"));
                listMember.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMember;
    }
    
}
