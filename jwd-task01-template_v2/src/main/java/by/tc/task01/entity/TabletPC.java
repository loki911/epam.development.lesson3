package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class TabletPC extends Appliance{

    private static Map<String, Class> propertyTypes = new HashMap<>() {{
        put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), Integer.class);
        put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), Integer.class);
        put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), Integer.class);
        put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), Integer.class);
        put(SearchCriteria.TabletPC.COLOR.toString(), String.class);
    }};

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.TABLETPC;
    }


}