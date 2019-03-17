package com.myspring.DB;
import com.myspring.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.security.acl.Group;
import java.util.List;
    @Transactional
    @Repository
    public class UserBean{
        private SessionFactory sessionFactory;
        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }
        public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public void addUser(Users user) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        }
        public List<Users> getAllUsers() {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
            Root<Users> root = query.from(Users.class);
            List<Users> allUsers = session.createQuery(query).getResultList();
            session.close();
            return allUsers;
        }

        public void deleteUser(Long id) {
            Users user = new Users();
            user.setId(id);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            session.close();
        }
        public Users getUser(Long id) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
            Root<Users> root = query.from(Users.class);
            Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
            session.close();
            return users;
        }

        public Users getUser(String email) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
            Root<Users> root = query.from(Users.class);
            Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("email"), email))).getSingleResult();
            session.close();
            return users;
        }

        public void saveUser(Users users) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(users);
            transaction.commit();
            session.close();
        }


        public void addSchedule(Schedule schedule) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(schedule);
            transaction.commit();
            session.close();
        }

        public List<Schedule> getAllSchedules() {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Schedule> query = criteriaBuilder.createQuery(Schedule.class);
            Root<Schedule> root = query.from(Schedule.class);
            List<Schedule> allSchedules = session.createQuery(query).getResultList();
            session.close();
            return allSchedules;
        }

        public void addGroup(Groups group) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
            session.close();
        }

        public List<Groups> getAllGroups() {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Groups> query = criteriaBuilder.createQuery(Groups.class);
            Root<Groups> root = query.from(Groups.class);
            List<Groups> allGroups = session.createQuery(query).getResultList();
            session.close();
            return allGroups;
        }

        public void deleteGroup(Long id) {
            Groups group = new Groups();
            group.setId(id);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(group);
            transaction.commit();
            session.close();
        }

        public Groups getGroup(Long id) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Groups> query = criteriaBuilder.createQuery(Groups.class);
            Root<Groups> root = query.from(Groups.class);
            Groups groups = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
            session.close();
            return groups;
        }

        public void editGroup(Groups group) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(group);
            transaction.commit();
            session.close();
        }

        public List<Teachers> getAllTeachers() {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Teachers> query = criteriaBuilder.createQuery(Teachers.class);
            Root<Teachers> root = query.from(Teachers.class);
            List<Teachers> allTeachers = session.createQuery(query).getResultList();
            session.close();
            return allTeachers;
        }

        public void addTeacher(Teachers teacher) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            session.close();
        }

        public void deleteTeacher(Long id) {
            Teachers teacher = new Teachers();
            teacher.setId(id);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(teacher);
            transaction.commit();
            session.close();
        }

        public Teachers getTeacher(Long id) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Teachers> query = criteriaBuilder.createQuery(Teachers.class);
            Root<Teachers> root = query.from(Teachers.class);
            Teachers teachers = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
            session.close();
            return teachers;
        }

        public void editTeacher(Teachers teachers) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(teachers);
            transaction.commit();
            session.close();
        }

        //-----------------------------------------S U B J E C T ------------------------------------------------------//
        public List<Subjects> getAllSubjects() {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Subjects> query = criteriaBuilder.createQuery(Subjects.class);
            Root<Subjects> root = query.from(Subjects.class);
            List<Subjects> allSubjects = session.createQuery(query).getResultList();
            session.close();
            return allSubjects;
        }

        public void addSubject(Subjects subject) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(subject);
            transaction.commit();
            session.close();
        }

        public void deleteSubject(Long id) {
            Subjects subject = new Subjects();
            subject.setId(id);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(subject);
            transaction.commit();
            session.close();
        }

        public Subjects getSubject(Long id) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Subjects> query = criteriaBuilder.createQuery(Subjects.class);
            Root<Subjects> root = query.from(Subjects.class);
            Subjects subject = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
            session.close();
            return subject;
        }

        public void editSubject(Subjects subject) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(subject);
            transaction.commit();
            session.close();
        }

        //---------------------------- CLASS TYPE ---------------------------------------------------------------//
        public List<ClassType> getAllClasses() {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ClassType> query = criteriaBuilder.createQuery(ClassType.class);
            Root<ClassType> root = query.from(ClassType.class);
            List<ClassType> allClassType = session.createQuery(query).getResultList();
            session.close();
            return allClassType;
        }


//        public List<Schedule> getScheduleByTeacherId(Long id) {
//            Session session = sessionFactory.getCurrentSession();
//            return (List<Schedule>) session.createQuery("from Schedule s join Teachers t on t.id = s.id where t.id = :id")
//                    .setParameter("id", id)
//                    .getResultList();
//        }

        public Groups getGroup(String groupName) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Groups> query = criteriaBuilder.createQuery(Groups.class);
            Root<Groups> root = query.from(Groups.class);
            Groups groups = session.createQuery(query.where(criteriaBuilder.equal(root.get("groupName"), groupName))).getSingleResult();
            session.close();
            return groups;
        }

        public List<Schedule> getScheduleByGroupId(Groups group) {
            Session session = sessionFactory.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Schedule> query = criteriaBuilder.createQuery(Schedule.class);
            Root<Schedule> root = query.from(Schedule.class);
            List<Schedule> schedules = session.createQuery(query.where(criteriaBuilder.equal(root.get("group"), group))).getResultList();
            session.close();
            return schedules;
        }

        public void deleteSchedule(Long id) {
            Schedule schedule = new Schedule();
            schedule.setId(id);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(schedule);
            transaction.commit();
            session.close();
        }
}
