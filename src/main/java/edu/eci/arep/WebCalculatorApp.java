package edu.eci.arep;

import edu.eci.arep.LinkedList.LinkedList;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Web Calculator App represents the main class that allows a REST service.
 *
 * @author Carlos Medina
 */
public class WebCalculatorApp {

    public static void main(String[] args) {
        port(getPort());
        Spark.staticFiles.location("/public");
        get("/results", (req, res) -> analizarDatos(req, res));
    }

    /**
     * Receive a request, analyze the data by calculating the mean and standard deviation.
     *
     * @param req request of the client.
     * @param res responde of the page
     * @return String : it returns the page content with the analyzed data.
     */
    private static String analizarDatos(Request req, Response res) {
        String pageContent = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Web Calculator App</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "\n"
                + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
                + "        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n"
                + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n"
                + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div class=\"container\">            \n"
                + "            <div class=\"row\" style=\"padding: 5% 0 5% 0;\">\n"
                + "                <div class=\"col-md-3\"></div>\n"
                + "                <div class=\"col-md-6\" style=\"text-align: center;\">\n"
                + "                    <h2>Web Calculator App</h2>\n"
                + "                    <h4>Results</h4>\n"
                + "                </div>\n"
                + "                <div class=\"col-md-3\"></div>\n"
                + "            </div>\n"
                + "            <div class=\"row\">\n"
                + "                <div class=\"col-md-3\"></div>\n"
                + "                <div class=\"col-md-2\" style=\"text-align: center;\">\n"
                + "                    <table class=\"table table-bordered\">\n"
                + "                        <thead class=\"thead-dark\">\n"
                + "                            <tr>\n"
                + "                                <th>Datos (Data)</th>\n"
                + "                            </tr>\n"
                + "                        </thead>\n"
                + "                        <tbody>\n";
        LinkedList data = new LinkedList();
        String[] dataString = req.queryParams("data").split(",");
        for (String d : dataString) {
            pageContent += "<tr><td>" + d + "</td></tr>";
            data.add(Double.parseDouble(d));
        }
        double mean = CalculatorApp.mean(data);
        double deviation = CalculatorApp.standardDeviation(data, mean);
        pageContent += "                        </tbody>\n"
                + "                    </table>\n"
                + "                </div>\n"
                + "                <div class=\"col-md-4\" style=\"text-align: center;\">\n"
                + "                    <table class=\"table table-bordered\">\n"
                + "                        <thead class=\"thead-dark\">\n"
                + "                            <tr>\n"
                + "                                <th>Promedio (Mean)</th>\n"
                + "                                <th>Desviación Estándar (Standard Deviation)</th>\n"
                + "                            </tr>\n"
                + "                        </thead>\n"
                + "                        <tbody>\n"
                + "                            <tr>\n"
                + "                                <td>" + mean + "</td>"
                + "                                <td>" + deviation + "</td>"
                + "                            </tr>\n"
                + "                        </tbody>\n"
                + "                    </table>\n"
                + "                </div>\n"
                + "                <div class=\"col-md-3\"></div>\n"
                + "            </div>\n"
                + "            <div class=\"row\">\n"
                + "                <div class=\"col-md-3\"></div>\n"
                + "                <div class=\"col-md-6\" style=\"text-align: center;\">\n"
                + "                    <input type=\"button\" class=\"btn btn-primary\" value=\"Regresar\" onclick=\"window.location.href='/'\">\n"
                + "                </div>\n"
                + "                <div class=\"col-md-3\"></div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
        return pageContent;
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
