package exercisenodejsjava;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//- defining feature toggles
//- enable/disable
//- getting the enable/disable state of a feature toggle
//- deleting a feature toggle --> **this feature can be refactored on the later part. For tracking/record purposes,
//we don't totally delete a certain data in the system. We can add another attribute to determine if the feature is deleted already.

public class FeatureToggle {
	//There is actually 2 ways:
	//1. ArrayList but the cons here is we have to traverse the whole List every time we
	//   try to access a certain feature via code. This also doesn't have any ability to check maintain unique records
	//   so we also have to consider those
	//2. Use Map as our collection of feature toggle. The only cons here is that the feature code is somehow exposed outside the
	//   Feature object since we will be using the code attribute as a key for the Map. The cons here is we do not have to traverse
	//   the whole map because we can simply get the code as a key. Map also ensures unique values as key should be unique
	private Map<String, Feature> featureMap = new HashMap<String, Feature>();
	
	//this method initialises the featureMap list from a certain source (let's say from a database or text file)
	//this should be called first before anything else
	public void init() {
		Feature feature1 = new Feature();
		feature1.setCode("add");
		feature1.setName("Add Functionality");
		feature1.setEnabled(true);
		feature1.setDateChanged(Calendar.getInstance().getTime());
		feature1.setDeleted(false);
		featureMap.put(feature1.getCode(), feature1);
		
		Feature feature2 = new Feature();
		feature2.setCode("edit");
		feature2.setName("Edit Functionality");
		feature2.setEnabled(true);
		feature2.setDateChanged(Calendar.getInstance().getTime());
		feature2.setDeleted(false);
		featureMap.put(feature2.getCode(), feature2);
	}

	//to add or define the feature in the map. the expectation is to utilise the previously created 
	//Feature class and define its attributes already such as code, name, initial state and etc
	public void addFeature(Feature feature) {
		if(!featureMap.containsKey(feature.getCode())) {
			featureMap.put(feature.getCode(), feature);
		} else {
			//error handling: the feature you are trying to add exist already in the record
		}
	}
	
	//gets the instance of feature from the collection
	public Feature getFeature(String code) {
		return featureMap.get(code);
	}
	
	//toggles the feature if enabled or disabled
	public void setEnabled(String code, boolean isEnabled) {
		if(featureMap.containsKey(code)) {
			Feature feature = featureMap.get(code);
			feature.setEnabled(isEnabled);
			feature.setDateChanged(Calendar.getInstance().getTime());
		} else {
			//error handling: the feature you are trying to modify doesn't exist
		}
	}
	
	//getting the enable/disable state of a feature
	public boolean isFeatureEnabled(String code) {
		if(!featureMap.containsKey(code)) {
			//error handling: feature doesn't exist
		}
		return featureMap.get(code).isEnabled();	
	}
	
	//to delete a certain feature toggle. This actually don't delete the feature from the record
	//but only set is as inactive
	public void deleteFeature(String code) {
		if(featureMap.containsKey(code)) {
			featureMap.get(code).setDeleted(true);
			featureMap.get(code).setDateDeleted(Calendar.getInstance().getTime());
		} else {
			//error handling: the feature you are trying to delete doesn't exist in the record
		}
	}
	
	//get the full list of featureMap available
	public Map<String, Feature> getFeatureMap() {
		return featureMap;
	}
}
