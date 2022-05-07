package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class Laptop extends Appliance{

    private static Map<String, Class> propertyTypes = new HashMap<>() {{
        put(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), Double.class);
        put(SearchCriteria.Laptop.OS.toString(), String.class);
        put(SearchCriteria.Laptop.MEMORY_ROM.toString(), Integer.class);
        put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), Integer.class);
        put(SearchCriteria.Laptop.CPU.toString(), Double.class);
        put(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), Integer.class);
    }};

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.LAPTOP;
    }

}