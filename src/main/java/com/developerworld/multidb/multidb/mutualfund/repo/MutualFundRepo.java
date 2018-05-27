package com.developerworld.multidb.multidb.mutualfund.repo;

import com.developerworld.multidb.multidb.attendee.domain.FundAttendee;
import com.developerworld.multidb.multidb.mutualfund.domain.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MutualFundRepo extends JpaRepository<FundAttendee, Long> {

     Fund findFundById(Long id);
}
