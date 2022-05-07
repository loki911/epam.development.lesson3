package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.ApplianceFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.ApplianceTypeEnum;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ServiceFactory;

import java.io.InputStream;
import java.util.*;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String DB_FILE_NAME = "/appliances_db.txt";

    private final Map<ApplianceTypeEnum, List<Appliance>> appliances = new HashMap<>();
    private final ApplianceFactory applianceFactory;

    public ApplianceDAOImpl() {
        applianceFactory = ServiceFactory.getInstance().getApplianceFactory();
        readDataFile();
    }

    @Override
    public Appliance find(Criteria criteria) {
        // Assume that appliance type is correct. This should be checked in Validator
        ApplianceTypeEnum applianceType = ApplianceTypeEnum.fromApplianceName(criteria.getGroupSearchName());

        List<Appliance> applianceList = appliances.get(applianceType);
        if (applianceList == null || applianceList.isEmpty()) {
            return null;
        }

        Map<String, Object> searchCriteria = criteria.getCriteria();

        for (Appliance item: applianceList) {
            if (item.isMatched(searchCriteria)) {
                return item;
            }
        }

        // No matches found
        return null;
    }

    private void readDataFile() {

        InputStream stream = ApplianceDAOImpl.class.getResourceAsStream(DB_FILE_NAME);
        if (stream == null) {
            throw new DAOException("File with appliance data not found in resources");
        }
        Scanner myReader = new Scanner(stream);
        int line = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            line += 1;
            try {
                // Skip blank lines
                if (!data.trim().isBlank()) {
                    Appliance appliance = applianceFactory.createFromString(data);
                    storeAppliance(appliance);
                }
            } catch (DAOException ex) {
                System.out.println(String.format(
                        "Error loading appliance. Line %d: Message: %s",
                        line, ex.getMessage()));
            }
        }
        myReader.close();
    }

    private void storeAppliance(Appliance appliance) {
        if (appliance == null) {
            return;
        }

        ApplianceTypeEnum applianceType = appliance.getType();
        List<Appliance> applianceList =
                appliances.computeIfAbsent(applianceType, it -> new ArrayList<>());

        applianceList.add(appliance);
        System.out.println(appliance);
    }
}
