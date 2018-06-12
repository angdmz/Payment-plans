package com.project.paymentplans.model.fee;

import java.util.Date;

public interface Fee {
    float getAmount();
    int getFeeNumber();
    Date getDueDate();
}
