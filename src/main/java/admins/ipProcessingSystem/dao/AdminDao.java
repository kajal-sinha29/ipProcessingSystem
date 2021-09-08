package admins.ipProcessingSystem.dao;

import admins.ipProcessingSystem.entity.Admin;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;

import java.util.List;

public interface AdminDao {

    public void save(Admin admin);
    public List<IpDetails> findAllIp();
    public void save(Users users);
    public List<Users> findByAdminId(int adminId);
}
