import java.time.LocalDate;
import java.time.LocalDateTime;

public class MeetingSchedule extends ScheduleItem {
    private String location;
    private String participants;
    private String agenda;
    private String host;

    public MeetingSchedule(
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
            String location,
            String participants,
            String agenda,
            String host) {

        super(id, title, description, priority, taskStatus, notificationType, startDate, endDate, startTime, endTime, createdAt, updatedAt, isCompleted);
        this.location = location;
        this.participants = participants;
        this.agenda = agenda;
        this.host = host;
    }

    @Override
    public String getScheduleType() {
        return "회의 일정";
    }

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("종류: 회의 일정");
        System.out.println("장소: " + location);
        System.out.println("참석자: " + participants);
        System.out.println("안건: " + agenda);
        System.out.println("주최자: " + host);
    }
}
