# 📑 LAPORAN LENGKAP PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK
## MODUL 1: Dasar Pemrograman Berorientasi Objek (Class, Object, Encapsulation, & Inheritance)

---

### 👤 Data Praktikan
* **Mata Kuliah** : Pemrograman Berorientasi Objek (OOP)
* **Topik** : Implementasi Class, Object, Enkapsulasi, dan Pewarisan (*Inheritance*)
* **Bahasa Pemrograman** : Java

---

## 🎯 I. Tujuan Praktikum
1. Memahami konsep dasar **Class** sebagai *blueprint* dan **Object** sebagai wujud nyata (*instance*).
2. Mampu menerapkan prinsip **Enkapsulasi (*Encapsulation*)** dengan *access modifier* `private` serta *method getter/setter/behavior* untuk menjaga integritas data.
3. Memahami dan mengimplementasikan konsep **Pewarisan (*Inheritance*)** menggunakan kata kunci `extends`.
4. Mampu menerapkan konsep **Method Overriding** (`@Override`) dan pemanggilan konstruktor/method *superclass* menggunakan kata kunci `super`.
5. Mampu melakukan instansiasi objek majemuk, manipulasi nilai atribut, serta menampilkan data objek ke layar konsol.

---

## 📚 II. Dasar Teori
* **Class**: Cetak biru (*blueprint*) atau templat yang mendefinisikan variabel/atribut (*state*) dan method (*behavior*) yang dimiliki oleh objek.
* **Object**: Wujud nyata (*instance*) dari suatu kelas yang dialokasikan di memori saat program dieksekusi (*runtime*).
* **Encapsulation**: Teknik menyembunyikan detail internal objek (*data hiding*) dengan mendeklarasikan atribut sebagai `private` dan menyediakan metode akses publik yang terkontrol.
* **Inheritance (Pewarisan)**: Mekanisme di mana suatu kelas (*subclass*) mewarisi atribut dan method dari kelas lain (*superclass*) menggunakan kata kunci `extends`, yang mendukung prinsip penggunaan ulang kode (*code reusability*).
* **Method Overriding**: Kemampuan kelas turunan untuk menulis ulang implementasi method yang diwariskan dari kelas induk agar menghasilkan perilaku yang lebih spesifik.

---

# 📌 BAGIAN 1: LAPORAN TUGAS PRAKTIKUM 1 (PEMODELAN ELEKTRONIK)
> **Deskripsi**: Pemodelan perangkat elektronik rumah tangga yang mencakup kelas induk `KipasAngin`, kelas turunan `KipasBerdiri` dan `KipasKecil`, serta kelas mandiri `RiceCooker`.

---

### 🔹 Langkah 1.1: Superclass `KipasAngin.java`
Mendefinisikan atribut dasar kipas angin (status daya, warna, jumlah bilah, level kecepatan) serta method penambah kecepatan dengan batas maksimum level 3.

**Source Code:**
```java
package TugasPraktikum1;

public class KipasAngin {
    private boolean isPowerOn;
    private String warna;
    private int jumlahBilah;
    private int levelSpeed;

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    public void warnaKipas(String warnaKipas) {
        warna = warnaKipas;
    }

    public void jumlahBilah(int jumlah) {
        jumlahBilah = jumlah;
    }

    public void tambahKecepatan(int increment) {
        levelSpeed += increment;
        if (levelSpeed > 3) {
            levelSpeed = 3;
        }
    }

    public void printInfo() {
        System.out.println("=============================");
        System.out.println("Warna Kipas : " + warna);
        System.out.println("Status Menyala : " + isPowerOn);
        System.out.println("Jumlah Bilah: " + jumlahBilah);
        System.out.println("Kecepatan : " + levelSpeed);
    }
}
```

---

### 🔹 Langkah 1.2: Subclass `KipasBerdiri.java` (Inheritance & Overriding)
Mewarisi `KipasAngin` dan menambahkan atribut khusus kipas berdiri yaitu tinggi maksimal (`tinggiMaksimal`) dan osilasi putar (`isSwingOn`).

