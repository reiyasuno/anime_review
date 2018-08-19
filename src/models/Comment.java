package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="comment")
@NamedQueries({
    @NamedQuery(
            name="getAllComment",
            query="SELECT c FROM Comment AS c ORDER BY c.id DESC"
            ),
    @NamedQuery(
            name="getCommentCount",
            query="SELECT Count(c) FROM Comment AS c "
            ),
    @NamedQuery(
            name="getAnimeList",
            query="SELECT c FROM Comment AS c  WHERE c.animelist = :id ORDER BY c.id DESC"
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

    @Column(name = "comment_date", nullable = false)
    private Date comment_date;

    @Column(name="name",length = 255, nullable = false)
    private String name;

    @Lob
    @Column(name="content", length = 300,nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at",nullable=false)
    private Timestamp updated_at;

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

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
