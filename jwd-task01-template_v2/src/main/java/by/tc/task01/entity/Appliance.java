package by.tc.task01.entity;

import by.tc.task01.dao.impl.DAOException;
import by.tc.task01.types.Range;

import java.util.HashMap;
import java.util.Map;

public abstract class Appliance {
    private final Map<String, Class> propertyTypes;

    protected Map<String, Object> propertyBag = new HashMap<>();
    protected abstract Map<String, Class> getPropertyTypesInternal();

    Appliance() {
       propertyTypes = getPropertyTypesInternal();
    }

    public abstract ApplianceTypeEnum getType();

    public void fillFromMap(Map<String, String> props) {
        for (Map.Entry<String, String> item: props.entrySet()) {
            final String propertyName = item.getKey();
            final String propertyValue = item.getValue();
            final Map<String, Class> propertyTypeMap = getPropertyTypesInternal();

            if (propertyTypeMap == null) {
                System.out.println(String.format("Skip loading %s: property type map is nof defined", getType()));
                continue;
            }
            if (!propertyTypeMap.containsKey(item.getKey())) {
                throw new DAOException
                        (String.format("Unknown property %s for %s", propertyName, getType()));
            }
            Class propertyClass = propertyTypeMap.get(propertyName);
            if (propertyClass == Integer.class) {
                propertyBag.put(propertyName, Integer.parseInt(propertyValue));
            } else if (propertyClass == Float.class) {
                propertyBag.put(propertyName, Float.parseFloat(propertyValue));
            } else if (propertyClass == String.class) {
                propertyBag.put(propertyName, propertyValue);
            } else if (propertyClass == Range.class) {
                propertyBag.put(propertyName, Range.parseRange(propertyValue));
            }
        }
    }

    public Map<String, Class> getPropertyTypes() {
        return propertyTypes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("\n");

        for (Map.Entry<String, Object> entry: propertyBag.entrySet()) {
            sb.append(String.format("- %s: %s\n", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
