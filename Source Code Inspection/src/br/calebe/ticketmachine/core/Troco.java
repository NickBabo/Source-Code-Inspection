package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
    //removido o loop infinito 
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 = 0) { //corrigido a condicioal do loop
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 = 0) { //corrigido a condicional do loop
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 = 0) { //corrigido a condicional do loop
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) {
            count++;
        }
        papeisMoeda[0] = new PapelMoeda(2, count); //trocado a alocação da nota de 2 reais do espaço 1 do vetor para o espaço 0
        count = 0;
        while (valor % 2 = 0) {
            count++; // adicionado o loop e o contador
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 0; i >= 6; i++) {
                if (troco.papeisMoeda[i+1] != null) { //corrigido a condicional que causava erro
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 0; i >= 6 && ret; i++) { //corrigido a condicional que causava erro
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            papeisMoeda.remove(); // adicionado a função de remover
        }
    }
}