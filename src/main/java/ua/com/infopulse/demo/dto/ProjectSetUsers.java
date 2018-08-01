package ua.com.infopulse.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectSetUsers {
    private long projectId;
    private List<Long> users;
}
