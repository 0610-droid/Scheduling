import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReminderSchedule extends ScheduleItem {
    private LocalDateTime reminderTime;
    private String reminderMessage;
    private boolean isremindSent;

    public ReminderSchedule(

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
            LocalDateTime reminderTime,
            String reminderMessage,

            boolean remindSent, boolean isremindSent) {
        super(id, title, description, priority, taskStatus, notificationType, startDate, endDate, startTime, endTime, createdAt, updatedAt, isCompleted);
        this.reminderTime = reminderTime;
        this.reminderMessage = reminderMessage;
        this.isremindSent = remindSent;
    }

    @Override
    public String getScheduleType() {
        return "알림 일정";
    }

    @Override
    public void notifyUser() {
        System.out.println("알림: " + reminderMessage);
        isremindSent = true;
    }

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("종류: 알림 일정");
        System.out.println("알림 시간: " + reminderTime);
        System.out.println("알림 메시지: " + reminderMessage);
        System.out.println("알림 발송 여부: " + isremindSent);
    }
}
