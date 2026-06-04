public class ReminderSchedule implements Displayable {
    private final String reminderSchdule;
    private final String reminderMessage;
    private final String notificationType;
    private final String isRemindSent;

    public static void main(String[] args) {

    }
    public ReminderSchedule(
            String reminderSchedule, String reminderMessage, String notificationType, String isRemindeSent){
        this.reminderSchdule = reminderSchedule;
        this.reminderMessage = reminderMessage;
        this.notificationType = notificationType;
        this.isRemindSent = isRemindeSent;
    }

    @Override
    public void displayinfo() {

    }
}
