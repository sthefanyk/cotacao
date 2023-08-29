package ifpr.pgua.eic.cotacao.controllers;

import ifpr.pgua.eic.cotacao.App;
import javafx.fxml.FXML;

public class Principal {
    
    @FXML
    private void viewCotacao(){
        App.pushScreen("VIEWCOTACAO");
    }

    @FXML
    private void cadastrarGenero(){
        App.pushScreen("CADASTROGENERO");
    }

    @FXML
    private void cadastrarArtista(){
        App.pushScreen("CADASTROARTISTA");
    }

    @FXML
    private void listarGeneros(){
        App.pushScreen("LISTARGENEROS");
    }

}
