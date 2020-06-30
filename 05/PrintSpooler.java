import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class PrintSpooler {
  //
  String spoolFile;
  BufferedWriter spool;

  // construtor classe - recebe como parâmetro o nome do arquivo de spool
  public PrintSpooler(String spoolFile) {
      this.spoolFile = spoolFile;
  }

  // método utilizado para abrir o arquivo de spool
  public boolean openPrintSpooler() throws IOException {
    try {
      spool = new BufferedWriter(new FileWriter(spoolFile));
    }
    catch (IOException ioe) {
      System.err.println("Erro ao abrir spool");
      return false;
    }
    return true;
  }

  // método utilizado para imprimir um job
  public void printJob(String jobName) throws IOException {
    try {
      spool.append(jobName + "\n");
    } catch (Exception e) {
      System.err.println("Erro durante a impressao");
    }
  }


  // método utilizado para fechar o arquivo de spool
  public void closePrintSpooler() throws IOException {
    try {
      spool.close();
    }
    catch (IOException ioe) {
      System.err.println("Erro ao fechar spool");
    }
  }

}
