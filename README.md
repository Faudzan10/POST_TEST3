Sistem Reservasi Lapangan Mini Soccer
Deskripsi Program
Program ini adalah Sistem Reservasi Lapangan Mini Soccer berbasis console menggunakan bahasa Java. Fungsinya untuk mencatat, melihat, mengubah, dan menghapus data reservasi lapangan yang dilakukan oleh pengguna. Data reservasi tidak disimpan di database, tetapi sementara ditampung dalam ArrayList selama program berjalan. Struktur program sudah dipisahkan dengan menggunakan packages (main, model, service) sehingga lebih rapih sesuai konsep MVC sederhana.

Alur Program
1. Program dijalankan → menampilkan menu utama:

- Tambah Reservasi
- Lihat Reservasi
- Ubah Reservasi
- Hapus Reservasi
- Keluar

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

===========================================================
**PENJELASAN KODE PROGRAM**

**1. Class Reservasi.java (Superclass)**

<img width="977" height="712" alt="image" src="https://github.com/user-attachments/assets/ca494575-1c0e-4c85-8d9b-93a1c64cf1eb" />

<img width="946" height="749" alt="image" src="https://github.com/user-attachments/assets/ff33de68-f7ca-425f-82c0-750663a0b86a" />

<img width="1002" height="725" alt="image" src="https://github.com/user-attachments/assets/063dffe9-60f5-4283-b946-52af8d200162" />

- Penjelasan:

  - Private attributes: Menerapkan encapsulation untuk melindungi data
  - Constructor: Inisialisasi objek dengan parameter yang diperlukan
  - Getter/Setter: Akses aman ke data dengan validasi di setter
  - Method dasar: hitungTotalBiaya() dan infoReservasi() yang akan di-override


**2. Class ReservasiReguler.java (Subclass)**

  <img width="937" height="667" alt="image" src="https://github.com/user-attachments/assets/c38f6b83-e4f1-4873-b588-27d449100872" />

<img width="870" height="176" alt="image" src="https://github.com/user-attachments/assets/8136a703-484b-4c64-a7a8-32ca200db487" />

- Penjelasan:

  - extends Reservasi: Inheritance, mewarisi semua property dan method parent
  - super(): Memanggil constructor parent class
  - @Override: Method overriding untuk memberikan implementasi khusus
  - Additional property: fasilitas khusus untuk reservasi reguler

**3. Class ReservasiVIP.java (Subclass)**

<img width="1020" height="664" alt="image" src="https://github.com/user-attachments/assets/ff4701d6-6a21-4bad-9a90-e72469e13bfe" />

<img width="961" height="751" alt="image" src="https://github.com/user-attachments/assets/ac9915ed-68b8-4a59-aa03-53e199359ac1" />

- Penjelasan:

  - Additional properties: fasilitasVIP dan biayaTambahanVIP
  - Override hitungTotalBiaya(): Perhitungan berbeda dengan biaya tambahan VIP
  - Method khusus: hitungDiskonMember() hanya ada di VIP
  - Polymorphism: Method yang sama tapi behavior berbeda


**4. Class ReservasiService.java (Business Logic)**

<img width="886" height="719" alt="image" src="https://github.com/user-attachments/assets/24eaf2a8-4cad-462c-a601-8e4522a624db" />

<img width="882" height="739" alt="image" src="https://github.com/user-attachments/assets/eb390f84-4b6f-4846-952f-505f29bd4a2a" />

<img width="982" height="692" alt="image" src="https://github.com/user-attachments/assets/25447be8-c546-4a32-a465-75cba22e5cf2" />

- Penjelasan:

  - ArrayList: Collection untuk menyimpan multiple objek Reservasi
  - Input validation: Loop sampai input valid
  - Polymorphism: Satu variabel Reservasi bisa hold berbagai subclass
  - instanceof: Runtime type checking
  - Method overriding: infoReservasi() akan call implementasi yang tepat


**5. Class Main.java (Entry Point)**

  <img width="886" height="737" alt="image" src="https://github.com/user-attachments/assets/46031796-a368-4210-9190-1f7527406889" />

<img width="904" height="480" alt="image" src="https://github.com/user-attachments/assets/c523765c-20b8-42f9-b20f-3c5fdb93a4f0" />

- Penjelasan:

  - Entry point: Method main() sebagai starting point program
  - Object instantiation: Membuat objek service untuk handle business logic
  - Menu loop: while(true) untuk menu yang terus berulang
  - Switch-case: Control flow untuk pilihan menu

===========================================================

**ALUR PROGRAM**

**1. Tambah Reservasi**

