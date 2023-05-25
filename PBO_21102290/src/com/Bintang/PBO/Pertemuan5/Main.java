package com.Bintang.PBO.Pertemuan5;

public class Main {
    public static void main(String[] args) {
        // Membuat array kosong
        Barang[] keranjang = new Barang[10];

        // Membuat array dengan isinya
        Barang[] etalase = {
              new Barang("Indomie",3000),
              new Barang("Pulpen",3000),
              new Barang("Pensil",2500),
              new Barang("Spidol",5000),
              new Barang("Penghapus",4000)
        };

        // Menampilkan jumlah data dalam array
        System.out.println("Jumlah barang yang ada di etalase " + etalase.length);

        // Menampilkan jumlah data dalam array
        System.out.println("Daftar barang yang ada dalam etalase : ");

        // Perulangan for each untuk menampilkan data
        int i = 1;
        for (Barang b : etalase){
            System.out.println("Barang ke-" + i);
            b.showInfo();
            i++;
        }

        System.out.println();
        System.out.println("Daftar barang yang ada dalam etalase : ");
        for (int j = 0; j < etalase.length;j++){
            System.out.println("Barang ke-" + (j+1));
            etalase[j].showInfo();
        }
    }
}
