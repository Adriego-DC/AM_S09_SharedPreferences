Descripción General del Proyecto

Este proyecto consiste en el desarrollo de una aplicación móvil educativa orientada a la práctica y comprensión del uso de SharedPreferences en el entorno de desarrollo Android Studio, utilizando el lenguaje de programación Kotlin y el sistema visual Material Design 3. El objetivo principal de la aplicación es almacenar, recuperar y administrar información básica del usuario de forma persistente, permitiendo conservar datos incluso después de cerrar o reiniciar la aplicación.

Estructura General de la Aplicación

La aplicación se organiza en una única MainActivity que funciona como contenedor principal, la cual hace uso de varios Fragments para modularizar las funciones. El diseño de navegación está implementado mediante un BottomNavigationView (barra inferior), lo que brinda al usuario una experiencia fluida e intuitiva para moverse entre las diferentes secciones. Esta barra de navegación incluye cuatro apartados:

Menú:

Esta sección representa el núcleo funcional del proyecto. Permite al usuario ingresar su nombre, guardarlo en el almacenamiento local (usando SharedPreferences), cargarlo posteriormente y eliminar los datos almacenados. También se registra si es la primera vez que el usuario accede a la aplicación, lo cual permite mostrar un mensaje de bienvenida personalizado.

Contador:

Esta funcionalidad cuenta cuántas veces se ha iniciado la aplicación (desde cero), evitando que aumente el conteo cuando la app solo pasa al segundo plano o se rota el dispositivo. El valor se guarda también en SharedPreferences, lo que garantiza su persistencia. Además, se incluye un botón que permite reiniciar el contador a cero en cualquier momento.

Tema:

En esta sección, el usuario puede alternar entre el modo claro y el modo oscuro a través de un Switch interactivo. Esta elección visual se guarda en SharedPreferences, lo que permite que la aplicación recuerde y mantenga el tema preferido del usuario incluso después de reiniciar el dispositivo o cerrar la app. El cambio de tema se realiza en tiempo real y se aplica a toda la interfaz de usuario utilizando el soporte nativo de Theme.Material3.DayNight.

Perfil:

Esta vista permite visualizar y editar los datos personales del usuario: nombres, apellidos, edad y correo electrónico. Al pulsar el botón “Editar Perfil”, se muestra un formulario editable que, tras guardar, actualiza la información mostrada. La cancelación descarta cualquier cambio. Esta sección también hace uso de SharedPreferences para persistir los datos introducidos por el usuario.

Manejo de Datos Persistentes

Toda la lógica relacionada con el almacenamiento persistente de datos se encapsula en una clase personalizada llamada SharedPreferencesHelper. Esta clase proporciona métodos reutilizables y seguros para guardar y recuperar valores de tipo String, Int, Boolean, Long, y Float. Además, permite eliminar claves individuales o limpiar completamente las preferencias del usuario.

Gestión del Ciclo de Vida

Se han incorporado mecanismos para mantener el estado de la aplicación incluso ante eventos como la rotación de pantalla. Por ejemplo, se guarda el fragmento actual activo para evitar que, tras una rotación o reinicio, la aplicación vuelva al fragmento por defecto. Del mismo modo, se evita que ciertos mensajes como el de bienvenida se repitan innecesariamente. Esta atención al ciclo de vida de la actividad mejora significativamente la experiencia de usuario.

Diseño y Adaptabilidad

La interfaz de usuario se ha construido siguiendo las directrices de Material Design 3, lo cual garantiza una apariencia moderna, accesible y coherente en diferentes dispositivos y versiones de Android. Se ha utilizado ViewBinding para enlazar eficientemente los elementos visuales con la lógica de cada fragmento, mejorando la legibilidad y robustez del código.

Conclusión

Esta aplicación representa una implementación completa, ordenada y funcional de una app modular en Android. Además de enseñar el uso de SharedPreferences, también permite explorar conceptos clave como el manejo de fragmentos, navegación con BottomNavigationView, cambios de tema en tiempo real, gestión del ciclo de vida de actividades y fragmentos, y el diseño responsivo. Es un proyecto ideal tanto como práctica formativa como base para desarrollar aplicaciones más complejas que requieran persistencia de datos local.

Ejecucion del Programa:

Codigo Inicial sin modificar:

![WhatsApp Image 2025-06-24 at 17 37 45](https://github.com/user-attachments/assets/e0e62b7a-fa59-40f1-9a56-648881e4c3ef)

Contador de Visitas:

![WhatsApp Image 2025-06-24 at 17 37 45 (1)](https://github.com/user-attachments/assets/6fba38f6-8043-441b-96a1-db00677ef58a)
![WhatsApp Image 2025-06-24 at 17 37 46](https://github.com/user-attachments/assets/9aade9f0-c36f-4301-a8d1-82d611d26148)

Temas:

Tema Claro:

![WhatsApp Image 2025-06-24 at 17 37 46 (1)](https://github.com/user-attachments/assets/c2f30f93-9fe7-4f43-bba1-0564ff9885d2)

Tema Oscuro:

![WhatsApp Image 2025-06-24 at 17 37 46 (2)](https://github.com/user-attachments/assets/06bd36fb-1e5e-4ae1-833d-d7e50020a105)

Perfil:

![WhatsApp Image 2025-06-24 at 17 37 47](https://github.com/user-attachments/assets/bf84b75b-af10-4618-b38a-f58fc4211c4b)
![WhatsApp Image 2025-06-24 at 17 37 47 (1)](https://github.com/user-attachments/assets/2250ccf7-597f-449d-8be5-97c221b7b2dc)
![WhatsApp Image 2025-06-24 at 17 37 47 (2)](https://github.com/user-attachments/assets/a9c87c86-a5ab-4743-a9d2-e3d88751d71e)






