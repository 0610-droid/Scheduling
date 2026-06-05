import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScheduleItem implements Displayable, ScheduleFunction {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //속성 3 검증
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm"); //속성 4검증

    protected ScheduleItem[] schedule = new ScheduleItem[100];
    protected int size = 0;

    protected int id;
    protected String title;
    protected String description;

    public enum Priority {LOW, MEDIUM, HIGH}
    public enum TaskStatus {TODO, IN_PROGRESS, DONE}
    public enum NotificationType {POPUP, SOUND, MESSAGE}

    protected Priority priority;
    protected TaskStatus taskStatus;
    protected NotificationType notificationType;

    protected LocalDate startDate;
    protected LocalDate endDate;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    protected boolean isCompleted;

    public ScheduleItem() {
    }

    public ScheduleItem(
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getId() {
        return id;
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

    @Override
    public void addSchedule() {
        if (size >= schedule.length) {
            System.out.println("더 이상 일정을 등록할 수 없습니다.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("일정 종류를 선택하세요.");
        System.out.println("1 일반 일정");
        System.out.println("2 과제 일정");
        System.out.println("3 회의 일정");
        System.out.println("4 알림 일정");
        System.out.print("선택: ");
        int scheduleType = Integer.parseInt(scanner.nextLine());

        int id = size + 1; //속성1 검증
        System.out.print("제목: ");
        String title = scanner.nextLine();
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 비워둘 수 없습니다."); //속성2 검증
        }

        System.out.print("설명: ");
        String description = scanner.nextLine();

        System.out.print("우선순위(LOW, MEDIUM, HIGH): ");
        Priority priority = Priority.valueOf(scanner.nextLine().trim().toUpperCase()); //속성 7 검증

        System.out.print("상태(TODO, IN_PROGRESS, DONE): ");
        TaskStatus taskStatus = TaskStatus.valueOf(scanner.nextLine().trim().toUpperCase()); // 속성 9 검증

        System.out.print("알림 방식(POPUP, SOUND, MESSAGE): ");
        NotificationType notificationType = NotificationType.valueOf(scanner.nextLine().trim().toUpperCase()); //속성 10 검증

        System.out.print("시작일(yyyy-MM-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);

        System.out.print("종료일(yyyy-MM-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        if (endDate.isBefore(startDate)) {
            System.out.println("종료일은 시작일보다 빠를 수 없습니다.");
            return;
        }

        System.out.print("시작 시간(HH:mm): ");
        LocalTime startClock = LocalTime.parse(scanner.nextLine(), TIME_FORMATTER);

        System.out.print("종료 시간(HH:mm): ");
        LocalTime endClock = LocalTime.parse(scanner.nextLine(), TIME_FORMATTER);

        LocalDateTime startTime = LocalDateTime.of(startDate, startClock);
        LocalDateTime endTime = LocalDateTime.of(endDate, endClock);
        LocalDateTime now = LocalDateTime.now();

        ScheduleItem newSchedule;
        switch (scheduleType) {
            case 1:
                System.out.print("카테고리: ");
                String category = scanner.nextLine();
                System.out.print("장소: ");
                String place = scanner.nextLine();
                System.out.print("메모: ");
                String memo = scanner.nextLine();

                newSchedule = new GeneralSchedule(id, title, description, priority, taskStatus, notificationType,
                        startDate, endDate, startTime, endTime, now, now, false, category, place, memo);
                break;
            case 2:
                System.out.print("마감일(yyyy-MM-dd): ");
                LocalDate deadline = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
                System.out.print("진행률(0-100): ");
                int progress = Integer.parseInt(scanner.nextLine());
                if (progress < 0 || progress > 100) {
                    System.out.println("진행률은 0 이상 100 이하만 가능합니다. 0으로 저장합니다."); //속성8
                    progress = 0;
                }
                System.out.print("담당자: ");
                String assignedTo = scanner.nextLine();

                newSchedule = new TaskSchedule(id, title, description, priority, taskStatus, notificationType,
                        startDate, endDate, startTime, endTime, now, now, false, deadline, progress, assignedTo);
                break;
            case 3:
                System.out.print("회의 장소: ");
                String location = scanner.nextLine();
                System.out.print("참석자: ");
                String participants = scanner.nextLine();
                System.out.print("안건: ");
                String agenda = scanner.nextLine();
                System.out.print("주최자: ");
                String host = scanner.nextLine();

                newSchedule = new MeetingSchedule(id, title, description, priority, taskStatus, notificationType,
                        startDate, endDate, startTime, endTime, now, now, false, location, participants, agenda, host);
                break;
            case 4:
                System.out.print("알림 날짜(yyyy-MM-dd): ");
                LocalDate reminderDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
                System.out.print("알림 시간(HH:mm): ");
                LocalTime reminderClock = LocalTime.parse(scanner.nextLine(), TIME_FORMATTER);
                System.out.print("알림 메시지: ");
                String reminderMessage = scanner.nextLine();

                newSchedule = new ReminderSchedule(id, title, description, priority, taskStatus, notificationType,
                        startDate, endDate, startTime, endTime, now, now, false,
                        LocalDateTime.of(reminderDate, reminderClock), reminderMessage, false);
                break;
            default:
                System.out.println("잘못된 일정 종류입니다.");
                return;
        }

        schedule[size] = newSchedule;
        size++;
        System.out.println("일정이 등록되었습니다. ID: " + id);
    }

    @Override
    public void displayAllSchedules() {
        if (size == 0) {
            System.out.println("등록된 일정이 없습니다.");
            return;
        }

        for (int i = 0; i < size; i++) {
            schedule[i].displayinfo();
            System.out.println();
        }
    }

    @Override
    public void displayScheduleByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 일정 ID: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            if (schedule[i].id == inputId) {
                schedule[i].displayinfo();
                return;
            }
        }
        System.out.println("해당 ID의 일정이 없습니다.");
    }

    @Override
    public void updateSchedule() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수정할 일정 ID: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        ScheduleItem target = null;
        for (int i = 0; i < size; i++) {
            if (schedule[i].id == inputId) {
                target = schedule[i];
                break;
            }
        }

        if (target == null) {
            System.out.println("해당 ID의 일정이 없습니다.");
            return;
        }

        System.out.println("수정할 항목을 선택하세요.");
        System.out.println("1. 제목  2. 설명  3. 우선순위  4. 시작일  5. 종료일  6. 시작시간  7. 종료시간");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("새 제목: ");
                target.title = scanner.nextLine();
                break;
            case 2:
                System.out.print("새 설명: ");
                target.description = scanner.nextLine();
                break;
            case 3:
                System.out.print("우선순위 (LOW/MEDIUM/HIGH): ");
                target.priority = Priority.valueOf(scanner.nextLine().trim().toUpperCase());
                break;
            case 4:
                System.out.print("시작일 (yyyy-MM-dd): ");
                target.startDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
                break;
            case 5:
                System.out.print("종료일 (yyyy-MM-dd): ");
                LocalDate newEndDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
                if (newEndDate.isBefore(target.startDate)) {
                    System.out.println("종료일은 시작일보다 빠를 수 없습니다.");
                    return;
                }
                target.endDate = newEndDate;
                break;
            case 6:
                System.out.print("시작시간 (HH:mm): ");
                target.startTime = LocalDateTime.of(target.startDate, LocalTime.parse(scanner.nextLine(), TIME_FORMATTER));
                break;
            case 7:
                System.out.print("종료시간 (HH:mm): ");
                target.endTime = LocalDateTime.of(target.endDate, LocalTime.parse(scanner.nextLine(), TIME_FORMATTER));
                break;
        }

        target.updatedAt = LocalDateTime.now();
        System.out.println("수정되었습니다.");
    }

    @Override
    public void deleteSchedule() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 일정 ID: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            if (schedule[i].id == inputId) {
                for (int j = i; j < size - 1; j++) {
                    schedule[j] = schedule[j + 1];
                }
                schedule[size - 1] = null;
                size--;
                System.out.println("삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 일정이 없습니다.");
    }


    @Override
    public void completeSchedule() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("완료 처리할 일정 ID: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            if (schedule[i].id == inputId) {
                schedule[i].markAsCompleted();
                schedule[i].updatedAt = LocalDateTime.now();
                System.out.println("완료 처리되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 일정이 없습니다.");
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public void searchByTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 제목: ");
        String keyword = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (schedule[i].title.contains(keyword)) {
                schedule[i].displayinfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) System.out.println("검색 결과가 없습니다.");
    }

    @Override
    public void searchByDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 날짜 (yyyy-MM-dd): ");
        LocalDate targetDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (schedule[i].startDate.equals(targetDate)) {
                schedule[i].displayinfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) System.out.println("검색 결과가 없습니다.");
    }

    @Override
    public void searchByPriority() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 우선순위 (LOW/MEDIUM/HIGH): ");
        Priority targetPriority = Priority.valueOf(scanner.nextLine().trim().toUpperCase());

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (schedule[i].priority == targetPriority) {
                schedule[i].displayinfo();
                System.out.println();
                found = true;
            }
        }
        if (!found) System.out.println("검색 결과가 없습니다.");
    }

    @Override
    public void sortByDate() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                boolean swap;
                int dateCompare = schedule[j].startDate.compareTo(schedule[j + 1].startDate);
                if (dateCompare > 0) {
                    swap = true;
                } else if (dateCompare == 0) {
                    swap = schedule[j].startTime.compareTo(schedule[j + 1].startTime) > 0;
                } else {
                    swap = false;
                }
                if (swap) {
                    ScheduleItem temp = schedule[j];
                    schedule[j] = schedule[j + 1];
                    schedule[j + 1] = temp;
                }
            }
        }
        displayAllSchedules();
    }

    @Override
    public void sortByPriority() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (schedule[j].priority.ordinal() < schedule[j + 1].priority.ordinal()) {
                    ScheduleItem temp = schedule[j];
                    schedule[j] = schedule[j + 1];
                    schedule[j + 1] = temp;
                }
            }
        }
        displayAllSchedules();
    }

    @Override
    public void sortByCompletion() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (schedule[j].isCompleted && !schedule[j + 1].isCompleted) {
                    ScheduleItem temp = schedule[j];
                    schedule[j] = schedule[j + 1];
                    schedule[j + 1] = temp;
                }
            }
        }
        displayAllSchedules();
    }

    @Override
    public void checkConflict() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("시작일 (yyyy-MM-dd): ");
        LocalDate newStartDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        System.out.print("시작시간 (HH:mm): ");
        LocalDateTime newStartTime = LocalDateTime.of(newStartDate, LocalTime.parse(scanner.nextLine(), TIME_FORMATTER));
        System.out.print("종료일 (yyyy-MM-dd): ");
        LocalDate newEndDate = LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
        System.out.print("종료시간 (HH:mm): ");
        LocalDateTime newEndTime = LocalDateTime.of(newEndDate, LocalTime.parse(scanner.nextLine(), TIME_FORMATTER));

        boolean conflict = false;
        for (int i = 0; i < size; i++) {
            if (newStartTime.isBefore(schedule[i].endTime) && newEndTime.isAfter(schedule[i].startTime)) {
                System.out.println("충돌: " + schedule[i].title);
                conflict = true;
            }
        }
        if (!conflict) System.out.println("충돌하는 일정이 없습니다.");
    }

    @Override
    public void runNotification() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("알림 실행할 일정 ID: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            if (schedule[i].id == inputId) {
                schedule[i].notifyUser();
                return;
            }
        }
        System.out.println("해당 ID의 일정이 없습니다.");
    }

    public void notifyUser() {
    }

    @Override
    public void displayinfo() { //BIG6
        System.out.println("ID: " + id);
        System.out.println("제목: " + title);
        System.out.println("설명: " + description);
        System.out.println("우선순위: " + priority);
        System.out.println("상태: " + taskStatus);
        System.out.println("알림 방식: " + notificationType);
        System.out.println("시작일: " + startDate);
        System.out.println("종료일: " + endDate);
        System.out.println("시작 시간: " + startTime);
        System.out.println("종료 시간: " + endTime);
        System.out.println("완료 여부: " + isCompleted);
    }
}
