public class Consumer implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                Main.cheio.acquire(); // verifica se buffer esta cheio
                Main.mutex.acquire(); // entra na seccao critica
                int item = Main.buffer.poll(); // pega o item do buffer
                System.out.println("Consumidor consumiu: " + item);
                Main.mutex.release(); // sai da seccao critica
                Main.vazio.release(); // avisa que ha espaco vazio
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
