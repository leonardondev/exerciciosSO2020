import java.util.Scanner;

public class CalculaDeterminante{

  public static void main(String[] args) {


    //decladacao das variaveis
    int dimensao;
    Matrix m;
    Scanner sc;


    //inicializacao
    sc = new Scanner(System.in);
    System.out.println("Informe a dimensao da matriz");
    dimensao = sc.nextInt();
    m = new Matrix(dimensao);

    //preenchimento da matriz
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        System.out.println("Valor do elemento m" + (i+1) + (j+1) );
        m.setElement(i, j, sc.nextInt() );
      }
    }

    //calculo
    Determinante d = new Determinante(m);
    d.start();


    System.out.println("Determinante: " + d.getDeterminante());


  }
}
