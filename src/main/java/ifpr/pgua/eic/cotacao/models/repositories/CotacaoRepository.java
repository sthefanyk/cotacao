package ifpr.pgua.eic.cotacao.models.repositories;

import ifpr.pgua.eic.cotacao.models.Cotacao;
import ifpr.pgua.eic.cotacao.models.daos.CotacaoDAO;

public class CotacaoRepository {
    CotacaoDAO dao;

    public CotacaoRepository(CotacaoDAO dao) {
        this.dao = dao;
    }

    public Cotacao getCotacao(){
        return  dao.getCotacao();
    }
}
