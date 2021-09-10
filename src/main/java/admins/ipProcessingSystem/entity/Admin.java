package admins.ipProcessingSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//, generator = "admins_id_seq")
    //@SequenceGenerator(name="admins_id_seq",sequenceName="admins_id_seq",allocationSize=1)
    int id;

    @Column(name="admin_name")
    //@NotEmpty(message = "admin name is required")
    String adminName;

    public Admin(){}

    public Admin(String adminName) {
        this.adminName = adminName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
