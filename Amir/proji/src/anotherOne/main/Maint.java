package anotherOne.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Maint
{

    public static Map<String, Integer> freq = new HashMap<String,Integer>();
    public static List<Map.Entry<String, Integer>> lis; 
    public static List<Map.Entry<String, Integer>> list;	

	public static Map<String, Integer> frequency = new HashMap<String,Integer>();
	
    public static void main(String[] args)
    {       
    	System.out.println("Hello World");
    	String text = "the quick brown fox jumps fox fox over the lazy dog brown";
        String[] keys = text.split(" ");

        for (String word : keys){
        	if (frequency.containsKey(word)){
        		frequency.put(word, frequency.get(word)+1);
        	}
        	else {
        		frequency.put(word, 1);
        	}
        }

        list = new LinkedList<Map.Entry<String, Integer>>(frequency.entrySet());
        lis = new LinkedList<Map.Entry<String, Integer>>(frequency.entrySet());
    	quickSort(0,lis.size()-1);
        
        for(Entry<String,Integer> entry : list){
        	System.out.println(entry);
        }
        
//        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
//		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
//			Map.Entry<String, Integer> entry = it.next();
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}
        
    }
    
//  }
//		}
//  }

    static void quickSort(int lowerIndex , int higherIndex ){

    int i = lowerIndex;
    int j = higherIndex;
    Entry<String, Integer> piv = list.get(lowerIndex + (higherIndex - lowerIndex)/2);
    while (i <= j){
    	while (list.get(i).getValue()>piv.getValue()){
    		i++;
    	}
    	while (list.get(j).getValue()<piv.getValue()){
    		j--;
    	}
    	if (i<=j){
    		exchangeElements(i,j);
    	i++;
    	j--;
    } 
    }
    if(lowerIndex < i) {
    	quickSort(lowerIndex, j);
    }
    if (i<higherIndex){
    	quickSort(i,higherIndex);
    }
}

    static void exchangeElements(int i, int j){
	Entry<String,Integer> temp = list.get(i);
	list.set(i, list.get(j));
	list.set(j, temp);
}

  private Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {
 	 
		// Convert Map to List
		List<Map.Entry<String, Integer>> list = 
			new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
                                         Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
    }












/*
 * 
 * 
 * //        Set<Entry<String,Integer>> st = frequency.entrySet();
//        System.out.println(st.size());
 * 
 * 
 * 
 * 
 *         //  Map.Entry<String, Integer> dd = list.get(list.size()); 


    	freq.put("One", 1);
        freq.put("Two", 2);
        freq.put("Three", 3);

 * //  List<Integer> lst = 

//  int i = lowerIndex;
//  int j = higherIndex;
  
//  frequency.
//  Map.Entry<K, V> piv = 
//  frequency.entrySet().
  
        Iterator it = Arrays.asList(keys).iterator();
//  frequency.s
//  Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//		public int compare(Map.Entry<String, Integer> o1,
//                                     Map.Entry<String, Integer> o2) {
//			return (o1.getValue()).compareTo(o2.getValue());//Collections.sort(list);
//  for (String word : frequency.keySet()){
//  	System.out.println(word + ": " + frequency.get(word));
 * */
// */