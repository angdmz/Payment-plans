package com.project.paymentplans.services.plancreation;

import com.project.paymentplans.model.plan.PaymentPlan;
import com.project.paymentplans.model.plan.PaymentPlanServiceDTO;

public interface PlanCreationService {
    PaymentPlan createPlan(PaymentPlanServiceDTO params);
}
