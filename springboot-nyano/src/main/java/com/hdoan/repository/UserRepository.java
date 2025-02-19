package com.hdoan.repository;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Annnottation @Repository is not necessary
// @RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    // find username vs userEmail
    // findByUserNameAndUserEmail
    // UserNameAndUserEmail
    // userNameAndUserEmail
    // userNameAnduserEmail
    // where userName = ?1 and userEmail = ?1
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // userName
    UserEntity findByUserName(String userName);

    /**
     * WHERE userName LIKE %?
     */
    List<UserEntity> findByUserNameStartingWith(String userName);

    /**
     * WHERE userName LIKE ?%
     */
    List<UserEntity> findByUserNameEndingWith(String userName);

    /**
     * WHERE id < 1
     */
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /**
     * UPDATE DELETE
     */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userName = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // navtive query
    /**
     * get count user use native query
     */

    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();
}