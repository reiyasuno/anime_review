package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "genre")
@NamedQueries({
    @NamedQuery(
        name = "getAllGenre",
        query = "SELECT g From Genre g ORDER BY g.id DESC"
        ),
    @NamedQuery(
            name = "getGenreCount",
            query = "SELECT COUNT(g) FROM Genre AS g"
            ),
})
public class Genre {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
