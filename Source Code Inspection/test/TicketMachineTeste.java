/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31517072
 */
public class TicketMachineTeste {

    @Test
    public void inserirDinheiro() throws PapelMoedaInvalidaException {

        TicketMachine machine = new TicketMachine(10);
        machine.inserir(20);
        assertEquals(machine.getSaldo(), 20);

    }

    public void imprimirBilhete() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine machine = new TicketMachine(10);
        machine.inserir(20);
        assertEquals(machine.getSaldo(), 20);
        machine.imprimir();
        assertEquals(machine.getSaldo(), 10);

    }

    public void pegarTroco() {
        TicketMachine machine = new TicketMachine(10);
        try {
            machine.inserir(20);
        machine.inserir(5);
        assertEquals(machine.getSaldo(), 20);
        machine.imprimir();
        assertEquals(machine.getSaldo(), 10);
        Iterator<PapelMoeda> troco = machine.getTroco();

        while (troco.hasNext()) {
            PapelMoeda papelMoeda = troco.next();
            // Exibe o PapelMoeda cuja quantidade é maior que 0
            if (papelMoeda.getQuantidade() > 0) {
                assertEquals(papelMoeda.getValor(),10);
                assertEquals(papelMoeda.getQuantidade(),1);
            }
        }
        } catch (PapelMoedaInvalidaException | SaldoInsuficienteException ex) {
            Logger.getLogger(TicketMachineTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TicketMachineTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
