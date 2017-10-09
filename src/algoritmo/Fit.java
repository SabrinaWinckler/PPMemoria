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
 * @author Gustavo Bittecourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 * <gustavosatheler@gmail.com>
 */
public abstract class Fit {

    protected ArrayList<Processo> processosEmEspera;
    protected GerenciadorProcessos gerenciadorProcessos;
    protected Memoria memoria;
    protected int tempoClock;
    protected int espaco;
    protected int indiceProcura;
    protected boolean ocorreuEvento;  

    public Fit(ArrayList<Processo> listaEntrada, int tamanhoMemoria) {

        this.gerenciadorProcessos = new GerenciadorProcessos(listaEntrada, tamanhoMemoria);
        this.processosEmEspera = gerenciadorProcessos.getProcessosEmEspera();
        this.memoria = gerenciadorProcessos.getMemoria();

    }

    public void procuraEspaco(int posicao) {

        espaco = 0;

        for (int i = posicao; i < memoria.getTamanho(); i++) {

            if (memoria.get(i) == null) {
                espaco++;
            } else {
                break;
            }

        }

    }

    @Override
    public String toString() {
        return memoria.toString();
    }

    abstract public boolean executar();

}
