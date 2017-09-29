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

    public boolean getBuraco(int posicao) {
        return (this.processos[posicao] == null);
    }
}
