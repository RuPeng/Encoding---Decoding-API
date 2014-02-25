package ie.gmit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Make the file content to string.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class FileReader extends PathReader {

	@Override
	public String readPath(String filePath) throws Exception {
		String str = "";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			InputStreamReader isR = new InputStreamReader(fis);
			BufferedReader bfR = new BufferedReader(isR);

			String temp;
			while ((temp = bfR.readLine()) != null) {
				str += temp;
			}
			fis.close();
			isR.close();
			bfR.close();
		} catch (Exception e) {
			throw new PathException("File read fail!", e);
		}
		return str;
	}
}
