
package com.bework.beworktracking.repository;

import com.bework.beworktracking.entity.Tracking;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackingRepository  extends PagingAndSortingRepository<Tracking, Long> {

}

