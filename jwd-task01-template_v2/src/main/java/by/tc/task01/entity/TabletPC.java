package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class TabletPC extends Appliance{

    @Override
    protected Map<String, Class> getPropertyTypesInternal() {
        return null;
    }

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.TABLETPC;
    }


}