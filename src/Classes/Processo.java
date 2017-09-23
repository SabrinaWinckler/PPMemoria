
package Classes;

public class Processo {

    private String nome;
    private int tamanho;
    private int tempoExec;
    private int tempoCheg;

    public Processo(String nome, int tamanho, int tempoExec, int tempoCheg) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.tempoExec = tempoExec;
        this.tempoCheg = tempoCheg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTempoExec() {
        return tempoExec;
    }

    public void setTempoExec(int tempoExec) {
        this.tempoExec = tempoExec;
    }

    public int getTempoCheg() {
        return tempoCheg;
    }

    public void setTempoCheg(int tempoCheg) {
        this.tempoCheg = tempoCheg;
    }

}
