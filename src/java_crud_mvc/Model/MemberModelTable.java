/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_crud_mvc.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class MemberModelTable extends AbstractTableModel{
    
    List<MemberModel> listMember;

    public MemberModelTable(List<MemberModel> listMember) {
        this.listMember = listMember;
    }
    
    @Override
    public int getRowCount() {
        return listMember.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return listMember.get(rowIndex).getId();
            case 1: return listMember.get(rowIndex).getName();
            case 2: return listMember.get(rowIndex).getPhoneNumber();
            case 3: return listMember.get(rowIndex).getAddress();
            case 4: return listMember.get(rowIndex).getMemberType();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "ID/CODE";
            case 1: return "NAME";
            case 2: return "PHONE NUMBER";
            case 3: return "ADDRESS";
            case 4: return"MEMBER TYPE";
            default: return null;
        }
    }
    
}
