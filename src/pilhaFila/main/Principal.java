package pilhaFila.main;

import pilhaFila.basica.Processo;
import pilhaFila.estrututa.Fila;

public class Principal {

public static void main(String[] args) {

    Fila fila = new Fila(5);

    Processo p1 = new Processo(1, "Documento 1");
    Processo p2 = new Processo(2, "Trabalho de Java");
    Processo p3 = new Processo(3, "Relatório");
    Processo p4 = new Processo(4, "Atividade");

    // Adicionar
    fila.adicionar(p1);
    fila.adicionar(p2);
    fila.adicionar(p3);
    fila.adicionar(p4);

    // Mostrar
    fila.mostrar();

    // Verificar primeiro
    System.out.println("\nPrimeiro processo:");
    System.out.println(fila.verificar());

    // Remover
    System.out.println("\nRemovendo:");
    System.out.println(fila.remover());

    // Mostrar novamente
    fila.mostrar();

    // Inverter
    fila.inverter();

    // Mostrar fila invertida
    fila.mostrar();
}

}
