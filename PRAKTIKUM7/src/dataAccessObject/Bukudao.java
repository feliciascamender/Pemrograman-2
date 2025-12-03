package dataAccessObject;

import model.Buku;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bukudao {
	public List<Buku> getAllBuku() {
		List<Buku> daftarBuku = new ArrayList<>();
		String quer = "SELECT * FROM buku";
		try (Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(quer))
		{while (rs.next()) {
            daftarBuku.add(new Buku(rs.getInt("buku_id"), rs.getString("judul"), 
                    rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok"))); }
		} catch (SQLException e) { e.printStackTrace(); }
        return daftarBuku;}

//create
	public boolean addBuku(Buku b) { 
		String query = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query))
        { pstmt.setString(1, b.getJudul());
        pstmt.setString(2, b.getPenulis());
        pstmt.setDouble(3, b.getHarga());
        pstmt.setInt(4, b.getStok());
        return pstmt.executeUpdate() > 0; }
        
        catch (SQLException e) { System.err.println("Gagal menambah data buku: " + e.getMessage()); return false;
        }
	}
        
//update
        public boolean updateBuku(Buku b) {
            String query = "UPDATE buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) 
            {   pstmt.setString(1, b.getJudul()); pstmt.setString(2, b.getPenulis());
            pstmt.setDouble(3, b.getHarga()); pstmt.setInt(4, b.getStok());
            pstmt.setInt(5, b.getBuku_id());
            return pstmt.executeUpdate() > 0; }
              
            
            catch (SQLException e) { e.printStackTrace(); return false; }
            }
 
        
//delete
        public boolean deleteBuku(int buku_id) {
            String query = "DELETE FROM buku WHERE buku_id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) 
            { pstmt.setInt(1, buku_id);
            return pstmt.executeUpdate() > 0; } 
            
            catch (SQLException e) { e.printStackTrace(); return false; }
        }
  }


