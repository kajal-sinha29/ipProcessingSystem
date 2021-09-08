package admins.ipProcessingSystem.dao;

import admins.ipProcessingSystem.entity.Admin;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao {

    Users findByUserId(int userId);
    public List<IpDetails> findIpByUserId(int userId);
    public void save(IpDetails ipDetails);
}
