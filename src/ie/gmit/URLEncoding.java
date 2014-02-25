package ie.gmit;

/**
 * Encoding url by choosing an algorithm.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class URLEncoding extends PathEncoding {
	/**
	 * Using encoding algorithm to encode a URL
	 * 
	 * @param en
	 *            Which algorithm do you want to encode the URL?
	 *            HuffmanEncoding,RunlenthEncoding or Base64Encoding
	 */
	public URLEncoding(Encoding en) {
		super(en);
		this.setPr(new URLReader());
	}

}
