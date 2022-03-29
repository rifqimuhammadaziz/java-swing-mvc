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
        return switch (columnIndex) {
            case 0 -> listMember.get(rowIndex).getId();
            case 1 -> listMember.get(rowIndex).getName();
            case 2 -> listMember.get(rowIndex).getPhoneNumber();
            case 3 -> listMember.get(rowIndex).getAddress();
            case 4 -> listMember.get(rowIndex).getMemberType();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "ID/CODE";
            case 1 -> "NAME";
            case 2 -> "PHONE NUMBER";
            case 3 -> "ADDRESS";
            case 4 -> "MEMBER TYPE";
            default -> null;
        };
    }
    
}
