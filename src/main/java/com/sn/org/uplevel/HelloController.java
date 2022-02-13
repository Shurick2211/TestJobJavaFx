package com.sn.org.uplevel;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import rx.Observer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class HelloController implements Observer<List<Valuta>> {
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


   private static ObservableList<Valuta> valutas = FXCollections.observableArrayList();

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




    @FXML
    void change() {
        if(valuta2.getValue()!=null&&valuta1.getValue()!=null) {
           Valuta v1=valuta1.getValue();
           Valuta v2=valuta2.getValue();
            valuta1.setValue(v2);
            valuta2.setValue(v1);
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
    public void onCompleted() {
        System.out.println("Data here!");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error data!");
    }

    @Override
    public  void onNext(List<Valuta> valutass) {

        valutas.setAll(valutass);
        valutas.add(new Valuta("UAN", 1F));

    }
}