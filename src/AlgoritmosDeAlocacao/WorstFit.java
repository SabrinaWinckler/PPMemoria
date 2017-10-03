/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosDeAlocacao;

import Gerenciador.Memoria;
import Gerenciador.Processo;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gustavo Bittecourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 * <gustavosatheler@gmail.com>
 */
public class WorstFit {

    private Memoria memoria;
    private ArrayList<Processo> processosEntrada;
    private ArrayList<Processo> processosEmExecucao;
    private ArrayList<Processo> processosEmEspera;
    private int[] buraco;

    public WorstFit(Memoria memoria, ArrayList<Processo> processos) {
        this.memoria = memoria;
        this.processosEntrada = new ArrayList();
        this.processosEntrada = processos;
        this.processosEmExecucao = new ArrayList();
        this.processosEmEspera = new ArrayList();
        this.buraco = new int[2]; //[0] = Indice inicial do buraco, [1] = Tamanho do buraco
    }

    public void executar() {
        int tique = 0;

        while (!processosEntrada.isEmpty() || !processosEmExecucao.isEmpty() || !processosEmEspera.isEmpty()) {
            this.maiorBuraco();

            if (!processosEntrada.isEmpty() && (processosEntrada.get(0).getTempoCheg() == tique && processosEntrada.get(0).getTamanho() <= buraco[1])) {
                memoria.inserirProcesso(processosEntrada.get(0), this.buraco[0]);
                processosEntrada.get(0).setPosicaoMemoria(buraco[0]);
                processosEmExecucao.add(processosEntrada.remove(0));
            } else if(!processosEntrada.isEmpty() && (processosEntrada.get(0).getTempoCheg() == tique && processosEntrada.get(0).getTamanho() > buraco[1])){
                processosEmEspera.add(processosEntrada.remove(0));
            } else {
                tique++;
                System.out.println(Arrays.toString(memoria.getProcessos()));
                if (!processosEmExecucao.isEmpty()) {
                    this.executarProcessos();
                }
            }
            
            if (!processosEmEspera.isEmpty() && processosEmEspera.get(0).getTamanho() <= buraco[1]) {
                memoria.inserirProcesso(processosEmEspera.get(0), this.buraco[0]);
                processosEmEspera.get(0).setPosicaoMemoria(buraco[0]);
                processosEmExecucao.add(processosEmEspera.remove(0));
            }
        }
    }

    private void maiorBuraco() {
        buraco[0] = 0;
        buraco[1] = 0;
        int indice = 0;
        int tamanhoBuraco = 0;

        for (int i = 0; i < memoria.getTamanho(); i++) {
            if (memoria.getBuraco(i)) {
                tamanhoBuraco++;
            } else {
                if (tamanhoBuraco > this.buraco[1]) {
                    this.buraco[0] = indice;
                    this.buraco[1] = tamanhoBuraco;
                }
                indice = i + 1;
                tamanhoBuraco = 0;
            }
        }

        if (tamanhoBuraco > this.buraco[1]) {
            this.buraco[0] = indice;
            this.buraco[1] = tamanhoBuraco;
        }
    }

    private void executarProcessos() {
        for (int i = processosEmExecucao.size() - 1; i >= 0; i--) {
            processosEmExecucao.get(i).executar();
            if (processosEmExecucao.get(i).getTempoExec() == 0) {
                this.removerProcesso(i);
            }
        }
    }

    private void removerProcesso(int posicao) {
        Processo processoRemovido = processosEmExecucao.remove(posicao);
        memoria.removerProcesso(processoRemovido, processoRemovido.getPosicaoMemoria());

    }
}
