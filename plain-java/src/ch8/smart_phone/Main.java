package ch8.smart_phone;

public class Main {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();

        myPhone.call("010-1234-5678");
        myPhone.sendMessage("안녕하세요", "홍길동");
        myPhone.connectWiFi("HomeWiFi");

        myPhone.endCall();
        myPhone.disconnectWiFi();
    }
}
