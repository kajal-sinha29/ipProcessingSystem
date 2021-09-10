package admins.ipProcessingSystem.service;

import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;

import java.util.List;

public interface UserService {

    Users findByUserId(int userId);
    List<IpDetails> findIpByUserId(int userId);
    public void save(IpDetails ipDetails);
    public void update(IpDetails ipDetails);

}
