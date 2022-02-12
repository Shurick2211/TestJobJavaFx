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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
    @FXML Button change;


    public static    ObservableList<Valuta> valutas = FXCollections.observableArrayList();
    int timer;



    ParseKurce parseKurce;
    public void initialize()  {
        change.setShape(new Circle(15));
        char st='\u21C4';
        change.setText(st+"");


        parseKurce=new ParseKurce();
        parseKurce.setTime(50);
        time.setText("50");
        parseKurce.start();

        tableView.itemsProperty().setValue(valutas);
        valName.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getName()));
        valKurs.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getKurs()+""));


        valuta1.setItems(valutas);
        valuta2.setItems(valutas);
        amount.setText("1");

    }


    public void  select() {




    }

    @FXML
    void change() {
        if(valuta2.getValue()!=null&&valuta1.getValue()!=null&&!valutas.isEmpty()) {
            int v1 = valuta1.getSelectionModel().getSelectedIndex();
            int v2 = valuta2.getSelectionModel().getSelectedIndex();
            valuta1.setValue(valuta1.getItems().get(v2));
            valuta2.setValue(valuta1.getItems().get(v1));
        }
    }



    @FXML
    void apply() {
        try {
            timer = Integer.parseInt(time.getText());
            parseKurce.setTime(timer);
            errEnter.setText("");
        }catch (Exception e){
            errEnter.setText("Enter number");
        }
    }

    @FXML
    void convert(){


        float am=1;
        try {
            am = Float.parseFloat(amount.getText());
        }catch (Exception e){
            rezult.setText("Error to enter");
        }
        float rez=0;
        if(valuta2.getValue()!=null&valuta1.getValue()!=null) {
            rez = am / valuta2.getValue().getKurs() *
                    valuta1.getValue().getKurs();

            rezult.setText(valuta2.getValue().getName()+": "+rez);
        }else  rezult.setText("Select from & to");
    }


    @Override
    public  synchronized void  handleEvent(List<Valuta> valutaList) {

        valutas.setAll(valutaList);
        valutas.add(new Valuta("UAN", 1.0F));
       select();

    }
}