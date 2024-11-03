package dd.core;

/**
 * Class representing a Knight character, which is a type of Personaje
 * (Character) with higher health.
 * The Caballero has a unique attack behavior where it attacks twice in
 * succession.
 */
public class Caballero extends Personaje {

    /**
     * Constructor to initialize the Caballero with a given name.
     * Sets the initial health to 1500, making it a more resilient character.
     *
     * @param nombre The name of the Caballero character.
     */
    public Caballero(String nombre) {
        super(nombre);
        super.setSalud(1500); // Set higher base health for the Caballero
    }

    /**
     * Executes a double attack on the specified enemy character. The Caballero
     * attacks twice in succession,
     * dealing damage on each strike and reducing the enemy's health accordingly.
     *
     * @param enemigo The enemy character to attack.
     * @return An array of two integers representing the damage dealt in each of the
     *         two attacks.
     */
    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[2]; // Array to store damage from each of the two attacks
        for (int i = 0; i < 2; i++) {
            ataques[i] = this.getAtaque().lanzaAtaque(enemigo); // Calculate damage for the attack
            enemigo.setSalud(enemigo.getSalud() - ataques[i]); // Apply damage to enemy's health
        }
        return ataques; // Return damage values for both attacks
    }
}
