package converter
import java.lang.Exception
import java.lang.NumberFormatException
import java.util.Locale
import java.util.Scanner
import kotlin.math.sin
import kotlin.system.exitProcess

val meter = listOf("meter", "m", "meters")
val kilometer = listOf("kilometer", "km", "kilometers")
val centimeter = listOf("centimeter", "cm", "centimeters")
val millimeter = listOf("millimeter", "mm", "millimeters")
val mile = listOf("mile", "mi", "miles")
val yard = listOf("yard", "yd", "yards")
val foot = listOf("foot", "ft", "feet")
val inch = listOf("inch", "in", "inches")
val lengthUnits = listOf(meter,kilometer, centimeter, millimeter, mile, yard, foot, inch)
val gram = listOf("gram", "g", "grams")
val kilogram = listOf("kilogram", "kg", "kilograms")
val milligram = listOf("milligram", "mg", "milligrams")
val pound = listOf("pound", "lb", "pounds")
val ounce = listOf("ounce", "oz", "ounces")
val weightUnits = listOf(gram, kilogram, milligram, pound, ounce)
val celsius = listOf("degree Celsius", "degrees Celsius", "celsius", "dc", "c", "degree celsius", "degrees celsius")
val fahrenheit = listOf("degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "df", "f", "degree fahrenheit", "degrees fahrenheit")
val kelvin = listOf("kelvin", "kelvins", "k")
val temperatureUnits = listOf(celsius, fahrenheit, kelvin)

fun fromKilometersToMeters(number : Double) : Double{
    return number*1000
}
fun fromMetersToKilometers(number : Double) : Double{
    return number/1000
}
fun fromMetersToMeters(number : Double) : Double{
    return number
}
fun fromCentimetersToMeters(number : Double) : Double{
    return number*0.01
}
fun fromMetersToCentimeters(number : Double) : Double{
    return number*100
}
fun fromMillimetersToMeters(number : Double) : Double{
    return number*0.001
}
fun fromMetersToMillimeters(number : Double) : Double{
    return number*1000
}
fun fromMilesToMeters(number : Double) : Double{
    return number*1609.35
}
fun fromMetersToMiles(number : Double) : Double{
    return number/1609.35
}
fun fromYardsToMeters(number : Double) : Double{
    return number*0.9144
}
fun fromMetersToYards(number : Double) : Double{
    return number/0.9144
}
fun fromFeetToMeters(number : Double) : Double{
    return number*0.3048
}
fun fromMetersToFeet(number : Double) : Double{
    return number/0.3048
}
fun fromInchesToMeters(number : Double) : Double{
    return number*0.0254
}
fun fromMetersToInches(number : Double) : Double{
    return number/0.0254
}
fun util(num : Double) : String{
    if(num == 1.0){
        return ""
    }
    else return "s"
}
fun formatted(num : Double, numConverted: Double, sourceSingular : String, sourcePlural : String, sinkSingular : String, sinkPlural : String){
    println("${num.toString() + if(num == 1.0) " " + sourceSingular else " " + sourcePlural} is ${numConverted.toString() + if(numConverted == 1.0) " " + sinkSingular else " " + sinkPlural}")
}

fun lengthConverter(number : Double, source : String, sink : String){
    if(number < 0){
        println("Length shouldn't be negative")
        return
    }
    when(source){
        in meter ->{
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(number), "meter", "meters", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(number), "meter", "meters","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(number), "meter", "meters", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(number),"meter", "meters", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(number),"meter", "meters", "mile", "miles")
                in yard-> formatted(number, fromMetersToYards(number),"meter", "meters", "yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(number),"meter", "meters", "foot", "feet")
                in inch-> formatted(number, fromMetersToInches(number),"meter", "meters", "inch", "inches")
            }
        }
        in kilometer->{
            when(sink){
                in meter -> formatted(number, fromKilometersToMeters(number), "kilometer", "kilometers", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromKilometersToMeters(number)), "kilometer", "kilometers","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromKilometersToMeters(number)), "kilometer", "kilometers", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromKilometersToMeters(number)),"kilometer", "kilometers", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromKilometersToMeters(number)),"kilometer", "kilometers", "mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromKilometersToMeters(number)),"kilometer", "kilometers", "yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromKilometersToMeters(number)),"kilometer", "kilometers", "foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromKilometersToMeters(number)),"kilometer", "kilometers", "inch", "inches")
            }
        }
        in centimeter ->{
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(fromCentimetersToMeters(number)), "centimeter", "centimeters", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromCentimetersToMeters(number)), "centimeter", "centimeters","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromCentimetersToMeters(number)), "centimeter", "centimeters", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromCentimetersToMeters(number)),"centimeter", "centimeters", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromCentimetersToMeters(number)),"centimeter", "centimeters", "mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromCentimetersToMeters(number)),"centimeter", "centimeters", "yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromCentimetersToMeters(number)),"centimeter", "centimeters", "foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromCentimetersToMeters(number)),"centimeter", "centimeters", "inch", "inches")
            }
        }
        in millimeter -> {
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(fromMillimetersToMeters(number)), "millimeters", "millimeters", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromMillimetersToMeters(number)), "millimeter", "millimeters","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromMillimetersToMeters(number)), "millimeter", "millimeters", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromMillimetersToMeters(number)),"millimeter", "millimeters", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromMillimetersToMeters(number)),"millimeter", "millimeters", "mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromMillimetersToMeters(number)),"millimeter", "millimeters", "yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromMillimetersToMeters(number)),"millimeter", "millimeters", "foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromMillimetersToMeters(number)),"millimeter", "millimeters", "inch", "inches")
            }
        }
        in mile -> {
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(fromMilesToMeters(number)),"mile","miles", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromMilesToMeters(number)),"mile","miles","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromMilesToMeters(number)),"mile","miles", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromMilesToMeters(number)),"mile","miles", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromMilesToMeters(number)),"mile","miles","mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromMilesToMeters(number)),"mile","miles","yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromMilesToMeters(number)),"mile","miles","foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromMilesToMeters(number)),"mile","miles","inch", "inches")
            }
        }
        in yard -> {
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(fromYardsToMeters(number)),"yard","yards", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromYardsToMeters(number)),"yard","yards","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromYardsToMeters(number)),"yard","yards", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromYardsToMeters(number)),"yard","yards", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromYardsToMeters(number)),"yard","yards","mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromYardsToMeters(number)),"yard","yards","yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromYardsToMeters(number)),"yard","yards","foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromYardsToMeters(number)),"yard","yards","inch", "inches")
            }
        }
        in foot -> {
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(fromFeetToMeters(number)),"foot","feet", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromFeetToMeters(number)),"foot","feet","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromFeetToMeters(number)),"foot","feet", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromFeetToMeters(number)),"foot","feet", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromFeetToMeters(number)),"foot","feet","mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromFeetToMeters(number)),"foot","feet","yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromFeetToMeters(number)),"foot","feet","foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromFeetToMeters(number)),"foot","feet","inch", "inches")
            }
        }
        in inch->{
            when(sink){
                in meter -> formatted(number, fromMetersToMeters(fromInchesToMeters(number)),"inch","inches", "meter", "meters")
                in kilometer-> formatted(number, fromMetersToKilometers(fromInchesToMeters(number)),"inch","inches","kilometer", "kilometers")
                in centimeter-> formatted(number, fromMetersToCentimeters(fromInchesToMeters(number)),"inch","inches", "centimeter", "centimeters")
                in millimeter-> formatted(number, fromMetersToMillimeters(fromInchesToMeters(number)),"inch","inches", "millimeter", "millimeters")
                in mile-> formatted(number, fromMetersToMiles(fromInchesToMeters(number)),"inch","inches","mile", "miles")
                in yard-> formatted(number, fromMetersToYards(fromInchesToMeters(number)),"inch","inches","yard", "yards")
                in foot-> formatted(number, fromMetersToFeet(fromInchesToMeters(number)),"inch","inches","foot", "feet")
                in inch-> formatted(number, fromMetersToInches(fromInchesToMeters(number)),"inch","inches","inch", "inches")
            }
        }
    }
}

