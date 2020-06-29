import java.util.Scanner;

public class CalculaDeterminante {

  public static void main(String[] args) {


    //decladacao das variaveis
    int dimensao;
    Matrix m;
    Scanner sc;


    // inicializacao
    // sc = new Scanner(System.in);
    // System.out.println("Informe a dimensao da matriz");
    // dimensao = sc.nextInt();
    // m = new Matrix(dimensao);
    // m.readMatrix();

    m = new Matrix(4);

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        m.setElement(i, j, 10*(i+1) + (j+1) );
      }
    }

    m.printMatrix();
    System.out.println();

    //calculo
    Determinante d = new Determinante(m);

    d.start();

    synchronized(d){
      try{
          System.out.println("Aguardando calcular...");
          d.wait();
      }
      catch(InterruptedException e){
          e.printStackTrace();
      }

      System.out.println("Determinante: " + d.getDeterminante() );
    }



  }
}

