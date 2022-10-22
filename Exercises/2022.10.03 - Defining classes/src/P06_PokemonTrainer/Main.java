package P06_PokemonTrainer;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> trainerNames = new ArrayList<>();
        Set<Trainer> trainerSet = new LinkedHashSet<>();
        Trainer currTrainer = null;

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] trainerData = input.split("\\s+");
            String trainerName = trainerData[0];
            String pokemonName = trainerData[1];
            String pokemonElement = trainerData[2];
            int pokemonHealth = Integer.parseInt(trainerData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainerNames.contains(trainerName)) {
                currTrainer = new Trainer(trainerName);
                trainerNames.add(trainerName);
                List<Pokemon> pokemonsList = new ArrayList<>();
                pokemonsList.add(pokemon);
                currTrainer.setPokemons(pokemonsList);
                trainerSet.add(currTrainer);

            } else {
                currTrainer = trainerSet.stream().filter(t -> trainerName.equals(t.getName()))
                        .findAny()
                        .orElse(null);
                List<Pokemon> currPokemonsList = currTrainer.getPokemons();
                currPokemonsList.add(pokemon);
                currTrainer.setPokemons(currPokemonsList);
            }

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            switch (command) {
                case "Fire":
                    checkCommandExistence(trainerSet, command);
                    break;

                case "Water":
                    checkCommandExistence(trainerSet, command);
                    break;

                case "Electricity":
                    checkCommandExistence(trainerSet, command);
                    break;
            }

            command = scanner.nextLine();
        }

        trainerSet.stream().sorted(Comparator.comparing(Trainer::getBadgesCount).reversed())
                .forEach(System.out::println);
    }

    public static void checkCommandExistence(Set<Trainer> trainerSet, String command) {
        for (Trainer trainer : trainerSet) {
            List<Pokemon> pokemonList = trainer.getPokemons();
            for (Pokemon pokemon : pokemonList) {
                if (pokemon.getElement().equals(command)) {
                    trainer.increaseBadges();
                    break;
                } else {
                    int updatedHealth = pokemon.getHealth() - 10;
                    if (updatedHealth <= 0) {
                        trainer.removePokemon(updatedHealth, pokemon);
                        break;
                    } else {
                        pokemon.setHealth(updatedHealth);
                    }
                }
            }
        }
    }

}
