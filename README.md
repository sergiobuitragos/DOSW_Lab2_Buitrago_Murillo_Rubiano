# DOSW_Lab2_Buitrago_Murillo_Rubiano
Lab2 de DOSW


Desarrollo del desafio N°1
### Desafío 1: Implementación del patrón Strategy

Para el Desafío 1 se utilizó el patrón de comportamiento **Strategy**, con el objetivo de permitir diferentes estrategias de descuento sin generar un acoplamiento directo entre el cliente y una implementación específica.

**Estructura del sistema:**

* `Product` representa cada producto y cuenta con un precio **inmutable** una vez creado.
* `CartItem` relaciona un producto con una cantidad determinada y se encarga de calcular su subtotal.
* `ShoppingCart` almacena la lista de productos agregados al carrito y calcula el total mediante **Streams**, utilizando las operaciones `map` y `reduce`.
* `DiscountStrategy` es la interfaz que establece el contrato para las estrategias de descuento. `NewCustomerDiscount` (5 %) y `FrequentCustomerDiscount` (10 %) corresponden a las implementaciones concretas. Ambas heredan de `AbstractDiscountStrategy`, clase que centraliza la validación del subtotal, con la que evitamos la duplicación de código.
* `Customer` almacena el nombre del cliente y la estrategia de descuento asignada, sin depender directamente de una implementación concreta, aplicando el principio de **Inversión de Dependencias (Dependency Inversion)**.
* `Receipt` se encarga de generar el recibo final. Para ello, utiliza `filter` y `forEach` para listar los productos, además de calcular el subtotal, el descuento y el total. Finalmente, presenta los valores con formato de miles colombiano.

Adicionalmente, en la clase `Main` se realizó directamente el ejemplo planteado en el reto, con el propósito de comprobar el correcto funcionamiento de las validaciones implementadas. También se desarrollaron **tres pruebas** para verificar el comportamiento del sistema, las cuales se encuentran descritas y documentadas dentro del archivo `.java` correspondiente.

**Estado actual del reto:** todos los requisitos funcionales y de diseño establecidos para el desafío se encuentran cumplidos.

![Output Reto 1](image-2.png)

En cuanto a las preguntas puntuales del reto:

1. **Principios SOLID:**

* **(S) Single Responsibility:** `Product` solo representa un producto con nombre y precio, `CartItem` solo representa el producto + su cantidad, calculando su propio `subTotal`, `ShoppingCart` solo recibe la lista de items y suma el total, `DiscountStrategy` se utiliza para calcular los descuentos y `Receipt` solo arma la estructura de la factura y la imprime.

* **(O) Open/Closed:** el sistema está abierto por si se desea agregar algún descuento nuevo, sin embargo, está cerrado para modificar el código ya existente. Es decir, si mañana Don Pepe decide agregar un descuento para clientes VIP, solo se debe crear la nueva clase `VipCustomerDiscount`, hacer que extienda de `AbstractDiscountStrategy` y listo.

* **(L) Liskov Substitution:** cualquier implementación que se necesite de `DiscountStrategy` se puede reemplazar sin problema, porque a `Customer` no le interesa si tiene o no un `NewCustomerDiscount`, ya que cualquier implementación cumpliría con el mismo contrato.

* **(I) Interface Segregation:** `DiscountStrategy` tiene un solo método (`calculateDiscount`). No obliga a las clases a implementar métodos que no necesitan y es una interfaz pequeña y específica.

* **(D) Dependency Inversion:** `Customer` no depende de una clase concreta de descuento, como `NewCustomerDiscount`, sino que depende de la **interfaz** `DiscountStrategy`.

 2. **Polimorfismo::** 
El código de Customer es el mismo siempre, pero el comportamiento cambia según el objeto real que tenga por dentro. Es decir, cuando Customer.calculateDiscount() llama a discountStrategy.calculateDiscount(subtotal), Java decide en tiempo de ejecución cuál implementación usar.

 3. **Encapsulamiento:**
    Todos los atributos de todas las clases son private
 4. **Inmutabilidad:**
Product es una clase final con atributos final y sin setters. Una vez creado un producto con new Product("nombre", precio), ese precio no se puede cambiar nunca. Si necesitan un producto con otro precio, tienemos que crear un Product nuevo, no modificar el existente.


Desarrollo del desafio N°2
### Desafío 2: Implementación del patrón creacional Builder
Se utilizó el patrón creacional Builder porque el reto exige construir una hamburguesa personalizada paso a paso, es decir, tener una cantidad dada de variables independientes y opcionales (pan, carne, queso, vegetales y salsas).

Este patrón nos ayuda a separar lo complejo de la construcción (crear el objeto hamburguesa) de lo que es su presentación final, permitiéndonos ensamblar el objeto incrementalmente sin necesidad de un constructor con múltiples parámetros.

Lo implementamos de la siguiente manera:

BurgerBuilder mantiene una lista interna de Ingredient y expone métodos encadenables (withBread, withMeat, addIngredient) que retornan this, permitiendo realizar llamadas fluidas (method chaining).

El método build() finaliza el proceso, creando un objeto Burger a partir de los ingredientes acumulados.

La clase Cliente actúa como quien dirige la construcción (Main), seleccionando ingredientes de un catálogo predefinido y orquestando las llamadas al builder paso a paso.

Adicionalmente, usamos un Fluent Builder, que es una versión simplificada del patrón Builder clásico, sin Director ni una interfaz separada, donde el propio BurgerBuilder construye el objeto paso a paso mediante métodos encadenados.

Lo utilizamos por las siguientes razones:

El reto no lo necesitaba, ya que cada hamburguesa es distinta según lo que el usuario elige.
Utilizamos menos clases y consideramos que implementar el Director y una interfaz separada sería sobreingeniería para este caso.

