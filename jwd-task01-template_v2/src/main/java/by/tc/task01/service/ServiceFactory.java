package by.tc.task01.service;

import by.tc.task01.dao.ApplianceFactory;
import by.tc.task01.dao.impl.ApplianceFactoryImpl;
import by.tc.task01.service.impl.ApplianceServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();
    private final ApplianceFactory applianceFactory = new ApplianceFactoryImpl();

    private ServiceFactory() {
    }

    public ApplianceService getApplianceService() {
        return applianceService;
    }

    public ApplianceFactory getApplianceFactory() {
        return applianceFactory;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
