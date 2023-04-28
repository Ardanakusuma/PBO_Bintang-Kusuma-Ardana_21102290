package com.Bintang.PBO.Pertemuan4;

public class PaketData {
    String namapaket;
    String benefit;
    int harga;

    public int getHarga() {
        return harga;
    }

    public void infoPaket() {
        System.out.println();
        System.out.println("Nama Paket : " + namapaket);
        System.out.println("Benefit : " + benefit);
        System.out.println("Harga : " + harga);
    }

    public void infoTambah(){
        System.out.println("Batas pakai : tanpa batas ");
    }

}
