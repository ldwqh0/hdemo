package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "es_return_order_")
public class ReturnOrder {

    @Id
    @Column(name = "id_")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumns(value = {
            @JoinColumn(
                    name = "order_id_",
                    referencedColumnName = "id_",
                    nullable = false,
                    insertable = false,
                    updatable = false
            ),
            @JoinColumn(
                    name = "tenant_id_",
                    referencedColumnName = "tenant_id_",
                    nullable = false,
                    insertable = false,
                    updatable = false
            )}
    )
    private Order order;


    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(
                    name = "tenant_id_",
                    referencedColumnName = "tenant_id_",
                    insertable = false,
                    updatable = false
            ),
            @JoinColumn(
                    name = "customer_id_",
                    referencedColumnName = "id_",
                    insertable = false,
                    updatable = false
            )
    })
    private Customer customer;

    @Column(name = "order_id_", updatable = false, nullable = false)
    private Long orderId;

    @Column(name = "tenant_id_", updatable = false, nullable = false)
    private Long tenantId;

    @Column(name = "customer_id_")
    private Long customerId;

    // getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        this.tenantId = order.getTenantId();
        this.orderId = order.getId();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    public Long getOrderId() {
        return orderId;
    }


    public Long getTenantId() {
        return tenantId;
    }


    public Long getCustomerId() {
        return customerId;
    }

}
