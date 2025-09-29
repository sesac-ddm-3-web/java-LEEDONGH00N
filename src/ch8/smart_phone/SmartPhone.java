package ch8.smart_phone;

public class SmartPhone implements Callable, Connectable, Messageable{

    @Override
    public void call(String number) {
        System.out.printf("%s로 전화를 겁니다\n", number);
    }

    @Override
    public void endCall() {
        System.out.println("통화를 종료합니다.");
    }

    @Override
    public void connectWiFi(String network) {
        System.out.printf("%s 네트워크에 연결됐습니다.\n", network);
    }

    @Override
    public void disconnectWiFi() {
        System.out.println("WiFi 연결을 해제했습니다.");
    }

    @Override
    public void sendMessage(String message, String recipient) {
        System.out.printf("%s 메세지를 %s에게 전송했습니다.\n", message, recipient);
    }
}
