package models;

import java.time.LocalDate;

public class Record {
    private double value;
    private LocalDate date;

    public Record(double value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "value=" + value +
                ", date=" + date +
                '}';
    }
}
