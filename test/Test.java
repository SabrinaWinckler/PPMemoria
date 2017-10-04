
import gerais.Memoria;
import gerais.Processo;
import java.util.Arrays;
import algoritmo.BestFit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roliv
 */
public class Test {

    public static void main(String[] args) {

        Memoria memoria = new Memoria(20);
        BestFit bf;
        bf = new BestFit(memoria, memoria.getProcessos());
        Processo p1 = new Processo("p1", 3, 2, 1);
        Processo p2 = new Processo("p2", 3, 2, 1);
        Processo p3 = new Processo("p3", 6, 2, 1);
        Processo p4 = new Processo("p4", 3, 2, 1);
        int temp;
        memoria.inserirProcesso(p1, 0);
        memoria.inserirProcesso(p2, 5);
        memoria.inserirProcesso(p3, 11);

        temp = bf.cabeEspaco(p4.getTamanho());
        //for(int i = 0; i < memoria.getTamanho(); i++){

        memoria.inserirProcesso(p4, temp);

        System.out.println(Arrays.toString(memoria.getProcessos()));
    }
}
