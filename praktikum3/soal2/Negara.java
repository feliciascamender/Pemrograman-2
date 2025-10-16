package praktikum3.soal2;

import java.util.HashMap;

class Negara {
    private String nama;
    private String jenis;
    private String namaPemimpin;
    private int tanggal;
    private int bulan;
    private int tahun;

    public Negara(String nama, String jenis, String namaPemimpin, int tanggal, int bulan, int tahun) {
        this.nama = nama;
        this.jenis = jenis;
        this.namaPemimpin = namaPemimpin;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public Negara(String nama, String jenis, String namaPemimpin) {
        this.nama = nama;
        this.jenis = jenis;
        this.namaPemimpin = namaPemimpin;
    }

    public int getBulan() {
        return bulan;
    }

    public void tampilkan(HashMap<Integer, String> daftarBulan) {
        if (jenis.equalsIgnoreCase("monarki")) {
            System.out.println("Negara " + nama + " mempunyai Raja bernama " + namaPemimpin + "\n");
        } else {
            String bulanTeks = daftarBulan.get(bulan);
            String jabatan = jenis.equalsIgnoreCase("presiden") ? "Presiden" : "Perdana Menteri";
            System.out.println("Negara " + nama + " mempunyai " + jabatan + " bernama " + namaPemimpin  +  
                    "\nDeklarasi Kemerdekaan pada Tanggal " + tanggal + " " + bulanTeks + " " + tahun + "\n");
        }
    }
}