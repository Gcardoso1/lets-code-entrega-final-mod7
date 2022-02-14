package com.recrutamento;
import controller.InteligenciaCentral;
import views.addRebeldeView;
import views.OrdemRebeldeView;

public class App 
{
    public static void main( String[] args )
    {
        InteligenciaCentral ic = new InteligenciaCentral();
        addRebeldeView.iniciarCadastroRebeldes(ic);
        FieldsEnum fieldsEnum = OrdemRebeldeView.iniciarOrdenacaoRebeldes(ic);
    }
}
