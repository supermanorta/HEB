package dev1_challenge_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class ModifiedMap {
	/***
	 * the Starting Map to be modified
	 */
	private Map<String, Integer> map;
	/***
	 * a Copy of the Set entry of this.map
	 */
	private Set<Entry<String,Integer>> mapSetEntries;
	/***
	 * a List of Set Entry from this.mapSetEntries
	 */
	private List<Entry<String,Integer>> mapList;
	/***
	 * A member whos' life is to hold values in a certain format
	 */
	private ArrayList<String> hebReworkedMapList ;
	/***
	 * Constructs a ModifiedMap object
	 * @param passedMap, of type Map<String, Integer>
	 */
	public ModifiedMap(Map<String, Integer> passedMap) 
	{
		this.map = passedMap;
		this.mapSetEntries = this.map.entrySet();
		this.mapList = new ArrayList<Entry<String,Integer>>(mapSetEntries);
		this.hebReworkedMapList = new ArrayList<String>();
	}
	/***
	 * Sorts a list via ascending order of values  
	 * a list sorted by value, largest to smallest
	 */
	public void sortCurrentMap() 
	{
		Collections.sort(this.mapList, new Comparator<Entry<String,Integer>>() {
			public int compare(Entry<String, Integer> element1,
					           Entry<String, Integer> element2) {
				//Sort in Ascending order, if the result was to the opposite simple flip the elements
				return element1.getValue().compareTo(element2.getValue() );
			}
		} );
	}
	/***
	 * A get method to return member this.getMapList
	 * @return a List<Entry<String,Integer>> 
	 */
	public List<Entry<String,Integer>> getMapList(){
		return this.mapList;
	}
	/***
	 * Returns an original version of a Map, this.map
	 * @return a String of this.map
	 */
	public String toStringUnEdited() {
		Iterator myIterator = this.map.entrySet().iterator();
		
		while( myIterator.hasNext() ) {
			Map.Entry mapPiece = (Map.Entry)myIterator.next();
			return "Key scanned-> "+ mapPiece.getKey() + " " + " with pair value " +mapPiece.getValue() ;
		}
		return "no map to return";
	}
	/***
	 * Reorganize a mapList ( List<Entry<String,Integer>> ) and saves it so that
	 * the higher value is always on top of the list. This is save in a other member of this class.
	 */
	public void reorgainizeMapList() {
		String stringEqualsAmount = "";
		for(int i = mapList.size() -1; i>=0; i--) {
			String hebFormat = String.format("%9s ",mapList.get(i).getKey() );
			//System.out.print( hebFormat + " | " );
			for(int x =0; x <mapList.get(i).getValue(); x++) {
				//System.out.print( "=" );
				stringEqualsAmount += "=";
			}
			this.hebReworkedMapList.add( hebFormat + " | " + stringEqualsAmount +" "
			                                  + "("+mapList.get(i).getValue() + ")");
			stringEqualsAmount ="";
			
		}
	}
	/***
	 * Returns a class member hebReworkedMapList 
	 * @return this.hebReworkedMapList which is of type ArrayList<String>
	 */
	public ArrayList<String> getHEBReworkedMapList() {
		return this.hebReworkedMapList;
	}
}