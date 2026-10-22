package modelo;

/**
 * Nodo del árbol. Se usa la representación binaria
 * "hijo izquierdo - hermano derecho":
 *  - hijoIzquierdo : primer hijo de la unidad.
 *  - hermanoDerecho: siguiente hermano de la unidad.
 */
public class UnidadAcademica {

    private final String nombre;
    private UnidadAcademica hijoIzquierdo;
    private UnidadAcademica hermanoDerecho;

    public UnidadAcademica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public UnidadAcademica getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(UnidadAcademica hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public UnidadAcademica getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(UnidadAcademica hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
