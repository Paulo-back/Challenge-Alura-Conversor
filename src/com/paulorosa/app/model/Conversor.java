package com.paulorosa.app.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Conversor extends APIExRate{
    Scanner sc = new Scanner(System.in);
    private double moedaBase;

    public double getMoedaBase() {
        return moedaBase;
    }


    public int Menu() throws InterruptedException {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   🌍 Bem-vindo à Loja de Intercâmbio! 🌍     ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║ Escolha a operação que deseja realizar:       ║");
        System.out.println("║                                               ║");
        System.out.println("║ [1] 💵 Dólar        → Real                    ║");
        System.out.println("║ [2] 💶 Euro         → Real                    ║");
        System.out.println("║ [3] 💷 Libra        → Real                    ║");
        System.out.println("║ [4] 💴 Yen          → Real                    ║");
        System.out.println("║ [5] 💲 Franco Suíço → Real                    ║");
        System.out.println("║ [6] 💲 Yuan Chinês  → Real                    ║");
        System.out.println("║ [7] 🪙 Bitcoin      → Dólar & Real            ║");
        System.out.println("║ [8] 🪙 Solana       → Dólar & Real            ║");
        System.out.println("║ [9] 🪙 ethereum     → Dólar & Real            ║");
        System.out.println("║ [10] ❌ Sair                                  ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.print("Digite sua opção: ");

        int escolha = sc.nextInt();
        if (escolha ==10){
            escolha =-1;
        }else if (!Arrays.asList(1,2,3,4,5,6,7,8,9).contains(escolha)){
            System.out.println("Escolha uma operação valida!!!");
            Thread.sleep(2 * 1000);
            Menu();
        }
        return escolha;
    }
    public void ValorMoedaBase(){
        System.out.print("Digite o valor para conversão: ");
        this.moedaBase = sc.nextDouble();
    }

}
