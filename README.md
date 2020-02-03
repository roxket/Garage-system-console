# Garage-system-console

Garaje mecánico (ArrayList) 
 
Se desea realizar una aplicación que permita a los mecánicos de un garaje registrar, consultar y actualizar los trabajos (reparaciones y revisiones) que han sido realizados o que están en proceso de realización en el garaje. 
Cada trabajo se identifica inequívocamente por su “identificador de trabajo”. El “identificador de trabajo” es un número que se asocia con el trabajo en el momento que se registra. El primer trabajo registrado tendrá el identificador 0, el segundo el 1 y así sucesivamente. 
Los trabajos incluyen una pequeña descripción de la reparación o revisión a realizar. 
Todos los trabajos incluyen el número de horas que van siendo necesarias para su realización. Al crear un trabajo el número de horas es 0.El número de horas irá aumentando a medida que los mecánicos van dedicando tiempo a realizar la reparación o la revisión. Cuando el trabajo se ha finalizado se marca como “finalizado” y el número de horas no puede volver a cambiarse. 
Las reparaciones incluyen el precio del material utilizado (piezas o pintura). Al registrar una reparación el precio del material es 0 y va aumentando a medida que los mecánicos van utilizando material en la reparación. Una vez que la reparación se marca como “finalizada” no se puede cambiar el precio del material utilizado. 
El precio a cobrar para cada trabajo se compone de una parte fija que resulta de multiplicar el número  de horas empleadas por 30€. Además, dependiendo del tipo de trabajo el coste varía de la siguiente manera: 

• Reparación mecánica: su precio se calcula como fijo más el coste material multiplicado por 1.1. 
• Reparación de chapa y pintura: su precio se calcula como fijo más el coste material multiplicado por 1.3.
• Revisión: su precio se calcula como fijo más extra independiente del número de horas de 20€. 

La aplicación tendrá las siguientes funcionalidades: 

• Registrar trabajo: se introduce el tipo de trabajo y su descripción. El mecánico introduce los datos y el programa añade el trabajo a la lista y muestra el identificador asignado al trabajo.
• Aumenta horas: el mecánico introduce el identificador del trabajo y el número de horas. 
• Aumenta coste piezas: el mecánico introduce el identificador del trabajo y el coste de las piezas, y la aplicación aumenta el coste de las piezas al trabajo. 
• Finaliza trabajo: el mecánico introduce el identificador del trabajo y la aplicación termina el trabajo. 
• Muestra trabajo: el mecánico introduce el identificador del trabajo y la aplicación muestra el identificador, la descripción y el precio del trabajo. 
Siempre que el mecánico introduzca un identificador incorrecto, el programa informará de este error. 
Utilizar un ArrayList para almacenar los trabajos. Hay que hacer uso de clases y herencias.
