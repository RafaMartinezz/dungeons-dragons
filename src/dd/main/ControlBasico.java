package dd.main;

import dd.core.AtaqueArco;
import dd.core.AtaqueEspada;
import dd.core.Personaje;
import dd.core.Rey;
import dd.core.Troll;

/**
 * Main class for testing character interactions without armies or victory
 * conditions.
 * This class sets up two characters with different attack strategies and
 * simulates
 * attack scenarios to test combat mechanics, health adjustments, and death
 * conditions.
 */
public class ControlBasico {
    public static void main(String[] args) {
        // Create a Rey character named "Arturo" with a sword attack strategy
        Personaje p1 = new Rey("Arturo");
        p1.setAtaque(new AtaqueEspada());

        // Create a Troll character named "Troll 1" with a bow attack strategy
        Personaje p2 = new Troll("Troll 1");
        p2.setAtaque(new AtaqueArco());

        // Display initial character statuses and attack types
        System.out.println(p1 + ", " + p1.getAtaque());
        System.out.println(p2 + ", " + p2.getAtaque());

        // Execute and display the results of p1's attack on p2
        int[] valoresAtaque = p1.ataca(p2);
        for (int valor : valoresAtaque) {
            System.out.println("p1 ataca a p2 y el valor del ataque es: " + (valor > 0 ? valor : "falla"));
        }

        // Check and display the updated health of p2
        System.out.println("Comprobar salud actualizada de p2");
        // If health is <= 0, the character is considered dead
        System.out.println(p2.getSalud() <= 0 ? "MUERTO " + p2.getNombre() : p2);

        // Set p2's health to 1 to simulate a scenario where it can be defeated by the
        // next attack
        System.out.println("Vamos a repetir el ataque pero ahora forzando que p2 muera poniendo salud a 1");
        p2.setSalud(1);

        // Execute and display the results of another attack from p1 on p2
        valoresAtaque = p1.ataca(p2);
        for (int valor : valoresAtaque) {
            System.out.println("p1 ataca a p2 y el valor del ataque es: " + (valor > 0 ? valor : "falla"));
        }

        // Final check of p2's health to confirm if it survived or was defeated
        System.out.println("Comprobar salud actualizada de p2");
        System.out.println(p2.getSalud() <= 0 ? "MUERTO maldito " + p2.getNombre() : p2);
    }
}
