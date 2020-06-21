package com.example.demo.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile_data")
@Builder
public class ProfileDao {

    private String name;
    private String contact;
    private String address;
    @Id
    private String email;
    private String facebookLink;
    private String youtubeLink;
    private String instagramLink;
    private String twitterHandle;
}
