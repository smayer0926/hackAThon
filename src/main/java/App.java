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
            model.put("teams", Team.getAllTeams());
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
            ArrayList<String> allMembers = teams.getMembers();
            model.put("teams", teams);
            model.put("members", allMembers);
            model.put("email", allMembers);
            return new ModelAndView(model, "team-details.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String members = request.queryParams("members");
            String email = request.queryParams("email");
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team teams = Team.findbyId(idOfNewTeam);
            ArrayList<String> allMembers = teams.getMembers();
            teams.setMembers(members, email);
            model.put("teams", teams);
            model.put("members", allMembers);
            model.put("email", allMembers);
            return new ModelAndView(model, "team-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team editTeam = Team.findbyId(idOfNewTeam);
            model.put("editTeams", editTeam);
            return new ModelAndView(model, "entryForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<String,Object>();
            ArrayList<Team> allTeams = Team.getAllTeams();
            String nameOfTeam = request.queryParams("nameOfTeam");
            int idOfNewTeam = Integer.parseInt(request.params("id"));
            Team editTeam = Team.findbyId(idOfNewTeam);
            editTeam.update(nameOfTeam);
            model.put("teams", allTeams);
            response.redirect("/");
            return null;
        });
    }

}



