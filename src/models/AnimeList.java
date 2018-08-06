package models;


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

@Table(name = "animelist")
@NamedQueries({
    @NamedQuery(
        name = "getAllAnimeList",
        query = "SELECT a From AnimeList a ORDER BY a.id DESC"
        ),
    @NamedQuery(
        name = "getAnimeListCount",
        query = "SELECT COUNT(a) FROM AnimeList AS a"
        )
})
@Entity
public class AnimeList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "genre_id",nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @Column(name="title", length = 255,nullable = false)
    private String title;

    @Column(name="company",nullable = false)
    private String company;

    @Lob
    @Column(name="staff",nullable = false)
    private String staff;

    @Lob
    @Column(name="summary",nullable = false)
    private String summary;

    @Lob
    @Column(name="music",nullable = false)
    private String music;

    @Lob
    @Column(name="cast",nullable = false)
    private String cast;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

}
