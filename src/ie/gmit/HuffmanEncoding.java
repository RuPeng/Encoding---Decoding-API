package ie.gmit;

import java.util.HashMap;
import java.util.Map;

/**
 * Encoding and Decoding String by Huffman.
 * 
 * @version 1.0
 * @author Ru peng
 * 
 */
public class HuffmanEncoding implements Encoding {
	private Map<String, String> hufMap;

	@Override
	public String encode(String source) {
		HuffmanMap map = new HuffmanMap();
		map.getMap(source);

		HuffmanTree tree = new HuffmanTree();
		tree.buildTree(map.getMap(source));
		HuffmanCode code = new HuffmanCode();

		String s = "";
		Map<String, String> m = new HashMap<String, String>();
		code.getCode(tree.buildTree(map.getMap(source)).getRoot(), s, m);
		return m + getHfmEncoding(m, source);
	}

	/**
	 * Encoding the source string according to the map.
	 * 
	 * @param m
	 * @param source
	 * @return The Encoded string
	 */
	public String getHfmEncoding(Map<String, String> m, String source) {
		String output = "";
		for (int i = 0; i < source.length(); i++) {
			output += m.get(String.valueOf(source.charAt(i)));
		}
		return output;
	}

	@Override
	public String decode(String source) throws Exception {
		String mapstring = source.substring(0, source.lastIndexOf('}') + 1);
		String datastring = source.substring(source.lastIndexOf('}') + 1);
		if (datastring.isEmpty() || mapstring.isEmpty()) {
			throw new Exception("Source can not be decode!");
		}
		int longest = getComprInfo(mapstring);
		for (int i = 0; i < datastring.length();) {
			for (int j = i + longest; j > i; j--) {
				if (j < datastring.length()) {
					String code = datastring.substring(i, j);
					if (hufMap.containsKey(code)) {
						datastring = datastring.substring(0, i)
								+ hufMap.get(code) + datastring.substring(j);
						i++;
						break;
					}

				} else {
					String code = datastring.substring(i);
					if (hufMap.containsKey(code)) {
						datastring = datastring.substring(0, i)
								+ hufMap.get(code);
						i++;
						break;
					}

				}
			}

		}
		return datastring;
	}

	/**
	 * Get the map from the encoded string, only with the map, can we decode the
	 * string.
	 * 
	 * @param mapstring
	 * @return The map with compressed information
	 */
	public int getComprInfo(String mapstring) {
		hufMap = new HashMap<String, String>();
		int count = 0;
		int[] markpos = new int[mapstring.length() / 2];
		for (int i = 0; i < mapstring.length(); i++) {
			if (mapstring.charAt(i) == '=' && mapstring.charAt(i + 1) != '=') {
				markpos[count++] = i;
			}
		}
		int longest = 0;
		for (int i = 0; i < count; i++) {
			if (i < count - 1) {
				String value = String.valueOf(mapstring.charAt(markpos[i] - 1));
				String key = mapstring.substring(markpos[i] + 1,
						mapstring.indexOf(',', markpos[i] + 1));

				longest = key.length() > longest ? key.length() : longest;

				hufMap.put(key, value);

			} else {
				String value = String.valueOf(mapstring.charAt(markpos[i] - 1));
				String key = mapstring.substring(markpos[i] + 1,
						mapstring.indexOf('}', markpos[i] + 1));
				longest = key.length() > longest ? key.length() : longest;
				hufMap.put(key, value);
			}
		}
		return longest;

	}

}
