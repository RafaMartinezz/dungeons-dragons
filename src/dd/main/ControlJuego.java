package dd.main;

import dd.core.*;
import java.util.Random;

/**
 * Class to simulate a battle between an army of "Hombres" (Humans) and an army
 * of "Trolls".
 * The game continues until one side is completely defeated, with attacks
 * alternating between the armies.
 */
public class ControlJuego {
    // Arrays to store the characters in each army
    Personaje[] hombres;
    Personaje[] trolls;
    boolean finJuego = false; // Flag to determine if the game is over
    String ganador = ""; // Stores the name of the winning team
    Random aleatorio = new Random();

    /**
     * Constructor to initialize the game. Creates both armies, presents the
     * storyline,
     * and initiates the game flow.
     */
    ControlJuego() {
        construirEjercitoHombres();
        construirEjercitoTrolls();
        presentacion();
        jugar();
        vencedor();
    }

    /**
     * Constructs the army of "Hombres" (Humans) with predefined characters.
     * Initializes an array of three characters: one "Rey" and two "Caballero" with
     * different attack strategies.
     */
    public void construirEjercitoHombres() {
        hombres = new Personaje[3];
        hombres[0] = new Rey("Arturo");
        hombres[0].setAtaque(new AtaqueEspada());
        hombres[1] = new Caballero("Lancelot");
        hombres[1].setAtaque(new AtaqueEspada());
        hombres[2] = new Caballero("Percival");
        hombres[2].setAtaque(new AtaqueArco());
    }

    /**
     * Constructs the army of "Trolls" with a randomized number of trolls (between 2
     * and 10).
     * Each troll is assigned a random attack strategy.
     */
    public void construirEjercitoTrolls() {
        int numeroTrolls = aleatorio.nextInt(2, 11); // Random number of trolls between 2 and 10
        trolls = new Personaje[numeroTrolls];
        for (int i = 0; i < numeroTrolls; i++) {
            trolls[i] = new Troll("Troll" + i);
            trolls[i].ataqueRandom(); // Assigns a random attack strategy
        }
    }

    /**
     * Removes a dead character from the specified army by creating a new array
     * without characters whose health is zero or below.
     *
     * @param ejercito The army array from which to remove dead characters.
     */
    public void retirarCadaver(Personaje[] ejercito) {
        Personaje[] nuevoEjercito = new Personaje[ejercito.length - 1];
        for (int i = 0, j = 0; i < ejercito.length; i++) {
            if (ejercito[i].getSalud() <= 0) {
                continue; // Skip dead characters
            } else {
                nuevoEjercito[j] = ejercito[i];
                j++;
            }
        }
        if (ejercito == this.hombres) {
            this.hombres = nuevoEjercito;
        } else {
            this.trolls = nuevoEjercito;
        }
    }

    /**
     * Executes a turn for the "Hombres" army. Each character attacks a random
     * troll.
     * If a troll's health drops to zero or below, it is removed from the army.
     */
    public void turnoHombres() {
        for (Personaje soldado : hombres) {
            if (trolls.length == 0) {
                this.finJuego = true;
                this.ganador = "Hombres";
                break;
            }
            int numeroTroll = aleatorio.nextInt(trolls.length); // Select a random troll
            System.out.println(soldado + " lucha contra " + trolls[numeroTroll]);
            int[] ataques = soldado.ataca(trolls[numeroTroll]);

            // Print each attack result
            if (soldado instanceof Rey) {
                for (int i = 0; i < 3; i++) {
                    System.out
                            .println(soldado.getAtaque() + " (" + (ataques[i] == 0 ? "falla" : "-" + ataques[i]) + ")");
                }
            } else if (soldado instanceof Caballero) {
                for (int i = 0; i < 2; i++) {
                    System.out
                            .println(soldado.getAtaque() + " (" + (ataques[i] == 0 ? "falla" : "-" + ataques[i]) + ")");
                }
            }
            if (trolls[numeroTroll].getSalud() <= 0) {
                System.out.println(trolls[numeroTroll] + " muere!");
                retirarCadaver(trolls);
            }
        }
    }

    /**
     * Executes a turn for the "Trolls" army. Each troll attacks a random character
     * from the "Hombres" army.
     * If a character's health drops to zero or below, it is removed from the army.
     */
    public void turnoTrolls() {
        for (Personaje troll : trolls) {
            if (hombres.length == 0) {
                this.finJuego = true;
                this.ganador = "Trolls";
                break;
            }
            int soldado = aleatorio.nextInt(hombres.length); // Select a random human soldier
            System.out.println(troll + " lucha contra " + hombres[soldado]);
            int ataque = troll.ataca(hombres[soldado])[0]; // Trolls perform a single attack
            System.out.println(troll.getAtaque() + " (" + (ataque == 0 ? "falla" : "-" + ataque) + ")");
            if (hombres[soldado].getSalud() <= 0) {
                System.out.println(hombres[soldado] + " muere!");
                retirarCadaver(hombres);
            }
        }
    }

    /**
     * Main game loop. Alternates between turns for the "Hombres" and "Trolls"
     * armies
     * until one army is entirely defeated.
     */
    public void jugar() {
        while (!this.finJuego) {
            turnoHombres();
            if (this.finJuego) {
                break;
            }
            turnoTrolls();
        }
    }

    /**
     * Declares the winner of the game and displays the remaining characters in the
     * winning army.
     */
    public void vencedor() {
        if (ganador.equals("Hombres")) {
            System.out.println("Finalmente el ejercito del Rey Arturo venció!!");
            System.out.println("Los supervivientes de la batalla fueron");
            for (Personaje soldado : hombres) {
                System.out.print(soldado);
            }
        } else {
            System.out.println("Han ganado los trolls...");
        }
    }

    /**
     * Prints an introductory story and the initial setup of the game.
     */
    public void presentacion() {
        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera");
        System.out.println("la partida formada por: " + hombres);
        System.out.println("hallándose en los frondosos bosques del sitio de Deorham, se topó con una");
        System.out.println("patrulla de esas sanguinarias e inhumanas criaturas popularmente");
        System.out.println("conocidas como trolls.");
        System.out.println("De la batalla que aconteció, dejo aquí testimonio:");
    }
}
