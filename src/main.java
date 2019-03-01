import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String args[]){
        Map currentMap;
        Factory currentFactory = new Factory();
        Scanner S = new Scanner(System.in);
        System.out.println("Indique qué tipo de carrta desea utilizar");
        System.out.println("Opciones:");
        System.out.println("Hash Map");
        System.out.println("Tree Map:");
        System.out.println("Linked HashMap");

        String input = S.nextLine();
        if (input.equals("1") || input.equals("2") || input.equals("3")){
            currentMap = currentFactory.getMap(input);
            System.out.println("yay");
            currentMap.put("yay", "yay2");
        }
        else {
            System.out.println("Este ingreso no es válido, favor intentar nuevamente");
        }
    }
}