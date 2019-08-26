package tw;

import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.Soundbank;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import tw.commands.GuessInputCommand;

public class Main {

    private static final int RUN_TIMES = 6;
    
    public static String[] isValid(String input) {
    	String[] arr = input.split(" ");
    	if (arr == null) {
    		System.out.println("Wrong Input，Input again\n");
			return null;
		}
        if (input.length() != 7) {
			System.out.println("Wrong Input，Input again\n");
			return null;
		}
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (String a : arr) {
			set.add(Integer.parseInt(a));
		}
        if (set.size() != 4) {
        	System.out.println("Wrong Input，Input again\n");
        	return null;
		}
		return arr;
	}
    
    public static int countAFunc(String[] arr) {
    	int countA = 0;
    	if (arr[0].equals("1")) {
			countA+=1;
		} 
        if (arr[1].equals("2")) {
			countA+=1;
		} 
        if (arr[2].equals("3")) {
			countA+=1;
		} 
        if (arr[3].equals("4")) {
			countA+=1;
		} 
        return countA;
	}
    
    public static int countBFunc(String[] arr, int countA) {
    	int countB = 0;
    	for (String c : arr) {
        	if (c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4")) {
				countB++;
			}
        	else {
				continue;
			}
		}        
                    
        int B = countB-countA > 0 ? countB-countA : 0;
        
        return B;
	}

    public static void main(String[] args) throws Exception {
    	int countA = 0;
    	int countB = 0;
        for (int i = 0; i < RUN_TIMES; i++) {
            String input = new GuessInputCommand().input();
//            System.out.println(input.length());
            String[] arr = isValid(input) ;
            
           
            countA = countAFunc(arr);
            countB = countBFunc(arr, countA);
            
            System.out.println(countA+"A"+ countB+"B\n");	
            countA = 0;
            countB = 0;          
        }
        
       
    }
    
    
}
