package it.ibs.tourismsquare.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "users",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private final String name;
    @NotNull private final String surname;
    @NotNull private final String city;
    @NotNull private final String email;
    @NotNull private final String password;
    @NotNull private final Date  createdAt;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Reminder> reminders;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<EventFavourite> favouriteEvents;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<UserMeta> userMetaList;
    
    @ManyToMany
    @JoinTable(
    		  name = "user_interests", 
    		  joinColumns = @JoinColumn(name = "user_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "event_category_id"))
    private List<EventCategory> interests;
    
    @OneToMany(mappedBy = "userId", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Role> role;
}
