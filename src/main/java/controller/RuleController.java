package controller;

import model.Rule;
import model.RuleModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/Rules")
public class RuleController {

    static RuleModel ruleList = new RuleModel();

    /*Handle Post to insert new Rule*/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateRule(Rule r) {
        ruleList.addRule(r);
        return Response.status(Response.Status.OK)
                .entity(r)
                .build();

    }
    /*Handle Get to list the rules Inserted*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Rule> getRules(){

        return ruleList.getAllRules();
    }




}
