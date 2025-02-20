package com.hdoan.entity.user;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Entity
@Table(name = "java_user_001")
/*
 2 annotation đều của hibernate
 @DynamicInsert, @DynamicUpdate dùng dể tối ưu hóa các thao tác SQL
 @DynamicInsert: tạo sql insert chỉ với các cột có giá trị khác null
 @DynamicUpdate: tạo sql update chỉ với các cột có giá trị khác null
 */
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //userId

    @Column(columnDefinition = "VARCHAR(255) comment 'user name'", nullable = false )
    private String userName;

    @Column(columnDefinition = "VARCHAR(255) comment 'user email'", nullable = false, unique = true)
    private String userEmail;

    // 1 user -> many feeds
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // orphanRemoval -> nếu Feed ko có user -> auto delete
    @ToString.Exclude
    private List<FeedEntity> feeds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private CCCDEntity cccd;
}
