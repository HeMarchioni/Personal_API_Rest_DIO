package one.digitalInovation.personaApi.model.person;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gerar o valor automaticamente do id
    private Long cd_Person;

    @Column(nullable = false)
    private String nm_FirstName;

    @Column(nullable = false)
    private String nm_LastName;

    @Column(nullable = false, unique = true)  // notnull e unique
    private String cd_Cpf;

    private LocalDate dt_BirthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})  // -> campo com relacionamento com outra tabela ele ira criar a tabela de relacionamento (OneTomany 1 para muitos, fetch lazy para performace, casacade para a hora que for cadastrar ja a persona ja cadastrar o telefone.
    private List<Phone> phones = new ArrayList<>();

}
