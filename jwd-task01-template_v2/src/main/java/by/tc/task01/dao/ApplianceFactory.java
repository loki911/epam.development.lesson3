package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;

public interface ApplianceFactory {
    Appliance createFromString(String str);
}
