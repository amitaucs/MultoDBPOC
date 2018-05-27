package com.developerworld.multidb.multidb.mutualfund.domain;


import javax.persistence.*;

@Entity
@Table(name = "t_fund")
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "fund")
    private String fund;

    Fund(String foo) {
        this.fund = fund;
    }

    Fund() {
        // Default constructor needed by JPA
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }
}
