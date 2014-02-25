The main features of my application:
1. This API provides three Encoding&Decoding algorithms: Huffman, Runlength and Base64.
2. Each algorithm can be parsed a string, a file or an URL.



The instructions for running the programme (by using the Runner.java in G00307401.zip):
1. Use ant build the source file.
2. Set classpath and run.
   Executing the following command from a console:
   (1)SET CLASSPATH=.;encoding/encoder.jar 
   (2)javac Runner.java
   (3)java Runner



The instructions for running the programme (by using the source code):
1. New a java project in Eclipse, new a package named ie.gmit, import the *.java file from src/ie/gmit.
2. Create a Runner class, so you can test the project.
   (1) If you want to encode a string, for example, by using Huffman:

                // Encoding hufEn = new HuffmanEncoding();
		// try {
		// 	   System.out.println(hufEn.encode("Hello"));
		// } catch (Exception e1) {
		//	   e1.printStackTrace();
		// }

       Then the encode result is:{e=001, o=01, l=1, H=000}0000011101, the content in {} is HuffmanMap which is for decoding

		// try {
		//	   System.out.println(hufEn.decode("{e=001, o=01, l=1, H=000}0000011101"));
		// } catch (Exception e1) {
		//	   e1.printStackTrace();
		// }

       Then the decode result is: Hello
    
   (2) If you want to encode a file, for example, by using Base64:

                /* First I have a file which called original.txt in local disk D: 
                 * Then I save the encoded string to a file which named Base64Encoded.txt 
		 * We can see that the result of decoding Base64Encoded.txt is the same to original.txt
		 */	
		
		// PathEncoding filePE = new FileEncoding(new Base64Encoding());
		// try {
		// System.out.println(filePE.encode("d:/original.txt"));
		// System.out.println(filePE.decode("d:/Base64Encoded.txt"));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
        Then the encode result is: YWFhYmJjY2NjY2VlZWVlZWYxMTExMTEyMjIyMjIyMjIyMzMzNDQ0NDQ/Pz8=
        Then the decode result is: aaabbccccceeeeeef111111222222222233344444???

   (3) If you want to encode a URL, for example, by using Runlenth:

                // PathEncoding urlPE = new URLEncoding(new RunlengthEncoding());
		// try {
		// System.out.println(urlPE.encode("http://www.google.ie"));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

        Then the encode result is something like that: @<1@!1@d1@o1@c1@t1@y1@p1@e1@ 1@h1@t1@m1@l1@>1@<1@h1@t1@m1@l1@ 1@i1@t1@e1@m1@s1@c1@o1@p1@e1@=1@"2@ 1......
	