fun fromGramToGram(number : Double) : Double{
    return number
}
fun fromGramToKilogram(number : Double) : Double{
    return number/1000
}
fun fromKilogramToGram(number : Double) : Double{
    return number*1000
}
fun fromGramToMilligram(number : Double) : Double{
    return number*1000
}
fun fromMilligramToGram(number : Double) : Double{
    return number/1000
}
fun fromGramToPound(number : Double) : Double{
    return number / 453.592
}
fun fromPoundToGram(number : Double) : Double{
    return number * 453.592
}
fun fromGramToOunce(number : Double) : Double{
    return number/28.3495
}
fun fromOunceToGram(number : Double) : Double{
    return number * 28.3495
}

fun weightConverter(number : Double, source : String, sink : String){
    if(number < 0){
        println("Weight shouldn't be negative")
        return
    }
    when(source){
        in gram -> {
            when(sink){
                in gram -> formatted(number, fromGramToGram(fromGramToGram(number)), "gram", "grams", "gram", "grams")
                in kilogram -> formatted(number, fromGramToKilogram(fromGramToGram(number)), "gram", "grams", "kilogram", "kilograms")
                in milligram -> formatted(number, fromGramToMilligram(fromGramToGram(number)), "gram", "grams", "milligram", "milligrams")
                in pound -> formatted(number, fromGramToPound(fromGramToGram(number)), "gram", "grams", "pound", "pounds")
                in ounce -> formatted(number, fromGramToOunce(fromGramToGram(number)), "gram", "grams", "ounce", "ounces")
            }
        }
        in milligram ->{
            when(sink){
                in gram -> formatted(number, fromGramToGram(fromMilligramToGram(number)), "milligram", "milligrams", "gram", "grams")
                in kilogram -> formatted(number, fromGramToKilogram(fromMilligramToGram(number)), "milligram", "milligrams", "kilogram", "kilograms")
                in milligram -> formatted(number, fromGramToMilligram(fromMilligramToGram(number)), "milligram", "milligrams", "milligram", "milligrams")
                in pound -> formatted(number, fromGramToPound(fromMilligramToGram(number)), "milligram", "milligrams", "pound", "pounds")
                in ounce -> formatted(number, fromGramToOunce(fromMilligramToGram(number)), "milligram", "milligrams", "ounce", "ounces")
            }
        }
        in kilogram ->{
            when(sink){
                in gram -> formatted(number, fromGramToGram(fromKilogramToGram(number)), "kilogram", "kilograms", "gram", "grams")
                in kilogram -> formatted(number, fromGramToKilogram(fromKilogramToGram(number)), "kilogram", "kilograms", "kilogram", "kilograms")
                in milligram -> formatted(number, fromGramToMilligram(fromKilogramToGram(number)), "kilogram", "kilograms", "milligram", "milligrams")
                in pound -> formatted(number, fromGramToPound(fromKilogramToGram(number)), "kilogram", "kilograms", "pound", "pounds")
                in ounce -> formatted(number, fromGramToOunce(fromKilogramToGram(number)), "kilogram", "kilograms", "ounce", "ounces")
            }
        }
        in pound ->{
            when(sink){
                in gram -> formatted(number, fromGramToGram(fromPoundToGram(number)), "pound", "pounds", "gram", "grams")
                in kilogram -> formatted(number, fromGramToKilogram(fromPoundToGram(number)), "pound", "pounds", "kilogram", "kilograms")
                in milligram -> formatted(number, fromGramToMilligram(fromPoundToGram(number)), "pound", "pounds", "milligram", "milligrams")
                in pound -> formatted(number, fromGramToPound(fromPoundToGram(number)), "pound", "pounds", "pound", "pounds")
                in ounce -> formatted(number, fromGramToOunce(fromPoundToGram(number)), "pound", "pounds", "ounce", "ounces")
            }
        }
        in ounce->{
            when(sink){
                in gram -> formatted(number, fromGramToGram(fromOunceToGram(number)), "ounce", "ounces", "gram", "grams")
                in kilogram -> formatted(number, fromGramToKilogram(fromOunceToGram(number)), "ounce", "ounces", "kilogram", "kilograms")
                in milligram -> formatted(number, fromGramToMilligram(fromOunceToGram(number)), "ounce", "ounces", "milligram", "milligrams")
                in pound -> formatted(number, fromGramToPound(fromOunceToGram(number)), "ounce", "ounces", "pound", "pounds")
                in ounce -> formatted(number, fromGramToOunce(fromOunceToGram(number)), "ounce", "ounces", "ounce", "ounces")
            }
        }
    }
}

