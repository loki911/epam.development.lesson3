package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class Oven extends Appliance {

    private static Map<String, Class> propertyTypes = new HashMap<>() {{
        put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), Integer.class);
        put(SearchCriteria.Oven.WEIGHT.toString(), Integer.class);
        put(SearchCriteria.Oven.CAPACITY.toString(), Integer.class);
        put(SearchCriteria.Oven.DEPTH.toString(), Integer.class);
        put(SearchCriteria.Oven.HEIGHT.toString(), Double.class);
        put(SearchCriteria.Oven.WIDTH.toString(), Double.class);
    }};

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.OVEN;
    }
}