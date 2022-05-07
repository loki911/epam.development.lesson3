package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.types.Range;

import java.util.HashMap;
import java.util.Map;

public class Speakers extends Appliance{

    private static Map<String, Class> propertyTypes = new HashMap<>() {{
        put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), Integer.class);
        put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), Integer.class);
        put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), Range.class);
        put(SearchCriteria.Speakers.CORD_LENGTH.toString(), Integer.class);

    }};

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.SPEAKERS;
    }

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }
}