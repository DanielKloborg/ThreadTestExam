
public class Main {

  public static void main( String[] argv ) throws InterruptedException {
    new SimpleServer().start();
    Thread.sleep(1000);

    new SimpleClient().start();
  }
}