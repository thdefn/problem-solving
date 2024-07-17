package thread;

public class Main {
    public static void main(String[] args) {
//        TestThread thread = new TestThread();
//        thread.start();
//
//        System.out.println();
//
//        Runnable run = new TestRunnable();
//        Thread thread1 = new Thread(run);
//        thread1.start();

        Runnable task = () -> {
            int sum = 0;
            for (int i = 0; i < 50; i++) {
                sum += i;
                System.out.println(sum + " ");
            }
            System.out.println(Thread.currentThread().getName() + " 최종 합 : " + sum);
        };
        Thread thread2 = new Thread(task);
        thread2.setName("thread2");
        thread2.start();

        Thread thread3 = new Thread(task);
        thread3.setName("thread3");
        thread3.start();
    }
}
