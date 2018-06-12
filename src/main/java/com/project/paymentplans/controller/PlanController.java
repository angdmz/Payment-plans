package com.project.paymentplans.controller;

import com.project.paymentplans.exception.ResourceNotFoundException;
import com.project.paymentplans.model.plan.PaymentPlan;
import com.project.paymentplans.model.plan.PaymentPlanServiceDTO;
import com.project.paymentplans.model.plan.Plan;
import com.project.paymentplans.repository.PlanRepository;
import com.project.paymentplans.services.plancreation.PlanCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {

    private PlanCreator service;
    private PlanRepository repository;

    @Autowired
    public PlanController(PlanCreator service, PlanRepository planRepository) {
        this.service = service;
        this.repository = planRepository;
    }

    @GetMapping("/payment_plans")
    public List<Plan> getAllPlans() {
        return repository.findAll();
    }

    // Create a new Plan
    @PostMapping("/payment_plans")
    public PaymentPlan createPlan(@Valid @RequestBody PaymentPlanServiceDTO params) {
        return service.createPlan(params);
    }

    // Get a Single Note
    @GetMapping("/payment_plans/{id}")
    public Plan getPlanById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }
}
