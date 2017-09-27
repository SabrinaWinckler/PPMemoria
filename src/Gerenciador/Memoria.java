
package Gerenciador;

import java.util.List;
import java.util.ArrayList;


public class Memoria {
    private List<Buraco> buracos;
    private int tamanhoMax = 1024;
    private int tamanhoAtual;
    
    public Memoria(){
        this.tamanhoAtual = 0;
    }
    public void addProcesso(Buraco buraco){
         this.buracos.add(buraco);
         
    }
   public List<Buraco> getProcessos(){// Não seria um getBuracos ??
       return this.buracos;
   }
}
