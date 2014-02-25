package ie.gmit;

import java.util.HashMap;
import java.util.Map;

/**
 * Put the characters and their appear times into a map.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class HuffmanMap {
	/**
	 * Statistics a character's appear times in the string.
	 * 
	 * @param source
	 * @return A map with the statistic information
	 */
	public Map<Character, Integer> getMap(String source) {

		int[] charcount = new int[256];

		for (int i = 0; i < source.length(); i++) {
			charcount[source.charAt(i)]++;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < 256; i++) {
			if (charcount[i] != 0) {
				Character c = new Character((char) i);
				map.put(c, charcount[i]);
			}
		}
		// System.out.println(map);
		return map;

	}

}
