package tshimoda.pokemon.server.model;

public class Elemental {
    private Integer id;
    private String name_en;
    private String name_ja;

    public Elemental() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ja() {
        return name_ja;
    }

    public void setName_ja(String name_ja) {
        this.name_ja = name_ja;
    }
}
