package edu.cpp.awh.easyabc.model;

public class DateTime {
    private int day;
    private int month;
    private int year;

    private int hour;
    private int minute;

    public DateTime() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;

        this.hour = 0;
        this.minute = 0;
    }

    public DateTime(DateTime source)throws InvalidInputException {
        this.day = source.day;
        this.month = source.month;
        this.year = source.year;

        this.hour = source.hour;
        this.minute = source.minute;

        checkValidity();
    }

    public DateTime withDay(int d) throws InvalidInputException {
        this.day = d;
        checkValidity();
        return this;
    }

    public DateTime withMonth(int m) throws InvalidInputException {
        this.month = m;
        checkValidity();
        return this;
    }

    public DateTime withYear(int y) throws InvalidInputException {
        this.year = y;
        checkValidity();
        return this;
    }

    public DateTime withHour(int h) throws InvalidInputException {
        this.hour = h;
        checkValidity();
        return this;
    }

    public DateTime withMinute(int m) throws InvalidInputException {
        this.minute = m;
        checkValidity();
        return this;
    }

    public void checkValidity() throws InvalidInputException {
        if(day < 1 || day > 31)
            throw new InvalidInputException();
        if(month < 1 || month > 12)
            throw new InvalidInputException();
        if(year < 1 )
            throw new InvalidInputException();

        if(hour < 0 || hour > 23)
            throw new InvalidInputException();
        if(minute < 0 || minute > 59)
            throw new InvalidInputException();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
