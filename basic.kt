package org.example
import kotlin.random.Random
import java.lang.Exception

//constants are declared outside of functions
const val URL_LINK = "google.com";

fun variablesAndStringsModule(){
    //Exercise: Variables and Strings
    println("(\\(\\ \n(-.-)\nO_(\")(\")");
    //Length of a string
    val name = "livia";
    println(name.length);
    //Trim
    val text = "      such a      beautiful morning     ";
    println(text.trim());
    //Get
    println(name.get(2));
    println(name[3])
    //Get a part of a string
    val fruit = "watermelon";
    println(fruit.substring(5));
    println(fruit.substring(0, 4));
    //Exercise: Discover a new fun and use it
    println(fruit.plus(" sugar"));
    //Templates
    println("name $name age ${1+20}");
    //Constants
    println(URL_LINK);
}

fun userInputAndRandom(){
    val userInput = readlnOrNull(); // is similar to readLine(), but instead of throwing an exception, it returns null if the user does not provide any input or an error occurs
    println(userInput);
    //or you can do that with readLine function if receive a number
    val userInput2 = readLine()?:"";
    println(userInput2);
    //now you can input a number
    println(userInput2.toInt());
    //random numbers
    println(Random.nextInt());
    println(Random.nextInt(10)); //0 until 9
    println(Random.nextInt(20, 30));
    println(Random.nextDouble(123.5));
    //Exercise: Getting user input
    val birthYear = readLine()?:"";
    println(2024-birthYear.toInt());
}

fun typesOfNumbers(){
    val items = 5.453453;
    val item = 2;
    println("${items::class.java} ${item::class.java}");
    //Exercise: Numbers
    val userNumber = readln()?:"";
    val userAuxNumber = userNumber.toInt();
    val result = userAuxNumber * items;
    println(result::class.java);
    //Explicit
    val dogs: Byte = 5;
    println(dogs::class.java);
    val dog: String = "Toty";
    println(dog::class.java);
    val life = 42L; //it's another way to declare variables, like 42F
    //Type conversions
    var lifeFloat = life.toFloat();

}

fun operatorsAndBoolean(){
    println(5+2);
    println(5-2);
    println(5*2);
    println(5/2);
    println(5%2);
    println("Hi" + "Livia");
    var dogs = 26;
    println(dogs++);
    //Augmented assignment
    dogs += 1;
    dogs -= 1;
    dogs /= 3;
    dogs *= 2;
    //Exercise: Operators
    val userInput = readLine()?:"";
    val amount = ((5.5/100) * userInput.toDouble()) * 5;
    println(amount);
    //Logical Operators
    val isDay = true;
    val isNotDay = false;
    println(isDay && isNotDay);
    println(isDay || isNotDay);
    val isNight = !isDay;
    val isNotNight = !isNotDay;
    println(isNight);
    //Comparison operators
    val a = 1;
    val b = 2;
    println(a==b);
    println(a>=b);
    println(a<=b);
    println(a!=b);
    //Exercise: Logical Operators
    val animals = 3;
    val product = 1;
    val family = 3;
    println(animals<=5 && product>0 && family>=3);
}

fun nullability(){
    val name: String = "livia"; // if you try name = null will generate a compilation error
    val names: String? = null;
    println(names?.length);
    println(names?.length?.toString());
    /* arithmetic operators
    + -> ?.plus()
    - -> ?.minus()
    multiplication -> ?.times()
    division -> ?.div()
    % -> ?.rem() */
    var age: Int? = 10;
    println(age?.plus(5));
    println(age?.minus((3)));
    println(age?.rem(2));
    println(age?.times(7));
    println(age?.div(3));
    var type: String? = "Method";
    type = null;
    println(type?.substring(2,6));
    //Exercise: Null
    val numberUser = readln();
    val result = numberUser?.toDouble()?.times(7);
    println(result?.toString()?.length);
    var message: String? = null;
    println(message?: "Howwwwww")
    // !! non null assertion
    println(numberUser.toInt()!! * 5);
}

fun exceptions(){
    val name = readln();
    try{
        println(name?.toInt());
    }catch(e: Exception){
        e.printStackTrace(); //you can see in the log files
        println("An Exception happened \n ${e.localizedMessage}");
    }finally {
        println("finished");
    }
    throw IllegalArgumentException("You're a horrible programmer");
}

