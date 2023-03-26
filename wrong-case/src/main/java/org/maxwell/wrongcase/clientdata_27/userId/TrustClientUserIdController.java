package org.maxwell.wrongcase.clientdata_27.userId;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/24 17:25
 */
@RequestMapping("/trustclientuserid")
@RestController
public class TrustClientUserIdController {

    @GetMapping("wrong")
    public String wrong(@RequestParam("userId") Long userId) {
        return "当前用户Id：" + userId;
    }

    @GetMapping("right")
    public String right(@LoginRequired Long userId) {
        return "当前用户Id：" + userId;
    }

    @GetMapping("login")
    public long login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        if (username.equals("admin") && password.equals("admin")) {
            session.setAttribute("currentUser", 1L);
            return 1L;
        }
        return 0L;
    }


}
