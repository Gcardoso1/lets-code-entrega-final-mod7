package interfaces;

import domain.Rebelde;
import enums.CamposEnum;
import interfaces.Comparacao;
import interfaces.Ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort implements Ordenacao {
    @Override
    public ArrayList<Rebelde> sortBy(List<Rebelde> rebeldeList, FieldsEnum fieldParaOrdenar) {
        ArrayList<Rebelde> rebeldesLinkedList = null;
        switch (fieldParaOrdenar.getDescricao()) {
            case "Nome":
                rebeldesLinkedList = sort(rebeldeList, new CompararPorNome());
                break;
            case "Idade":
                rebeldesLinkedList = sort(rebeldeList, new CompararPorIdade());
                break;
            case "Raca":
                rebeldesLinkedList = sort(rebeldeList, new CompararPorRaca());
                break;
            default:
                System.out.println("Opção invalida!");
        }
        return rebeldesLinkedList;
    }

    @Override
    public ArrayList<Rebelde> sort(List<Rebelde> rebeldeList, Comparacao comparar) {
        Rebelde[] rebeldes = rebeldeList.toArray(Rebelde[]::new);

        for (int i = 0; i < rebeldes.length; i++){
            int indiceMenor = i;
            for (int j = i + 1; j < rebeldes.length; j++){
                int indiceSeguinte = j;
                if (comparar.ehMenorQue(rebeldes[indiceSeguinte],rebeldes[indiceMenor])){
                    indiceMenor = j;
                }
            }
            Rebelde aux = rebeldes[i];
            rebeldes[i] = rebeldes[indiceMenor];
            rebeldes[indiceMenor] = aux;
        }

        Arrays.stream(rebeldes).forEach(x -> System.out.println(x.toString()));
        return (ArrayList<Rebelde>) Arrays.stream(rebeldes).collect(Collectors.toList());
    }
}
