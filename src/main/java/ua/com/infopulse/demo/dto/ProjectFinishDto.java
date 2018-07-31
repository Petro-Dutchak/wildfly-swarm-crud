package ua.com.infopulse.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectFinishDto {
    private long id;
    private LocalDate endDate;
}
