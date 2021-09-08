package admins.ipProcessingSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="ipdetails")
public class IpDetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="Ips")
    //@Pattern(regexp="^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\\\.(?!$)|$)){4}$",
            //message="Ip  is invalid")
    //@NotEmpty(message = "Ip is required")
    String ip;

    @Column(name="Description")
    @NotEmpty(message = "Ip discription is required")
    String discription;

    @Column(name="user_id")
    //@NotEmpty(message = "user id is required")
    int userId;

    public IpDetails(){}

    public IpDetails(String ip, String discription, int userId) {
        this.ip = ip;
        this.discription = discription;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "IpDetails{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", discription='" + discription + '\'' +
                ", userId=" + userId +
                '}';
    }
}
