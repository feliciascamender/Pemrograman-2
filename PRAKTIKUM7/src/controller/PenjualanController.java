package controller;

import dataAccessObject.Penjualandao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Penjualan;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PenjualanController {
    
    // fxml elements dari PenjualanView.fxml
    @FXML private TextField pelangganIdField;
    @FXML private TextField bukuIdField;
    @FXML private TextField jumlahField;
    @FXML private TextField totalHargaField;
    @FXML private TextField tanggalField; 
    
    @FXML private TableView<Penjualan> penjualanTable;
    @FXML private TableColumn<Penjualan, Integer> idPenjualanColumn;
    @FXML private TableColumn<Penjualan, Integer> idPelangganColumn;
    @FXML private TableColumn<Penjualan, Integer> idBukuColumn;
    @FXML private TableColumn<Penjualan, Integer> jumlahColumn;
    @FXML private TableColumn<Penjualan, Double> totalHargaColumn;
    @FXML private TableColumn<Penjualan, LocalDate> tanggalColumn;
    
    private Penjualandao penjualanDAO = new Penjualandao();
    private ObservableList<Penjualan> dataPenjualan = FXCollections.observableArrayList();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @FXML
    public void initialize() {
        // menghubungkan kolom tabel dengan properti di kelas Penjualan
        idPenjualanColumn.setCellValueFactory(new PropertyValueFactory<>("penjualan_id"));
        idPelangganColumn.setCellValueFactory(new PropertyValueFactory<>("pelanggan_id"));
        idBukuColumn.setCellValueFactory(new PropertyValueFactory<>("buku_id"));
        jumlahColumn.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        totalHargaColumn.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        
        penjualanTable.setItems(dataPenjualan);
        loadPenjualanData();

        // listener untuk mengisi form saat baris dipilih
        penjualanTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                pelangganIdField.setText(String.valueOf(newSelection.getPelanggan_id()));
                bukuIdField.setText(String.valueOf(newSelection.getBuku_id()));
                jumlahField.setText(String.valueOf(newSelection.getJumlah()));
                totalHargaField.setText(String.valueOf(newSelection.getTotalHarga()));
                tanggalField.setText(newSelection.getTanggal().format(DATE_FORMATTER));
            } else { 
                clearFields(); 
            }
        });
    }

    private void loadPenjualanData() {
        dataPenjualan.clear();
        dataPenjualan.addAll(penjualanDAO.getAllPenjualan());
    }

    // create
    @FXML
    private void handleAddPenjualan() {
        if (isInputValid()) {
            try {
                LocalDate tanggal = LocalDate.parse(tanggalField.getText(), DATE_FORMATTER);

                Penjualan p = new Penjualan(
                    0, // ID akan di-generate oleh DB
                    Integer.parseInt(jumlahField.getText()),
                    Double.parseDouble(totalHargaField.getText()),
                    tanggal,
                    Integer.parseInt(pelangganIdField.getText()),
                    Integer.parseInt(bukuIdField.getText())
                );

                if (penjualanDAO.addPenjualan(p)) { 
                    loadPenjualanData(); 
                    clearFields(); 
                    showAlert(AlertType.INFORMATION, "Sukses", "Data Penjualan berhasil ditambahkan."); 
                } else { 
                    showAlert(AlertType.ERROR, "Error", "Gagal menambah data Penjualan. Cek ID Pelanggan/Buku."); 
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                showAlert(AlertType.ERROR, "Input Salah", "Pastikan ID, Jumlah, Total Harga adalah angka, dan Tanggal format YYYY-MM-DD.");
            }
        }
    }
    
    // update
    @FXML
    private void handleUpdatePenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected != null && isInputValid()) {
            try {
                LocalDate tanggal = LocalDate.parse(tanggalField.getText(), DATE_FORMATTER);

                selected.setPelanggan_id(Integer.parseInt(pelangganIdField.getText()));
                selected.setBuku_id(Integer.parseInt(bukuIdField.getText()));
                selected.setJumlah(Integer.parseInt(jumlahField.getText()));
                selected.setTotalHarga(Double.parseDouble(totalHargaField.getText()));
                selected.setTanggal(tanggal);

                if (penjualanDAO.updatePenjualan(selected)) { 
                    loadPenjualanData(); 
                    clearFields(); 
                    showAlert(AlertType.INFORMATION, "Sukses", "Data Penjualan berhasil diperbarui."); 
                } else { 
                    showAlert(AlertType.ERROR, "Error", "Gagal memperbarui data Penjualan."); 
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                showAlert(AlertType.ERROR, "Input Salah", "Pastikan format input benar.");
            }
        } else if (selected == null) { 
            showAlert(AlertType.WARNING, "Peringatan", "Pilih data Penjualan yang ingin diubah."); 
        }
    }

    // delete
    @FXML
    private void handleDeletePenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (penjualanDAO.deletePenjualan(selected.getPenjualan_id())) { 
                loadPenjualanData(); 
                clearFields(); 
                showAlert(AlertType.INFORMATION, "Sukses", "Data Penjualan berhasil dihapus."); 
            } else { 
                showAlert(AlertType.ERROR, "Error", "Gagal menghapus data Penjualan."); 
            }
        } else { 
            showAlert(AlertType.WARNING, "Peringatan", "Pilih data Penjualan yang ingin dihapus."); 
        }
    }

    // validasi dan alert
    private boolean isInputValid() {
        String errorMessage = "";
        if (pelangganIdField.getText() == null || pelangganIdField.getText().trim().isEmpty()) {
            errorMessage += "ID Pelanggan tidak boleh kosong!\n";
        }
        if (bukuIdField.getText() == null || bukuIdField.getText().trim().isEmpty()) {
            errorMessage += "ID Buku tidak boleh kosong!\n";
        }
        if (jumlahField.getText() == null || jumlahField.getText().trim().isEmpty()) {
            errorMessage += "Jumlah tidak boleh kosong!\n";
        }
        if (totalHargaField.getText() == null || totalHargaField.getText().trim().isEmpty()) {
            errorMessage += "Total Harga tidak boleh kosong!\n";
        }
        if (tanggalField.getText() == null || tanggalField.getText().trim().isEmpty()) {
            errorMessage += "Tanggal tidak boleh kosong (YYYY-MM-DD)!\n";
        }
        
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showAlert(AlertType.ERROR, "Input Tidak Valid", errorMessage);
            return false;
        }
    }
    
    private void clearFields() {
        pelangganIdField.clear();
        bukuIdField.clear();
        jumlahField.clear();
        totalHargaField.clear();
        tanggalField.clear();
        penjualanTable.getSelectionModel().clearSelection();
    }
    
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}