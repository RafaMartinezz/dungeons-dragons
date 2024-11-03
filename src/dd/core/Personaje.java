package dd.core;

import java.util.Random;

/**
 * Abstract class representing a general character in the game, with attributes
 * for name, health, and an attack strategy.
 * Specific character types extend this class, implementing custom attack
 * behaviors.
 */
abstract public class Personaje {
    private String nombre; // Character's name
    private Ataque ataque; // Attack strategy assigned to the character
    private int salud; // Character's health points

    /**
     * Constructor to initialize a character with the specified name.
     *
     * @param nombre The name of the character.
     */
    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Sets the attack strategy for the character.
     *
     * @param ataque The attack strategy to assign to this character.
     */
    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    /**
     * Retrieves the current attack strategy of the character.
     *
     * @return The character's current attack strategy.
     */
    public Ataque getAtaque() {
        return ataque;
    }

    /**
     * Retrieves the current health points of the character.
     *
     * @return The current health points.
     */
    public int getSalud() {
        return this.salud;
    }

    /**
     * Sets the character's health points.
     *
     * @param salud The new health points for the character.
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Retrieves the name of the character.
     *
     * @return The character's name.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Randomly assigns an attack strategy to the character. The attack type is
     * chosen randomly
     * from three options: bow, knife, or sword.
     */
    public void ataqueRandom() {
        Random aleatorio = new Random();
        int numeroAtaque = aleatorio.nextInt(3); // Generate a random number between 0 and 2

        // Assign an attack strategy based on the random number
        switch (numeroAtaque) {
            case 0 -> this.ataque = new AtaqueArco();
            case 1 -> this.ataque = new AtaqueCuchillo();
            case 2 -> this.ataque = new AtaqueEspada();
        }
    }

    /**
     * Abstract method to perform an attack on an enemy character.
     * Each specific character subclass must define its own attack behavior.
     *
     * @param enemigo The enemy character to attack.
     * @return An array of integers representing the damage dealt in each part of
     *         the attack.
     */
    abstract public int[] ataca(Personaje enemigo);

    /**
     * Provides a string representation of the character, showing its name and
     * current health.
     *
     * @return A string with the character's name and health.
     */
    @Override
    public String toString() {
        return "[" + this.nombre + ":" + this.salud + "]";
    }
}
