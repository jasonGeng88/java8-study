/**
 * Created by jason-geng on 1/19/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int port = 1107;

//        Runnable r1 = () -> System.out.println("Hello World");
//        r1.run();
//
//        Callable<String> ca = () -> "hello callable";
//
//        String res = ca.call();
//        System.out.println(res);
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lamdba ...");
            System.out.println(port + "");};


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println("oop ...");
                System.out.println(String.valueOf(port));
            }
        };
//        r.run();
//        new Thread(r).run();
        new Thread(r2).start();
        Thread.sleep(200);
        System.out.println("port is" + port);

    }
}
