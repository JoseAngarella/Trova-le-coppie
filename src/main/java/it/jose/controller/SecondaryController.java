package it.jose.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.jose.App;
import it.jose.model.*;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class SecondaryController implements Initializable {

    @FXML
    private GridPane campo;

    @FXML
    private Label tentativiRimasti;

    private Button btn1;
    private PauseTransition pt;

    @FXML
    private void scopriClicked(ActionEvent event) throws InterruptedException {
        Button btn = (Button) event.getTarget();
        pt.setOnFinished(evt -> timeout(btn));
        btn.setDisable(true);
        illuminaTesto(btn);
        int x = GridPane.getRowIndex(btn.getParent());
        int y = GridPane.getColumnIndex(btn.getParent());
        cambiaTestoCasella(PartitaService.casellaScoperta(x, y), btn);

        if (PartitaService.getCasellaGiaScoperta() != null) {
            dueCaselleAperte(btn, x, y);

        } else {
            btn1 = btn;
            PartitaService.setCasellaGiaScoperta(PartitaService.casellaScoperta(x, y));

        }

    }

    @FXML
    public void dueCaselleAperte(@SuppressWarnings("exports") Button btn, int x, int y){
        if (PartitaService.indovinato(x, y)) {
            disilluminaTesto(btn);
            disilluminaTesto(btn1);

        } else {
            disabilitaPulsanti();

            pt.playFromStart();
        }
        tentativiRimasti.setText("Tentativi Rimasti: "+ PartitaService.getP().getNumeroTentativi());
        PartitaService.setCasellaGiaScoperta(null);
        controllaSeVittoria();


    }

    @FXML
    public void illuminaTesto(@SuppressWarnings("exports") Button b){
        VBox vb=(VBox) b.getParent();
        ObservableList<Node> l=vb.getChildren();
        for (Node node : l) {
            if(node instanceof Label){ 
                Label label=(Label) node;
                label.setStyle("-fx-font-weight: bold; -fx-background-color: SkyBlue;  -fx-background-radius: 10");
                
            }
        }

    }

    @FXML
    public void disilluminaTesto(@SuppressWarnings("exports") Button b){
        VBox vb=(VBox) b.getParent();
        ObservableList<Node> l=vb.getChildren();
        for (Node node : l) {
            if(node instanceof Label){ 
                Label label=(Label) node;
                label.setStyle("-fx-font-weight: normal; -fx-background-color: SkyBlue;  -fx-background-radius: 10");
            }
        }
    }


    @FXML
    private void controllaSeVittoria() { //o sconfitta

        if(PartitaService.vittoria()){
            tentativiRimasti.setText("Partita Vinta \n Tentativi Rimasti: "+PartitaService.getP().getNumeroTentativi());
            disabilitaPulsanti();
            
            
        }else if(PartitaService.getP().getNumeroTentativi()==0){
            tentativiRimasti.setText("Partita Persa");
            disabilitaPulsanti();

        }

    }

    @FXML
    private void cambiaTestoCasella(String s, Button b) {
        VBox vb = (VBox) b.getParent();
        ObservableList<Node> l = vb.getChildren();
        for (Node node : l) {
            if (node instanceof Label) {
                Label label = (Label) node;
                label.setText(s);
                break;
            }

        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void disabilitaPulsanti(){
        ObservableList<Node> l=campo.getChildren();
        for (Node node : l) {
            VBox vb= (VBox)node;
            ObservableList<Node> l2 = vb.getChildren();
            for (Node node2 : l2) {
                if(node2 instanceof Button){
                    node2.setDisable(true);
                }     
                
            }
        }

    }

    @FXML
    public void abilitaPulsanti(){
        List<Punto> p= PartitaService.cordinatePulsantiGiaIndovinati();
        ObservableList<Node> l=campo.getChildren();
        for (Node node : l) {
            VBox vb= (VBox)node;
            ObservableList<Node> l2 = vb.getChildren();
            for (Node node2 : l2) {
                if(node2 instanceof Button){
                    if(!p.contains(new Punto(GridPane.getRowIndex(node2.getParent()), GridPane.getColumnIndex(node2.getParent())))){
                        node2.setDisable(false);
                    }
                  
                }     
                
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        PartitaService.inizioPartita("fileParole.txt");
        tentativiRimasti.setText("Tentativi Rimasti: "+PartitaService.getP().getNumeroTentativi());
        pt = new PauseTransition(Duration.seconds(1));

    }

    private void timeout(Button btn) {
        cambiaTestoCasella("?", btn1);
        cambiaTestoCasella("?", btn);
        disilluminaTesto(btn);
        disilluminaTesto(btn1);
        if(PartitaService.getP().getNumeroTentativi()!=0){
            abilitaPulsanti();

        }
    }
}