
class lab8 extends Thread {

    public void run() {
        System.out.println(getName() + " Priority: "
                + getPriority());
    }

    public static void main(String[] args) {
        lab8 t1 = new lab8();
        lab8 t2 = new lab8();
        lab8 t3 = new lab8();

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t1.setPriority(3);
        t2.setPriority(5);
        t3.setPriority(8);

        t1.start();
        t2.start();
        t3.start();
    }
}
