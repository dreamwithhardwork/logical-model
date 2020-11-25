package org.models.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.internal.connection.Time;
import lombok.Getter;
import lombok.Setter;
import org.models.core.enums.BookingStatus;
import org.models.core.enums.BookingType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class Booking {
    @Email
    private String email;
    private String mobile;
    @NotNull
    private BookingType bookingType;
    @JsonIgnore
    private Date bookingDate = new Date();
    private Date scheduledDate;
    private Time time;
    private BookingStatus status;
    private String feedback;
}
