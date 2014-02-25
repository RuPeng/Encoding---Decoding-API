/**
 * 
 */
package ie.gmit;

/**
 * Encoding the source string by getting a related path,such as file path, url.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public abstract class PathEncoding implements Encoding {
	private Encoding en;
	private PathReader pr;

	public PathEncoding(Encoding en) {
		this.en = en;
	}

	/**
	 * @param pr
	 *            Set the pr, decide which to choose, file or url
	 */
	public void setPr(PathReader pr) {
		this.pr = pr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.gmit.cloud.Encoding#encode(java.lang.String)
	 */
	@Override
	public String encode(String source) throws Exception {
		return en.encode(pr.readPath(source));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ie.gmit.cloud.Encoding#decode(java.lang.String)
	 */
	@Override
	public String decode(String source) throws Exception {
		return en.decode(pr.readPath(source));
	}

}
