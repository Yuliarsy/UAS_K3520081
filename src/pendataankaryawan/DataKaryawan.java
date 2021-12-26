/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/**
 *
 * @author Yulia Rakhmah
 */

public class DataKaryawan implements Interfacess{

    private int d,m,y;
    
    // attribute dipakai statusnya
    public int statusKaryawan,JumlahAnak,usia,tunjanganKaryawan,tunjanganPegawai,tunjanganAnak,gajiKotor,potongan,
            gajiBersih ,gajiPokok;
    
    // atribute karyawan
    public String idKaryawan,namaKaryawan,alamatKaryawan,tgllahirKaryawan,golKaryawan;
    
    //attribute untuk cek status nikah,anak,umur
    boolean StatusTunjangan = false,StatusTK = false,StatusTP = false;
    ArrayList<DataKaryawan> data = new ArrayList<>();
    
    @Override
    public void addKaryawan(DataKaryawan dataKaryawan) {
        data.add(dataKaryawan);
    }
    
    boolean terhapus = false;
    @Override
    public void deleteKaryawan(String idk) {
        for(int i = 0; i < data.size(); i++){
            
            if(data.get(i).idKaryawan.equals(idk)){
                data.remove(i);
                terhapus = true;
                System.out.println("Karyawan berhasil dihapus dari data");
            }else{
                System.out.println("Kode karyawan tidak ada dalam data");
            }
        }
    }
    
    boolean ditemukan = false;
    int index = 0;
    @Override
    public void searchKaryawan(String idk) {
        for(int i = 0; i < data.size(); i++){            
            if(data.get(i).idKaryawan.equals(idk)){
                
                // mengambil index untuk menampilkan data
                index = i;
                ditemukan = true;
                
            }
        }
        
        // memanggil method print() jika data ditemukan
        if(ditemukan){
            data.get(index).print();
        }
    }

    @Override
    public void printKaryawan() {
        System.out.println("=============================================================================");
        System.out.println("                                DATA KARYAWAN                                ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("KODE" + "\t" + "NAMA" + "\t"+ "GOL"+ "\t"+  "USIA"+ "\t" + "STATUS NIKAH" + "\t" + "JUMLAH ANAK");
        System.out.println("-----------------------------------------------------------------------------");
        
        
        //looping print data
        for(int i=0; i < data.size(); i++){
            String kode = data.get(i).idKaryawan;
            String nama = data.get(i).namaKaryawan;
            String gol = data.get(i).golKaryawan;
            int usia = data.get(i).usia;
            String status = "Belum Menikah";
            int JmlAnak = 0;
            if( data.get(i).statusKaryawan == 1){
                status = "Sudah Menikah";
                JmlAnak = data.get(i).JumlahAnak;
            }else if( data.get(i).statusKaryawan == 0){
                status = "Belum Menikah";
                JmlAnak = 0;
            }
            
            //menampilkan output dari data
            System.out.println(kode + "\t" + nama + "\t"+ gol+ "\t"+ usia+"\t"+ status +"\t"+ JmlAnak );
        }
        
        System.out.println("-----------------------------------------------------------------------------");
        
        //menampilkan jumlah data karyawan dalam arraylist
        System.out.println("Jumlah Data : " + data.size());
    }
  
    DataKaryawan() {
    }
    // konstruktor
    DataKaryawan(String id, String nama, String alamat, String tgl, String golong, int status, int anak){
        this.idKaryawan = id;
        this.namaKaryawan = nama;
        this.alamatKaryawan = alamat;
        this.tgllahirKaryawan = tgl;
        this.golKaryawan = golong;
        this.statusKaryawan = status;
        this.JumlahAnak = anak;    
        // hitung usia karyawan
        String tgllahir =  this.tgllahirKaryawan;
        String[] lahir = tgllahir.split("-");
        y = Integer.parseInt(lahir[0] );
        m = Integer.parseInt(lahir[1] );
        d = Integer.parseInt(lahir[2] );
        
        LocalDate from = LocalDate.of(y, m, d);
        
        //mengambil tanggal saat ini
        LocalDate today = LocalDate.now();
        
        //hitung usia
        int umur = Period.between(from, today).getYears();
        this.usia = umur;
        
        
        // gaji pokok karyawan tergantung golongan
        switch (golKaryawan) {
            case "a":
            case "A":
                gajiPokok = 5000000;
                break;
            case "b":
            case "B":
                gajiPokok = 6000000;
                break;
            case "c":
            case "C":
                gajiPokok = 7000000;
                break;
        }
        
        
        // tunjangan status
        switch(statusKaryawan ){
            case 1 : 
                this.tunjanganKaryawan = gajiPokok*10/100;
                this.StatusTK = true;
                break;
        }
        
        // tunjangan anak
        switch(statusKaryawan){
            case 1 :
                if(JumlahAnak>0){
                    tunjanganAnak = JumlahAnak*gajiPokok*5/100;
                    StatusTunjangan = true;
                }
                break;
        }
        
        
        
        // tunjangan usia
        if(usia>30){
            tunjanganPegawai = gajiPokok*15/100;
            StatusTP = true;
            
        }

        
        
        
        // menentukan gaji kotor 
        gajiKotor = gajiPokok + tunjanganKaryawan + tunjanganPegawai+ tunjanganAnak;
        
        // pemotongan gaji
        potongan = gajiKotor*25/1000;
        
        // gaji bersih
        gajiBersih = gajiKotor - potongan;
        
    }

    
    
    // output cari data
    public void print(){
        System.out.println("=========================================================");
        System.out.println("                  DATA PROFIL KARYAWAN                   ");
        System.out.println("---------------------------------------------------------");

        System.out.println("Kode Karyawan           : " + idKaryawan);
        System.out.println("Nama Karyawan           : " + namaKaryawan);
        System.out.println("Golongan                : " + golKaryawan);
        System.out.println("Usia                    : " + usia);

        // status menikah dan jumlah anak 
        switch( statusKaryawan ){
            case 0 :
                System.out.println("Status Menikah          : Belum Menikah");
                System.out.println("---------------------------------------------------------");
                break;
            
            case 1 :
                System.out.println("Status Menikah          : Sudah Menikah");
                System.out.println("Jumlah Anak             : " + JumlahAnak);
                System.out.println("---------------------------------------------------------");
        }
        System.out.println("Gaji Pokok              : Rp" + gajiPokok);
        
        //pengecekan tunjangan
        if(StatusTK){
            System.out.println("Tunjangan Suami/Istri   : Rp" + tunjanganKaryawan );
        }if(StatusTP){
            System.out.println("Tunjangan Pegawai       : Rp" + tunjanganPegawai);
        }if(StatusTunjangan){
            System.out.println("Tunjangan Anak          : Rp" + tunjanganAnak); 
        }
        System.out.println("--------------------------------------------------------- +");
        System.out.println("Gaji Kotor              : Rp" + gajiKotor);
        System.out.println("Potongan                : Rp" + potongan);
        System.out.println("--------------------------------------------------------- -");
        System.out.println("Gaji Bersih             : Rp" + gajiBersih);
    }
}