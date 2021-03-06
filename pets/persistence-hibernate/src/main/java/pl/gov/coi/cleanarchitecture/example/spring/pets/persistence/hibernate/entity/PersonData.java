package pl.gov.coi.cleanarchitecture.example.spring.pets.persistence.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="krzysztof.suszynski@wavesoftware.pl">Krzysztof Suszyński</a>
 * @since 2018-01-18
 */
@Entity
@Table
@Getter
@Setter
@Access(AccessType.PROPERTY)
@NoArgsConstructor
public class PersonData extends Record {

  private static final long serialVersionUID = 20180430195435L;

  private String name;
  private String surname;
  private Set<OwnershipData> ownerships = new HashSet<>();

  // JPA Mappings

  @NotNull
  @Column
  public String getName() {
    return name;
  }

  @NotNull
  @Column
  public String getSurname() {
    return surname;
  }

  @OneToMany(
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "person",
    orphanRemoval = true
  )
  public Set<OwnershipData> getOwnerships() {
    return ownerships;
  }

}
