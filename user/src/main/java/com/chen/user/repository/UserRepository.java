package com.chen.user.repository;

import com.chen.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 2017/7/25.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
