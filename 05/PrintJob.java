import java.util.concurrent.Semaphore;

public class PrintJob extends Thread {

  private PrintSpooler printer;
  private Semaphore mutex;
  private String doc;

  public PrintJob(PrintSpooler printer, Semaphore mutex, String doc) {
    this.printer = printer;
    this.mutex = mutex;
    this.doc = doc;
  }

  public void run() {

    try {
      mutex.acquire();
      System.out.println("imprimindo " + doc + "...");
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    finally {
      mutex.release();
    }
  }
}

