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


    @Override
    public String toString() {
        //"memoria=" + memoria.toString()+
        
        return "FirstFit{" +  ", processos=" + processos.toString() + '}';
    }


    public FirstFit(Memoria memoria, ArrayList<Processo> processos) {
        this.memoria = memoria;
        this.processos = processos;

 
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
    public boolean temEspaco(int posicao, int posProcesso){
            boolean temEspaco = false;
            for(int i = posicao; i<this.memoria.getProcessos().length; i++){
                if(memoria.getBuraco(i)){
                    if(this.memoria.tamanhoDoBuraco(i) >= processos.get(posProcesso).getTamanho()  ){
                        temEspaco = true;
                    }else if(this.memoria.tamanhoDoBuraco(i) < processos.get(posProcesso).getTamanho()){
                        temEspaco =  false;
                    }
                }
            }        
            
        return temEspaco;
    }
    public void insereProcesso(Processo processo){
        for(int i = 0; i<memoria.getProcessos().length;i++){
            if(temEspaco(i, processo.getPosicaoMemoria())){
                memoria.inserirProcesso(processo, i);
                if(memoria.getPosicao(i) == processo ){
                    break;
                }             
            }
        }
    }
    public void acabouProcesso(Processo processo){
        for (int i =0; i<processos.size(); i++){
            if(processos.get(i).getTempoExec() == 0){
                memoria.removerProcesso(processo, i);
             
            }
        }
    }

    @Override
    public ArrayList<String> executar() {
        return this.plot;
    }
}
