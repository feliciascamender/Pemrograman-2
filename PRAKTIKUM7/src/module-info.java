/**
 * 
 */
/**
 * 
 */
module PRAKTIKUM7 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens model to javafx.base;
	opens controller to javafx.fxml;
	
	
	exports application;
}