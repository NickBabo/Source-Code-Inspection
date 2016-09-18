package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length; i++) {
            if (papelMoeda[i] == quantia) { // trocado a condicional de papelMoeda[1] por papelMoeda[i]
                achou = true;
                this.saldo += quantia; // movido da linha 33 para dentro da condicional
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        return this.saldo; //retorna o saldo restante na maquina como troco
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
        this.saldo=0; // adicionado a função de zerar o saldo ao término da impressão
    }
}