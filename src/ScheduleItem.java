import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleItem implements Displayable,ScheduleFunction {

    scheduleItem[] schedule = new scheduleItem[100];
    private int size = 0;

    private int id;
    private String title;
    private String description;



    private enum Priority {LOW, MEDIUM, HIGH}

    private enum TaskStatus {TODO, IN_PROGRESS, DONE}

    private enum NotificationType {POPUP, SOUND, MESSAGE}

    private Priority priority;
    private TaskStatus taskStatus;
    private NotificationType notificationType;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean isCompleted;

    private ScheduleItem(
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
            boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.taskStatus = taskStatus;
        this.notificationType = notificationType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isCompleted = isCompleted;
        }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getId() {
        return id;
    }
}


    public void ScheduleItem(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            // 비어있을 경우 예외 처리
            throw new IllegalArgumentException("title은 비워둘 수 없습니다.");
        }
    }       // 검증2

        Random random = new Random();
            // 0 이상 100 이하의 정수 할당
            int progress = random.nextInt(100);
            // 검증8
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String userInput = scanner.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(userInput, formatter);
        LocalDateTime endTime = LocalDateTime.parse(userInput, formatter);

        //검증4
        //LocaldateTime reminderTree = LocalDateTime.parse(userInput,formatter);

        Scanner scanner2 = new Scanner(System.in);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String userInput2 = scanner2.nextLine();
        LocalDate startDate = LocalDate.parse(userInput2, formatter2);
        LocalDate endDate = LocalDate.parse(userInput2, formatter2);
        //Localdate deadline = LocalDate.parse(userInput2, formatter2);
        //검증3


        if (endDate.isbefore(startDate)) {
            System.out.println("종료일은 시작일보다 빠를 수 없습니다.")};

        //if (endDate.isafter(StartDate)) {
          //  System.out.println("종료일은 시작일보다 빠를 수 없습니다.")};
        //검증 //검증6

}
@Override
public void addSchedule() {
    ScheduleFunction.super.addSchedule();
}

@Override
public void displayAllSchedules() {
    ScheduleFunction.super.displayAllSchedules();
}

@Override
public void displayScheduleByID() {
    ScheduleFunction.super.displayScheduleByID();
}

@Override
public void updateSchedule() {
    ScheduleFunction.super.updateSchedule();
}

@Override
public void updateScheduleByID() {
    ScheduleFunction.super.updateScheduleByID();
}

@Override
public void deleteSchedule() {
    ScheduleFunction.super.deleteSchedule();
}

@Override
public void completeSchedule() {
    ScheduleFunction.super.completeSchedule();
}

@Override
public void searchByTitle() {
    ScheduleFunction.super.searchByTitle();
}

@Override
public void searchByDate() {
    ScheduleFunction.super.searchByDate();
}

@Override
public void searchByPriority() {
    ScheduleFunction.super.searchByPriority();
}

@Override
public void sortByDate() {
    ScheduleFunction.super.sortByDate();
}

@Override
public void sortByPriority() {
    ScheduleFunction.super.sortByPriority();
}

@Override
public void sortByCompletion() {
    ScheduleFunction.super.sortByCompletion();
}

@Override
public void CheckConflict() {
    ScheduleFunction.super.CheckConflict();
}

@Override
public void runNotification() {
    ScheduleFunction.super.runNotification();
}



