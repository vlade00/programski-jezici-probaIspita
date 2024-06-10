package rc.as.singidunum.spring_dan1.repository;
//4.korak
//Sluzi za queery nad bazom

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.as.singidunum.spring_dan1.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByAndDeletedAtIsNull();
    Optional<Student> findByIdAndDeletedAtIsNull(Integer id);
    //Pazi ovo se radi nakon onog frontenda
    List<Student> findByIndeksContainsAndDeletedAtIsNull(String indeks);


}
