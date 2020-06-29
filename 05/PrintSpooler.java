public class PrintSpooler {

  // construtor classe - recebe como parâmetro o nome do arquivo de spool
  public PrintSpooler(String spoolFile);
  
  // método utilizado para abrir o arquivo de spool
  public boolean openPrintSpooler();
  
  // método utilizado para imprimir um job
  public void printJob(String jobName);
  
  // método utilizado para fechar o arquivo de spool
  public void closePrintSpooler();


  