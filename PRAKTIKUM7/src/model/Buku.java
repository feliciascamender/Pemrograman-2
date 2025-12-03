package model;

public class Buku {
	private int buku_id;
    private String judul;
    private String penulis;
    private double harga;
    private int stok;

    public Buku(int buku_id, String judul, String penulis, double harga, int stok) {
        this.buku_id = buku_id;
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }


    public int getBuku_id() { return buku_id;}
    public void setBuku_id(int buku_id) { this.buku_id = buku_id;}
    
    public String getJudul() { return judul;}
    public void setJudul(String judul) { this.judul = judul;}
    
    public String getPenulis() {return penulis;}
    public void setPenulis(String penulis) {this.penulis = penulis;}
    
    public double getHarga() {return harga;}
    public void setHarga(double harga) {this.harga = harga;}
    
    public int getStok() {return stok;}
    public void setStok(int stok) {this.stok = stok;}
}
