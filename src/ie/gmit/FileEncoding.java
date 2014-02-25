package ie.gmit;

/**
 * Encoding file by choosing an algorithm.
 * 
 * @version i.0
 * @author Ru Peng
 * 
 */
public class FileEncoding extends PathEncoding {
	/**
	 * Using encoding algorithm to encode a file.
	 * 
	 * @param en
	 *            Which algorithm do you want to encode the file?
	 *            HuffmanEncoding,RunlenthEncoding or Base64Encoding
	 */
	public FileEncoding(Encoding en) {
		super(en);
		this.setPr(new FileReader());
	}

}
