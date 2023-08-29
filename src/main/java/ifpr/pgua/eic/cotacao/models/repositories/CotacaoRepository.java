package ifpr.pgua.eic.cotacao.models.repositories;

import ifpr.pgua.eic.cotacao.models.Cotacao;
import ifpr.pgua.eic.cotacao.models.daos.CotacaoDAO;
import ifpr.pgua.eic.cotacao.models.results.Result;

public class CotacaoRepository {
    CotacaoDAO dao;

    public CotacaoRepository(CotacaoDAO dao) {
        this.dao = dao;
    }

    public Cotacao getCotacao(){
        return  dao.getCotacao();
    }

    public Result insert(String name, String min, String max, String bid, String datetime){

        if (!(name.equals("")) && !(min.equals("")) && !(max.equals("")) && !(bid.equals("")) && !(datetime.equals(""))) {
            Cotacao cotacao = new Cotacao(name, min, max, bid, datetime);
            return dao.insert(cotacao);
        }

        return Result.fail("Ocorreu um erro!");
    }
}
