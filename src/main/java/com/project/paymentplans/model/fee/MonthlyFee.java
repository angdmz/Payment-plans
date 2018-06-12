package com.project.paymentplans.model.fee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.paymentplans.model.plan.Plan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "fees")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)

public class MonthlyFee implements Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    protected float amount;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dueDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updatedAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdAt;

    @ManyToOne(targetEntity = Plan.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable = false)
    @JsonBackReference
    protected Plan plan;

    @NotNull
    protected int feeNumber;

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public int getFeeNumber() {
        return feeNumber;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setFeeNumber(int feeNumber) {
        this.feeNumber = feeNumber;
    }
}
