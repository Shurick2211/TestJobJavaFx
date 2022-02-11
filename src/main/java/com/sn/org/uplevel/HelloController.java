package com.sn.org.uplevel;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
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


public class HelloController {
    @FXML
    TextField amount;
    @FXML
    TextField  time;
    @FXML
    SplitMenuButton valuta1;
    @FXML
    SplitMenuButton valuta2;
    @FXML
    TableView tableView;
    @FXML
    TableColumn<Valuta,String> valKurs;
    @FXML
    TableColumn<Valuta,String> valName;




    @FXML
    public static ObservableList<Valuta> valutas = FXCollections.observableArrayList();
    ParseKurce parseKurce=new ParseKurce();



    public void initialize(){
        /*
        tableView.itemsProperty().setValue(valutas);
        valName.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getName()));
        valKurs.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getKurs()+""));

        //create table
        tableView.itemsProperty().setValue(questions);

        N.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getN()+""));
        quCol.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getQu()));
        an1.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getAn1()));
        an2.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getAn2()));
        an3.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getAn3()));
        an4.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getAn4()));
        b1.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getB1()));
        b2.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getB2()));
        b3.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getB3()));
        b4.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getB4()));
        tableView.setEditable(true);
        //edit nf,kt
        quCol.setEditable(true);
        quCol.setCellFactory(TextFieldTableCell.forTableColumn());
        quCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setQu(q.getNewValue());
            }
        });


        an1.setEditable(true);
        an1.setCellFactory(TextFieldTableCell.forTableColumn());
        an1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setAn1(q.getNewValue());
            }
        });
        an2.setEditable(true);
        an2.setCellFactory(TextFieldTableCell.forTableColumn());
        an2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setAn2(q.getNewValue());
            }
        });
        an3.setEditable(true);
        an3.setCellFactory(TextFieldTableCell.forTableColumn());
        an3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setAn3(q.getNewValue());
            }
        });
        an4.setEditable(true);
        an4.setCellFactory(TextFieldTableCell.forTableColumn());
        an4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setAn4(q.getNewValue());
            }
        });
        b1.setEditable(true);
        b1.setCellFactory(TextFieldTableCell.forTableColumn());
        b1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setB1(q.getNewValue());
            }
        });
        b2.setEditable(true);
        b2.setCellFactory(TextFieldTableCell.forTableColumn());
        b2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setB2(q.getNewValue());
            }
        });
        b3.setEditable(true);
        b3.setCellFactory(TextFieldTableCell.forTableColumn());
        b3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setB3(q.getNewValue());
            }
        });
        b4.setEditable(true);
        b4.setCellFactory(TextFieldTableCell.forTableColumn());
        b4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Question, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Question, String> q) {
                q.getTableView().getItems().get(q.getTablePosition().getRow()).setB4(q.getNewValue());
            }
        });
         tableView.refresh();
*/


    }

    @FXML
    void change() {
System.out.println("change");
    }



    @FXML
    void apply(){

        try {
            valutas.addAll(parseKurce.kursPars());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tableView.itemsProperty().setValue(valutas);
        valName.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getName()));
        valKurs.setCellValueFactory(n->new SimpleStringProperty(n.getValue().getKurs()+""));
       // valutas.forEach(System.out::println);

    }

    @FXML
    void convert(){
        System.out.println("convert");
    }




}