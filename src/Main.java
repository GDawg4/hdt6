import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        Map<String, String> newMap;
        boolean isMapSelected = false;
        boolean wantsToContinue = true;

        do {
            Scanner S = new Scanner(System.in);
            String input = S.nextLine();
            System.out.println("Indique qué tipo de mapa desea utilizar");
            System.out.println("Opciones:");
            System.out.println("1. Hash Map");
            System.out.println("2. Tree Map");
            System.out.println("3. Linked HashMap");

            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                newMap = getCards(input);
                isMapSelected = true;
            }else {
                System.out.println("Este ingreso no es válido, favor intentar nuevamente");
            }
        }while (!isMapSelected);

        do {
            Scanner T = new Scanner(System.in);
            String input = T.nextLine();
            System.out.println("Indique qué desea hacer");
            System.out.println("Opciones:");
            System.out.println("1. Hash Map");
            System.out.println("2. Tree Map");
            System.out.println("3. Linked HashMap");

        }while (wantsToContinue);
    }
}