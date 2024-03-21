package br.com.surb.surbeventos.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_activity")
public class Activity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6540400649218654723L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "activities")
    private final Set<Participant> activities = new HashSet<>();

    @OneToMany(mappedBy = "activity")
    private final List<Block> blocks = new ArrayList<>();

    public Activity() {
    }

    public Activity(Long activityId, String name, String description, Double price) {
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public Set<Participant> getActivities() {
        return activities;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Activity activity = (Activity) object;
        return Objects.equals(activityId, activity.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId);
    }
}
