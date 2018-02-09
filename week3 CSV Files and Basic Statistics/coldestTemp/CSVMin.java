
/**
 * Write a description of CSVMin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMin {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        
        for(CSVRecord currentRow:parser){    
            if(smallestSoFar == null){
                smallestSoFar =currentRow;
            }
            
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF")); 
                if(currentTemp < smallestTemp){
                    smallestSoFar = currentRow;
                }
            }
        
        }
        
        return smallestSoFar;
    }
   
    public void testColdestHourInFile(){
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-06-29.csv");
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was "+ smallest.get("TemperatureF")+" at "+ smallest.get("TimeEDT"));
    }
    
    public CSVRecord coldestInManyDays(){
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }
            
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                
                if(currentTemp < smallestTemp){
                    smallestSoFar = currentRow;
                }
            }
        }
        return smallestSoFar;
    }
    
    public void testColdestInManyDays(){
        CSVRecord smallest = coldestInManyDays();
        System.out.println("The coldest temperature was " + smallest.get("TemperatureF") +
				   " at " + smallest.get("DateUTC") );
    }
    
    public String fileWithColdestTemperature(){
	    CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        String coldestFileName= null;
        
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }
            
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                
                if(currentTemp < smallestTemp){
                    smallestSoFar = currentRow;
                    coldestFileName = f.getName();
                }
                
            }
        }
        return coldestFileName;
	
    }
    
    public void InfoTemp(CSVParser parser){
        //CSVRecord currentRow = null;
        String time = null;
        String temp = null;
        for(CSVRecord currentRow:parser){    
            System.out.println(currentRow.get("DateUTC")+": "+currentRow.get("TemperatureF"));
        }
    }
	   
	public void testfileWithColdestTemperature(){
	    
	    String coldestName = fileWithColdestTemperature();
	    System.out.print("Coldest day was in file ");
        System.out.println(coldestName);
        System.out.println(coldestName);
        
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        
        System.out.print("The coldest temperature on that way was ");
        System.out.println(coldest.get("TemperatureF"));
        
        System.out.println("All the Temperatures on the coldest day were:");
        // show all info in a day
        InfoTemp(fr.getCSVParser());
        
	   
	}
	
	public CSVRecord lowestHumidityInFile(CSVParser parser){
	   CSVRecord lowestHumid = null;
	   
	   for(CSVRecord record:parser){
	       String currHumid = record.get("Humidity");
	       if(!currHumid.equals("N/A")){
	           double numHumid = Double.parseDouble(record.get("Humidity"));
	           
	           if(lowestHumid == null ||  numHumid < Double.parseDouble( lowestHumid.get("Humidity") ) )
	           {
	               lowestHumid = record;
	           }
	           
	          
	       }
	   }
	   
	   return lowestHumid;
	}
	   
	public void testLowestHumidityInFile(){
	  
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		
		System.out.println("The lowest humidity in File is: " + csv.get("Humidity") +" at " + csv.get("DateUTC") );
     }
     
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumidity = null;
		
		//get the directory
		DirectoryResource dr = new DirectoryResource();
		
		for(File file : dr.selectedFiles()){
			
			
			//get the file
			FileResource fr = new FileResource(file);
			
			//get the CSV praser
			CSVParser praser = fr.getCSVParser();
			
			//get the lowest Humidity in that document 'file'
			CSVRecord currLowHumidity = lowestHumidityInFile(praser);
			
			//compare and assign the CSV record with lower humidity to lowestHumidity;
			if(lowestHumidity == null || Double.parseDouble(currLowHumidity.get("Humidity")) < Double.parseDouble( lowestHumidity.get("Humidity")))
				lowestHumidity = currLowHumidity;
			
		}//end for File loop;
		
		return lowestHumidity;
    
    }
    
    public double averageTemperatureInFile(CSVParser parser){
       int count =0;
       double total =0;
       double averTemp;
        
       for(CSVRecord currRow:parser){
	  
	       double numTemp = Double.parseDouble(currRow.get("TemperatureF"));
	       total = total + numTemp;
	       count = count +1;
	           
	           
	   }
	   
	   averTemp = total/count;
	   
	   return averTemp;
	 }


	 
	  public void testLowestHumidityInManyFiles(){
	
		CSVRecord csv = lowestHumidityInManyFiles();	
		System.out.println("The lowest humidity in File is: " + csv.get("Humidity") +" at " + csv.get("DateUTC") );
    
    } 
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
        double averTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is: " + averTemp);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sum =0;
        double average =0;
        int count =0;
        for(CSVRecord currentRow:parser){
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            
            if(currentHumidity >= value ){
                sum = sum + currentTemp;
                count = count +1;
            }
            
        }
        average = sum/ count;
        return average;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
	    double avarage = averageTemperatureWithHighHumidityInFile(parser,80);
	    if(avarage==0){
	        System.out.println("No temperatures with that humidity");  
	    }
	    
	    else {
	        System.out.println("Average temperature when high Humidity is " + avarage);
	    }
    
    
    }


}
    
    
  