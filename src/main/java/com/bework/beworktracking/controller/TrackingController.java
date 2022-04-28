package com.bework.beworktracking.controller;

import com.bework.beworktracking.dto.TrackingDTO;
import com.bework.beworktracking.entity.Tracking;
import com.bework.beworktracking.service.TrackingService;
import com.bework.beworktracking.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/tracking")
public class TrackingController {


    private TrackingService trackingService;
    private Validator<TrackingDTO> trackingValidatorInsert;

    @Autowired
    public TrackingController(TrackingService trackingService, Validator<TrackingDTO> trackingValidatorInsert) {
        this.trackingService = trackingService;
        this.trackingValidatorInsert = trackingValidatorInsert;
    }

    /*
    private Validator<Tracking> trackingValidatorInsert;

    private Validator<Tracking> trackingValidatorUpdate;

    private BaseService baseService;

    private static final ObjectMapper ob = new ObjectMapper();

    @Autowired
    public TrackingController(@Qualifier("trackingUpdateValidator") Validator<Tracking> trackingValidatorUpdate,
                              @Qualifier("trackingInsertValidator") Validator<Tracking> trackingValidatorInsert,
                              TrackingService trackingService) {
        this.trackingValidatorInsert = trackingValidatorInsert;
        this.trackingValidatorUpdate = trackingValidatorUpdate;
        this.trackingService = trackingService;
    }

    @PostMapping("")
    public ResponseEntity insertTracking(@RequestBody Tracking tracking) {
        try {

            trackingValidatorInsert.validate(Tracking);
            Tracking savedTracking = trackingService.save(tracking);
            return ResponseEntity.ok(savedTracking);
        } catch (Exception e) {
            //todo -example :haivn Cần phải tạo common response
            e.printStackTrace();
            Map<String, Object> res = new HashMap<>();
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    //quyen admin
    @PutMapping("")//   /{trackingId}
    public ResponseEntity updateTracking(@RequestBody Tracking tracking) {
        try {
            trackingValidatorUpdate.validate(tracking);
            Tracking savedTracking = trackingService.update(tracking);
            return ResponseEntity.ok(savedTracking);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> res = new HashMap<>();
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
  @RequestMapping(value = "invite/{inviteCode}/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String inviteCode) {
        try {



    public ResponseEntity<?> getTracking(@PathVariable Long userId)
            {


            }
        }

    {
        return  null;
    }
   @PostMapping("/{userId}")
    public ResponseEntity<?> getTracking(@PathVariable Long userId)
    {
        return ResponseEntity.ok();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTracking(@PathVariable Long id) {
        try {
            trackingService.delete(id);
            // return ResponseEntity.ok(trackingService.delete(deleteTracking(id)));

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> res = new HashMap<>();
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    return  null;
    }*/

    @PostMapping("")
    public ResponseEntity insertTracking1(@RequestBody TrackingDTO trackingDto) {
        try {
            trackingValidatorInsert.validate(trackingDto);
            TrackingDTO savedTrackingDto = trackingService.insert(trackingDto);
            return ResponseEntity.ok(savedTrackingDto);
        } catch (Exception e) {
            //todo -example :haivn Cần phải tạo common response
            e.printStackTrace();
            Map<String, Object> res = new HashMap<>();
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
    @GetMapping
    public ResponseEntity<List<Tracking>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "userId") String sortBy)
    {

        List<Tracking> list = trackingService.getAllTracking(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Tracking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}

