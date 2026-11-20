
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Aluno: João Victor Batista dos Santos
// RA: 0024291
// Consumo da API ViaCEP em Java

public class APIViaCep {

    public static void main(String[] args) {

        String cep = "72426060";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            System.out.println("Resultado da consulta ViaCEP:");
            System.out.println(response.body());

        } catch (Exception e) {

            System.out.println(
                    "Erro ao consultar o CEP: " + e.getMessage()
            );
        }
    }
}
