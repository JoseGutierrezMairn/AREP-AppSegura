package edu.ecuelaing.arep.app;

import static spark.Spark.*;

import spark.ModelAndView;
//import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class HelloService 
{
    public static void main( String[] args )
    {	
    	
    	port(getPort());
		Map<String, String> usuarios = new HashMap<>();
		Gson gson = new Gson();
		usuarios.put("jose@email.com", Hashing.sha256().hashString("jose123", StandardCharsets.UTF_8).toString());
		staticFileLocation("/static");
		secure("keycerts/ecikeystore.p12", "arep2021", null, null);
		get("/hellosecureservice", (req, res)-> "Hello from secure service!");
		get("/", (req, res) -> {
            res.redirect( "login.html");
            return "";
        });
		post("/login", (req, res) -> {
        	
			req.session(true);
			Usuario usuario = gson.fromJson(req.body(), Usuario.class);
			if(Hashing.sha256().hashString(usuario.getPw(), StandardCharsets.UTF_8).toString().equals(usuarios.get(usuario.getEmail()))){
                req.session().attribute("User",usuario.getEmail());
                req.session().attribute("Loged",true);
            }
			else {
				return "El Usuario o la Contraseña son incorrectas, por favor vuelva a intentar";
			}
			return "";
		});

		
		
    	
    	
        
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
