package modelo;

/**
 * La clase {@code CalculadoraModelo} maneja la lógica de las operaciones matemáticas básicas
 * y funciones adicionales como porcentaje, raíz cuadrada, recíproco y cambio de signo.
 */
public class CalculadoraModelo {
    private double resultado;

    /**
     * Realiza la suma de dos números y almacena el resultado.
     *
     * @param num1 el primer número
     * @param num2 el segundo número
     */
    public void sumar(double num1, double num2) {
        resultado = num1 + num2;
    }

    /**
     * Realiza la resta de dos números y almacena el resultado.
     *
     * @param num1 el primer número
     * @param num2 el segundo número
     */
    public void restar(double num1, double num2) {
        resultado = num1 - num2;
    }

    /**
     * Realiza la multiplicación de dos números y almacena el resultado.
     *
     * @param num1 el primer número
     * @param num2 el segundo número
     */
    public void multiplicar(double num1, double num2) {
        resultado = num1 * num2;
    }

    /**
     * Realiza la división de dos números y almacena el resultado.
     *
     * @param num1 el primer número
     * @param num2 el segundo número
     * @throws ArithmeticException si {@code num2} es cero (división por cero)
     */
    public void dividir(double num1, double num2) {
        if (num2 != 0) {
            resultado = Math.round((num1 / num2) * 100.0) / 100.0; // Redondear a 2 decimales
        } else {
            throw new ArithmeticException("No se puede dividir entre 0");
        }
    }

    /**
     * Realiza el cálculo de porcentaje de un número.
     *
     * @param num el número al que se le aplicará el porcentaje
     */
    public void porcentaje(double num) {
        resultado = num / 100;
    }

    /**
     * Calcula la raíz cuadrada de un número.
     *
     * @param num el número al que se le aplicará la raíz cuadrada
     * @throws ArithmeticException si {@code num} es negativo
     */
    public void raizCuadrada(double num) {
        if (num >= 0) {
            resultado = Math.sqrt(num);
        } else {
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
        }
    }

    /**
     * Cambia el signo del número actual (positivo a negativo o viceversa).
     *
     * @param num el número al que se le cambiará el signo
     */
    public void cambiarSigno(double num) {
        resultado = -num;
    }

    /**
     * Eleva el número a una potencia.
     *
     * @param base la base
     * @param exponente el exponente
     */
    public void potencia(double base, double exponente) {
        resultado = Math.pow(base, exponente);
    }

    /**
     * Calcula el logaritmo natural de un número.
     *
     * @param num el número al que se le aplicará el logaritmo
     * @throws ArithmeticException si {@code num} es menor o igual a 0
     */
    public void logaritmo(double num) {
        if (num > 0) {
            resultado = Math.log(num);
        } else {
            throw new ArithmeticException("El logaritmo sólo está definido para números positivos");
        }
    }

    /**
     * Obtiene el resultado de la última operación realizada.
     *
     * @return el resultado de la operación
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * Establece el resultado manualmente.
     *
     * @param resultado el nuevo resultado a establecer
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    /**
     * Reinicia el resultado a cero.
     */
    public void reiniciar() {
        resultado = 0;
    }
}
