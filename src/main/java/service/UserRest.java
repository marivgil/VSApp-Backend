package service;

import model.User;
import persistence.service.UserService;
import service.dto.UserDTO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
