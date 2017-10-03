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
    public Processo getPosicao(int indice){
        for(int i = 0; i <= indice; i++){
            if(i == indice){
               return processos[i];
            }
        }
        return null;
    }

    public boolean getBuraco(int posicao) {
        return (this.processos[posicao] == null);
    }

    public void inserirProcesso(Processo processo, int indice) {
        for(int i = indice; i < processo.getTamanho(); i++){
            if(getBuraco(i)){
                processos[i] = processo;
            }
        }
    }
    public void removerProcesso(Processo processo, int indice) {
        for(int i = indice; i < processo.getTamanho(); i++){
            processos[i] = null;
        }
    }

    @Override
    public String toString() {
        return "Memoria{" + "processos=" + processos.toString() + '}';
    }
    
}
