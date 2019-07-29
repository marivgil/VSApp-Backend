package service;

import model.Area;
import model.Profile;
import model.User;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import persistence.service.UserService;
import service.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@CrossOriginResourceSharing(
        allowOrigins = {
                "https://vsapp-frontend.herokuapp.com"
        },
        allowCredentials = true,
        maxAge = 1,
        allowHeaders = {
                "X-custom-1", "X-custom-2"
        },
        exposeHeaders = {
                "X-custom-3", "X-custom-4"
        }
)
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
    @Path("/findUserByMail/{mail}")
    @Produces("application/json")
    public UserDTO findUserByEmailRest(@PathParam("mail") final String mail){
        User user = this.getUserService().findById(mail);
        if(user==null)
            return null;
            else return userToUserDTO(user);
    }

    @POST
    @Path("/createUser")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUserRest(UserDTO dto){
        User rc = userDTOtoUser(dto);
        this.getUserService().save(rc);
        return Response.ok().build();
    }

    private User userDTOtoUser(UserDTO dto){
        User user = new User();
        user.setPhone(dto.getPhone());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setMail(dto.getMail());
        user.setLocation(dto.getLocation());
        user.setArea(Area.valueOf(dto.getArea()));
        user.setProfile(Profile.valueOf(dto.getProfile()));
        return user;
    }

    private UserDTO userToUserDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setPhone(user.getPhone());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setMail(user.getMail());
        dto.setLocation(user.getLocation());
        dto.setArea(user.getArea().toString());
        dto.setProfile(user.getProfile().toString());
        return dto;
    }
}
