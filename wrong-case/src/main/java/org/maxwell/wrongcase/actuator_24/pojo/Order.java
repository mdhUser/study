package org.maxwell.wrongcase.actuator_24.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private Long id;
    private Long userId;
    private Long merchantId;
}
