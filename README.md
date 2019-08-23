# Web Calculator App

Esta aplicación web permite calcular la media y la desviación estándar de un conjunto de datos que son pasados a través de una página. Para la implementación, se usó la estructura LinkedList usada en el proyecto [Calculator App](https://github.com/CarlosCL98/CalculatorApp)

## Diseño de Arquitectura

![](/src/main/resources/img/DiagramaDeClases.PNG)

![](/src/main/resources/img/DiagramaDeDespliegue.PNG)

La arquitectua realizada permite identificar los principales componentes como lo son los clientes y los servidores. Para estos últimos encontramos a Heroku como servidor en donde se encuentra desplegada la página, además de los componentes con los cuáles interactúa la aplicación central de Web Calculator App.

Cuando se realiza una petición get, el framewrok Spark ayuda a consumir dichas peticiones que de acuerdo a su implementación otorgan un resultado. Esta podemos denotarla como una interfaz, de manera que ofrece diversas formas de conectarse a ella, ya sea por requerimientos HTTP o respuestas, entre otros.

## Documentación
Para ver la documentación y más información sobre las funcionalidades, acceda a los siguientes links:
 
- [API de WebCalculatorApp](https://carloscl98.github.io/WebCalculatorApp/src/main/resources/site/apidocs/index.html)
- [Tests de WebCalculatorApp](https://carloscl98.github.io/WebCalculatorApp/src/main/resources/site/testapidocs/index.html)

## Prerrequisitos
Antes de usar el programa, tenga en cuenta que debe usar **java JDK 1.8**.

## Cómo usar el programa

1. Para usar el programa, debe acceder al siguiente link en **Heroku**:

	> [Web Calculator App Heroku](https://webcalculatorapp.herokuapp.com)

## Creador

*Carlos Andrés Medina Rivas*

*Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito.*

## Licencia

> GNU GENERAL PUBLIC LICENSE - Version 3, 29 June 2007

Para ver más, leer el archivo [LICENSE.txt](LICENSE.txt) ubicado en la raíz de este repositorio.