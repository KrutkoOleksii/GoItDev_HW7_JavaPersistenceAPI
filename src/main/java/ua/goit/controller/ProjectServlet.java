package ua.goit.controller;

import ua.goit.model.Company;
import ua.goit.model.Customer;
import ua.goit.model.Project;
import ua.goit.service.BaseService;
import ua.goit.service.CompanyService;
import ua.goit.service.CustomerService;
import ua.goit.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/project/*")
public class ProjectServlet extends HttpServlet {

    private final BaseService<Long, Project> projectBaseService;
    private final BaseService<Long, Company> companyBaseService;
    private final BaseService<Long, Customer> customerBaseService;

    public ProjectServlet() {
        projectBaseService = new ProjectService();
        companyBaseService = new CompanyService();
        customerBaseService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        String pathInfo = req.getPathInfo();
        String[] split = pathInfo.split("/");
        if (pathInfo==null || "/".equals(pathInfo)) {
            req.setAttribute("projects",projectBaseService.readAll(Project.class));
            req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
        } else if (action.startsWith("/findProject")) {
            req.setAttribute("entity","project");
            req.getRequestDispatcher("/view/findByName.jsp").forward(req,resp);
        } else if (action.startsWith("/find")) {
            if (req.getParameter("id")==null) {
                List<Project> projects = projectBaseService.findByName(Project.class, req.getParameter("name"));
                req.setAttribute("projects",projects);
                req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
            } else {
                Project project = projectBaseService.findById(Project.class, Long.parseLong(req.getParameter("id"))).get();
                req.setAttribute("project", project);
                req.setAttribute("company", companyBaseService.findById(Company.class,project.getCompanyId()).get());
                req.setAttribute("customer", customerBaseService.findById(Customer.class,project.getCustomerId()).get());
                req.getRequestDispatcher("/view/project/projectDetails.jsp").forward(req,resp);
            }
        } else if (action.startsWith("/addProject")) {
            req.setAttribute("mode", 0);
            req.getRequestDispatcher("/view/project/saveProject.jsp").forward(req,resp);
        } else if (action.startsWith("/updateProject")) {
            Project project = projectBaseService.findById(Project.class, Long.parseLong(req.getParameter("id"))).get();
            req.setAttribute("project", project);
            req.setAttribute("mode", 1);
            req.getRequestDispatcher("/view/project/saveProject.jsp").forward(req,resp);
        } else if (action.startsWith("/update")) {
            doPut(req,resp);
        } else if (action.startsWith("/deleteProject")) {
            req.setAttribute("entity","project");
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
            Project project = Project.builder()
                    .name(req.getParameter("name"))
                    .cost(Integer.parseInt(req.getParameter("cost")))
                    .startDate(req.getParameter("startDate"))
                    .companyId(Long.parseLong(req.getParameter("companyId")))
                    .customerId(Long.parseLong(req.getParameter("customerId")))
                    .build();
            projectBaseService.createEntity(Project.class, project);
            req.setAttribute("projects",projectBaseService.readAll(Project.class));
            req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Project project = Project.builder()
                .id(Long.parseLong(req.getParameter("id")))
                .name(req.getParameter("name"))
                .cost(Integer.parseInt(req.getParameter("cost")))
                .startDate(req.getParameter("startDate"))
                .companyId(Long.parseLong(req.getParameter("companyId")))
                .customerId(Long.parseLong(req.getParameter("customerId")))
                .build();
        projectBaseService.createEntity(Project.class, project);
        req.setAttribute("projects",projectBaseService.readAll(Project.class));
        req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        projectBaseService.deleteEntity(Project.class, Long.parseLong(id));
        req.setAttribute("projects",projectBaseService.readAll(Project.class));
        req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletPath = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletPath.length());
    }

}
