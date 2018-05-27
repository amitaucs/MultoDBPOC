package com.developerworld.multidb.multidb.attendee.domain;


import javax.persistence.*;

@Entity
@Table(name = "t_attendee")
public class FundAttendee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "fund_attendee")
    private String attendee;

    FundAttendee(String attendee) {
        this.attendee = attendee;
    }

    FundAttendee() {
        // Default constructor needed by JPA
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendee() {
        return attendee;
    }

    public void setAttendee(String attendee) {
        this.attendee = attendee;
    }
}
