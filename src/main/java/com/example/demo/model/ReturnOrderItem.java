package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "es_return_order_item_")
public class ReturnOrderItem {


    @Id
    @Column(name = "id_")
    private Long id;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "return_order_id_",
                    referencedColumnName = "id_",
                    insertable = false,
                    updatable = false
            ),
            @JoinColumn(name = "tenant_id_",
                    referencedColumnName = "tenant_id_",
                    insertable = false,
                    updatable = false
            )
    })
    private ReturnOrder returnOrder;

    @Column(name = "return_order_id_")
    private Long returnOrderId;

    @Column(name = "tenant_id_", updatable = false, nullable = false)
    private Long tenantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReturnOrder getReturnOrder() {
        return returnOrder;
    }

    public void setReturnOrder(ReturnOrder returnOrder) {
        this.returnOrder = returnOrder;
        this.returnOrderId = returnOrder.getId();
    }

    public Long getReturnOrderId() {
        return returnOrderId;
    }

    public Long getTenantId() {
        return tenantId;
    }


}
