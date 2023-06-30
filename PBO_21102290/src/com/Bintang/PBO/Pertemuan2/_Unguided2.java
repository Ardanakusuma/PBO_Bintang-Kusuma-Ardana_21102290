package com.Bintang.PBO.Pertemuan2;

import java.util.Scanner;

public class _Unguided2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan nama anda : ");
        String nama = input.nextLine();

        System.out.println("Gaji yang diterima oleh " + nama + " adalah sebagai berikut");

        System.out.println("Gaji = ");
        double Gaji = input.nextDouble();

        System.out.println("Tunjangan = ");
        double Tunjangan = input.nextDouble();

        System.out.println("Pajak = 7.65%" );
        double Pajak = 0.0765;

        double Gaji_kotor = Gaji + Tunjangan;
        double Pajak_negara = Gaji_kotor * Pajak;
        double Gaji_bersih = Gaji_kotor - Pajak_negara;

        System.out.println("Gaji_kotor = " + Gaji_kotor);
        System.out.println("Pajak_negara = " + Pajak_negara);
        System.out.println("Gaji_bersih = " + Gaji_bersih);

        System.out.println("Total gaji bersih dari " + nama + " yang diterima yaitu " + Gaji_bersih );
    }
}
