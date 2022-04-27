import java.net.*;
import java.io.*;

public class SimpleClient extends Thread{
  
  @Override
  public void run() {
    try {
      Socket connection = new Socket( "127.0.0.1", 6010 );
      System.out.println( "[Client] Connection opened" );
    
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
      
      sendLine( writer, "42" );
      sendLine( writer, "31" );
      sendLine( writer, "22" );
      sendLine( writer, "11" );
      sendLine( writer, "7" );
      sendLine( writer, "2" );
      sendLine( writer, "<end>");

      writer.close();
      System.out.println( "[Client] Connection closed" );
    }
    catch ( IOException e ) {
      System.out.println( "[Client] I/O error" );
    } 
    catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
  
  private void sendLine( BufferedWriter writer, String line )throws IOException, InterruptedException {
    System.out.println( "[Client] sending line: " + line );
    
    writer.write( line );
    writer.newLine();
    writer.flush();
    
    Thread.sleep(1000);
  }
}