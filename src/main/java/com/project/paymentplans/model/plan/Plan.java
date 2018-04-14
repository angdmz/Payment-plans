package com.project.paymentplans.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.paymentplans.model.fee.Fee;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "plans")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Plan implements PaymentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @NotBlank
    protected String debtorName;

    @NotBlank
    protected String debtorId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updatedAt;

    @Override
    public List<Fee> getFees() {
        return null;
    }

    @Override
    public float getTotalFee() {
        return 0;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getDebtorName() {
        return debtorName;
    }

    @Override
    public String getDebtorId() {
        return debtorId;
    }
}
