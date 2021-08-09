package lesson3;

public class PingPong {

    private static final Object lock = new Object();
    private static boolean isPing = true;

    public static void main(String[] args) {
        int current = 10;

        for (int i = 0; i < current; i++) {
            new Ping().start();
        }

    }

    private static class Ping extends Thread {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    while (!isPing) {
                        lock.wait();
                    }
                    System.out.println("Ping");
                    isPing = false;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }

        private static class Pong extends Thread {

            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        while (isPing) {
                            lock.wait();
                        }
                        System.out.println("Pong");
                        isPing = true;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
