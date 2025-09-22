package com.mycompany.reservasi_lapangan_minisoccer.service;

import com.mycompany.reservasi_lapangan_minisoccer.model.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Service untuk mengelola CRUD Reservasi dengan konsep OOP
 * @author [Nama Anda]
 */
public class ReservasiService {
    private ArrayList<Reservasi> daftarReservasi;
    private Scanner scanner;

    public ReservasiService() {
        this.daftarReservasi = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void tambahReservasi() {
        System.out.println("\n=== TAMBAH RESERVASI ===");
        
        try {
            // Input nama dengan loop sampai benar
            String nama;
            while (true) {
                System.out.print("Nama Pemesan: ");
                nama = scanner.nextLine().trim();
                if (!nama.isEmpty()) {
                    break;
                }
                System.out.println("Nama tidak boleh kosong!");
            }

            // Input tanggal dengan loop sampai benar
            String tanggal;
            while (true) {
                System.out.print("Tanggal (dd-mm-yyyy): ");
                tanggal = scanner.nextLine().trim();
                if (!tanggal.isEmpty()) {
                    break;
                }
                System.out.println("Tanggal tidak boleh kosong!");
            }

            // Input jam dengan loop sampai benar
            String jam;
            while (true) {
                System.out.print("Jam mulai (HH:MM): ");
                jam = scanner.nextLine().trim();
                if (!jam.isEmpty()) {
                    break;
                }
                System.out.println("Jam tidak boleh kosong!");
            }

            // Input durasi dengan loop sampai benar
            int durasi;
            while (true) {
                try {
                    System.out.print("Durasi (jam): ");
                    durasi = scanner.nextInt();
                    if (durasi > 0) {
                        break;
                    }
                    System.out.println("Durasi harus lebih dari 0!");
                } catch (InputMismatchException e) {
                    System.out.println("Durasi harus berupa angka!");
                    scanner.next();
                }
            }
            scanner.nextLine();

            // Pilihan jenis reservasi dengan loop sampai benar
            int jenisReservasi;
            while (true) {
                try {
                    System.out.println("\nPilih jenis reservasi:");
                    System.out.println("1. Reguler (Rp 50.000/jam)");
                    System.out.println("2. VIP (Rp 100.000/jam)");
                    System.out.print("Pilihan (1-2): ");
                    jenisReservasi = scanner.nextInt();
                    scanner.nextLine();
                    if (jenisReservasi == 1 || jenisReservasi == 2) {
                        break;
                    }
                    System.out.println("Pilihan harus 1 atau 2!");
                } catch (InputMismatchException e) {
                    System.out.println("Pilihan harus berupa angka!");
                    scanner.nextLine();
                }
            }

            // Polymorphism - membuat objek berdasarkan pilihan
            Reservasi reservasiBaru;
            if (jenisReservasi == 1) {
                reservasiBaru = new ReservasiReguler(nama, tanggal, jam, durasi);
                System.out.println("\nKeuntungan Reservasi Reguler:");
                ((ReservasiReguler) reservasiBaru).tampilkanKeuntungan();
            } else {
                reservasiBaru = new ReservasiVIP(nama, tanggal, jam, durasi);
                System.out.println("\nKeuntungan Reservasi VIP:");
                ((ReservasiVIP) reservasiBaru).tampilkanKeuntungan();
                
                // Fitur khusus VIP - diskon member
                System.out.print("\nApakah Anda member VIP? (y/n): ");
                String isMemberInput = scanner.nextLine().trim().toLowerCase();
                if (isMemberInput.equals("y")) {
                    double diskon = ((ReservasiVIP) reservasiBaru).hitungDiskonMember(true);
                    System.out.printf("Selamat! Anda mendapat diskon member: Rp %.0f\n", diskon);
                }
            }

            daftarReservasi.add(reservasiBaru);
            System.out.println("\nReservasi berhasil ditambahkan!");
            // Method override - akan memanggil versi yang sesuai
            System.out.println("Detail: " + reservasiBaru.infoReservasi());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void lihatReservasi() {
        System.out.println("\n=== DAFTAR RESERVASI ===");
        
        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada data reservasi.");
            return;
        }

        double totalPendapatan = 0;
        int jumlahReguler = 0;
        int jumlahVIP = 0;
        
        for (int i = 0; i < daftarReservasi.size(); i++) {
            Reservasi reservasi = daftarReservasi.get(i);
            // Method override - format berbeda untuk setiap jenis
            System.out.printf("%d. %s\n", (i + 1), reservasi.infoReservasi());
            
            totalPendapatan += reservasi.hitungTotalBiaya();
            
            // instanceof untuk mengecek jenis objek
            if (reservasi instanceof ReservasiReguler) {
                jumlahReguler++;
            } else if (reservasi instanceof ReservasiVIP) {
                jumlahVIP++;
            }
        }
        
        System.out.println("\n=== STATISTIK ===");
        System.out.printf("Total Reservasi: %d\n", daftarReservasi.size());
        System.out.printf("Reguler: %d | VIP: %d\n", jumlahReguler, jumlahVIP);
        System.out.printf("Total Pendapatan: Rp %.0f\n", totalPendapatan);
    }

    public void ubahReservasi() {
        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada data reservasi untuk diubah.");
            return;
        }

        System.out.println("\n=== UBAH RESERVASI ===");
        lihatReservasi();
        
        try {
            System.out.print("\nPilih nomor reservasi yang ingin diubah: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();

            if (nomor < 1 || nomor > daftarReservasi.size()) {
                System.out.println("Error: Nomor reservasi tidak valid!");
                return;
            }

            Reservasi reservasi = daftarReservasi.get(nomor - 1);
            System.out.println("Data saat ini: " + reservasi.infoReservasi());

            System.out.println("\nPilih data yang ingin diubah:");
            System.out.println("1. Nama Pemesan");
            System.out.println("2. Tanggal");
            System.out.println("3. Jam");
            System.out.println("4. Durasi");
            System.out.print("Pilihan (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.printf("Nama saat ini (%s): ", reservasi.getNamaPemesan());
                    String namaBaru = scanner.nextLine().trim();
                    if (!namaBaru.isEmpty()) {
                        // Menggunakan setter dengan validasi (Encapsulation)
                        reservasi.setNamaPemesan(namaBaru);
                    }
                    break;
                case 2:
                    System.out.printf("Tanggal saat ini (%s): ", reservasi.getTanggal());
                    String tanggalBaru = scanner.nextLine().trim();
                    if (!tanggalBaru.isEmpty()) {
                        reservasi.setTanggal(tanggalBaru);
                    }
                    break;
                case 3:
                    System.out.printf("Jam saat ini (%s): ", reservasi.getJam());
                    String jamBaru = scanner.nextLine().trim();
                    if (!jamBaru.isEmpty()) {
                        reservasi.setJam(jamBaru);
                    }
                    break;
                case 4:
                    System.out.printf("Durasi saat ini (%d jam): ", reservasi.getDurasi());
                    try {
                        int durasiBaru = scanner.nextInt();
                        if (durasiBaru > 0) {
                            reservasi.setDurasi(durasiBaru);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Durasi harus berupa angka!");
                    }
                    break;
                default:
                    System.out.println("Error: Pilihan tidak valid!");
                    return;
            }

            System.out.println("Reservasi berhasil diubah!");
            System.out.println("Data baru: " + reservasi.infoReservasi());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void hapusReservasi() {
        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada data reservasi untuk dihapus.");
            return;
        }

        System.out.println("\n=== HAPUS RESERVASI ===");
        lihatReservasi();

        try {
            System.out.print("\nPilih nomor reservasi yang ingin dihapus: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();

            if (nomor < 1 || nomor > daftarReservasi.size()) {
                System.out.println("Error: Nomor reservasi tidak valid!");
                return;
            }

            Reservasi reservasiDihapus = daftarReservasi.remove(nomor - 1);
            System.out.println("Reservasi berhasil dihapus!");
            System.out.println("Data yang dihapus: " + reservasiDihapus.infoReservasi());

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    public void tutupScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}