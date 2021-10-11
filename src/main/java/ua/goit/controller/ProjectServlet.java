package ua.goit.controller;

import ua.goit.model.Company;
import ua.goit.model.Customer;
import ua.goit.model.Project;
import ua.goit.service.BaseService;
import ua.goit.service.CompanyService;
import ua.goit.service.CustomerService;
import ua.goit.service.ProjectService;
import ua.goit.util.NumericConverter;

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
        projectBaseService = new ProjectService(Project.class);
        companyBaseService = new CompanyService(Company.class);
        customerBaseService = new CustomerService(Customer.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        String pathInfo = req.getPathInfo();
        String[] split = pathInfo.split("/");
        if (pathInfo==null || "/".equals(pathInfo)) {
            req.setAttribute("projects",projectBaseService.readAll());
            req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
        } else if (action.startsWith("/findProject")) {
            req.setAttribute("entity","project");
            req.getRequestDispatcher("/view/findByName.jsp").forward(req,resp);
        } else if (action.startsWith("/find")) {
            if (req.getParameter("id")==null) {
                List<Project> projects = projectBaseService.findByName(req.getParameter("name"));
                if (projects.size() == 0) {
                    req.setAttribute("entity","project");
                    req.setAttribute("message","No projects whit name: "+req.getParameter("name"));
                    req.getRequestDispatcher("/view/notFound.jsp").forward(req,resp);
                } else {
                    req.setAttribute("projects", projects);
                    req.getRequestDispatcher("/view/project/projects.jsp").forward(req, resp);
                }
            } else {
                Project project = projectBaseService.findById(NumericConverter.getLong(req.getParameter("id"))).get();
                req.setAttribute("project", project);
                req.setAttribute("company", companyBaseService.findById(project.getCompany().getId()).get());
                req.setAttribute("customer", customerBaseService.findById(project.getCustomer().getId()).get());
                req.getRequestDispatcher("/view/project/projectDetails.jsp").forward(req,resp);
            }
        } else if (action.startsWith("/addProject")) {
            req.setAttribute("mode", 0);
            req.getRequestDispatcher("/view/project/saveProject.jsp").forward(req,resp);
        } else if (action.startsWith("/updateProject")) {
            Project project = projectBaseService.findById(NumericConverter.getLong(req.getParameter("id"))).get();
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
        Long companyId = NumericConverter.getLong(req.getParameter("companyId"));
        if (!companyBaseService.findById(companyId).isPresent()){
            req.setAttribute("entity","company");
            req.setAttribute("message","no company with ID: " + companyId);
            req.getRequestDispatcher("/view/notFound.jsp").forward(req,resp);
        }
        Long customerId = NumericConverter.getLong(req.getParameter("customerId"));
        if (!customerBaseService.findById(customerId).isPresent()){
            req.setAttribute("entity","customer");
            req.setAttribute("message","no customer with ID: " + customerId);
            req.getRequestDispatcher("/view/notFound.jsp").forward(req,resp);
        }
        String action = getAction(req);
        if (action.startsWith("/create")) {
            Project project = Project.builder()
                    .name(req.getParameter("name"))
                    .cost(NumericConverter.getInteger(req.getParameter("cost")))
                    .startDate(req.getParameter("startDate"))
                    .company(companyBaseService.findById(companyId).get())
                    .customer(customerBaseService.findById(customerId).get())
                    .build();
            projectBaseService.createEntity(project);
            req.setAttribute("projects",projectBaseService.readAll());
            req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long companyId = NumericConverter.getLong(req.getParameter("companyId"));
        if (!companyBaseService.findById(companyId).isPresent()){
            req.setAttribute("entity","company");
            req.setAttribute("message","no company with ID: " + companyId);
            req.getRequestDispatcher("/view/notFound.jsp").forward(req,resp);
        }
        Long customerId = NumericConverter.getLong(req.getParameter("customerId"));
        if (!customerBaseService.findById(customerId).isPresent()){
            req.setAttribute("entity","customer");
            req.setAttribute("message","no customer with ID: " + customerId);
            req.getRequestDispatcher("/view/notFound.jsp").forward(req,resp);
        }
        Project project = Project.builder()
                .id(NumericConverter.getLong(req.getParameter("id")))
                .name(req.getParameter("name"))
                .cost(NumericConverter.getInteger(req.getParameter("cost")))
                .startDate(req.getParameter("startDate"))
                .company(companyBaseService.findById(companyId).get())
                .customer(customerBaseService.findById(customerId).get())
                .build();
        projectBaseService.createEntity(project);
        req.setAttribute("projects",projectBaseService.readAll());
        req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        projectBaseService.deleteEntity(NumericConverter.getLong(id));
        req.setAttribute("projects",projectBaseService.readAll());
        req.getRequestDispatcher("/view/project/projects.jsp").forward(req,resp);
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletPath = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletPath.length());
    }

}
