package com.Bintang.PBO.Pertemuan3;

public class Main {
    public static void main(String[] args) {
        SepedaMotor honda = new SepedaMotor("Honda","Vario 160",35000000);
        SepedaMotor yamaha = new SepedaMotor("Yamaha","N Max",40000000);
        SepedaMotor vespa = new SepedaMotor("Vespa","Vespa Matic",60000000);

        /*
        // Mengisi nilai atribute object Honda
        honda.merk = "Honda";
        honda.tipe = "Vario 160";
        honda.harga = 35000000;

        // Mengisi nilai atribute object Yamaha

        yamaha.merk = "Yamaha";
        yamaha.tipe = "N Max";
        yamaha.harga = 40000000;

        // Mengisi nilai atribute object Vespa
        vespa.merk = "Vespa";
        vespa.tipe = "Vespa Matic";
        vespa.harga = 60000000;
         */

        // Untuk menjalankan method
        honda.showInfo();
        yamaha.showInfo();
        vespa.showInfo();

        // Uji coba getter dan setter
        System.out.println("Motor merk " + honda.getMerk() + " dengan tipe (sebelum) : " + honda.getTipe());
        honda.setTipe("Honda Beat");
        System.out.println("Motor merk " + honda.getMerk() + " dengan tipe (sesudah) : " + honda.getTipe());

    }
}