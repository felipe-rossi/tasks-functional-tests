package suporte;

import java.util.Random;

public class GerarNumeroAleatorio {

    public int gerarNumeroInteiro(){
        Random n = new Random();
        int num = n.nextInt(0, 1000);

        return num;
    }
}
