# 📑 LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK
## JOBSHEET 7: OVERLOADING DAN OVERRIDING

---

## 📌 DAFTAR ISI
1. [Percobaan 1: Overloading Method (Perkalian)](#-percobaan-1-overloading-method-perkalian)
2. [Percobaan 2: Pemilihan Overload oleh Compiler (Resolusi)](#-percobaan-2-pemilihan-overload-oleh-compiler-resolusi)
3. [Percobaan 3: Overloading Konstruktor (Kucing)](#-percobaan-3-overloading-konstruktor-kucing)
4. [Percobaan 4: Dasar Overriding (Ikan dan Piranha)](#-percobaan-4-dasar-overriding-ikan-dan-piranha)
5. [Percobaan 5: Overloading dan Overriding Bersama (Karyawan, Staff, Manager)](#-percobaan-5-overloading-dan-overriding-bersama-karyawan-staff-manager)
6. [Tugas Mandiri 1: Overloading pada Class Segitiga](#-tugas-mandiri-1-overloading-pada-class-segitiga)
7. [Tugas Mandiri 2: Overriding pada Manusia, Dosen, dan Mahasiswa](#-tugas-mandiri-2-overriding-pada-manusia-dosen-dan-mahasiswa)
8. [Tugas Mandiri 3: Pertanyaan Ringkas & Tabel Perbandingan](#-tugas-mandiri-3-pertanyaan-ringkas--tabel-perbandingan)

---

## 🧪 Percobaan 1: Overloading Method (Perkalian)

### 📊 Tabel Hasil Eksperimen (Langkah 4)
| Tambahan pada class `Perkalian` / Kode di `Main` | Hasil / Pesan Error |
| :--- | :--- |
| `public long kali(int a, int b) { return (long) a * b; }` | **Pesan Error:**<br>`error: method kali(int,int) is already defined in class id.ac.polinema.overloading.percobaan1.Perkalian` |
| `public int kali(int x, int y) { return x * y; }` | **Pesan Error:**<br>`error: method kali(int,int) is already defined in class id.ac.polinema.overloading.percobaan1.Perkalian` |
| Pada main: `p.kali(5, 2.5)`, `p.kali(2, 3)`, `p.kali(2.0, 3)` | **Output:**<br>`12.5`<br>`6`<br>`6.0` |

---

### ❓ Jawaban Pertanyaan Percobaan 1

#### 1. Sebutkan method hasil overloading pada `Perkalian` dan pembeda tiap pasangannya (jumlah, tipe, atau urutan parameter).
**Jawaban:**
Terdapat dua kelompok method yang mengalami overloading:
1. **Kelompok Method `kali`:**
   - `kali(int a, int b)` vs `kali(int a, int b, int c)` $\rightarrow$ **Pembeda:** **Jumlah parameter** (2 parameter `int` vs 3 parameter `int`).
   - `kali(int a, int b)` vs `kali(double a, double b)` $\rightarrow$ **Pembeda:** **Tipe data parameter** (`int` vs `double`).
2. **Kelompok Method `tampilkan`:**
   - `tampilkan(int nomor, String label)` vs `tampilkan(String label, int nomor)` $\rightarrow$ **Pembeda:** **Urutan tipe data parameter** (`(int, String)` vs `(String, int)`).

#### 2. Pada `p.kali(25.5, 4.0)`, versi `kali()` mana yang dipanggil? Mengapa bukan versi `int`?
**Jawaban:**
Method yang dipanggil adalah **`kali(double a, double b)`**. Hal ini terjadi karena literal `25.5` dan `4.0` secara otomatis bertipe `double` (bilangan pecahan). Compiler mencocokkan tipe argumen pemanggil dengan signature method yang paling tepat (*exact match*). Versi `kali(int, int)` tidak dipanggil karena Java melarang *narrowing conversion* (pemotongan tipe `double` ke `int` secara implisit karena rawan kehilangan presisi).

#### 3. Mengapa `tampilkan(int, String)` dan `tampilkan(String, int)` sah sebagai overloading, sedangkan dua method yang hanya beda tipe kembalian atau nama parameter tidak?
**Jawaban:**
Karena *method signature* dalam Java **hanya terdiri dari: Nama Method + Daftar Tipe Parameter (jumlah, jenis tipe, dan urutan tipenya)**.
- `(int, String)` dan `(String, int)` memiliki urutan tipe yang berbeda, sehingga compiler dapat membedakan secara pasti method mana yang ingin dipanggil saat runtime berdasarkan urutan argumennya.
- **Beda tipe kembalian (*return type*) saja tidak sah** karena saat pemanggilan (misal: `kali(2, 3);` tanpa menampung return value), compiler tidak tahu versi mana yang dimaksud.
- **Beda nama variabel parameter saja tidak sah** karena nama variabel lokal dihilangkan saat kompilasi ke bytecode dan tidak berpengaruh pada saat pemanggilan argumen.

#### 4. Pada eksperimen ketiga, mengapa `kali(5, 2.5)` menghasilkan 12.5 dan bukan error?
**Jawaban:**
Karena terjadi mekanisme **Widening Conversion** (pelebaran tipe data otomatis) dari tipe `int` ke `double`. Argumen pertama bernilai `5` (`int`) secara otomatis diperlebar menjadi `5.0` (`double`), sehingga cocok dengan method `kali(double a, double b)`. Hasil perkalian $5.0 \times 2.5 = 12.5$.

---
---

## 🧪 Percobaan 2: Pemilihan Overload oleh Compiler (Resolusi)

### 📊 Tabel Prediksi dan Hasil Eksekusi (Langkah 2)
| Pemanggilan | Prediksi | Hasil Sebenarnya |
| :--- | :--- | :--- |
| `tampil(5)` | `tampil(long) : 5` | `tampil(long) : 5` |
| `tampil(5L)` | `tampil(long) : 5` | `tampil(long) : 5` |
| `tampil(Integer.valueOf(7))` | `tampil(Integer) : 7` | `tampil(Integer) : 7` |
| `tampil(3.5)` | `tampil(Object) : 3.5` | `tampil(Object) : 3.5` |
| `tampil("Java")` | `tampil(Object) : Java` | `tampil(Object) : Java` |
| `tampil()` | `tampil(int...) : 0 elemen` | `tampil(int...) : 0 elemen` |
| `tampil(1, 2, 3)` | `tampil(int...) : 3 elemen` | `tampil(int...) : 3 elemen` |

---

### 📊 Tabel Eksperimen Kumulatif (Langkah 3)
| Kondisi | Overload yang Dipanggil oleh `tampil(5)` |
| :--- | :--- |
| **Semua overload aktif** | `tampil(long) : 5` *(Fase 1: Widening primitif)* |
| **`tampil(long)` dikomentari** | `tampil(Integer) : 5` *(Fase 2: Autoboxing int $\rightarrow$ Integer)* |
| **`tampil(long)` dan `tampil(Integer)` dikomentari** | `tampil(Object) : 5` *(Fase 2: Autoboxing int $\rightarrow$ Integer $\rightarrow$ Polymorphic Upcast ke Object)* |
| **`tampil(long)`, `tampil(Integer)`, dan `tampil(Object)` dikomentari** | `tampil(int...) : 1 elemen` *(Fase 3: Varargs)* |

---

### ❓ Jawaban Pertanyaan Percobaan 2

#### 1. Mengapa `tampil(5)` memilih `tampil(long)` dan bukan `tampil(Integer)`, padahal 5 dapat di-boxing? Sebutkan fase yang menentukan.
**Jawaban:**
Karena aturan resolusi overloading Java mengutamakan **Fase 1 (Identitas & Widening)** di atas **Fase 2 (Boxing/Unboxing)** dan **Fase 3 (Varargs)**.
Compiler selalu mencari kecocokan tanpa boxing terlebih dahulu. Mengubah `int` menjadi `long` (Widening primitif) berada pada Fase 1, sedangkan mengubah `int` menjadi `Integer` (Autoboxing) berada pada Fase 2. Compiler langsung berhenti pada Fase 1 saat kecocokan ditemukan.

#### 2. Jelaskan perpindahan overload pada tiap baris tabel Langkah 3.
**Jawaban:**
1. **Kondisi 1 (Default):** Compiler memilih `tampil(long)` pada **Fase 1** (Widening primitif `int` $\rightarrow$ `long`).
2. **Kondisi 2 (`long` mati):** Fase 1 gagal, lanjut ke **Fase 2**. Compiler melakukan Autoboxing `int` $\rightarrow$ `Integer` dan memanggil `tampil(Integer)`.
3. **Kondisi 3 (`long` & `Integer` mati):** Compiler melakukan Autoboxing `int` $\rightarrow$ `Integer`, lalu melakukan upcasting polimorfisme karena `Integer is-a Object`, sehingga memilih `tampil(Object)`.
4. **Kondisi 4 (Semua mati kecuali varargs):** Fase 1 dan Fase 2 gagal, lanjut ke **Fase 3 (Varargs)**. Nilai `5` dibungkus menjadi array elemen tunggal `new int[]{5}` dan memanggil `tampil(int...)`.

#### 3. Mengapa `tampilLong(5)` gagal, sedangkan `tampil(5)` dapat berakhir pada `tampil(Object)` bila overload lain dikomentari?
**Jawaban:**
- `tampilLong(5)` gagal karena Java **TIDAK MENGIZINKAN Widening yang dilanjutkan dengan Boxing** (`int` $\rightarrow$ `long` $\rightarrow$ `Long` ditolak). Java juga tidak mengizinkan widening antar-wrapper (`Integer` tidak bisa diubah ke `Long`).
- Sebaliknya, `tampil(5)` dapat memanggil `tampil(Object)` karena Java **MENGIZINKAN Boxing yang dilanjutkan dengan Widening/Upcasting** (`int` $\rightarrow$ di-boxing ke `Integer` $\rightarrow$ di-upcast ke `Object` karena `Object` adalah superclass dari `Integer`).

#### 4. Tantangan. Tanpa menjalankan, prediksi output `Resolusi.tampil((short) 3)` dan `Resolusi.tampil('A')`, lalu buktikan.
**Jawaban:**
- **Prediksi:**
  1. `Resolusi.tampil((short) 3)` $\rightarrow$ **`tampil(long) : 3`** (tipe `short` di-widening ke `long` pada Fase 1).
  2. `Resolusi.tampil('A')` $\rightarrow$ **`tampil(long) : 65`** (tipe `char` dengan nilai ASCII 65 di-widening ke `long` pada Fase 1).
- **Pembuktian:** Terbukti benar sesuai aturan *primitive widening conversion* (`short`/`char` $\rightarrow$ `int` $\rightarrow$ `long`).

---
---

## 🧪 Percobaan 3: Overloading Konstruktor (Kucing)

### ❓ Jawaban Pertanyaan Percobaan 3

#### 1. Mengapa `Konstruktor 2 parameter selesai` tercetak lebih dulu daripada `Konstruktor 1 parameter selesai` pada `new Kucing("Tom")`?
**Jawaban:**
Karena pada konstruktor 1 parameter:
```java
public Kucing(String nama) {
    this(nama, 1); // Memanggil konstruktor 2 parameter
    System.out.println("Konstruktor 1 parameter selesai");
}
```
Instruksi `this(nama, 1)` dieksekusi terlebih dahulu sebelum baris perintah berikutnya. Alur eksekusi langsung melompat ke konstruktor 2 parameter, menyelesaikan inisialisasi dan mencetak `"Konstruktor 2 parameter selesai"`. Setelah konstruktor 2 parameter tuntas, kontrol kembali ke konstruktor 1 parameter untuk mencetak `"Konstruktor 1 parameter selesai"`.

#### 2. Apa keuntungan `this(nama, 1)` dibandingkan menyalin isi konstruktor kedua ke konstruktor pertama?
**Jawaban:**
Keuntungannya menerapkan prinsip **DRY (*Don't Repeat Yourself*)**:
1. **Menghindari Duplikasi Kode:** Logika inisialisasi hanya ditulis dan dipusatkan pada satu konstruktor utama (*Master Constructor*).
2. **Kemudahan Pemeliharaan (*Maintainability*):** Jika ada perubahan aturan inisialisasi atau validasi atribut di masa depan, kita hanya perlu mengubah di satu tempat saja tanpa takut lupa memperbarui konstruktor lainnya.

#### 3. Tambahkan `public Kucing()` yang memanggil `this("Tanpa Nama")` dan mencetak `Konstruktor 0 parameter selesai`. Tuliskan output `new Kucing()` serta urutan ketiga konstruktor dijalankan.
**Jawaban:**
* **Implementasi Kode:**
  ```java
  public Kucing() {
      this("Tanpa Nama");
      System.out.println("Konstruktor 0 parameter selesai");
  }
  ```
* **Output yang Tercetak:**
  ```text
  Konstruktor 2 parameter selesai
  Konstruktor 1 parameter selesai
  Konstruktor 0 parameter selesai
  ```
* **Urutan Eksekusi:**
  `Kucing()` memanggil $\rightarrow$ `Kucing(String)` memanggil $\rightarrow$ `Kucing(String, int)`. Eksekusi selesai dan mencetak pesan berurutan dari: **Konstruktor 2 parameter** $\rightarrow$ **Konstruktor 1 parameter** $\rightarrow$ **Konstruktor 0 parameter**.

---
---

## 🧪 Percobaan 4: Dasar Overriding (Ikan dan Piranha)

### 📊 Tabel Hasil Eksperimen (Langkah 4)
| Perubahan pada Kode | Pesan Error Pertama | Aturan Overriding yang Dilanggar |
| :--- | :--- | :--- |
| **Hapus `public` pada `swim()` di `Piranha`** | `error: swim() in Piranha cannot override swim() in Ikan; attempting to assign weaker access privileges; was public` | **Aturan Hak Akses:** Method overriding tidak boleh mempersempit hak akses (*weaker access modifier*). |
| **Tambahkan `final` pada `swim()` di `Ikan`** | `error: swim() in Piranha cannot override swim() in Ikan; overridden method is final` | **Aturan Kata Kunci `final`:** Method yang berstatus `final` pada superclass tidak boleh di-override oleh subclass. |
| **Ubah `swim()` di `Piranha` menjadi `swim(int jarak)`, `@Override` tetap ada** | `error: method does not override or implement a method from a supertype` | **Aturan Signature:** Method overriding wajib memiliki nama dan daftar tipe parameter yang sama persis (*exact signature*). |
| **Tambahkan `throws Exception` pada `swim()` di `Piranha`** | `error: swim() in Piranha cannot override swim() in Ikan; overridden method does not throw Exception` | **Aturan Exception:** Method overriding tidak boleh melempar checked exception baru atau yang lebih luas dari yang dideklarasikan superclass. |

---

### ❓ Jawaban Pertanyaan Percobaan 4

#### 1. Bandingkan `a.swim()` dan `c.swim()`. Apa peran `super.swim()`, dan apa yang tercetak bila baris itu dihapus?
**Jawaban:**
* `a.swim()` menjalankan method asli milik class `Ikan` $\rightarrow$ mencetak `"Ikan bisa berenang"`.
* `c.swim()` menjalankan method hasil overriding milik class `Piranha` $\rightarrow$ berkat baris `super.swim()`, ia menjalankan perilaku superclass terlebih dahulu (`"Ikan bisa berenang"`), lalu mencetak perilaku spesifiknya (`"Piranha bisa makan daging"`).
* **Jika `super.swim()` dihapus:** Pesan `"Ikan bisa berenang"` tidak akan muncul pada objek Piranha; yang tercetak hanya `"Piranha bisa makan daging"`.

#### 2. Apa manfaat *covariant return* pada `beranak()`? Apakah `Piranha anak = a.beranak();` valid? Mengapa?
**Jawaban:**
* **Manfaat *Covariant Return*:** Subclass diizinkan mengubah tipe kembalian method overriding menjadi tipe subclass-nya (`Piranha` alih-alih `Ikan`). Manfaatnya adalah pemanggil method tidak perlu lagi melakukan *explicit type casting* manual seperti `(Piranha) c.beranak()`.
* **Validitas `Piranha anak = a.beranak();`:** **TIDAK VALID (Compile Error)**. Karena `a` adalah objek `Ikan`, method `a.beranak()` mengembalikan tipe `Ikan`. Objek general `Ikan` tidak bisa langsung ditampung ke variabel khusus `Piranha` tanpa *type casting*.

#### 3. Pada baris ketiga tabel, apa yang terjadi bila `@Override` dihapus? Apakah `swim(int)` overriding atau overloading?
**Jawaban:**
Jika `@Override` dihapus, kompilasi akan **LOLOS/BERHASIL**. Namun method `swim(int jarak)` tersebut statusnya berubah menjadi **OVERLOADING** (karena memiliki nama sama tetapi parameternya berbeda). Akibatnya, saat `c.swim()` tanpa argumen dipanggil, Java akan mengeksekusi versi warisan asli milik `Ikan`.

#### 4. Tantangan. Jika `swim()` di `Ikan` dibuat `private` dan `Piranha` memiliki `@Override public void swim()`, apa yang terjadi? Mengapa?
**Jawaban:**
Akan terjadi **Compile Error** dengan pesan: `method does not override or implement a method from a supertype`.
* **Alasannya:** Method `private` pada superclass tersembunyi sepenuhnya dan **tidak pernah diwariskan** ke subclass. Karena tidak diwariskan, maka subclass tidak dapat melakukan *overriding* terhadap method tersebut.

---
---

## 🧪 Percobaan 5: Overloading dan Overriding Bersama (Karyawan, Staff, Manager)

### ❓ Jawaban Pertanyaan Percobaan 5

#### 1. Tunjuk method yang termasuk overloading dan yang termasuk overriding pada ketiga class (sebutkan class dan signature-nya), dan jelaskan pembeda masing-masing.
**Jawaban:**
1. **Method Overriding:**
   - `Staff.getGaji()` menimpa `Karyawan.getGaji()` (Signature sama persis: `getGaji()`).
   - `Manager.getGaji()` menimpa `Karyawan.getGaji()` (Signature sama persis: `getGaji()`).
   - `Staff.lihatInfo()` dan `Manager.lihatInfo()` menimpa `Karyawan.lihatInfo()`.
   - **Pembeda:** Signature sama, implementasi perilaku diubah sesuai role subclass.
2. **Method Overloading:**
   - Di class `Staff`: terdapat `getGaji()` (tanpa parameter) dan `getGaji(int jamLembur, double tarifLembur)` (2 parameter).
   - **Pembeda:** Jumlah dan tipe parameter berbeda dalam satu kelas.

#### 2. Mengapa `getGaji(int, double)` memakai `super.getGaji()`, sedangkan `getGaji()` pada `Staff` memanggil `getGaji(jamLembur, tarifLembur)`? Apa yang terjadi bila isi `getGaji(int, double)` diganti `return getGaji() + jamLembur * tarifLembur;`?
**Jawaban:**
- `getGaji(int, double)` memakai `super.getGaji()` untuk mengambil nilai `gajiPokok` murni dari class induk `Karyawan`.
- `getGaji()` tanpa parameter pada `Staff` memanggil `getGaji(jamLembur, tarifLembur)` untuk mendelegasikan perhitungan dengan atribut lembur milik objek itu sendiri.
- **Jika diganti `return getGaji() + jamLembur * tarifLembur;`:** Akan terjadi **Infinite Recursion (Perulangan Tanpa Akhir)** yang mengakibatkan error **`java.lang.StackOverflowError`** saat program dijalankan, karena method `getGaji()` dan `getGaji(int, double)` akan saling memanggil satu sama lain tanpa henti.

#### 3. Apa akibatnya pada gaji Staff bila `getGaji()` di `Staff` ditulis `return jamLembur * tarifLembur;`? Apakah gaji Manager ikut berubah?
**Jawaban:**
- **Akibat pada Staff:** Gaji Staff hanya menghitung uang lembur saja (gaji pokok Rp 2.000.000 hilang/tidak terhitung).
- **Apakah gaji Manager ikut berubah?** **TIDAK**. Karena `Manager` memanggil `super.getGaji()` yang langsung merujuk ke method `Karyawan.getGaji()` (gaji pokok Manager), bukan memanggil method milik `Staff`.

#### 4. Apa hubungan Manager dengan Staff (is-a atau has-a)? Tunjuk atributnya dan bandingkan dengan hubungan Manager dengan Karyawan.
**Jawaban:**
- **Hubungan Manager dengan Staff:** Bersifat **`has-a` (Agregasi)**, ditunjukkan oleh atribut `private Staff[] bawahan;` (Manager memiliki sekumpulan objek Staff sebagai bawahan).
- **Hubungan Manager dengan Karyawan:** Bersifat **`is-a` (Pewarisan / Inheritance)**, ditunjukkan oleh deklarasi `public class Manager extends Karyawan` (Manager adalah seorang Karyawan).

---
---

## 💻 Tugas Mandiri 1: Overloading pada Class Segitiga

### 📝 Kode Solusi `Segitiga.java`
```java
package TugasPraktikum7.TugasMandiri.Tugas1Overloading;

public class Segitiga {
    private int sudut;

    public int sisaSudut(int sudutA) {
        if (sudutA <= 0 || sudutA >= 180) {
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan kurang dari 180!");
        }
        this.sudut = 180 - sudutA;
        return this.sudut;
    }

    public int sisaSudut(int sudutA, int sudutB) {
        int total = sudutA + sudutB;
        if (total <= 0 || total >= 180) {
            throw new IllegalArgumentException("Total sudut harus lebih dari 0 dan kurang dari 180!");
        }
        this.sudut = 180 - total;
        return this.sudut;
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        double c = Math.sqrt((sisiA * sisiA) + (sisiB * sisiB));
        return (sisiA + sisiB + c);
    }

    public int getSudut() {
        return this.sudut;
    }
}
```

### ❓ Jawaban Pertanyaan Analisis Tugas 1
#### (a) `keliling(3, 4, 5)` dan `keliling(3, 4)` bertipe kembalian berbeda. Apakah itu yang membuatnya sah sebagai overloading? Apa pembeda sebenarnya?
**Jawaban:**
**BUKAN**. Tipe kembalian (*return type*) **bukan merupakan faktor penentu keabsahan overloading**. Pembeda sebenarnya yang membuat kedua method tersebut sah adalah **Jumlah Parameternya** (versi pertama memiliki 3 parameter `int`, sedangkan versi kedua memiliki 2 parameter `int`).

#### (b) Apa yang terjadi bila `t.keliling(3, 4.0)` dipanggil? Tuliskan pesan error dan alasannya.
**Jawaban:**
* **Yang terjadi:** Terjadi **Compile Error**.
* **Pesan Error:**
  ```text
  error: no suitable method found for keliling(int,double)
      method Segitiga.keliling(int,int,int) is not applicable (actual and formal argument lists differ in length)
      method Segitiga.keliling(int,int) is not applicable (argument mismatch; possible lossy conversion from double to int)
  ```
* **Alasannya:** Java tidak menemukan signature `keliling(int, double)`. Argumen kedua bernilai `4.0` (`double`) tidak bisa dimasukkan ke parameter `int` tanpa *explicit casting* karena rawan kehilangan presisi (*lossy conversion*).

---
---

## 💻 Tugas Mandiri 2: Overriding pada Manusia, Dosen, dan Mahasiswa

### 📝 Implementasi Kode
* **`Manusia.java`**
  ```java
  package TugasPraktikum7.TugasMandiri.Tugas2Overriding;

  public class Manusia {
      public void bernafas() {
          System.out.println("Manusia bernafas dengan paru-paru");
      }
      public void makan() {
          System.out.println("Manusia makan nasi");
      }
  }
  ```
* **`Dosen.java`**
  ```java
  package TugasPraktikum7.TugasMandiri.Tugas2Overriding;

  public class Dosen extends Manusia {
      @Override
      public void makan() {
          super.makan();
          System.out.println("Dosen makan di kantin fakultas");
      }
      public void lembur() {
          System.out.println("Dosen lembur menilai ujian");
      }
  }
  ```
* **`Mahasiswa.java`**
  ```java
  package TugasPraktikum7.TugasMandiri.Tugas2Overriding;

  public class Mahasiswa extends Manusia {
      @Override
      public void makan() {
          System.out.println("Mahasiswa makan di kantin kampus");
      }
      public void tidur() {
          System.out.println("Mahasiswa tidur di perpustakaan");
      }
  }
  ```

### ❓ Jawaban Pertanyaan Analisis Tugas 2
#### (a) Mengapa `bernafas()` pada objek `Mahasiswa` mencetak teks milik `Manusia`, sedangkan `makan()` tidak?
**Jawaban:**
Karena method `bernafas()` **tidak di-override** oleh class `Mahasiswa`, sehingga objek `Mahasiswa` mewarisi dan menjalankan perilaku default dari superclass `Manusia`. Sedangkan method `makan()` telah **di-override secara total**, sehingga saat dipanggil pada objek `Mahasiswa`, implementasi baru milik `Mahasiswa` yang dieksekusi.

#### (b) Bandingkan hasil `makan()` pada `Dosen` dan `Mahasiswa`, lalu jelaskan peran `super.makan()`.
**Jawaban:**
- Pada **`Dosen`**: Mencetak `"Manusia makan nasi"` kemudian `"Dosen makan di kantin fakultas"` karena memanggil `super.makan()`.
- Pada **`Mahasiswa`**: Hanya mencetak `"Mahasiswa makan di kantin kampus"` karena tidak memanggil `super.makan()`.
- **Peran `super.makan()`:** Berfungsi untuk mengeksekusi logika dasar/warisan dari method superclass sebelum atau sesudah menambahkan logika spesifik milik subclass (*extending behavior*).

---
---

## 📝 Tugas Mandiri 3: Pertanyaan Ringkas & Tabel Perbandingan

### 1. Tabel Perbandingan Overloading vs Overriding

| Aspek | Overloading | Overriding |
| :--- | :--- | :--- |
| **Lokasi Terjadi** | Terjadi di **dalam class yang sama** (atau antara superclass-subclass). | Terjadi antara **Superclass dan Subclass** (hubungan pewarisan / *inheritance*). |
| **Signature (Parameter)** | **WAJIB BERBEDA** (jumlah, tipe data, atau urutan tipe parameter). | **WAJIB SAMA PERSIS** (nama method dan tipe parameternya). |
| **Tipe Kembalian (*Return Type*)** | **Boleh sama, boleh berbeda** (bukan penentu overloading). | **Wajib sama**, atau berupa subclass-nya (*Covariant Return*). |
| **Access Modifier** | **Boleh sama, boleh berbeda**. | **Wajib sama atau lebih luas/longgar** (tidak boleh mempersempit hak akses). |
| **Peran `@Override`** | **Tidak digunakan** (akan menimbulkan compile error jika dipasang). | **Sangat dianjurkan** (sebagai compiler-check pencegah salah ketik signature). |

---

### 2. Kapan Memilih Overloading dan Kapan Memilih Overriding?
**Jawaban:**
- **Pilihlah Overloading:** Ketika kita ingin menyediakan **satu nama fungsi yang sama untuk menangani variasi tipe data atau jumlah input yang berbeda** demi kenyamanan pemanggil.
  - *Contoh Jobsheet:* Method `Perkalian.kali(int, int)` dan `kali(double, double)` atau `kali(int, int, int)`.
- **Pilihlah Overriding:** Ketika sebuah **subclass membutuhkan implementasi perilaku yang lebih spesifik** untuk menggantikan atau memperluas method yang diwariskan oleh superclass-nya.
  - *Contoh Jobsheet:* `Dosen` dan `Mahasiswa` menimpa method `makan()` milik `Manusia` sesuai kebiasaan masing-masing.

---

### 3. Mengapa Method `static`, `private`, dan `final` Tidak Dapat Di-override?
**Jawaban:**
1. **Method `private`:** Tidak dapat di-override karena memiliki *class-level scope* dan tersembunyi sepenuhnya sehingga tidak pernah diwariskan ke subclass.
2. **Method `static`:** Tidak dapat di-override karena terikat pada **Class** saat waktu kompilasi (*compile-time / early binding*), bukan terikat pada instansi objek saat runtime (*runtime polymorphism*). Jika subclass membuat method static yang sama, itu disebut *Method Hiding*, bukan overriding.
3. **Method `final`:** Tidak dapat di-override karena kata kunci `final` secara eksplisit mengunci implementasi method pada superclass agar tidak boleh diubah atau ditimpa oleh subclass manapun (*immutability rule*).
