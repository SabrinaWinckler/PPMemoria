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
    private ArrayList<Processo> processosEmExecucao;
    private ArrayList<String> plot;
    private ArrayList<Processo> EntradaDeProcessos;
    private ArrayList<Processo> processosEmEspera;
    private static int execucao;

    @Override
    public String toString() {
        //"memoria=" + memoria.toString()+

        return "FirstFit{" + ", processos=" + processosEmExecucao.toString() + '}';
    }

    public FirstFit(Memoria memoria, ArrayList<Processo> processos) {
        this.memoria = memoria;
        this.EntradaDeProcessos = processos;
        this.processosEmExecucao = new ArrayList<Processo>();
        this.processosEmEspera = new ArrayList<Processo>();
        this.execucao = 0;

    }
    //USA O PRIMEIRO BURACO QUE COUBER O PROCESSO
    //encontrar primeiro buraco vazio
    //verificar se tem espaço para o processo
    //se tiver insere se não procura novamente se não houver mais espaço retorna que não tem espaço para a terefa ser alocada 
  
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

    public void percorreProcessos() {

        for (Processo processo : EntradaDeProcessos) {

            if (processo.getTempoCheg() == execucao) {
                processosEmEspera.add(processo);
            }

        }

    }

    public boolean insereProcesso(Processo processo) {

        for (int i = 0; i < memoria.getTamanho(); i++) {

            if (temEspaco(i, processo.getTamanho())) {
                memoria.inserirProcesso(processo, i);
                this.processosEmExecucao.add(processo);
                return true;
            }
        }
        return false;
    }
    

    public void executarProcessos() {
        for (int i = processosEmExecucao.size()-1; i>=0; i--) {
            Processo processo = processosEmExecucao.get(i);
            processo.executar();
            if (processo.getTempoExec() == 0) {
                memoria.removerProcesso(processo, processo.getPosicaoMemoria());
                processosEmExecucao.remove(i);
            }
        }
    }
  
     @Override
    public ArrayList<String> executar() {
        percorreProcessos();
        for (int i = this.processosEmEspera.size()-1; i>=0; i--) {
            if(insereProcesso(processosEmEspera.get(i))){
               processosEmEspera.remove(i);
            }
        }
        int teste = execucao++;
        return this.plot;
    }
}
