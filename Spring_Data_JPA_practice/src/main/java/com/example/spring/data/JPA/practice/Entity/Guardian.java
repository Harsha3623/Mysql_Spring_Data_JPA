package com.example.spring.data.JPA.practice.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardianEmail")
        ),
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardianName")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardianMobile")
        )

})
public class Guardian {


    @NotBlank(message = "Guardian name cannot be blank")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Guardian email is required")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Guardian mobile number is required")
    @Column(nullable = false)
    private String mobile;
}
