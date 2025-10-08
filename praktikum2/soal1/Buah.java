package praktikum2.soal1;

public class Buah {
    public String nama;
    public double berat; 
    public double harga; 
    public double jumlahBeli; 

    public Buah(String nama, double berat, double harga, double jumlahBeli) {
        this.nama = nama;
        this.berat = berat;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
    }

    public double getHargaSebelumDiskon() {
        double jumlahUnit = jumlahBeli / berat;
        return jumlahUnit * harga;
    }

    public double getTotalDiskon() {
        return getHargaSebelumDiskon() * 0.02 * berat;
    }

    public double getHargaSetelahDiskon() {
        return getHargaSebelumDiskon() - getTotalDiskon();
    }

    public void showInfo() {
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", getHargaSebelumDiskon());
        System.out.printf("Total Diskon: Rp%.2f%n", getTotalDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n%n", getHargaSetelahDiskon());
    }
}
