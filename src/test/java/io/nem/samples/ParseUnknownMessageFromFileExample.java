package io.nem.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;


/**
 * This example shows how to read a SWIFT MT message from a file, in the context where
 * the message type to parse is unknown and also it can be a system message.
 * This example uses the generic parser instead of the AbstractMT class.
 * 
 * 
 * @since 7.7
 */
public class ParseUnknownMessageFromFileExample {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * Read the file and create an instance of the generic parser for it
		 */
		File file = new File("src/system.txt");
		SwiftParser parser = new SwiftParser(new FileInputStream(file));		
		SwiftMessage msg = parser.message();

		if (msg.isServiceMessage()) {
			System.out.println("System Message");
			/*
			 * deal with system message
			 */
			Tag t = msg.getBlock4().getTagByName("177");
			if (t != null) {
				System.out.println(t.getValue());
			}
			
		} else {
			/*
			 * specialize message as necessary depending on message type
			 */
			if (msg.isType(103)) {
				/*
				 * Specialize the message to its specific model representation
				 */
				MT103 mt = new MT103(msg);
				
				/*
				 * Print details of a specific field
				 */
				System.out.println("Reference: "+mt.getField20().getValue());
			}
		}
	}
}
