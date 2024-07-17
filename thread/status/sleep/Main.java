package thread.status.sleep;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(2000); // TIMED_WAITING
            } catch (InterruptedException e) { // 위험한 익셉션인데도 핸들링을 안했다.
                e.printStackTrace();
            }

            System.out.println("task : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread"); // NEW
        thread.start(); // RUNNABLE

        try{
            // 특정 스레드를 지목해서 멈추게 할 수 없음 이건 사실 static 메서드
            thread.sleep(1000); // Thread.sleep(1000);
            System.out.println("sleep(1000) : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
