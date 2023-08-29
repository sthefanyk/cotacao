package ifpr.pgua.eic.cotacao.models.daos;

import ifpr.pgua.eic.cotacao.models.Cotacao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICotacaoDAO implements CotacaoDAO{

    @Override
    public Cotacao getCotacao() {
        String apiUrl = "https://economia.awesomeapi.com.br/last/USD-BRL";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // pegar cotacao do response

            Cotacao cot = new Cotacao("moeda", "4.8736", "4.899", "4.8938", "datetime");
            return cot;

            // System.out.println("Response Body:\n" + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
}
