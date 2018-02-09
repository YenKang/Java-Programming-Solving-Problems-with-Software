
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
         int startPosition = stringb.indexOf(stringa);
         if(startPosition==-1){return false;}
         
         if(stringb.indexOf(stringa,startPosition+1)== -1){return false; }
         
         return true;
    }
    
    public String lastPart(String stringa, String stringb){
        int startPosition = stringb.indexOf(stringa);
        if (startPosition == -1)
        {return stringb;}
        
        int length = stringa.length();
        String stringAdd = stringb.substring(startPosition,startPosition+length+1);
        return stringAdd;
    
    }
    
    public void test(){
        System.out.println("Is there more than one by in by the way baby? " + twoOccurrences("by", "by the way baby"));
        System.out.println("lastPart(by, angelababyaaa):"+ lastPart("by", "angelababyaaa"));
        System.out.println("lastPart(zoo, apple):"+ lastPart("zoo", "apple"));
    }

}
