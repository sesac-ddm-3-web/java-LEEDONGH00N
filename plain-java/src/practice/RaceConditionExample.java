package practice;

public class RaceConditionExample {

    // 여러 스레드가 공유할 Counter 클래스
    static class Counter {
        private int count = 0;

        // count를 1 증가시키는 메서드
        public synchronized void increment() {
            // 이 연산(count++)은 원자적(atomic)이지 않습니다.
            // 1. 현재 count 값을 읽어온다.
            // 2. 읽어온 값에 1을 더한다.
            // 3. 계산된 결과를 count에 다시 쓴다.
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 공유 객체 생성
        Counter counter = new Counter();

        // 100,000번씩 counter를 증가시킬 두 개의 스레드 생성
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        // 스레드 실행 시작
        thread1.start();
        thread2.start();

        // main 스레드가 thread1과 thread2의 작업이 끝날 때까지 기다림
        thread1.join();
        thread2.join();

        // 최종 결과 출력
        System.out.println("기대 값: 200000");
        System.out.println("실행 결과: " + counter.getCount());
        System.out.println("오차: " + (200000 - counter.getCount()));
    }
}


