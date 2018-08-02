package ua.com.infopulse.demo.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ProjectStatusDto {
    private BigInteger activeProjects;
    private BigInteger finishedProjects;
}
