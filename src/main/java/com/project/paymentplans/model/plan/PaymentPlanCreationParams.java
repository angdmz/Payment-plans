package com.project.paymentplans.model.plan;

import javax.validation.constraints.NotBlank;

public class PaymentPlanCreationParams {

    @NotBlank
    private String debtorName;

    @NotBlank
    private int debtorId;

    @NotBlank   
    private int fees;

    @NotBlank
    private float feeAmount;

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public int getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(int debtorId) {
        this.debtorId = debtorId;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public float getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(int feeAmount) {
        this.feeAmount = feeAmount;
    }
}
