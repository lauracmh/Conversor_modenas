package com.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    double tasa;
    public Double obtenerTasa(Object moneda, Object moneda2){
        String url = "https://v6.exchangerate-api.com/v6/e2ad6d718dc9877648d583ff/latest/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + moneda)).build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

        tasa = jsonObject.get("conversion_rates").getAsJsonObject().get((String) moneda2).getAsDouble();
        return tasa;
    }

    public double calcularCambio(double valor){
        return valor*tasa;
    }
}
