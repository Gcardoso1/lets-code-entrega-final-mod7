package enums;

import lombok.Getter;

public enum CamposEnum {
    NOME("Nome"),
    IDADE("Idade"),
    RACA("Raca");

    @Getter
    private String descricao;

    FieldsEnum(String descricao) {
        this.descricao = descricao;
    }
}
