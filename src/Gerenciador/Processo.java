package Gerenciador;

public class Processo {

    private String nome;
    private int tamanho;
    private int tempoExec;
    private int tempoCheg;
    private int posicaoMemoria;

    public Processo(String nome, int tamanho, int tempoExec, int tempoCheg) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.tempoExec = tempoExec;
        this.tempoCheg = tempoCheg;
    }

    public void executar() {
        if (this.tempoExec >= 0) {
            this.tempoExec--;
        }
    }

    public String getNome() {
        return nome;
    }

    public long getTamanho() {
        return tamanho;
    }

    public int getTempoExec() {
        return tempoExec;
    }

    public int getTempoCheg() {
        return tempoCheg;
    }

    public int getPosicaoMemoria() {
        return posicaoMemoria;
    }

    public void setPosicaoMemoria(int posicaoMemoria) {
        this.posicaoMemoria = posicaoMemoria;
    }

    @Override
    public String toString() {
        return "Processo{" + "nome=" + nome + '}';
    }

}
