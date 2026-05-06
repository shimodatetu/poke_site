package tshimoda.pokemon.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tshimoda.pokemon.server.model.Elemental;
import tshimoda.pokemon.server.model.Pokemon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PokemonRepository {
    private final DataClassRowMapper<Pokemon> mapper = new DataClassRowMapper<>(Pokemon.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PokemonRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pokemon> selectAll() {
        String sql = "SELECT pokemon.id AS pokemon_id,pokemon.name AS pokemon_name, pokemon.pokedex_id AS pokedex_id,elemental.id AS elemental_id,elemental.name_ja AS elemental_name,elemental.name_en  AS elemental_name_en FROM pokemon INNER JOIN pokemon_elemental ON pokemon.id = pokemon_elemental.pokemon_id INNER JOIN elemental ON pokemon_elemental.elemental_id = elemental.id ORDER BY pokemon.id;";

        return jdbcTemplate.query(sql, (ResultSet rs) -> {
            Map<Integer, Pokemon> pokemonMap = new LinkedHashMap<>();
           while (rs.next()){

               int pokemonId = rs.getInt("pokemon_id");
                Pokemon pokemon =
                        pokemonMap.computeIfAbsent(pokemonId,id->{
                           Pokemon p = new Pokemon();
                           p.setId(id);
                            try {
                                p.setName(rs.getString("pokemon_name"));
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            try {
                                p.setPokedexId(rs.getInt("pokedex_id"));
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            p.setElementals(new ArrayList<>());
                           return p;
                        });
                int elementalId = rs.getInt("elemental_id");
                if(elementalId != 0){
                    Elemental elemental = new Elemental();
                    elemental.setId(elementalId);
                    elemental.setName_en(rs.getString("elemental_name_en"));
                    elemental.setName_ja(rs.getString("elemental_name"));
                    pokemon.getElementals().add(elemental);
                }
            }
            return new ArrayList<>(pokemonMap.values());
        });
    }
}
