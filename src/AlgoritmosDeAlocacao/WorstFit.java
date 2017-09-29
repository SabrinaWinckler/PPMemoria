/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosDeAlocacao;

import Gerenciador.Memoria;
import Gerenciador.Processo;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Bittecourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 * <gustavosatheler@gmail.com>
 */
public class WorstFit {
    private Memoria memoria;
    private ArrayList<Processo> processos;
    private int tique;
    
    public WorstFit(Memoria memoria, ArrayList<Processo> processos) {
        this.memoria = memoria;
        this.processos = new ArrayList();
        this.processos = processos;
        this.tique = 0;
    }
    
    public void executar(){
        int indiceInicial = 0;
        int espaco = 0;
        
        while(!processos.isEmpty()){
            
            for(int i = 0; i < memoria.getTamanho(); i++){
//                if (processos.get(i).getTempoCheg() == tique ) {
//                    memoria.inserir(processos.get(i));
//                }

                if(memoria.getBuraco(i)){
                    espaco++;
                }
            }
            processos.remove(0);
        }
        
        System.out.println(espaco);
    }
}
