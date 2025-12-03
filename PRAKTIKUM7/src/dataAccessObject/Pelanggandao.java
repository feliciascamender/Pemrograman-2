package dataAccessObject;

import model.Pelanggan;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pelanggandao {
	
	//read
	public List<Pelanggan> getAllPelanggan() {
        List<Pelanggan> daftarPelanggan = new ArrayList<>();
        String query = "SELECT * FROM pelanggan";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) 
        {
        	while (rs.next()) {
                Pelanggan p = new Pelanggan(
                    rs.getInt("pelanggan_id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon") );
                
                daftarPelanggan.add(p); }
        } catch (SQLException e) { e.printStackTrace(); }
        
        return daftarPelanggan;
    }
	
	//create
	public boolean addPelanggan(Pelanggan p) {
        String query = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) 
        {
        	pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getEmail());
            pstmt.setString(3, p.getTelepon());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } 
        
        catch (SQLException e) { System.err.println("Gagal menambah data: " + e.getMessage());
            
        return false; }
    }
	
	//update
	public boolean updatePelanggan(Pelanggan p) {
        String query = "UPDATE pelanggan SET nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
            pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getEmail());
            pstmt.setString(3, p.getTelepon());
            pstmt.setInt(4, p.getPelanggan_id());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } 
        
        catch (SQLException e) {e.printStackTrace();
            
        return false; }
    }
	
	//delete
	public boolean deletePelanggan(int pelanggan_id) {
        String query = "DELETE FROM pelanggan WHERE pelanggan_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        
        {
        	pstmt.setInt(1, pelanggan_id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } 
        
        catch (SQLException e) {e.printStackTrace();
            
        return false; }
        
	}
	
}
