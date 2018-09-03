package manman.pro.api.service;

import manman.pro.api.dao.UserInfo;
import manman.pro.db.domain.ShopUser;
import manman.pro.db.service.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 17:24
 */
@Service
public class UserInfoService {

    @Autowired
    private ShopUserService userService;


    public UserInfo getInfo(Integer userId) {
        ShopUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
