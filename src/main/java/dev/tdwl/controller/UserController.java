package dev.tdwl.controller;

import dev.tdwl.model.Activities;
import dev.tdwl.model.CategoryLists;
import dev.tdwl.model.Contact;
import dev.tdwl.model.User;
import dev.tdwl.repository.ActivitiesRepository;
import dev.tdwl.repository.CategoryListsRepository;
import dev.tdwl.repository.ContactRepository;
import dev.tdwl.repository.UserRepository;
import dev.tdwl.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserController(UserRepository repository, CategoryListsRepository categoryRepo, ContactRepository contactRepo, ActivitiesRepository activityRepo) {
        this.userRepo = repository;
        this.categoryRepo = categoryRepo;
        this.contactRepo = contactRepo;
        this.activityRepo = activityRepo;
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

        return contactRepo.findContactsByUserId(loginUserId);
    }

    @GetMapping("/users/contacts/job/id/{id}")
    public List<Contact> getContactListForJob(@PathVariable("id") String id) {
        return contactRepo.findContactsByJobId(id);
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

}
