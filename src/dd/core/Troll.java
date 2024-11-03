package dd.core;

/**
 * Class representing a Troll character, which is a type of Personaje
 * (Character) with moderate health.
 * The Troll has a single, straightforward attack behavior.
 */
public class Troll extends Personaje {

    /**
     * Constructor to initialize the Troll with a specified name.
     * Sets the initial health to 1000, making it less resilient compared to other
     * characters like Rey or Caballero.
     *
     * @param nombre The name of the Troll character.
     */
    public Troll(String nombre) {
        super(nombre);
        super.setSalud(1000); // Set moderate base health for the Troll
    }

    /**
     * Executes a single attack on the specified enemy character.
     * This method inflicts damage on the enemy based on the Troll's current attack
     * strategy.
     *
     * @param enemigo The enemy character to attack.
     * @return An array containing one integer, representing the damage dealt in
     *         this single attack.
     */
    public int[] ataca(Personaje enemigo) {
        int[] ataques = new int[1]; // Array to store the single attack damage
        ataques[0] = this.getAtaque().lanzaAtaque(enemigo); // Calculate damage for the attack
        enemigo.setSalud(enemigo.getSalud() - ataques[0]); // Apply damage to the enemy's health
        return ataques; // Return the damage dealt
    }
}
