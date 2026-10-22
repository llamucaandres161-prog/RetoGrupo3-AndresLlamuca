package modelo;

/**
 * Árbol general almacenado internamente como árbol binario
 * (hijo izquierdo - hermano derecho). No usa listas ni librerías de árboles.
 */
public class ArbolOrganizacional {

    private final UnidadAcademica raiz;

    public ArbolOrganizacional(String nombreRaiz) {
        this.raiz = new UnidadAcademica(nombreRaiz);
    }

    public UnidadAcademica getRaiz() {
        return raiz;
    }

    /**
     * Agrega nodoHijo como ÚLTIMO hijo del nodo llamado nombrePadre.
     * Por eso el orden de inserción define el orden de los hermanos.
     *
     * @return true si el padre existía y se insertó el hijo.
     */
    public boolean agregar(String nombrePadre, UnidadAcademica nodoHijo) {
        UnidadAcademica padre = buscar(raiz, nombrePadre);
        if (padre == null) {
            System.out.println("[Aviso] No existe el padre: " + nombrePadre);
            return false;
        }
        if (padre.getHijoIzquierdo() == null) {
            // Primer hijo -> va a la izquierda del padre
            padre.setHijoIzquierdo(nodoHijo);
        } else {
            // Ya tiene hijos -> se enlaza como hermano derecho del último hijo
            UnidadAcademica ultimo = padre.getHijoIzquierdo();
            while (ultimo.getHermanoDerecho() != null) {
                ultimo = ultimo.getHermanoDerecho();
            }
            ultimo.setHermanoDerecho(nodoHijo);
        }
        return true;
    }

    /** Búsqueda recursiva por nombre en el árbol binario. */
    private UnidadAcademica buscar(UnidadAcademica actual, String nombre) {
        if (actual == null) {
            return null;
        }
        if (actual.getNombre().equals(nombre)) {
            return actual;
        }
        UnidadAcademica enHijos = buscar(actual.getHijoIzquierdo(), nombre);
        if (enHijos != null) {
            return enHijos;
        }
        return buscar(actual.getHermanoDerecho(), nombre);
    }

    /** Muestra el árbol binario obtenido (izq = primer hijo, der = hermano). */
    public void mostrarBinario() {
        System.out.println(raiz.getNombre() + "  (raiz)");
        mostrarBinario(raiz, "");
    }

    private void mostrarBinario(UnidadAcademica nodo, String prefijo) {
        boolean hayIzq = nodo.getHijoIzquierdo() != null;
        boolean hayDer = nodo.getHermanoDerecho() != null;

        if (hayIzq) {
            System.out.println(prefijo + (hayDer ? "+-- " : "`-- ")
                    + "[izq - hijo] " + nodo.getHijoIzquierdo().getNombre());
            mostrarBinario(nodo.getHijoIzquierdo(), prefijo + (hayDer ? "|   " : "    "));
        }
        if (hayDer) {
            System.out.println(prefijo + "`-- [der - hermano] " + nodo.getHermanoDerecho().getNombre());
            mostrarBinario(nodo.getHermanoDerecho(), prefijo + "    ");
        }
    }

    /** Muestra el árbol general original (jerarquía por niveles con sangría). */
    public void mostrarGeneral() {
        mostrarGeneral(raiz, 0);
    }

    private void mostrarGeneral(UnidadAcademica nodo, int nivel) {
        System.out.println("    ".repeat(nivel) + (nivel == 0 ? "" : "`- ") + nodo.getNombre());
        UnidadAcademica hijo = nodo.getHijoIzquierdo();
        while (hijo != null) {
            mostrarGeneral(hijo, nivel + 1);
            hijo = hijo.getHermanoDerecho();
        }
    }
}
