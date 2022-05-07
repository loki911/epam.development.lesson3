package by.tc.task01.service.validation;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Validator {

	// Add dummy appliances as values to get access to property types map
	private static Map<String, Appliance> groupNameToPropsMap = new HashMap<>() {{
		put("Laptop", new Laptop());
		put("Oven", new Oven());
		put("Refrigerator", new Refrigerator());
		put("Speakers", new Speakers());
		put("TabletPC", new TabletPC());
		put("VacuumCleaner", new VacuumCleaner());
	}};

	public static boolean criteriaValidator(Criteria criteria) {
		if (criteria == null) {
			throw new ValidationException("Search criteria must not be null");
		}
		if (criteria.getGroupSearchName() == null || criteria.getGroupSearchName().isBlank()) {
			throw new ValidationException("Search group name must not be null");
		}
		Map<String, Object> criteriaMap = criteria.getCriteria();
		if (criteriaMap == null || criteriaMap.isEmpty()) {
			throw new ValidationException("At least one property must be defined for search criteria");
		}

		// Validate criteria group name
		if (!groupNameToPropsMap.containsKey(criteria.getGroupSearchName())) {
			throw new ValidationException(
				String.format("Invalid criteria group name: %s", criteria.getGroupSearchName()));
		}

		Appliance appliance = groupNameToPropsMap.get(criteria.getGroupSearchName());

		// Keys in this map are valid appliance property names
		Map<String, Class> propertyTypes = appliance.getPropertyTypes();
		Set<String> validPropertyNames = propertyTypes.keySet();

		// Make sure all properties in criteria exists for this type of appliance
		for (String propertyName: criteria.getCriteriaProperties()) {
			if (!validPropertyNames.contains(propertyName)) {
				throw new ValidationException(
						String.format("Search criteria property %s does not exist in appliance %s",
								propertyName, criteria.getGroupSearchName()));
			}
		}
		
		return true;
	}

}
