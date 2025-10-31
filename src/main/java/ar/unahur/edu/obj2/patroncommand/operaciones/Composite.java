package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Composite extends Comando{

    private List<Operable> instrucciones = new ArrayList<>();

    public Composite(List<Operable> instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.run(instrucciones);
    } 

    protected Boolean noEsCero(Programable micro){
        return !micro.getAcumuladorA().equals(0);
    }
}
