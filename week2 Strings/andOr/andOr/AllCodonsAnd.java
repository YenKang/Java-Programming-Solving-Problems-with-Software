//video Coding And / Or in lesson Finding All Genes in DNA

/**
 * Using AND && and OR ||
 * 
 * @author Owen
 * @version 1.0
 */
public class AllCodonsAnd {
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
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        //int temp = Math.min(taaIndex,tagIndex);
        //int minIndex = Math.min(temp, tgaIndex);
        //int minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        int minIndex = 0;
        if (taaIndex == -1 ||
            (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        
        // if taaIndex == -1 OR
        // if tgaIndex != -1 AND tgaIndex < taaIndex
        // then set minIndex to tgaIndex
        // else set minIndex to taaIndex
        if (minIndex == -1 ||
            (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        // if minIndex == -1 OR 
        // if tagIndex != -1 and tagIndex < minIndex
        // then set minIndex to tagIndex
        // if minIndex == -1, return ""
  
        
        if (minIndex == -1){
            return "";
        }
        
        return dna.substring(startIndex,minIndex + 3);
    }
    
    public void testFindStop() {
        //            01234567890123456789012345
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if (dex != -1) System.out.println("error on 26");
        dex = findStopCodon(dna,0,"TAG");
        if (dex != -1) System.out.println("error on 26 TAG");
        System.out.println("tests finished");
    }
    
    public void testFindGene() {
        String dna = "ATGCCCGGGAAATAAACCC";
        String gene = findGene(dna);
        if (! gene.equals("CATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("testeeeeees finished");
    }
}
