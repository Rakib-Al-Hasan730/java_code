
class Lab7 extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread Running");

            Thread.yield();

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        Lab7 t = new Lab7();
        t.start();
    }
}
