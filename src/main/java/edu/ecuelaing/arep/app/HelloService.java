package edu.ecuelaing.arep.app;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
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
    	staticFileLocation("/static");
        get("/hellosecureservice", (req, res)-> "Hello from secure service!");
        
        get("/", (req, res) -> {
        	System.out.println("Acá estamos mijo 11111");
            res.redirect( "login.html");
            return "";
        });
    	//ursecure("keycerts/eci"),
        
        //get("/helloservice", (req, res) -> "Hello from secure service !!");
        
        post("/login", (req, res) -> {
        	System.out.println("Acá estamos mijo");
            Map<String, Object> model = new HashMap<String, Object>();
            List<String> lista = Arrays.asList(req.body().split("&"));
            String username = lista.get(0).substring(9);
            String password = lista.get(1).substring(9);
            String usernameUserDefault = "jose@hotmail.com";
            String passwordUserDefaultCrypt = encriptar("jose123");

            String resultado;
            req.session(true);
            req.session().attribute("Autenticado", false);
            if(username.equals(usernameUserDefault) && encriptar(password).equals(passwordUserDefaultCrypt)){
                resultado = "Usuario" + " " + username;
                req.session().attribute("Autenticado", true);
            }else{
                resultado = "Usuario o contraseña incorrecta";
            }
            model.put("result", resultado);


            return new ModelAndView(model,"/authentication");
        },new ThymeleafTemplateEngine());
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    
    private static String encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    public static String render(Map<String, Object> model, String templatePath) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
