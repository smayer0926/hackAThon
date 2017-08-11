import models.Team;
import models.Member;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.staticFileLocation;


import java.lang.reflect.Array;
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
            ArrayList<Team> allTeams = request.session().attribute("teams");
            if (allTeams == null) {
                allTeams = new ArrayList<Team>();
                request.session().attribute("teams", allTeams);
            }
            String nameOfTeam = request.queryParams("nameOfTeam");
            Team newTeam = new Team(nameOfTeam);
            allTeams.add(newTeam);
            response.redirect("/");
            return null;
        });

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team teamMade = Team.findById(idOfTeamToFind);
            model.put("teams", teamMade);
            model.put("members", teamMade.getTeamMembers());
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
        get("/members/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Member> allMembers = Member.getAllMembers();
            model.put("allMembers", allMembers);
            return new ModelAndView(model, "membersonteam.hbs");
        }, new HandlebarsTemplateEngine());

        post("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String description = request.queryParams("description");
            Member newMember = new Member(name, age, description);
            model.put("newMembers", newMember.getAllMembers());
            response.redirect("/");
            return null;
        });

        get("/members/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfMemberToEdit = Integer.parseInt(req.params("id"));
            Member memberAdded = Member.findById(idOfMemberToEdit);
            model.put("members", memberAdded);
            model.put("members", memberAdded.getId());
            return new ModelAndView(model, "membersonteam.hbs");
        }, new HandlebarsTemplateEngine());

        get("/members/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfMemberToEdit = Integer.parseInt(req.params("id"));
            Member memberAdded = Member.findById(idOfMemberToEdit);
            model.put("editMembers", memberAdded);
            return new ModelAndView(model, "membersonteam.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (request, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String description = request.queryParams("description");
            int idOfPostToEdit = Integer.parseInt(request.params("id"));
            Member editMember = Member.findById(idOfPostToEdit);
            editMember.update(name, age, description);
            res.redirect("/");
            return null;
        });

    }
}



