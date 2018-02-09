/**
 *
 * 
 * @author Bryan Yen
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }
    
    // count the total number name of males and females
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys   );
    }
    
    
    // print total numbers of males and females in 1905
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr0 = new FileResource("data/yob1900.csv");
        System.out.println("In 1900:");
        totalBirths(fr0);
        
        FileResource fr1 = new FileResource("data/yob1920.csv");
        System.out.println("In 1920:");
        totalBirths(fr1);
        
        FileResource fr2 = new FileResource("data/yob1940.csv");
        System.out.println("In 1940:");
        totalBirths(fr2);
        
        FileResource fr3 = new FileResource("data/yob1960.csv");
        System.out.println("In 1960:");
        totalBirths(fr3);
        
        FileResource fr4 = new FileResource("data/yob1980.csv");
        System.out.println("In 1980:");
        totalBirths(fr4);
        
        FileResource fr5 = new FileResource("data/yob2000.csv");
        System.out.println("In 2000:");
        totalBirths(fr5);
    }
    
    // getRank
    public int getRank(int year,String name,String gender){
        String fileName = "data/yob"+year+ ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        
        int tempRank =0;
        int rank=0;
        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                tempRank = tempRank +1;
                if(record.get(0).equals(name)){
                    rank = tempRank;
                    break;
                }
            }
        
        }
        
        if(rank ==0){
            rank=-1;
        }
        return rank;
       
    }
    
    public void testGetRank(){
        //int list[100] ; 
        
        System.out.println("Christine rank:");
        for(int i=1900;i<2001;i++){
            int rankResult =getRank(i,"Christine","F");
            System.out.println("In "+ i+":"+ rankResult);
        }
        
        System.out.println("Bryan rank:");
        for(int i=1900;i<2001;i++){
            int rankResult =getRank(i,"Bryan","M");
            System.out.println("In "+ i+":"+ rankResult);
        }
        
        
        // int rankResult= getRank(1966,"Tina","F");
        // System.out.println("Tina in female is ranked at "+ rankResult);
        //System.out.println("myList: "+ myList);

    }
    
    // getName
    public String getName(int year,int rank,String gender){
        String fileName = "data/yob"+year+ ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        
        int currentRank=0;
        String resultName ="No name";
        
        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                currentRank = currentRank+1;
                if(currentRank == rank){
                    resultName = record.get(0);
                    break;
                }
            }
        
        
        }
        return resultName;
    }
    
    public void testGetName(){
        String resultName1 = getName(1980,350,"F");
        System.out.println("In 1980,Females,Rank 350,name: "+ resultName1);
        
        String resultName2 = getName(1982,450,"M");
        System.out.println("In 1982,Males,Rank 450,name: "+ resultName2);
    
    }
    
    // what is name in new year?
    public void whatIsNameInYear(String name,int year, int newYear,String gender){
       String originalName = name;
       int originalYear = year;
     
       int rankResult = getRank(year,originalName,gender);
       String newName = getName(newYear,rankResult,gender);
       System.out.println(originalName + " born in "+ originalYear +" would be "+ newName+ " if she was born in "+newYear);
      

    }
    
    public void testWhatIsNameInYear(){
        //whatIsNameInYear("Isabella",2012,2014,"F");
        //whatIsNameInYear("Susan",1972,2014,"F");
        whatIsNameInYear("Owen",1974,2014,"M");
    }
    
    public int yearOfHighestRank(String name,String gender){
            int currentMaxRankYear = -1;
            int currentMaxRank = -1;
        
           DirectoryResource dr= new DirectoryResource();
           for(File f:dr.selectedFiles()){
               FileResource fr = new FileResource(f);
               CSVParser parser = fr.getCSVParser(false);
               String currentYears = f.getName().substring(3,7);// 是"f" 而不是 "fr"
               int currentYear = Integer.parseInt(currentYears);
               int tempRank =0;
               int rank= -1;
               
               for(CSVRecord record:parser){
                   if(record.get(1).equals(gender)){
                       tempRank =tempRank+1;
                       if(record.get(0).equals(name)){
                           rank = tempRank;
                           break;
                        }
                    
                    
                    }
                
                }
                
               if(currentMaxRank== -1 && rank != -1){
                   currentMaxRank = rank;
                   currentMaxRankYear = currentYear;
                }
               
               else if(rank < currentMaxRank && rank != -1){
                   currentMaxRank = rank;
                   currentMaxRankYear = currentYear;
                }
                
               
           }
           
           return currentMaxRankYear;
    
    }
    
     public void testYearOfHighestRank(){
        //System.out.println(yearOfHighestRank("Mary", "F")); 
        //System.out.println(yearOfHighestRank("Genevieve", "F"));
        System.out.println(yearOfHighestRank("Mich", "M"));
    }
    
    // getAverageRank
    public double getAverageRank(String name,String gender){
       //double avergeRank ;
       double sumRank=0.0;
       double countFiles=0.0;
       
       DirectoryResource dr= new DirectoryResource();
       for(File f:dr.selectedFiles()){
           FileResource fr = new FileResource(f);
           CSVParser parser = fr.getCSVParser(false);
           String currentYears = f.getName().substring(3,7);// 是"f" 而不是 "fr"
           int currentYear = Integer.parseInt(currentYears);
           int tempRank =0;
           int rank= -1;
           
           for(CSVRecord record:parser){
                   if(record.get(1).equals(gender)){
                       tempRank =tempRank+1;
                       if(record.get(0).equals(name)){
                           rank = tempRank;
                           break;
                        }
                    
                    
                    }
                    
                  
           }
           
           if(rank !=-1){
                sumRank += rank; 
                    
            }
                   
           
 
           countFiles = countFiles+1;
           System.out.println("sunRank:"+sumRank);
           System.out.println("countFiles:"+countFiles);
           System.out.println(" ");
       }
       
       double averageRank = sumRank / countFiles;
       System.out.println("averageRank: "+ averageRank);
       return averageRank;
    }
    
    public void testgetAverageRank(){
        double averageRankResults = getAverageRank("Christine","F");
        System.out.println("Christine's average Rank: "+averageRankResults);
    }
    
   
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int sumHigherNumBorn =0;
        int numBorn=0;
        int tempRank =0;
        String fileName = "data/yob"+year+ ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        int inputRank = getRank(year,name,gender);
        
        for(CSVRecord record:parser)
        {
            if(record.get(1).equals(gender))
            {
                 tempRank +=1;
                 if(tempRank < inputRank)
                 {
                    sumHigherNumBorn += Integer.parseInt(record.get(2));
                 }
            }
            
        }
        return sumHigherNumBorn;   
       }
        
    public void testGetTotalBirthsRankedHigher(){
        int resultSumBorn = getTotalBirthsRankedHigher(1990,"Drew","M");
        System.out.println("The numbers of Higer Born than Drew is: "+ resultSumBorn);
    }      
     
   
    }
      
  
    
