package by.tc.task01.entity;

import java.util.Map;

public class VacuumCleaner extends Appliance{
    @Override
    public ApplianceTypeEnum getType() {
        return ApplianceTypeEnum.VACUUMCLEANER;
    }

    @Override
    public void fillFromMap(Map<String, String> props) {

    }
    // you may add your own code here
}
