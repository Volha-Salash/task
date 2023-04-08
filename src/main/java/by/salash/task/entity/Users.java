package by.salash.task.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

/**
 * @author : Volha Salash
 */

/**
 * Class describing the object User
 */
@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    @NotBlank
    @JsonProperty(required = true)
    private String username;

    @Column(name = "state")
    @NotBlank
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "State Online/Offline")
    private String state;

    @Column(name = "email", updatable = false, nullable = false)
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "User`s email")
    @Email
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Avatar> avatars;

}
