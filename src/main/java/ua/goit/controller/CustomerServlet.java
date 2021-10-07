package ua.goit.controller;

import ua.goit.model.Customer;
import ua.goit.service.BaseService;
import ua.goit.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {

    private final BaseService<Long,Customer> customerBaseService;

    public CustomerServlet() {
        customerBaseService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = getAction(req);
        String pathInfo = req.getPathInfo();
        String[] split = pathInfo.split("/");
        if (pathInfo==null || "/".equals(pathInfo)) {
            req.setAttribute("customers",customerBaseService.readAll(Customer.class));
            req.getRequestDispatcher("/view/customer/customers.jsp").forward(req,resp);
        } else if (action.startsWith("/findCustomer")) {
            req.setAttribute("entity","customer");
            req.getRequestDispatcher("/view/findByName.jsp").forward(req,resp);
        } else if (action.startsWith("/find")) {
            if (req.getParameter("id")==null) {
                List<Customer> customers = customerBaseService.findByName(Customer.class, req.getParameter("name"));
                req.setAttribute("customers",customers);
                req.getRequestDispatcher("/view/customer/customers.jsp").forward(req,resp);
            } else {
                Customer customer = customerBaseService.findById(Customer.class, Long.parseLong(req.getParameter("id"))).get();
                req.setAttribute("customer", customer);
                req.getRequestDispatcher("/view/customer/customerDetails.jsp").forward(req,resp);
            }
        } else if (action.startsWith("/addCustomer")) {
            req.setAttribute("mode", 0);
            req.getRequestDispatcher("/view/customer/saveCustomer.jsp").forward(req,resp);
        } else if (action.startsWith("/updateCustomer")) {
            Customer customer = customerBaseService.findById(Customer.class, Long.parseLong(req.getParameter("id"))).get();
            req.setAttribute("customer", customer);
            req.setAttribute("mode", 1);
            req.getRequestDispatcher("/view/customer/saveCustomer.jsp").forward(req,resp);
        } else if (action.startsWith("/update")) {
            doPut(req,resp);
        } else if (action.startsWith("/deleteCustomer")) {
            req.setAttribute("entity","customer");
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
            Customer customer = Customer.builder()
                    .name(req.getParameter("name"))
                    .code(req.getParameter("code"))
                    .build();
            customerBaseService.createEntity(Customer.class, customer);
            req.setAttribute("customers",customerBaseService.readAll(Customer.class));
            req.getRequestDispatcher("/view/customer/customers.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Customer customer = Customer.builder()
                .id(Long.parseLong(req.getParameter("id")))
                .name(req.getParameter("name"))
                .code(req.getParameter("code"))
                .build();
        customerBaseService.createEntity(Customer.class, customer);
        req.setAttribute("customers",customerBaseService.readAll(Customer.class));
        req.getRequestDispatcher("/view/customer/customers.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        customerBaseService.deleteEntity(Customer.class, Long.parseLong(id));
        req.setAttribute("customer",customerBaseService.readAll(Customer.class));
        req.getRequestDispatcher("/view/customer/customers.jsp").forward(req,resp);
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletPath = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletPath.length());
    }
}
