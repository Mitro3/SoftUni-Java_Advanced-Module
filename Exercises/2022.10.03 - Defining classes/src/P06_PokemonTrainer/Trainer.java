package P06_PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badgesCount = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void removePokemon(int updatedHealth, Pokemon pokemon) {
            pokemons.remove(pokemon);
    }

    public void increaseBadges() {
        badgesCount++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badgesCount, getPokemons().size());
    }
}
