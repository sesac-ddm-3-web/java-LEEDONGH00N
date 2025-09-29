package ch9.event;

public class Button {

    private String name;
    private EventListener eventListener;

    public Button(String name) {
        this.name = name;
    }

    public void setListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void click(){
        System.out.println(name + " 버튼이 클릭이 되었습니다.");
        eventListener.onClick();
    }
}
