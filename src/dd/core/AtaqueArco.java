package dd.core;

import java.util.Random;

/**
 * Class representing an attack action using a bow.
 * Implements the Ataque interface to define a ranged attack with variable
 * accuracy and damage factor.
 */
public class AtaqueArco implements Ataque {
    // Base damage value for the bow attack
    private final int ATAQUE = 50;

    /**
     * Executes a bow attack on the specified enemy character. The attack success
     * and total damage
     * are determined randomly:
     * - A success chance (50%) is simulated by a random integer (0 or 1).
     * - A random damage factor between 0.0 and 1.0 is applied to the base attack
     * damage.
     *
     * @param enemigo The enemy character to attack.
     * @return The calculated damage inflicted on the enemy, which may be zero if
     *         the attack misses.
     */
    public int lanzaAtaque(Personaje enemigo) {
        int acierta = new Random().nextInt(2); // 50% chance to hit the target (1) or miss (0)
        double factor = new Random().nextDouble(1); // Random multiplier from 0.0 to 1.0
        int dañoTotal = (int) (this.ATAQUE * acierta * factor); // Calculate the final damage
        return dañoTotal;
    }

    /**
     * Returns a string representation of the attack type.
     *
     * @return A description of the attack, indicating it is a bow attack.
     */
    @Override
    public String toString() {
        return "Ataque con Arco";
    }
}
