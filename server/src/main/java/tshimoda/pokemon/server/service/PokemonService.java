package tshimoda.pokemon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tshimoda.pokemon.server.model.Pokemon;
import tshimoda.pokemon.server.repository.PokemonRepository;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }
    public List<Pokemon> pokemonListAll() {
        return pokemonRepository.selectAll();
    }
}
