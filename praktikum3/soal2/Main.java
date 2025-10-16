package praktikum3.soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Negara> daftarNegara = new LinkedList<>();
        HashMap<Integer, String> daftarBulan = new HashMap<>();

        daftarBulan.put(1, "Januari");
        daftarBulan.put(2, "Februari");
        daftarBulan.put(3, "Maret");
        daftarBulan.put(4, "April");
        daftarBulan.put(5, "Mei");
        daftarBulan.put(6, "Juni");
        daftarBulan.put(7, "Juli");
        daftarBulan.put(8, "Agustus");
        daftarBulan.put(9, "September");
        daftarBulan.put(10, "Oktober");
        daftarBulan.put(11, "November");
        daftarBulan.put(12, "Desember");

        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++) {
            String nama = input.nextLine();
            String jenis = input.nextLine();
            String namaPemimpin = input.nextLine();

            if (jenis.equalsIgnoreCase("monarki")) {
                daftarNegara.add(new Negara(nama, jenis, namaPemimpin));
            } else {
                int tanggal = input.nextInt();
                int bulan = input.nextInt();
                int tahun = input.nextInt();
                input.nextLine();
                daftarNegara.add(new Negara(nama, jenis, namaPemimpin, tanggal, bulan, tahun));
            }
        }

        for (Negara n : daftarNegara) {
            n.tampilkan(daftarBulan);
        }

        input.close();
    }
}