package dataAccessObject;

import model.Penjualan;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Penjualandao {
	
	//read
    public List<Penjualan> getAllPenjualan() {
        List<Penjualan> daftarPenjualan = new ArrayList<>();
        String query = "SELECT * FROM penjualan";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) 
        {
        	while (rs.next()) { Penjualan p = new Penjualan
            		(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getDate("tanggal").toLocalDate(),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id") 
                    );
            
                daftarPenjualan.add(p); }
        	} 
        
        catch (SQLException e) { e.printStackTrace(); }
        return daftarPenjualan;
        
    }
    
    //create
    public boolean addPenjualan(Penjualan p) {
        String query = "INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
        	pstmt.setInt(1, p.getJumlah());
            pstmt.setDouble(2, p.getTotalHarga());
            pstmt.setDate(3, Date.valueOf(p.getTanggal()));
            pstmt.setInt(4, p.getPelanggan_id());
            pstmt.setInt(5, p.getBuku_id());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } 
        
        catch (SQLException e) { System.err.println("Gagal menambah data penjualan: " + e.getMessage());
        return false; }  
    }
    
    //update
    public boolean updatePenjualan(Penjualan p) {
        String query = "UPDATE penjualan SET jumlah = ?, total_harga = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
        	pstmt.setInt(1, p.getJumlah());
            pstmt.setDouble(2, p.getTotalHarga());
            pstmt.setDate(3, Date.valueOf(p.getTanggal()));
            pstmt.setInt(4, p.getPelanggan_id());
            pstmt.setInt(5, p.getBuku_id());
            pstmt.setInt(6, p.getPenjualan_id());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) { e.printStackTrace();
        return false; }
    }
    
    //delete
    public boolean deletePenjualan(int penjualan_id) {
        String query = "DELETE FROM penjualan WHERE penjualan_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
        	pstmt.setInt(1, penjualan_id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
 
        } catch (SQLException e) { e.printStackTrace();
        return false; }
    }
}
