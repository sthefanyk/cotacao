package ifpr.pgua.eic.cotacao.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ifpr.pgua.eic.cotacao.models.Cotacao;
import ifpr.pgua.eic.cotacao.models.FabricaConexoes;
import ifpr.pgua.eic.cotacao.models.results.Result;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JDBCCotacaoDAO implements CotacaoDAO{

    private static final String INSERT = "INSERT INTO cotacao (name, max, min, bid, datetime) VALUES (?,?,?,?,?)";

    private FabricaConexoes fabricaConexao;

    public JDBCCotacaoDAO(FabricaConexoes fabricaConexao){
        this.fabricaConexao = fabricaConexao;
    }

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

    @Override
    public Result insert(Cotacao cotacao) {
        try{
            Connection con = fabricaConexao.getConnection();
            PreparedStatement pstm = con.prepareStatement(INSERT);

            pstm.setString(1, cotacao.getName());
            pstm.setString(2, cotacao.getMax());
            pstm.setString(3, cotacao.getMin());
            pstm.setString(4, cotacao.getBid());
            pstm.setString(5, cotacao.getDatetime());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Cotação adicionada!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(msg(e.getMessage()));
        }
    }

    public String msg(String msg){
        String[] msgSeparada = msg.split("'");
        msg = msgSeparada[1];
        msgSeparada = msg.split("\\.");
        return msgSeparada[1];
    }
    
}
