Calculadora Java con GUI

Este proyecto es una calculadora básica implementada en Java utilizando el patrón Modelo-Vista-Controlador (MVC) y la biblioteca Swing para la interfaz gráfica de usuario (GUI).

Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- modelo: Contiene la clase `CalculadoraModelo` que maneja la lógica de las operaciones matemáticas.
- vista: Contiene la clase `CalculadoraVista` que implementa la interfaz gráfica de usuario.
- controlador: Contiene la clase `CalculadoraControlador` que conecta el modelo con la vista.
- Main.CalculadoraMain: La clase principal que inicia la aplicación.

Requisitos

- JDK 22.0.2 o superior
- Un entorno de desarrollo compatible con Java (como Eclipse, IntelliJ IDEA, o simplemente la línea de comandos)

Compilación y Ejecución

1. Compilación

Para compilar el proyecto, asegúrate de que estás en el directorio raíz del proyecto (donde se encuentra el archivo `Main.CalculadoraMain.java`).

Abre una terminal o línea de comandos y ejecuta el siguiente comando:

```sh
javac -d bin src/controlador/*.java src/modelo/*.java src/vista/*.java src/Main.CalculadoraMain.java

Uso de la Calculadora

Entrada de Números: Haz clic en los botones numéricos (0-9) para ingresar números.
Selección de Operaciones: Haz clic en los botones de operaciones (+, -, *, /) para seleccionar la operación deseada.
Ejecución de Operación: Después de ingresar los números y seleccionar una operación, haz clic en el botón = para calcular el resultado.
Limpieza: Haz clic en el botón C para borrar la entrada actual y comenzar de nuevo.