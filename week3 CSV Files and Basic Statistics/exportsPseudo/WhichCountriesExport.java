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
        for(CSVRecord record:parser)
        {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if(export.indexOf(exportOfInterest)!= -1)
            {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
               
        }    
    }

    public void whoExportsWirelessCommunicationEquipment() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "wireless communication equipment");
    }

    public String countryInfo(CSVParser parser, String country){
        String countryInfo = " ";
        for(CSVRecord record:parser){

            // Look ar the "Country" column
            String currCountry = record.get("Country");
            // check if it contains input country
            if(currCountry.contains(country)){
                // If so, store the export items of input country;
                String this_exports = record.get("Exports");
                String this_country = record.get("Country");
                String thus_values = record.get("Value (dollars)");
                countryInfo = (this_country+ ": "+this_exports+ ": "+thus_values);

            }
        }

        return countryInfo;

    }

    public void whatExportItemsOfTaiwan(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Taiwan"));

    }
    
    public void whatExportItemsOfParticularCountry(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Philippines"));

    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1,String exportItem2){
        for(CSVRecord record:parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country + " exports "+ exportItem1 + " and " + exportItem2);
            }

        }

    }
    
      public void listExportersOneProduct(CSVParser parser, String exportItem1){
        for(CSVRecord record:parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) ){
                String country = record.get("Country");
                System.out.println(country + " exports "+ exportItem1 );
            }

        }

    }
    
     public void whichCountryExportsSelectedItem(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersOneProduct(parser, "semiconductors");

    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int count_country =0;
        for (CSVRecord record: parser) {
            // Look ar the "Exports" column
            String export = record.get("Exports");

            if (export.contains(exportItem)) {
                String country = record.get("Country");
                count_country =  count_country+1;
            }
        }
        return count_country;
    }

    public void whichCountryExportsSelectedItems(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "computers","electronics");

    }

    public void howManyCountriesExportSemiconductors(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int count_country = numberOfExporters(parser,"semiconductors");
        System.out.println("There are "+ count_country + " exporting " + "semiconductors");
    }

    public void bigExporters(CSVParser parser, String money){
        for (CSVRecord record:parser ) {
            String currValue = record.get("Value (dollars)");
            if(money.length()< currValue.length()){

                System.out.println("Country: " + record.get("Country") + ", " + record.get("Value (dollars)") );
            }
        }
    }

    public void valueMoreThanOnehundredBillion(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "100,000,000,000");

    }


}