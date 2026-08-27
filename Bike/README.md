# Tugas Praktikum Pemrograman Berorientasi Objek (OOP) - BikeDemo

Repositori ini berisi tugas percobaan dan pertanyaan mengenai konsep Pemrograman Berorientasi Objek (OOP) menggunakan bahasa pemrograman Java.

---

## 📝 Jawaban Pertanyaan Tugas

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
