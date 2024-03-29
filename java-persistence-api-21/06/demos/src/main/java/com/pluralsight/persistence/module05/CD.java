package com.pluralsight.persistence.module05;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@NamedQueries({
        @NamedQuery(name = CD.FIND_ALL, query = "select c from CD c"),
})
public class CD extends Item implements Serializable {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "total_duration")
  private Float totalDuration;

  @Column(name = "music_company")
  private String musicCompany;

  private String genre;

  @ManyToMany
  @JoinTable(name = "cd_musician", joinColumns = @JoinColumn(name = "cd_fk"), inverseJoinColumns = @JoinColumn(name = "musician_fk"))
  private Set<Musician> musicians = new HashSet<>();

  // ======================================
  // =              Constant              =
  // ======================================

  public static final String FIND_ALL = "CD.findAll";

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD() {
  }

  public CD(String title) {
    this.title = title;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getMusicCompany() {
    return musicCompany;
  }

  public void setMusicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Set<Musician> getMusicians() {
    return musicians;
  }

  public void setMusicians(Set<Musician> musicians) {
    this.musicians = musicians;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    CD cd = (CD) o;

    if (genre != null ? !genre.equals(cd.genre) : cd.genre != null) return false;
    if (musicCompany != null ? !musicCompany.equals(cd.musicCompany) : cd.musicCompany != null) return false;
    if (totalDuration != null ? !totalDuration.equals(cd.totalDuration) : cd.totalDuration != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (totalDuration != null ? totalDuration.hashCode() : 0);
    result = 31 * result + (musicCompany != null ? musicCompany.hashCode() : 0);
    result = 31 * result + (genre != null ? genre.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CD{");
    sb.append("title='").append(title).append('\'');
    sb.append(", unitCost=").append(unitCost);
    sb.append(", totalDuration=").append(totalDuration);
    sb.append(", musicCompany=").append(musicCompany);
    sb.append(", genre=").append(genre);
    sb.append('}');
    return sb.toString();
  }
}