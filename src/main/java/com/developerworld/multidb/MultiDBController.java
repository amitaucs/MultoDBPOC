package com.developerworld.multidb;


import com.developerworld.multidb.multidb.attendee.domain.FundAttendee;
import com.developerworld.multidb.multidb.attendee.repo.AttendeeRepo;
import com.developerworld.multidb.multidb.mutualfund.domain.Fund;
import com.developerworld.multidb.multidb.mutualfund.repo.MutualFundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiDBController {

    @Autowired
    AttendeeRepo attendeeRepo;
    @Autowired
    MutualFundRepo mfRepo;


    @RequestMapping("/multidb/{id}")
    public String fooBar(@PathVariable("id") Long id) {
        FundAttendee attendee = attendeeRepo.findFundAttendeeById(id);
        Fund fund = mfRepo.findFundById(id);

        return attendee.getAttendee() + " " +fund.getFund();
    }

}
