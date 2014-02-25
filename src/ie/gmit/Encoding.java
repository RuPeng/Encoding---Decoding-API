package ie.gmit;

/**
 * The interface include encode and decode methods.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public interface Encoding {
	/**
	 * Encoding a string.
	 * 
	 * @param source
	 * @return The encoded string
	 * @throws Exception
	 */
	public String encode(String source) throws Exception;

	/**
	 * Decoding a string.
	 * 
	 * @param source
	 * @return The decoded string
	 * @throws Exception
	 */
	public String decode(String source) throws Exception;

}
