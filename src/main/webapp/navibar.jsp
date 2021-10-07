<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Company
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/company/">Show Companies</a>
            <a href="${pageContext.request.contextPath}/company/findCompany">Find Company</a>
            <a href="${pageContext.request.contextPath}/company/addCompany">Create Company</a>
            <%--
            <a href="${pageContext.request.contextPath}/company/updateCompany">Update Company</a>
            <a href="${pageContext.request.contextPath}/company/deleteCompany">Delete Company</a>
            --%>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/customer/">Show Customers</a>
            <a href="${pageContext.request.contextPath}/customer/findCustomer">Find Customer</a>
            <a href="${pageContext.request.contextPath}/customer/addCustomer">Create Customer</a>
            <%--
            <a href="${pageContext.request.contextPath}/customer/updateCustomer">Update Customer</a>
            <a href="${pageContext.request.contextPath}/customer/deleteCustomer">Delete Customer</a>
             --%>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Developer
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/developer/">Show Developers</a>
            <a href="${pageContext.request.contextPath}/developer/findDeveloper">Find Developer</a>
            <a href="${pageContext.request.contextPath}/developer/addDeveloper">Create Developer</a>
            <%--
            <a href="${pageContext.request.contextPath}/developer/updateDeveloper">Update Developer</a>
            <a href="${pageContext.request.contextPath}/developer/deleteDeveloper">Delete Developer</a>
             --%>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Project
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/project/">Show Projects</a>
            <a href="${pageContext.request.contextPath}/project/findProject">Find Project</a>
            <a href="${pageContext.request.contextPath}/project/addProject">Create Project</a>
            <%--
            <a href="${pageContext.request.contextPath}/project/updateProject">Update Project</a>
            <a href="${pageContext.request.contextPath}/project/deleteProject">Delete Project</a>
             --%>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Skill
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/skill/">Show Skills</a>
            <a href="${pageContext.request.contextPath}/skill/findSkill">Find Skill by name</a>
            <a href="${pageContext.request.contextPath}/skill/findSkillById">Find Skill by ID</a>
            <a href="${pageContext.request.contextPath}/skill/addSkill">Create Skill</a>
            <%--
            <a href="${pageContext.request.contextPath}/skill/updateSkill">Update Skill</a>
            <a href="${pageContext.request.contextPath}/skill/deleteSkill">Delete Skill</a>
             --%>
        </div>
    </div>
</div>