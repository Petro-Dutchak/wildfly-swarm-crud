package ua.com.infopulse.demo.dao;

import ua.com.infopulse.demo.dto.UserStatusDto;
import ua.com.infopulse.demo.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;


@ApplicationScoped
public class UserDao {
    @PersistenceContext
    EntityManager em;

    public User get(long id) {
        return em.find(User.class, id);
    }

    public User create(User user) {
        em.persist(user);
        return user;
    }

    public User update(User user) {
        em.merge(user);
        return user;
    }

    public void delete(long id) {
        User user = get(id);
        user.setStatus(User.Status.DELETED);
        update(user);

    }

    public User changeStatus(long id, User.Status status) {
        User user = get(id);
        user.setStatus(status);
        em.merge(user);
        return user;
    }

    public UserStatusDto getUserStatus() {
        List<Object[]> results = em.createNativeQuery("SELECT u.statuse, count(*) FROM USER u group by status").getResultList();
        UserStatusDto userStatusDto = new UserStatusDto();
        results.stream().forEach((record) -> {
            if (((String) record[0]).equalsIgnoreCase(User.Status.ACTIVE.name())) {
                userStatusDto.setActiveStatus(((BigInteger) record[1]).longValue());
            } else if (((String) record[0]).equalsIgnoreCase(User.Status.INACTIVE.name())) {
                userStatusDto.setInActiveStatus(((BigInteger) record[1]).longValue());
            } else if (((String) record[0]).equalsIgnoreCase(User.Status.DELETED.name())) {
                userStatusDto.setDeletedStatus(((BigInteger) record[1]).longValue());
            }
        });
        return userStatusDto;
    }

    public List<User> getUsers(List<Long> usersIds) {
        List<User> result = em.createQuery("SELECT u FROM USER u WHERE u.id IN :ids").
                setParameter("ids", usersIds).getResultList();
        return result;
    }

    public List<User> getUsersByProjectId(Long projectId) {
        List<User> result = em.createQuery("SELECT u FROM USER u WHERE u.projectId = :id").
                setParameter("id", projectId).getResultList();
        return result;
    }

}
