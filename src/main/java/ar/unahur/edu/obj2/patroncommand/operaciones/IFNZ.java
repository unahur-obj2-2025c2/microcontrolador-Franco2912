package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class IFNZ extends Composite{

    public IFNZ(List<Operable> instrucciones) {
        super(instrucciones);
    }

    @Override
    protected void doExecute(Programable micro) {
        if(Boolean.TRUE.equals(this.noEsCero(micro))){
            super.doExecute(micro);
        }
    }
}
