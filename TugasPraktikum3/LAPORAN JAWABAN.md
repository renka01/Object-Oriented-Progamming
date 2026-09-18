# 📑 LAPORAN PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK
## MODUL 3: Enkapsulasi (Encapsulation)

---

### 👤 Data Praktikan
* **Mata Kuliah** : Pemrograman Berorientasi Objek (OOP)
* **Topik** : Penerapan Enkapsulasi (*Access Modifier*, *Getter/Setter*, Konstruktor, dan Validasi)
* **Bahasa Pemrograman** : Java

---

## 📝 3.3 Pertanyaan dan Jawaban – Percobaan 1 dan 2 (MotorEncapsulation)

### 1. Pada class TestMobil / MotorDemo, saat kita menambah kecepatan untuk pertama kalinya, mengapa muncul peringatan *"Kecepatan tidak bisa bertambah karena Mesin Off!"*?

**Jawaban:**
Peringatan tersebut muncul karena pada saat objek `Motor` pertama kali diinstansiasi (`new Motor()`), atribut `kontakOn` secara *default* diinisialisasi dengan nilai `false` (mesin dalam kondisi mati). 

Di dalam method `tambahKecepatan()`, terdapat struktur kontrol logika:
```java
if (this.kontakOn == true) {
    // tambah kecepatan
} else {
    System.out.println("Kecepatan tidak bisa bertambah karena mesin masih Off");
}
```
Karena method `nyalakanMesin()` belum dipanggil, kondisi `this.kontakOn == true` menghasilkan nilai `false`. Akibatnya, alur program masuk ke blok `else` dan mencetak pesan peringatan tersebut untuk mencegah penambahan kecepatan saat mesin belum menyala.

---

### 2. Mengapa atribut `kecepatan` dan `kontakOn` diset `private`?

**Jawaban:**
Atribut `kecepatan` dan `kontakOn` diset `private` sebagai penerapan konsep **Enkapsulasi (*Data Hiding*)** dengan tujuan:
* **Mencegah Akses & Modifikasi Sembarangan**: Menghindari pengubahan nilai secara langsung dari luar class (seperti `motor.kecepatan = 300;` atau `motor.kecepatan = -50;`) yang dapat merusak integritas data objek.
* **Memastikan Validasi Logika Berjalan**: Setiap perubahan *state* (keadaan) pada objek harus melalui *method* tertentu (seperti `tambahKecepatan()`, `kurangiKecepatan()`, `nyalakanMesin()`, dan `matikanMesin()`). Dengan cara ini, aturan bisnis (seperti mesin harus menyala untuk menambah kecepatan, atau batas kecepatan maksimum) dapat ditegakkan secara konsisten.

---

### 3. Ubah class `Motor` sehingga kecepatan maksimalnya adalah 100!

**Jawaban:**
Pada class `Motor`, method `tambahKecepatan()` dimodifikasi dengan menambahkan kondisi pengecekan batas maksimum kecepatan (`kecepatan < 100`). Jika kecepatan setelah ditambah melebihi 100, nilainya akan dikunci pada 100 dan sistem menampilkan informasi bahwa batas maksimal telah tercapai.

#### 🔹 Kode Hasil Modifikasi pada `Motor.java`:
```java
public class Motor {
    private int kecepatan = 0;
    private boolean kontakOn = false;

    public void nyalakanMesin() {
        kontakOn = true;
    }

    public void matikanMesin() {
        kontakOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan() {
        if (this.kontakOn == true) {
            if (kecepatan < 100) {
                kecepatan += 5;
                if (kecepatan > 100) {
                    kecepatan = 100;
                }
            } else {
                System.out.println("Kecepatan sudah mencapai batas maksimal (100)!");
            }
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena mesin masih Off");
        }
    }

    public void kurangiKecepatan() {
        if (this.kontakOn == true) {
            kecepatan -= 5;
            if (kecepatan < 0) {
                kecepatan = 0;
            }
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena mesin masih Off");
        }
    }

    public void printStatus() {
        if (this.kontakOn == true) {
            System.out.println(" Kontak On ");
        } else {
            System.out.println(" Kontak Off");
        }
        System.out.println("Kecepatan: " + kecepatan + "\n");
    }
}
```

---

## 📝 3.6 Pertanyaan dan Jawaban – Percobaan 3 dan 4 (KoperasiGetterSetter)

