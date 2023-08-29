package ifpr.pgua.eic.cotacao;

import ifpr.pgua.eic.cotacao.controllers.CotacaoController;
import ifpr.pgua.eic.cotacao.controllers.Principal;
import ifpr.pgua.eic.cotacao.controllers.viewmodel.GetCotacaoViewModel;
import ifpr.pgua.eic.cotacao.models.daos.JDBCCotacaoDAO;
import ifpr.pgua.eic.cotacao.models.FabricaConexoes;
import ifpr.pgua.eic.cotacao.models.daos.CotacaoDAO;
import ifpr.pgua.eic.cotacao.models.repositories.CotacaoRepository;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private CotacaoDAO cotacaoDAO;
    private CotacaoRepository cotacaoRepo;

    @Override
    public void init() throws Exception {
        super.init();

        cotacaoDAO = new JDBCCotacaoDAO(FabricaConexoes.getInstance());
        cotacaoRepo = new CotacaoRepository(cotacaoDAO);
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Coleção de Músicas";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));

        registraTela("VIEWCOTACAO",
                  new ScreenRegistryFXML(App.class, 
                      "cotacao.fxml", 
                      o->new CotacaoController(new GetCotacaoViewModel(cotacaoRepo))
                  )
        );
    }

}