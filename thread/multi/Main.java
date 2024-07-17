package thread.multi;

public class Main {
    public static void main(String[] args) {
        // 병렬 처리됨 = > 순서가 순차적이지 않음, 멀티스레드 방식으로 동시에 프린트를 찍는다 두 개의 스레드가 번갈아가면서 작업함
        // 우리는 걸리는 시간이나 동작을 예측할 수 없다. 매번 다르다
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("$");
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("*");
            }
        };

        Thread thread1 = new Thread(task);
        thread1.setName("thread1");

        Thread thread2 = new Thread(task2);
        thread2.setName("thread2");

        thread1.start();
        thread2.start();

    }
}
