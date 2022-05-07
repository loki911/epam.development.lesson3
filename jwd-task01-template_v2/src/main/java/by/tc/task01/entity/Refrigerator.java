package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class Refrigerator extends Appliance {

    private static Map<String, Class> propertyTypes = new HashMap<>() {{
        put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), Integer.class);
        put(SearchCriteria.Refrigerator.WEIGHT.toString(), Integer.class);
        put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), Integer.class);
        put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), Double.class);
        put(SearchCriteria.Refrigerator.HEIGHT.toString(), Integer.class);
        put(SearchCriteria.Refrigerator.WIDTH.toString(), Integer.class);
    }};

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.REFRIGERATOR;
    }
}
