package dev.tdwl.controller;

import dev.tdwl.model.*;
import dev.tdwl.repository.*;
import dev.tdwl.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepo;
    private final CategoryListsRepository categoryRepo;
    private final ContactRepository contactRepo;
    private final ActivitiesRepository activityRepo;
    private final NotesRepository notesRepo;

    @Autowired
    public UserController(UserRepository repository, CategoryListsRepository categoryRepo, ContactRepository contactRepo, ActivitiesRepository activityRepo, NotesRepository notesRepo) {
        this.userRepo = repository;
        this.categoryRepo = categoryRepo;
        this.contactRepo = contactRepo;
        this.activityRepo = activityRepo;
        this.notesRepo = notesRepo;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userRepo.findUserById(id);
    }

    @GetMapping("/users/categories")
    public CategoryLists getUserLists() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return categoryRepo.findListsById(userDetails.getId());
    }

    @PostMapping("/users/categories")
    public ResponseEntity<?> updateUserLists(@RequestBody CategoryLists lists) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String listUserId = lists.getUserId();
        String loginUserId = userDetails.getId();

        if (listUserId.equals(loginUserId)) {
            categoryRepo.save(lists);
            return ResponseEntity.ok(lists);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/users/contacts")
    public List<Contact> getContactList() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUserId = userDetails.getId();

        Sort sort = Sort.by(Sort.Direction.DESC, "name");

        return contactRepo.findContactsByUserId(loginUserId, sort);
    }

    @GetMapping("/users/contacts/job/id/{id}")
    public List<Contact> getContactListForJob(@PathVariable("id") String id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        
        return contactRepo.findContactsByJobId(id, sort);
    }

    @GetMapping("/users/contact/id/{id}")
    public Contact getContact(@PathVariable("id") String id) {
        return contactRepo.findContactById(id);
    }

    @PostMapping("/users/contact")
    public ResponseEntity<?> insertContact(@RequestBody Contact contact) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUserId = userDetails.getId();

        contact.setUserId(loginUserId);
        contactRepo.save(contact);

        return ResponseEntity.ok(contact);
    }

    @GetMapping("/users/activities/job/id/{id}")
    public Activities getActivitiesForJob(@PathVariable("id") String id) {
        return activityRepo.findActivitiesByJobId(id);
    }

    @PostMapping("/users/activities/job")
    public ResponseEntity<?> updateActivities(@RequestBody Activities activities) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUserId = userDetails.getId();

        activities.setUserId(loginUserId);

        activityRepo.save(activities);

        return ResponseEntity.ok(activities);
    }

    @GetMapping("/users/notes/job/id/{id}")
    public Notes getNotesForJob(@PathVariable("id") String id) {
        return notesRepo.findNotesByJobId(id);
    }

    @PostMapping("/users/notes/job")
    public ResponseEntity<?> updateNotes(@RequestBody Notes notes) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUserId = userDetails.getId();

        notes.setUserId(loginUserId);

        notesRepo.save(notes);

        return ResponseEntity.ok(notes);
    }


}
