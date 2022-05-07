package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class VacuumCleaner extends Appliance {

    // Anonymous map creation
    // https://www.javavogue.com/2015/06/how-to-create-hashmap-in-java.html/#anonymous_subclass_hashmap
    private static Map<String, Class> propertyTypes = new HashMap<>() {{
        put(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), String.class);
        put(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), Integer.class);
        put(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), String.class);
        put(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), Integer.class);
        put(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), Integer.class);
        put(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), String.class);
    }};

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return propertyTypes;
    }

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.VACUUMCLEANER;
    }

}