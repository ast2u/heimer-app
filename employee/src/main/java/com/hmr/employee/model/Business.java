package com.hmr.employee.model;

import com.hmr.shared.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "business")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String businessName;

    @Column
    private String shortName;

    @Column
    private String address;

    @Column
    private String logo;


}
