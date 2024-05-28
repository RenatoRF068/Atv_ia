import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Consultar{
public static String consultarEnderecoPeloCEP(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scannerResponse = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scannerResponse.hasNextLine()) {
                    response.append(scannerResponse.nextLine());
                }
                scannerResponse.close();

                return extrairEnderecoCompleto(response.toString());
            } else {
                System.out.println("Erro ao consultar o serviço de CEP. Código de resposta: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Erro ao fazer a requisição HTTP: " + e.getMessage());
        }
        return "Endereço não encontrado";
    }

    public static String extrairEnderecoCompleto(String jsonResponse) {
        JSONObject jsonObj = new JSONObject(jsonResponse);
        String endereco = jsonObj.getString("logradouro") + ", " +
                          jsonObj.getString("bairro") + ", " +
                          jsonObj.getString("localidade") + " - " +
                          jsonObj.getString("uf") + ", " +
                          jsonObj.getString("cep");
        return endereco;
    }
}
