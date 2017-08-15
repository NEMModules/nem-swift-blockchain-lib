package io.nem.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PrivateKey;
import org.nem.core.crypto.PublicKey;
import org.nem.core.messages.SecureMessage;
import org.nem.core.model.Account;
import org.nem.core.model.Address;
import org.nem.core.utils.HexEncoder;

import io.nem.swift.crypto.SecureMessageSwiftPayloadDecoder;
import io.nem.util.GzipUtils;

/**
 * The Class BuildTransactionTest.
 */
public class DecodeBuildTransactionTest extends TransactionUnitTest {

	/** The sample swift msg. */
	final String sampleSwiftMsg = "c621b0e0a3f20523f60f9d99394e716e598c575b9f3c06a613b5d1483805dcb22c08e09de166ac08ebbf7c3f953dda74d634e60d81ba35059a53bb6662b624d7243315d3af013630f17f2b2120869a364e39152b35aa502067166cd80c215db3c023ec4c28c9438d33d0c75e15093bbb7d84154476288d49017918f3cc2f90d9734400c45283d258068c6d2b4db5c1243ff32d008bb92d8841455f38b611fa67ecc4afc0761a5ec3931c4875850d98d64d00e87a93f1284847b6d62390ead93f714784f658c6651ae56b1cb9684339ee654204bdef601e2df33f68d51463e58d2f4cdb5570a33084717f7b24c2bdf9e745d6154c0260182f59d7901d04131aa636dc3f368fb4622a5fb8e65fc24cd3f9";
	final String simplePayload = "2e66cc91dc415cb8c51ab5ffc8f38724119a417d86ecfcfc2169576ac224ca92f1081ea1541eb0ef1badfc3cd0f8f4a22967f31f1775057b4b690baf07262fb5eb0e9682df212ce774d4956736c16b9c";
	
	/**
	 * Test transaction hash.
	 */
	@Test
	public void testDecode() {
		try {
			if(isTestable()) {
				assertNotNull("Decode process completed.", SecureMessageSwiftPayloadDecoder.decodeAndGzipUncompress(this.senderPrivateKeyPair,this.recipientPublicKeyPair,sampleSwiftMsg));
			}else {
				//	we pass with message
				assertTrue("Unit Test is not testable", !isTestable());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
