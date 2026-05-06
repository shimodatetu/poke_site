package tshimoda.pokemon.server.model;

import java.util.List;

public class Pokemon {
    private Integer id;
    private Integer pokedexId;
    private String name;
    private List<Elemental> elementals;

    public Pokemon() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Elemental> getElementals() {
        return elementals;
    }

    public void setElementals(List<Elemental> elementals) {
        this.elementals = elementals;
    }
}
