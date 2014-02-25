import java.util.ArrayList;
import java.util.Collection;
import ie.gmit.Base64Encoding;
import ie.gmit.Encoding;
import ie.gmit.FileEncoding;
import ie.gmit.HuffmanEncoding;
import ie.gmit.PathEncoding;
import ie.gmit.RunlengthEncoding;
import ie.gmit.URLEncoding;

public class Runner {
	public static void main(String[] args) {
		/*
		 * Example of Encoding and Decoding a String
		 */
		String example = "How are you?";
		Collection<Encoding> col = new ArrayList<Encoding>();
		col.add(new RunlengthEncoding());
		col.add(new HuffmanEncoding());
		col.add(new Base64Encoding());
		Encoding[] arr = new Encoding[col.size()];
		col.toArray(arr);
		System.out.println("This achieved the polymorphism:");
		for (int i = 0; i < arr.length; i++) {
			try {
			    System.out.print("Encode result: ");
				System.out.println(arr[i].encode(example));
				System.out.print("Decode result: ");
				System.out.println(arr[i].decode(arr[i].encode(example)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*
		 * Example of Encoding and Decoding a File by using Base64Encoding
		 * 
		 * First I have a file which called original.txt in local disk D: Then I
		 * save the encoded string to a file which named Base64Encoded.txt We
		 * can see that the result of decoding Base64Encoded.txt is the same to
		 * original.txt
		 */

		// PathEncoding filePE = new FileEncoding(new Base64Encoding());
		// try {
		// System.out.println(filePE.encode("d:/original.txt"));
		// System.out.println(filePE.decode("d:/Base64Encoded.txt"));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		/*
		 * Example of Encoding a URL by using RunlenthEncoding
		 */

		 //PathEncoding urlPE = new URLEncoding(new RunlengthEncoding());
		 //try {
		 //System.out.println(urlPE.encode("http://www.google.ie"));
		 //} catch (Exception e) {
		 //e.printStackTrace();
		 //}

	}

}
