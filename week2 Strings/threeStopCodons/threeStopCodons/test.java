
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test {
    public void test(){
        String dna = "CTGCCTGCATGATCGTA";
        int pos = dna.indexOf("TG");
        int count = 0;
        while (pos >= 0) {
            count = count + 1;
            pos = dna.indexOf("TG",pos);
        }
        System.out.println(count);
    }
}
