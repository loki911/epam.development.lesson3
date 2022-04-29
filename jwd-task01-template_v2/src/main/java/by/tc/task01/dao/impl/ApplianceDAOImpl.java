package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.ApplianceFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.ApplianceTypeEnum;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ServiceFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
        // you may add your own code here
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
                }
            } catch (DAOException ex) {
                System.out.println(String.format(
                        "Error loading appliance. Line %d: Message: %s",
                        line, ex.getMessage()));
            }
        }
        myReader.close();
    }
}


//you may add your own new classes