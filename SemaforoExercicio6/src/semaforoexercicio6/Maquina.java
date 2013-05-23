package semaforoexercicio6;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maquina {

   Semaphore mutex;
   Random rand;
   float valorMoeda;
   String produto;

   public Maquina() {
      mutex = new Semaphore(1);
      rand = new Random();
      this.produto = null;
   }

   public void paga() {
      try {
         mutex.acquire();
         do {
            valorMoeda = rand.nextInt(11) * 0.1f; // valores de 0.0 a 1.0
            if (valorMoeda == 1.0) {
               produto = "Refri";
               liberaProduto();
               break;
            }
            if (valorMoeda == 0.5) {
               produto = "Água";
               liberaProduto();
               break;
            }
         } while (valorMoeda != 1.0 || valorMoeda != 0.5);
      } catch (InterruptedException ex) {
         Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void liberaProduto() {
      System.out.println("Valor inserido (R$): "+ valorMoeda);
      System.out.println("Produto liberado: "+ produto);
      mutex.release();
  }
}
