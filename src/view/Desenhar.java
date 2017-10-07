/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import gerais.Memoria;
import gerais.Processo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author tobia
 */
public class Desenhar extends JFrame {

    private Memoria memoria;
    private static int posicaoProcesso;
    private int proxPosicao;
    int [] buraco;
    ArrayList<Processo> processos = new ArrayList();

    private int posicaoString;

    public Desenhar(Memoria memoria) {
        this.memoria = memoria;
        transformaMemoria(memoria);
        
       setSize(1200, 1024);
      setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.fillRect(100, 50, 300, memoria.getTamanho());

        for (int i = 0; i <= memoria.getTamanho(); i++) {
            
            if (i == 0) {
                posicaoProcesso = 55;//posiÃ§Ã£o inicial
            } else {
                posicaoProcesso = proxPosicao;//posiÃ§Ã£o anterior + tamanho do processo
            }
            if(processos.get(i).getNome()=="buraco"){
                                g.setColor(Color.gray);
            g.fillRect(110, posicaoProcesso, 280, processos.get(i).getTamanho());
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial Bold", Font.PLAIN, 11));
            posicaoString =  posicaoProcesso+processos.get(i).getTamanho() / 2; // onde vai escrever o nome do processo
            g.drawString("Buraco "+processos.get(i).getTamanho() + "k", 150, posicaoString);
            proxPosicao = posicaoProcesso + processos.get(i).getTamanho()+5;
            }else{
                g.setColor(Color.red);
            g.fillRect(110, posicaoProcesso, 280, processos.get(i).getTamanho());
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial Bold", Font.PLAIN, 11));
            posicaoString = posicaoProcesso+ processos.get(i).getTamanho()/2; // onde vai escrever o nome do processo
            g.drawString(processos.get(i).getNome()+" "+processos.get(i).getTamanho() + "k", 150, posicaoString);
            proxPosicao = posicaoProcesso + processos.get(i).getTamanho()+5;
            }
        }
//    }
    }

    public List transformaMemoria(Memoria m) {
        
        
        for (int i = 0; i < memoria.getTamanho(); i++) {
            if (m.getBuraco(i))//ver como vem o buraco
            {
               int tamanhoBuraco= maiorBuraco(i);
               Processo p = new Processo("buraco", tamanhoBuraco, 0, 0);
               processos.add(p);
               i =i+tamanhoBuraco;
            } else {

               Processo primeiro = m.getPosicao(i);
                int tamanhoProcesso = primeiro.getTamanho();
              Processo p = new Processo(primeiro.getNome(), tamanhoProcesso, 0, 0);
              processos.add(p);
              i=i+tamanhoProcesso;
                
            }
        }
        return processos;
    }
        private int maiorBuraco(int posicao) {
        int tamanhoBuraco = 0;

        for (int i = posicao; i < memoria.getTamanho(); i++) {
            if(memoria.getPosicao(i)==null){
                tamanhoBuraco++;
            }else{break;}
        }

        return tamanhoBuraco;
    }

}
