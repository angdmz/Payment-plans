package com.project.paymentplans.model.plan;

import com.project.paymentplans.model.fee.Fee;

import java.util.List;

public interface PaymentPlan {
    List<Fee> getFees();
    float getTotalFee();
    String getDebtorName();
    String getDebtorId();
    int getId();
}
