package com.project.paymentplans.services;

import com.project.paymentplans.model.plan.PaymentPlanCreationParams;
import com.project.paymentplans.model.plan.Plan;
import com.project.paymentplans.repository.PlanRepository;

public class PlanCreationService {

    private PlanRepository repository;

    public Plan createPlan(PaymentPlanCreationParams params){
        return new Plan();
    }
}
