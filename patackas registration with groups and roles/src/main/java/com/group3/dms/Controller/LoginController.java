package com.group3.dms.Controller;

import com.group3.dms.Entity.*;
//import com.group3.dms.Service.TextService;
import com.group3.dms.Repository.NoteRepository;
import com.group3.dms.Service.UserService;
import com.group3.dms.Repository.NoteRepository;

import com.group3.dms.exception.ResourceNotFoundException;
import com.group3.dms.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private TextService textService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value = "/peasant/peasanthome", method = RequestMethod.GET)
    public ModelAndView peasanthome() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage", "Content Available Only for Users with Peasant Role");
        modelAndView.setViewName("peasant/peasanthome");
        return modelAndView;
    }

    @RequestMapping(value = {"/admin/allnotes/"}, method = RequestMethod.GET)
    public ModelAndView notes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/allnotes");
        return modelAndView;
    }

    @RequestMapping(value = {"/peasant/peasanteditor"}, method = RequestMethod.GET)
    public ModelAndView editor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Peasant/peasanteditor");
        return modelAndView;
    }


//    @RequestMapping("/api")
//    public class NoteController {
//
//        @Autowired
//        NoteRepository noteRepository;
//
//        @GetMapping("/notes")
//        public List<Note> getAllNotes() {
//            return noteRepository.findAll();
//        }
//        @PostMapping("/notes")
//        public Note createNote(@Valid @RequestBody Note note) {
//            return noteRepository.save(note);
//        }
//    }
//
//    @Autowired
//    NoteRepository noteRepository;
//    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
//        return noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//    }
//
//    @PutMapping("/notes/{id}")
//    public Note updateNote(@PathVariable(value = "id") Long noteId,
//                           @Valid @RequestBody Note noteDetails) {
//
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());
//
//        Note updatedNote = noteRepository.save(note);
//        return updatedNote;
//
//
//    }
//
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        noteRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }

}

//    @RequestMapping(value={"/text/text"}, method = RequestMethod.POST)
//    public ModelAndView addTextToDb(@Valid Text text, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/Text/Text");
//
//
//        TextService.saveText(text);
//        modelAndView.addObject("successMessage", "User has been registered successfully");
//        modelAndView.addObject("text", new Text());
//        modelAndView.addObject("text", "message");
//        modelAndView.setViewName("/Text/Text");
//        return modelAndView;
//
//    }
//


