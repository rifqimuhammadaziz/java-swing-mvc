/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package java_crud_mvc.DAOImplement;

import java.util.List;
import java_crud_mvc.Model.MemberModel;

/**
 *
 * @author Lenovo
 */
public interface MemberImpl {
    
    public void insert(MemberModel member);
    
    public void update(MemberModel member);
    
    public void delete(int id);
    
    public List<MemberModel> getAll();
    
    public List<MemberModel> getMember(String name); 
}
