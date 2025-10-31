package ar.unahur.edu.obj2.patroncommand.invoker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

class ProgramaTest {

    private Programa programa = new Programa();
    private Programable micro = new Microcontrolador();

    @BeforeEach()
    void setUp(){
        programa.vaciarLista();
        programa.resetearMicro(micro);
    }

    @Test
    void avanzar3PosicionesElProgramCounter(){
        programa.agregarOperacionNOP();
        programa.agregarOperacionNOP();
        programa.agregarOperacionNOP();

        programa.ejecutar(micro);

        assertEquals(3, micro.getProgramCounter()); 
    }

    @Test
    void acumuladorA37AcumuladorB0ProgramCounter4(){
        programa.agregarOperacionLODV(20);
        programa.agregarOperacionSWAP();
        programa.agregarOperacionLODV(17);
        programa.agregarOperacionADD();

        programa.ejecutar(micro);

        assertEquals(37, micro.getAcumuladorA()); 
        assertEquals(0, micro.getAcumuladorB()); 
        assertEquals(4, micro.getProgramCounter()); 
    }

    @Test
    void acumuladorA15AcumuladorB0(){
        programa.agregarOperacionLODV(2);
        programa.agregarOperacionSTR(0);
        programa.agregarOperacionLODV(8);
        programa.agregarOperacionSWAP();
        programa.agregarOperacionLODV(5);
        programa.agregarOperacionADD();
        programa.agregarOperacionSWAP();
        programa.agregarOperacionLOD(0);
        programa.agregarOperacionADD();

        programa.ejecutar(micro);

        assertEquals(15, micro.getAcumuladorA()); 
        assertEquals(0, micro.getAcumuladorB()); 
        assertEquals(9, micro.getProgramCounter()); 
    }
    
}
