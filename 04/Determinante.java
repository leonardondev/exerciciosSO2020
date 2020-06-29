
public class Determinante extends Thread {

  //campos
  Matrix m;
  float det;


  //construtor
  public Determinante(Matrix matrix){
    m = matrix;
    det = 0;
  }


  //InterruptedException
  @Override
  public void run() {
    synchronized (this) {
      //trivial
      if (m.getRowsSize() == 2) {
        det = m.getElement(0, 0) * m.getElement(1, 1)
            - m.getElement(0, 1) * m.getElement(1, 0);
      }

      //laplace na primeira linha 
      for (int j = 0; j < m.getRowsSize()-1; j++) {
        Determinante subDet = new Determinante( m.getSubmatrix(j) );
        subDet.start();
        det += Math.pow(-1, j+2) * m.getElement(0, j) * subDet.getDeterminante();
      }


    }
  }
  

  float getDeterminante(){
    return det;
  }

}
