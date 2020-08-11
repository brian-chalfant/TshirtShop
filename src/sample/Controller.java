package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.swing.*;


public class Controller {
    final private double TAXRATE = 1.04167;
    final private double COST = 10.00;
    public GridPane contentContainer;
    public TextField quantityTextfield;
    public Label totalcostLabel;
    public Label totalcostDisplay;
    public Button clearButton;
    public Button submit;
    public Button Quit;
    public Label quantityLabel;
    public Label titleLabel0;
    public Label titleLabel1;
    public Label subtotalLabel;
    public Label subtotalCostDisplay;
    public Label taxLabel;
    public Label taxCostDisplay;
    public GridPane root;


    public void initialize() {
        quantityTextfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                submit.setDisable(quantityTextfield.getText().isEmpty() || quantityTextfield.getText().trim().isEmpty());
            }
        });
    }

    public void calculateCost(ActionEvent actionevent){
        try {
            int quantity = Integer.parseInt(quantityTextfield.getText());
            double subtotal = (quantity * COST);
            double tax = (subtotal * (TAXRATE - 1));
            double cost = subtotal * TAXRATE;
            subtotalCostDisplay.setText(String.format("$%.2f", subtotal));
            taxCostDisplay.setText(String.format("$%.2f", tax));
            totalcostDisplay.setText(String.format("$%.2f", cost));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR! Check your input");
        }
    }

    public void quitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void clear(){
        subtotalCostDisplay.setText("");
        taxCostDisplay.setText("");
        totalcostDisplay.setText("");
        quantityTextfield.clear();
        submit.setDisable(true);
    }
}

