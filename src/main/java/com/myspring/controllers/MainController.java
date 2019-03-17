package com.myspring.controllers;


import com.myspring.DB.UserBean;
import com.myspring.entities.*;
import com.myspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    UserBean userBean;


    private Schedule[][] showSchedule(List<Schedule> allSchedules) {
        Schedule[][] newArray = new Schedule[5][6];

        for (int k = 0; k < allSchedules.size(); k++) {
            if (allSchedules.get(k).getTime().equals("8:00") && allSchedules.get(k).getWeekDay().equals("mon")) {
                newArray[0][0] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("8:00") && allSchedules.get(k).getWeekDay().equals("tue")) {
                newArray[0][1] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("8:00") && allSchedules.get(k).getWeekDay().equals("wed")) {
                newArray[0][2] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("8:00") && allSchedules.get(k).getWeekDay().equals("thu")) {
                newArray[0][3] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("8:00") && allSchedules.get(k).getWeekDay().equals("fri")) {
                newArray[0][4] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("8:00") && allSchedules.get(k).getWeekDay().equals("sat")) {
                newArray[0][5] = allSchedules.get(k);
            }

            if (allSchedules.get(k).getTime().equals("9:00") && allSchedules.get(k).getWeekDay().equals("mon")) {
                newArray[1][0] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("9:00") && allSchedules.get(k).getWeekDay().equals("tue")) {
                newArray[1][1] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("9:00") && allSchedules.get(k).getWeekDay().equals("wed")) {
                newArray[1][2] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("9:00") && allSchedules.get(k).getWeekDay().equals("thu")) {
                newArray[1][3] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("9:00") && allSchedules.get(k).getWeekDay().equals("fri")) {
                newArray[1][4] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("9:00") && allSchedules.get(k).getWeekDay().equals("sat")) {
                newArray[1][5] = allSchedules.get(k);
            }

            if (allSchedules.get(k).getTime().equals("10:00") && allSchedules.get(k).getWeekDay().equals("mon")) {
                newArray[2][0] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("10:00") && allSchedules.get(k).getWeekDay().equals("tue")) {
                newArray[2][1] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("10:00") && allSchedules.get(k).getWeekDay().equals("wed")) {
                newArray[2][2] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("10:00") && allSchedules.get(k).getWeekDay().equals("thu")) {
                newArray[2][3] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("10:00") && allSchedules.get(k).getWeekDay().equals("fri")) {
                newArray[2][4] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("10:00") && allSchedules.get(k).getWeekDay().equals("sat")) {
                newArray[2][5] = allSchedules.get(k);
            }

            if (allSchedules.get(k).getTime().equals("11:00") && allSchedules.get(k).getWeekDay().equals("mon")) {
                newArray[3][0] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("11:00") && allSchedules.get(k).getWeekDay().equals("tue")) {
                newArray[3][1] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("11:00") && allSchedules.get(k).getWeekDay().equals("wed")) {
                newArray[3][2] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("11:00") && allSchedules.get(k).getWeekDay().equals("thu")) {
                newArray[3][3] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("11:00") && allSchedules.get(k).getWeekDay().equals("fri")) {
                newArray[3][4] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("11:00") && allSchedules.get(k).getWeekDay().equals("sat")) {
                newArray[3][5] = allSchedules.get(k);
            }

            if (allSchedules.get(k).getTime().equals("12:00") && allSchedules.get(k).getWeekDay().equals("mon")) {
                newArray[4][0] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("12:00") && allSchedules.get(k).getWeekDay().equals("tue")) {
                newArray[4][1] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("12:00") && allSchedules.get(k).getWeekDay().equals("wed")) {
                newArray[4][2] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("12:00") && allSchedules.get(k).getWeekDay().equals("thu")) {
                newArray[4][3] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("12:00") && allSchedules.get(k).getWeekDay().equals("fri")) {
                newArray[4][4] = allSchedules.get(k);
            }
            if (allSchedules.get(k).getTime().equals("12:00") && allSchedules.get(k).getWeekDay().equals("sat")) {
                newArray[4][5] = allSchedules.get(k);
            }


        }

        return newArray;
    }


    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/enter","/"}, method = RequestMethod.GET)
    public ModelAndView enter(){
        ModelAndView mw = new ModelAndView("login");
        return new ModelAndView("login", "userForm", new Users());
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage(){
        ModelAndView mw = new ModelAndView("403");
        return mw;
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        Users user = getUserData(); // -------------------------------------------------------------------------------
        ModelAndView mw = new ModelAndView("profile");
        mw.addObject("user", user);
        return mw;
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(@RequestParam(required = false) String query){
        ModelAndView mw = new ModelAndView("admin");
        List<Schedule> allSchedules = userBean.getAllSchedules();


        List<Teachers> allTeachers  = userBean.getAllTeachers();
        List<Subjects> allSubjects  = userBean.getAllSubjects();
        List<Groups> allGroups  = userBean.getAllGroups();
        List<ClassType> allClasses  = userBean.getAllClasses();

        mw.addObject("teachers",allTeachers);
        mw.addObject("subjects",allSubjects);
        mw.addObject("groups",allGroups);
        mw.addObject("classes",allClasses);

        if (query != null) {
            try {
                Groups tempGroup;

                tempGroup = userBean.getGroup(query);
                if (tempGroup != null) {
                    List<Schedule> schedules = userBean.getScheduleByGroupId(tempGroup);
                    Schedule[][] newArray = showSchedule(schedules);
                    mw.addObject("sch", newArray);
                    int timer = 7;
                    mw.addObject("timer", timer);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        return mw;
    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(@RequestParam(required = false) String query){

        ModelAndView mw = new ModelAndView("main");
        Users currentUser = getUserData();
        boolean isAdmin = false;
        for (Roles r : currentUser.getRoles()) {
            if(r.getRole().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }


        if (query != null) {
            try {
                Groups tempGroup;

                tempGroup = userBean.getGroup(query);
                if (tempGroup != null) {
                    List<Schedule> schedules = userBean.getScheduleByGroupId(tempGroup);
                    Schedule[][] newArray = showSchedule(schedules);
                    mw.addObject("sch", newArray);
                    int timer = 7;
                    mw.addObject("timer", timer);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        mw.addObject("isAdmin",isAdmin);
        mw.addObject("user",currentUser);
        return mw;
    }
    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            UserDetails ud = (UserDetails) authentication.getPrincipal();
            user = userService.getUserBean().getUser(ud.getUsername());
            System.out.println(ud.getUsername());
        }
        //DigestUtils.sha1Hex("ali");
        return user;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("registration", "userForm", new Users());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute("userForm") Users userForm) {
        userService.save(userForm);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
    public String addSchedule (@RequestParam String time,
                               @RequestParam String week,
                               @RequestParam Long clas,
                               @RequestParam Long group,
                               @RequestParam Long subject,
                               @RequestParam Long teacher) {
        Schedule tempSchedule = new Schedule(week, time, new Groups(group), new Subjects(subject), new Teachers(teacher), new ClassType(clas));
        userBean.addSchedule(tempSchedule);

        return "redirect:/admin";
    }


    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String addGroup (@RequestParam(name = "groupName") String groupName) {
        Groups tempGroup =  new Groups(groupName);
        userBean.addGroup(tempGroup);
        return "redirect:/groupPage";
    }

    @RequestMapping(value = "/groupPage", method = RequestMethod.GET)
    public ModelAndView groupPage () {
        ModelAndView mw = new ModelAndView("groupPage");
        List<Groups> groups = userBean.getAllGroups();
        mw.addObject("groups", groups);
        return mw;
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.POST)
    public String deleteGroup(@RequestParam(name = "id")Long id) {
        userBean.deleteGroup(id);
        return "redirect:/groupPage";
    }

    @RequestMapping(value = "/editGroup/{id}", method = RequestMethod.GET)
    public ModelAndView editWorkerPage(@PathVariable(name = "id") Long id){
            ModelAndView mw = new ModelAndView("editGroup");
            Groups group = userBean.getGroup(id);
            mw.addObject("group", group);
            return mw;

        }


    @RequestMapping(value = "/editGroupPost", method = RequestMethod.POST)
    public String editWorkerPostPage (@RequestParam(name = "id")Long id,
                                      @RequestParam(name = "name")String name
                                      ) {
        Groups group = new Groups();
        group.setId(id);
        group.setGroupName(name);
        userBean.editGroup(group);
        return "redirect:/groupPage";
    }


    @RequestMapping(value = "/Schedule", method =  RequestMethod.GET)
    @ResponseBody
    public List<Schedule> scheduleShow () {
       return userBean.getAllSchedules();
    }

    @RequestMapping(value = "/teacherPage", method = RequestMethod.GET)
    public ModelAndView teacherPage () {
        ModelAndView mw = new ModelAndView("teacherPage");
        List<Teachers> teachers = userBean.getAllTeachers();
        mw.addObject("teachers", teachers);
        return mw;
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addTeacher (@RequestParam(name = "lname") String lname,
                              @RequestParam(name = "fname") String fname,
                              @RequestParam(name = "degree") String degree) {
        Teachers teacher = new Teachers(lname, fname, degree);
        userBean.addTeacher(teacher);
        return "redirect:/teacherPage";
    }

    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
    public String deleteTeacher(@RequestParam(name = "id")Long id) {
        userBean.deleteTeacher(id);
        return "redirect:/teacherPage";
    }

    @RequestMapping(value = "/editTeacher/{id}", method = RequestMethod.GET)
    public ModelAndView editTeacherPage(@PathVariable(name = "id") Long id){
        ModelAndView mw = new ModelAndView("editTeacher");
        Teachers teacher = userBean.getTeacher(id);
        mw.addObject("teacher", teacher);
        return mw;

    }


    @RequestMapping(value = "/editTeacherPost", method = RequestMethod.POST)
    public String editWorkerPostPage (@RequestParam(name = "id")Long id,
                                      @RequestParam(name = "lname") String lname,
                                      @RequestParam(name = "fname") String fname,
                                      @RequestParam(name = "degree") String degree
    ) {
        Teachers teacher = new Teachers();
        teacher.setId(id);
        teacher.setLname(lname);
        teacher.setFname(fname);
        teacher.setDegree(degree);
        userBean.editTeacher(teacher);
        return "redirect:/teacherPage";
    }

    @RequestMapping(value = "/subjectPage", method = RequestMethod.GET)
    public ModelAndView subjectPage () {
        ModelAndView mw = new ModelAndView("subjectPage");
        List<Subjects> subjects = userBean.getAllSubjects();
        mw.addObject("subjects", subjects);
        return mw;
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public String addTeacher (@RequestParam(name = "subjectName") String subjectName,
                              @RequestParam(name = "credits") int credits) {
        Subjects subject = new Subjects(subjectName, credits);
        userBean.addSubject(subject);
        return "redirect:/subjectPage";
    }

    @RequestMapping(value = "/deleteSubject", method = RequestMethod.POST)
    public String deleteSubject(@RequestParam(name = "id")Long id) {
        userBean.deleteSubject(id);
        return "redirect:/subjectPage";
    }

    @RequestMapping(value = "/editSubject/{id}", method = RequestMethod.GET)
    public ModelAndView editSubjectPage(@PathVariable(name = "id") Long id){
        ModelAndView mw = new ModelAndView("editSubject");
        Subjects subject = userBean.getSubject(id);
        mw.addObject("subject", subject);
        return mw;

    }


    @RequestMapping(value = "/editSubjectPost", method = RequestMethod.POST)
    public String editSubjectPostPage (@RequestParam(name = "id")Long id,
                                      @RequestParam(name = "subjectName") String subjectName,
                                      @RequestParam(name = "credits") int credits) {
        Subjects subject = new Subjects();
        subject.setId(id);
        subject.setSubjectName(subjectName);
        subject.setCredits(credits);
        userBean.editSubject(subject);
        return "redirect:/subjectPage";
    }

    @RequestMapping(value = "/userGroupPage", method = RequestMethod.GET)
    public ModelAndView userGroupPage () {
        ModelAndView mw = new ModelAndView("userGroupPage");
        List<Users> users = userBean.getAllUsers();
        mw.addObject("users", users);
        return mw;
    }


    @RequestMapping(value = "/editUserGroup/{id}", method = RequestMethod.GET)
    public ModelAndView editUserGroupPage(@PathVariable(name = "id") Long id){
        ModelAndView mw = new ModelAndView("editUserGroup");
        List<Groups> groups = userBean.getAllGroups();
        Users user = userBean.getUser(id);
        mw.addObject("groups",groups);
        mw.addObject("user", user);
        return mw;

    }

    @RequestMapping(value = "/editUserGroupPost", method = RequestMethod.POST)
    public String editSubjectPostPage (@RequestParam(name = "id")Long id,
                                       @RequestParam(name = "group") Long group) {
        Users tempUser = userBean.getUser(id);
        tempUser.setGroup(new Groups(group));
        userBean.saveUser(tempUser);
        return "redirect:/userGroupPage";
    }


    @RequestMapping(value = "/userYourGroup", method = RequestMethod.GET)
    public ModelAndView userYourGroup () {
        ModelAndView mw = new ModelAndView("userYourGroup");
        Users currentUser = getUserData();
        boolean isAdmin = false;
        for (Roles r : currentUser.getRoles()) {
            if(r.getRole().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        Groups currentUserGroup = currentUser.getGroup();

        if(currentUserGroup != null) {
            try {
                if (currentUserGroup != null) {
                    List<Schedule> schedules = userBean.getScheduleByGroupId(currentUserGroup);
                    Schedule[][] newArray = showSchedule(schedules);
                    mw.addObject("sch", newArray);
                    int timer = 7;
                    mw.addObject("timer", timer);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }


        mw.addObject("isAdmin",isAdmin);
        mw.addObject("user",currentUser);
        return mw;
    }

    @RequestMapping(value = "/deleteSchedule", method = RequestMethod.POST)
    public String deleteSchedule(@RequestParam(name = "id")Long id) {
        userBean.deleteSchedule(id);
        return "redirect:/admin";
    }
}

