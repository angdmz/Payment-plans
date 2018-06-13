package com.project.paymentplans.controller;

import com.project.paymentplans.exception.ResourceNotFoundException;
import com.project.paymentplans.model.plan.PaymentPlan;
import com.project.paymentplans.model.plan.PaymentPlanServiceDTO;
import com.project.paymentplans.model.plan.Plan;
import com.project.paymentplans.repository.PlanRepository;
import com.project.paymentplans.services.plancreation.PlanCreationService;
import com.project.paymentplans.services.plancreation.PlanCreator;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlanController {

    private PlanCreationService service;
    private PlanRepository repository;
    private Logger logger;

    @Autowired
    public PlanController(Logger logger, PlanCreationService service, PlanRepository planRepository) {
        this.service = service;
        this.logger = logger;
        this.repository = planRepository;
    }

    @GetMapping("/payment_plans")
    public Page<Plan> getAllPlans(Pageable p){
        return repository.findAll(p);
    }

    // Create a new Plan
    @PostMapping("/payment_plans")
    public PaymentPlan createPlan(@Valid @RequestBody PaymentPlanServiceDTO params) {
        logger.info("Creating payment plan");
        return service.createPlan(params);
    }

    // Get a Single Note
    @GetMapping("/payment_plans/{id}")
    public PaymentPlan getPlanById(@PathVariable(value = "id") Long id) {
        logger.info("Retrieving plan id: " + id.toString());
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }
}
