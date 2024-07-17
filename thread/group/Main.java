package thread.group;

public class Main {
    public static void main(String[] args) {
        Runnable task1 = () -> {
          while (!Thread.currentThread().isInterrupted()){
              try {
                  Thread.sleep(1000);
                  System.out.println(Thread.currentThread().getName());
              } catch (InterruptedException e) {
                  break;
              }
          }
        };

        ThreadGroup group1 = new ThreadGroup("Group1");

        Thread thread1 = new Thread(group1, task1, "Thread 1");
        Thread thread2 = new Thread(group1, task1, "Thread 2");

        System.out.println("Group of thread1 : " + thread1.getThreadGroup().getName());
        System.out.println("Group of thread2 : " + thread2.getThreadGroup().getName());

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group1.interrupt();
    }
}
