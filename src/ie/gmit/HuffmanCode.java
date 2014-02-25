package ie.gmit;

import java.util.Map;

/**
 * Make the character related a code.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */

public class HuffmanCode {
	/**
	 * Giving the related HuffmanCode to each character.
	 * 
	 * @param node
	 * @param s
	 * @param m
	 *            Input character and code pairs
	 */
	public void getCode(HuffmanNode node, String s, Map<String, String> m) {

		if (node.getLeftNode() == null && node.getRightNode() == null) {
			m.put(node.getChars(), s);
		} else {
			if (node.getLeftNode() != null) {
				s += "1";
				getCode(node.getLeftNode(), s, m);
				s = s.substring(0, s.length() - 1);

			}
			if (node.getRightNode() != null) {
				s += "0";
				getCode(node.getRightNode(), s, m);
				s = s.substring(0, s.length() - 1);

			}
		}

	}

}
