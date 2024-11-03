package dd.core;

/**
 * Class representing a King character, which is a type of Personaje (Character)
 * with higher health.
 * The Rey has a unique attack behavior where it performs three consecutive
 * attacks on an enemy.
 */
public class Rey extends Personaje {

    /**
     * Constructor to initialize the Rey with a specified name.
     * Sets the initial health to 2000, making it a very resilient character.
     *
     * @param nombre The name of the Rey character.
     */
    public Rey(String nombre) {
        super(nombre);
        super.setSalud(2000); // Set higher base health for the Rey
    }

    /**
     * Executes a triple attack on the specified enemy character.
     * The Rey performs three consecutive attacks, each dealing variable damage,
     * and reduces the enemy's health accordingly.
     *
     * @param enemigo The enemy character to attack.
     * @return An array of three integers representing the damage dealt in each of
     *         the three attacks.
     */
    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[3]; // Array to store damage from each of the three attacks
        for (int i = 0; i < 3; i++) {
            ataques[i] = this.getAtaque().lanzaAtaque(enemigo); // Calculate damage for each attack
            enemigo.setSalud(enemigo.getSalud() - ataques[i]); // Apply damage to the enemy's health
        }
        return ataques; // Return damage values for all three attacks
    }
}
