package ch11;


public class ShoppingMallV1 {
    public static void main(String[] args) throws Exception {
        try{
            OrderService service = new OrderService();
            System.out.println("---[ CASE 1: 정상 주문 ]---");
            service.processOrder("U001", "P101", 1);
            System.out.println("\n---[ CASE 2: 재고 부족 ]---");
            service.processOrder("U001", "P102", 1);
            System.out.println("\n---[ CASE 3: 데이터 형식 오류 ]---");
            service.processOrder("U001", "P103", 1);
            System.out.println("\n---[ CASE 4: 잔고 부족 ]---");
            service.processOrder("U002", "P101", 1);
        }catch (Exception e){
            System.out.println(e.getClass() + " : " + e.getMessage());
        }finally {
            System.out.println("주문 시도를 종료합니다.");
        }
    }
}
