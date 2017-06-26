
package io.nem.samples;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.prowidesoftware.swift.io.PPCReader;
import com.prowidesoftware.swift.model.field.Field32A;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;

/**
 * This example shows how to read a SWIFT MT message from an DOS-PPC file.
 * The example file used contains two MT103 messages.
 * <br />
 * The PPC reader is scheduled for release in version 7.8 
 * In the meantime it is available on source code, or upon request.
 * 
 * 
 * @since 7.8
 */
public class ReadDOSPCCFileExample {

	public static void main(String[] args) throws IOException {
		/*
		 * Read and parse the file content into a SWIFT message object
		 */
		PPCReader reader = new PPCReader(new File("src/mt103.dos"));
		
		/*
		 * Iterate the reader
		 */
		while (reader.hasNext()) {
			/*
			 * Read the message. 
			 */
			//System.out.println(reader.next());
			AbstractMT msg = reader.nextMT();
			
			if (msg.isType(103)) {
				
				/*
				 * Specialize the message 
				 */
				MT103 mt = (MT103) msg;
				
				/*
				 * Print some content from message
				 * 
				 * Expected output:
				 * Sender: BBBBBBBBAXXX
				 * Receiver: AAAAAAAAXXX7
				 * Reference: DET 12/13/3724
				 * Value Date: 2013/10/18
				 * Amount: EUR 12591,01
				 * --------------------------
				 * Sender: BBBBBBBBAXXX
				 * Receiver: AAAAAAAAXXX7
				 * Reference: DET 12/13/3754
				 * Value Date: 2013/10/18
				 * Amount: EUR 1800,00
				 * --------------------------
				 */
				System.out.println("Sender: "+mt.getSender());
				System.out.println("Receiver: "+mt.getReceiver());
				System.out.println("Reference: "+mt.getField20().getValue());
				
				Field32A f = mt.getField32A();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				System.out.println("Value Date: "+sdf.format(f.getDateAsCalendar().getTime()));
				System.out.println("Amount: "+f.getCurrency()+" "+f.getAmount());
				System.out.println("--------------------------");
			}
		}
	}
}
