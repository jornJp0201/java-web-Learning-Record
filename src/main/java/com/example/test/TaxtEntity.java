package com.example.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "taxt_table") 

public class TaxtEntity {

    @Id 
    @Column(name = "taxt", nullable = false, length = 50)
    private String taxt;

    @Column(name = "sentence", nullable = false)
    private String sentence;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private UserEntity username;




    
    public TaxtEntity() {
    }

   
    public TaxtEntity(String taxt, String sentence,UserEntity username) {
        this.taxt = taxt;
        this.sentence = sentence;
        this.username = username;
    }

    // --- ゲッター ＆ セッター ---

    public String getTaxt() {
        return taxt;
    }

    public void setTaxt(String taxt) {
    this.taxt = taxt;
}

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public UserEntity get_username(){
        return username;
    }

    public void set_username(UserEntity username){
        this.username=username;
    }
}
    

