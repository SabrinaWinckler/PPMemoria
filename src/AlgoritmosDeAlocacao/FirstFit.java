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
 * @author SABRINA
 */
public class FirstFit {
    private Memoria memoria;
    private ArrayList<Processo> processos;

    @Override
    public String toString() {
        //"memoria=" + memoria.toString() +
        
        return "FirstFit{" +  ", processos=" + processos.toString() + '}';
    }


    public FirstFit(Memoria memoria, ArrayList<Processo> processos) {
        this.memoria = memoria;
        this.processos = processos;
 
    }
    //USA O PRIMEIRO BURACO QUE COUBER O PROCESSO
    //encontrar primeiro buraco vazio
    //verificar se tem espaço para a tarefa
    //se tiver insere se não procura novamente se não houver mais espaço retorna que não tem espaço para a terefa ser alocada 
    //    public boolean estaCheio(){
    //    if(!memoria.getBuraco()){
    //        return true;
    //    }
    //    return false; 
    //}    
    public boolean temEspaco(){
        
            for(int i = 0; i<this.processos.size(); i++){
                if(memoria.getBuraco(i)){
                    if(processos.get(i).getTamanho() <= this.memoria.getTamanho()){
                        return true;
                    }
                }
            }              
        return false;
    }
    public void insereProcesso(Processo processo){
        for(int i = 0; i<this.processos.size();i++){
            if(temEspaco()){
                memoria.inserirProcesso(processo, 0);
                break;
            }
        }
    }
    public void acabouProcesso(Processo processo){
        for (int i =0; i<processos.size(); i++){
            if(processos.get(i).getTempoExec() == 0){
                memoria.removerProcesso(processo, 0);
                break;
            }
        }
    }
}
