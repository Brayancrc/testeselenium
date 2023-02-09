package src.test.java.automatizado.test;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;
    

    @BeforeClass
    public static void preperarTestes(){
        loginPage = new LoginPO(driver); 
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){

        loginPage.executarAcaoDeLogar("","");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos." );
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){

        loginPage.executarAcaoDeLogar("teste","");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos." );
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("","teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos." );
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaIncorretos(){

        loginPage.executarAcaoDeLogar("teste","teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos" );
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailcorretoESenhaIncorreta(){

        loginPage.executarAcaoDeLogar("admin@gmail.com","teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos" );
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta(){

        loginPage.executarAcaoDeLogar("Aadmin@gmail.com","admin@123");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos" );
    }

    @Test
    public void TC007_deveLogarNoSistemaComEmailESenhaCorretos(){

        loginPage.executarAcaoDeLogar("admin@gmail.com","admin@123");
        
        assertEquals(login.obterTituloPagina(), "Controle de Produtos");
    }
}
