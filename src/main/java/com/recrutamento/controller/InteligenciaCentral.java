package controller;

import domain.Rebelde;
import enums.CamposEnum;
import interfaces.Ordenacao;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

public class InteligenciaCentral {
    @Getter
    @Setter
    private List<Rebelde> rebeldes = new LinkedList<Rebelde>();

    public void add(Rebelde rebelde){
        if (solicitarIngresso(rebelde))  {
            this.rebeldes.add(rebelde);
        }
    }

    public void imprimirAprovados(){
        try {
            @Cleanup PrintWriter writer = new PrintWriter("lista-rebeldes-aprovados.txt", "UTF-8");
            PrintWriter finalWriter = writer;
            this.getRebeldesAprovados().stream().forEach(x -> {
                finalWriter.println(x.toString());
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private boolean solicitarIngresso(Rebelde rebelde){
        String[] possiveisRespostas = {"Apto","Inapto"};
        int resultado = new Random().nextInt(2);
        if (possiveisRespostas[resultado] == "Apto") {
            System.out.println("Rebelde aprovado!");
            return true;
        } else {
            System.out.println("Rebelde reprovado!");
            return false;
        }
    }

    public static boolean buscarRebelde(Rebelde[] arr, Rebelde rebelde){
        return Arrays.asList(arr).contains(rebelde);
    }

    public static void comparaRebeldes(int[] arr1, int[] arr2) {
        Arrays.compare(arr1, arr2);
    }

    public static Rebelde[] copiarLista() {
        Rebelde[] rebelde = Arrays.copyOf(arrayRebeldes, 12);

        return rebelde;
    }

    public void ordenarRebeldesAprovados(Ordenacao ordenacao, FieldsEnum fieldsEnum){
        List<Rebelde> rebeldeListOrdenada = ordenacao.sortBy(this.getRebeldesAprovados(), fieldsEnum);
        this.setRebeldesAprovados(rebeldeListOrdenada);
    }
}
