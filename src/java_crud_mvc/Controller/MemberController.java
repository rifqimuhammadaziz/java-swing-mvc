/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_crud_mvc.Controller;

import java.util.List;
import java_crud_mvc.DAO.MemberDAO;
import java_crud_mvc.DAOImplement.MemberImpl;
import java_crud_mvc.Model.MemberModel;
import java_crud_mvc.Model.MemberModelTable;
import java_crud_mvc.View.MemberView;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class MemberController {
    MemberView memberFrame;
    MemberImpl memberImpl;
    
    List<MemberModel> listMember;
    
    public MemberController(MemberView memberFrame) {
        this.memberFrame = memberFrame;
        memberImpl = new MemberDAO();
        listMember = memberImpl.getAll();
    }
    
    // Reset Button
    public void resetTextField() {
        memberFrame.getTxtID().setText("");
        memberFrame.getTxtMemberName().setText("");
        memberFrame.getTxtPhoneNumber().setText("");
        memberFrame.getTxtAddress().setText("");
        memberFrame.getCbMemberType().setSelectedItem("--- Choose Type ---");
    }
    
    // Fill Data Table
    public void fillTable() {
        listMember = memberImpl.getAll();
        MemberModelTable table = new MemberModelTable(listMember);
        memberFrame.getTblData().setModel(table);
    }
    
    // Show Data to Form while Clicked
    public void fillField(int row) {
        memberFrame.getTxtID().setText(listMember.get(row).getId().toString());
        memberFrame.getTxtMemberName().setText(listMember.get(row).getName());
        memberFrame.getTxtPhoneNumber().setText(listMember.get(row).getPhoneNumber());
        memberFrame.getTxtAddress().setText(listMember.get(row).getAddress());
        memberFrame.getCbMemberType().setSelectedItem(listMember.get(row).getMemberType());
    }
    
    // Insert Data Form to Database
    public void insert() {
        if (!memberFrame.getTxtMemberName().getText().trim().isEmpty() &&
                !memberFrame.getTxtPhoneNumber().getText().trim().isEmpty() &&
                !memberFrame.getTxtAddress().getText().trim().isEmpty() &&
                !memberFrame.getCbMemberType().getSelectedItem().equals("--- Choose Type ---")) {
            MemberModel member = new MemberModel();
            member.setName(memberFrame.getTxtMemberName().getText());
            member.setPhoneNumber(memberFrame.getTxtPhoneNumber().getText());
            member.setAddress(memberFrame.getTxtAddress().getText());
            member.setMemberType(memberFrame.getCbMemberType().getSelectedItem().toString());
            
            memberImpl.insert(member);
            JOptionPane.showMessageDialog(null, "Success Save Data!", "Success", 1);
        } else {
            JOptionPane.showMessageDialog(memberFrame, "Data cannot be null!", "Error", 0);
        }
    }
    
    // Update Data Form to Database 
    public void update() {
        if (!memberFrame.getTxtID().getText().trim().isEmpty()) {
            MemberModel member = new MemberModel();
            member.setName(memberFrame.getTxtMemberName().getText());
            member.setPhoneNumber(memberFrame.getTxtPhoneNumber().getText());
            member.setAddress(memberFrame.getTxtAddress().getText());
            member.setMemberType(memberFrame.getCbMemberType().getSelectedItem().toString());
            member.setId(Integer.parseInt(memberFrame.getTxtID().getText()));
            
            memberImpl.update(member);
            JOptionPane.showMessageDialog(null, "Success Update Data!", "Success", 0);
        } else {
            JOptionPane.showMessageDialog(memberFrame, "Data cannot be null!", "Error", 0);
        }
    }
    
    // Delete Data Table
    public void delete() {
        if (!memberFrame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(memberFrame.getTxtID().getText());
            memberImpl.delete(id);
            JOptionPane.showMessageDialog(null, "Success Delete Data!", "Success", 0);
        } else {
            JOptionPane.showMessageDialog(memberFrame, "Choose data!", "Error", 0);
        }
    }
    
    // Search Data
    public void fillSearchTable() {
        listMember = memberImpl.getMember(memberFrame.getTxtSearch().getText());
        MemberModelTable table = new MemberModelTable(listMember);
        memberFrame.getTblData().setModel(table);
    }
    
    // Get Search Data
    public void getData() {
        if (!memberFrame.getTxtSearch().getText().trim().isEmpty()) {
            memberImpl.getMember(memberFrame.getTxtSearch().getText());
            fillSearchTable();
        } else {
            JOptionPane.showMessageDialog(memberFrame, "Choose data!", "Error", 0);
        }
    }
}
