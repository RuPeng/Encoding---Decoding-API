package ie.gmit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Make the url content to string.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class URLReader extends PathReader {

	@Override
	public String readPath(String url) throws Exception {
		URL oracle;
		String output = "";
		try {
			oracle = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					oracle.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null)
				output += inputLine;
			in.close();
		} catch (Exception e) {
			throw new PathException("URL read fail.", e);
		}

		return output;

	}
}
