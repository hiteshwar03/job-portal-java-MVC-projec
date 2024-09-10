<%@page import="com.job.model.Company"%>
<%@page import="com.job.model.User"%>
<%@page import="com.job.dao.CompanyDao"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<style type="text/css">
		main{
    width: 80vw;
    margin: 0 auto;
    margin-top: 4rem;
}
.content{
    display: flex;
    gap: 3rem;
}
.table{
    width: 100%;
    
    & a{
        padding: 2px 12px;
        border-radius:5px;
        font-size: 15px;
    }

    &  a#view{
        color: white;
        text-decoration: none;
        background-color: blue;
    }
    &  a#edit{
        color: white;
        text-decoration: none;
        background-color: green;
    }
    &  a#delete{
        color: white;
        text-decoration: none;
        background-color: red;
    }
}
	</style>
</head>
<body>
	<%@ include file="/components/employer_navbar.jsp"%>  
	
	
	<main>
            <h5>As an employer, you can manage your job postings and applications here.</h5>
            <hr>
            <div class="content">
                <aside>
                <h3></h3>
                    <div class="card" style="width: 25rem;">
                        
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item"><h3>Comapny: ${company.companyName}</h3></li>
                          <li class="list-group-item"><h5><i class="fa-solid fa-location-dot"></i> ${company.companyAddress}</h5></li>
                          <li class="list-group-item"><p> <i class="fa-solid fa-envelope"></i> ${company.companyEmail}</p></li>
                        </ul>
                    </div>
                </aside>

                <section>
                <h3>Your Posted Jobs</h3>
                    <table class="table table-striped">
                        <tr >
                           <th>Job Id</th>
                           <th>Job Title</th>
							<th>Location</th>
							<th>Job Type</th>
							<th>Posted date</th>
							<th>Status</th>
							<th>Action</th>
                        </tr>
                        <c:forEach var="job" items="${allJobs}">
                        <tr>
                            <td>${job.jobId}</td>
							<td>${job.jobTitle}</td>
							<td>${job.location}</td>
							<td>${job.jobType}</td>
							<td>${job.postedDate}</td>
							<td>${job.status}</td>
                            <td><a href="view-job?id=${job.jobId}" id="view"><i class="fa-regular fa-eye"></i></a></td>
                            <td><a href="view-job?id=${job.jobId}" id="edit"><i class="fa-regular fa-pen-to-square"></i></a></td>
                            <td><a href="view-job?id=${job.jobId}" id="delete"><i class="fa-solid fa-trash"></i></a></td>
                         </tr>
                         </c:forEach>
                    </table>
                </section>
            </div>
        </main>	
</body>
</html>



