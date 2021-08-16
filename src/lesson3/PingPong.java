package lesson3;

public class PingPong {

    private static final Object lock = new Object();
    private static boolean isPing = true;
    static final int counter = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < counter; i++) {
                    synchronized (lock) {
                        while (!isPing) {
                            lock.wait();
                        }
                        System.out.println("Ping");
                        isPing = false;
                        Thread.sleep(1000);
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < counter; i++) {
                    synchronized (lock) {
                        while (isPing) {
                            lock.wait();
                        }
                        System.out.println("Pong");
                        isPing = true;
                        Thread.sleep(1000);
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
