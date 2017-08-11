import models.Team;
import models.Member;
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
            return new ModelAndView(model, "entryform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> allTeams = Team.getAllTeams();
            String nameOfTeam = request.queryParams("nameOfTeam");
            Team newTeam = new Team(nameOfTeam);
            response.redirect("/");
            return null;
        });

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfCakeToFind = Integer.parseInt(req.params("id"));
            Team teamMade = Team.findById(idOfCakeToFind);
            model.put("teams", teamMade);
            return new ModelAndView(model, "team-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Team teamMade = Team.findById(idOfPostToEdit);
            model.put("editTeams", teamMade);
            return new ModelAndView(model, "entryForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (request, res) -> {
            Map<String, Object> model = new HashMap<>();
            String nameOfTeam = request.queryParams("nameOfTeam");
            int idOfPostToEdit = Integer.parseInt(request.params("id"));
            Team editTeams = Team.findById(idOfPostToEdit);
            editTeams.update(nameOfTeam);
            res.redirect("/");
            return null;
        });

//        get("/members/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeam = Integer.parseInt(req.params("id"));
//            Member newMember = Member.findById(idOfTeam);
//            model.put("teams", newMember);
//            return new ModelAndView(model, "team-details.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/members/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfPostToEdit = Integer.parseInt(req.params("id"));
//            Member editMembers = Member.findById(idOfPostToEdit);
//            model.put("editMembers", editMembers);
//            return new ModelAndView(model, "entryForm.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/members/:id/update", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String participantName = request.queryParams("participantName");
//            int age = Integer.parseInt(request.params("age"));
//            String description = request.queryParams("description");
//            int idOfPostToEdit = Integer.parseInt(request.params("id"));
//            Member editMembers = Member.findById(idOfPostToEdit);
//            editMembers.update(participantName, age, description);
//            response.redirect("/");
//            return null;
//        });
    }
}
