package by.salash.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author : Volha Salash
 */


/**
 * Class describing the object Avatar of user
 */
@Entity
@Table(name = "avatars")
@Getter
@Setter
public class Avatar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @JsonProperty(required = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Users user;

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}";
    }

}