package model;


import java.sql.Timestamp;

public class Event {
    private String receivedParameter;
    private int parameterValue;
    private Timestamp time;

    public String getReceivedParameter() {
        return receivedParameter;
    }

    public void setReceivedParameter(String receivedParameter) {
        this.receivedParameter = receivedParameter;
    }

    public int getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(int parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
