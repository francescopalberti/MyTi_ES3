package it.myti.test;

/**
 * Classe che rappresenta il WebService.
 * @author Francesco Palberti
 */

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;

@Path("/student")
public class StudentResources {
	private StudentDAO dao = StudentDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> list(){
		return dao.listAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Student aStudent) throws URISyntaxException {
		int newStudentId = dao.addStudent(aStudent);
		URI uri = new URI("/student/" + newStudentId);
		
		return Response.created(uri).build();
 }

 

}