fun fromCelsiusToFahrenheit(number : Double) : Double{
    return number*(9.0/5.0) + 32
}
fun fromFahrenheitToCelsius(number : Double) : Double{
    return (number - 32)*(5.0/9.0)
}
fun fromCelsiusToKelvin(number : Double) : Double{
    return number + 273.15
}
fun fromKelvinToCelsius(number : Double) : Double{
    return number - 273.15
}
fun fromFahrenheitToKelvin(number : Double) : Double{
    return ((number + 459.67)*(5.0/9.0))
}
fun fromKelvinToFahrenheit(number : Double) : Double{
    return number*(9.0/5.0) - 459.67
}
fun temperatureConverter(number : Double, source : String, sink : String){

    when(source){
        in celsius->{
            when(sink){
                in celsius -> formatted(number, number, "degree Celsius", "degrees Celsius", "degree Celsius", "degrees Celsius")
                in kelvin-> formatted(number, fromCelsiusToKelvin(number), "degree Celsius", "degrees Celsius", "kelvin", "kelvins")
                in fahrenheit -> formatted(number, fromCelsiusToFahrenheit(number), "degree Celsius", "degrees Celsius", "degree Fahrenheit", "degrees Fahrenheit")
            }
        }
        in kelvin->{
            when(sink){
                in celsius -> formatted(number, fromKelvinToCelsius(number), "kelvin", "kelvins", "degree Celsius", "degrees Celsius")
                in kelvin -> formatted(number, number, "kelvin", "kelvins", "kelvin", " kelvins")
                in fahrenheit -> formatted(number, fromKelvinToFahrenheit(number), "kelvin", "kelvins", "degree Fahrenheit", "degrees Fahrenheit")
            }
        }
        in fahrenheit->{
            when(sink){
                in celsius -> formatted(number, fromFahrenheitToCelsius(number), "degree Fahrenheit", "degrees Fahrenheit", "degree Celsius", "degrees Celsius")
                in kelvin -> formatted(number, fromFahrenheitToKelvin(number), "degree Fahrenheit", "degrees Fahrenheit", "kelvin", "kelvins")
                in fahrenheit -> formatted(number, number, "degree Fahrenheit", "degrees Fahrenheit", "degree Fahrenheit", "degrees Fahrenheit")
            }
        }
    }
}

