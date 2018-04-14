package com.project.paymentplans.model.fee;

import java.util.Date;

public class MonthlyFee implements Fee {

    protected float amount;
    protected Date dueDate;

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }
}
