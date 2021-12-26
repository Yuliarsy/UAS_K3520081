/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.util.Scanner;

/**
 *
 * @author Yulia Rakhmah
 */
public class main {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {

        //attribute pengecekan untuk looping
        boolean cekmenu = true;
        DataKaryawan dataK = new DataKaryawan();
        
        while( cekmenu ){    
            System.out.println("---- Menu Program ----");
            System.out.println("1.Tambah data");
            System.out.println("2.Hapus Data");
            System.out.println("3.Cari Data");
            System.out.println("4.Lihat Data");
            System.out.println("5.Exit");
            Scanner input = new Scanner( System.in );
            System.out.print("Menu pilihan: ");
            int inp = input.nextInt();
            switch(inp){
                case 1 : 
                    boolean adddata = true;
                    while( adddata ){
                        System.out.println("");
                        System.out.println("================================================================");
                        System.out.println("                           Menu Tambah Data                     ");
                        System.out.println("================================================================");
                        String cb = input.nextLine();
                        
                        //input nama karyawan
                        System.out.print("Masukan Kode Karyawan                 : ");
                        String kode_karyawan = input.nextLine();
                        
                        //input alamat karyawan
                        System.out.print("Masukan Nama Karyawan                 : ");
                        String nama_karyawan = input.nextLine();
                        
                        //input alamat karyawan
                        System.out.print("Masukan Alamat                        : ");
                        String alamat = input.nextLine();
                        
                        //input tanggal lagir karyawan
                        System.out.print("Masukan Tanggal Lahir (yyyy-mm-dd)    : ");
                        String tanggal_lahir = input.nextLine();
                        
                        //input golongan karyawan
                        System.out.print("Masukan Golongan (A/B/C)              : ");
                        String golongan = input.nextLine();
                        
                        //input status karyawan sudah menikah atau belum
                        System.out.println("Masukan Status Menikah ");
                        System.out.print("(0. belum menikah , 1. sudah menikah) : ");
                        int statusKar = input.nextInt();
                        
                        //attribut untuk jumlah anak
                        int jumlahAnak;
                        if( statusKar == 1 ){
                            System.out.print("Jumlah Anak                           : ");
                            jumlahAnak = input.nextInt();
                        } else {
                            statusKar = 0;
                            jumlahAnak = 0;
                        }
                        

                        //data akan dimasukkan ke class Data
                        //dan nantinya akan di masukkan ke arraylist
                        DataKaryawan karyawan = new DataKaryawan(
                                kode_karyawan,
                                nama_karyawan,
                                alamat,
                                tanggal_lahir,
                                golongan,
                                statusKar,
                                jumlahAnak
                        );
                        
                        // data ditambahkan ke array list
                        dataK.addKaryawan(karyawan);
                        
                        //input submenu
                        System.out.println("\n");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1. Kembali ke menu utama");
                        System.out.println("2. Tambah Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        //cek inputan submenu
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            adddata = false;
                        }else if(inpSub != 2) {
                            System.out.println("Pilihan menu tidak tersedia");
                        }  
                    }
                    break;
                
                    
                case 2 : 
                    boolean inpHapus = true;
                    while( inpHapus ) {
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("                 Hapus Data                ");
                        System.out.println("===========================================");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan kode karyawan yg akan di hapus: ");
                        String kode_karyawan = input.nextLine();
                        
                        // menghapus data karyawan 
                        dataK.deleteKaryawan(kode_karyawan);
                        

                        //input submenu
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1. Kembali ke menu utama");
                        System.out.println("2. Hapus Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        //cek inputan submenu
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            inpHapus = false;
                        } else if(inpSub != 2) {
                            System.out.println("Pilihan menu tidak tersedia");
                        }
                        
                    }
                    break;
                
                case 3 :                     
                    boolean menu_cari_data = true;
                    while( menu_cari_data ){
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("                 Cari Data                 ");
                        System.out.println("===========================================");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan Kode Karyawan : ");
                        String inputID = input.nextLine();

                        // mencari ID karywan
                        dataK.searchKaryawan(inputID);

                        //input submenu
                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("1.Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            menu_cari_data = false;
                        } else{
                            System.out.println("pilihan sub menu tidak ada");
                        }
                    }
                    break;
                
                case 4 : 
                    boolean perint = true;
                    while( perint ){
                        //menampilkan data karyawan
                        dataK.printKaryawan();
                        
                        
                        //input submenu
                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("1.Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");

                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            perint = false;
                        } else {
                            System.out.println("Pilihan menu tidak tersedia");
                        }
                    }
                    break;

                    
                case 5 : 
                    System.exit(0);
                
                default: 
                    System.out.println("Menu yang anda pilih tidak tersedia");
                    System.out.println("");
                
            }   
            
        }
    }
    
}