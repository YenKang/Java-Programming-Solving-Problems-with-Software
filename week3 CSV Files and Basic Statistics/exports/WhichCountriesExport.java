/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public void whoExportsCoffee() {
        //FileResource fr = new FileResource();
        //CSVParser parser = fr.getCSVParser();
        CSVParser parser1 = tester();
        listExporters(parser1, "coffee");
    }
    
    public CSVParser tester(){
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       return parser;
    }
    
    public String countryInfo(CSVParser parser, String country){
        String countryInfo="";
        for(CSVRecord record:parser){    
        String country1 = record.get("Country");
        
        if(country1.contains(country)){
           String cho_country = record.get("Country");
           String cho_exports = record.get("Exports");
           String cho_values = record.get("Value (dollars)");  
          countryInfo = (cho_country+" : "+cho_exports+" : "+ cho_values);
        }        
        } 
        return countryInfo;
    }
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
       
        for(CSVRecord record:parser){
            String export = record.get("Exports");
            
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country);
        
            }
            
        }
   
    }
    

    public int numberOfExporters(CSVParser parser,String exportItem){
        int count_country=0;
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportItem)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                count_country = count_country+1;

            }
        }
    
        return count_country;
    }
    
    
    public void test(){
        
        // part2
        //CSVParser parser2=tester();
        //System.out.println(countryInfo(parser2,"Nauru"));
        
         //part3
        //CSVParser parser3=tester();
        //listExportersTwoProducts(parser3,"cotton","flowers");
        
        //part4
        //CSVParser parser4 = tester();
        //System.out.println(numberOfExporters(parser4,"cocoa"));
        
        //part5
        CSVParser parser5 = tester();
        bigExporters(parser5, "$999,999,999,999");
        
    }
    
    public void bigExporters(CSVParser parser,String money){
        
        for(CSVRecord record:parser){
            
            String currValue = record.get("Value (dollars)");
            
            if(money.length() < currValue.length()){
                System.out.println("Count: " + record.get("Country") + ", " + record.get("Value (dollars)") );
            }
        }
    }
}
