import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskSchedule extends ScheduleItem {
    private LocalDate deadline;
    private int progress;
    private String assignedTo;

    public TaskSchedule(
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
            LocalDate deadline,
            int progress,
            String assignedTo) {
        super(id, title, description, priority, taskStatus, notificationType,
                startDate, endDate, startTime, endTime, createdAt, updatedAt, isCompleted);
        this.deadline = deadline;
        this.progress = progress;
        this.assignedTo = assignedTo;
    }

    @Override
    public String getScheduleType() {
        return "과제 일정";
    }

    // T
    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("종류: 과제 일정");
        System.out.println("마감일: " + deadline);
        System.out.println("진행률: " + progress + "%");
        System.out.println("담당자: " + assignedTo);
    }
}
