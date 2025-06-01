public class Producer implements Runnable {
    @Override
    public void run() {
        int item = 0;
        while(true){
            try{
                item++; // produz item
                Main.vazio.acquire(); // verifica se buffer esta vazio
                Main.mutex.acquire(); // entra na seccao critica
                Main.buffer.add(item); // coloca no buffer
                System.out.println("Produtor produziu: " + item + "\nBuffer:" + Main.buffer);
                Main.mutex.release(); // avisa que saiu da seccao critica
                Main.cheio.release(); // avisa que tem item cheio
                Thread.sleep(1000);

            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
