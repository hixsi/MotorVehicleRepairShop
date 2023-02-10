package com.project.motorVehicleRepairShop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter

@ToString
@Entity
@NoArgsConstructor
@Table(name = "owner")
public class Owner extends BaseEntity {
    @NotBlank
    @Size(min = 5, max = 20, message="Min 1, Max 20")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message="Min 1, Max 20")
    private String lastName;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("owner")
    private List<MotorVehicle> motorVehicleList;
}