### 1. Apa yang dimaksud getter dan setter?
* **Getter**: Method publik yang berfungsi untuk **membaca / mengambil (*retrieve/read*)** nilai dari atribut yang dideklarasikan secara `private`. Biasanya mengembalikan nilai (*return value*) sesuai tipe data atribut dan diawali kata `get` (contoh: `getNama()`, `getSimpanan()`).
* **Setter**: Method publik yang berfungsi untuk **memberi / mengubah (*write/modify*)** nilai dari atribut yang dideklarasikan secara `private`. Biasanya bertipe kembalian `void`, menerima parameter input, dan diawali kata `set` (contoh: `setNama(String nama)`).

---

### 2. Apa kegunaan dari method `getSimpanan()`?
Method `getSimpanan()` berguna untuk mengakses dan mengembalikan nilai dari atribut `simpanan` (bertipe `float`) yang bersifat `private` pada class `Anggota`, sehingga nilainya dapat dibaca, diproses, atau ditampilkan ke layar konsol oleh class luar (seperti `KoperasiDemo`) tanpa harus membuka akses langsung ke variabel `simpanan`.

---

### 3. Method apa yang digunakan untuk menambah saldo?
Method yang digunakan untuk menambah saldo simpanan adalah method **`setor(float uang)`** yang ada pada class `Anggota`. Method ini menjalankan operasi penambahan nilai saldo:
```java
public void setor(float uang) {
    simpanan += uang;
}
```

---

### 4. Apa yang dimaksud konstruktor?
**Konstruktor (*Constructor*)** adalah method khusus dalam suatu class yang dipanggil secara otomatis pada saat sebuah objek diinstansiasi (dibuat di memori menggunakan kata kunci `new`). Fungsi utamanya adalah mengalokasikan memori serta memberikan nilai awal (*inisialisasi state*) pada atribut-atribut objek tersebut.

---

### 5. Sebutkan aturan dalam membuat konstruktor?
1. **Nama konstruktor HARUS sama persis** dengan nama class-nya (*case-sensitive*).
2. **TIDAK memiliki tipe data kembalian (*return type*)**, bahkan tidak boleh menggunakan `void`.
3. Dapat dideklarasikan dengan atau tanpa parameter (*default constructor* vs *parameterized constructor*).
4. Dapat menggunakan berbagai *access modifier* (`public`, `protected`, `default`/package-private, `private`).
5. Dapat menerapkan konsep **Overloading** (membuat lebih dari satu konstruktor dalam kelas yang sama dengan tipe atau jumlah parameter yang berbeda).

---

### 6. Apakah boleh konstruktor bertipe `private`?
**Boleh.** Di dalam bahasa Java, konstruktor diperbolehkan bertipe `private`. 
* **Fungsi**: Konstruktor `private` mencegah pembuatan instance/objek secara langsung dari luar kelas menggunakan kata kunci `new`.
* **Penerapan Nyata**: Umumnya digunakan pada pola desain **Singleton Pattern** (memastikan hanya satu objek yang dibuat di seluruh aplikasi) atau pada **Utility Class** yang seluruh method-nya bersifat `static` (contoh: `java.lang.Math`).

---

### 7. Kapan menggunakan konstruktor dengan passing parameter?
Konstruktor dengan *passing parameter* (*Parameterized Constructor*) digunakan ketika kita ingin **memberikan nilai awal yang spesifik secara langsung pada saat objek pertama kali diciptakan**, sehingga objek yang baru terbuat sudah berada dalam keadaan (*state*) yang valid dan siap digunakan tanpa perlu memanggil method *setter* satu per satu secara terpisah.

---

### 8. Apa perbedaan inisialisasi atribut dan instansiasi atribut?
* **Inisialisasi Atribut**: Proses pengisian nilai awal (*value assignment*) ke dalam variabel/atribut tertentu. Inisialisasi berlaku untuk semua tipe data, baik tipe primitif maupun referensi (contoh: `int kecepatan = 0;` atau `this.simpanan = 0;`).
* **Instansiasi Atribut**: Proses pembuatan objek konkret di memori (*heap memory*) menggunakan kata kunci `new` yang kemudian alamat referensinya disimpan ke dalam atribut bertipe objek/kelas referensi (contoh: `private Mesin mesinUtama = new Mesin();`).

---

