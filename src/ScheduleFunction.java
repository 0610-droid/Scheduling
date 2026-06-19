public interface ScheduleFunction {
    void addSchedule();

    void displayAllSchedules();

    void displayScheduleByID();

    void updateSchedule();

    void deleteSchedule();

    void completeSchedule();

    void searchByTitle();

    void searchByDate();

    void searchByPriority();

    void sortByDate();

    void sortByPriority();

    void sortByCompletion();

    void checkConflict();

    void runNotification();
}
