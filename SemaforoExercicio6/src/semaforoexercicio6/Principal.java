package semaforoexercicio6;


public class Principal {


   public static void main(String[] args) {
      
      Maquina maq = new Maquina();
      Pessoa p = new Pessoa(maq);
      p.start();

   }
}