fun listAndArrayList(){
    //List is immutable
    val colors = listOf("Blue", "Red", "Yellow");
    println(colors);
    val animals = listOf<String>("Cat", "Dog", "Bee");
    println(animals);
    println(animals.size);
    val otherAnimals = listOf<String?>("Cat", "Dog", "Bee", null);
    println(otherAnimals);
    println(otherAnimals[0])
    //ArrayList is mutable, you can change
    val newColors = arrayListOf("Brown", "Green");
    val emptyArList = arrayListOf<String>();
    println(emptyArList);
    newColors.add("Pink");
    println(newColors);
    newColors.addAll(colors);
    println(newColors);
    newColors.remove("Yellow");
    println(newColors);
    newColors.removeAt(3);
    //Exercise: List and ArrayList
    val items = arrayListOf("laptop", "pen", "paper", "mug", "phone", "mouse");
    val removeItems = arrayListOf("pen", "paper", "mug", "phone");
    items.removeAll(removeItems);
    println(items);
    //List functions
    val colorsAgain = listOf("Blue", "Red", "Yellow", "Red", "Pink", "Brown");
    colorsAgain.size;
    colorsAgain.contains("Red");
    val colorsMinor = listOf("Red", "Yellow");
    colorsAgain.containsAll(colorsMinor);
    colorsAgain.indexOf("Red");
    colorsAgain.lastIndexOf("Red");
    //ArrayList functions
    val itemsAgain = arrayListOf("laptop", "pen", "paper", "mug", "phone", "mouse");
    itemsAgain[0] = "computer";
    println(itemsAgain);
    val subItems = itemsAgain.subList(0, 2);
    println(subItems);
    subItems.clear();
    println(subItems);
    println(subItems.isEmpty());
    println(itemsAgain.isEmpty());
}

fun setAndHashSet(){
    //Set: Stores unique elements in an undefined order
    val numbers = setOf(6, 37, 6, 42);
    println(numbers);
    val numbers2 = setOf<Int>();
    println(numbers2);
    val numbers3 = setOf(1, 2, null, null, 4, 35);
    println(numbers3);
    //HashSet: A mutable set
    val numbers4 = hashSetOf(6, 37, null, 42);
    val numbers5 = hashSetOf<Int>();
    numbers4.add(44);
    numbers4.addAll(numbers);
    numbers4.remove(6);
    numbers4.removeAll(numbers);
    println(numbers4);
    //Exercise: Set and HashSet
    val costumers = hashSetOf("Livia", "Joao", "Maria");
    costumers.add("Lucas");
    println(costumers);
    costumers.remove("Livia");
    println(costumers);
    //Set functions
    numbers.size;
    numbers.contains(4);
    numbers.containsAll(numbers3);
    numbers.containsAll(setOf(6, 37));
    numbers.isEmpty();
    numbers2.isEmpty();
    //Hashset functions
    val newNumbersHash = hashSetOf(2, 3, 4, 7, 8, 4, 5);
    val subNumberHash = hashSetOf(5, 6, 7)
    println(newNumbersHash.intersect(subNumberHash)); //Don't modify the original
    println(newNumbersHash.retainAll(subNumberHash)); //Modify
    subNumberHash.clear();
}

fun mapAndHashMap(){
    //Map -> immutable, is a set of key-values pairs
    val count = mapOf(Pair(1, "one"), Pair(2, "two"), Pair(5, "Five"));
    println(count);
    val newCount = mapOf<Int, String>();
    println(newCount);
    println(count[1]);
    println(count.keys);
    println(count.values);
    //Hashmap -> a mutable map
    val countHash = hashMapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"));
    countHash[4] = "four";
    countHash.putAll(count);
    println(countHash)
    countHash.remove(2);
    println(countHash[1]);
    println(countHash);
    countHash.replace(1, "One");
    println(countHash);
    //countHash.clear();
    //Map Functions
    countHash.size;
    count.size;
    countHash.containsKey(2);
    countHash.containsKey(3);
    count.containsKey(1);
    countHash.containsValue("One");
    count.containsValue("two");
    countHash.isEmpty();
    countHash.isNotEmpty();
    count.isEmpty();
}

fun ifCondition(number: Int){
    val night: Boolean = true;
    if(night){
        println("It's time to sleep");
    }else{
        println("Wake up!");
    }
    //shorthand if -> curly brackets can be ommitted if there is only one expression
    val isEven: String  = if(number%2 == 0) "Number is even"; else "Number is odd";
    println(isEven);
    if(number > 50) println("you're so old");
    else if(number < 50) println("you're young");
    else println("you're nothing");
}

