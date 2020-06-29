public class Determinante extends Thread {

  //campos
  Matrix m;
  double det;


  //construtor
  public Determinante(Matrix matrix){
    m = matrix;
    det = 0.0;
  }


  //InterruptedException
  @Override
  public void run() {
    synchronized(this){

      //trivial
      if (m.getRowsSize() == 2) {
        setDeterminante( m.getElement(0, 0) * m.getElement(1, 1) - m.getElement(0, 1) * m.getElement(1, 0) );
        // System.out.println("[ "+m.getElement(0, 0)+" "+m.getElement(0, 1)+" ]");
        // System.out.println("[ "+m.getElement(1, 0)+" "+m.getElement(1, 1)+" ]");
        // System.out.println(det);

        notify();
      }
      else{
        //laplace na primeira linha
        double detParcial = 0.0;
        for (int j = 0; j < m.getRowsSize(); j++) {

          Determinante subDet = new Determinante( m.getSubmatrix(j) );
          subDet.mToString();
          subDet.start();

          synchronized(subDet){
            try{
              subDet.wait();
            }
            catch(InterruptedException e){
              e.printStackTrace();
            }
            detParcial += Math.pow(-1, j+2) * m.getElement(0, j) * subDet.getDeterminante();

            setDeterminante(detParcial);
            // System.out.println(det);
          }
        }
        notify();
      }
    }
  }


  public double getDeterminante(){
    return det;
  }

  public void setDeterminante(double determinante){
    det = determinante;
  }

  public void mToString(){
    System.out.println("\ndet");
    m.printMatrix();
  }

}
