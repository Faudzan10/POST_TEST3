Sistem Reservasi Lapangan Mini Soccer
Deskripsi Program
Program ini adalah Sistem Reservasi Lapangan Mini Soccer berbasis console menggunakan bahasa Java. Fungsinya untuk mencatat, melihat, mengubah, dan menghapus data reservasi lapangan yang dilakukan oleh pengguna. Data reservasi tidak disimpan di database, tetapi sementara ditampung dalam ArrayList selama program berjalan. Struktur program sudah dipisahkan dengan menggunakan packages (main, model, service) sehingga lebih rapih sesuai konsep MVC sederhana.

Alur Program
1. Program dijalankan → menampilkan menu utama:

Tambah Reservasi
Lihat Reservasi
Ubah Reservasi
Hapus Reservasi
Keluar

2. Tambah Reservasi

User memasukkan: nama, tanggal, jam, dan durasi.
Ada validasi input (tidak boleh kosong, durasi harus angka lebih dari 0).
Data tersimpan ke dalam daftar reservasi.

3. Lihat Reservasi

Menampilkan semua reservasi yang sudah tersimpan.
Jika kosong → muncul pesan "Belum ada data reservasi".

4. Ubah Reservasi

User memilih nomor reservasi dari daftar.
Program menampilkan data lama → user bisa isi data baru (atau enter kosong jika tidak ingin diubah).
Data diperbarui sesuai input.

5. Hapus Reservasi

User memilih nomor reservasi dari daftar.
Program menghapus data tersebut dari daftar.

6. Keluar

User memilih menu keluar.
Program menampilkan pesan perpisahan → program berhenti.

Jadi alurnya sederhana: program jalan → tampilkan menu → user pilih → program proses → kembali ke menu, sampai user memilih keluar.
