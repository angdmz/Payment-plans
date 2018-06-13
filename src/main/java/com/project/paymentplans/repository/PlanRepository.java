package com.project.paymentplans.repository;

import com.project.paymentplans.model.plan.PaymentPlan;
import com.project.paymentplans.model.plan.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{
}
