package com.paulorosa.app.main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.paulorosa.app.model.Conversor;
import com.paulorosa.app.model.ConversorCripto;
import com.paulorosa.app.model.ConversorValores;

import java.lang.reflect.Type;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        int escolha = 0;
        while (escolha!=-1){
            escolha = conversor.Menu();
            if (escolha == -1){
                break;
            }

            conversor.ValorMoedaBase();
            String recebe = conversor.consultaApi(escolha);

            if (escolha ==7 || escolha ==8 || escolha ==9){
                String cripto = "bitcoin";
                Gson gson = new Gson();
                Type type = new TypeToken<Map<String, ConversorCripto>>(){}.getType();
                Map<String, ConversorCripto> mapa = gson.fromJson(recebe,type);
                if (escolha==8){
                    cripto = "solana";
                }else if(escolha==9){
                    cripto = "ethereum";
                }
                ConversorCripto valores = mapa.get(cripto);
//                System.out.println("valores = "+ valores);
                conversor.conversaoCripto(conversor.getMoedaBase(),valores.usd(),valores.brl());
               esperar(2);

            }else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ConversorValores valores = gson.fromJson(recebe,ConversorValores.class);
            Double valorDeConversao = conversor.conversao(conversor.getMoedaBase(),valores.conversion_rate());
            System.out.println("╔══════════════════════════════╗");
            System.out.printf ("║ 💰 Valor convertido: R$ %.2f ║\n", valorDeConversao);
            System.out.println("╚══════════════════════════════╝");
            esperar(2);

            }
        }

    }
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}