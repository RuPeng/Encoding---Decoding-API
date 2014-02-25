package ie.gmit.test;

import ie.gmit.Base64Encoding;
import ie.gmit.Encoding;
import ie.gmit.HuffmanEncoding;
import ie.gmit.RunlengthEncoding;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DecodeTest {
	private Encoding eng;

	@Before
	public void createEncoding() {
		eng = new HuffmanEncoding();
	}

	@After
	public void destroyEncoding() {
		eng = null;
	}

	@Test(expected = Exception.class)
	public void decodeErrorHuffman() throws Exception {
		eng.decode("aaaaaa");
	}

	@Test(expected = Exception.class)
	public void decodeErrorRunlength() throws Exception {
		eng = new RunlengthEncoding();
		eng.decode("aaaaaa");
	}

	@Test(expected = Exception.class)
	public void decodeErrorBase64() throws Exception {
		eng = new Base64Encoding();
		eng.decode("???????????~~~~~~~~~~~~~");
	}
}
