package com.Bintang.PBO.Pertemuan6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        jumlahBilangan operasi1 = new jumlahBilangan();

        try {
            System.out.println("Masukkan bilangan pertama \t : ");
            int bilangan1 = input.nextInt();

            System.out.println("Masukkan bilangan kedua \t : ");
            int bilangan2 = input.nextInt();

            operasi1.jumlahBilangan(bilangan1, bilangan2);
        }

        catch (InputMismatchException e){
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
        }
        catch (ArithmeticException e){
            System.out.println("Pembagian dengan nol tidak diperbolehkan.");
        }
    }
}
