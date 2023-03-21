public enum TaskRepeatability {

    ONE_TIME_TASK("Однократная задача"),
    DAILY_TASK("Ежедневная задача"),
    WEEKLY_TASK("Еженедельная задача"),
    MONTHLY_TASK("Ежемесячная задача"),
    YEAR_TASK("Ежегодное задача");

    private final String typeOfTask;

    TaskRepeatability(String typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }

    @Override
    public String toString() {
        return "Тип задачи - " + typeOfTask;
    }
}
