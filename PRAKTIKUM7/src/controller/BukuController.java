package controller;

import dataAccessObject.Bukudao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Buku;

public class BukuController {
    
    // fxml elements dari BukuView.fxml
    @FXML private TextField judulField;
    @FXML private TextField penulisField;
    @FXML private TextField hargaField;
    @FXML private TextField stokField;
    @FXML private TableView<Buku> bukuTable;
    @FXML private TableColumn<Buku, String> judulColumn;
    @FXML private TableColumn<Buku, String> penulisColumn;
    @FXML private TableColumn<Buku, Double> hargaColumn;
    @FXML private TableColumn<Buku, Integer> stokColumn;
    
    private Bukudao bukudao = new Bukudao();
    private ObservableList<Buku> dataBuku = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // mengaitkan kolom tabel dengan properti di kelas Buku
        judulColumn.setCellValueFactory(new PropertyValueFactory<>("judul"));
        penulisColumn.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        hargaColumn.setCellValueFactory(new PropertyValueFactory<>("harga"));
        stokColumn.setCellValueFactory(new PropertyValueFactory<>("stok"));
        
        bukuTable.setItems(dataBuku);
        loadBukuData();

        // listener untuk mengisi form saat baris dipilih
        bukuTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                judulField.setText(newSelection.getJudul());
                penulisField.setText(newSelection.getPenulis());
                hargaField.setText(String.valueOf(newSelection.getHarga()));
                stokField.setText(String.valueOf(newSelection.getStok()));
            } else { 
                clearFields(); 
            }
        });
    }

    private void loadBukuData() {
        dataBuku.clear();
        dataBuku.addAll(bukudao.getAllBuku());
    }

    // create
    @FXML
    private void handleAddBuku() {
        if (isInputValid()) {
            try {
                Buku b = new Buku(
                    0, // ID akan di-generate oleh DB
                    judulField.getText(),
                    penulisField.getText(),
                    Double.parseDouble(hargaField.getText()),
                    Integer.parseInt(stokField.getText())
                );

                if (bukudao.addBuku(b)) { 
                    loadBukuData(); 
                    clearFields(); 
                    showAlert(AlertType.INFORMATION, "Sukses", "Data Buku berhasil ditambahkan."); 
                } else { 
                    showAlert(AlertType.ERROR, "Error", "Gagal menambah data buku."); 
                }
            } catch (NumberFormatException e) {
                showAlert(AlertType.ERROR, "Input Salah", "Harga dan Stok harus berupa angka.");
            }
        }
    }
    
    // update
    @FXML
    private void handleUpdateBuku() {
         Buku selected = bukuTable.getSelectionModel().getSelectedItem();
         if (selected != null && isInputValid()) {
             try {
                 selected.setJudul(judulField.getText());
                 selected.setPenulis(penulisField.getText());
                 selected.setHarga(Double.parseDouble(hargaField.getText()));
                 selected.setStok(Integer.parseInt(stokField.getText()));
                 
                 if (bukudao.updateBuku(selected)) { 
                     loadBukuData(); 
                     clearFields(); 
                     showAlert(AlertType.INFORMATION, "Sukses", "Data Buku berhasil diperbarui."); 
                 } else { 
                     showAlert(AlertType.ERROR, "Error", "Gagal memperbarui data buku."); 
                 }
             } catch (NumberFormatException e) {
                 showAlert(AlertType.ERROR, "Input Salah", "Harga dan Stok harus berupa angka.");
             }
         } else if (selected == null) { 
             showAlert(AlertType.WARNING, "Peringatan", "Pilih data buku yang ingin diubah."); 
         }
    }

    // delete
    @FXML
    private void handleDeleteBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (bukudao.deleteBuku(selected.getBuku_id())) { 
                loadBukuData(); 
                clearFields(); 
                showAlert(AlertType.INFORMATION, "Sukses", "Data Buku berhasil dihapus."); 
            } else { 
                showAlert(AlertType.ERROR, "Error", "Gagal menghapus data buku."); 
            }
        } else { 
            showAlert(AlertType.WARNING, "Peringatan", "Pilih data buku yang ingin dihapus."); 
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (judulField.getText() == null || judulField.getText().trim().isEmpty()) {
            errorMessage += "Judul tidak boleh kosong!\n";
        }
        if (penulisField.getText() == null || penulisField.getText().trim().isEmpty()) {
            errorMessage += "Penulis tidak boleh kosong!\n";
        }
        if (hargaField.getText() == null || hargaField.getText().trim().isEmpty()) {
            errorMessage += "Harga tidak boleh kosong!\n";
        }
        if (stokField.getText() == null || stokField.getText().trim().isEmpty()) {
            errorMessage += "Stok tidak boleh kosong!\n";
        }
        
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showAlert(AlertType.ERROR, "Input Tidak Valid", errorMessage);
            return false;
        }
    }
    
    private void clearFields() {
        judulField.clear();
        penulisField.clear();
        hargaField.clear();
        stokField.clear();
        bukuTable.getSelectionModel().clearSelection();
    }
    
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}