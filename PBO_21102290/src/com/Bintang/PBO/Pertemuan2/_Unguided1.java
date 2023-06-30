package com.Bintang.PBO.Pertemuan2;

import java.util.Scanner;

public class _Unguided1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan username : ");
        String username = input.nextLine();

        System.out.println("Masukkan password : ");
        String password = input.nextLine();

        if (username.equals("bintangkusuma") && password.equals("pbo90")){
            System.out.println("Login berhasil silahkan masuk");
        } else if (username.equals("bintangkusuma") || password.equals("pbo90")){
            System.out.println("Silahkan login dengan username dan password yang sah!");
        } else {
            System.out.println("Username dan password anda salah!");
        }
    }
}
