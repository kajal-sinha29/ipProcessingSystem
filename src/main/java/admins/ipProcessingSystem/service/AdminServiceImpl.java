package admins.ipProcessingSystem.service;

import admins.ipProcessingSystem.dao.AdminDao;
import admins.ipProcessingSystem.entity.Admin;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{


    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void save(Admin admin) {

        adminDao.save(admin);
    }

    @Override
    public void save(Users users) {
        adminDao.save(users);
    }

    @Override
    public List<IpDetails> findAllIp() {
        return adminDao.findAllIp();
    }

    @Override
    public List<Users> findByAdminId(int adminId) {
        return adminDao.findByAdminId(adminId);
    }
}
