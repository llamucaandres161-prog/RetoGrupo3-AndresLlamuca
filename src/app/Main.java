package app;

import modelo.ArbolOrganizacional;
import modelo.UnidadAcademica;

public class Main {

    public static void main(String[] args) {

        ArbolOrganizacional arbolGeneral = new ArbolOrganizacional("A");

        // Nivel 1: hijos de A (orden: B, C, D)
        arbolGeneral.agregar("A", new UnidadAcademica("B"));
        arbolGeneral.agregar("A", new UnidadAcademica("C"));
        arbolGeneral.agregar("A", new UnidadAcademica("D"));

        // Nivel 2: hijos de B (E, F), de C (G) y de D (H, I)
        arbolGeneral.agregar("B", new UnidadAcademica("E"));
        arbolGeneral.agregar("B", new UnidadAcademica("F"));
        arbolGeneral.agregar("C", new UnidadAcademica("G"));
        arbolGeneral.agregar("D", new UnidadAcademica("H"));
        arbolGeneral.agregar("D", new UnidadAcademica("I"));

        // Nivel 3: hijo de E (J) y de G (K)
        arbolGeneral.agregar("E", new UnidadAcademica("J"));
        arbolGeneral.agregar("G", new UnidadAcademica("K"));

        System.out.println("===== ARBOL GENERAL =====");
        arbolGeneral.mostrarGeneral();

        System.out.println();
        System.out.println("===== ARBOL BINARIO (hijo izquierdo - hermano derecho) =====");
        arbolGeneral.mostrarBinario();
    }
}
