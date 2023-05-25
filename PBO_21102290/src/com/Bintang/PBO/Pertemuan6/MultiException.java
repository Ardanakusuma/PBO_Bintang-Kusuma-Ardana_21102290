package com.Bintang.PBO.Pertemuan6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Masukkan bilangan : ");
            int bilangan = input.nextInt();

            System.out.println("Masukkan pembaginya : ");
            int bilangan2 = input.nextInt();

            int hasil = bilangan/bilangan2;
            System.out.println(bilangan + " / " + bilangan2 + " = " + hasil + " (dibulatkan)");
        }

        //MultiException
//        catch ( ArithmeticException | InputMismatchException e){
//            System.out.println("Error. Tidak dapat diproses :(");
//        }

        //Multiple Catch
        catch ( ArithmeticException e){
            System.out.println("Error. Tidak dapat diproses :(");
        }
        catch (InputMismatchException e){
            System.out.println("Error. Masukkan angka saja :)");
        }

        System.out.println("Proses sudah selesai :)");
    }
}
