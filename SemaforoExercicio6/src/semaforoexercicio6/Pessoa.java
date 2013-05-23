package semaforoexercicio6;

import java.util.Random;

public class Pessoa extends Thread{

   private Maquina maq;
   
   
   public Pessoa(Maquina maq) {
      this.maq = maq;

   }
   
   public void run()   {
    
      while (true) {
         maq.paga();
         System.out.println();
         System.out.println();
      }
   }
}
