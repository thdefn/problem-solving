package thread.status.interrupt;

public class Main {

    public static void main(String[] args) {
        Runnable task = () -> {
                try {
                    Thread.sleep(1000); // 일시 정지
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) { // interrupt 발생 시 여기로 빠지게 됨
                    e.printStackTrace();
                }

                System.out.println("task : "  + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread"); // NEW
        thread.start(); // RUNNABLE
        thread.interrupt(); // InterruptedException 이 발생함

        System.out.println("thread.isInterrupted() = " + thread.isInterrupted()); // 지정한 스레드가 현재 interrupt 된 상태인지
    }
    public static void main2(String[] args) {
        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()){
                try {
                  //  System.out.println("hi");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    break;
                }

                System.out.println("task : "  + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(task, "Thread");
        thread.start();
        thread.interrupt();

        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());
    }
}
