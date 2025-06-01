import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Main {

    static Queue<Integer> buffer = new LinkedList<>();
    static final int TAMANHO_BUFFER = 5;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore cheio = new Semaphore(0);
    static Semaphore vazio = new Semaphore(TAMANHO_BUFFER);

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();
    }
}
