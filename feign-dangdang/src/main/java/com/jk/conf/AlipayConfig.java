package com.jk.conf;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101000651524";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCyakvzBDLkPp0Lvm7qkXAoRXn6qs5CixiuY6EP20GCaaXy6QzxtJEElgFcRpCGsFSy7iZDh9SCfcAwypb/iUvmJZLLrpC6vML0oVPCb2XCSeJ2QZZGlD+Yli/I7yjAIfhDwyNu5RQPAwjx3YR83a+5TLpF+PmOSeTnHH7N6+UxdSqv/921yYns7xJXdB67IO9Riq2p7TTGKNaetwhF4JKjwNOU345hL8K5Ix3vtENHy6yKHaQt82JARNd6Ipudqj2VcR+mrG9fP6Up6K0dwDFtj65mZ2wVYkXt8+DWIgcnlbI++YjXaF5hm9d6JsdlXgUPXfQhvv+6k99naejwthAxAgMBAAECggEAHHIoM9Haj1uQTHwLUSjpGfKh1R6AjkmBIOTPnCiYFEPl6onPv4XLjVChXOX/Swo4JuMjhKbWcgu8pcrXMlzglgwtkH3/o1ZPOxOxuBFsxwJisfoZDJ28WgawDbhb5e5EmAE32Al8Hjyco3tvET2DM+cQ1/EvUMllTpfTe999hlnkVeyhllWOGgPOLXqDlrDAgVcm4ijFtIUpFRNcx3IvSJfywnoWlhM8VeYrM+H5o7an+iFTws5CpJZeUJSyHUTE71BwHPAcDzmJJB90QOYGhhEbUR1vINHzgz3Cr4YIgMJnCFcTWocBSu48DB6zTk2XJ3MQPZJRmasTZnrlKeK+ZQKBgQDw6jTEAHXfB/ovwjZvTWtZ7/qbYireTh2i1fQrvuw+JXMzaAgR/DNg135YFtJoZJW6xJeU6RCYasfZwBLEaQycC3CMS/o1xTEUVp2aOZnjXgbiGmgz/oubkrk/RbPueb9Jm4dzGjVMk8sXVZWbdSw5sfrYBpTLpler+epgcTgdtwKBgQC9lj1hUpBkayUlMP6lLrxwT3c5FKLb0KONf0ynGPNVCa2ChRHeJTE+QVP+dx+CNJFcf6RxN3WbCvJltLI1lIkxbNzYHc7wY0KrDHYo9P+uwn2287SJi5p1/si1R5k9e6n4jrdOBnIQNoow9Njr63fzeGF5086q2unIB+O/KavBVwKBgGJ9zY6oBYhl8YGe67Q7OX0uYA0waAg0dWdCAy3zQw/xLZTBnjMEIVkhIHUQ93pYTOJrRvFJC1DUrtm17bZAoDgXcS7aTPO4p2UCODJ6BBDxOu0rEJjZIug6ZuOYMoR3X53PKOQEve+NqITkp2JD2A3KVpwErMZJPiR/6rL89o0nAoGAAbfk4obvDBn0gjvJcxHTX2k4+Wl4eGmRseyfczxEqFaoHfC60rqfkaLh8gJ+ZJ25W49EnEoWZMtamxViMB4iiDImZkcO4xrjNc2tHH3r+1eD8C6RSlXblooyo4H8n5QJXFley/Q/AGqeIgd2F91QfwJuT75dtyq4x7lalRb5mY0CgYEA7Y3XcEWUJt8wB/Xt1NCpY+5VkygEYN3fT1wXWSLxroYZYcaptFSvQxiBpi9PTAD/pE3SkYNRBuzIHp1dsrtTTGyYFfEYzOkUL8QKXBuXDkMQpyBMVzntBcM8fKKAk5smQ+Qh+gvU0dKp2fAZudOUXidNJVSn2zLuZnBsmg9WHLE=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsmpL8wQy5D6dC75u6pFwKEV5+qrOQosYrmOhD9tBgmml8ukM8bSRBJYBXEaQhrBUsu4mQ4fUgn3AMMqW/4lL5iWSy66QurzC9KFTwm9lwknidkGWRpQ/mJYvyO8owCH4Q8MjbuUUDwMI8d2EfN2vuUy6Rfj5jknk5xx+zevlMXUqr//dtcmJ7O8SV3QeuyDvUYqtqe00xijWnrcIReCSo8DTlN+OYS/CuSMd77RDR8usih2kLfNiQETXeiKbnao9lXEfpqxvXz+lKeitHcAxbY+uZmdsFWJF7fPg1iIHJ5WyPvmI12heYZvXeibHZV4FD130Ib7/upPfZ2no8LYQMQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8091/order/updMyOrderzt";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
