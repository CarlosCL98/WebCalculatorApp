package edu.eci.arep;

import com.google.gson.Gson;

import edu.eci.arep.CalculatorServices.CalculatorApp;
import edu.eci.arep.CalculatorServices.ResultService;
import edu.eci.arep.CalculatorServices.StandardResponse;
import edu.eci.arep.CalculatorServices.StatusResponse;
import edu.eci.arep.Entities.Result;
import edu.eci.arep.LinkedList.LinkedList;

import static spark.Spark.*;

/**
 * Web Calculator App represents the main class that allows a REST service.
 *
 * @author Carlos Medina
 */
public class WebCalculatorApp {

    private static ResultService resultService = new ResultService();

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        // Show main page.
        get("/calculator", (request, response) -> {
            response.type("text/html");
            response.redirect("/index.html");
            response.status(200);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        // Get all results saved.
        get("/calculator/results", (request, response) -> {
            response.type("application/json");
            response.status(200);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJson(resultService.getAllResults())));
        });
        // Get last result saved.
        get("/calculator/result", (request, response) -> {
            response.type("application/json");
            response.status(200);
            Result result = resultService.getResultById(resultService.getMaxId());
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJson(result)));
        });
        // Create a new result by analyzing the data.
        post("/calculator/result", (request, response) -> {
            response.type("application/json");
            LinkedList data = new LinkedList();
            String[] dataString = request.queryParams("data").split(",");
            for (String d : dataString) {
                data.add(Double.parseDouble(d));
            }
            double mean = CalculatorApp.mean(data);
            double deviation = CalculatorApp.standardDeviation(data, mean);
            Result result = new Result(resultService.getMaxId() + 1, mean, deviation);
            resultService.addResult(result);
            response.status(201);
            response.redirect("/results.html");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJson(result)));
        });
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        int port = 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
        if (System.getenv("PORT") != null) {
            port = Integer.parseInt(System.getenv("PORT"));
        }
        return port;
    }
}
