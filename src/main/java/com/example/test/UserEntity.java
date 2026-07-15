package com.example.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // データベース内のテーブル名を「users」に設定
public class UserEntity {

    @Id //
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    
    public UserEntity() {
    }

   
    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // --- ゲッター ＆ セッター ---

    public String getUsername() {
        return username;
    }

    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}