### 9. Apa perbedaan inisialisasi method dan instansiasi method?
* **Inisialisasi Method**: Dalam konsep OOP Java tidak ada istilah baku "inisialisasi method", melainkan **Deklarasi / Definisi Method** (proses merancang header method, tipe return, parameter, dan blok isi fungsinya) atau method khusus inisialisasi (seperti method `init()`).
* **Instansiasi Method**: Method **tidak dapat diinstansiasi** karena method bukanlah tipe data/cetak biru objek, melainkan sekumpulan instruksi perilaku (*behavior*). Yang diinstansiasi adalah **Class menjadi Objek**. Setelah objek diinstansiasi ke memori, barulah method-method non-static yang ada di dalam objek tersebut dapat dipanggil (*invoked* / *called*).

---

# 📌 BAGIAN TUGAS (EncapDemo & EncapTest)

## 📝 Pertanyaan dan Jawaban – Tugas Mandiri

### 2. Pada class `EncapTest`, kita mengeset `age` dengan nilai **35** (`encap.setAge(35)`), namun pada saat ditampilkan ke layar nilainya **30**. Jelaskan mengapa hal tersebut terjadi!

**Jawaban:**
Hal tersebut terjadi karena adanya **logika validasi / batasan nilai** di dalam method `setAge()` pada class `EncapDemo`.

