package admins.ipProcessingSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @Column(name="user_name")
    @NotEmpty(message = "user name is required")
    String userName;
    
    @Column(name="admin_id")
    @NotEmpty(message = "admin_id is required")
    int adminId;

    @Column(name="rights")
    @NotEmpty(message = "right is required")
    String rights;

    public Users(){}

    public Users(String userName, int adminId, String rights) {
        this.userName = userName;
        this.adminId = adminId;
        this.rights = rights;
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
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", adminId=" + adminId +
                ", rights='" + rights + '\'' +
                '}';
    }
}
