package by.tc.task01.entity;

import java.util.Map;

public class Oven extends Appliance{
    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.OVEN;
    }

    @Override
    public void fillFromMap(Map<String, String> props) {

    }
    // you may add your own code here
}
