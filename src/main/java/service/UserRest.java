package service;

import persistence.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/servicesUsers")
public class UserRest {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/testRest/")
    @Produces("application/json")
    public Response findUserByEmailRest(){
        return Response.ok().build();
    }
}
