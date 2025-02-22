package entities;
public class NumberVector {
    private int value;
    private double valueDb;

    public NumberVector(int value, double valueDb) {
        this.value = value;
        this.valueDb = valueDb;
    }

    public NumberVector(double valueDb){
        this.valueDb = valueDb;
    }

    public NumberVector(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getValueDb() {
        return valueDb;
    }

    public void setValueDb(double valueDb) {
        this.valueDb = valueDb;
    }
    
}
