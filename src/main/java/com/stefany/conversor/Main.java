package com.stefany.conversor;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (true) {
            System.out.println("=== Conversor de Moedas ===");
            System.out.println("1. USD --> BRL");
            System.out.println("2. BRL --> USD");
            System.out.println("3. EUR --> BRL");
            System.out.println("4. BRL --> EUR");
            System.out.println("5. EUR --> USD");
            System.out.println("6. USD --> EUR");
            System.out.println("7. Converter outras moedas.");
            System.out.println("8. Sair");
            System.out.println("Escolha uma opção: ");
             int opcao;
             try {
                 opcao = Integer.parseInt(scanner.nextLine().trim());
             } catch (NumberFormatException ex) {
                 System.out.println("Opção inválida.");
                 continue;
             }
             if (opcao == 8) {
                 System.out.println("Encerrando...");
                 break;
             }
             String de = "", para = "";
             double valor;

             switch (opcao) {
                 case 1 -> {
                     de = "USD";
                     para = "BRL";
                 }
                 case 2 -> {
                     de = "BRL";
                     para = "USD";
                 }
                 case 3 -> {
                     de = "EUR";
                     para = "BRL";
                 }
                 case 4 -> {
                     de = "BRL";
                     para = "EUR";
                 }
                 case 5 -> {
                     de = "EUR";
                     para = "USD";
                 }
                 case 6 -> {
                     de = "USD";
                     para = "EUR";
                 }
                 case 7 -> {
                     System.out.println("Moeda de origem (ex. BRL): ");
                     de = scanner.nextLine().trim().toUpperCase();
                     System.out.println("Moeda de destino (ex. USD): ");
                     para = scanner.nextLine().trim().toUpperCase();
                 }
                 default -> System.out.println("Opção Inválida.");
             }
            System.out.println("Digite o valor que deseja converter: ");
            try {
                valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException ex) {
                System.out.println("Opção inválida.");
                continue;
            }
            double resultado = conversor.converter(valor, de, para);
             System.out.printf("%.2f %s = %.2f %s%n", valor, de, resultado, para);
        }
        scanner.close();
    }
}
