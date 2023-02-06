package com.example.combovox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label label1;
    @FXML
    private ComboBox ComboBox1 ;
    @FXML
    private ComboBox<String> ComboBox2 ;
    @FXML
    private Button button1 ;


    ArrayList<Cerveza> cervezas = new ArrayList<>();

    @FXML
    protected void cargarCervezas1() {
        cervezas.add(new Cerveza("rubia","mahou", 1.00));
        cervezas.add(new Cerveza("rubia","mahou", 1.00));
        cervezas.add(new Cerveza("rubia","mahou", 1.00));

        cervezas.add(new Cerveza("tostadas","mahou maestra", 1.00));
        cervezas.add(new Cerveza("tostadas","amstel oro", 2.50));
        cervezas.add(new Cerveza("tostadas","alhambra roja", 2.70));

        cervezas.add(new Cerveza("negras","mahou", 1.00));
        cervezas.add(new Cerveza("negras","mahou", 1.00));
        cervezas.add(new Cerveza("negras","mahou", 1.00));

    }
    @FXML
    protected void initialize(){
        //Cargar las cervezas al inciar la aplicacion a taves del metodo initialize
        cargarCervezas1();
    }
    @FXML
    protected void onF1(){
        //Eliminar los elementos de combobox2
        ComboBox2.getItems().clear();
        //Volcar, vuelta a vuelta, los objetos de la Arraylist "cervezas" en el objeto
        //"cerveza" para cargar los elementos en el ComboBox2
        //dependiendo de lo seleccionado en comboBox1
        for (Cerveza cerveza:cervezas){
            //Su el atributo "tipo cerveza" del objeto "cerveza"
            //coincide con el elemento seleccionado en comboBox1...
            if(cerveza.tipoCerveza.equalsIgnoreCase(ComboBox1.getValue().toString())){
                // añadir a combobox2 el atributo "nombre cerveza"
                ComboBox2.getItems().add(cerveza.nombreCerveza);
                //Establecer el primer elemento de combobox2 como el valor por defecto
                ComboBox2.getSelectionModel().selectFirst();
            }
        }
    }
    @FXML
    protected void onF2(){
        //Buscar en la ArrayList "cervezas"
        for (Cerveza cerveza: cervezas){
            //Si el atributo tipoCerveza del objeto "Cerveza"
            // coincide con el elemento seleccionado del combobox1
            if(cerveza.nombreCerveza.equalsIgnoreCase(ComboBox2.getValue().toString())){
                //mostrar en label1 el atributo "pvpCerveza"
                //coincide
                label1.setText(String.valueOf(cerveza.pvpCerveza) + "$");
            }
        }
    }
}