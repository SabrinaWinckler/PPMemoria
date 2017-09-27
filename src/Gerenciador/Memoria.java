
package Gerenciador;

import java.util.List;
import java.util.ArrayList;


public class Memoria {
    private Buraco [] buracos = new Buraco [1000];
    private int tamanhoMax = 1024;
    private int tamanhoAtual=0;
    private int buracoAtual = 0;
    
    public Memoria(){
    }
    public boolean addBuraco(Buraco buraco){// mudei o nome do método e fiz a validação pra não estrapolar o tamanho max, deixei booleano para tratar
        if(buraco.getTamanho()+tamanhoAtual>tamanhoMax){
         tamanhoAtual+=buraco.getTamanho();
         this.buracos[buracoAtual] = buraco;
         buracoAtual++;
         return true;
        }return false;
    }
   public Buraco[] getBuracos(){
       return this.buracos;
   }
}
