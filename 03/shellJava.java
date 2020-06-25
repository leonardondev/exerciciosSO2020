import java.io.*;

public class shellJava {


  public static void main(String[] args){
    
    // Declaracao das variaveis
    ProcessBuilder pb;
    Process process1;
 
    // Inicializacao das variavais
    pb = new ProcessBuilder(args[0], args[1]).inheritIO();
    

    try{
        process1 = pb.start();//cria processo filho
        process1.waitFor(); //espero pelo termino de sua execucao
  
        System.out.print("retorno do processo filho: ");
        System.out.println(process1.exitValue());
        
    }catch(IOException ioe){//erro no inheritIO
        System.err.println(ioe);
    
    }catch (InterruptedException ie){//erro no waitfor
         System.err.println(ie);
    }

  }
}