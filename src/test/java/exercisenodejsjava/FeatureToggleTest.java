package exercisenodejsjava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class FeatureToggleTest {
	private FeatureToggle featureToggle;
	
	@Before
	public void setUp() {
		featureToggle = new FeatureToggle();
		featureToggle.init();
	}
	
	@Test
	public void testInstance() {
		assertEquals(2, featureToggle.getFeatureMap().size());
	}
	
	@Test
	public void testAddValidFeature() {
		Feature feature = new Feature();
		feature.setCode("delete");
		feature.setName("Delete Functionality");
		feature.setEnabled(true);
		feature.setDateChanged(Calendar.getInstance().getTime());
		feature.setDeleted(false);
		featureToggle.addFeature(feature);
		
		assertNotNull(featureToggle.getFeature("delete").getName());
		assertEquals(3, featureToggle.getFeatureMap().size());
	}

	@Test
	public void testDuplicateFeature() {
		Feature feature = new Feature();
		feature.setCode("edit");
		feature.setName("Edit Functionality");
		feature.setEnabled(true);
		feature.setDateChanged(Calendar.getInstance().getTime());
		feature.setDeleted(false);
		featureToggle.addFeature(feature);
		
		assertEquals(2, featureToggle.getFeatureMap().size());
	}
	
	@Test
	public void testSetEnabledWhenCodeExist() throws InterruptedException {
		String code = "edit";
		Date date = featureToggle.getFeature(code).getDateChanged();
		
		assertTrue(featureToggle.getFeature(code).isEnabled());
		
		Thread.sleep(1);
		featureToggle.setEnabled(code, false);
		
		assertFalse(featureToggle.getFeature(code).isEnabled());
		assertNotEquals(date, featureToggle.getFeature(code).getDateChanged());
	}
	
	@Test
	public void testSetEnabledWhenCodeDoesNotExist() {
		String code = "xxxx";
		featureToggle.setEnabled(code, false);
		assertNull(featureToggle.getFeature(code));
	}
	
	@Test
	public void testIsFeatureEnabled() {
		String code = "add";
		featureToggle.setEnabled(code, false);
		assertFalse(featureToggle.isFeatureEnabled(code));
	}
	
	@Test
	public void testDeleteWhenFeatureExists() {
		String code = "add";
		
		assertFalse(featureToggle.getFeature(code).isDeleted());
		assertNull(featureToggle.getFeature(code).getDateDeleted());
		
		featureToggle.deleteFeature(code);
		
		assertEquals(2, featureToggle.getFeatureMap().size());
		assertTrue(featureToggle.getFeature(code).isDeleted());
		assertNotNull(featureToggle.getFeature(code).getDateDeleted());
	}
	

	@Test
	public void testDeleteWhenFeatureDoesNotExists() {
		String code = "xxx";
		featureToggle.deleteFeature(code);
		assertEquals(2, featureToggle.getFeatureMap().size());
		assertNull(featureToggle.getFeature(code));
	}
}
