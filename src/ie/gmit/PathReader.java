/**
 * 
 */
package ie.gmit;

/**
 * Changing the content in the path to string.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public abstract class PathReader {
	/**
	 * Changing the content which related to the path to string.
	 * 
	 * @param path
	 * @return The string which is going to be encoded or decoded
	 * @throws Exception
	 */
	public abstract String readPath(String path) throws Exception;
}
