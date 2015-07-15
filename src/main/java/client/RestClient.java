package client;

import model.Event;
import model.Rule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    private static Client cli = ClientBuilder.newClient();
    private final static int MAX_PARAMETER =30000;
    private final static int MIN_PARAMETER =10000;

    private static void postNewRule() throws IOException {

        WebTarget target = cli.target("http://localhost:8080").path("/Rules");
        ArrayList<String> users = new ArrayList<String>();
        users.add("Joao");
        users.add("Diogo");

        Rule r = new Rule();
        r.setAlertThreshold(13000);
        r.setParameter("CO");
        r.setUsers(users);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(r);

        Response rs = target.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        //Rule taskResponse = rs.readEntity(Rule.class);

        //System.out.println(taskResponse.getParameter());
    }


    private static void postNewEvent(String parameter, int parameterValue) throws IOException{


        WebTarget target = cli.target("http://localhost:8080").path("/Events");

        Event e = new Event();
        e.setReceivedParameter(parameter);
        e.setParameterValue(parameterValue);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(e);
        Response rs = target.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        //Event eventResponse = rs.readEntity(Event.class);

        //System.out.println(eventResponse.getReceivedParameter());

    }

    private static void getAlerts(String username){
        WebTarget targetRules = cli.target("http://localhost:8080").path("/Rules");
        WebTarget targetEvents = cli.target("http://localhost:8080").path("/Events");

        Invocation.Builder invBuilderRules = targetRules.request(MediaType.APPLICATION_JSON);
        Invocation.Builder invBuilderEvents = targetEvents.request(MediaType.APPLICATION_JSON);

        Response respRules = invBuilderRules.get();
        Response respEvents = invBuilderEvents.get();

        String rules = respRules.readEntity(String.class);
        String events = respEvents.readEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Rule [] ruleList = null;
        Event [] eventList = null;

        try {
            ruleList = mapper.readValue(rules,Rule[].class);
            eventList = mapper.readValue(events,Event[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Rule r : ruleList){
            for(Event e : eventList){
                    if(r.getParameter().equals(e.getReceivedParameter()) && e.getParameterValue()>r.getAlertThreshold() && r.getUsers().contains(username)){
                        System.out.println("ALERT - "+e.getReceivedParameter()+" - " + e.getParameterValue() + " Max - "+r.getAlertThreshold()+" Time - "+e.getTime());
                    }
            }
        }

    }

    public static void main(String[] argv) {

        Random r = new Random();

        try {
            postNewRule();
            for (int i = 0; i <5; i++){
                postNewEvent("CO",r.nextInt((MAX_PARAMETER - MIN_PARAMETER) + 1) + MIN_PARAMETER);
            }
            getAlerts("Diogo");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Please, do not remove this line from file template, here invocation of web service will be inserted
    }
}