<img width="1308" height="610" alt="image" src="https://github.com/user-attachments/assets/3e578bc0-c7f5-47c2-95a4-79f6443ff598" />

Penjelasan Output:

- Menu Utama
User diberikan pilihan 1–5 (Tambah, Lihat, Ubah, Hapus, Keluar).
Pada contoh ini, user memilih 1 (Tambah Reservasi).

- Form Input Reservasi

  - Nama Pemesan: janod

  - Tanggal: 22-09-2025

  - Jam Mulai: 23:00

  - Durasi: 3 jam

  - Jenis Reservasi: Reguler (Rp 50.000/jam)

- Informasi Keuntungan
Karena memilih Reguler, program menampilkan keuntungan reservasi reguler:

  - Harga lebih terjangkau (Rp 50.000/jam)

  - Fasilitas: Lapangan standar & air mineral

  - Cocok untuk bermain santai

- Konfirmasi Reservasi Berhasil
Program menampilkan detail reservasi:

  - [REGULER] Nama: janod

  - Tanggal: 22-09-2025

  - Jam: 23:00

  - Durasi: 3 jam

  - Total biaya: Rp 150.000

  - Fasilitas: Lapangan standar, Air mineral


*Contoh jika mengisi dengan jawaban kosong*

<img width="1593" height="618" alt="image" src="https://github.com/user-attachments/assets/d7f94c1d-2c1b-4f48-92e1-675c57087d52" />


**2.Lihat Reservasi**
<img width="1604" height="372" alt="image" src="https://github.com/user-attachments/assets/16d4ad3d-5fa1-4d6d-b1a5-f364c145e46a" />

Penjelasan Output:

- Menu Utama
User memilih 2 (Lihat Reservasi).

- Daftar Reservasi
Program menampilkan semua data reservasi yang sudah tersimpan:

  - Reservasi 1 (Reguler)
Nama: janod | Tanggal: 22-09-2025 | Jam: 23:00 | Durasi: 3 jam | Total Rp 150.000
Fasilitas: Lapangan standar, Air mineral

  - Reservasi 2 (VIP)
Nama: ojan | Tanggal: 23-10-2025 | Jam: 22:00 | Durasi: 2 jam | Total Rp 200.000
Fasilitas VIP: Lapangan premium, AC, Sound system, Snack & minuman, Handuk
Biaya tambahan: Rp 50.000

- Statistik Reservasi
Program otomatis menghitung ringkasan:

  - Total Reservasi: 2

  - Jumlah Reguler: 1

  - Jumlah VIP: 1

  - Total Pendapatan: Rp 350.000

**3.Ubah Reservasi**

<img width="1617" height="699" alt="image" src="https://github.com/user-attachments/assets/899628cc-32f3-4b24-a697-219ed7dd9f58" />

Penjelasan Output:

- Menu Utama
User memilih 3 (Ubah Reservasi).

- Daftar Reservasi
Program menampilkan semua data reservasi yang ada (sama seperti menu lihat reservasi), lengkap dengan detail reguler dan VIP, serta statistik total.

- Pilih Data yang Akan Diubah

  - User memilih reservasi nomor 1 (atas nama janod).

  - Program menampilkan data lama untuk memastikan.

- Pilih Bagian yang Ingin Diubah
Opsi yang tersedia: Nama, Tanggal, Jam, atau Durasi.

  - User memilih 1 (Nama Pemesan).

  - Nama diubah dari janod → ZANOD.

- Konfirmasi Perubahan
Program menampilkan pesan “Reservasi berhasil diubah!” dan memperlihatkan data terbaru dengan nama pemesan yang sudah diperbarui.

**4.Hapus Reservasi**

<img width="1625" height="500" alt="image" src="https://github.com/user-attachments/assets/d119abaa-48e2-4bdc-a093-b33d8bec2d6b" />

- Penjelasan Output:

- Daftar Reservasi Ditampilkan
Program menampilkan semua data reservasi yang ada, lengkap dengan detail Reguler dan VIP, serta ringkasan statistik.

- Pilih Reservasi yang Akan Dihapus

  - User memilih nomor 1 (atas nama ZANOD).

- Konfirmasi Hapus
Program menampilkan pesan “Reservasi berhasil dihapus!” dan menampilkan detail data yang telah dihapus agar user tahu reservasi mana yang dihapus.

**5.Keluar**

<img width="784" height="333" alt="image" src="https://github.com/user-attachments/assets/78ff6197-9167-49b9-b447-d09babd73752" />


- Penjelasan Output:

  - Menu Utama
User memilih opsi 5 (Keluar).

  - Program Selesai
Program menampilkan pesan “Terima kasih!” sebagai penutup, lalu menghentikan proses.
