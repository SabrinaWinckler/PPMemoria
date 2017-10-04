/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;


import gerais.Memoria;
import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author SABRINA
 */
public class FirstFit implements Fit {
    private Memoria memoria;
    private ArrayList<Processo> processos;
    private ArrayList<String> plot;
    private ArrayList<Processo> processosEmEspera;
    private int execucao;


    @Override
    public String toString() {
        //"memoria=" + memoria.toString()+
        
        return "FirstFit{" +  ", processos=" + processos.toString() + '}';
    }


    public FirstFit(Memoria memoria, ArrayList<Processo> processos) {
        this.memoria = memoria;
        this.processosEmEspera = processos;
        this.processos = new ArrayList<Processo>();
        this.execucao = 0;
 
    }
    //USA O PRIMEIRO BURACO QUE COUBER O PROCESSO
    //encontrar primeiro buraco vazio
    //verificar se tem espaço para o processo
    //se tiver insere se não procura novamente se não houver mais espaço retorna que não tem espaço para a terefa ser alocada 
    //    public boolean estaCheio(){
    //    if(!memoria.getBuraco()){
    //        return true;
    //    }
    //    return false; 
    //}    
    public boolean temEspaco(int posicao, int tam) {
        if (memoria.getBuraco(posicao)) {
            int espaco = 0;
            for (int i = posicao; i <= posicao + tam - 1; i++) {
                if (memoria.getPosicao(i) != null) {
                    return false;
                } else {
                    espaco++;
                }
                if (espaco == tam) {
                    return true;
                }
            }
        }
        return false;
    }
    public void percorreProcessos(){

        
        for(Processo processo: processosEmEspera){
         
            insereProcesso(processo);
            emExecucao(processo);  
            
        }
        removerProcesso(0);
        
    }
    public void insereProcesso(Processo processo){
        
        for(int i = 0; i<memoria.getProcessos().length;i++){
            
            if(temEspaco(i, processo.getTamanho())){
                memoria.inserirProcesso(processo, i);
                if(memoria.getPosicao(i) == processo ){
                    break;
                }             
            }
        }
        
    }

    public void emExecucao(Processo processo){

            for (int i = 0; i<processosEmEspera.size(); i++){
                
                this.processos.add(i, processo);
                this.processos.get(i).setPosicaoMemoria(i);
                this.processos.get(i).executar();
 
            }
               
    }
    public boolean acabouProcesso(int posicao){
        
         return (this.processos.get(posicao).getTempoExec() == 0);
    }
    public void removerProcesso(int posicao){
        for(int i = posicao; i<processos.size(); i++){
        execucao = processos.get(i).getTempoExec();
        do{
            if(acabouProcesso(i)){
                 this.memoria.removerProcesso(processos.get(i), i);
            }
        }while(execucao >=0);
        }
          
    }

    @Override
    public ArrayList<String> executar() {
        return this.plot;
    }
}
