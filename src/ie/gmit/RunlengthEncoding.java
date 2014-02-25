package ie.gmit;

/**
 * Encoding and Decoding string by using Runlength.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class RunlengthEncoding implements Encoding {

	@Override
	public String encode(String source) {

		char mark = '@';
		StringBuffer dest = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			int runLength = 1;
			while (i + 1 < source.length()
					&& source.charAt(i) == source.charAt(i + 1)) {
				runLength++;
				i++;
			}
			dest.append(mark);
			dest.append(source.charAt(i));
			dest.append(runLength);

		}
		// System.out.println(dest);
		return dest.toString();
	}

	@Override
	public String decode(String source) {
		int count = 0;
		int[] pos = new int[source.length()];
		for (int i = 0; i < source.length(); i++) {
			if (i == 0) {
				pos[count++] = i + 1;
			} else {
				if (source.charAt(i) == '@' && source.charAt(i - 1) != '@')
					pos[count++] = i + 1;
			}
		}
		String output = "";
		for (int i = 0; i < count; i++) {
			if (i < count - 1) {
				for (int j = 0; j < Integer.parseInt(source.substring(
						pos[i] + 1, pos[i + 1] - 1)); j++) {
					output += String.valueOf(source.charAt(pos[i]));
				}
			} else {
				for (int j = 0; j < Integer.parseInt(source
						.substring(pos[i] + 1)); j++) {
					output += String.valueOf(source.charAt(pos[i]));
				}
			}
		}
		// System.out.println(output);
		return output;
	}

}
