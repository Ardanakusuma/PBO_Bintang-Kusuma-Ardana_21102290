package com.Bintang.PBO.Pertemuan3;

import java.util.Scanner;
public class MainUnguided {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        Unguided paket1 = new Unguided("Paket Kuota Internet XL Hemat Bermanfaat", "2 GB Kuota Utama  + 6 GB Kuota Area", 25000);
        Unguided paket2 = new Unguided("Paket Kuota Internet XL Medium is Premium", "4 GB Kuota Utama  + 11 GB Kuota Area", 40000);
        Unguided paket3 = new Unguided("Paket Kuota Internet XL W for Wumbo Jumbo", "10 GB Kuota Utama  + 25 GB Kuota Area", 80000);

        paket1.infoPaket();
        paket2.infoPaket();
        paket3.infoPaket();

        int lanjut = 1;
        int jumlah = 0;

        do {
            System.out.println();
            System.out.println("Tambahkan paket anda (1/2/3) : ");
            int pesanan = input.nextInt();

            if (pesanan == 1) {
                System.out.println("=== "+ paket1.namapaket + " telah ditambahkan ===");
                jumlah += paket1.getHarga();
            } else if (pesanan == 2) {
                System.out.println("=== "+ paket2.namapaket + " telah ditambahkan ===");
                jumlah += paket2.getHarga();
            } else if (pesanan == 3) {
                System.out.println("=== "+ paket3.namapaket + " telah ditambahkan ===");
                jumlah += paket3.getHarga();
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
