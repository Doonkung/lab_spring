package com.thaicom.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import springfox.documentation.service.ApiListing;

import javax.persistence.*;
import java.util.List;

@Entity(name = "u_user")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @JsonIgnore
    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

    private String civilId;

    public String getCivilId() {
        return civilId;
    }

    public void setCivilId(String civilId) {
        this.civilId = civilId;
    }

    // เพิ่ม property orphanRemoval สำหรับการลบ แบบ column ลูกได้
    @OneToOne(mappedBy = "user", orphanRemoval = true)
    private Social social;

    // FetchType
    // EAGER : ใช้สำหรับข้อมูลน้อยๆ เนื่องจาก spring จะทำการ fetch มาไว้บน memory
    // LAZY : ใช้สำหรับข้อมูลที่มีการ join ขนาด table ใหญ่
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Address> address;

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
