package dd.core;

import java.util.Random;

/**
 * Class representing an attack action using a sword.
 * Implements the Ataque interface to define a melee attack with a higher base
 * damage and
 * variable success and damage factors.
 */
public class AtaqueEspada implements Ataque {
    // Base damage value for the sword attack
    private final int ATAQUE = 100;

    /**
     * Executes a sword attack on the specified enemy character.
     * The attack's success and total damage are determined randomly:
     * - A success chance (50%) is simulated by generating a random integer (0 or
     * 1).
     * - A random damage factor between 0.0 and 1.0 is applied to the base attack
     * damage.
     *
     * @param enemigo The enemy character to attack.
     * @return The calculated damage inflicted on the enemy, which may be zero if
     *         the attack misses.
     */
    public int lanzaAtaque(Personaje enemigo) {
        int acierta = new Random().nextInt(2); // 50% chance of hit (1) or miss (0)
        double factor = new Random().nextDouble(1); // Random multiplier from 0.0 to 1.0
        int dañoTotal = (int) (this.ATAQUE * acierta * factor); // Calculate the final damage
        return dañoTotal;
    }

    /**
     * Returns a string representation of the attack type.
     *
     * @return A description of the attack, indicating it is a sword attack.
     */
    @Override
    public String toString() {
        return "Ataque con Espada";
    }
}
