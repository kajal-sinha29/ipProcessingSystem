package admins.ipProcessingSystem.service;

import admins.ipProcessingSystem.entity.Admin;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;

import java.util.List;

public interface AdminService {

    public void save(Admin admin);
    public void save(Users users);
    public List<IpDetails> findAllIp();
    List<Users> findByAdminId(int adminId);
}
