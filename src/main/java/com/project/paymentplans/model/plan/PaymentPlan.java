package com.project.paymentplans.model.plan;

import com.project.paymentplans.model.fee.Fee;

import java.util.List;
import java.util.Set;

public interface PaymentPlan {
    Set<Fee> getFees();
    float getTotalFee();
    String getDebtorName();
    String getDebtorId();
    int getId();
}
