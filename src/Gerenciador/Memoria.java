package Gerenciador;

public class Memoria {

    private Processo[] processos;
    private int tamanho;

    public Memoria(int tamanho) {
        this.processos = new Processo[tamanho];
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Processo[] getProcessos() {
        return processos;
    }

    public boolean getBuraco(int posicao) {
        return (this.processos[posicao] == null);
    }

    public void inserirProcesso(Processo processo, int indice) {
        for(int i = indice; i < processo.getTamanho(); i++){
            processos[i] = processo;
        }
    }
}
