package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class EventModel {


    //supposed to implement the CRUD operations only C and R implemented


    private ArrayList<Event> eventList = new ArrayList<Event>();
    private Date date = new Date();
    public void addEvent(Event e){

        e.setTime(new Timestamp(date.getTime()));
        this.eventList.add(e);
    }

    public ArrayList<Event> getAllRules() {
        return this.eventList;

    }

}