**Source Code:**
```java
package TugasPraktikum1;

public class KipasBerdiri extends KipasAngin {
    private int tinggiMaksimal;
    private boolean isSwingOn;

    public void setTinggiMaksimal(int tinggi) {
        tinggiMaksimal = tinggi;
    }

    public void setSwingOn(boolean swingOn) {
        isSwingOn = swingOn;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tinggi Maksimal: " + tinggiMaksimal + "cm");
        System.out.println("Swing: " + isSwingOn);
        System.out.println("Tipe Kipas: Kipas Berdiri");
    }
}
```

---

### 🔹 Langkah 1.3: Subclass `KipasKecil.java` (Inheritance & Overriding)
Mewarisi `KipasAngin` dan menambahkan atribut spesifik kipas portabel/kecil yaitu panjang kabel (`panjangKabel`) dan tipe sambungan listrik (`tipePower`).

**Source Code:**
```java
package TugasPraktikum1;

public class KipasKecil extends KipasAngin {
    private int panjangKabel;
    private String tipePower;

    public void setPanjangKabel(int kabel) {
        panjangKabel = kabel;
    }

    public void setTipePower(String power) {
        tipePower = power;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Panjang Kabel: " + panjangKabel + "cm");
        System.out.println("Tipe Power/Colokan : " + tipePower);
        System.out.println("Tipe Kipas: Kipas Kecil");
    }
}
```

---

### 🔹 Langkah 1.4: Standalone Class `RiceCooker.java`
Memodelkan entitas penanak nasi mandiri dengan atribut nama objek, merek, kapasitas wadah (liter), dan mode memasak.

**Source Code:**
```java
package TugasPraktikum1;

public class RiceCooker {
    private String namaObjek;
    private String brand;
    private double kapasitas;
    private String mode;

    public void setNamaObjek(String namaObjek) {
        this.namaObjek = namaObjek;
    }

    public void setBrand(String namaBrand) {
        brand = namaBrand;
    }

    public void setKapasitas(double kapasitasWadah) {
        kapasitas = kapasitasWadah;
    }

    public void setMode(String modeMasak) {
        mode = modeMasak;
    }

    public void printInfo() {
        System.out.println("======================");
        System.out.println("Objek: " + namaObjek);
        System.out.println("Brand:" + brand);
        System.out.println("Kapasitas:" + kapasitas + " liter");
        System.out.println("Mode saat ini: " + mode);
    }
}
```

---

### 🔹 Langkah 1.5: Main Class `Demo.java`
Program driver yang menginstansiasi dan menguji seluruh objek perangkat elektronik di atas.

**Source Code:**
```java
package TugasPraktikum1;

public class Demo {
    public static void main(String[] args) {
        KipasAngin kipas1 = new KipasAngin();
        KipasAngin kipas2 = new KipasAngin();
        KipasBerdiri kipasBerdiri = new KipasBerdiri();
        KipasKecil kipasKecil = new KipasKecil();
        RiceCooker riceCooker = new RiceCooker();

        // Uji Objek 1
        kipas1.warnaKipas("Putih");
        kipas1.setPowerOn(true);
        kipas1.jumlahBilah(3);
        kipas1.tambahKecepatan(2);
        kipas1.printInfo();

        // Uji Objek 2
        kipas2.warnaKipas("Hitam");
        kipas2.setPowerOn(false);
        kipas2.jumlahBilah(4);
        kipas2.tambahKecepatan(3);
        kipas2.printInfo();

        // Uji Objek 3: Kipas Berdiri
        kipasBerdiri.warnaKipas("Biru");
        kipasBerdiri.setPowerOn(true);
        kipasBerdiri.jumlahBilah(3);
        kipasBerdiri.tambahKecepatan(2);
        kipasBerdiri.setTinggiMaksimal(150);
        kipasBerdiri.setSwingOn(true);
        kipasBerdiri.printInfo();

        // Uji Objek 4: Kipas Kecil
        kipasKecil.warnaKipas("Merah");
        kipasKecil.setPowerOn(true);
        kipasKecil.jumlahBilah(4);
        kipasKecil.tambahKecepatan(3);
        kipasKecil.setPanjangKabel(100);
        kipasKecil.setTipePower("USB");
        kipasKecil.printInfo();

        // Uji Objek 5: Rice Cooker
        riceCooker.setNamaObjek("Rice Cooker");
        riceCooker.setBrand("Miyako");
        riceCooker.setKapasitas(2);
        riceCooker.setMode("Masak");
        riceCooker.printInfo();
    }
}
```

