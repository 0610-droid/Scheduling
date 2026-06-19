public class Main {
    public static void main(String[] args) {
        ScheduleItem manager = new ScheduleItem();

        while (true) {
            System.out.println();
            System.out.println("===== 일정 관리 프로그램 =====");
            System.out.println("1. 일정 등록");
            System.out.println("2. 전체 일정 보기");
            System.out.println("3. ID로 일정 조회");
            System.out.println("4. 일정 수정");
            System.out.println("5. 일정 삭제");
            System.out.println("6. 일정 완료 처리");
            System.out.println("7. 제목으로 검색");
            System.out.println("8. 날짜로 검색");
            System.out.println("9. 우선순위로 검색");
            System.out.println("10. 날짜순 정렬");
            System.out.println("11. 우선순위순 정렬");
            System.out.println("12. 완료여부순 정렬");
            System.out.println("13. 일정 충돌 확인");
            System.out.println("14. 알림 실행");
            System.out.println("0. 종료");

            int choice = manager.getInt("선택: ");

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    manager.addSchedule();
                    break;
                case 2:
                    manager.displayAllSchedules();
                    break;
                case 3:
                    manager.displayScheduleByID();
                    break;
                case 4:
                    manager.updateSchedule();
                    break;
                case 5:
                    manager.deleteSchedule();
                    break;
                case 6:
                    manager.completeSchedule();
                    break;
                case 7:
                    manager.searchByTitle();
                    break;
                case 8:
                    manager.searchByDate();
                    break;
                case 9:
                    manager.searchByPriority();
                    break;
                case 10:
                    manager.sortByDate();
                    break;
                case 11:
                    manager.sortByPriority();
                    break;
                case 12:
                    manager.sortByCompletion();
                    break;
                case 13:
                    manager.checkConflict();
                    break;
                case 14:
                    manager.runNotification();
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
