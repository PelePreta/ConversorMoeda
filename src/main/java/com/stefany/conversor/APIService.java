package com.stefany.conversor;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIService {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "4e2edb166f4e051bd9ee44a2";

    public JsonObject buscarTaxa (String moedaOrigem, String moedaDestino)
        throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/pair/" + moedaOrigem + "/" + moedaDestino;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
}
