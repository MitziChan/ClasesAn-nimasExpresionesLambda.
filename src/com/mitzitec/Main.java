package com.mitzitec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    List<String> strings = new ArrayList<>();

    public void loadStrings(String...strings){
        for (var string : strings) this.strings.add(string);
    }

    public List<String> sortAlphabeticAnonymousClass(){
        List<String> strings = this.strings;
        Collections.sort(strings ,new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });
        return strings;
    }

    public List<String> sortAlphabeticLambdaFunction(){
        List<String> strings = this.strings;
        strings.sort((str1,str2) -> str1.compareToIgnoreCase(str2));
        return strings;
    }

    public List<String> sortAlphabeticReference(){
        List<String> strings = this.strings;
        SortAlphabetic sortAlphabetic = new SortAlphabetic();
        Collections.sort(strings,sortAlphabetic::compare);
        return strings;
    }

    public List<String> sortLenghtAnonymousClass(){
        List<String> strings = this.strings;
        strings.sort( new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        return strings;
    }

    public List<String> sortLenghtLambaFunction(){
        List<String> strings = this.strings;
        Collections.sort(strings,(str1,str2) ->  str1.length() - str2.length());
        return strings;
    }

    public List<String> sortLenghtReference(){
        List<String> strings = this.strings;
        SortLenght sortLenght = new SortLenght();
        strings.sort(sortLenght::compare);
        return strings;
    }

    public void showList(List<String> list){
        list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.loadStrings (
                "Hamster",
                "Rata",
                "Perro",
                "Gato",
                "Pato",
                "Serpiente",
                "Gallo",
                "Ganso",
                "Tarantula",
                "Tortuga");

        var sortLenghtAnonymousClass = main.sortLenghtAnonymousClass();
        System.out.println("");
        System.out.println("¡Bienvenido!");
        System.out.println("");
        System.out.println("____________________________");
        System.out.println("\nLongitud por Clase anónima");
        System.out.println("____________________________");
        main.showList(sortLenghtAnonymousClass);
        var sortAlphabeticByAnonymousClass = main.sortAlphabeticAnonymousClass();
        System.out.println("____________________________________");
        System.out.println("\nOrden alfabético por Clase anónima");
        System.out.println("____________________________________");
        main.showList(sortAlphabeticByAnonymousClass);

        var sortLenghtLambdaFunction = main.sortLenghtLambaFunction();
        System.out.println("_______________________________");
        System.out.println("\nLongitud por Expresión Lambda");
        System.out.println("_______________________________");
        main.showList(sortLenghtLambdaFunction);
        var sortAlphabeticByLambda = main.sortAlphabeticLambdaFunction();
        System.out.println("_______________________________________");
        System.out.println("\nOrden alfabético por Expresión Lambda");
        System.out.println("_______________________________________");
        main.showList(sortAlphabeticByLambda);

        var sortLenghtReference = main.sortLenghtReference();
        System.out.println("___________________________________");
        System.out.println("\nLongitud por Método De referencia");
        System.out.println("___________________________________");
        main.showList(sortLenghtReference);
        var sortAlphabeticByReference = main.sortAlphabeticReference();
        System.out.println("________________________________________");
        System.out.println("\nOrden alfabético: Método De referencia");
        System.out.println("________________________________________");
        main.showList(sortAlphabeticByReference);
    }
}

class SortAlphabetic implements Comparator{

    public static int sort(Object o, Object o1) {
        return o.toString().compareToIgnoreCase(o1.toString());
    }

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}

class SortLenght implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().length() - o2.toString().length();
    }
}