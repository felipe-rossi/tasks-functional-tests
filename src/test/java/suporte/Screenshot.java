package suporte;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Screenshot {

    public static void tirarPrint(){
        try{
            GerarData data = new GerarData();
            Robot rb = new Robot();
            Rectangle rt = new Rectangle(1920,1080);
           BufferedImage screenshot = rb.createScreenCapture(rt);

            ImageIO.write(screenshot,"PNG",new File("D:\\Prints\\" + data.getDataAtual(true) + ".png"));

        }catch (Exception e){
            System.out.println("Erro ao tirar print da tela: " + e.getMessage());
        }

    }
}
