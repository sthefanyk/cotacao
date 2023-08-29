package ifpr.pgua.eic.cotacao.models.daos;

import ifpr.pgua.eic.cotacao.models.Cotacao;
import ifpr.pgua.eic.cotacao.models.results.Result;

public interface CotacaoDAO {
    Cotacao getCotacao();
    Result insert(Cotacao cotacao);
}
