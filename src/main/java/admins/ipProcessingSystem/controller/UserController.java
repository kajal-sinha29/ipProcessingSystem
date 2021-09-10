package admins.ipProcessingSystem.controller;

import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import admins.ipProcessingSystem.exceptionHandler.ResourceNotFoundException;
import admins.ipProcessingSystem.service.UserService;
import admins.ipProcessingSystem.util.BlockedIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    /*private BlockedIp blockedIp;*/
    BlockedIp blockedIp=new BlockedIp();

    ArrayList<String> blocked = blockedIp.blockedByAdmin();
     Users user = new Users();
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/saveIp")
    public IpDetails addIpDetail(@Valid @RequestBody IpDetails ipDetails){
        String ip = ipDetails.getIp();
        int userId = ipDetails.getUserId();
        Users users= userService.findByUserId(userId);
        String right = users.getRightName();
        String[] rights = right.split(",");
        List<String> rightList = Arrays.asList(rights);

        for (String element : blocked) {
            if (element.contains(ip)) {
                throw new ResourceNotFoundException("Id is blocked By Admin :");
            }
            else{
                if(rightList.contains("Insert")){
                    userService.save(ipDetails);
                }
                else{
                    throw new ResourceNotFoundException("User has no insert right:");
                }
            }
        }

        return ipDetails;
    };
//Expr


    @GetMapping("/user/getUserByUserId/{userId}")
    public Users getUserByUserId(@PathVariable int userId){
        Users users= userService.findByUserId(userId);
        if(users==null){
            throw new ResourceNotFoundException("User not found with id :" + userId);
        }
        return  users;
    };

    @GetMapping("/user/getIpByUserId/{userId}")
    public List<IpDetails> getIpByUserId(@PathVariable int userId){
        List<IpDetails> ipDetails= userService.findIpByUserId(userId);
        if(ipDetails==null){
            throw  new ResourceNotFoundException("User not found with id :" + userId);
        }
        return  ipDetails;
    };



    @PutMapping("/user/updateIp")
    public IpDetails updateIp(@Valid @RequestBody IpDetails ipDetails){
        String ip = ipDetails.getIp();
        int userId = ipDetails.getUserId();
        Users users= userService.findByUserId(userId);
        String right = users.getRightName();
        String[] rights = right.split(",");
        List<String> rightList = Arrays.asList(rights);

        if(rightList.contains("update")){
            userService.update(ipDetails);
        }
        else{
            throw new ResourceNotFoundException("User has no update right:");
        }

        return ipDetails;
    };
}
