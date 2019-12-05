import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommonFactorTest {
	@Test
	public void getCommonFactorTest() {
		assertEquals(2, CommonFactor.getCommonFactor(10, 15));
		assertEquals(4, CommonFactor.getCommonFactor(10, 20));
		assertEquals(4, CommonFactor.getCommonFactor(10, 10));
		assertEquals(2, CommonFactor.getCommonFactor(15, 10));
		assertEquals(4, CommonFactor.getCommonFactor(20, 10));
	}
}
