package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) { try
	{ primaryStage.setTitle("PRAKTUKUM&");
	TabPane tabPane = new TabPane();
	
//Pelanggan
	Tab pelangganTab = new Tab("Data Pelanggan");
	pelangganTab.setContent (FXMLLoader.load(getClass().getResource("/view/PelangganView.fxml")));
	pelangganTab.setClosable(false);
	
//Data Buku
	Tab bukuTab = new Tab("Data Buku");
	bukuTab.setContent(FXMLLoader.load(getClass().getResource("/view/BukuView.fxml")));
	bukuTab.setClosable(false);
	
//Data Penjualan
	Tab penjualanTab = new Tab("Data Penjualan");
	penjualanTab.setContent(FXMLLoader.load(getClass().getResource("/view/PenjualanView.fxml")));
	penjualanTab.setClosable(false);
	
	tabPane.getTabs().addAll(pelangganTab, bukuTab, penjualanTab);
	Scene scene = new Scene(tabPane, 800, 600);
	
	primaryStage.setScene(scene);
	primaryStage.show(); }
	
	catch (Exception e) {e.printStackTrace(); }
	}
	
	public static void main(String[] args) { launch(args);}

}
