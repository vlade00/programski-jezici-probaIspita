package rc.as.singidunum.spring_dan1.service;
//6.klasa

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rc.as.singidunum.spring_dan1.entity.Student;
import rc.as.singidunum.spring_dan1.model.StudentModel;
import rc.as.singidunum.spring_dan1.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
//da bi imali konstruktor za student repository
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAllByAndDeletedAtIsNull();
    }

    public Optional<Student> getStudentById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }
    //Pazi ovo se radi nakon onog frontenda
    public List<Student> getStudentByIndeks(String indeks) {
        return repository.findByIndeksContainsAndDeletedAtIsNull(indeks);
    }
    //Ovde pravimo da mozemo izmeniti update
    public Student createStudent(StudentModel model){
        Student student = new Student();
        student.setName(model.getName());
        student.setSurname(model.getSurname());
        student.setIndeks(model.getIndeks());
        student.setCreatedAt(LocalDateTime.now());
        return repository.save(student);
    }

    public Student updateStudent(Integer id, StudentModel model){
        Student student = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        student.setName(model.getName());
        student.setSurname(model.getSurname());
        student.setIndeks(model.getIndeks());
        student.setUpdatedAt(LocalDateTime.now());
        return repository.save(student);
    }

    public void deletedStudent(Integer id){
        Student student = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        student.setDeletedAt(LocalDateTime.now());
        repository.save(student);
    }
}
