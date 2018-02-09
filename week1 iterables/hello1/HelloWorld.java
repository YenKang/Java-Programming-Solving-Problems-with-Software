import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		FileResource rs = new FileResource("animals.txt");
		for (String line : rs.lines()) {
			System.out.println(line);
		}
	}
}
