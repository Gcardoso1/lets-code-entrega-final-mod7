package views;

import domain.Rebelde;
import enums.RacasEnum;

import java.util.Arrays;
import java.util.Scanner;

public class RebeldeView {

    public static Rebelde getInstanciaRebelde(){
        String nome = perguntarNome(null);
        int idade = perguntarIdade(null);
        RacasEnum raca = perguntarRaca(null);

        Rebelde novoRebelde = new Rebelde(nome, idade, raca);
        return novoRebelde;
    }

    private static String perguntarNome(String message){
        printError(message);
        System.out.println("Qual seu nome? ");
        String nome = new Scanner(System.in).nextLine();
        if (nome.length() < 3) perguntarNome("O nome deve conter mais que 3 caracteres!");
        return nome;
    }

    private static int perguntarIdade(String message){
        printError(message);
        System.out.println("Qual sua idade? ");
        int idade = new Scanner(System.in).nextInt();
        if (idade < 0 ) perguntarIdade("Idade deve ser maior que 0.");
        return idade;
    }

    private static RacasEnum perguntarRaca(String message){
        RacasEnum racaEscolhida = null;
        printError(message);
        System.out.println("Escolha o numero da sua Raça:");
        for (RacasEnum raca : RacasEnum.values()){
            System.out.printf("%d - %s%n", raca.ordinal(), raca.getDescricao());
        }
        int racaInt = new Scanner(System.in).nextInt();
        if (racaInt >= 0 && racaInt < RacasEnum.values().length){
            racaEscolhida = RacasEnum.values()[racaInt];
        } else perguntarRaca("Raça invalida! Tente novamente");
        return racaEscolhida;
    }

    private static void printError(String message) {
        if (message != null) {
            System.err.println("[ERROR]: " + message);
        }
    }
}
