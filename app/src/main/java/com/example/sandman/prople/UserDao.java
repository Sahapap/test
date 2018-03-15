package com.example.sandman.prople;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by SandMan on 3/14/2018.
 */

@Dao
public interface UserDao {
    @Query("select * from user order by id DESC")
    List<User> getAllUsers();

    @Insert
    void insertAll(User... users);

}