---

### 💻 Kompilasi dan Hasil Eksekusi Tugas Praktikum 1:

**Perintah Terminal:**
```bash
javac TugasPraktikum1/*.java
java TugasPraktikum1.Demo
```

**Hasil Output Running:**
```text
=============================
Warna Kipas : Putih
Status Menyala : true
Jumlah Bilah: 3
Kecepatan : 2
=============================
Warna Kipas : Hitam
Status Menyala : false
Jumlah Bilah: 4
Kecepatan : 3
=============================
Warna Kipas : Biru
Status Menyala : true
Jumlah Bilah: 3
Kecepatan : 2
Tinggi Maksimal: 150cm
Swing: true
Tipe Kipas: Kipas Berdiri
=============================
Warna Kipas : Merah
Status Menyala : true
Jumlah Bilah: 4
Kecepatan : 3
Panjang Kabel: 100cm
Tipe Power/Colokan : USB
Tipe Kipas: Kipas Kecil
======================
Objek: Rice Cooker
Brand:Miyako
Kapasitas:2.0 liter
Mode saat ini: Masak
```

---

# 📌 BAGIAN 2: LAPORAN PERCOBAAN PRAKTIKUM (BIKEDEMO & ROADBIKE)
> **Deskripsi**: Pemodelan objek sepeda dengan pengaturan batas kecepatan berbasis sistem gigi (*gear speed limits*) serta pembuatan kelas turunan `RoadBike` dengan atribut ukuran lebar ban.

---

### 🔹 Langkah 2.1: Superclass `Bike.java`
Mendefinisikan entitas sepeda dengan batas kecepatan bertingkat sesuai posisi gigi (`gear`).

**Source Code `Bike.java`:**
```java
public class Bike {
    private String brand;
    private int speed;
    private int gear = 1;
    // Gear 1: max 5 km/h, Gear 2: max 10 km/h, ... Gear 6: max 60 km/h
    private final int[] GEAR_SPEED_LIMITS = {5, 10, 25, 30, 40, 60};

    public void setBrand(String brandName) {
        brand = brandName;
    }

    public void gearChanges(int gearValue) {
        if (gearValue < 1 || gearValue > 6) {
            System.out.println("Invalid gear value. Gear must be between 1 and 6.");
        } else {
            gear = gearValue;
        }
    }

    public int speedAcceleration(int increment) {
        speed += increment;
        if (speed > GEAR_SPEED_LIMITS[gear - 1]) {
            speed = GEAR_SPEED_LIMITS[gear - 1];
        }
        return speed;
    }

    public int speedDeceleration(int decrement) {
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        return speed;
    }

    public void printInfo() {
        System.out.println("Brand : " + brand);
        System.out.println("Speed : " + speed);
        System.out.println("Gear : " + gear);
    }
}
```

---

### 🔹 Langkah 2.2: Subclass `RoadBike.java` (Inheritance & Overriding)
Mewarisi `Bike` dan menambahkan atribut ukuran lebar ban (`tireWidth`) dalam satuan milimeter.

**Source Code `RoadBike.java`:**
```java
public class RoadBike extends Bike {
    private int tireWidth;

    public void setTireWidth(int width) {
        tireWidth = width;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tire Width: " + tireWidth + "mm");
        System.out.println("Bike Type : Road Bike");
    }
}
```

---

### 🔹 Langkah 2.3: Driver Class `BikeDemo.java`
Menginstansiasi objek sepeda gunung (`mountainBike1`, `mountainBike2`) dan sepeda balap (`roadBike1`) serta menampilkan informasinya.

**Source Code `BikeDemo.java`:**
```java
public class BikeDemo {
    public static void main(String[] args) {
        Bike mountainBike1 = new Bike();
        Bike mountainBike2 = new Bike();
        RoadBike roadBike1 = new RoadBike();

        mountainBike1.setBrand("Trek");
        mountainBike1.speedAcceleration(10);
        mountainBike1.printInfo();

        mountainBike2.setBrand("Giant");
        mountainBike2.speedAcceleration(20);
        mountainBike2.gearChanges(3);
        mountainBike2.printInfo();

        roadBike1.setBrand("Specialized");
        roadBike1.setTireWidth(25);
        roadBike1.speedAcceleration(15);
        roadBike1.gearChanges(4);
        roadBike1.printInfo();
    }
}
```

