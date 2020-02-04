package exercisenodejsjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvRow {
	private Map rowAsMap = new HashMap<Object, Object>();
	private static final char QUOTE = '"';
	
	public CsvRow(List<String> columnNames, List<String> values) {
		if(columnNames.size() != values.size()) {
			return; //column count doesn't match
		}
		for(int x=0 ; x<columnNames.size() ; x++) {
			String value = values.get(x);
			if(QUOTE == value.charAt(0) && QUOTE == value.charAt(value.length()-1)){
				rowAsMap.put(columnNames.get(x), value.substring(1, value.length()-1));
			} else {
				Integer valueAsInt;
				try {
					valueAsInt = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					//not a number nor a valid string
					continue; //proceed to next field
				}
				rowAsMap.put(columnNames.get(x), valueAsInt);
			}		
		}
	}
	
	public Map getRowAsMap() {
		return rowAsMap;
	}
}
