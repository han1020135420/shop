package manman.pro.api.util;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 16:36
 */
public class IpUtil {
    public static String client(HttpServletRequest request) {
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            xff = request.getRemoteAddr();
        }
        return xff;
    }
}
