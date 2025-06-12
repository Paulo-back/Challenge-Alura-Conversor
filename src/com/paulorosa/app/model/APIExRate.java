package com.paulorosa.app.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Properties;

public class APIExRate {

    private static Properties props = new Properties();

    static {
        try {
            InputStream input = APIExRate.class.getClassLoader().getResourceAsStream("com/paulorosa/app/config/config.properties");
            props.load(input);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static String getApiKey() {
        return props.getProperty("API_KEY");
    }
    //Pega a chave api


    public String consultaApi(int escolha) {
        String url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/USD/BRL";

        switch (escolha) {
            case 1:
                url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/USD/BRL";
                break;
            case 2:
                url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/EUR/BRL";
                break;
            case 3:
                url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/GBP/BRL";
                break;
            case 4:
                url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/JPY/BRL";
                break;
            case 5:
                url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/CHF/BRL";
                break;
            case 6:
                url = "https://v6.exchangerate-api.com/v6/" + getApiKey() + "/pair/CNY/BRL";
                break;
            case 7:
                url = "https://api.coingecko.com/api/v3/simple/price?ids=" + "bitcoin" + "&vs_currencies=usd,brl";
                break;
            case 8:
                url = "https://api.coingecko.com/api/v3/simple/price?ids=" + "solana" + "&vs_currencies=usd,brl";
                break;
            case 9:
                url = "https://api.coingecko.com/api/v3/simple/price?ids=" + "ethereum" + "&vs_currencies=usd,brl";
                break;

        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if (statusCode == 200) {

                String json = response.body();
//                System.out.println(json);

                return json;

            } else if (statusCode == 400) {
                System.out.println("Erro de conversão");
            } else {
                System.out.println("Erro Https: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter a conversão: " + e);
        }
        return null;
    }

    public double conversao(double valor, double valorConversao) {
        double valorConvertido = valor * valorConversao;

        return Math.round(valorConvertido * 100) / 100.0;
    }
    public void conversaoCripto(double valor,double valorDollar,double valorReal){
        double Dollar = valorDollar * valor;
        double Real = valorReal * valor;
//        System.out.println("real: "+Real+"\nDollar: "+Dollar);
        System.out.println("╔════════════════════════════════════════╗");
        System.out.printf (String.format( "║ 💰 Valor convertido Real: R$ %.2f ║\n", Real));
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("╔═════════════════════════════════════════╗");
        System.out.printf ("║ 💰 Valor convertido Dolar: US$ %.2f ║\n", Dollar);
        System.out.println("╚═════════════════════════════════════════╝");
    }
}




