package ua.com.infopulse.demo.dto;

    import lombok.Data;

@Data
public class UserStatusDto {
    private long activeStatus;
    private long inActiveStatus;
    private long deletedStatus;
}
