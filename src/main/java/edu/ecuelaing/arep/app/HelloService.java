package edu.ecuelaing.arep.app;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class HelloService 
{
    public static void main( String[] args )
    {
    	secure("keycerts/ecikeystore.p12", "arep2021", null, null);
    	port(getPort());
        get("/hellosecureservice", (req, res)-> "Hello from secure service!");
    	//ursecure("keycerts/eci"),
        
        //get("/helloservice", (req, res) -> "Hello from secure service !!");
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
