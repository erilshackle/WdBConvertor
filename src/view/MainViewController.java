/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

import convertor.ConvertionType;
import convertor.Convertor;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MainViewController implements Initializable {


    @FXML
    private TextField txtInput;
    @FXML
    private TextField txtResult;
    @FXML
    private Label lblErrorMsg;
    @FXML
    private ComboBox<ConvertionType> cbxConvertion;
    @FXML
    private Label lblInfo;
    
    ConvertionType ct;
    Double result;
    String output;
    final DecimalFormat df = new DecimalFormat();
    @FXML
    private Label lblFormula;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxConvertion.setItems(FXCollections.observableArrayList(ConvertionType.values()));
        cbxConvertion.getSelectionModel().select(ConvertionType.dBW_watt);
        ct = cbxConvertion.getSelectionModel().getSelectedItem();
        lblFormula.setText(ct.getFormula());
        lblInfo.setText("Conversão de "+ct.getDescription());
        
        df.setMaximumFractionDigits(6);
        
        // previne entrada invalida. ex: letras e simbolos (nao numeros)
        txtInput.textProperty().addListener((ObservableValue<? extends String> 
                observable, String oldValue, String newValue) -> {
                if(!newValue.matches("ˆ([+-]?\\d*\\.?\\d*)$")){
                    txtInput.setText(newValue.replaceAll("ˆ[0-9.]", ""));
                }
                convertResult();
        });
    }    

    @FXML
    private void checkInput(KeyEvent event) {
        try{
            if(txtInput.getText().isBlank()){
                lblErrorMsg.setText("");
                txtResult.clear();
            } else
            if(!txtInput.getText().matches("\\d*[.]?\\d*")){
                lblErrorMsg.setText("Entrada Inválida");
            } else {
                lblErrorMsg.setText("");
            }
            //double value = Double.parseDouble(txtInput.getText());
        } catch (NumberFormatException err){}
    }

    private void convertResult(){
        try{
            double val = Double.parseDouble(txtInput.getText());
            ct = cbxConvertion.getSelectionModel().getSelectedItem();
            result = Convertor.convert(val, ct);
            output = Double.toString(result);
            output = df.format(result);
            txtResult.setText(output);
            lblFormula.setText(ct.getFormula());
        }catch(NumberFormatException err){
            txtResult.setText("inválido");
        }
    }

    @FXML
    private void selectConvertion(ActionEvent event) {
        ct = cbxConvertion.getSelectionModel().getSelectedItem();
        txtInput.clear();
        txtResult.clear();
        lblFormula.setText(ct.getFormula());
        lblInfo.setText("Conversão de "+ct.getDescription());
        txtInput.requestFocus();
    }
    
}