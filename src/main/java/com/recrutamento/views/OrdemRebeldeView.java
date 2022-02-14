
import controller.InteligenciaCentral;
import enums.CamposEnum;

import java.util.Arrays;
import java.util.Scanner;

public class OrdemRebeldeView {
    public static CamposEnum iniciarOrdenacaoRebeldes(InteligenciaCentral ic){
        int fieldNumber;
        do {
            System.out.println("Por qual campo deseja ordenar?");
            Arrays.stream(CamposEnum.values()).forEach(field -> System. out.printf("%d - %s%n", field.ordinal(), field.getDescricao()));
            Scanner scanner = new Scanner(System.in);
            fieldNumber = scanner.nextInt();
        } while (fieldNumber < 0 || fieldNumber > CamposEnum.values().length);
        return CamposEnum.values()[fieldNumber];
    }    
}
