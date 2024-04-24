 Proyecto Mascota Virtual POO

## Instrucciones de Uso

Este proyecto consiste en un juego de simulacion de mascotas virtuales. El archivo `Main.java`es el punto de entrada del programa y usa los datos del archivo `config.csv` para configurar la mascota y su inventario Aquí tienes los detalles sobre los archivos, compilación y ejecución del proyecto:

## Estructura del Proyecto

El proyecto está compuesto por los siguientes archivos:
1. **Main.java**: Archivo principal que inicia el programa y controla el flujo del juego.
2. **MascotaVirtual.java**: Define la clase `MascotaVirtual` y sus métodos.
3. **Item.java**: Define la clase base `Item` y sus subclases `Comida`, `Medicina`, y `Juguete`.
4. **Inventario.java**: Clase que maneja el inventario de ítems para la mascota.
5. **config.csv**: Archivo CSV que contiene la configuración inicial del juego, incluyendo el nombre de la mascota y los ítems en el inventario.

## Contenido de config.csv

El archivo `config.csv` tiene la siguiente estructura:
1. La primera línea contiene el nombre de la mascota.
2. Las siguientes líneas contienen información sobre los ítems en el inventario, separadas por punto y coma `;`. El formato es: `id;tipo;nombre;cantidad`.

Por ejemplo, un archivo `config.csv` podría ser:

```csv
POU
1;Comida;Manzana;5
2;Medicina;Jartabe;3
3;Juguete;Pelota;2
```
## Compilación del Proyecto

Para compilar el proyecto, necesitas tener instalado el JDK(). Asegúrate de tener el entorno de desarrollo configurado y el directorio de tu proyecto correctamente establecido.
1. Abre una terminal
2. Dirígete al directorio donde esten los archivos.
3. Compila el proyecto con el siguiente comando:

   ```bash
   javac Main.java 


## Ejecución del Proyecto
Una vez que el proyecto esté compilado, puedes ejecutarlo de la siguiente manera:
```bash
    java Main config.csv
```
## Compilacion en Aragon

Primero que todo tienes que conectarte al servidor.
En el caso de Windows, la forma más sencilla de conectarse a aragorn es a través de Windows PowerShell, simplemente debe utilizar el comando ssh como se muestra a continuación.
   ```bash
    $ ssh nombre.apellido@aragorn.elo.utfsm.cl
   ```

Luego para compilar y correr el codigo:

   ```bash
 $ make /* para compilar */
 $ make run /* para ejecutar la tarea */
 $ make clean /* para borrar archivos .class */
 ```

## Uso del Programa

El programa te permite interactuar con una mascota virtual y manejar su inventario.Usando los siguientes comandos:

- "Visualizar los atributos de la mascota" El programa mostrara la edad, la salud, la energia y la felicidad
- "Acceder al inventario" presiona `i` para ver el inventario de la mascota.
- "Continuar simulación" presiona `c` para avanzar el tiempo simulado, lo cual incrementa la edad de la mascota y puede afectar sus atributos
- "Salir del programa" presiona `x` para finalizar la simulacion

### Interacción con el Inventario


- "Usar un item": Ingresa el numero correspondiente al item que deseas usar . El primer item (0) siempre es "Dormir", que restaura energia a 100
- "Verificar el estado de la mascota": La mascota puede tener diferentes estados de animo, que se verán afectados por el uso de items o el paso del tiempo y seran mostrado como caritas segun sus stats.
