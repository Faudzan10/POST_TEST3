package com.mycompany.reservasi_lapangan_minisoccer.model;

/**
 * Superclass Reservasi - Menerapkan Encapsulation
 * @author [Nama Anda]
 */
public class Reservasi {
    // Encapsulation: private properties
    private String namaPemesan;
    private String tanggal;
    private String jam;
    private int durasi;
    private double hargaPerJam;

    // Constructor
    public Reservasi(String namaPemesan, String tanggal, String jam, int durasi) {
        this.namaPemesan = namaPemesan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.durasi = durasi;
        this.hargaPerJam = 50000; // Harga dasar
    }

    // Getter methods
    public String getNamaPemesan() {
        return namaPemesan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public int getDurasi() {
        return durasi;
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    // Setter methods dengan validasi (Encapsulation)
    public void setNamaPemesan(String namaPemesan) {
        if (namaPemesan != null && !namaPemesan.trim().isEmpty()) {
            this.namaPemesan = namaPemesan;
        } else {
            System.out.println("Nama pemesan tidak boleh kosong!");
        }
    }

    public void setTanggal(String tanggal) {
        if (tanggal != null && !tanggal.trim().isEmpty()) {
            this.tanggal = tanggal;
        } else {
            System.out.println("Tanggal tidak boleh kosong!");
        }
    }

    public void setJam(String jam) {
        if (jam != null && !jam.trim().isEmpty()) {
            this.jam = jam;
        } else {
            System.out.println("Jam tidak boleh kosong!");
        }
    }

    public void setDurasi(int durasi) {
        if (durasi > 0) {
            this.durasi = durasi;
        } else {
            System.out.println("Durasi harus lebih dari 0!");
        }
    }

    protected void setHargaPerJam(double hargaPerJam) {
        if (hargaPerJam > 0) {
            this.hargaPerJam = hargaPerJam;
        }
    }

    // Method yang akan di-override oleh subclass
    public double hitungTotalBiaya() {
        return durasi * hargaPerJam;
    }

    // Method yang akan di-override oleh subclass
    public String infoReservasi() {
        return String.format("Nama: %s | Tanggal: %s | Jam: %s | Durasi: %d jam | Total: Rp %.0f",
                namaPemesan, tanggal, jam, durasi, hitungTotalBiaya());
    }

    @Override
    public String toString() {
        return infoReservasi();
    }
}