package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class Speakers extends Appliance{

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.SPEAKERS;
    }

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }
}