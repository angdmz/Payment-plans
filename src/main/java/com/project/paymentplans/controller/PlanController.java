package com.project.paymentplans.controller;

import com.project.paymentplans.exception.ResourceNotFoundException;
import com.project.paymentplans.model.plan.PaymentPlanCreationParams;
import com.project.paymentplans.model.plan.Plan;
import com.project.paymentplans.repository.PlanRepository;
import com.project.paymentplans.services.PlanCreationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {

    private PlanRepository repository;

    @GetMapping("/payment_plans")
    public List<Plan> getAllNotes() {
        return repository.findAll();
    }

    // Create a new Plan
    @PostMapping("/payment_plans")
    public Plan createPlan(@Valid @RequestBody PaymentPlanCreationParams params, PlanCreationService service) {
        return service.createPlan(params);
    }

    // Get a Single Note
    @GetMapping("/payment_plans/{id}")
    public Plan getNoteById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }
}