fun isLength(str : String) : Pair<Boolean,String> {
    var result = false
    var string = ""
    lengthUnits.forEach{
        if(it.contains(str)){
            result = true
            string = it[2].toString()
        }
    }
    return result to string
}

fun isWeight(str : String) : Pair<Boolean, String>{
    var result = false
    var string = ""
    weightUnits.forEach{
        if(it.contains(str)){
            result = true
            string = it[2].toString()
        }
    }
    return result to string
}

fun isTemperature(str : String) : Pair<Boolean, String>{
    var result = false
    var string = ""
    temperatureUnits.forEach{
        if(it.contains(str)){
            result = true
            string = it[1].toString()
        }
    }
    return result to string
}

fun main(){

    while(true){
        println("Enter what you want to convert (or exit):")
        var parseError = false
        val input = readln()
        if(input == "exit") break
        val scanner = Scanner(input)

        val number : Double
        number = try{
            scanner.next().toDouble()
        }
        catch (e : Exception){
            parseError = true
            -1.0
        }
        var source : String
        source = try{
            scanner.next().lowercase()
        }
        catch (e : Exception){
            parseError = true
            "."
        }
        if(source == "degree" || source == "degrees"){
            source += try{
                " " + scanner.next().lowercase()
            }
            catch(e : Exception){
                parseError = true
                "."
            }
        }
        val something : String = try{
            scanner.next()
        }
        catch(e : Exception){
            parseError = true
            "."
        }
        var sink : String = try{
            scanner.next().lowercase()
        }
        catch (e : Exception){
            parseError = true
            "."
        }
        if(sink == "degree" || sink == "degrees"){
            sink += try{
                " " + scanner.next().lowercase()
            }
            catch (e : Exception){
                parseError = true
                "."
            }
        }
        if(parseError){
            println("Parse Error")
            continue
        }
        val sourceIsLength = isLength(source)
        val sourceIsWeight = isWeight(source)
        val sourceIsTemperature = isTemperature(source)
        val sinkIsWeight = isWeight(sink)
        val sinkIsLength = isLength(sink)
        val sinkIsTemperature = isTemperature(sink)

        if(sourceIsLength.first && sinkIsLength.first){
            lengthConverter(number, source, sink)
            continue
        }
        if(sourceIsWeight.first && sinkIsWeight.first){
            weightConverter(number, source, sink)
            continue
        }

        if(sourceIsTemperature.first && sinkIsTemperature.first){
            temperatureConverter(number, source, sink)
            continue
        }
        println("Conversion from ${if(sourceIsLength.first) sourceIsLength.second else if(sourceIsWeight.first) sourceIsWeight.second else if(sourceIsTemperature.first) sourceIsTemperature.second else "???"} to ${if(sinkIsLength.first) sinkIsLength.second else if(sinkIsWeight.first) sinkIsWeight.second else if(sinkIsTemperature.first) sinkIsTemperature.second else "???"} is impossible")

    }

}
