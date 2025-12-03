package model;

public class Pelanggan {
	private int pelanggan_id;
    private String nama;
    private String email;
    private String telepon;

    public Pelanggan(int pelanggan_id, String nama, String email, String telepon) {
        this.pelanggan_id = pelanggan_id;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
    }

    public int getPelanggan_id() { return pelanggan_id; }
    public void setPelanggan_id(int pelanggan_id) { this.pelanggan_id = pelanggan_id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }
}
