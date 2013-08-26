package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

//test7
import org.codehaus.jackson.node.ObjectNode;

//test8
import org.codehaus.jackson.JsonNode;
import play.libs.Json;

public class Application extends Controller {
  
    public static Result index() {

        //test1
        //return ok(index.render("Your new application is ready."));

        //test2
        return ok("It works!");
    }

    public static Result hello(String name) {

        //test3
        //http://localhost:9000/hello/hoge
        return ok("Hello " + name + "!");
    }

    public static Result getParameters(String parameter) {

        //test4
        //http://localhost:9000/getParameters?parameter=hoge
        return ok("Parameter is " + parameter);
    }

    public static Result contentType() {

        //test5
        //        return ok("<h1>Hello World1!</h1>").as("text/html");

        //test6
        response().setContentType("text/html");
        return ok("<h1>Hello World2!</h1>");
    }

    public static Result responseJson() {

        //test7
        response().setContentType("application/json");
        ObjectNode result = Json.newObject();
        result.put("status","OK");
        result.put("message","Hello World");
        return ok(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result requestJson() {

        /*
          CURL
          curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"name":"takayuki"}'  http://localhost:9000/requestJson
         */

        //test8
        JsonNode json = request().body().asJson();
        String name = json.findPath("name").getTextValue();
        return ok("Hello "+name+ ".");
    }
  
}
