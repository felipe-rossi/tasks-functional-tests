import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.CreateDrive;
import suporte.GerarData;
import suporte.GerarNumeroAleatorio;
import suporte.Screenshot;

import java.util.Random;

public class TasksTests {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp(){
       driver = CreateDrive.criarDriverChrome();
    }

    @Test
    public void adicionarComSucessoUmatarefa(){
        GerarNumeroAleatorio num = new GerarNumeroAleatorio();
        GerarData data = new GerarData();

        driver.findElement(By.id("addTodo")).click();
        driver.findElement(By.id("task")).sendKeys("Teste" + num.gerarNumeroInteiro());
        driver.findElement(By.id("dueDate")).sendKeys(data.getDataAtual(false).toString());
        driver.findElement(By.id("saveButton")).click();

        String mensagem = driver.findElement(By.id("message")).getText();

        Assertions.assertEquals("Success!", mensagem);

    }

    @Test
    public void naoDeveAdicionarTarefaSemDescricao(){

        driver.findElement(By.id("addTodo")).click();
        driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
        driver.findElement(By.id("saveButton")).click();

        String mensagem = driver.findElement(By.id("message")).getText();

        Assertions.assertEquals("Fill the task description", mensagem);

    }

    @Test
    public void naoDeveAdicionarTarefaSemData(){
        GerarNumeroAleatorio num = new GerarNumeroAleatorio();

        driver.findElement(By.id("addTodo")).click();
        driver.findElement(By.id("task")).sendKeys("Teste" + num.gerarNumeroInteiro());
        driver.findElement(By.id("saveButton")).click();

        String mensagem = driver.findElement(By.id("message")).getText();

        Assertions.assertEquals("Fill the due date", mensagem);

    }

    @Test
    public void naoDeveAdicionarTarefaComDataNoPassado(){
        GerarNumeroAleatorio num = new GerarNumeroAleatorio();

        driver.findElement(By.id("addTodo")).click();
        driver.findElement(By.id("task")).sendKeys("Teste" + num.gerarNumeroInteiro());
        driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
        driver.findElement(By.id("saveButton")).click();

        String mensagem = driver.findElement(By.id("message")).getText();

        Assertions.assertEquals("Due date must not be in past", mensagem);

    }


    @AfterAll
    public static void tearDown(){
        Screenshot.tirarPrint();
        driver.quit();
    }
}
