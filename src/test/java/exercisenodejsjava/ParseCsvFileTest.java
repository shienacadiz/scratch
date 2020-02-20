package exercisenodejsjava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class ParseCsvFileTest {

	@Test
	public void TestAndPrintValidFile() throws IOException {
		File file = new File("src/test/java/resources/data.csv");
		ParseCsvFile parseCsvFile = new ParseCsvFile(file);
		parseCsvFile.printValues();
		assertNotNull(parseCsvFile);
		assertEquals(5, parseCsvFile.getCsvRows().size());
	}
	
	@Test
	public void TestEmptyFile() throws IOException {
		File file = new File("src/test/java/resources/empty.csv");
		ParseCsvFile parseCsvFile = new ParseCsvFile(file);
		assertEquals(0, parseCsvFile.getCsvRows().size());
	}
	
	@Test
	public void TestWithInvalidDataInFile() throws IOException {
		File file = new File("src/test/java/resources/withinvaliddata.csv");
		ParseCsvFile parseCsvFile = new ParseCsvFile(file);
		assertNotNull(parseCsvFile);
		assertEquals(4, parseCsvFile.getCsvRows().size());
	}
}
