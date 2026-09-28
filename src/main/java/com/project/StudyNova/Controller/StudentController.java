package com.project.StudyNova.Controller;


	import org.springframework.stereotype.Controller;

	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;

	import com.project.StudyNova.Modal.Users;

	import jakarta.servlet.http.HttpSession;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import jakarta.servlet.http.HttpSession;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	@Controller
	public class StudentController {

		@GetMapping("/Student/Dashboard")
		public String studentDashboard(HttpSession session, Model model) {

		    Users student = (Users) session.getAttribute("loggedInStudent");

		    if (student == null) {
		        return "redirect:/login";
		    }

		    model.addAttribute("student", student);

		    int completedLessons = 0;

		    // Java
		    for (int i = 1; i <= 5; i++) {
		        if (Boolean.TRUE.equals(session.getAttribute("javaLesson" + i + "Completed"))) {
		            completedLessons++;
		        }
		    }

		    // Python
		    for (int i = 1; i <= 10; i++) {
		        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson" + i + "Completed"))) {
		            completedLessons++;
		        }
		    }

		    // Web Development
		    for (int i = 1; i <= 10; i++) {
		        if (Boolean.TRUE.equals(session.getAttribute("webLesson" + i + "Completed"))) {
		            completedLessons++;
		        }
		    }

		    // Spring Boot
		    for (int i = 1; i <= 5; i++) {
		        if (Boolean.TRUE.equals(session.getAttribute("springLesson" + i + "Completed"))) {
		            completedLessons++;
		        }
		    }

		    // SQL
		    for (int i = 1; i <= 10; i++) {
		        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson" + i + "Completed"))) {
		            completedLessons++;
		        }
		    }

		    // C++
		    for (int i = 1; i <= 10; i++) {
		        if (Boolean.TRUE.equals(session.getAttribute("cppLesson" + i + "Completed"))) {
		            completedLessons++;
		        }
		    }

		    int totalLessons = 50;
		    int progress = (completedLessons * 100) / totalLessons;

		    model.addAttribute("completedLessons", completedLessons);
		    model.addAttribute("totalLessons", totalLessons);
		    model.addAttribute("progress", progress);

		    return "student-dashboard";
		}
	    @GetMapping("/Student/Courses")
	    public String studentCourses(HttpSession session) {

	        Users student = (Users) session.getAttribute("loggedInStudent");

	        if (student == null) {
	            return "redirect:/login";
	        }
	        
	        return "student-courses";
	    }

	    @GetMapping("/Student/Course/Java")
	    public String javaCourse(HttpSession session, Model model) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        int completedLessons = 0;

	        if (Boolean.TRUE.equals(session.getAttribute("javaLesson1Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("javaLesson2Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("javaLesson3Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("javaLesson4Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("javaLesson5Completed"))) completedLessons++;

	        int progress = completedLessons * 20;

	        model.addAttribute("completedLessons", completedLessons);
	        model.addAttribute("progress", progress);

	        return "java-course";
	    }
	    @GetMapping("/Student/Course/Java/Lesson1/Complete")
	    public String completeJavaLesson1(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("javaLesson1Completed", true);
	        return "redirect:/Student/Course/Java";
	    }

	    @GetMapping("/Student/Course/Java/Lesson2/Complete")
	    public String completeJavaLesson2(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("javaLesson2Completed", true);
	        return "redirect:/Student/Course/Java";
	    }

	    @GetMapping("/Student/Course/Java/Lesson3/Complete")
	    public String completeJavaLesson3(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("javaLesson3Completed", true);
	        return "redirect:/Student/Course/Java";
	    }

	    @GetMapping("/Student/Course/Java/Lesson4/Complete")
	    public String completeJavaLesson4(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("javaLesson4Completed", true);
	        return "redirect:/Student/Course/Java";
	    }

	    @GetMapping("/Student/Course/Java/Lesson5/Complete")
	    public String completeJavaLesson5(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("javaLesson5Completed", true);
	        return "redirect:/Student/Course/Java";
	    }
	    @GetMapping("/Student/Course/Java/Quiz")
	    public String javaQuiz(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "java-quiz";
	    }

	    @GetMapping("/Student/Course/Java/Quiz/Complete")
	    public String completeJavaQuiz(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("javaQuizCompleted", true);
	        return "redirect:/Student/Course/Java";
	    }
	    @GetMapping("/Student/Course/Python")
	    public String pythonCourse(HttpSession session, Model model) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        int completedLessons = 0;

	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson1Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson2Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson3Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson4Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson5Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson6Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson7Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson8Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson9Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("pythonLesson10Completed"))) completedLessons++;

	        int progress = completedLessons * 10;

	        model.addAttribute("completedLessons", completedLessons);
	        model.addAttribute("progress", progress);

	        return "python-course";
	    }
	    @GetMapping("/Student/Course/WebDevelopment")
	    public String webDevelopmentCourse(HttpSession session) {
	    	Users student = (Users) session.getAttribute("loggedInStudent");

	        if (student == null) {
	            return "redirect:/login";
	        }
	        return "web-development";
	    }
	    
	    @GetMapping("/Student/Course/CPP")
	    public String cppCourse(HttpSession session, Model model) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        int completedLessons = 0;

	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson1Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson2Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson3Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson4Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson5Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson6Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson7Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson8Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson9Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("cppLesson10Completed"))) completedLessons++;

	        int progress = completedLessons * 10;

	        model.addAttribute("completedLessons", completedLessons);
	        model.addAttribute("progress", progress);

	        return "cpp-course";
	    }
	    @GetMapping("/Student/Course/SQL")
	    public String sqlCourse(HttpSession session, Model model) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        int completedLessons = 0;

	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson1Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson2Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson3Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson4Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson5Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson6Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson7Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson8Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson9Completed"))) completedLessons++;
	        if (Boolean.TRUE.equals(session.getAttribute("sqlLesson10Completed"))) completedLessons++;

	        int progress = completedLessons * 10;

	        model.addAttribute("completedLessons", completedLessons);
	        model.addAttribute("progress", progress);

	        return "sql-course";
	    }
	    @GetMapping("/Student/Course/SpringBoot")
	    public String springBootCourse(HttpSession session, Model model) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        int completedLessons = 0;

	        if (Boolean.TRUE.equals(session.getAttribute("springBootLesson1Completed"))) {
	            completedLessons++;
	        }

	        if (Boolean.TRUE.equals(session.getAttribute("springBootLesson2Completed"))) {
	            completedLessons++;
	        }

	        if (Boolean.TRUE.equals(session.getAttribute("springBootLesson3Completed"))) {
	            completedLessons++;
	        }

	        if (Boolean.TRUE.equals(session.getAttribute("springBootLesson4Completed"))) {
	            completedLessons++;
	        }

	        if (Boolean.TRUE.equals(session.getAttribute("springBootLesson5Completed"))) {
	            completedLessons++;
	        }

	        int progress = completedLessons * 20;

	        model.addAttribute("completedLessons", completedLessons);
	        model.addAttribute("progress", progress);

	        return "springboot-course";
	    }

	    
	    @GetMapping("/Student/Course/SpringBoot/Lesson1")
	    public String springBootLesson1(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "springboot-lesson1";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson1/Complete")
	    public String completeSpringBootLesson1(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("springBootLesson1Completed", true);

	        return "redirect:/Student/Course/SpringBoot";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson2")
	    public String springBootLesson2(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "springboot-lesson2";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson2/Complete")
	    public String completeSpringBootLesson2(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("springBootLesson2Completed", true);

	        return "redirect:/Student/Course/SpringBoot";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson3")
	    public String springBootLesson3(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "springboot-lesson3";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson3/Complete")
	    public String completeSpringBootLesson3(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("springBootLesson3Completed", true);

	        return "redirect:/Student/Course/SpringBoot";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson4")
	    public String springBootLesson4(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "springboot-lesson4";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson4/Complete")
	    public String completeSpringBootLesson4(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("springBootLesson4Completed", true);

	        return "redirect:/Student/Course/SpringBoot";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson5")
	    public String springBootLesson5(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "springboot-lesson5";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Lesson5/Complete")
	    public String completeSpringBootLesson5(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("springBootLesson5Completed", true);

	        return "redirect:/Student/Course/SpringBoot";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Quiz")
	    public String springBootQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "springboot-quiz";
	    }
	    @GetMapping("/Student/Course/SpringBoot/Quiz/Complete")
	    public String completeSpringBootQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("springBootQuizCompleted", true);

	        return "redirect:/Student/Course/SpringBoot";
	    }
	  
	    @GetMapping("/Student/Course/Python/Lesson1")
	    public String pythonLesson1(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "python-lesson1";
	    }

	    @GetMapping("/Student/Course/Python/Lesson2")
	    public String pythonLesson2(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "python-lesson2";
	    }

	    @GetMapping("/Student/Course/Python/Lesson3")
	    public String pythonLesson3(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "python-lesson3";
	    }

	    @GetMapping("/Student/Course/Python/Lesson4")
	    public String pythonLesson4(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "python-lesson4";
	    }

	    @GetMapping("/Student/Course/Python/Lesson5")
	    public String pythonLesson5(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "python-lesson5";
	    }
	    @GetMapping("/Student/Course/Python/Lesson1/Complete")
	    public String completePythonLesson1(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("pythonLesson1Completed", true);
	        return "redirect:/Student/Course/Python";
	    }

	    @GetMapping("/Student/Course/Python/Lesson2/Complete")
	    public String completePythonLesson2(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("pythonLesson2Completed", true);
	        return "redirect:/Student/Course/Python";
	    }

	    @GetMapping("/Student/Course/Python/Lesson3/Complete")
	    public String completePythonLesson3(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("pythonLesson3Completed", true);
	        return "redirect:/Student/Course/Python";
	    }

	    @GetMapping("/Student/Course/Python/Lesson4/Complete")
	    public String completePythonLesson4(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("pythonLesson4Completed", true);
	        return "redirect:/Student/Course/Python";
	    }

	    @GetMapping("/Student/Course/Python/Lesson5/Complete")
	    public String completePythonLesson5(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        session.setAttribute("pythonLesson5Completed", true);
	        return "redirect:/Student/Course/Python";
	    }
	    @GetMapping("/Student/Course/Python/Quiz")
	    public String pythonQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "python-quiz";
	    }
	    @GetMapping("/Student/Course/Python/Quiz/Complete")
	    public String completePythonQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("pythonQuizCompleted", true);

	        return "redirect:/Student/Course/Python";
	    }
	    @GetMapping("/Student/Course/Python/Lesson6")
	    public String pythonLesson6(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "python-lesson6";
	    }
	    @GetMapping("/Student/Course/Python/Lesson7")
	    public String pythonLesson7(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "python-lesson7";
	    }


	    @GetMapping("/Student/Course/Python/Lesson8")
	    public String pythonLesson8(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "python-lesson8";
	    }


	    @GetMapping("/Student/Course/Python/Lesson9")
	    public String pythonLesson9(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "python-lesson9";
	    }


	    @GetMapping("/Student/Course/Python/Lesson10")
	    public String pythonLesson10(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "python-lesson10";
	    }
	    @GetMapping("/Student/Course/WebDevelopment/Lesson1")
	    public String webLesson1(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson1";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson2")
	    public String webLesson2(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson2";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson3")
	    public String webLesson3(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson3";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson4")
	    public String webLesson4(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson4";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson5")
	    public String webLesson5(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson5";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson6")
	    public String webLesson6(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson6";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson7")
	    public String webLesson7(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson7";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson8")
	    public String webLesson8(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson8";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson9")
	    public String webLesson9(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson9";
	    }

	    @GetMapping("/Student/Course/WebDevelopment/Lesson10")
	    public String webLesson10(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }
	        return "web-lesson10";
	    }
	    @GetMapping("/Student/Course/WebDevelopment/Quiz")
	    public String webDevelopmentQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "web-quiz";
	    }
	    @GetMapping("/Student/Course/WebDevelopment/Quiz/Complete")
	    public String completeWebDevelopmentQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("webDevelopmentQuizCompleted", true);

	        return "redirect:/Student/Course/WebDevelopment";
	    }
	    @GetMapping("/Student/Course/SQL/Lesson1")
	    public String sqlLesson1(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson1";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson2")
	    public String sqlLesson2(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson2";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson3")
	    public String sqlLesson3(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson3";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson4")
	    public String sqlLesson4(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson4";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson5")
	    public String sqlLesson5(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson5";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson6")
	    public String sqlLesson6(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson6";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson7")
	    public String sqlLesson7(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson7";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson8")
	    public String sqlLesson8(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson8";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson9")
	    public String sqlLesson9(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson9";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson10")
	    public String sqlLesson10(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "sql-lesson10";
	    }
	    @GetMapping("/Student/Course/SQL/Lesson1/Complete")
	    public String completeSqlLesson1(HttpSession session) {
	        session.setAttribute("sqlLesson1Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson2/Complete")
	    public String completeSqlLesson2(HttpSession session) {
	        session.setAttribute("sqlLesson2Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson3/Complete")
	    public String completeSqlLesson3(HttpSession session) {
	        session.setAttribute("sqlLesson3Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson4/Complete")
	    public String completeSqlLesson4(HttpSession session) {
	        session.setAttribute("sqlLesson4Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson5/Complete")
	    public String completeSqlLesson5(HttpSession session) {
	        session.setAttribute("sqlLesson5Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson6/Complete")
	    public String completeSqlLesson6(HttpSession session) {
	        session.setAttribute("sqlLesson6Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson7/Complete")
	    public String completeSqlLesson7(HttpSession session) {
	        session.setAttribute("sqlLesson7Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson8/Complete")
	    public String completeSqlLesson8(HttpSession session) {
	        session.setAttribute("sqlLesson8Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson9/Complete")
	    public String completeSqlLesson9(HttpSession session) {
	        session.setAttribute("sqlLesson9Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }

	    @GetMapping("/Student/Course/SQL/Lesson10/Complete")
	    public String completeSqlLesson10(HttpSession session) {
	        session.setAttribute("sqlLesson10Completed", true);
	        return "redirect:/Student/Course/SQL";
	    }
	    @GetMapping("/Student/Course/SQL/Quiz")
	    public String sqlQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "sql-quiz";
	    }
	    @GetMapping("/Student/Course/SQL/Quiz/Complete")
	    public String completeSqlQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("sqlQuizCompleted", true);

	        return "redirect:/Student/Course/SQL";
	    }
	    @GetMapping("/Student/Course/CPP/Lesson1")
	    public String cppLesson1(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson1";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson2")
	    public String cppLesson2(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson2";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson3")
	    public String cppLesson3(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson3";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson4")
	    public String cppLesson4(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson4";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson5")
	    public String cppLesson5(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson5";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson6")
	    public String cppLesson6(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson6";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson7")
	    public String cppLesson7(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson7";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson8")
	    public String cppLesson8(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson8";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson9")
	    public String cppLesson9(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson9";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson10")
	    public String cppLesson10(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) return "redirect:/login";
	        return "cpp-lesson10";
	    }
	    @GetMapping("/Student/Course/CPP/Lesson1/Complete")
	    public String completeCppLesson1(HttpSession session) {
	        session.setAttribute("cppLesson1Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson2/Complete")
	    public String completeCppLesson2(HttpSession session) {
	        session.setAttribute("cppLesson2Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson3/Complete")
	    public String completeCppLesson3(HttpSession session) {
	        session.setAttribute("cppLesson3Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson4/Complete")
	    public String completeCppLesson4(HttpSession session) {
	        session.setAttribute("cppLesson4Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson5/Complete")
	    public String completeCppLesson5(HttpSession session) {
	        session.setAttribute("cppLesson5Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson6/Complete")
	    public String completeCppLesson6(HttpSession session) {
	        session.setAttribute("cppLesson6Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson7/Complete")
	    public String completeCppLesson7(HttpSession session) {
	        session.setAttribute("cppLesson7Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson8/Complete")
	    public String completeCppLesson8(HttpSession session) {
	        session.setAttribute("cppLesson8Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson9/Complete")
	    public String completeCppLesson9(HttpSession session) {
	        session.setAttribute("cppLesson9Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }

	    @GetMapping("/Student/Course/CPP/Lesson10/Complete")
	    public String completeCppLesson10(HttpSession session) {
	        session.setAttribute("cppLesson10Completed", true);
	        return "redirect:/Student/Course/CPP";
	    }
	    @GetMapping("/Student/Course/CPP/Quiz")
	    public String cppQuiz(HttpSession session) {
	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "cpp-quiz";
	    }


	    @GetMapping("/Student/Course/CPP/Quiz/Complete")
	    public String completeCppQuiz(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        session.setAttribute("cppQuizCompleted", true);

	        return "redirect:/Student/Course/CPP";
	    }
	    @GetMapping("/Student/MockTests")
	    public String mockTests(HttpSession session) {

	        if (session.getAttribute("loggedInStudent") == null) {
	            return "redirect:/login";
	        }

	        return "mock-tests";
	    }
	    }
	

