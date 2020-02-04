package exercisenodejsjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseCsvFile {
	private List<CsvRow> csvRows = new ArrayList<CsvRow>();
	private static final String DELIMITER = ";";
	
	public ParseCsvFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<String> columnNames = new ArrayList<String>();
		String row;
		if((row = br.readLine()) != null){
			columnNames = splitLine(row);
		} else {
			br.close();
			return;
			//empty file
		}
		while((row = br.readLine()) != null) {
			List<String> values = splitLine(row);
			CsvRow csvRow = new CsvRow(columnNames, values);
			if(!csvRow.getRowAsMap().isEmpty()) {
				csvRows.add(csvRow);
			}
		}
		br.close();
	}
	
	private List<String> splitLine(String line){
		List<String> strList = new ArrayList<String>();
		String[] split = line.split(DELIMITER);
		for(String s : split) {
			strList.add(s);
		}
		
		return strList;
	}
	
	public void printValues() {
		for(CsvRow row : csvRows) {
			Map csvRowAsMap = row.getRowAsMap();
			System.out.println(csvRowAsMap.keySet().toString());
			System.out.println(csvRowAsMap.values().toString());			
		}
	}
	
	public List<CsvRow> getCsvRows() {
		return csvRows;
	}
}
