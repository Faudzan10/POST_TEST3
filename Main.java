package com.mycompany.reservasi_lapangan_minisoccer;

import com.mycompany.reservasi_lapangan_minisoccer.service.ReservasiService;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class - Sistem Reservasi Lapangan Mini Soccer
 * Implementasi konsep OOP: Encapsulation, Inheritance, Override
 * @author [Nama Anda]
 */
public class Main {
    public static void main(String[] args) {
        ReservasiService service = new ReservasiService();
        Scanner scanner = new Scanner(System.in);
        

        
        while (true) {
            System.out.println("\nMENU UTAMA RESEVASI ZANOD MINI SOCCER:");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Lihat Reservasi");
            System.out.println("3. Ubah Reservasi");
            System.out.println("4. Hapus Reservasi");
            System.out.println("5. Keluar");
            System.out.print("\nPilih menu (1-5): ");
            
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (pilihan) {
                    case 1:
                        service.tambahReservasi();
                        break;
                    case 2:
                        service.lihatReservasi();
                        break;
                    case 3:
                        service.ubahReservasi();
                        break;
                    case 4:
                        service.hapusReservasi();
                        break;
                    case 5:
                        System.out.println("Terima kasih!");
                        service.tutupScanner();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka! Silakan coba lagi.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

}
