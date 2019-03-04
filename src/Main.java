import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {

    public static Map<String, String> getCards(String typeOfMap){
        Map<String, String> currentMap;
        Factory currentFactory = new Factory();
        currentMap = currentFactory.getMap(typeOfMap);
        String fileName = "cards.txt";
        File file = new File(fileName);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.defaultCharset());
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                String[] twoElements = line.split("\\|");
                currentMap.put(twoElements[0], twoElements[1]);
            }
            br.close();
        }catch (FileNotFoundException e){

        }catch (IOException e){

        }
        return currentMap;
    }

    public static void main(String args[]){

        Map<String, String> currentMap;
        Map<String, Integer> userCollection;

        boolean isMapSelected = false;
        boolean wantsToContinue = true;

        do {
            Scanner S = new Scanner(System.in);
            System.out.println("Indique qué tipo de mapa desea utilizar");
            System.out.println("Opciones:");
            System.out.println("1. Hash Map");
            System.out.println("2. Tree Map");
            System.out.println("3. Linked HashMap");
            String input = S.nextLine();

            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                currentMap = getCards(input);
                userCollection = new HashMap<>();
                isMapSelected = true;

                do {
                    Scanner T = new Scanner(System.in);

                    System.out.println("\n Indique el número de la opción qué desea hacer");
                    System.out.println("Opciones:");
                    System.out.println("1. Agregar una carta a la colección");
                    System.out.println("2. Mostrar una carta específica");
                    System.out.println("3. Mostrar el tipo, nombre y cantidad de una carta en su colección");
                    System.out.println("4. Mostrar el tipo, nombre y cantidad de una carta en su colección, ordenadas por tipo");
                    System.out.println("5. Mostrar el nombre y tipo de las cartas existentes");
                    System.out.println("6. Mostrar el nombre y tipo de las cartas existentes, ordenadas por tipo");
                    System.out.println("7. Salir");
                    String input2 = T.nextLine();

                    switch (input2){
                        case ("1"):
                            System.out.println("Ingrese el nombre de la carta qué desea agregar");
                            String cardName = T.nextLine();
                            if (currentMap.get(cardName) != null){
                                if (userCollection.get(cardName) == null){
                                    userCollection.put(cardName, 1);
                                }
                                else {
                                 userCollection.put(cardName, userCollection.get(cardName) + 1);
                                }
                                System.out.println("Carta agregada éxitosamente");
                            }else {
                                System.out.println("Esta carta no está en la colección");
                            }
                            break;

                        case("2"):
                            System.out.println("Ingrese el nombre de la carta qué desea consultar");
                            String cardToCheck = T.nextLine();

                            if (currentMap.get(cardToCheck) != null){
                                System.out.println(currentMap.get(cardToCheck));
                            }else {
                                System.out.println("Esta carta no está en la colección");
                            }
                            break;

                        case ("3"):
                            //obtenido de: https://www.geeksforgeeks.org/count-occurrences-elements-list-java/
                            for (Map.Entry m : userCollection.entrySet())
                                System.out.println("La carta "
                                        + m.getKey()
                                        + " de tipo "
                                        + currentMap.get(m.getKey())
                                        + " aparece "
                                        + m.getValue());
                            break;
                        case ("4"):
                            //obtenido de https://www.javacodegeeks.com/2017/09/java-8-sorting-hashmap-values-ascending-descending-order.html

                            HashMap<String, String> toBeSorted = new HashMap<>();

                            for (Map.Entry m : userCollection.entrySet())
                                toBeSorted.put(m.getKey().toString(), currentMap.get(m.getKey().toString()));

                            HashMap<String, String> sorted = toBeSorted
                                    .entrySet()
                                    .stream()
                                    .sorted(comparingByValue())
                                    .collect(
                                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                                    LinkedHashMap::new));

                            for (Map.Entry m : sorted.entrySet())
                                System.out.println("La carta "
                                        + m.getKey()
                                        + " de tipo "
                                        + currentMap.get(m.getKey())
                                        + " aparece "
                                        + m.getValue());
                            break;

                        case ("5"):
                            for (Map.Entry m : currentMap.entrySet())
                                System.out.println(
                                        "La carta "
                                        + m.getKey()
                                        + " es de tipo "
                                        + m.getValue()
                                );
                            break;
                        case("6"):
                            HashMap<String, String> sortedAll = currentMap
                                    .entrySet()
                                    .stream()
                                    .sorted(comparingByValue())
                                    .collect(
                                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                                    LinkedHashMap::new));

                            for (Map.Entry m : sortedAll.entrySet())
                                System.out.println("La carta "
                                        + m.getKey()
                                        + " es de tipo "
                                        + m.getValue());
                            break;
                        case ("7"):
                            wantsToContinue = false;
                            break;
                    }
                }while (wantsToContinue);


            }else {
                System.out.println("Este ingreso no es válido, favor intentar nuevamente");
            }
        }while (!isMapSelected);


    }
}