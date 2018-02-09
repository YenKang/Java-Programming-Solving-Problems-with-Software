
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna,String startCodon, String stopCodon){
        String result = ""; 
        int startIndex = dna.indexOf("ATG");
        
        if( startIndex== -1)
        {return "";}
        
        int stopIndex = dna.indexOf("TAA",startIndex+3);
         if( stopIndex== -1)
        {return "";}
        result = dna.substring(startIndex, stopIndex+3);
      
        return result ;
        
        
    }
    
    public boolean twoOccurrences(String stringa, String stringb){
    }
    
    public void testFindGeneSimple(){
        String dna = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is " + dna);
        
        String (gene, startCodon,stopCodon) = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    
    }

}
