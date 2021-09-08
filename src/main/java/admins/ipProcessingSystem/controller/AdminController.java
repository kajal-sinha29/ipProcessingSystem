package admins.ipProcessingSystem.controller;

import admins.ipProcessingSystem.entity.Admin;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import admins.ipProcessingSystem.exceptionHandler.ResourceNotFoundException;
import admins.ipProcessingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/admin/saveAdmin")
    public Admin addPersonalDetail(@RequestBody Admin admin){
        adminService.save(admin);
        return admin;
    };

    @PostMapping("/admin/saveUser")
    public Users addPersonalDetail(@Valid @RequestBody Users users){
        adminService.save(users);
        return users;
    };

    @GetMapping("/admin/getAllIp")
    public List<IpDetails> findAll()
    {
        List<IpDetails> listOfIp =  adminService.findAllIp();
        if(listOfIp==null){
            throw  new ResourceNotFoundException("No Ip Found:");
        }
        return listOfIp;
    }

    @GetMapping("/admin/getUserByAdminId/{adminId}")
    public List<Users> getUserByAdminId(@PathVariable int adminId){
        List<Users> users= adminService.findByAdminId(adminId);
        if(users==null){
            throw  new ResourceNotFoundException("No user is registered with this adminId : " + adminId);
        }
        return  users;
    };


}
