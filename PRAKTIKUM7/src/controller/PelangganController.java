package controller;

import dataAccessObject.Pelanggandao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pelanggan;

public class PelangganController {

    @FXML private TextField namaField;
    @FXML private TextField emailField;
    @FXML private TextField teleponField;
    @FXML private TableView<Pelanggan> pelangganTable;
    @FXML private TableColumn<Pelanggan, String> namaColumn;
    @FXML private TableColumn<Pelanggan, String> emailColumn;
    @FXML private TableColumn<Pelanggan, String> teleponColumn;

    private Pelanggandao pelanggandao = new Pelanggandao();
    private ObservableList<Pelanggan> dataPelanggan = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // menghubungkan kolom tabel dengan properti kelas Pelanggan
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        teleponColumn.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        pelangganTable.setItems(dataPelanggan);
        
        // listener untuk mengisi form saat baris dipilih
        pelangganTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                namaField.setText(newSelection.getNama());
                emailField.setText(newSelection.getEmail());
                teleponField.setText(newSelection.getTelepon());
            } else {
                clearFields();
            }
        });

        loadPelangganData();
    }

    private void loadPelangganData() {
        dataPelanggan.clear();
        dataPelanggan.addAll(pelanggandao.getAllPelanggan());
    }

    // create
    @FXML
    private void handleAddPelanggan() {
        if (isInputValid()) {
            Pelanggan p = new Pelanggan(0, namaField.getText(), emailField.getText(), teleponField.getText());
            if (pelanggandao.addPelanggan(p)) {
                loadPelangganData();
                clearFields();
                showAlert(AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil ditambahkan.");
            } else {
                showAlert(AlertType.ERROR, "Error", "Gagal menambah data. Email mungkin sudah terdaftar.");
            }
        }
    }

    // update
    @FXML
    private void handleUpdatePelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected != null && isInputValid()) {
            selected.setNama(namaField.getText());
            selected.setEmail(emailField.getText());
            selected.setTelepon(teleponField.getText());

            if (pelanggandao.updatePelanggan(selected)) {
                loadPelangganData();
                clearFields();
                showAlert(AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil diperbarui.");
            } else {
                showAlert(AlertType.ERROR, "Error", "Gagal memperbarui data pelanggan.");
            }
        } else if (selected == null) {
            showAlert(AlertType.WARNING, "Peringatan", "Pilih data yang ingin diubah.");
        }
    }

    // delete
    @FXML
    private void handleDeletePelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (pelanggandao.deletePelanggan(selected.getPelanggan_id())) {
                loadPelangganData();
                clearFields();
                showAlert(AlertType.INFORMATION, "Sukses", "Data Pelanggan berhasil dihapus.");
            } else {
                showAlert(AlertType.ERROR, "Error", "Gagal menghapus data pelanggan.");
            }
        } else {
            showAlert(AlertType.WARNING, "Peringatan", "Pilih data yang ingin dihapus.");
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (namaField.getText() == null || namaField.getText().trim().isEmpty()) {
            errorMessage += "Nama tidak boleh kosong!\n";
        }
        if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {
            errorMessage += "Email tidak boleh kosong!\n";
        }
        if (teleponField.getText() == null || teleponField.getText().trim().isEmpty()) {
            errorMessage += "Telepon tidak boleh kosong!\n";
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showAlert(AlertType.ERROR, "Input Tidak Valid", errorMessage);
            return false;
        }
    }

    private void clearFields() {
        namaField.clear();
        emailField.clear();
        teleponField.clear();
        pelangganTable.getSelectionModel().clearSelection();
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}