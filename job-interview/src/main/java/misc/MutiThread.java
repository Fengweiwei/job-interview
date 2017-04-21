package misc;

import java.util.ArrayList;
import java.util.List;

public class MutiThread {
    private static class ThreadPrint implements Runnable {
        private Object pre;
        private Object cur;
        private int    cnt;
        private char   label;

        public ThreadPrint(char label, int cnt, Object pre, Object cur) {
            this.cnt = cnt;
            this.cur = cur;
            this.pre = pre;
            this.label = label;
        }

        @Override
        public void run() {
            for (int i = 0; i < cnt; i++) {
                synchronized (pre) {
                    synchronized (cur) {
                        System.out.println(Thread.currentThread().getName() + ":" + label);
                        cur.notify();//释放锁给下一个，执行下去
                    }
                    try {
                        if (i == cnt - 1) {
                            pre.notify();
                        } else {
                            pre.wait();//释放上一个锁，但是等在这里
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int m = 3;
        int n = 2;
//        Executor  pool  = Executors.newFixedThreadPool(m);
        List<Thread> pool  = new ArrayList<>();
        Object[]     locks = new Object[m];
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new Object();
        }
        for (int i = 0; i < m; i++) {
            ThreadPrint print = new ThreadPrint((char) ('A' + i), n, locks[(i + m - 1) % m], locks[i]);
            pool.add(new Thread(print));
        }
        pool.forEach(p -> {
            try {
                Thread.sleep(100);//一个一个执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.start();
        });
    }
}
