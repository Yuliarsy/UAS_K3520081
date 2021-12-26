/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

/**
 *
 * @author Yulia Rakhmah
 */
public interface Interfacess {
    int usia = 30;
    String golongan = "A";
    
    public void addKaryawan(DataKaryawan data);
    public void deleteKaryawan(String idk);
    public void searchKaryawan(String idk);
    public void printKaryawan();
}