fun expressions(){
    //in keyword
    val animals = listOf<String>("Cat", "Dog", "Bird", "Crocodile");
    if("Cat" in animals) println("You're a cat owner!");
    if("Bee" !in animals) println("Yo don't have a cute bee...");
}

fun whenCondition(animal: String){
    var action: String;
    //The {} is optional in the options
    when(animal) {
        "cat" -> action = "Miauuuu"
        "dog" -> action = "AuAuAuAu";
    }
    val month: String = "December";
    val days = when(month){
        "January", "December", "June" -> 31;
        "February" -> 28
        else -> 30
    }
    println(days);
    when(val length = animal.length){
        in 1..5 -> println("Name with $length characters is short");
        in 6..10 -> println("Name with $length characters is medium");
        in 11..15 -> println("Name with $length characters is long");
    }
}

fun forLoop(){
    val colors = listOf("Blue", "Red", "Yellow");
    for(color in colors){
        println(color);
    }
    for(i in 1..12){
        println(i)
    }
    for(i in 10 downTo 0){
        println(i)
    }
    for(i in 10 downTo 0 step 3){
        println(i)
    }
    for(i in 10 downTo 0 step 2){
        println(i)
    }
    val countHash = hashMapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"));
    for(countName in countHash.keys){
        println(countHash[countName]);
    }
    for(i in 1..5){
        for(j in 1..15){
            print("$i,$j \t");
        }
        println();
    }
}

fun whileLoop(){
    //common while loop -> condition is evaluated at the beginning
    var pare: Boolean = false;
    var cont: Int = 0;
    while(!pare){
        println("Hello");
        cont++;
        if(cont == 5) pare = true;
    }
    //do while loop -> the condition is evaluated at the end
    var aux: Int = 0;
    do{
        println("I'm still here");
        aux++;
    }while (aux < 10);
    //nested while loop
    var i = 0
    var j = 0;
    while (i <= 10){
        while (j <= 5){
            print("$i, $j ");
            j++;
        }
        j = 0;
        i++;
        println();
    }
}

fun breakAndContinue(){
    val numbers = arrayListOf(1, 2, 3, 4);
    for(number in numbers){
        if (number == 2) break;
    }
    for(number in numbers){
        print(number);
        if(number % 2 != 0) continue;
    }
}

fun functionReturn(number: Int, def: String = "Hi"): Int{
    println(def);
    return number;
}

fun scope(parakeets: Int) {
    val parakeets = 3
}

fun varargs(vararg names: String){
    for(name in names) println(name);
}

fun lambdaFunctions(){
    val names = arrayListOf("Alice", "Bob", "Dan");
    val myLambda = {name: String -> println("Hello Word $name")};
    sayHello(names, myLambda);
    //OR
    sayHello(names) {name: String -> println("Hello Word $name")};
}

fun sayHello(names: ArrayList<String>, doSomething: (String) -> Unit){
    for(name in names) doSomething(name);
}

fun forEachHOF(){
    val clients = arrayListOf("livia", "ze", "maria");
    clients.forEach { println("Hello $it") };
}

fun filterHOF(){
    val clients = arrayListOf("livia", "ze", "maria");
    clients.filter { it.length <5 }
        .forEach { println("Hello $it") };
}

fun mapHOF(){
    val clients = arrayListOf("livia", "maria", "zezinho");
    val sizes = clients.map {it.length}
    println(sizes);
}

fun sortedByHOF(){
    val clients = listOf("Anna", "Bob", "Carol", "David");
    val sorted = clients.sortedBy { it.length };
    println(sorted);
}

fun maxMinByHOF(){
    val clients = listOf("Anna", "Bob", "Carol", "David");
    val max = clients.maxBy { it.length };
    println(max)
    val min = clients.minBy { it.length };
    println(min);
}

fun main() {
    //variablesAndStringsModule();
    //userInputAndRandom();
    //typesOfNumbers();
    //operatorsAndBoolean();
    //nullability();
    //exceptions();
    //listAndArrayList();
    //setAndHashSet();
    //mapAndHashMap();
    //ifCondition(24);
    //expressions();
    //whenCondition("dog");
    //forLoop();
    //whileLoop();
    //breakAndContinue();
    //functionReturn(5, "Helloooo");
    //functionReturn(6);
    //var parakeets = 5;
    //scope(parakeets);
    //println(parakeets);
    //varargs("Livia", "Rosa", "Rhuana");
    //lambdaFunctions();
    //forEachHOF();
    //filterHOF();
    //mapHOF();
    //sortedByHOF();
    maxMinByHOF();
}