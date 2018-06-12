package com.project.paymentplans.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.paymentplans.model.fee.Fee;
import com.project.paymentplans.model.fee.MonthlyFee;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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

    @OneToMany(targetEntity = MonthlyFee.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "plan")
    @JsonManagedReference
    protected Set<Fee> fees;

    @Override
    public Set<Fee> getFees() {
        return fees;
    }

    public void setFees(Set<Fee> fees) {
        this.fees = fees;
    }

    @Override
    public float getTotalFee() {

        Iterator<Fee> it = fees.iterator();
        float sum = 0;
        while (it.hasNext()){
            Fee current = it.next();
            sum += current.getAmount();
        }
        return sum;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public void setDebtorId(String debtorId) {
        this.debtorId = debtorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}
