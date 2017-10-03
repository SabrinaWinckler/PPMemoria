/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import algoritmo.FirstFit;
import gerais.Memoria;
import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author SABRINA
 */
public class teste {
    public static void main(String[] args){
     Memoria memoria = new Memoria(500);
     ArrayList<Processo> processos = new ArrayList();
     
     Processo p1 = new Processo("p1", 88, 50, 0);
     Processo p2 = new Processo("p2", 2, 50, 0);
     Processo p3 = new Processo("p3", 20, 50, 0);
     Processo p4 = new Processo("p4", 24, 50, 0);
     
     processos.add(p1);
     processos.add(p2);
     processos.add(p4);
     
     memoria.inserirProcesso(p2, 0);
     memoria.inserirProcesso(p3, 2);
     memoria.inserirProcesso(p2, 6);
     
     FirstFit aloc = new FirstFit(memoria, processos); 
     
     for(Processo processo : processos){
         
         aloc.insereProcesso(processo);
         aloc.acabouProcesso(processo);
         
     }
     for(int i = 0; i< memoria.getProcessos().length;i++){
         
         if(memoria.getPosicao(i) != null){
            System.out.println(memoria.getPosicao(i).toString()); 
         }
         if(memoria.getPosicao(i)==null){
             System.out.println("posiçao vazia"); 
         }
     }
    }
}
