package com.bework.beworktracking.validation.impl;

import com.bework.beworktracking.dto.TrackingDTO;
import com.bework.beworktracking.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrackingInsertValidator implements Validator<TrackingDTO> {

    @Override
    public void validate(TrackingDTO tracking) {

        if (tracking.getTime() == null) {
            throw new RuntimeException("Mời chấm vân lại");
        }

    }

    @Override
    public void validateAll(List<TrackingDTO> trackingDTOS) {
    }

}
