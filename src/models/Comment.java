package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="comment")
@NamedQueries({
    @NamedQuery(
            name="getAllComment",
            query="SELECT c FROM Comment c ORDER BY c.id DESC"
            ),
    @NamedQuery(
            name="getCommentCount",
            query="SELECT Count(c) FROM Comment AS c "
            )
})
@Entity
public class Comment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "animelist_id",nullable = false)
    private AnimeList animelist;

    @Column(name="content", length = 300,nullable = false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AnimeList getAnimelist() {
        return animelist;
    }

    public void setAnimelist(AnimeList animelist) {
        this.animelist = animelist;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
