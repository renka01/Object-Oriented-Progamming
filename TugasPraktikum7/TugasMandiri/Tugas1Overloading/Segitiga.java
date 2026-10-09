package TugasPraktikum7.TugasMandiri.Tugas1Overloading;

public class Segitiga {
    private int sudut;

    // Overload 1: 1 sudut diketahui
    public int sisaSudut(int sudutA) {
        if (sudutA <= 0 || sudutA >= 180) {
            throw new IllegalArgumentException("Sudut harus lebih dari 0 dan kurang dari 180!");
        }
        this.sudut = 180 - sudutA;
        return this.sudut;
    }

    // Overload 2: 2 sudut diketahui
    public int sisaSudut(int sudutA, int sudutB) {
        int total = sudutA + sudutB;
        if (total <= 0 || total >= 180) {
            throw new IllegalArgumentException("Jumlah sudut harus lebih dari 0 dan kurang dari 180!");
        }
        this.sudut = 180 - total;
        return this.sudut;
    }

    // Overload 3: Keliling segitiga sembarang (3 parameter int)
    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    // Overload 4: Keliling segitiga siku-siku (2 parameter int, return double)
    public double keliling(int sisiA, int sisiB) {
        double c = Math.sqrt((sisiA * sisiA) + (sisiB * sisiB));
        return (sisiA + sisiB + c);
    }

    public int getSudut() {
        return this.sudut;
    }
}
