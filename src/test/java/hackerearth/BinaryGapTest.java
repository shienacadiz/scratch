package hackerearth;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BinaryGapTest {
	
	@Test
	public void testInstance() {
		assertNotNull(new BinaryGap());
	}

	@Test
	public void testConvertToBinary() {
		assertEquals("1011", BinaryGap.convertToBinary(11));
		assertEquals("10", BinaryGap.convertToBinary(2));
		assertEquals("1111101000", BinaryGap.convertToBinary(1000));
		assertEquals("110111100", BinaryGap.convertToBinary(444));
		assertEquals("10000010001", BinaryGap.convertToBinary(1041));
	}
	
	@Test
	public void testGetBinaryGap() {
		assertEquals(1, BinaryGap.getBinaryGap("1011"));
		assertEquals(0, BinaryGap.getBinaryGap("10"));
		assertEquals(1, BinaryGap.getBinaryGap("1111101000"));
		assertEquals(1, BinaryGap.getBinaryGap("110111100"));
		assertEquals(5, BinaryGap.getBinaryGap("10000010001"));
	}
}
