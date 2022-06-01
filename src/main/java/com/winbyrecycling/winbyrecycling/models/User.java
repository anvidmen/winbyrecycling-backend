package com.winbyrecycling.winbyrecycling.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 45)
    private String username;
    private String password;
    private int points_game1 = 0;
	private int points_game2 = 0;
	private int points_game3 = 0;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getPoints_game_1() {
        return points_game1;
    }

    public void setPoints_game1(int points_game1) {
        this.points_game1 = points_game1;
    }

    public int getPoints_game2() {
        return points_game2;
    }

    public void setPoints_game2(int points_game2) {
        this.points_game2 = points_game2;
    }

    public int getPoints_game3() {
        return points_game3;
    }

    public void setPoints_game3(int points_game3) {
        this.points_game3 = points_game3;
    }
}
