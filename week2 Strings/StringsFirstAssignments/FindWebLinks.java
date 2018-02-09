
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//import edu.duke.*;
//import java.io.File;

/*public class Part4 {
    
    public void sayHello(){
    URLResource rs = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html"); 
		for (String line: rs.lines()) {
			System.out.println(line);
		}
   }
}  */

import edu.duke.*;
import java.io.*;

public class FindWebLinks {
    
    public void findLinks() {
        
        URLResource webPage = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html"); 
		for ( String word : webPage.words() ) {
		    
		    String wLow = word.toLowerCase();
		    //System.out.println("**original: "+ wLow);
			if ( wLow.contains( "youtube.com" ) && ( wLow.contains( "https://" ) || wLow.contains( "http://" ) ) ) {
			    
			    //System.out.println("original: "+ wLow);
			    System.out.println(" ");
			    int startQuote = wLow.indexOf("\"");
			    int endQuote = wLow.lastIndexOf("\"");
			    String ytLink = word.substring( startQuote+1, endQuote );
			    System.out.println( ytLink );
			    System.out.println(" ");
       
            }
			
		}
        
    }
    
}