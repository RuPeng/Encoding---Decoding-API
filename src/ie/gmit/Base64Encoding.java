package ie.gmit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Encoding and Decoding string by using Base64.
 * 
 * @version 1.0
 * @author Ru Peng
 * 
 */
public class Base64Encoding implements Encoding {

	@Override
	public String encode(String source) {
		byte[] bytes = source.getBytes();
		byte[] encoded = encode(bytes);
		try {
			return new String(encoded, "ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
	}

	/**
	 * Encoding a binary sequence. The source string should turned to bytes
	 * first while encoding.
	 * 
	 * @param bytes
	 * @return The encoded sequence
	 * @throws RuntimeException
	 */
	public static byte[] encode(byte[] bytes) throws RuntimeException {
		return encode(bytes, 0);
	}

	/**
	 * Encoding a binary sequence, wrapping every encoded line and every
	 * <em>wrapAt</em> characters.
	 * 
	 * @param bytes
	 *            The source sequence
	 * @param wrapAt
	 *            The max line length for encoded data. If less than 1 no wrap
	 *            is applied
	 * @return The encoded sequence
	 * @throws RuntimeException
	 */

	public static byte[] encode(byte[] bytes, int wrapAt)
			throws RuntimeException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			encode(inputStream, outputStream, wrapAt);
		} catch (IOException e) {
			throw new RuntimeException("Unexpected I/O error", e);
		} finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
			try {
				outputStream.close();
			} catch (Throwable t) {
				;
			}
		}
		return outputStream.toByteArray();
	}

	/**
	 * Encoding data from the given input stream and writes them in the given
	 * output stream.
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 */

	public static void encode(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		encode(inputStream, outputStream, 0);
	}

	/**
	 * Encoding data from the given input stream and writes them in the given
	 * output stream, wrapping every encoded line every <em>wrapAt</em>
	 * characters.
	 * 
	 * @param inputStream
	 *            The input stream from which clear data are read
	 * @param outputStream
	 *            The output stream in which encoded data are written
	 * @param wrapAt
	 *            The max line length for encoded data. If less than 1 no wrap
	 *            is applied
	 * @throws IOException
	 */

	public static void encode(InputStream inputStream,
			OutputStream outputStream, int wrapAt) throws IOException {
		Base64OutputStream aux = new Base64OutputStream(outputStream, wrapAt);
		copy(inputStream, aux);
		aux.commit();
	}

	/**
	 * Coping data from a stream to another.
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 */

	public static void copy(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// 1KB buffer
		byte[] b = new byte[1024];
		int len;
		while ((len = inputStream.read(b)) != -1) {
			outputStream.write(b, 0, len);
		}
	}

	@Override
	public String decode(String source) {

		byte[] bytes;
		try {
			bytes = source.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
		byte[] decoded = decode(bytes);
		return new String(decoded);
	}

	/**
	 * Decoding a binary sequence.
	 * 
	 * @param bytes
	 *            The encoded sequence
	 * @return The decoded sequence
	 * @throws RuntimeException
	 */
	public static byte[] decode(byte[] bytes) throws RuntimeException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			decode(inputStream, outputStream);
		} catch (IOException e) {
			throw new RuntimeException("Unexpected I/O error", e);
		} finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
			try {
				outputStream.close();
			} catch (Throwable t) {
				;
			}
		}
		return outputStream.toByteArray();
	}

	/**
	 * Decoding data from the given input stream and writes them in the given
	 * output stream.
	 * 
	 * @param inputStream
	 *            The input stream from which encoded data are read
	 * @param outputStream
	 *            The output stream in which decoded data are written
	 * @throws IOException
	 */
	public static void decode(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		copy(new Base64InputStream(inputStream), outputStream);
	}

}
