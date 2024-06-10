package rc.as.singidunum.spring_dan1.controller;

//5.korak
//Sluzi da npr stavimo putanju //students i on ucita sve studente

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.as.singidunum.spring_dan1.entity.Student;
import rc.as.singidunum.spring_dan1.model.StudentModel;
import rc.as.singidunum.spring_dan1.service.StudentService;

import java.util.List;

//ovim mu kazemo da je kontroler
@RestController
//putanja kad ukucamo student
@RequestMapping(path = "/api/student")
//Generise konstruktor automatski ovom dole repository
@RequiredArgsConstructor
//origin je za frontend
@CrossOrigin
public class StudentController {

    private final StudentService service;

    @GetMapping(path = "/" )
    public List<Student> getAllStudents() {

        return service.getAllStudents();

    }

    //ResponseEntity , nece da se desi da ne nadje studenta i izbaci 404 error
    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getStudentById(id));
    }

    @GetMapping(path = "/indeks/{indeks}")
    //Pazi ovo se radi nakon onog frontenda
    public List<Student> getStudentByIndeks(@PathVariable String indeks) {
        return service.getStudentByIndeks(indeks);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentModel student){
        return service.createStudent(student);
    }

    @PutMapping(path ="/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody StudentModel student){
        return service.updateStudent(id, student);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delatedStudent(@PathVariable Integer id){
        service.deletedStudent(id);
    }
}


