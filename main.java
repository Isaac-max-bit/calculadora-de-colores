import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    private static final Map<String, Integer> colorMap = new HashMap<>();

    static{
        colorMap.put("negro", 0);
        colorMap.put("marron", 1);
        colorMap.put("rojo", 2);
        colorMap.put("naranja", 3);
        colorMap.put("amarillo", 4);
        colorMap.put("verde", 5);
        colorMap.put("azul", 6);
        colorMap.put("violeta", 7);
        colorMap.put("gris", 8);
        colorMap.put("blanco", 9);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la calculadora de código de colores para resistencias de 4 bandas");
        System.out.println("Ingrese el color de la primera banda:");
        String color1 = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese el color de la segunda banda:");
        String color2 = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese el color de la tercera banda (multiplicador):");
        String color3 = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese el color de la cuarta banda (tolerancia):");
        String color4 = scanner.nextLine().toLowerCase();

        if (!colorMap.containsKey(color1) || !colorMap.containsKey(color2) ||
            !colorMap.containsKey(color3) || !colorMap.containsKey(color4)) {
            System.out.println("Error: Uno o más colores ingresados son inválidos.");
            return;
        }

        int resistanceValue = (colorMap.get(color1) * 10 + colorMap.get(color2)) * (int) Math.pow(10, colorMap.get(color3));
        double tolerance = getToleranceValue(color4);

        System.out.println("Valor de la resistencia: " + resistanceValue + " ohms");
        System.out.println("Tolerancia: " + tolerance + "%");
    }

    private static double getToleranceValue(String color) {
        switch (color) {
            case "marrón":
                return 1;
            case "rojo":
                return 2;
            case "verde":
                return 0.5;
            case "azul":
                return 0.25;
            case "violeta":
                return 0.1;
            case "gris":
                return 0.05;
            case "oro":
                return 5;
            case "plata":
                return 10;
            default:
                return 20;
        }
    }
}


