package by.tc.task01.types;

import by.tc.task01.dao.impl.DAOException;

public class Range {
    private float minValue;
    private float maxValue;

    Range(float minValue, float maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Range parseRange(String value) {
        String[] values = value.split("-");
        if (values.length < 2) {
            throw new DAOException("Invalid range, must be two values separated by dash");
        }
        float[] result = new float[] {Float.parseFloat(values[0]), Float.parseFloat(values[1])};

        return new Range(result[0], result[1]);
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }
}
