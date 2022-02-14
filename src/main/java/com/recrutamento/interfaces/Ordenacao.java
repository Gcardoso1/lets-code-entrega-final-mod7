package interfaces;

import domain.Rebelde;
import enums.CamposEnum;

import java.util.ArrayList;
import java.util.List;

public interface Ordenacao {

    ArrayList<Rebelde> sortBy(List<Rebelde> rebeldeList, FieldsEnum fieldParaOrdenar);
    ArrayList<Rebelde> sort(List<Rebelde> rebeldeList, Comparacao comparar);
}
