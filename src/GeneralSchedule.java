import java.time.LocalDate;
import java.time.LocalDateTime;

public class GeneralSchedule extends ScheduleItem {
    private String category;
    private String place;
    private String memo;

    public GeneralSchedule(
            int id,
            String title,
            String description,
            Priority priority,
            TaskStatus taskStatus,
            NotificationType notificationType,
            LocalDate startDate,
            LocalDate endDate,
            LocalDateTime startTime,
            LocalDateTime endTime,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            boolean isCompleted,
            String category,
            String place,
            String memo) {
        super(id, title, description, priority, taskStatus, notificationType,
                startDate, endDate, startTime, endTime, createdAt, updatedAt, isCompleted);
        this.category = category;
        this.place = place;
        this.memo = memo;
    }

    @Override
    public String getScheduleType() {
        return "일반 일정";
    }

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("종류: 일반 일정");
        System.out.println("카테고리: " + category);
        System.out.println("장소: " + place);
        System.out.println("메모: " + memo);
    }
}
