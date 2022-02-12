package com.sn.org.uplevel;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;


public class HelloController implements Observer{
    @FXML
    TextField amount;
    @FXML
    TextField  time;
    @FXML
    ChoiceBox<Valuta> valuta1;
    @FXML
    ChoiceBox<Valuta> valuta2;
    @FXML
    TableView tableView;
    @FXML
    TableColumn<Valuta,String> valKurs;
    @FXML
    TableColumn<Valuta,String> valName;
    @FXML Label rezult;
    @FXML Label errEnter;



    public static ObservableList<Valuta> valutas = FXCollections.observableArrayList();
    int timer;



    ParseKurce parseKurce;
    public void initialize() throws InterruptedException {

        parseKurce=new ParseKurce();
        parseKurce.setTime(5);
        parseKurce.start();

        tableView.itemsProperty().setValue(valutas);
        valName.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getName()));
        valKurs.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getKurs()+""));


        valuta1.setItems(valutas);
        valuta2.setItems(valutas);
    }

    @FXML
    void select() {




    }

    @FXML
    void change() {
System.out.println("change");
    }



    @FXML
    void apply() {
        timer=Integer.parseInt(time.getText());
        parseKurce.setTime(timer);
    }

    @FXML
    void convert(){
        rezult.setText("rezult");
    }


    @Override
    public void handleEvent(List<Valuta> valutaList) {
        valutas.clear();
        valutas.addAll(valutaList);



    }
}