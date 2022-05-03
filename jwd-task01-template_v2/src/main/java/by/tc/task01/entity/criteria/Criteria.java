package by.tc.task01.entity.criteria;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

    private final String groupSearchName;
    private final Map<String, Object> criteria = new HashMap<>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Set<String> getCriteriaProperties() {
        return Collections.unmodifiableSet(criteria.keySet());
    }

}
