package controller;

import model.Event;
import model.EventModel;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/Events")
public class EventController {

    static EventModel eventList = new EventModel();

    /*Handle Post to insert new Event*/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateRule(Event e) {
        eventList.addEvent(e);
        return Response.status(Response.Status.OK)
                .entity(e)
                .build();

    }
    /*Handle Get to list the events Inserted*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Event> getEvents(){

        return eventList.getAllRules();
    }




}
