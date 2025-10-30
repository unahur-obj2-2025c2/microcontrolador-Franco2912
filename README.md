# 🔌 Microcontrolador [![codecov](https://codecov.io/gh/unahur-obj2/microcontrolador/branch/main/graph/badge.svg?token=qLtHHlVTmi)](https://codecov.io/gh/unahur-obj2/microcontrolador)

Un **microcontrolador** es una computadora integrada en uno o varios chips. Suele utilizarse en la industria para controlar máquinas, herramientas, robots, teléfonos celulares, entre otros. Un fabricante de microcontroladores nos solicita que desarrollemos un **simulador** de uno de sus modelos, el cual consta de:

- 🧮 Dos acumuladores de tipo `Integer`, identificados como **A** y **B**.
- ⏱️ Un _program counter_ (PC), que indica la dirección en la memoria de programa de la próxima instrucción a ejecutar. Se incrementa cada vez que el microcontrolador ejecuta una instrucción.
- 💾 Un área de **1024 valores enteros** correspondiente a la memoria de datos.

![estado_interno](./assets/MicroEstadoInterno.png)

El fabricante nos proporcionó la lista de operaciones mínimas que debe soportar:

| Memotécnico | Descripción                                                                          |
| ------------ | ------------------------------------------------------------------------------------ |
| `NOP`        | No realiza ninguna operación; el programa continúa con la siguiente instrucción.     |
| `ADD`        | Suma los valores de los dos acumuladores.                                            |
| `SWAP`       | Intercambia los valores de los acumuladores (el de A va a B y viceversa).            |
| `LOD addr`   | Carga el acumulador A con el contenido de la memoria de datos en la posición `addr`. |
| `STR addr`   | Guarda el valor del acumulador A en la posición `addr` de la memoria de datos.       |
| `LODV val`   | Carga en el acumulador A el valor `val`.                                             |

🧑‍💻 Además, nos brindaron las interfaces que debemos implementar para el microcontrolador y sus operaciones:

### Interfaz del Microcontrolador

```java
public interface Programable {

    void run(List<Operable> operaciones);

    void incProgramCounter();

    Integer getProgramCounter();

    void setAcumuladorA(Integer value);

    Integer getAcumuladorA();

    void setAcumuladorB(Integer value);

    Integer getAcumuladorB();

    void setAddr(Integer addr);

    Integer getAddr(Integer addr);

    void reset();
}
```

### Interfaz de las Operaciones

```java
public interface Operable {

    void execute(Programable micro);
}
```

## ✅ Requerimientos

- El sistema debe permitir **agregar nuevas instrucciones** de manera simple a medida que el fabricante las solicite.
- La memoria de datos tiene un rango de direcciones válidas de **0 a 1023**.
- La operación aritmética `ADD` siempre produce un valor entero, dejando el resultado en el acumulador A y un **0 en el acumulador B**.
- Si se produce un error durante la ejecución del programa (por ejemplo, al acceder a una dirección de memoria fuera de rango), el programa debe detenerse y el _program counter_ debe permanecer en la dirección de la instrucción que causó el error.
- Los métodos que reciben direcciones de memoria como parámetro deben **verificar que estén dentro del rango válido** (de 0 a 1023).

---

## 🧪 Test

Se solicita que el microcontrolador pueda resolver los siguientes programas, realizando las pruebas correspondientes:

| Objetivo                         | Programa                                                                                     | Resultado esperado                                     |
| -------------------------------- | -------------------------------------------------------------------------------------------- | ------------------------------------------------------ |
| Hacer avanzar 3 posiciones el PC | `NOP`<br>`NOP`<br>`NOP`                                                                      | El PC pasa de 0 a 3.                                   |
| Sumar 20 + 17                    | `LODV 20`<br>`SWAP`<br>`LODV 17`<br>`ADD`                                                    | Acumulador A: 37, Acumulador B: 0<br>PC pasa de 0 a 4. |
| Sumar 2 + 8 + 5                  | `LODV 2`<br>`STR 0`<br>`LODV 8`<br>`SWAP`<br>`LODV 5`<br>`ADD`<br>`SWAP`<br>`LOD 0`<br>`ADD` | Acumulador A: 15, Acumulador B: 0                      |

---

## 🧩 Parte II

1. Se desea poder **crear un programa**, es decir, un conjunto de instrucciones, y entregárselo al microcontrolador para que lo ejecute mediante el método `run`.

2. Se requiere que el microcontrolador pueda **deshacer la última instrucción ejecutada**, es decir, volver al estado anterior.  
   Ejemplo:
   - Si se ejecutó un `SWAP`, los acumuladores A y B deben volver a sus valores previos.
   - Si se ejecutó un `ADD`, debe deshacerse la suma, restaurando los valores anteriores de los acumuladores.

(\*) Seguramente vas a necesitar tocar las interfaces para poder copiar el estado del microprocesador y poder hacer el undo. Pensá cuidadosamente qué y donde tenes que agregar lo métodos en los contratos de las interfaces.

4. Para simplificar la construcción de programas, la segunda versión del procesador agregó instrucciones de más alto nivel:

| Mnemotécnico | Descripción                                                                                   |
| ------------ | --------------------------------------------------------------------------------------------- |
| `IFNZ`       | Ejecuta un conjunto de instrucciones si el valor del acumulador A es distinto de cero.        |
| `WHNZ`       | Ejecuta un conjunto de instrucciones mientras el valor del acumulador A sea distinto de cero. |

---

🛠️ ¡Listo para programar tu microcontrolador!
