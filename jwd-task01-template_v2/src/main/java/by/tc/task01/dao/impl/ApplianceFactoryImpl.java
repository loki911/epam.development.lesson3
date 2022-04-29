package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceFactory;
import by.tc.task01.entity.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceFactoryImpl implements ApplianceFactory {

    @Override
    public Appliance createFromString(String str) {
        String[] values = str.split(":");
        if (values.length != 2) {
            throw new DAOException("Sting must contain exactly one semicolon");
        }
        ApplianceTypeEnum applianceType;
        try {
            applianceType = ApplianceTypeEnum.valueOf(values[0].trim().toUpperCase());
            System.out.println(String.format("Loading %s", applianceType));
        } catch (IllegalArgumentException ex) {
            throw new DAOException(String.format("Unknown appliance type: %s", values[0]));
        }

        Appliance appliance;
        switch (applianceType) {
            case OVEN:
               appliance = new Oven();
               break;

            case LAPTOP:
                appliance = new Laptop();
                break;

            case REFRIGERATOR:
                appliance = new Refrigerator();
                break;

            case VACUUMCLEANER:
                appliance = new VacuumCleaner();
                break;

            case TABLETPC:
                appliance = new TabletPC();
                break;

            case SPEAKERS:
                appliance = new Speakers();
                break;

            default:
                throw new DAOException(String.format("Unsupported appliance type: %s", applianceType));
        }
        Map<String, String> props = stingToKeyValueProps(values[1]);
        appliance.fillFromMap(props);

        return appliance;
    }

    private Map<String, String> stingToKeyValueProps(String value) {
        Map<String, String> result = new HashMap<>();
        String[] pairs = value.split(",");
        for (String keyValue : pairs) {
            String[] propData = keyValue.split("=");
            if (propData.length != 2) {
                throw new DAOException("Property must be defined with two strings separated by exactly one equal sign");
            }
            result.put(propData[0], propData[1]);
        }

        return result;
    }
}
