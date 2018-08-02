package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "category")
@NamedQueries({
    @NamedQuery(
        name = "getAllCategory",
        query = "SELECT c From Category c ORDER BY c.id DESC"
        ),
    @NamedQuery(
            name = "getCategoryCount",
            query = "SELECT COUNT(c) FROM Category AS c"
            ),
})
public class Category {
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

