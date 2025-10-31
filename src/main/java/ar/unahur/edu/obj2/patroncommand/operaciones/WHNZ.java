package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class WHNZ extends Composite{

    public WHNZ(List<Operable> instrucciones) {
        super(instrucciones);
    }

    @Override
    protected void doExecute(Programable micro) {
        while(Boolean.TRUE.equals(this.noEsCero(micro))){
            super.doExecute(micro);
        }
    }
}
