# YouOnlyLeaseOnce
### Proyecto de la materia Visión Computacional


## Objetivo
El objetivo de este proyecto es crear una aplicación que valida la existencia de inmobiliario en departamentos en renta, y de esta manera dar confianza a cualquiera que quiera rentar un espacio. Así mismo, esta aplicación ayuda a los arrendadores a enlistar los objetos o comodidades con los que cuenta su departamento, de manera más fácil y automática. 

Las clases u objetos que se detectan son: 
- Bed
- Chair
- Couch 
- Gas stove
- Microwave oven
- Refrigerator
- Sink
- Table
- Television
- Toilet
- Washing machine

Finalmente, la aplicación se basa en el demo de detección de objetos de tensor flow.

### Notas
Para hacer funcionar esta versión del proyecto, es necesario bajar el modelo yolov4_own.tflite de [este link](https://drive.google.com/file/d/1LeQAGNgkkYVvCg1pllGjJAlzV6crvQC-/view?usp=sharing).  
Posteriormente, este archivo deberá ser colocado en **YouOnlyLeaseOnce -> app -> src -> main -> assets**
