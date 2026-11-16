package org.example.bookshelf.Book.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.bookshelf.Common.Validation.ValidPublishedYear;

@Getter
@Setter
public class CreateBookRequest {
     @NotBlank
    private String title;
    @NotNull(message = "Published year is required")
    @Min(value = 1000, message = "Published year must be at least 1000")
    @ValidPublishedYear
    private Integer publishedYear;
    @NotNull
    private Long categoryId;

}
