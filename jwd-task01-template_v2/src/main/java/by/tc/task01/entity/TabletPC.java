package by.tc.task01.entity;

import java.util.Map;

public class TabletPC extends Appliance{
    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.TABLETPC;
    }

    @Override
    public void fillFromMap(Map<String, String> props) {

    }
    // you may add your own code here
}
