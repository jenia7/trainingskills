package com.ivanova;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 26.04.2018.
 */

public class Deadlock {
    static class Roommate{
        private final String name;

        public Roommate(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void occupyTop(Roommate roommate) {
            System.out.println(this.name + "  occupied top bank of the bed before "+roommate.getName()+"\n");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            roommate.occupyBottom();
        }

        public synchronized void occupyBottom() {
            System.out.println(this.name + " occupied bottom bank of the bed\n");
        }


    }
    static Roommate sam = new Roommate("Sam");
    static Roommate dean = new Roommate("Dean");
    public static void main(String[] args) {


        new Thread(new Runnable() {
            public void run() {
                sam.occupyTop(dean);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                dean.occupyTop(sam);
            }
        }).start();
    }
}
