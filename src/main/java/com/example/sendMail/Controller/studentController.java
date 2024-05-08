package com.example.sendMail.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sendMail.Model.EmailSenderService;
import com.example.sendMail.Model.funtionStudent;
import com.example.sendMail.Model.student;

@Controller
@RequestMapping(value = { "/student" })
public class studentController {

    funtionStudent funtionStudent = new funtionStudent();

    @GetMapping(value = "/getAll")
    public String getAll(Model model) {
        ArrayList<student> students = new ArrayList<>();
        students = funtionStudent.getAll();
        model.addAttribute("studenList", students);
        return "hello";

    }

    @PostMapping(value = "/login")
    public String login(Model model, @ModelAttribute("student") student student) {
        if (student.getId() == 1 && student.getName().equals("Viet")) {
            return getAll(model);
        }
        return "login";
    }

    @GetMapping(value = "/showLogin")
    public String showLogin(Model model) {
        student student = new student();
        model.addAttribute("student", student);
        return "login";

    }

    @GetMapping(value = "/getByID")
    public String getById(Model model, @RequestParam(name = "idStudent") int id) {
        for (student st : funtionStudent.getAll()) {
            if (id == st.getId()) {
                return "getByID";
            }
        }
        return getAll(model);

    }

    public static void main(String[] args) {
        double a = 54000.0;
        System.out.println((int) a);
    }

}