Mari kita lihat kode awal pada method `setAge()` di [EncapDemo.java](file:///e:/OOP-SMT3/TugasPraktikum3/Tugas/EncapDemo.java):
```java
public void setAge(int newAge) {
    if (newAge > 30) {
        age = 30;
    } else {
        age = newAge;
    }
}
```

**Penjelasan Alur Program:**
1. Saat baris `encap.setAge(35);` dijalankan, nilai parameter `newAge` adalah **35**.
2. Di dalam method, program memeriksa kondisi: `if (newAge > 30)`.
3. Karena **35 > 30** bernilai **`true` (benar)**, maka baris di dalam blok `if` yaitu `age = 30;` dieksekusi.
4. Nilai atribut `age` secara otomatis dipaksa/dikunci pada nilai maksimalnya, yaitu **30**.
5. Akibatnya, ketika `encap.getAge()` dipanggil untuk dicetak ke layar, nilai yang dikembalikan adalah **30**.

> 💡 **Kesimpulan Konsep:**
> Ini merupakan salah satu fungsi utama dari **Enkapsulasi**, yaitu melindungi data (*data protection*) agar nilai atribut objek tidak bisa diisi sembarangan dan selalu mematuhi aturan/batasan logika yang telah ditentukan oleh pembuat program.

---

### 3. Ubah program diatas agar atribut `age` dapat diberi nilai maksimal 30 dan minimal 18!

**Jawaban:**
Untuk membatasi nilai `age` agar berada dalam rentang minimal **18** dan maksimal **30**, kita memodifikasi method `setAge(int newAge)` pada class `EncapDemo` menggunakan struktur percabangan `if - else if - else`.

#### 🔹 Kode Hasil Modifikasi pada `EncapDemo.java`:
```java
package TugasPraktikum3.Tugas;

public class EncapDemo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge > 30) {
            age = 30; // Jika nilai melebihi 30, nilai age dibatasi maksimal 30
        } else if (newAge < 18) {
            age = 18; // Jika nilai kurang dari 18, nilai age dibatasi minimal 18
        } else {
            age = newAge; // Jika berada di antara 18 - 30, simpan nilai asli
        }
    }
}
```

#### 🔹 Pengujian pada `EncapTest.java`:
```java
package TugasPraktikum3.Tugas;

public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();
        encap.setName("James Bond");

        // Uji batas atas (> 30)
        encap.setAge(35);
        System.out.println("Name: " + encap.getName());
        System.out.println("Age (set 35 -> max 30): " + encap.getAge());

        // Uji batas bawah (< 18)
        encap.setAge(15);
        System.out.println("Age (set 15 -> min 18): " + encap.getAge());

        // Uji nilai valid (18 - 30)
        encap.setAge(25);
        System.out.println("Age (set 25 -> valid): " + encap.getAge());
    }
}
```

---

### 4. Pembuatan Class `Kontainer` dan Pengujian dengan Driver `TestLogistik`

#### 📋 Deskripsi Soal:
> Pada sebuah sistem manajemen pergudangan kargo ekspedisi, terdapat class `Kontainer` yang memiliki atribut antara lain `nomorResi`, `namaPemilik`, `kapasitasMaksimal` (dalam kg), dan `beratMuatanSaatIni`. Kontainer dapat menerima tambahan muatan barang dengan batasan kapasitas maksimal yang telah ditentukan. Kontainer juga dapat diturunkan muatannya (bongkar muat). Ketika barang diturunkan, maka jumlah muatan saat ini akan berkurang sesuai dengan nominal berat yang dikeluarkan.
> 
> Buatlah class `Kontainer` tersebut, berikan atribut (`private`), method getter, dan konstruktor sesuai dengan kebutuhan arsitektur enkapsulasi. Uji dengan kelas driver `TestLogistik` untuk memeriksa apakah manajemen state kelas Anda telah berjalan dengan benar.

#### 🔹 Source Code `Kontainer.java`:
```java
package TugasPraktikum3.Tugas;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private int kapasitasMaksimal;
    private int beratMuatanKini;

    // Konstruktor
    public Kontainer(String resi, String pemilik, int kapasitas) {
        nomorResi = resi;
        namaPemilik = pemilik;
        kapasitasMaksimal = kapasitas;
        beratMuatanKini = 0;
    }

    // Getter methods
    public String getNomorResi() {
        return nomorResi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public int getBeratMuatanKini() {
        return beratMuatanKini;
    }

    // Method menambah muatan dengan validasi kapasitas maksimal
    public void setTambahBerat(int berat) {
        if (beratMuatanKini + berat > kapasitasMaksimal) {
            System.out.println("Berat muatan melebihi kapasitas maksimal");
        } else {
            beratMuatanKini += berat;
            System.out.println("Berhasil menambah muatan sebesar " + berat + " kg.");
        }
    }

    // Method membongkar muatan
    public void setBongkarMuat(int berat) {
        if (beratMuatanKini == 0) {
            System.out.println("Kontainer kosong, tidak ada muatan yang bisa diturunkan.");
        } else if (berat > beratMuatanKini * 0.5) {
            System.out.println("Maaf, demi keselamatan. Pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
        } else {
            beratMuatanKini -= berat;
            System.out.println("Berhasil membongkar muatan sebesar " + berat + " kg.");
        }
    }
}
```

#### 🔹 Source Code Driver `TestLogistik.java`:
```java
package TugasPraktikum3.Tugas;

public class TestLogistik {
    public static void main(String[] args) {
        Kontainer kontainerAlfa = new Kontainer("REQ-123", "PT. Maju Bersama Wawan", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal() + " kg");

        System.out.println("\n Memasukka muatan baru sebesar 6000 kg... ");
        kontainerAlfa.setTambahBerat(6000);
        System.out.println("Berat Muatan Kini: " + kontainerAlfa.getBeratMuatanKini() + " kg");

        System.out.println("\nMemasukkan muatan baru sebesar 4.000kg...");
        kontainerAlfa.setTambahBerat(4000);
        System.out.println("Berat Muatan Kini: " + kontainerAlfa.getBeratMuatanKini() + " kg");

        System.out.println("\nMembongkar muat/menurunkan barang seberat 500kg...");
        kontainerAlfa.setBongkarMuat(500);
        System.out.println("Berat Muatan Kini:  " + kontainerAlfa.getBeratMuatanKini() + " kg");

        System.out.println("\nMembongkar muat/menurunkan barang seberat 1.500kg...");
        kontainerAlfa.setBongkarMuat(1500);
        System.out.println("Berat Muatan Kini:  " + kontainerAlfa.getBeratMuatanKini() + " kg");
    }
}
```

#### 💻 Hasil Output Running:
```text
Nama Pemilik Kontainer: PT. Maju Bersama Wawan
Kapasitas Maksimal: 5000 kg

 Memasukka muatan baru sebesar 6000 kg... 
Berat muatan melebihi kapasitas maksimal
Berat Muatan Kini: 0 kg

Memasukkan muatan baru sebesar 4.000kg...
Berhasil menambah muatan sebesar 4000 kg.
Berat Muatan Kini: 4000 kg

Membongkar muat/menurunkan barang seberat 500kg...
Berhasil membongkar muatan sebesar 500 kg.
Berat Muatan Kini:  3500 kg

Membongkar muat/menurunkan barang seberat 1.500kg...
Berhasil membongkar muatan sebesar 1500 kg.
Berat Muatan Kini:  2000 kg
```

---

### 5. Modifikasi Batasan Penurunan Muatan Maksimal 50% Demi Keselamatan Crane

#### 📋 Deskripsi Soal:
> Modifikasi soal kargo logistik di atas agar nominal berat muatan yang dibongkar/diturunkan dalam satu kali pemanggilan method `setBongkarMuat()` / `turunkanMuatan()` maksimal hanya boleh sebesar 50% dari total berat muatan saat ini. Langkah ini diterapkan demi alasan keselamatan kerja operasional alat berat (*crane*). Jika operator mencoba menurunkan muatan melebihi batas 50% tersebut, sistem harus memblokir aksi dan memunculkan peringatan: 
> `"Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!"`.

#### 🔹 Kode Hasil Modifikasi pada Method `setBongkarMuat()`:
```java
public void setBongkarMuat(int berat) {
    if (beratMuatanKini == 0) {
        System.out.println("Kontainer kosong, tidak ada muatan yang bisa diturunkan.");
    } else if (berat > (beratMuatanKini * 0.5)) {
        // Blokir aksi jika penurunan muatan > 50% dari berat saat ini
        System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
    } else {
        beratMuatanKini -= berat;
        System.out.println("Berhasil membongkar muatan sebesar " + berat + " kg.");
    }
}
```

#### 💡 Penjelasan Logika:
1. **Validasi Batas 50%**: Sebelum nilai `beratMuatanKini` dikurangi, sistem menghitung batas aman pembongkaran yaitu `beratMuatanKini * 0.5`.
2. **Pemblokiran Aksi**: Apabila parameter `berat` yang dimasukkan melebihi `beratMuatanKini * 0.5`, maka alur program masuk ke blok `else if`, menampilkan pesan peringatan keselamatan, dan **tidak melakukan operasi pengurangan nilai** pada atribut `beratMuatanKini`.
3. **Pemberlakuan Enkapsulasi**: Pengaturan batas ini sepenuhnya terlindungi di dalam class `Kontainer`, sehingga pengguna class dari luar tidak dapat melanggar aturan keselamatan operasional.

---

### 6. Modifikasi Driver `TestLogistik` Menggunakan `java.util.Scanner`

#### 📋 Deskripsi Soal:
> Modifikasi kelas Main `TestLogistik` agar parameter jumlah berat barang yang dimasukkan (`tambahMuatan` / `setTambahBerat`) maupun berat barang yang dibongkar (`turunkanMuatan` / `setBongkarMuat`) dapat menerima input nilai dinamis dari pengguna secara interaktif melalui terminal menggunakan utilitas `java.util.Scanner`.

#### 🔹 Source Code Modifikasi `TestLogistik.java`:
```java
package TugasPraktikum3.Tugas;

import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Kontainer kontainerAlfa = new Kontainer("REQ-123", "PT. Maju Bersama Wawan", 5000);

        System.out.println("==================================================");
        System.out.println("          SISTEM LOGISTIK KONTAINER               ");
        System.out.println("==================================================");
        System.out.println("Nomor Resi             : " + kontainerAlfa.getNomorResi());
        System.out.println("Nama Pemilik Kontainer : " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal     : " + kontainerAlfa.getKapasitasMaksimal() + " kg");
        System.out.println("Berat Muatan Awal      : " + kontainerAlfa.getBeratMuatanKini() + " kg");
        System.out.println("--------------------------------------------------");

        // 1. Input Penambahan Muatan Dinamis
        System.out.print("\nMasukkan berat muatan yang ingin ditambahkan (kg): ");
        int beratMasuk = input.nextInt();
        kontainerAlfa.setTambahBerat(beratMasuk);
        System.out.println("Berat Muatan Kini: " + kontainerAlfa.getBeratMuatanKini() + " kg");

        // 2. Input Pembongkaran Muatan Dinamis
        System.out.print("\nMasukkan berat muatan yang ingin dibongkar (kg): ");
        int beratKeluar = input.nextInt();
        kontainerAlfa.setBongkarMuat(beratKeluar);
        System.out.println("Berat Muatan Kini: " + kontainerAlfa.getBeratMuatanKini() + " kg");

        input.close();
    }
}
```

#### 💻 Contoh Hasil Eksekusi Interaktif:
```text
==================================================
          SISTEM LOGISTIK KONTAINER               
==================================================
Nomor Resi             : REQ-123
Nama Pemilik Kontainer : PT. Maju Bersama Wawan
Kapasitas Maksimal     : 5000 kg
Berat Muatan Awal      : 0 kg
--------------------------------------------------

Masukkan berat muatan yang ingin ditambahkan (kg): 4000
Berhasil menambah muatan sebesar 4000 kg.
Berat Muatan Kini: 4000 kg

Masukkan berat muatan yang ingin dibongkar (kg): 1500
Berhasil membongkar muatan sebesar 1500 kg.
Berat Muatan Kini: 2500 kg
```

#### 💡 Penjelasan Implementasi:
1. **Inisialisasi Scanner**: Menggunakan objek `Scanner input = new Scanner(System.in);` untuk menerima input stream dari keyboard terminal.
2. **Pengambilan Nilai Dinamis**: Method `input.nextInt()` digunakan untuk menangkap bilangan bulat yang dimasukkan pengguna secara interaktif saat runtime.
3. **Penerusan Nilai ke Objek**: Nilai input disimpan dalam variabel (`beratMasuk` dan `beratKeluar`) yang langsung dilewatkan sebagai argumen ke method `setTambahBerat()` dan `setBongkarMuat()`.
4. **Penutupan Resource**: `input.close()` dipanggil di akhir method main untuk melepaskan resource stream.

---

### 7. Pembuatan Sistem Pemesanan Tiket Bioskop (`Tiket` & `TestBioskop`)

#### 📋 Deskripsi Soal:
> Sebuah aplikasi pemesanan tiket bioskop memerlukan kelas `Tiket` untuk mengelola data pemesanan secara aman. Kelas ini harus memiliki atribut `private`: `judulFilm` (`String`), `hargaDasar` (`double`), dan `statusPembayaran` (`boolean`).
> 
> **Ketentuan pengesetan nilai objek:**
> * **Konstruktor** harus menerima parameter `judulFilm` dan `hargaDasar`. Nilai awal `statusPembayaran` selalu diset `false` (Belum Dibayar).
> * Atribut `hargaDasar` tidak boleh bernilai negatif. Jika input yang dimasukkan kurang dari 0, otomatis set nilai default ke **Rp 35.000**.
> * Sediakan method `lakukanPembayaran()` untuk mengubah `statusPembayaran` menjadi `true`.
> * Nilai `statusPembayaran` hanya boleh dibaca (**Read-Only**) menggunakan getter, tidak boleh memiliki fungsi setter langsung dari luar kelas demi alasan keamanan transaksi.

#### 🔹 Source Code `Tiket.java`:
```java
package TugasPraktikum3.Tugas.TiketBioskop;

public class Tiket {
    private String judulFilm;
    private double hargaDasar = 35000;
    private boolean statusPembayaran = false;

    // Konstruktor dengan validasi harga negatif
    public Tiket(String judul, double harga) {
        judulFilm = judul;
        
        if (harga < 0) {
            hargaDasar = 35000;
        } else {
            hargaDasar = harga;
        }
        statusPembayaran = false;
    }
    
    // Getter judulFilm
    public String getJudulFilm() {
        return judulFilm;
    }

    // Getter hargaDasar
    public double getHargaDasar() {
        return hargaDasar;
    }

    // Getter statusPembayaran (Read-Only)
    public boolean getStatusPembayaran() {
        return statusPembayaran;
    }

    // Method behavior untuk mengubah status pembayaran
    public void lakukanPembayaran() {
        this.statusPembayaran = true;
    }
}
```

#### 🔹 Source Code Driver `TestBioskop.java`:
```java
package TugasPraktikum3.Tugas.TiketBioskop;

public class TestBioskop {
    public static void main(String[] args) {
        Tiket tiket1 = new Tiket("SuperWawan: The Last Man Standing", 40000);
        
        System.out.println("Film yang ditonton :" + tiket1.getJudulFilm());  
        System.out.println("Harga Tiket :" + tiket1.getHargaDasar());
        System.out.println("Status Pembayaran :" + tiket1.getStatusPembayaran());
        
        System.out.println("\nMemproses Pembayaran...");
        tiket1.lakukanPembayaran();
        System.out.println("Status Pembayaran :" + tiket1.getStatusPembayaran());  
    }
}
```

#### 💻 Hasil Output Running:
```text
Film yang ditonton :SuperWawan: The Last Man Standing
Harga Tiket :40000.0
Status Pembayaran :false

Memproses Pembayaran...
Status Pembayaran :true
```

#### 💡 Penjelasan Implementasi:
1. **Penerapan *Read-Only Property***: Atribut `statusPembayaran` hanya memiliki method getter (`getStatusPembayaran()`) dan tidak memiliki setter. Hal ini menjamin status pembayaran tidak bisa dimanipulasi secara ilegal dari luar kelas.
2. **Validasi Konstruktor**: Konstruktor secara otomatis mengoreksi nilai `hargaDasar` menjadi nilai default `35000` apabila dimasukkan harga bernilai negatif ($< 0$).
3. **Pemberian Akses Terkontrol melalui Method Behavior**: Perubahan status bayar hanya bisa dilakukan secara sah melalui pemanggilan method `lakukanPembayaran()`.

---
