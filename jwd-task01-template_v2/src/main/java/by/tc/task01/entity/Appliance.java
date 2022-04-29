package by.tc.task01.entity;

import java.util.Map;

public abstract class Appliance {
    public abstract ApplianceTypeEnum getType();
    public abstract void fillFromMap(Map<String, String> props);
}
