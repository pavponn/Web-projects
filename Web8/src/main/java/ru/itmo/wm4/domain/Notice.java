package ru.itmo.wm4.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.assertj.core.util.Lists;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(indexes = @Index(columnList = "creationTime"))
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 5000)
    @Lob
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "notice_id", referencedColumnName = "id")
    private List<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "notice_tag",
            joinColumns = @JoinColumn(name = "notice_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags;

    @CreationTimestamp
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    public List<Tag> getTags() {
        return Lists.newArrayList(tags);
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    public void addTag(Tag tag) {
        if (tags == null) {
            tags = new HashSet<>();
        }
        tags.add(tag);
    }
}
