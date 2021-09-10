package admins.ipProcessingSystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @Column(name="user_name")
    //@NotEmpty(message = "user name is required")
    String userName;
    
    @Column(name="admin_id")
    //@NotEmpty(message = "admin_id is required")
    int adminId;

    @Column(name="rights")
    //@NotEmpty(message = "right is required")
    String rightName;


    public Users(){}

    public Users(String userName, int adminId, String rightName) {
        this.userName = userName;
        this.adminId = adminId;
        this.rightName = rightName;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getRights() {
        return rightName;
    }

    public void setRights(String rights) {
        this.rightName = rights;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }



    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", adminId=" + adminId +
                ", rightName='" + rightName + '\'' +
                '}';
    }
}
