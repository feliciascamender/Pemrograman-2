package Controller;

import Model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TableView<Mahasiswa> tableMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    @FXML
    public void initialize() {

        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tableMahasiswa.setItems(getDataMahasiswa());
    }

    private ObservableList<Mahasiswa> getDataMahasiswa() {
        return FXCollections.observableArrayList(
                new Mahasiswa("1234", "Felicia"),
                new Mahasiswa("1345", "Caleb"),
                new Mahasiswa("1456", "Rafayel"),
                new Mahasiswa("1567", "Zayne"),
                new Mahasiswa("1678", "Xavier"),
                new Mahasiswa("1890", "Vilhelm"),
                new Mahasiswa("1901", "Maul"),
                new Mahasiswa("1023", "Luke"),
                new Mahasiswa("1123", "Artem"),
                new Mahasiswa("1223", "Marius")
        );
    }
}
