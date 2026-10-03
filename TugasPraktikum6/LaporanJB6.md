# 📑 LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK
## JOBSHEET 6: INHERITANCE (PEWARISAN)

---

## 📌 DAFTAR ISI
1. [Pertanyaan Percobaan 1: Single Inheritance dengan extends (ClassA dan ClassB)](#-pertanyaan-percobaan-1-single-inheritance-dengan-extends-classa-dan-classb)
2. [Pertanyaan Percobaan 2: Hak Akses pada Pewarisan (private dan protected)](#-pertanyaan-percobaan-2-hak-akses-pada-pewarisan-private-dan-protected)
3. [Pertanyaan Percobaan 3: Kata Kunci this dan super (Bangun dan Tabung)](#-pertanyaan-percobaan-3-kata-kunci-this-dan-super-bangun-dan-tabung)
4. [Pertanyaan Percobaan 4: Konstruktor dan Multilevel Inheritance (ClassA, ClassB, ClassC)](#-pertanyaan-percobaan-4-konstruktor-dan-multilevel-inheritance-classa-classb-classc)
5. [Pertanyaan Percobaan 5: Konstruktor Berparameter dan Overriding (Komputer, Desktop, Laptop)](#-pertanyaan-percobaan-5-konstruktor-berparameter-dan-overriding-komputer-desktop-laptop)

---

## 🧪 Pertanyaan Percobaan 1: Single Inheritance dengan `extends` (ClassA dan ClassB)

### 1. Mengapa kompilasi pada Langkah 5 gagal? Tuliskan pesan error pertama beserta file dan baris tempat error muncul.
**Jawaban:**
Kompilasi pada Langkah 5 gagal karena `ClassB` belum diturunkan dari `ClassA` (belum menambahkan kata kunci `extends ClassA`), serta `MainPercobaan1` mencoba mengakses atribut dan method milik `ClassA` melalui objek `ClassB`. Akibatnya, *compiler* Java tidak dapat menemukan deklarasi variabel `x`, `y`, maupun method `getNilai()` di dalam `ClassB`.

* **Pesan error pertama:**
  ```text
  ClassB.java:11: error: cannot find symbol
          System.out.println("jumlah: " + (x + y + z));
                                           ^
    symbol:   variable x
    location: class ClassB
  ```
  *(Selain itu, error serupa juga muncul untuk variabel `y` pada baris 11 di `ClassB.java`, serta pemanggilan `hitung.x`, `hitung.y`, dan `hitung.getNilai()` pada `MainPercobaan1.java`).*

---

### 2. Baris kode mana yang diubah pada Langkah 6, dan apa artinya? Sebutkan class yang berperan sebagai superclass dan subclass.
**Jawaban:**
* **Baris kode yang diubah:**
  ```java
  public class ClassB extends ClassA {
  ```
* **Arti perubahan:**
  Kata kunci `extends` mendeklarasikan hubungan pewarisan (*inheritance* / *is-a*). Artinya, `ClassB` mewarisi semua atribut dan method yang berstatus non-private dari `ClassA`.
* **Peran Class:**
  - **Superclass (Parent Class / Base Class):** `ClassA`
  - **Subclass (Child Class / Derived Class):** `ClassB`

---

### 3. Setelah diperbaiki, sebutkan atribut dan method yang dapat dipakai oleh objek `hitung`. Kelompokkan mana yang dideklarasikan di `ClassA` dan mana yang dideklarasikan di `ClassB`.
**Jawaban:**
Objek `hitung` bertipe `ClassB` dapat menggunakan seluruh member miliknya sendiri ditambah seluruh member yang diwariskan dari `ClassA`:

| Asal Deklarasi | Atribut yang Dapat Digunakan | Method yang Dapat Digunakan |
| :--- | :--- | :--- |
| **Dideklarasikan di `ClassA`** | `public int x`<br>`public int y` | `public void getNilai()` |
| **Dideklarasikan di `ClassB`** | `public int z` | `public void getNilaiZ()`<br>`public void getJumlah()` |

---

### 4. Pada `MainPercobaan1`, `hitung.x = 20` ditulis pada objek `ClassB`, padahal atribut `x` tidak dideklarasikan di `ClassB`. Mengapa hal ini diperbolehkan?
**Jawaban:**
Hal ini diperbolehkan karena melalui mekanisme pewarisan (`public class ClassB extends ClassA`), seluruh atribut `public` dari `ClassA` (yaitu `x` dan `y`) secara otomatis diwariskan dan menjadi bagian dari `ClassB`. Oleh sebab itu, setiap instansiasi objek dari `ClassB` (yaitu `hitung`) secara sah memiliki atribut `x` dan dapat mengaksesnya secara langsung.

---

### 5. Atribut `x` dan `y` pada `ClassA` dibuat `public`, sehingga dapat diubah langsung dari `MainPercobaan1`. Apa risiko dari desain seperti ini? (jawaban ini akan kita telusuri pada Percobaan 2)
**Jawaban:**
Risiko dari atribut yang bersifat `public` adalah:
1. **Melanggar Prinsip Enkapsulasi (*Data Hiding*):** Data internal objek dapat diubah secara bebas dan tidak terkontrol oleh class eksternal mana pun tanpa melalui validasi.
2. **Rawan Inkonsistensi Data:** Tidak ada proteksi dari *invalid state* (misalnya nilai diisi data negatif atau angka tidak wajar).
3. **Ketergantungan Kode yang Tinggi (*High Coupling*):** Jika nama atau tipe data atribut `x` dan `y` di masa depan diubah, semua class lain yang mengakses langsung variabel tersebut akan ikut rusak dan harus diubah manual.

---

### 6. Coba tambahkan class `ClassD` lalu ubah deklarasi menjadi `public class ClassB extends ClassA, ClassD`. Apa yang terjadi? Apa yang dapat Anda simpulkan tentang jumlah superclass langsung pada Java?
**Jawaban:**
* **Yang terjadi:** Kompilasi akan gagal (*compile error*) dengan pesan kesalahan seperti:
  ```text
  ClassB.java:3: error: '{' expected
  public class ClassB extends ClassA, ClassD {
                                    ^
  ```
* **Kesimpulan:**
  Java **TIDAK MENDUKUNG *Multiple Inheritance* untuk Class** secara langsung. Sebuah subclass di Java hanya diizinkan memiliki **tepat 1 (*single*) superclass langsung** dengan kata kunci `extends`. Hal ini dirancang oleh pembuat Java untuk menghindari ambiguitas (*Diamond Problem*).

---
---

## 🧪 Pertanyaan Percobaan 2: Hak Akses pada Pewarisan (private dan protected)

### 1. Di file dan baris mana error pada Langkah 5 muncul, dan apa pesannya? Mengapa error tidak muncul di `MainPercobaan2`?
**Jawaban:**
* **Lokasi & Pesan Error:**
  Error muncul di file **`ClassB.java` pada baris ke-15** (di dalam method `getJumlah()`):
  ```text
  ClassB.java:15: error: x has private access in ClassA
          System.out.println("jumlah: " + (x + y + z));
                                           ^
  ClassB.java:15: error: y has private access in ClassA
          System.out.println("jumlah: " + (x + y + z));
                                               ^
  ```
* **Mengapa tidak muncul di `MainPercobaan2`:**
  Karena `MainPercobaan2` tidak mengakses atribut `x` dan `y` secara langsung, melainkan memanggil method `public` yaitu `hitung.setX(20)`, `hitung.setY(30)`, dan `hitung.getNilai()`. Method-method public tersebut sah diakses dari mana saja.

---

### 2. Jelaskan penyebab error tersebut dengan merujuk pada tabel kontrol pengaksesan (Langkah 1).
**Jawaban:**
Berdasarkan tabel kontrol pengaksesan:
* Member dengan modifier **`private`** **HANYA DAPAT DIAKSES** oleh class tempat ia dideklarasikan (`ClassA`).
* Modifier `private` **tidak dapat diakses oleh subclass manapun**, meskipun subclass tersebut berada dalam satu package yang sama.
* Karena `ClassB` mencoba mengakses variabel `x` dan `y` secara langsung di baris `(x + y + z)`, maka *compiler* menolaknya karena `x` dan `y` berstatus `private` di `ClassA`.

---

### 3. Pada kode awal, `MainPercobaan2` memanggil `hitung.setX(20)` dan tidak error, padahal `x` bersifat `private`. Mengapa pemanggilan ini diperbolehkan, dan di mana nilai `x` tersimpan?
**Jawaban:**
* **Mengapa diperbolehkan:**
  Method `setX(int x)` dideklarasikan dengan modifier **`public`** di `ClassA` dan diwariskan ke `ClassB`. Class dari luar (`MainPercobaan2`) memanggil method `public` tersebut (bukan mengakses variabel `private x` secara langsung). Method `setX` yang berada di dalam `ClassA` inilah yang kemudian secara internal memberikan nilai ke `this.x`.
* **Di mana nilai `x` tersimpan:**
  Nilai `x` tersimpan di dalam memori objek `hitung` pada area state yang dialokasikan untuk instance `ClassA` yang menjadi bagian dari objek `ClassB` tersebut.

---

### 4. Bandingkan Perbaikan A (`protected`) dan Perbaikan B (`private` + getter) dari sisi *encapsulation*. Mana yang Anda pilih untuk program sungguhan? Jelaskan alasannya.
**Jawaban:**
* **Perbandingan:**
  - **Perbaikan A (`protected`):** Memberikan akses langsung ke atribut bagi subclass dan semua class lain dalam package yang sama. Enkapsulasinya lebih longgar.
  - **Perbaikan B (`private` + getter/setter):** Menjaga atribut tetap tersembunyi sepenuhnya dari luar (bahkan dari subclass), dan hanya membuka akses baca melalui `getX()` dan `getY()`.
* **Pilihan untuk Program Sungguhan:**
  **Perbaikan B (`private` + getter/setter)** lebih direkomendasikan karena:
  1. Menjaga enkapsulasi secara maksimal (*strict encapsulation*).
  2. Subclass tidak bisa merusak atau memanipulasi data atribut secara ilegal di luar logika getter/setter.
  3. Memudahkan *maintenance* di masa depan jika ada perubahan representasi data pada superclass.

---

### 5. Andaikan `ClassA` dan `ClassB` berada di package yang berbeda. Berdasarkan tabel, apakah `ClassB` tetap dapat mengakses atribut `protected` milik `ClassA`? Bagaimana jika atributnya `default` (tanpa modifier)?
**Jawaban:**
* **Untuk atribut `protected`:**
  **YA, `ClassB` TETAP BISA mengaksesnya.** Sesuai aturan Java, modifier `protected` mengizinkan akses dari subclass meskipun subclass tersebut berada di package yang berbeda (*Subclass beda package: YES*).
* **Untuk atribut `default` (tanpa modifier):**
  **TIDAK BISA.** Modifier `default` hanya mengizinkan pengaksesan oleh class yang berada dalam **satu package yang sama**. Jika beda package, subclass tidak dapat mengakses atribut `default` milik superclass.

---
---

## 🧪 Pertanyaan Percobaan 3: Kata Kunci `this` dan `super` (Bangun dan Tabung)

### 1. Jelaskan fungsi `super` pada `super.phi = phi;` dan `super.r = r;` di method `setSuperPhi()` dan `setSuperR()` milik `Tabung`.
**Jawaban:**
Kata kunci **`super`** berfungsi sebagai referensi eksplisit untuk menunjuk ke **member (atribut atau method) milik superclass (`Bangun`)**.
* `super.phi = phi;` memastikan bahwa nilai argumen `phi` disimpan ke atribut `phi` milik class induk `Bangun`.
* `super.r = r;` memastikan bahwa nilai argumen `r` disimpan ke atribut `r` milik class induk `Bangun`.

---

### 2. Jelaskan fungsi `super` dan `this` pada ekspresi `super.phi * super.r * super.r * this.t` di method `volume()`.
**Jawaban:**
* **`super.phi` dan `super.r`**: Merujuk secara spesifik ke atribut `phi` dan jari-jari `r` yang dideklarasikan pada superclass (`Bangun`).
* **`this.t`**: Merujuk secara spesifik ke atribut tinggi `t` yang dideklarasikan pada class itu sendiri (`Tabung`).
* Penggunaan `super` dan `this` di sini memperjelas asal-usul variabel: rumus volume tabung adalah gabungan dari luas alas milik bangun datar superclass ($\pi \times r^2$) dikalikan dengan tinggi milik subclass ($t$).

---

### 3. Mengapa `Tabung` tidak mendeklarasikan atribut `phi` dan `r`, tetapi tetap dapat mengaksesnya? Apa yang terjadi bila pada `Bangun` keduanya diubah menjadi `private`?
**Jawaban:**
* **Mengapa tetap dapat mengakses:**
  Karena `Tabung` merupakan subclass dari `Bangun` (`extends Bangun`), dan atribut `phi` serta `r` pada `Bangun` dideklarasikan dengan access modifier **`protected`**. Atribut `protected` secara otomatis diwariskan ke subclass sehingga dapat langsung diakses oleh `Tabung`.
* **Jika diubah menjadi `private`:**
  Class `Tabung` akan mengalami **compile error** saat mencoba mengakses `super.phi` atau `super.r` karena hak akses `private` melarang pengaksesan dari class manapun di luar class `Bangun` itu sendiri (termasuk subclass).

---

### 4. Pada Eksperimen 1, apakah output berubah ketika `super.phi` diganti `this.phi`? Jelaskan mengapa.
**Jawaban:**
* **Perubahan Output:** **TIDAK BERUBAH** (output tetap `Volume Tabung adalah: 942.0`).
* **Alasan:**
  Karena pada `Tabung` tidak ada deklarasi atribut `phi` milik sendiri, maka kata kunci `this.phi` akan mencari atribut `phi` di class `Tabung`. Karena tidak ditemukan di class sendiri, Java otomatis mencari ke atas hierarki pewarisan dan menemukan `phi` yang diwarisi dari superclass `Bangun`. Sehingga `this.phi` dan `super.phi` merujuk ke lokasi variabel yang sama di memori.

---

### 5. Pada Eksperimen 2, mengapa `r`, `this.r`, dan `super.r` menghasilkan nilai yang berbeda? Pada kondisi apa awalan `super.` menjadi wajib dipakai?
**Jawaban:**
* **Penyebab perbedaan nilai:**
  - Pada Eksperimen 2, `Tabung` mendeklarasikan atribut baru miliknya sendiri: `protected int r = 5;`.
  - Hal ini menyebabkan fenomena **Variable Shadowing (Atribut superclass tertutupi oleh atribut subclass dengan nama yang sama)**.
  - **`r`** dan **`this.r`** merujuk ke atribut `r` milik `Tabung` yang bernilai **`5`**.
  - **`super.r`** merujuk ke atribut `r` milik superclass `Bangun` yang telah diisi nilai **`10`** lewat method `setSuperR(10)`.
* **Kapan awalan `super.` wajib dipakai:**
  Awalan `super.` menjadi **WAJIB** digunakan ketika terjadi **Variable Shadowing** atau **Method Overriding**, yaitu saat subclass memiliki atribut atau method dengan nama yang persis sama dengan milik superclass, namun kita secara spesifik ingin mengakses atau mengeksekusi versi milik superclass.

---
---

## 🧪 Pertanyaan Percobaan 4: Konstruktor dan Multilevel Inheritance (ClassA, ClassB, ClassC)

### 1. Sebutkan class yang berperan sebagai superclass dan subclass pada percobaan ini beserta alasannya. Mengapa `ClassB` disebut berperan ganda?
**Jawaban:**
* **Peran Class dalam Hierarki:**
  - **`ClassA`**: Berperan sebagai **Superclass** murni (paling atas / *root parent*).
  - **`ClassC`**: Berperan sebagai **Subclass** murni (paling bawah / *leaf child*).
  - **`ClassB`**: Berperan ganda sebagai **Subclass** dari `ClassA` (`ClassB extends ClassA`) sekaligus sebagai **Superclass** bagi `ClassC` (`ClassC extends ClassB`).
* **Alasan `ClassB` Disebut Berperan Ganda:**
  Karena pada konsep *Multilevel Inheritance*, `ClassB` berada di posisi tengah rantai pewarisan: ia mewarisi sifat dari `ClassA`, dan di saat yang sama mewariskan sifatnya (beserta sifat `ClassA`) kepada `ClassC`.

---

### 2. Program hanya membuat satu objek (`new ClassC()`), tetapi tiga baris tercetak. Jelaskan mengapa konstruktor `ClassA` dan `ClassB` ikut dijalankan.
**Jawaban:**
Di Java, saat sebuah objek subclass diinstansiasi, konstruktor subclass **tidak dapat berdiri sendiri tanpa superclass-nya diinisialisasi terlebih dahulu**.
Secara otomatis:
1. Konstruktor `ClassC()` akan memanggil konstruktor superclass-nya yaitu `ClassB()`.
2. Konstruktor `ClassB()` akan memanggil konstruktor superclass-nya yaitu `ClassA()`.
3. Konstruktor `ClassA()` memanggil konstruktor kelas puncak `Object()`.

Eksekusi konstruktor kemudian berjalan dari hierarki teratas (`ClassA` $\rightarrow$ `ClassB` $\rightarrow$ `ClassC`), sehingga pesan dari ketiga konstruktor ikut tercetak secara berurutan.

---

### 3. Pada Modifikasi 1, mengapa output tidak berbeda dari sebelumnya meskipun `super();` ditambahkan secara eksplisit?
**Jawaban:**
Karena *compiler* Java secara *default* **selalu menyisipkan pemanggilan `super();` (tanpa argumen) secara implisit/otomatis pada baris pertama setiap konstruktor** jika kita tidak menuliskannya secara manual. Oleh karena itu, menambahkan `super();` secara eksplisit pada Modifikasi 1 tidak mengubah alur eksekusi program sama sekali.

---

### 4. Pada Modifikasi 2 terjadi error. Aturan apa yang dilanggar, dan mengapa Java menetapkan aturan tersebut?
**Jawaban:**
* **Aturan yang Dilanggar:**
  Aturan dasar konstruktor Java: **"Call to super must be first statement in constructor"** (pemanggilan `super()` wajib diletakkan pada baris paling pertama di dalam blok konstruktor).
* **Alasan Java Menetapkan Aturan Tersebut:**
  Untuk menjamin integritas data (*State Consistency*). Superclass harus diinisialisasi dan dibangun secara utuh terlebih dahulu sebelum subclass melakukan operasi, inisialisasi atribut, atau mengeksekusi method miliknya sendiri. Jika kode subclass diizinkan berjalan sebelum superclass siap, terdapat risiko subclass mengakses state superclass yang belum terinisialisasi (*uninitialized state*).

---

### 5. Tuliskan urutan proses (bernomor) yang terjadi ketika `new ClassC()` dieksekusi, dimulai dari pemanggilan konstruktor `ClassC` hingga seluruh output tercetak.
**Jawaban:**
1. Baris `new ClassC()` mengalokasikan memori untuk objek baru dan memanggil konstruktor `ClassC()`.
2. Di baris pertama `ClassC()`, terdapat pemanggilan `super()` yang mengalihkan eksekusi ke konstruktor `ClassB()`.
3. Di baris pertama `ClassB()`, terdapat pemanggilan `super()` yang mengalihkan eksekusi ke konstruktor `ClassA()`.
4. Di baris pertama `ClassA()`, terdapat pemanggilan `super()` ke konstruktor default kelas `java.lang.Object`.
5. Konstruktor `Object` selesai, kontrol kembali ke `ClassA()` $\rightarrow$ mengeksekusi `System.out.println("Konstruktor A dijalankan")` $\rightarrow$ **Output: "Konstruktor A dijalankan"**.
6. Konstruktor `ClassA()` selesai, kontrol kembali ke `ClassB()` $\rightarrow$ mengeksekusi `System.out.println("Konstruktor B dijalankan")` $\rightarrow$ **Output: "Konstruktor B dijalankan"**.
7. Konstruktor `ClassB()` selesai, kontrol kembali ke `ClassC()` $\rightarrow$ mengeksekusi `System.out.println("konstruktor C dijalankan")` $\rightarrow$ **Output: "konstruktor C dijalankan"**.
8. Konstruktor `ClassC()` selesai, referensi objek `ClassC` yang sudah utuh dikembalikan dan disimpan ke variabel `test`.

---
---

## 🧪 Pertanyaan Percobaan 5: Konstruktor Berparameter dan Overriding (Komputer, Desktop, Laptop)

### 1. Jelaskan fungsi `super(merk, memory, cpu)` pada konstruktor `Desktop`. Atribut apa saja yang diisi oleh baris tersebut, dan atribut apa yang diisi oleh baris berikutnya?
**Jawaban:**
* **Fungsi `super(merk, memory, cpu)`:**
  Berfungsi untuk memanggil konstruktor berparameter milik superclass (`Komputer`) guna menginisialisasi atribut-atribut yang diwariskan dari `Komputer`.
* **Atribut yang diisi oleh `super(...)`:**
  1. `this.merk = merk;`
  2. `this.kapasitasMemory = memory;`
  3. `this.kecepatanCPU = cpu;`
* **Atribut yang diisi oleh baris berikutnya (`this.printer = printer;`):**
  Menginisialisasi atribut spesifik milik class `Desktop` itu sendiri, yaitu atribut `printer`.

---

### 2. Pada Eksperimen 1, mengapa error muncul di sini, padahal pada Percobaan 4 `super()` juga tidak ditulis tetapi program tetap berjalan?
**Jawaban:**
* **Pada Percobaan 4:** Superclass (`ClassA` & `ClassB`) memiliki konstruktor *default* (tanpa parameter). Saat `super()` tidak ditulis, compiler secara otomatis menyisipkan `super();` tanpa argumen dan berhasil menemukan konstruktor yang cocok.
* **Pada Percobaan 5 (Eksperimen 1):** Superclass `Komputer` **HANYA memiliki konstruktor berparameter (3 argumen)** dan **TIDAK memiliki konstruktor default tanpa parameter**. Saat `super(merk, memory, cpu)` dihapus, compiler mencoba menyisipkan `super();` tanpa argumen, yang berakibat gagal (*error: constructor Komputer in class Komputer cannot be applied to given types: required: String,int,int; found: no arguments*).

---

### 3. Method `showInfo()` ditulis di `Komputer` sekaligus di `Desktop`. Apa istilah untuk kondisi ini? Apa yang tercetak bila baris `super.showInfo();` pada `Desktop` dihapus?
**Jawaban:**
* **Istilah Kondisi:** **Method Overriding** (subclass menulis ulang implementasi method yang diwariskan dari superclass dengan nama, parameter, dan return type yang sama).
* **Jika `super.showInfo();` dihapus pada `Desktop`:**
  Informasi umum komputer (`Merk`, `Kapasitas Memory`, dan `Kecepatan CPU`) tidak akan dicetak lagi. Yang tercetak ke layar hanya informasi spesifik dari `Desktop`, yaitu:
  ```text
  Printer : Cannon
  ```

---

### 4. Pada Eksperimen 2, jelaskan perbedaan hasil kompilasi dengan dan tanpa `@Override`. Apa manfaat menuliskan `@Override`?
**Jawaban:**
* **Perbedaan Hasil Kompilasi:**
  - **DENGAN anotasi `@Override`:** Compiler mendeteksi bahwa nama method `showinfo()` salah ketik (huruf 'i' kecil tidak cocok dengan `showInfo()` pada superclass) dan langsung memunculkan **Compile Error** (*method does not override or implement a method from a supertype*).
  - **TANPA anotasi `@Override`:** Kompilasi **berhasil/lolos**, tetapi compiler menganggap `showinfo()` sebagai method baru biasa milik `Desktop` (bukan overriding). Akibatnya saat `desk.showInfo()` dipanggil, yang berjalan adalah method milik superclass `Komputer`, sehingga baris `Printer` tidak pernah tercetak (*silent logical bug*).
* **Manfaat Menuliskan `@Override`:**
  1. **Sebagai Proteksi Kesalahan Kompilasi (*Compile-Time Safety*):** Memastikan bahwa method yang kita buat benar-benar valid menimpa method superclass (mencegah salah ketik nama atau salah parameter).
  2. **Meningkatkan Keterbacaan Kode (*Readability*):** Memberikan tanda yang jelas bagi programmer lain bahwa method tersebut merupakan hasil penimpaan dari superclass.

---

### 5. Tantangan. Buat class `Workstation` sebagai turunan `Desktop` dengan atribut `gpu` (`String`). Class ini harus menimpa `showInfo()` sehingga menampilkan seluruh informasi `Desktop` ditambah baris GPU. Ketika `new Workstation(...)` dibuat, konstruktor class apa saja yang terpanggil, dan dalam urutan apa?
**Jawaban:**
* **Implementasi Kode Class `Workstation`:**
  ```java
  package TugasPraktikum6.Percobaan5KonstruktorBerparameterDanOverriding;

  public class Workstation extends Desktop {
      protected String gpu;

      public Workstation(String merk, int memory, int cpu, String printer, String gpu) {
          super(merk, memory, cpu, printer);
          this.gpu = gpu;
      }

      @Override
      public void showInfo() {
          super.showInfo();
          System.out.println("GPU            : " + this.gpu);
      }
  }
  ```
* **Urutan Konstruktor yang Terpanggil Saat `new Workstation(...)` Dibuat:**
  1. **Konstruktor `Komputer`** (dijalankan paling awal untuk inisialisasi `merk`, `memory`, `cpu`).
  2. **Konstruktor `Desktop`** (dijalankan kedua untuk inisialisasi `printer`).
  3. **Konstruktor `Workstation`** (dijalankan terakhir untuk inisialisasi `gpu`).
