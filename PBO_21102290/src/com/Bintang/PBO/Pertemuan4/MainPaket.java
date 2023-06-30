package com.Bintang.PBO.Pertemuan4;

import java.util.Scanner;
public class MainPaket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PaketData paket1 = new PaketData();
        PaketDataBerbatas paket2 = new PaketDataBerbatas();

        paket1.namapaket = "Paket Data Biasa ";
        paket1.benefit = "Kuota Utama 10 GB";
        paket1.harga = 25000;

        paket2.namapaket = "Paket Data Malam";
        paket2.benefit = "Kuota Malam 15 GB";
        paket2.harga = 10000;

        paket1.infoPaket();
        paket1.infoTambah();
        paket2.infoPaket();
        paket2.infoTambah("Jam 1 s/d 6");

        int lanjut;
        int jumlah = 0;

        do {
            System.out.println();
            System.out.println("Tambahkan paket anda (1/2) : ");
            int pesanan = input.nextInt();

            if (pesanan == 1) {
                System.out.println("=== "+ paket1.namapaket + " telah ditambahkan ===");
                jumlah += paket1.getHarga();
            } else if (pesanan == 2) {
                System.out.println("=== "+ paket2.namapaket + " telah ditambahkan ===");
                jumlah += paket2.getHarga();
            } else {
                System.out.println("Masukkan jenis paket yang tersedia!");
            }

            System.out.println();

            System.out.println("Tambah pesanan? (1/0)");
            lanjut = input.nextInt();

            if (lanjut==0) {
                break;
            }

        } while (lanjut==1);

        System.out.println();
        System.out.println("=== Pesanan selesai! Jumlah tagihan yang harus dibayar : " + jumlah + " ===");
    }
}
