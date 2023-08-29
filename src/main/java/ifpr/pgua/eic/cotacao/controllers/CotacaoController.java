package ifpr.pgua.eic.cotacao.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.cotacao.App;
import ifpr.pgua.eic.cotacao.controllers.viewmodel.GetCotacaoViewModel;
import ifpr.pgua.eic.cotacao.controllers.viewmodel.RowCotacao;
import ifpr.pgua.eic.cotacao.models.results.Result;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CotacaoController extends BaseController implements Initializable{
    @FXML
    private TableView<RowCotacao> tbCotacao;

    @FXML
    private TableColumn<RowCotacao,String> tbcName;

    @FXML
    private TableColumn<RowCotacao,String> tbcMax;

    @FXML
    private TableColumn<RowCotacao,String> tbcMin;

    @FXML
    private TableColumn<RowCotacao,String> tbcBid;

    @FXML
    private TableColumn<RowCotacao,String> tbcDatetime;

    private GetCotacaoViewModel viewModel;

    public CotacaoController(GetCotacaoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }

    // @FXML
    // private void atualizar(){
    //     viewModel.updateList();
    //     this.tbCotacao.setItems(viewModel.getCotacoes());
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        this.tbcName.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        this.tbcMax.setCellValueFactory(new PropertyValueFactory<>("autor"));
        this.tbcMin.setCellValueFactory(new PropertyValueFactory<>("numero_paginas_livro"));
        this.tbcBid.setCellValueFactory(new PropertyValueFactory<>("ano_lancamento"));
        this.tbcDatetime.setCellValueFactory(new PropertyValueFactory<>("genero"));
        this.tbCotacao.setItems(viewModel.getCotacoes());


        this.viewModel.getAlertProperty().addListener((ChangeListener<Result>) (observable, oldVal, newVal) -> {
            showMessage(newVal);
        });
    }

}
