package dd.main;

/**
 * Entry point for the D&D-style game simulation.
 * This class simply starts the game by creating an instance of the ControlJuego
 * class.
 */
class DDApp {

    /**
     * Main method that launches the game simulation.
     * Creates a new ControlJuego instance, which initializes the game setup and
     * starts the game loop.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        new ControlJuego(); // Starts the game simulation
    }
}
