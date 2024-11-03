package dd.core;

/**
 * Interface that defines the attack behavior for characters in the game.
 * Implementing classes should provide specific attack logic to be used
 * against an enemy character.
 */
public interface Ataque {

    /**
     * Executes an attack action on the specified enemy character.
     *
     * @param enemigo The enemy character that the attack is directed towards.
     * @return The amount of damage inflicted on the enemy character.
     */
    public int lanzaAtaque(Personaje enemigo);
}
