package java_project.data;

public enum TaskType {

    CALCULATE(2), LIST(1), EXIT(-1);


    private int code;

    TaskType(int code) {
        this.code = code;
    }

    public static TaskType from(int input) {
        for (TaskType type : values()) {
            if (type.code == input) return type;
        }
        throw new IllegalArgumentException("잘못된 선택입니다: " + input);
    }
}
