package com.bework.beworktracking.service;

import com.bework.beworktracking.dto.TrackingDTO;
import com.bework.beworktracking.entity.Tracking;
import com.bework.beworktracking.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService extends BaseService {

    private BaseService baseService;
    private TrackingRepository trackingRepository;

    @Autowired
    public TrackingService(BaseService baseService, TrackingRepository trackingRepository) {
        this.baseService = baseService;
        this.trackingRepository = trackingRepository;
    }

    public TrackingDTO insert(TrackingDTO trackingDto) {
        TrackingDTO saved = trackingRepository.insertTracking(trackingDto);
        return saved;
    }

    public List<Tracking> getAllTracking(Integer pageNo, Integer pageSize, String sortBy) {

        return  null;
    }
}
