package com.Bintang.PBO.Pertemuan6;

public class TryCatch {
    public static void main(String[] args) {
        // Membuat array
        int[] nomor = {1, 2, 3, 4, 5};

        try {
            System.out.println(nomor[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array melebihi batas!");
        }

        System.out.println("Proses Selesai!");
    }
}
