package ua.goit.controller;

import ua.goit.model.Company;
import ua.goit.model.Developer;
import ua.goit.service.BaseService;
import ua.goit.service.CompanyService;
import ua.goit.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/developer/*")
public class DeveloperServlet extends HttpServlet {

    private final BaseService<Long, Developer> developerBaseService;
    private final BaseService<Long, Company> companyBaseService;

    public DeveloperServlet() {
        developerBaseService = new DeveloperService(Developer.class);
        companyBaseService = new CompanyService(Company.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        String pathInfo = req.getPathInfo();
        String[] split = pathInfo.split("/");
        if (pathInfo==null || "/".equals(pathInfo)) {
            req.setAttribute("developers",developerBaseService.readAll());
            req.getRequestDispatcher("/view/developer/developers.jsp").forward(req,resp);
        } else if (action.startsWith("/findDeveloper")) {
            req.setAttribute("entity","developer");
            req.getRequestDispatcher("/view/findByName.jsp").forward(req,resp);
        } else if (action.startsWith("/find")) {
            if (req.getParameter("id")==null) {
                List<Developer> developers = developerBaseService.findByName(req.getParameter("name"));
                req.setAttribute("developers",developers);
                req.getRequestDispatcher("/view/developer/developers.jsp").forward(req,resp);
            } else {
                Developer developer = developerBaseService.findById(Long.parseLong(req.getParameter("id"))).get();
                req.setAttribute("developer", developer);
                req.setAttribute("company", companyBaseService.findById(developer.getCompany().getId()));
                req.getRequestDispatcher("/view/developer/developerDetails.jsp").forward(req,resp);
            }
        } else if (action.startsWith("/addDeveloper")) {
            req.setAttribute("mode", 0);
            req.getRequestDispatcher("/view/developer/saveDeveloper.jsp").forward(req,resp);
        } else if (action.startsWith("/updateDeveloper")) {
            Developer developer = developerBaseService.findById(Long.parseLong(req.getParameter("id"))).get();
            req.setAttribute("developer", developer);
            req.setAttribute("mode", 1);
            req.getRequestDispatcher("/view/developer/saveDeveloper.jsp").forward(req,resp);
        } else if (action.startsWith("/update")) {
            doPut(req,resp);
        } else if (action.startsWith("/deleteDeveloper")) {
            req.setAttribute("entity","developer");
            req.getRequestDispatcher("/view/deleteById.jsp").forward(req,resp);
        } else if (action.startsWith("/delete")) {
            doDelete(req,resp);
        } else if (split.length!=2){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        if (action.startsWith("/create")) {
            Developer developer = Developer.builder()
                    .name(req.getParameter("name"))
                    .age(Integer.parseInt(req.getParameter("age")))
                    .gender(req.getParameter("gender"))
                    .salary(Integer.parseInt(req.getParameter("salary")))
                    .company(companyBaseService.findById(Long.parseLong(req.getParameter("companyId"))).get())
                    .build();
            developerBaseService.createEntity(developer);
            req.setAttribute("developers",developerBaseService.readAll());
            req.getRequestDispatcher("/view/developer/developers.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Developer developer = Developer.builder()
                .id(Long.parseLong(req.getParameter("id")))
                .name(req.getParameter("name"))
                .age(Integer.parseInt(req.getParameter("age")))
                .gender(req.getParameter("gender"))
                .salary(Integer.parseInt(req.getParameter("salary")))
                .company(companyBaseService.findById(Long.parseLong(req.getParameter("companyId"))).get())
                .build();
        developerBaseService.createEntity(developer);
        req.setAttribute("developer", developer);
        req.setAttribute("developers",developerBaseService.readAll());
        req.getRequestDispatcher("/view/developer/developers.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        developerBaseService.deleteEntity(Long.parseLong(id));
        req.setAttribute("developers",developerBaseService.readAll());
        req.getRequestDispatcher("/view/developer/developers.jsp").forward(req,resp);
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletPath = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletPath.length());
    }

}
