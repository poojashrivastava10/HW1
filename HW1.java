package LanguageModel;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;



 


public class HW1 {

	static Ngrams ng ;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		ArrayList<String> Lines= readfiles("C:\\Users\\Pooja\\Desktop\\Courses\\NLP\\HW1\\HW1\\ALL");
		//System.out.println(Lines.size());
		noofwords(Lines);
		noofuniquewords(Lines);
		
//		for (String s : Lines)
//		{
//			Ngrams ng= new Ngrams(s,2);
//			ng.getNGramsText();
//			
//			//strings++;
//		}

        }
	
public static ArrayList<String> readfiles (String path) throws FileNotFoundException
{
	File dir = new File(path);
	ArrayList<String> lines = new ArrayList<String>();
	
	for (File files : dir.listFiles()) 
	{
		
	    Scanner s = new Scanner(files);	
	    ArrayList<String> line = new ArrayList<String>();

		
		while (s.hasNextLine())
		{
			line.add(s.nextLine());
		}
				
		lines.addAll(line);
		s.close();
		
		
	}
	
	return lines;
	
}

public static void noofwords(ArrayList<String> Lines)
{
	int words = 0;
	for (String s : Lines)
	{
		
		words=words+s.split(" ").length;
		//strings++;
	}
	System.out.println("The total number of words in the reviews are: "+words);
}

public static void noofuniquewords(ArrayList<String> Lines)
{
    String word;
    HashMap<String , Integer> Hmap = new HashMap<>();
    
    for (String S : Lines) 
    {
    	StringTokenizer st = new StringTokenizer(S);
    	while (st.hasMoreTokens())
    	{
    		word = st.nextToken();
    		int val =0;
           		        		
    		if (Hmap.containsKey(word))
    		{
    			val = Hmap.get(word).intValue();
    			val = val +1;
    			Hmap.put(word, val);
    		}
    		else
    		{
    			Hmap.put(word, 1);
    		}
    	}
     }
    int count =0;
    for(int i : Hmap.values())
    {
        if (i==1)
            count++;
    }
    System.out.println("The total no of Unique words:" +count);
}
}