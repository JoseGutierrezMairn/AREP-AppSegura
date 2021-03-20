# Taller de arquitectura segura
En este repositorio está disponible una app segura a partir de llaves y certificados, como dice el título  
con el fin de hacer una aplicación más segura para los usuarios que hagan uso de la aplicación y para los dueños de la aplicación.
## Prerrequisitos
Debemos tener los siguientes programas instalados o cuentas para poder hacer uso de las herramientas:
~~~
* Maven
* Git
* Java
* Java IDE de preferencia
~~~

# Instalando 
Para descargar el proyecto realizaremos los siguientes pasos desde el **Simbolo del sistema** o **Command prompt**:  
1. Nos dirigimos a la ubicación donde queremos descargar el proyecto desde el simbolo del sistema.  
2. Escribimos el siguiente comando para realizar la descarga:  
~~~
git clone https://github.com/JoseGutierrezMairn/AREP-AppSegura.git
~~~
3. Esperamos a que el simbolo de sistema nos diga que ya se realizó la descarga  
4. El proyecto ya se encuentra en nuestros computadores y está listo para ser editado o probado.  
  
# Documentación
Para compilar el código con maven solo debemos correr el siguiente codigo en el símbolo del sistema ubicado en la raíz del proyecto (Carpeta que contiene el archivo README.md)
`mvn package`

Si queremos ejecutar el programa de manera local, debemos compilar el proyecto con maven y posteriormente ir a nuestro IDE y ejecutar el código fuente.  
Una vez el programa este ejecutandose podemos ir a nuestro navegador de preferencia y escribir en la url la siguiente dirección:  
~~~
https://localhost:5000/  
~~~
## Certificado
Cuando entramos a la página podemos ver el certificado que se creó para la página  
![Imagenes](https://github.com/JoseGutierrezMairn/AREP-AppSegura/blob/master/img/certificado1.PNG?raw=true)  

![Imagenes](https://github.com/JoseGutierrezMairn/AREP-AppSegura/blob/master/img/certificado2.PNG?raw=true)  

![Imagenes](https://github.com/JoseGutierrezMairn/AREP-AppSegura/blob/master/img/certificado3.PNG?raw=true)  
Cuando se entra a la página por primera vez es normal que el navegador muestre una advertencia que el certificado es desconocido,  
lo que se debe hacer es decirle al navegador que nos redirija a la página que solicitamos y que ignore permita el certificado.  

## Demostración en video
~~~
funcionamiento de la página con login exitoso
~~~  
![gifautsuccess](https://github.com/JoseGutierrezMairn/AREP-AppSegura/blob/master/img/authenticationSuccessful.gif)
~~~
funcionamiento de la página con login no exitoso
~~~  
![gifautsuccess](https://github.com/JoseGutierrezMairn/AREP-AppSegura/blob/master/img/noAuthentication.gif)

# Autor
* [Jose Gutierrez](https://github.com/JoseGutierrezMairn)