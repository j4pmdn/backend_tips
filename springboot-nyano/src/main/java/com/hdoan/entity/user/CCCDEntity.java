package com.hdoan.entity.user;/*
 * @project springboot-nyano
 * @author Huy
 */

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "java_cccd_001")
public class CCCDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numberCCCD;

//    @OneToOne(cascade = CascadeType.ALL)    // khi xóa CCCD -> xóa user
//    @JoinColumn(name = "user_id")
//    private UserEntity user;

}
