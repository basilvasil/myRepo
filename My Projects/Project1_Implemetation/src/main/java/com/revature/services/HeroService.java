package com.revature.services;
import com.revature.Create.ORMCreator;
import com.revature.Delete.ORMDeleter;
import com.revature.Read.ORMReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Update.ORMUpdater;
import com.revature.models.Hero;



public class HeroService {

    ObjectMapper mapper;

    public HeroService() {
        mapper = new ObjectMapper();
    }

    public void getAllHeroes(HttpServletRequest req, HttpServletResponse res){

        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getHeroes());
            res.getOutputStream().print(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Hero> getHeroes(){
        Optional<List<Hero>> result = ORMReader.readORM();
        return result.orElseGet(ArrayList::new);
    }


    public void insertHero(HttpServletRequest req, HttpServletResponse resp) {
        try {
            StringBuilder builder = new StringBuilder();
            req.getReader().lines()
                    .collect(Collectors.toList())
                    .forEach(builder::append);

            Hero hero = mapper.readValue(builder.toString(), Hero.class);
            int result = ORMCreator.insertHero(hero);

            if(result != 0){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else{

                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }


        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();

        }

    }
    public void deleteHero(HttpServletRequest req, HttpServletResponse resp) {
        boolean result = ORMDeleter.deleteHero(Integer.parseInt(req.getParameter("id")));
        if(result){
            resp.setStatus(HttpServletResponse.SC_OK);
        } else{
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }


    public void updateHero(HttpServletRequest req, HttpServletResponse resp) {
        StringBuilder builder = new StringBuilder();
        try {

            req.getReader().lines()
                    .collect(Collectors.toList())
                    .forEach(builder::append);

            Hero hero = mapper.readValue(builder.toString(), Hero.class);

            if(hero.getId() != 0){
                boolean result = ORMUpdater.update(hero);

                if(result){
                    resp.setStatus(HttpServletResponse.SC_OK);
                    String JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hero);
                    resp.getWriter().print(JSON);
                }

            } else{
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
