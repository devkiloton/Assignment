package com.grocery.payaut.dto;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.grocery.payaut.enumerator.DiscountUnits;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class DiscountDTO {
    @NotNull
    private Long discountId;
    private DiscountUnits discountUnit;
    private Boolean isConstantSlab;
    private List<DiscountSlabDTO> discountSlabs;
}
