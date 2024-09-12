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
		    background-color:#F7F7F8;
		    height:100vh;
		    padding:1rem;
		}
		
		.table-jobs{
			width:71%;
		}
		
		.table{
		    width: 100%;
		    
		    & a{
		        padding: 2px 12px;
		        border-radius:5px;
		        font-size: 15px
				
		    }
		    .fa-eye{
		    	color:blue;
		    }
		    .fa-trash{
		    	color:red;
		    }
		    
		    
		
		    &  a#view{
		        text-decoration: none;
		        color: blue;
		    }
		    
		    &  a#delete{
		        text-decoration: none;
		        color: red;
		    }
		    .heading{
		    	margin: 0 auto;
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
					<h2 class="heading">Selected Application</h2>
                    <table class="table table-striped">
                        <tr >
                           <th>Application Id</th>
                           <th>Job Id</th>
                           <th>Job Title</th>
							<th>Location</th>
							<th>Status</th>
							<th>User id</th>
							<th>User Phone</th>
							<th>Username</th>
							<th>Action</th>
							<th></th>
                        </tr>
                        <c:forEach var="application" items="${selectedApplications}">
                        <tr>
                        	<td>${application.applicationId}</td>
                        	<td>${application.job.jobId}</td>
							<td>${application.job.jobTitle}</td>
							<td>${application.job.location}</td>
							<td>${application.status}</td>
							<td>${application.user.userId}</td>
							<td>${application.user.phone}</td>
							<td>${application.user.username}</td>
							 <td><a href="${pageContext.request.contextPath}/employer/view-application?id=${application.applicationId}" id="view"><i class="fa-regular fa-eye"></i> View</a></td>
							<td><a href="javascript:confirmDelete(${application.applicationId})" id="delete"><i class="fa-solid fa-trash"></i> Delete</a></td>
                         </tr>
                         </c:forEach>
                    </table>
            </div>
            
            
        </main>	
        
        <script type="text/javascript">
        	function confirmDelete(appid){
				if(confirm("Are you sure to delete: "+appid+"?")){
					window.location="${pageContext.request.contextPath}/employer/delete-application?id="+appid;
				}
        	}
        </script>
</body>
</html>


