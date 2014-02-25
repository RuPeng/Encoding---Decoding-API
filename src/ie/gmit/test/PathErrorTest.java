package ie.gmit.test;

import ie.gmit.FileReader;
import ie.gmit.PathException;
import ie.gmit.PathReader;
import ie.gmit.URLReader;

import org.junit.After;
import org.junit.Test;

public class PathErrorTest {
	private PathReader pr = null;

	@After
	public void destroyReader() {
		pr = null;
	}

	@Test(expected = PathException.class)
	public void filePathError() throws Exception {
		pr = new FileReader();
		pr.readPath("this is not a file path");

	}

	@Test(expected = PathException.class)
	public void URLPathError() throws Exception {
		pr = new URLReader();
		pr.readPath("wrong URL");

	}

}