**Imagenes de funcionamiento del reto**
<img width="347" height="108" alt="image" src="https://github.com/user-attachments/assets/e4433306-15be-4547-a537-a726825c059a" />
<img width="358" height="295" alt="image" src="https://github.com/user-attachments/assets/c9974fb9-3624-433f-bc3f-9d708521237b" />
<img width="530" height="185" alt="image" src="https://github.com/user-attachments/assets/cf40424e-5743-4ef0-b60f-df9552cb9a09" />
**pruebas exitosas**
<img width="837" height="275" alt="image" src="https://github.com/user-attachments/assets/0c6e4fb1-6ba4-415c-a777-0d68a882958c" />


Desarrollo del desafio N°3
### Desafío 3: Implementación del patrón Factory 

Utilizamos el patrón Factory porque el sistema necesita crear distintos tipos de vehículos (Land, Water, Air) sin que el código cliente (Dealership) conozca las clases concretas ni la lógica de construcción de cada uno. Cada familia tiene su propia lógica de especificaciones (velocidad, precio, equipo) según la categoría y el modelo, por lo que delegar la creación a una clase especializada por familia evita condicionales extensos y centraliza el conocimiento de cada catálogo.

¿Cómo lo aplicamos?

Se definió la interfaz VehicleFactory con el método createVehicle(category, model). Cada familia tiene su implementación concreta (LandVehicleFactory, WaterVehicleFactory, AirVehicleFactory), cada una con su propia tabla de especificaciones (VehicleSpec). VehicleFactoryProvider selecciona la factory correcta según la familia solicitada y delega la creación, devolviendo siempre el tipo abstracto Vehicle. El cliente (Dealership) solo interactúa con VehicleFactoryProvider, sin conocer las clases concretas.

**Imegenes que muestran que si fumciona**

<img width="431" height="316" alt="image" src="https://github.com/user-attachments/assets/de28f460-530f-4b57-8b43-4f90f1aee14d" />
<img width="506" height="206" alt="image" src="https://github.com/user-attachments/assets/c06b660c-8420-42e1-af62-61485791da51" />

**Pruebas**

<img width="912" height="312" alt="image" src="https://github.com/user-attachments/assets/3eda29ba-04a0-4948-8330-1820f72c2dd8" />

Desarrollo del desafio N°4

**Design Pattern Category:** Behavioral

**Pattern Used:** Strategy

**Justification:** Cada par de monedas requiere una tasa de conversión distinta. Strategy permite intercambiar el algoritmo de conversión sin modificar el código cliente.

**How It Was Applied:** ExchangeRateStrategy define el contrato de conversión, FixedExchangeRateStrategy lo implementa con una tasa fija por par de monedas. ExchangeRateProvider selecciona la estrategia correcta según origen/destino. CurrencyConverter usa la estrategia sin conocer los detalles de cálculo (Dependency Inversion).

**Streams:** CurrencyConverter.totalConvertedByCurrency() usa Collectors.groupingBy + Collectors.summingDouble para acumular totales por moneda destino, cumpliendo el requisito explícito de "grouped or accumulated" del enunciado.

**Evidencia**
![Reto 4:](image.png)


Desarrollo del desafio N°5


Desarrollo del desafio N°6

**Design Pattern Category:** Behavioral
**Pattern Used:** Chain of Responsibility
**Justification:** Un ticket recorre una secuencia de técnicos sin que el cliente sepa cuál lo resuelve, cada uno decide si resolver o delegar al siguiente.
**How It Was Applied:** TechnicalSupport centraliza la lógica común (registrar intento, verificar capacidad, resolver o delegar), BasicTechnician/IntermediateTechnician/AdvancedTechnician solo definen su especialidad. SupportChain expone un único punto de entrada.

**Streams:** SupportStatistics usa groupingBy+counting (tickets por nivel), filter+count (resueltos/pendientes), y mapToInt+average (promedio de prioridad de resueltos).

**Evidencia**
![Reto 6 Evidencia](image.png)

Desarrollo del desafio N°5
### Desafío 5: Implementación del patrón Collector

Usamos este patrón porque el reto exige poder agregar nuevos toppings (Milk, Chocolate, Caramel, Whipped Cream, Mint, CustomTopping) sin modificar la clase base del café (NormalCoffee), y permitir combinar cualquier número de ellos sobre un mismo café. Además, permite envolver un objeto (Coffee) en otros objetos con la misma interfaz, añadiendo comportamiento (precio y descripción) de forma dinámica.
¿Cómo lo aplicamos?

Coffee es la interfaz común (component) con getDescription() y getPrice(). NormalCoffee es el componente concreto (café base sin toppings). Topping es el decorador abstracto: implementa Coffee, envuelve una referencia a otro Coffee y valida que no sea nulo. Cada topping concreto (Milk, Chocolate, Caramel, WhippedCream, Mint, CustomTopping) extiende Topping y sobrescribe getDescription()/getPrice(), delegando al coffee envuelto y sumando su propio aporte. Así, en Main.java, cada vez que el usuario elige un topping, se envuelve el café actual (coffee = new Milk(coffee), etc.), permitiendo apilar cualquier número de toppings sin tocar NormalCoffee ni las clases de otros toppings.

** Imagen de funcionamiento **

<img width="376" height="295" alt="image" src="https://github.com/user-attachments/assets/13f21bc9-1e60-452e-84cb-f2cdb0526422" />
<img width="518" height="267" alt="image" src="https://github.com/user-attachments/assets/4961ea94-d43f-4224-adaf-267ff4282b17" />

**Pruebas**
<img width="894" height="298" alt="image" src="https://github.com/user-attachments/assets/b33fcc7d-d8fb-4231-9038-5394fda8caa3" />




    
