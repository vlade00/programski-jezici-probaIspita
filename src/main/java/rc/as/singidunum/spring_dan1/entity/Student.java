package rc.as.singidunum.spring_dan1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//1.Pravo ime tabele ide u Entity
@Entity(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    //2.Deklarisemo Id iz tabele(student_id)
    //On zna po ovom ID-u dole, da po njemu pisemo querry u klasi(StudentRepository)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "student_id")
    //Integer moze da se nazove kako god al ovo gore name mora kako je u tabeli
    private Integer id;

    //3.Deklarisemo preostale podatke iz tabele i stavljamo im da su NN i indeks UNIQUE
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String indeks;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;

}
