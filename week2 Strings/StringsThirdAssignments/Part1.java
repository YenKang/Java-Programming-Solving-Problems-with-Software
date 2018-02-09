
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//video Coding StorageResource class in lesson Using the StorageResource Class

/**
 * Write a description of AllGenesStored here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import edu.duke.FileResource;

import edu.duke.StorageResource;


public class Part1 {
    public int findStopCodon(String dnaStr,
                             int startIndex, 
                             String stopCodon){                                 
            int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
            while (currIndex != -1 ) {
               int diff = currIndex - startIndex;
               if (diff % 3  == 0) {
                   return currIndex;
               }
               else {
                   currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
               }
            }
            return -1;
        
    }
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if (taaIndex == -1 ||
            (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 ||
            (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex,minIndex + 3);
    }
    public StorageResource getAllGenes(String dna) {
      //create an empty StorageResource, call it geneList
      StorageResource geneList = new StorageResource();
      //Set startIndex to 0
      int startIndex = 0;
      //Repeat the following steps
      while ( true ) {
          //Find the next gene after startIndex
          String currentGene = findGene(dna, startIndex);
          //If no gene was found, leave this loop 
          if (currentGene.isEmpty()) {
              break;
          }
          
          
          //Add that gene to geneList
          geneList.add(currentGene);
          //Set startIndex to just past the end of the gene
          startIndex = dna.indexOf(currentGene, startIndex) +
                       currentGene.length();
        }
      //Your answer is geneList
      return geneList;
    }
    
    
    public int countString(String target,String dna) {
      //Set startIndex to 0
      int pos = 0;
      int count = 0;
      //Repeat the following steps
      while ( true ) {
       
          
          pos = dna.indexOf(target,pos);
          if(pos== -1){
              break;
          }
          
          count = count +1;
          pos = pos +1; 
        }
        
      return count;
    }
    
    public float cgRatio(String dna){
        int c = countString("C",dna);
        int g = countString("G",dna);
        
        System.out.println("C:"+c+" times");
        System.out.println("G:"+g+" times");
        
        float fraction = (float)c/g;
        return fraction;
    }
    
    public void processGenes(String sr){
        //FileResource fr = new FileResource("brca1line.fa");
        //String dna = fr.asString();
    
    
    
    }
    
    public void testProcessGenes(){
    
    
    }
    
    public void testOn(String dna) {
        int geneCount = 0;
        System.out.println("-----------------------------" );
        System.out.println("Testing getAllGenes on " + dna);
       
        StorageResource genes = getAllGenes(dna);
        for (String g: genes.data()) {
         
             
              
            if(cgRatio(g) > 0.35){
                System.out.println(g);
                geneCount = geneCount+1;
            }
            
            
           
            System.out.println("This gene's length: "+ g.length());
            //geneCount = geneCount+1;
        }
        System.out.println(geneCount+" :times");
    }
    public void test() {
        //      ATGv  TAAv  ATG   v  v  TGA   
        String dna1= "ATGATCTAATTTATGCTGCAACGGTGAAGAATGATCATAAGAAGATAATAGAGGGCCATGTAAATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        //testOn(dna1);
        //System.out.println(cgRatio(dna1));
   
        //      ATGv  v  v  v  TAAv  v  v  ATGTAA
        //testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        
        //System.out.println(cgRatio("ATGATCTAATTTATGCTGCAACGGTGAAGA"));
        //URLResource fr = new URLResource("http://www.dukelearntoprogram.com/course2/data/dna/brca1line.fa");
        URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
     
        String kingDNA = fr.asString();
        String upcase_kingDNA = kingDNA.toUpperCase();
        testOn(upcase_kingDNA);
        //System.out.println(cgRatio(upcase_kingDNA));
        //System.out.println("-------------");
        //System.out.println("CTG in DNA: "+ countString("CTG",upcase_kingDNA));
        
        //System.out.println(mystery(dna1));       
        
    
    }
    
    public String mystery(String dna) {
          int pos = dna.indexOf("T");
          int count = 0;
          int startPos = 0;
          String newDna = "";
          if (pos == -1) {
            return dna;
          }
          while (count < 3) {
            count += 1;
            newDna = newDna + dna.substring(startPos,pos);
            startPos = pos+1;
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
              break;
            }
          }
          newDna = newDna + dna.substring(startPos);
          return newDna;
        }
}


