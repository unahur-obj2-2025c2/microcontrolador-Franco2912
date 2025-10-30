package ar.unahur.edu.obj2.patroncommand.excepciones;

public class FueraDeRangoDeMemoriaException extends RuntimeException{

    public FueraDeRangoDeMemoriaException(){
        super("Direccion de memoria ingresada fuera de rango");
    }

}
