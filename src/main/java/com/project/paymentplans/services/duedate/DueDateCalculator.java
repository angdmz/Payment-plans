package com.project.paymentplans.services.duedate;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class DueDateCalculator implements DueDateCalculationService {

    public Date calculateDueDate(Date date, Calendar myCal){
        myCal.setTime(date);
        myCal.add(Calendar.MONTH, +1);
        return myCal.getTime();
    }
}
