package ua.com.infopulse.demo.services;

import ua.com.infopulse.demo.Utils;
import ua.com.infopulse.demo.dao.UserDao;
import ua.com.infopulse.demo.dto.UserChangeStatusDto;
import ua.com.infopulse.demo.dto.UserDto;
import ua.com.infopulse.demo.dto.UserStatusDto;
import ua.com.infopulse.demo.entity.User;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
public class UserService {
    @Inject
    private UserDao userDao;

    public UserDto get(long id) {
        return User.toUserDto(userDao.get(id));
    }

    public UserDto create(UserDto user) {
        return User.toUserDto(userDao.create(UserDto.toUser(user)));
    }

    public UserDto update(UserDto user) {
        return User.toUserDto(userDao.update(UserDto.toUser(user)));
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public UserDto changeStatus(UserChangeStatusDto userChangeStatusDto) {
        return User.toUserDto(userDao.changeStatus(userChangeStatusDto.getId(),
            Utils.get(userChangeStatusDto.getStatus())));
    }

    public UserStatusDto getUserStatus() {

        return userDao.getUserStatus();
    }
}
