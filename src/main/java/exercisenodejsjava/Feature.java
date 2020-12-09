package exercisenodejsjava;

import java.util.Date;

//Feature
//- code - feature code - serves as an unique identifier of the feature. We can use this as a key for the Map
//- name - Feature name/description - a detailed title for the feature
//- isEnabled - this is the state to determine if the feature is enabled or disabled
//- dateChanged - this changes everytime the feature is toggled/isEnabled is changed
//- *isDeleted - determines if the feature is already deleted by the user
//- *dateDeleted - timestamp when the feature is deleted
//other optional attributes:
//- lastModifiedBy - the user who modifies the feature toggle
//- dateCreated - the date when the feature toggle is added

public class Feature {
	private String code;
	private String name;
	private boolean isEnabled;
	private Date dateChanged;
	private boolean isDeleted;
	private Date dateDeleted;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Date getDateChanged() {
		return dateChanged;
	}
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getDateDeleted() {
		return dateDeleted;
	}
	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}
}