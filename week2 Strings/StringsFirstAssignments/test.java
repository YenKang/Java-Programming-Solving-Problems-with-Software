
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           //System.out.println("Before_index: "+index);
           index = input.indexOf("abc",index+4);
           //System.out.println("After_index: "+index);
           
       }
   }

   public void test(){
       //findAbc("abcd");
       //findAbc("abcdabc");
       
      
       System.out.println("--------------------------");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
      
   }
   
   
    
}
