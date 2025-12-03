package model;

import java.time.LocalDate;

public class Penjualan {
	    private int penjualan_id;
	    private int jumlah;
	    private double totalHarga;
	    private LocalDate tanggal;
	    private int pelanggan_id; 
	    private int buku_id;      

	    public Penjualan(int penjualan_id, int jumlah, double totalHarga, LocalDate tanggal, int pelanggan_id, int buku_id) {
	        this.penjualan_id = penjualan_id;
	        this.jumlah = jumlah;
	        this.totalHarga = totalHarga;
	        this.tanggal = tanggal;
	        this.pelanggan_id = pelanggan_id;
	        this.buku_id = buku_id;
	    }

	    public int getPenjualan_id() { return penjualan_id; }
	    public void setPenjualan_id(int penjualan_id) { this.penjualan_id = penjualan_id; }

	    public int getJumlah() { return jumlah; }
	    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

	    public double getTotalHarga() { return totalHarga; }
	    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }

	    public LocalDate getTanggal() { return tanggal; }
	    public void setTanggal(LocalDate tanggal) { this.tanggal = tanggal; }

	    public int getPelanggan_id() { return pelanggan_id; }
	    public void setPelanggan_id(int pelanggan_id) { this.pelanggan_id = pelanggan_id; }

	    public int getBuku_id() { return buku_id; }
	    public void setBuku_id(int buku_id) { this.buku_id = buku_id; }
	}

