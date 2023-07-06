package com.moody.backend.model;

import com.moody.backend.model.Weather;
import jakarta.persistence.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "genre_name", nullable = false)
    private String name;

    @Column(name = "genre_message", nullable = false)
    private String message;

    @Column(name = "genre_upvotes", nullable = false)
    private Long upVotes = 0L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "weather_id", referencedColumnName = "id")
    private Weather weather;
    //@OnDelete(action = OnDeleteAction.CASCADE)
    public Long getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Long upVotes) {
        this.upVotes = upVotes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Long getId() {
        return id;
    }
}
