/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author tobia
 */
public class Buraco {
    private Processo processo;
    private boolean alocado = false;
    private int tamanho;
    
    public Buraco(int tamanho){
        this.tamanho = tamanho;
    }
    public void alocaProcesso(Processo processo){
        this.processo=processo;
        this.alocado = true;
    }
    public boolean verificaBuraco(){
        return this.alocado;
    }
    public int getTamanho(){
        return this.tamanho;
    }
}
