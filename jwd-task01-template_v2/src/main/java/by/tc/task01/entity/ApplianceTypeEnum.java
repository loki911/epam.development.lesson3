package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public enum ApplianceTypeEnum {
    OVEN,
    LAPTOP,
    REFRIGERATOR,
    VACUUMCLEANER,
    TABLETPC,
    SPEAKERS;

    public static ApplianceTypeEnum fromApplianceName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Appliance name must be defined");
        }

        switch (name) {
            case "Oven":
                return OVEN;

            case "TabletPC":
                return TABLETPC;

            case "Laptop":
                return LAPTOP;

            case "Refrigerator":
                return REFRIGERATOR;

            case "VacuumCleaner":
                return VACUUMCLEANER;

            case "Speakers":
                return SPEAKERS;

            default:
                throw new IllegalArgumentException("Unsupported appliance name: " + name);
        }
    }

    public String toApplianceClass() {
        Class applianceClass;

        switch (this) {
            case OVEN:
                applianceClass = SearchCriteria.Oven.class;
                break;
            case LAPTOP:
                applianceClass = SearchCriteria.Laptop.class;
                break;
            case REFRIGERATOR:
                applianceClass = SearchCriteria.Refrigerator.class;
                break;
            case VACUUMCLEANER:
                applianceClass = SearchCriteria.VacuumCleaner.class;
                break;
            case TABLETPC:
                applianceClass = SearchCriteria.TabletPC.class;
                break;
            case SPEAKERS:
                applianceClass = SearchCriteria.Speakers.class;
                break;
            default:
                throw new IllegalArgumentException("Unknown appliance type");
        }
        return applianceClass.getSimpleName();
    }
}