---

### 💻 Kompilasi dan Hasil Eksekusi Percobaan BikeDemo:

**Perintah Terminal:**
```bash
javac Bike.java RoadBike.java BikeDemo.java
java BikeDemo
```

**Hasil Output Running:**
```text
Brand : Trek
Speed : 5
Gear : 1
Brand : Giant
Speed : 5
Gear : 3
Brand : Specialized
Speed : 5
Gear : 4
Tire Width: 25mm
Bike Type : Road Bike
```

---

# 📝 BAGIAN 3: JAWABAN PERTANYAAN PRAKTIKUM

### 1. Jelaskan perbedaan antara object dengan class!
* **Class** adalah cetakan (*blueprint*), templat, atau definisi abstrak yang menentukan atribut (data) dan method (perilaku) yang dimiliki oleh suatu entitas atau objek.
* **Object** adalah wujud nyata (*instance*) yang dibuat dari sebuah class di memori komputer saat program berjalan, serta memiliki nilai konkret untuk atribut-atributnya.

---

### 2. Jelaskan alasan `gear` dan `brand` dapat menjadi atribut dari object `Bike`!
* Atribut merepresentasikan **karakteristik atau keadaan (*state*)** dari sebuah objek. `brand` merepresentasikan identitas/merek sepeda (misal: "Trek", "Giant"), sedangkan `gear` merepresentasikan kondisi posisi gigi sepeda saat ini. Karena kedua elemen ini merupakan informasi khas yang dimiliki oleh setiap sepeda, maka keduanya sangat tepat dijadikan atribut dari objek `Bike`.

---

### 3. Sebutkan salah satu kelebihan utama dari pemrograman berorientasi objek dibandingkan dengan pemrograman prosedural!
* **Reusability (Dapat Digunakan Kembali) & Modularitas**: OOP memungkinkan kita untuk memanfaatkan kembali kode yang sudah ada melalui konsep **Pewarisan (*Inheritance*)** dan **Enkapsulasi**. Hal ini membuat sistem lebih terstruktur, mudah dipelihara (*maintainable*), mudah dikembangkan, dan mengurangi duplikasi kode dibandingkan pemrograman prosedural.

---

### 4. Apakah diperbolehkan melakukan pendefinisian dua buah atribut dalam satu baris kode seperti `public String nama, alamat;`?
* **Ya, diperbolehkan secara sintaksis di bahasa Java**, asalkan kedua variabel memiliki tipe data yang sama. 
* **Catatan Best Practice**: Walaupun diperbolehkan, standar penulisan kode Java yang bersih (*clean code*) lebih menyarankan penulisan setiap atribut pada baris tersendiri untuk meningkatkan keterbacaan (*readability*) dan kemudahan dokumentasi kode.

---

### 5. Pada class `RoadBike`, jelaskan alasan atribut `brand`, `speed`, dan `gear` tidak lagi ditulis di dalam class tersebut!
* Atribut `brand`, `speed`, dan `gear` tidak perlu ditulis ulang di dalam class `RoadBike` karena class `RoadBike` menerapkan konsep **Pewarisan (*Inheritance*)** dengan melakukan `extends Bike`. 
* Sebagai *subclass* (kelas turunan), `RoadBike` secara otomatis mewarisi seluruh atribut dan method yang dimiliki oleh *superclass*-nya (`Bike`).

---

# 📌 BAGIAN 4: KESIMPULAN
1. Pemodelan berbasis objek pada studi kasus perangkat elektronik (`KipasAngin`, `RiceCooker`) dan kendaraan (`Bike`, `RoadBike`) berhasil merepresentasikan dunia nyata ke dalam kode program yang terstruktur dan modular.
2. Prinsip **Enkapsulasi** terbukti efektif dalam membatasi akses variabel secara langsung serta menjaga validitas data (seperti pembatasan kecepatan maksimum pada gigi tertentu dan level kecepatan kipas).
3. Penerapan **Inheritance** dan **Method Overriding** mempermudah perluasan fitur kelas (*extensibility*) tanpa melakukan duplikasi kode dari kelas induk, serta memungkinkan penambahan atribut spesifik pada kelas anak secara terisolasi.
