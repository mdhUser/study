package org.maxwell.se.base.course;

import java.util.Objects;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/24 17:34
 */
public class Movie {

    private String title;
    private String director;
    private String type;

    public Movie(String title, String director, String type) {
        this.title = title;
        this.director = director;
        this.type = type;
    }


    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                title + "-" + director + "-" + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title) && director.equals(movie.director) && type.equals(movie.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, type);
    }
}