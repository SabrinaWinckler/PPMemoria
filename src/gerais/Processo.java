package gerais;

public class Processo {

    private String nome;
    private int tamanho;
    private int tempoCheg;
    private int tempoExec;
    private int posicaoMemoria;

    public void setTempoExec(int tempoExec) {
        this.tempoExec = tempoExec;
    }

    public Processo(String nome, int tamanho, int tempoCheg, int tempoExec) {
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

    public int getTamanho() {
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
