package com.Bintang.PBO.Pertemuan3;

public class Unguided {

    String namapaket;
    String benefit;
    int harga;

    public Unguided(String namapaket, String benefit, int harga) {
        this.namapaket = namapaket;
        this.benefit = benefit;
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void infoPaket() {
        System.out.println("Nama Paket : " + namapaket);
        System.out.println("Benefit : " + benefit);
        System.out.println("Harga : " + harga);
        System.out.println();
    }

}
