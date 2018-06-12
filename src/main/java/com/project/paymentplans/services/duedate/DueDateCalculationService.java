package com.project.paymentplans.services.duedate;

import java.util.Calendar;
import java.util.Date;

public interface DueDateCalculationService {
    Date calculateDueDate(Date date, Calendar cal);
}
