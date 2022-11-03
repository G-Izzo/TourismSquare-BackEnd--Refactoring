package it.ibs.tourismsquare.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String role;
    private String city;
    private Date createdAt;
    private String password;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Reminder> reminders;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<EventFavourite> favouriteEvents;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<UserMeta> userMetaList;
}
