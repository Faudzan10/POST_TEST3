package com.mycompany.reservasi_lapangan_minisoccer.model;

/**
 * Subclass ReservasiVIP - extends Reservasi
 * Menerapkan Inheritance dan Method Overriding
 * @author [Nama Anda]
 */
public class ReservasiVIP extends Reservasi {
    private String fasilitasVIP;
    private double biayaTambahanVIP;

    // Constructor menggunakan super
    public ReservasiVIP(String namaPemesan, String tanggal, String jam, int durasi) {
        super(namaPemesan, tanggal, jam, durasi); // Keyword super
        this.fasilitasVIP = "Lapangan premium, AC, Sound system, Snack & minuman, Handuk";
        this.biayaTambahanVIP = 25000;
        setHargaPerJam(75000); // Harga dasar VIP
    }

    // Getter dan Setter
    public String getFasilitasVIP() {
        return fasilitasVIP;
    }

    public void setFasilitasVIP(String fasilitasVIP) {
        // Keyword this
        if (fasilitasVIP != null && !fasilitasVIP.trim().isEmpty()) {
            this.fasilitasVIP = fasilitasVIP;
        }
    }

    public double getBiayaTambahanVIP() {
        return biayaTambahanVIP;
    }

    public void setBiayaTambahanVIP(double biayaTambahanVIP) {
        if (biayaTambahanVIP >= 0) {
            this.biayaTambahanVIP = biayaTambahanVIP;
        }
    }

    // Override method hitungTotalBiaya dengan biaya tambahan
    @Override
    public double hitungTotalBiaya() {
        return super.hitungTotalBiaya() + (getDurasi() * biayaTambahanVIP);
    }

    // Override method infoReservasi
    @Override
    public String infoReservasi() {
        return String.format("[VIP] %s | Fasilitas VIP: %s | Biaya tambahan: Rp %.0f", 
                super.infoReservasi(), fasilitasVIP, getDurasi() * biayaTambahanVIP);
    }

    // Method khusus untuk reservasi VIP
    public void tampilkanKeuntungan() {
        System.out.println("⭐ Keuntungan Reservasi VIP:");
        System.out.println("   - Fasilitas premium: " + fasilitasVIP);
        System.out.println("   - Harga: Rp " + (getHargaPerJam() + biayaTambahanVIP) + "/jam");
        System.out.println("   - Pengalaman bermain yang eksklusif");
    }

    // Method tambahan untuk diskon member
    public double hitungDiskonMember(boolean isMember) {
        if (isMember) {
            return hitungTotalBiaya() * 0.1; // Diskon 10%
        }
        return 0;
    }
}