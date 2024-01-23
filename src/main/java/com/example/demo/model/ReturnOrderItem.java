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
                    updatable = false),
            @JoinColumn(name = "tenant_id_",
                    referencedColumnName = "tenant_id_",
                    insertable = false, updatable = false
            )
    },
            foreignKey = @ForeignKey(name = "fk_es_return_order_item_return_order_es_return_order_")
    )
    private ReturnOrder returnOrder;

    @Column(name = "return_order_id_")
    private Long returnOrderId;

    @Column(name = "tenant_id_", updatable = false, nullable = false)
    private Long tenantId;

}
