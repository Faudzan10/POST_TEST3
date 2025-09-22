package com.mycompany.reservasi_lapangan_minisoccer.model;

/**
 * Subclass ReservasiReguler - extends Reservasi
 * Menerapkan Inheritance dan Method Overriding
 * @author [Nama Anda]
 */
public class ReservasiReguler extends Reservasi {
    private String fasilitas;

    // Constructor menggunakan super
    public ReservasiReguler(String namaPemesan, String tanggal, String jam, int durasi) {
        super(namaPemesan, tanggal, jam, durasi); // Keyword super
        this.fasilitas = "Lapangan standar, Air mineral";
        setHargaPerJam(50000); // Harga reguler
    }

    // Getter dan Setter
    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        // Keyword this
        if (fasilitas != null && !fasilitas.trim().isEmpty()) {
            this.fasilitas = fasilitas;
        }
    }

    // Override method infoReservasi
    @Override
    public String infoReservasi() {
        return String.format("[REGULER] %s | Fasilitas: %s", 
                super.infoReservasi(), fasilitas);
    }

    // Method khusus untuk reservasi reguler
    public void tampilkanKeuntungan() {
        System.out.println("✅ Keuntungan Reservasi Reguler:");
        System.out.println("   - Harga terjangkau Rp 50.000/jam");
        System.out.println("   - Fasilitas: " + fasilitas);
        System.out.println("   - Cocok untuk bermain santai");
    }
}