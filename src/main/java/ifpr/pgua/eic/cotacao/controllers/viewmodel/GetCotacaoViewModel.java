package ifpr.pgua.eic.cotacao.controllers.viewmodel;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ifpr.pgua.eic.cotacao.models.Cotacao;
import ifpr.pgua.eic.cotacao.models.repositories.CotacaoRepository;
import ifpr.pgua.eic.cotacao.models.results.Result;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class GetCotacaoViewModel {
    private StringProperty nameProperty = new SimpleStringProperty();
    private StringProperty maxProperty = new SimpleStringProperty();
    private StringProperty minProperty = new SimpleStringProperty();
    private StringProperty bidProperty = new SimpleStringProperty();
    private StringProperty datetimaProperty = new SimpleStringProperty();
    private ObservableList<RowCotacao> cotacoes = FXCollections.observableArrayList();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();

    private CotacaoRepository repo;

    public GetCotacaoViewModel(CotacaoRepository repo) {
        this.repo = repo;
        updateList();
    }

    public void updateList() {
        cotacoes.clear();
        // for (Cotacao cotacao : repo.getCotacao()) {
        //     cotacoes.add(new RowCotacao(cotacao));
        // }

        cotacoes.add(new RowCotacao(repo.getCotacao()));
    }

    public ObservableList<RowCotacao> getCotacoes() {
        ObservableList<RowCotacao> cot = FXCollections.observableArrayList();
        cot.addAll(cotacoes);
        return cot;
    }

    public ObjectProperty<Result> getAlertProperty() {
        return alertProperty;
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public StringProperty getMaxProperty() {
        return maxProperty;
    }

    public StringProperty getMinProperty() {
        return minProperty;
    }

    public StringProperty getBidProperty() {
        return bidProperty;
    }

    public StringProperty getDatetimaProperty() {
        return datetimaProperty;
    }

    public CotacaoRepository getRepo() {
        return repo;
    }
}
