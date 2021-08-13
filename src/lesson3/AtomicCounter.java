package lesson3;

public class AtomicCounter {

    static final int counter = 100;

    public static void main(String[] args) {
        SyncCounter sc = new SyncCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < counter; i++) {
                sc.inc();
                System.out.println("thread1: " + sc.value());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < counter; i++) {
                sc.inc();
                System.out.println("thread2: " + sc.value());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sync_counter: " + sc.value());
    }

    public static class SyncCounter {
        private int c;
        private final Object mon = new Object();

        public int value() {
            return c;
        }

        public SyncCounter() {
            c = 0;
        }

        public void inc() {
            synchronized (mon) {
                c++;
            }
        }
    }
}
