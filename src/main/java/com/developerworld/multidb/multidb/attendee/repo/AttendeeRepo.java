package com.developerworld.multidb.multidb.attendee.repo;


import com.developerworld.multidb.multidb.attendee.domain.FundAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepo extends JpaRepository<FundAttendee, Long> {

    FundAttendee findFundAttendeeById(Long id);
}
