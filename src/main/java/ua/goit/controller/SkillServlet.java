package ua.goit.controller;

import ua.goit.model.Skill;
import ua.goit.service.BaseService;
import ua.goit.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/skill/*")
public class SkillServlet extends HttpServlet {
    
    private final BaseService<Long, Skill> skillBaseService;

    public SkillServlet() {
        skillBaseService = new SkillService(Skill.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        String pathInfo = req.getPathInfo();
        String[] split = pathInfo.split("/");
        if (pathInfo==null || "/".equals(pathInfo)) {
            req.setAttribute("skills",skillBaseService.readAll());
            req.getRequestDispatcher("/view/skill/skills.jsp").forward(req,resp);
        } else if (action.startsWith("/findSkillById")) {
            req.setAttribute("entity","skill");
            req.getRequestDispatcher("/view/findById.jsp").forward(req,resp);
        } else if (action.startsWith("/findSkill")) {
            req.setAttribute("entity","skill");
            req.getRequestDispatcher("/view/findByName.jsp").forward(req,resp);
        } else if (action.startsWith("/find")) {
            if(req.getParameter("id")==null) {
//                List<Skill> skills = skillBaseService.findByName(req.getParameter("name"));
//                req.setAttribute("skills",skills);
//                req.getRequestDispatcher("/view/skill/skills.jsp").forward(req,resp);
            } else {
                Skill skill = skillBaseService.findById(Long.parseLong(req.getParameter("id"))).get();
                req.setAttribute("skill", skill);
                req.getRequestDispatcher("/view/skill/skillDetails.jsp").forward(req,resp);
            }
        } else if (action.startsWith("/addSkill")) {
            req.setAttribute("mode", 0);
            req.getRequestDispatcher("/view/skill/saveSkill.jsp").forward(req,resp);
        } else if (action.startsWith("/updateSkill")) {
            Skill skill = skillBaseService.findById(Long.parseLong(req.getParameter("id"))).get();
            req.setAttribute("skill", skill);
            req.setAttribute("mode", 1);
            req.getRequestDispatcher("/view/skill/saveSkill.jsp").forward(req,resp);
        } else if (action.startsWith("/update")) {
            doPut(req,resp);
        } else if (action.startsWith("/deleteSkill")) {
            req.setAttribute("entity","skill");
            req.getRequestDispatcher("/view/deleteById.jsp").forward(req,resp);
        } else if (action.startsWith("/delete")) {
            doDelete(req,resp);
        } else if (split.length!=2){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        if (action.startsWith("/create")) {
            Skill skill = Skill.builder()
                    .name(req.getParameter("name"))
                    .skillLevel(req.getParameter("level"))
                    .build();
            skillBaseService.createEntity(skill);
            req.setAttribute("skills",skillBaseService.readAll());
            req.getRequestDispatcher("/view/skill/skills.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Skill skill = Skill.builder()
                .id(Long.parseLong(req.getParameter("id")))
                .name(req.getParameter("name"))
                .skillLevel(req.getParameter("level"))
                .build();
        skillBaseService.createEntity(skill);
        req.setAttribute("skills",skillBaseService.readAll());
        req.getRequestDispatcher("/view/skill/skills.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        skillBaseService.deleteEntity(Long.parseLong(id));
        req.setAttribute("skills",skillBaseService.readAll());
        req.getRequestDispatcher("/view/skill/skills.jsp").forward(req,resp);
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletPath = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletPath.length());
    }

}
