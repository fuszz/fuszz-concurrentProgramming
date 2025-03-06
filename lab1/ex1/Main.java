import java.lang.ProcessBuilder;
import java.lang.Process;
import java.io.IOException;

public class Main{
  public static void main (String[] args) throws IOException {
      String browserPath = "/bin/firefox";
      Process firefox = new ProcessBuilder(browserPath, System.getProperty("user.dir")+"/../exercises.pdf").start();
      System.out.println(firefox);
  }
}