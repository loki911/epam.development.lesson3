package by.tc.task01.entity;

import java.util.Map;

public class Speakers extends Appliance{
    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.SPEAKERS;
    }

    @Override
    public void fillFromMap(Map<String, String> props) {

    }

    // you may add your own code here
}
