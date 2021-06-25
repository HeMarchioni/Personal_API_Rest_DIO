package one.digitalInovation.personaApi.model.person;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalInovation.personaApi.model.enums.PhoneType;

import javax.persistence.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gerar o valor automaticamente do id
    private Long cd_Phone;

    @Enumerated(EnumType.STRING)  // -> colocando a referencia que ira receber um enum do tipo String
    @Column(nullable = false)     // -> criando uma constraint ( essa coluna nao pode ser nula == notnull)
    private PhoneType type;

    @Column(nullable = false)
    private String number;


}
