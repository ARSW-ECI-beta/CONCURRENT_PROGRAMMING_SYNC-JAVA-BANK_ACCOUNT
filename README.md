
### Escuela Colombiana de Ingeniería
### Arquitecturas de Software - ARSW
## Ejercicio - Programación Multi-hilo y esquemas de sincronización

### Descripción

Este ejercicio tiene como fin que el estudiante conozca y aplique conceptos propios de la programación concurrente.


### Parte 1 - Cuentas Bancarias

Las aplicaciones bancarias son uno de los sistemas informáticos más comunes y con muy conocidos problemas de concurrencia. En la operación diaria de una sucursal ocurren eventos como:

* Se abre una nueva cuenta bancaria, con un saldo inicial.
* Sobre una cuenta se pueden hacer depósitos (consignaciones) o retiros.
* Se cierra una cuenta.

Se ha elaborado un prototipo muy sencillo para un sistema como el descrito anteriormente el cual solamente incluye las clases Banco y Cuenta con el comportamiento de una sucursal bancaria y una cuenta respectivamente.

Note que las operaciones en las cuentas y en la sucursal cambian los saldos de unas y otra. En el prototipo no se ha tenido en cuenta la posibilidad de que los diferentes servicios (operaciones) ofrecidos por las mencionadas clases puedan ser utilizados concurrentemente (invocadossimultáneamente por Hilos diferentes).

Con las clases suministradas, una entidad financiera con $10000 en caja, y tres cuentas bancarias con $10000, $5000 y $3000 respectivamente, se representarían como objetos mediante las clases Banco y Cuenta de la siguiente manera:

``` java
	Banco bnc=new Banco(10000);
	Cuenta c=new Cuenta(10000, bnc);
	Cuenta c2=new Cuenta(5000, bnc);
	Cuenta c3=new Cuenta(3000, bnc);
	bnc.abrirCuenta(c);
	bnc.abrirCuenta(c2);
	bnc.abrirCuenta(c3);
``` 

Este banco, por lo tanto, tendrá en caja $28000. En este modelo, al cerrar alguna cuenta, el saldo de dicha cuenta se resta de la caja del banco. Por otro lado, al igual que hacer un retiro de una de las cuentas, se disminuye tanto el saldo de la cuenta, como el monto disponible en la caja del
banco. 
Por ejemplo, al hacer un retiro de la cuenta 'c3':
``` java
c3.retiro(2000);
``` 
se afecta el saldo en caja del banco, quedando un total de $26000.
### Ejercicio - Parte I
1. Se le han suministrado los fuentes de un programa que, de forma concurrente, manipula un banco (la clase con el método main de la misma se llama MainTransaccionesConcurrentes). Este programa crea una instancia del banco, y se la envía a un centenar de hilos de tipo HiloTransaccion, los cuales realizarán operaciones sobre el mismo. Ejecute este programa y verifique su funcionamiento.
2. Como se puede observar, el primer problema es que los resultados del procesamiento concurrente (que en este caso es el tiempo total que tomó el procesamiento, y el saldo final en la caja del banco), se están mostrando antes de que los hilos terminen. Para esto, es necesario sincronizar el programa principal, de manera que sólo muestre los resultados cuando el último hilo haya terminado. Recuerde que para esto puede usar:
	* a. o.wait() <- para suspender un hilo, y usar como monitor el objeto ‘o’.
	* b. o.notify()/o.notifyAll() <- para reactivar un hilo suspendido con respecto al monitor ‘o’.
3. Una vez pueda observar los resultados de la ejecución de los hilos (mostrándolos sólo al final de la ejecución de los mismos), ejecute varias veces el programa, y verifique si se obtiene siempre el mismo resultado. Bajo las condiciones actuales, el programa puede considerarse determinista?
4. Revise el código del hilo (clase HiloTransaccion), y calcule cual debería ser el saldo en caja que SIEMPRE se debería obtener del banco al final del programa, teniendo en cuenta el número de hilos que se están corriendo.
5. Analice el código de las clases Banco y Cuenta, e identifique cuales serían las regiones críticas a las que están accediendo los hilos de forma concurrente. Incorpore un método de exclusión mutua en dichas regiones. Verifique nuevamente los resultados.
