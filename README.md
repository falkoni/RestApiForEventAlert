# RestApiForEventAlert
Small api to create rules, events and alerts for those rules


Installation Notes

    Go to the output dir, get the war file and deploy in a local webserver (e.g Tomcat, GlassFish)
    Inside the war file there's the compiled version of the rest client, running java RestClient will give results 
    of a proposed test
    
 Project Notes   
    
    Project made with intelij ultimate 14.02 using maven, and the restfull framework support of this IDE
    
    Not all CRUD operations implemented only the Create option and the Read option
    
    the package model contais all the data models for this api
    
    the package controller, all the controllers (Restfull Service (servlet at this point still))
