package suporte;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerarData {

    public String getDataAtual(boolean comHoras){
        LocalDateTime localDate = LocalDateTime.now();
        String dataFormatada;

        if(comHoras == true){
            dataFormatada = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-MM-ss")).toString();
        }else {
            dataFormatada = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        }

        return dataFormatada;
    }


}
