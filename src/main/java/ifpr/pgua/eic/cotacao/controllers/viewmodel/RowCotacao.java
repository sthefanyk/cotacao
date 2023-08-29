package ifpr.pgua.eic.cotacao.controllers.viewmodel;

import ifpr.pgua.eic.cotacao.models.Cotacao;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RowCotacao {
    private Cotacao cotacao;

    public RowCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    /**
     * Propriedade para representar o atributo nome do cotacao.
     * 
     * @return SimpleStringProperty com o valor do nome do cotacao.
     */
    public StringProperty nameProperty(){
        return new SimpleStringProperty(cotacao.getName());
    }

    /**
     * Propriedade para representar o atributo contato do cotacao.
     * 
     * @return SimpleStringProperty com o valor do contato do cotacao.
     */
    public StringProperty maxProperty(){
        return new SimpleStringProperty(cotacao.getMax());
    }

    /**
     * Propriedade para representar o atributo contato do cotacao.
     * 
     * @return SimpleStringProperty com o valor do contato do cotacao.
     */
    public StringProperty minProperty(){
        return new SimpleStringProperty(cotacao.getMin());
    }

    /**
     * Propriedade para representar o atributo contato do cotacao.
     * 
     * @return SimpleStringProperty com o valor do contato do cotacao.
     */
    public StringProperty bidProperty(){
        return new SimpleStringProperty(cotacao.getBid());
    }

    /**
     * Propriedade para representar o atributo contato do cotacao.
     * 
     * @return SimpleStringProperty com o valor do contato do cotacao.
     */
    public StringProperty datetimeProperty(){
        return new SimpleStringProperty(cotacao.getDatetime());
    }


}
