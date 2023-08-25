package sistemabancario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;

public class GerenciadoraContasTeste1 {


    @Test
    public void testTransfereValor(){
        ContaCorrente conta01 = new ContaCorrente(1, 200, true);
        ContaCorrente conta02 = new ContaCorrente(2, 0, true);

        List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);

        GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);

        boolean resultadoTransferencia = gerContas.transfereValor(1, 50, 2);

        assertThat(conta01.getSaldo(), is(150.0));
        assertThat(conta02.getSaldo(), is(50.0));
        assert(resultadoTransferencia);

        
    }   
}
