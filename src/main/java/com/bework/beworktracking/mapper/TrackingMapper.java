package com.bework.beworktracking.mapper;

import com.bework.beworktracking.entity.Tracking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackingMapper implements RowMapper<Tracking> {

    @Override
    public Tracking mapRow(ResultSet rs, int i) throws SQLException {
        if (rs != null) {
            Tracking tracking = Tracking.builder()
                    .id(rs.getLong("id"))
                    .userId(rs.getLong("user_id"))
                    .username(rs.getString("username"))
                    .fullName(rs.getString("full_name"))
                    .avatar(rs.getString("avatar"))
                    .startTimeFirstShift(rs.getTimestamp("start_time_first_shift"))
                    .endTimeFirstShift(rs.getTimestamp("end_time_first_shift"))
                    .startTimeSecondShift(rs.getTimestamp("start_time_second_shift"))
                    .endTimeSecondShift(rs.getTimestamp("end_time_second_shift"))
                    .build();
            return tracking;
        }
        return null;
    }
}
