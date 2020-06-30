import java.util.concurrent.Semaphore;


public class Exe5 {

  public static void main(String[] args) {

    //organizar os arquivos
    Semaphore mutex = new Semaphore(1);
    PrintSpooler printer = new PrintSpooler( new String("papel.txt") );
    PrintJob[] arquivos = new PrintJob[args.length];

    for (int i = 0; i < args.length ; i++) {

      arquivos[i] = new PrintJob(printer, mutex, args[i]);
      arquivos[i].start();
    }


  }
}
