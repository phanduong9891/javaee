package resource;

import resource.request.DepartmentRequest;
import service.dto.DepartmentDto;
import service.serviceImpl.DepartmentService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(DepartmentResource.PATH)
public class DepartmentResource {

    public static final String PATH = "department";

    @Inject
    DepartmentService departmentService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
        return Response.ok(departmentService.getAll()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addDepartment(DepartmentRequest departmentRequest){
        DepartmentDto newDepartment = departmentService.save(departmentRequest);
        return Response.ok().entity(newDepartment).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{DepartmentId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateDepartment(@PathParam("DepartmentId")Integer departmentId, DepartmentRequest departmentRequest){
        DepartmentDto updateDepartment = departmentService.update(departmentId, departmentRequest);
        return Response.ok(updateDepartment).build();
    }

    @DELETE
    @Path("{DepartmentId}")
    public Response removeDepartment(@PathParam("DepartmentId")Integer departmentId){
        departmentService.remove(departmentId);
        return Response.ok().build();
    }
}
