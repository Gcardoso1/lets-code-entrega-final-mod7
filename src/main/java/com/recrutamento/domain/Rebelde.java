package domain;

import enums.RacasEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Rebelde {

    private String nome;
    private Integer idade;
    private RacasEnum raca;

    @Override
    public String toString(){
        return "Rebelde(nome=" + getNome() + ", idade=" + getIdade() + ", raca=" + raca.getDescricao() + ")";
    }
}
