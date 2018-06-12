package com.project.paymentplans.services.plancreation;

import com.project.paymentplans.model.fee.Fee;
import com.project.paymentplans.model.fee.MonthlyFee;
import com.project.paymentplans.model.plan.PaymentPlan;
import com.project.paymentplans.model.plan.PaymentPlanServiceDTO;
import com.project.paymentplans.model.plan.Plan;
import com.project.paymentplans.repository.PlanRepository;
import com.project.paymentplans.services.duedate.DueDateCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlanCreator implements PlanCreationService{
    private PlanRepository repository;
    private DueDateCalculationService dueDateCalculationService;

    @Autowired
    public PlanCreator(PlanRepository repository, DueDateCalculationService dueDateCalculationService) {
        this.repository = repository;
        this.dueDateCalculationService = dueDateCalculationService;
    }

    public PaymentPlan createPlan(PaymentPlanServiceDTO params){
        Plan plan = new Plan();
        plan.setDebtorId(params.getDebtorId());
        plan.setDebtorName(params.getDebtorName());
        int i = 0;
        Set<Fee> fees = new HashSet<Fee>();
        while (i<params.getFees()){
            MonthlyFee fee = new MonthlyFee();
            fee.setAmount(params.getFeeAmount());
            fee.setDueDate(new Date());
            fee.setPlan(plan);
            fee.setFeeNumber(i);
            fees.add(fee);
            i++;
        }
        plan.setFees(fees);
        repository.saveAndFlush(plan);
        return plan;
    }
}
