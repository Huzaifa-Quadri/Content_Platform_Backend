package com.myapp.ContentPlatform.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myapp.ContentPlatform.model.post.Post;
import com.myapp.ContentPlatform.model.post.Stories;
import com.myapp.ContentPlatform.model.post.Post;
import com.myapp.ContentPlatform.model.post.Stories;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Post> posts = new ArrayList<>();
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Stories> stories = new ArrayList<>();
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Stories> users = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}