package com.bework.beworktracking.repository;

import com.bework.beworktracking.common.constants.Consts;
import com.bework.beworktracking.dto.TrackingDTO;
import com.bework.beworktracking.entity.Tracking;
import com.bework.beworktracking.mapper.TrackingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class TrackingRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public TrackingDTO insertTracking(TrackingDTO trackingDto) {
        long insertTime = trackingDto.getTime();

         /*boolean t9 = Consts.Tracking.TIME_IN_FIRST_2 > 0;
        boolean t1 = insertTime - Consts.TRACKING_TIME_IN_FIRST_1 > 0; //t1= thời gian chấm vân so với thời gian cố định đầu vào ca 1 từ 7h
        boolean t2 = Consts.TRACKING_TIME_IN_FIRST_2 - insertTime > 0; //t2= thời gian cố định đầu vào ca 1 từ 9h lùi lại so với thời gian chấm vân
        boolean t3 = insertTime - Consts.TRACKING_TIME_IN_SECOND_1 > 0; //t3= thời gian chấm vân so với thời gian cố định đầu vào ca 2 từ 12h15'
        boolean t4 = Consts.TRACKING_TIME_IN_SECOND_2 - insertTime > 0; //t4= thời gian cố định đầu vào ca 2 từ 15h lùi lại so với thời gian chấm vân
        boolean t5 = insertTime - Consts.TRACKING_TIME_OUT_FIRST_1 > 0; //t5= thời gian chấm vân so với thời gian cố định đầu ra ca 1 từ 11h30'
        boolean t6 = Consts.TRACKING_TIME_OUT_FIRST_2 - insertTime > 0; //t6= thời gian cố định đầu ra ca 1 từ 12h15' lùi lại so với thời gian chấm vân
        boolean t7 = insertTime - Consts.TRACKING_TIME_OUT_SECOND_1 > 0; //t7= thời gian chấm vân so với thời gian cố định đầu ra ca 2 từ 15h10'
        boolean t8 = Consts.TRACKING_TIME_OUT_SECOND_2 - insertTime > 0; //t8= thời gian cố định đầu ra ca 2 từ 20h00' lùi lại so với thời gian chấm vân

*/
        boolean t1 = insertTime - Consts.Tracking.TIME_IN_FIRST_1 > 0; //t1= thời gian chấm vân so với thời gian cố định đầu vào ca 1 từ 7h
        boolean t2 = Consts.Tracking.TIME_IN_FIRST_2 - insertTime > 0; //t2= thời gian cố định đầu vào ca 1 từ 9h lùi lại so với thời gian chấm vân
        boolean t3 = insertTime - Consts.Tracking.TIME_IN_SECOND_1 > 0; //t3= thời gian chấm vân so với thời gian cố định đầu vào ca 2 từ 12h15'
        boolean t4 = Consts.Tracking.TIME_IN_SECOND_2 - insertTime > 0; //t4= thời gian cố định đầu vào ca 2 từ 15h lùi lại so với thời gian chấm vân
        boolean t5 = insertTime - Consts.Tracking.TIME_OUT_FIRST_1 > 0; //t5= thời gian chấm vân so với thời gian cố định đầu ra ca 1 từ 11h30'
        boolean t6 = Consts.Tracking.TIME_OUT_FIRST_2 - insertTime > 0; //t6= thời gian cố định đầu ra ca 1 từ 12h15' lùi lại so với thời gian chấm vân
        boolean t7 = insertTime - Consts.Tracking.TIME_OUT_SECOND_1 > 0; //t7= thời gian chấm vân so với thời gian cố định đầu ra ca 2 từ 15h10'
        boolean t8 = Consts.Tracking.TIME_OUT_SECOND_2 - insertTime > 0; //t8= thời gian cố định đầu ra ca 2 từ 20h00' lùi lại so với thời gian chấm vân*/

        try {
            String sql = "SELECT * FROM tracking WHERE user_id = :userId AND ((DATE(NOW()) = DATE(start_time_first_shift)) OR (DATE(NOW()) = DATE(end_time_first_shift)) OR (DATE(NOW()) = DATE(start_time_second_shift))) ";
            MapSqlParameterSource param = new MapSqlParameterSource();
            param.addValue("userId", trackingDto.getUserId());
            Tracking tracking = jdbcTemplate.queryForObject(sql, param, new TrackingMapper());
            if (tracking.getStartTimeFirstShift() == null) {
                if (tracking.getEndTimeFirstShift() != null) {
                    if (tracking.getStartTimeSecondShift() == null) {
                        String commonSql = "UPDATE tracking SET "+
                                " start_time_second_shift = IF(:startTimeSecondShift is not null, :startTimeSecondShift, start_time_second_shift)" +
                                ", end_time_second_shift = IF(:endTimeSecondShift is not null, :endTimeSecondShift, end_time_second_shift)" +
                                " where user_id = :userId AND DATE(NOW()) = DATE(start_time_first_shift) ";
                        MapSqlParameterSource commonMap = new MapSqlParameterSource();
                        commonMap.addValue("userId", trackingDto.getUserId());
                        commonMap.addValue("startTimeSecondShift",null);
                        commonMap.addValue("endTimeSecondShift",null);
                        if (t3 && t4) {
                            long timeBefore = tracking.getEndTimeFirstShift().getTime();
                            boolean timeAccept = insertTime - timeBefore >= Consts.Tracking.ACCEPT_TIME;
                            if (!timeAccept) return null;
                            commonMap.addValue("startTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        }
                        if (t7 && t8) {
                            commonMap.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        }
                        jdbcTemplate.update(commonSql, commonMap);
                        return trackingDto;
                    } else if (tracking.getStartTimeSecondShift() != null) {
                        long timeBefore = tracking.getStartTimeSecondShift().getTime();
                        boolean timeAccept = insertTime - timeBefore >= Consts.Tracking.ACCEPT_TIME;
                        if (!timeAccept) return null;
                        String sqlUpdateEndSecond = "UPDATE tracking SET end_time_second_shift = :endTimeSecondShift where user_id = :userId AND DATE(NOW()) = DATE(start_time_second_shift) ";
                        MapSqlParameterSource paramEndSecond = new MapSqlParameterSource();
                        paramEndSecond.addValue("userId", trackingDto.getUserId());
                        paramEndSecond.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        jdbcTemplate.update(sqlUpdateEndSecond, paramEndSecond);
                        return trackingDto;
                    }
                } else if (tracking.getEndTimeFirstShift() == null && tracking.getStartTimeSecondShift() != null) {
                    long timeBefore = tracking.getStartTimeSecondShift().getTime();
                    boolean timeAccept = insertTime - timeBefore >= Consts.Tracking.ACCEPT_TIME;
                    if (!timeAccept) return null;
                    String sqlUpdateEndSecond = "UPDATE tracking SET end_time_second_shift = :endTimeSecondShift where user_id = :userId AND DATE(NOW()) = DATE(start_time_second_shift) ";
                    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
                    parameterSource.addValue("userId", trackingDto.getUserId());
                    parameterSource.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
                    jdbcTemplate.update(sqlUpdateEndSecond, parameterSource);
                    return trackingDto;
                }
            } else if (tracking.getStartTimeFirstShift() != null) {
                if (tracking.getEndTimeFirstShift() == null) {
                    String commonSql = " UPDATE tracking SET  " +
                            "end_time_first_shift = IF(:endTimeFirstShift is not null, :endTimeFirstShift, end_time_first_shift)" +
                            ", start_time_second_shift = IF(:startTimeSecondShift is not null, :startTimeSecondShift, start_time_second_shift)" +
                            ", end_time_second_shift = IF(:endTimeSecondShift is not null, :endTimeSecondShift, end_time_second_shift) " +
                            "where user_id = :userId AND DATE(NOW()) = DATE(start_time_first_shift) ";
                    MapSqlParameterSource commonMap = new MapSqlParameterSource();
                    commonMap.addValue("userId", trackingDto.getUserId());
                    commonMap.addValue("endTimeFirstShift", null);
                    commonMap.addValue("startTimeSecondShift", null);
                    commonMap.addValue("endTimeSecondShift", null);
                    if (t5 && t6) {
                        long timeBefore = tracking.getStartTimeFirstShift().getTime();
                        boolean timeAccept = insertTime - timeBefore > Consts.Tracking.ACCEPT_TIME;
                        if (!timeAccept) return null;
                        commonMap.addValue("endTimeFirstShift", new Timestamp(trackingDto.getTime()));
                    }
                    if (t3 && t4) {
                        long timeBefore = tracking.getStartTimeSecondShift().getTime();
                        boolean timeAccept = insertTime - timeBefore > Consts.Tracking.ACCEPT_TIME;
                        if (!timeAccept) return null;
                        commonMap.addValue("startTimeSecondShift", new Timestamp(trackingDto.getTime()));
                    }
                    if (tracking.getEndTimeFirstShift() == null && tracking.getStartTimeSecondShift() != null) {
                        if (t7 && t8) {
                            long timeBefore = tracking.getStartTimeSecondShift().getTime();
                            boolean timeAccept = insertTime - timeBefore > Consts.Tracking.ACCEPT_TIME;
                            if (!timeAccept) return null;
                            commonMap.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        }
                    }
                    jdbcTemplate.update(commonSql, commonMap);
                    return trackingDto;
                } else if (tracking.getEndTimeFirstShift() != null) {
                    if (tracking.getStartTimeSecondShift() == null) {
                        String commonSql = "UPDATE tracking SET " +
                                " start_time_second_shift = IF(:startTimeSecondShift is not null, :startTimeSecondShift, start_time_second_shift)" +
                                ", end_time_second_shift = IF(:endTimeSecondShift is not null, :endTimeSecondShift, end_time_second_shift) " +
                                "where user_id = :userId AND DATE(NOW()) = DATE(start_time_first_shift) ";
                        MapSqlParameterSource commonMap = new MapSqlParameterSource();
                        commonMap.addValue("userId", trackingDto.getUserId());
                        commonMap.addValue("startTimeSecondShift", null);
                        commonMap.addValue("endTimeSecondShift",null);
                        if (t3 && t4) {
                            long timeBefore = tracking.getEndTimeFirstShift().getTime();
                            boolean timeAccept = insertTime - timeBefore >= Consts.Tracking.ACCEPT_TIME;
                            if (!timeAccept) return null;
                            commonMap.addValue("startTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        } else if (t7 & t8) {
                            commonMap.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        }
                        jdbcTemplate.update(commonSql, commonMap);
                        return trackingDto;
                    }
                    if (tracking.getStartTimeSecondShift() != null) {
                        long timeBefore = tracking.getStartTimeFirstShift().getTime();
                        boolean timeAccept = insertTime - timeBefore >= Consts.Tracking.ACCEPT_TIME;
                        if (!timeAccept) return null;
                        String sqlUpdateEndSecond = "UPDATE tracking SET end_time_second_shift = :endTimeSecondShift where user_id = :userId AND DATE(NOW()) = DATE(start_time_first_shift) ";
                        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
                        mapSqlParameterSource.addValue("userId", trackingDto.getUserId());
                        mapSqlParameterSource.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
                        jdbcTemplate.update(sqlUpdateEndSecond, mapSqlParameterSource);
                        return trackingDto;
                    }
                }
            }
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User khong ton tai");
            System.out.println("Thuc hien insert moi");
            String sqlInsert = "INSERT INTO tracking (user_id, username, full_name, avatar, start_time_first_shift, end_time_first_shift, start_time_second_shift, end_time_second_shift) " +
                    "VALUES ( :userId, :username, :fullName, :avatar, :startTimeFirstShift, :endTimeFirstShift, :startTimeSecondShift, :endTimeSecondShift)";
            MapSqlParameterSource newCommonMap = new MapSqlParameterSource();
            newCommonMap.addValue("userId", trackingDto.getUserId());
            newCommonMap.addValue("username", trackingDto.getUsername());
            newCommonMap.addValue("fullName", trackingDto.getFullName());
            newCommonMap.addValue("avatar", trackingDto.getAvatar());
            newCommonMap.addValue("startTimeFirstShift", null);
            newCommonMap.addValue("endTimeFirstShift", null);
            newCommonMap.addValue("startTimeSecondShift", null);
            newCommonMap.addValue("endTimeSecondShift", null);
            if (t1 && t2) {
                newCommonMap.addValue("startTimeFirstShift", new Timestamp(trackingDto.getTime()));
            } else if (t3 && t4) {
                newCommonMap.addValue("startTimeSecondShift", new Timestamp(trackingDto.getTime()));
            } else if (t5 && t6) {
                newCommonMap.addValue("endTimeFirstShift", new Timestamp(trackingDto.getTime()));
            } else if (t7 && t8) {
                newCommonMap.addValue("endTimeSecondShift", new Timestamp(trackingDto.getTime()));
            }
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(sqlInsert, newCommonMap, keyHolder);
            trackingDto.setId(keyHolder.getKey().longValue());
            return trackingDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
