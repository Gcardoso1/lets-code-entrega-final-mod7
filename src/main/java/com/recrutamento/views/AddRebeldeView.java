import controllers.InteligenciaCentral;
import domain.Rebelde;

import java.util.Scanner;

public class AddRebeldeView {

    public static void iniciarCadastroRebeldes(InteligenciaCentral ic){
        String resposta;
        do {
            Rebelde newRebelde = RebeldeView.getInstanciaRebelde();
            ic.add(newRebelde);
            System.out.println("Deseja adicionar mais rebeldes? [S/N] ");
            Scanner scanner = new Scanner(System.in);
            resposta = scanner.next();
            scanner.nextLine();
        } while (resposta.equalsIgnoreCase("S"));
    }
}