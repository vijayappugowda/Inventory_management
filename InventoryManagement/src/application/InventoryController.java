package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import java.io.FileWriter;

public class InventoryController {

    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, Integer> colId;
    @FXML private TableColumn<Product, String> colName, colCategory, colBarcode;
    @FXML private TableColumn<Product, Double> colPrice;
    @FXML private TableColumn<Product, Integer> colQuantity;
    @FXML private TextField barcodeInput;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        colName.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        colCategory.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCategory()));
        colPrice.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        colQuantity.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
        colBarcode.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getBarcode()));

        loadProducts();
    }

    private void loadProducts() {
        productTable.setItems(FXCollections.observableArrayList(ProductDAO.getAllProducts()));
    }

    @FXML
    public void searchProduct() {
        String barcode = barcodeInput.getText();
        if (!barcode.isEmpty()) {
            productTable.setItems(FXCollections.observableArrayList(
                ProductDAO.getAllProducts().stream()
                .filter(p -> p.getBarcode().equals(barcode))
                .toList()
            ));
        } else {
            loadProducts();
        }
    }

    @FXML
    public void exportCSV() {
        try {
            FileWriter writer = new FileWriter("inventory.csv");
            writer.append("ID,Name,Category,Price,Quantity,Barcode\n");
            for (Product p : ProductDAO.getAllProducts()) {
                writer.append(p.getId() + "," +
                              p.getName() + "," +
                              p.getCategory() + "," +
                              p.getPrice() + "," +
                              p.getQuantity() + "," +
                              p.getBarcode() + "\n");
            }
            writer.flush();
            writer.close();
            System.out.println("CSV exported successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
