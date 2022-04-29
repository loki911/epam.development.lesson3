package by.tc.task01.entity;

import java.util.Map;

public class Laptop extends Appliance{

    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.LAPTOP;
    }

    @Override
    public void fillFromMap(Map<String, String> props) {

    }

    // you may add your own code here
}
