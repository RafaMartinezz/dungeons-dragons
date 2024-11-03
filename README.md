# D&D Game Simulation

This project is a Java-based simulation of a battle between two armies inspired by D&D-style gameplay mechanics. The game involves two opposing factions: **Hombres** (Humans), led by King Arthur, and **Trolls**, a group of hostile creatures. The simulation alternates turns between the two armies until one side is entirely defeated.

## Table of Contents

- [Game Overview](#game-overview)
- [Characters](#characters)
- [Attacks](#attacks)
- [Installation](#installation)
- [Usage](#usage)
- [Game Flow](#game-flow)
- [Example Output](#example-output)
- [Customization](#customization)
- [License](#license)

---

## Game Overview

The game simulates a battle between two armies, with characters from each army taking turns to attack. Each character has different health points and attack capabilities, making the game a dynamic simulation of character interactions and combat outcomes.

The game ends when all characters from one army have been defeated. A victory message is displayed for the winning side, and any remaining characters are listed as survivors.

## Characters

### Hombres (Humans)
The **Hombres** army consists of the following characters:
- **Rey**: A resilient character with high health and a powerful three-part attack.
- **Caballero**: A skilled fighter with moderate health, capable of a double attack.

### Trolls
The **Trolls** army is composed of a variable number of troll characters, each with moderate health and a single attack.

## Attacks

Each character can be assigned one of three types of attacks:
1. **AtaqueArco (Bow Attack)**: A ranged attack with a moderate chance of hitting.
2. **AtaqueCuchillo (Knife Attack)**: A close-range attack with a lower damage output.
3. **AtaqueEspada (Sword Attack)**: A powerful melee attack with high damage potential.

Each attack type has randomized hit chances and damage factors, creating an element of unpredictability in each turn.

## Game Flow

1. **Initialization**:
   - Armies are created: **Hombres** has a fixed number of characters, while the **Trolls** army has a random size between 2 and 10.
   - Each character is assigned an attack strategy.

2. **Turns**:
   - The **Hombres** take their turn, with each character attacking a random troll.
   - If a troll's health reaches zero or below, it is removed from the army.
   - Next, the **Trolls** take their turn, with each troll attacking a random human character.
   - If a character's health reaches zero or below, it is removed from the army.

3. **Endgame**:
   - The game loop continues until one army is entirely defeated.
   - The surviving army is declared the winner, and the remaining characters are displayed as survivors.

## Example Output

An example of the game’s output:

```
Tal día como hoy, en una húmeda y fría mañana de finales de primavera...
[Rey Arturo:2000] lucha contra [Troll3:1000]
AtaqueEspada(-150)
AtaqueEspada(-200)
Troll3 muere!
...
Finalmente el ejército del Rey Arturo venció!!
Los supervivientes de la batalla fueron:
[Rey Arturo: 1200], [Caballero Lancelot: 900]
```

## Customization

- **Adding New Characters**: Extend the `Personaje` abstract class to create new character types with customized health and attack behavior.
- **Creating New Attacks**: Implement the `Ataque` interface to define new attack types with unique damage logic.
- **Adjusting Army Sizes**: Modify the random range in `construirEjercitoTrolls` for the number of trolls, or alter the number of characters in the `Hombres` array in `construirEjercitoHombres`.