package ch11;

import ch11.exception.DataFormatException;
import ch11.exception.InsufficientBalanceException;
import ch11.exception.OutOfStockException;


public class OrderService {

    private String[] productDb = {"P101:MacBook:2500000:10", "P102:iPhone:1500000:0", "P103:iPad:1000a00:20"};
    private String[] userDb = {"U001:김자바:5000000", "U002:박씨샵:1000000"};

    public void processOrder(String userId, String productId, int quantity) throws Exception {
        Product product = null;
        for (String data : productDb) {
            if (data.startsWith(productId + ":")) {
                try {
                    String[] parts = data.split(":");
                    if (parts.length != 4) {
                        throw new DataFormatException("오류: 상품 데이터 형식에 문제가 있어 처리할 수 없습니다.");
                    }
                    product = new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    break;
                }catch (DataFormatException e){
                    throw new DataFormatException(e.getMessage());
                }catch (NumberFormatException e) {
                    throw new NumberFormatException("오류: 상품 데이터 파싱에 문제가 있어 처리할 수 없습니다.");
                }
            }
        }
        if (product == null){
            throw new IllegalArgumentException("오류: 상품이 존재하지 않습니다.");
        }

        User user = null;
        for (String data : userDb) {
            if (data.startsWith(userId + ":")) {
                String[] parts = data.split(":");
                user = new User(parts[0], parts[1], Integer.parseInt(parts[2]));
                break;
            }
        }
        if (user == null){
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
        if (product.stock < quantity){
            throw new OutOfStockException("오류: 상품의 재고가 부족합니다.");
        }
        if (user.balance < product.price * quantity) {
            throw new InsufficientBalanceException("오류: 사용자 잔고가 부족합니다.");
        }

        product.stock -= quantity;
        user.balance -= product.price * quantity;
        System.out.printf("주문 성공! [%s]님이 [%s] %d개를 구매했습니다. 남은 잔고: %d\n", user.name, product.name, quantity, user.balance);
    }
}

