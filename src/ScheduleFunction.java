public interface ScheduleFunction {
    public void addSchedule();

    public void displayAllSchedules();

    public void displayScheduleByID();

    public void updateSchedule();

    public void deleteSchedule();

    public void completeSchedule();

    public void searchByTitle();

    public void searchByDate();

    public void searchByPriority();

    public void sortByDate();

    public void sortByPriority();

    public void sortByCompletion();

    public void checkConflict();

    public void runNotification();
}
