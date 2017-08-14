import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.staticFileLocation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> allTeams = Team.getAllTeams();
            model.put("allTeams", allTeams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "entryForm.hbs");
        }, new HandlebarsTemplateEngine());
        post("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> allTeams = Team.getAllTeams();
            String nameOfTeam = request.queryParams("nameOfTeam");
            String description = request.queryParams("description");
            Team newTeam = new Team(nameOfTeam, description);
            model.put("teams", allTeams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team teams = Team.findbyId(idOfNewTeam);
            ArrayList<String> allMembers = teams.getAllMembers();
            model.put("teams", teams);
            model.put("members", allMembers);
            return new ModelAndView(model, "team-details.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String members = request.queryParams("members");
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team teams = Team.findbyId(idOfNewTeam);
            ArrayList<String> allMembers = teams.getAllMembers();
            teams.setMembers(members);
            model.put("teams", teams);
            model.put("members", allMembers);
            return new ModelAndView(model,"team-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team teams = Team.findbyId(idOfNewTeam);
            model.put("teams", teams);
            return new ModelAndView(model, "entryForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            ArrayList<Team> allTeams = Team.getAllTeams();
            String nameOfTeam = request.queryParams("nameOfTeam");
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team teams = Team.findbyId(idOfNewTeam);
            teams.update(nameOfTeam);
            model.put("teams", allTeams);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
    }

}



