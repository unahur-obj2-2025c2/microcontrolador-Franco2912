package ar.unahur.edu.obj2.patroncommand.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.ADD;
import ar.unahur.edu.obj2.patroncommand.operaciones.LOD;
import ar.unahur.edu.obj2.patroncommand.operaciones.LODV;
import ar.unahur.edu.obj2.patroncommand.operaciones.NOP;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.operaciones.STR;
import ar.unahur.edu.obj2.patroncommand.operaciones.SWAP;

public class Programa {

    private final List<Operable> operaciones;

    public Programa(List<Operable> operaciones) {
        this.operaciones = operaciones;
    }

    public Programa() {
        this.operaciones = new ArrayList<>();
    }

    public void agregarOperacion(Operable operacion){
        operaciones.add(operacion);
    }

    public void sacarOperacion(Operable operacion){
        operaciones.remove(operacion);
    }

    public void agregarOperacionADD(){
        operaciones.add(new ADD());
    }

    public void agregarOperacionNOP(){
        operaciones.add(new NOP());
    }

    public void agregarOperacionSWAP(){
        operaciones.add(new SWAP());
    }

    public void agregarOperacionLOD(Integer addr){
        operaciones.add(new LOD(addr));
    }

    public void agregarOperacionSTR(Integer addr){
        operaciones.add(new STR(addr));
    }

    public void agregarOperacionLODV(Integer val){
        operaciones.add(new LODV(val));
    }

    public List<Operable> getOperaciones() {
        return operaciones;
    }

    public void vaciarLista(){
        operaciones.clear();
    }

    public void ejecutar(Programable micro){
        micro.run(operaciones);
    }

    public void resetearMicro(Programable micro) {
        micro.reset();
    }
}
