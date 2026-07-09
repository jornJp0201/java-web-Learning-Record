package com.example.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * ユーザー情報をデータベースに保存するためのEntity（テーブル設計図）クラスです。
 * 既存の「infomation」クラスの役割を置き換えます。
 */
@Entity
@Table(name = "users") // データベース内のテーブル名を「users」に設定
public class UserEntity {

    @Id // 主キー（プライマリキー：データの重複を許さないキー、今回はユーザー名）
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    // デフォルトコンストラクタ（JPAの仕様上、必須となります）
    public UserEntity() {
    }

    // 簡単にデータを入れられるようにするためのコンストラクタ
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