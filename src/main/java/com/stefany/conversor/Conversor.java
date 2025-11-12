package com.stefany.conversor;
import com.google.gson.JsonObject;
import java.io.IOException;

public class Conversor {
    private final APIService apiService = new APIService();

    public double converter (double valor, String moedaOrigem, String moedaDestino){
        try {
            JsonObject json = apiService.buscarTaxa(moedaOrigem, moedaDestino);
            if (json.has("conversion_rate")) {
                double taxa = json.get("conversion_rate").getAsDouble();
                return valor * taxa;
            } else {
                System.out.println("Erro: respota inválida da API");
                return 0.0;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar ao API" + e.getMessage());
            return 0.0;
        }
    }
}
