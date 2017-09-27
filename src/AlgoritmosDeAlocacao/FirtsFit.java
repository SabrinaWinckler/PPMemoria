/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosDeAlocacao;

import Gerenciador.Buraco;
import Gerenciador.Memoria;
import Gerenciador.Processo;
import java.util.List;

/**
 *
 * @author SABRINA
 */
public class FirtsFit {
    private Memoria memoria;
    private List<Processo> processos;
    private List<Buraco> buracos;
    private boolean espacoVazio;
    //USA O PRIMEIRO BURACO QUE COUBER O PROCESSO
    //encontrar primeiro buraco vazio
    //verificar se tem espaço para a tarefa
    //se tiver insere se não procura novamente se não houver mais espaço retorna que não tem espaço para a terefa ser alocada 
    public boolean encontrarBuracoVazio(){
        this.buracos =  this.memoria.getProcessos();//get buraco
        for(Buraco buraco : buracos){
            if(buraco == null){
                return true;
            }
        }
        return false;
    }
    public boolean estaCheio(){
        if(!encontrarBuracoVazio()){
            return true;
        }
        return false; 
    }    
    public boolean temEspaco(){
        if(encontrarBuracoVazio()){
            for(int i = 0; i<this.processos.size(); i++){
                if(processos.get(i).getTamanho() <= this.buracos.get(i).getTamanho()){
                    return true;
                }
            }
        }
        
        return false;
    }
    public void insereTarefa(Processo processo){
    
    }
}
