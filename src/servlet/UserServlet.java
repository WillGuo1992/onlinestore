package servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.CheckCodeUtil;
import utils.MyBeanUtils;
import utils.UUIDUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @description: 用户模块Servlet
 * @author: Will.Guo
 * @create: 2018-06-10 21:47
 **/
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    public String registerUI(HttpServletRequest request, HttpServletResponse resp) {
        return "jsp/register.jsp";
    }

    public String loginUI(HttpServletRequest request, HttpServletResponse resp) {
        return "jsp/login.jsp";
    }

    public String getCheckCodePic(HttpServletRequest request, HttpServletResponse response) {
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CheckCodeUtil.generateCodeAndPic();
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("code", codeMap.get("code").toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String register(HttpServletRequest request, HttpServletResponse response) {

        User user = MyBeanUtils.populate(User.class, request.getParameterMap());
        user.setUid(UUIDUtils.getUUID());
        user.setCode(UUIDUtils.get64UUID());
        user.setState(0);
        userService.register(user);
        request.setAttribute("msg", "注册成功，请邮件激活后登录");
        return "jsp/login.jsp";
    }

    public String checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = MyBeanUtils.populate(User.class, request.getParameterMap());
        boolean isHave = userService.checkUserByUsername(user);
        if (isHave) {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("用户名已经存在");
        }
        return null;
    }



    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = MyBeanUtils.populate(User.class, request.getParameterMap());
        user = userService.checkUserByUsernameAndPassword(user);
        if (user == null) {
            request.setAttribute("msg", "用户名或密码错误");
            return "UserServlet?method=loginUI";
        } else {
            request.getSession().setAttribute("user", user);
            request.removeAttribute("msg");
            return "IndexServlet?method=execute";
        }
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        return "IndexServlet?method=execute";
    }

    public String activate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = MyBeanUtils.populate(User.class, request.getParameterMap());
        if(user!=null){
            userService.active(user);
        }
        return "UserServlet?method=loginUI";
    }
}
