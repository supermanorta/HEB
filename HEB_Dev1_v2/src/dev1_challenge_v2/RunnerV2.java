package dev1_challenge_v2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
/***
 * RunnerV2  is the second version of a class that executes the count, parse and sort of 
 * words in a given paragraph into a histogram
 * @author Miguel R Moreno-Orta
 *
 */

public class RunnerV2 {
	public static void main(String[] args) throws IOException {
		executeTheMapForSorting();
		System.out.println("Dont forget to reflash the file in ecilpse");
	}
	/***
	 * Reads in a hard-coded file and populates a Map. The Map receives removed syntactical
	 * things such as ',' and '.'  . It was not built with the intent to handle more than that. 
	 * @return Map<String, Integer>
	 * @throws FileNotFoundException
	 */
	static Map<String, Integer> readInFileToMap( ) throws FileNotFoundException 
	{
		File txtFileToBeRead                = new File("C:\\Users\\Yoda\\git\\HEB_Dev1_v2\\HEB_Dev1_v2\\programAccessories\\input.txt" );
		Scanner scanedTxtFile               = new Scanner( txtFileToBeRead );
		Map<String, Integer> wordsMap = new HashMap< String,Integer >();
		
		while( scanedTxtFile.hasNextLine() ) 
		{
			String tempHold = scanedTxtFile.next().toLowerCase();
			tempHold = tempHold.replaceAll("\\,|\\.|\\?|\"", "");
			if(wordsMap.containsKey( tempHold )) {
				wordsMap.put( tempHold, wordsMap.get( tempHold) + 1  );
			}else {
				wordsMap.put( tempHold,  1  );
			}
		}
		return wordsMap;
	}
	/***
	 * Creates a ModifiedMap object to be used as the hub of how the list gets
	 * used and edited to be printed out to a file
	 * @throws IOException
	 */
	static void executeTheMapForSorting() throws IOException 
	{
		ModifiedMap modMap = new ModifiedMap( readInFileToMap( ) );
		modMap.sortCurrentMap();
		modMap.reorgainizeMapList();
		writeToOutFile( modMap.getHEBReworkedMapList() );
	}
	/***
	 * A function that creates a file that will be written to as the final product
	 * of a ArrayList 
	 * @param modifiedList is of type ArrayList<String>
	 * @throws IOException
	 */
	static void writeToOutFile(ArrayList<String> modifiedList) throws IOException 
	{
		FileWriter fw          = new FileWriter(new File("C:\\Users\\Yoda\\git\\HEB_Dev1_v2\\HEB_Dev1_v2\\programAccessories\\output.txt") );
		BufferedWriter bw = new BufferedWriter( fw );
		for(int i =0; i < modifiedList.size(); i++) {
			if(i == (modifiedList.size()-1) ){
				bw.write( modifiedList.get(i));	
				break;
			}else{
				bw.write( modifiedList.get(i) +"\n");	
				
			}
		}
		bw.close();
		fw.close();
	}
}