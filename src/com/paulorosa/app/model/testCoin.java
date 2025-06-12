package com.paulorosa.app.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class testCoin {
    public static void main(String[] args) throws IOException, InterruptedException {


    Scanner sc = new Scanner(System.in);
//https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd&x_cg_demo_api_key=CG-UsFj5RPJJpLRgDK56f4fNrsd
        System.out.print("Cripto de pesquisa: ");
    var criptoPesquisa = sc.next();
    var link = "https://api.coingecko.com/api/v3/simple/price?ids=";
    var link2 = "&vs_currencies=usd&x_cg_demo_api_key=";
    var apiKey = "CG-UsFj5RPJJpLRgDK56f4fNrsd";
    var url = link+criptoPesquisa+link2+apiKey;
    var url2 = "https://api.coingecko.com/api/v3/simple/price?ids="+criptoPesquisa+"&vs_currencies=usd,brl";

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url2))
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
}
}
