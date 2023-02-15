package com.lakers.test;

import com.github.plexpt.chatgpt.Chatbot;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created on 2022/12/30 16:41
 *
 * @author lakers
 */
public class AnnoTest {

    public static <T extends Annotation> T getAnnotation(AnnotatedElement annotatedElement, Class<T> annotation) {
        return annotatedElement.getAnnotation(annotation);
    }

    public static InetAddress getLocalHostExactAddress() {
        try {
            InetAddress candidateAddress = null;

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface iface = networkInterfaces.nextElement();
                // 该网卡接口下的ip会有多个，也需要一个个的遍历，找到自己所需要的
                for (Enumeration<InetAddress> inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = inetAddrs.nextElement();
                    // 排除loopback回环类型地址（不管是IPv4还是IPv6 只要是回环地址都会返回true）
                    if (!inetAddr.isLoopbackAddress()) {
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了 就是我们要找的
                            // ~~~~~~~~~~~~~绝大部分情况下都会在此处返回你的ip地址值~~~~~~~~~~~~~
                            return inetAddr;
                        }

                        // 若不是site-local地址 那就记录下该地址当作候选
                        if (candidateAddress == null) {
                            candidateAddress = inetAddr;
                        }

                    }
                }
            }

            // 如果出去loopback回环地之外无其它地址了，那就回退到原始方案吧
            return candidateAddress == null ? InetAddress.getLocalHost() : candidateAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPublicIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        String password = "Abc12345.";
        String patternString = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?!.*\\s).{8,16}$";
        Pattern pattern = Pattern.compile(patternString);
        boolean isMatch = pattern.matcher(password).matches();

        if (isMatch) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is invalid.");
        }
    }

    @Test
    public void testClassAnno() throws Exception {
        Class<HasAnnoClass> aClass = HasAnnoClass.class;
        Anno annotationClass = getAnnotation(aClass, Anno.class);
        Anno annotationMethod = getAnnotation(aClass.getDeclaredMethod("print"), Anno.class);
        Anno annotationField = getAnnotation(aClass.getDeclaredField("name"), Anno.class);

        System.out.println(annotationClass.name());
        System.out.println(annotationMethod.name());
        System.out.println(annotationField.name());
    }

    @Test
    public void chatGptTest() throws Exception {
        String sessionToken = "eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..2RNo38rjT7wCSORR.YUvMdVt50tL1OiIcdj3IHhOH9ScogZYHqIKPDf9YWR2Ru8MWzUy0MzC7U6KjJ-CbrK2DvsqKQUFA82a4_IzK21RChCruHDZqZbyeY5eeicTvQTip_6xaxSVYu5QBDeeWRq9zszhX5XvRO2ney3ldvxAAgw8SfhKfLf4VG6IVkz5LDGlABaThs3TWT3h_4mAriKdaEg7nMxHYWq8kRRxuPLT29bpa753hQ5A7TZxvhkyQAbKBj_q8IFnigpA5pWUV6o-zEJfIbyCLKXouWOU-k6anzcy1YZC3MluNWZcDGJSAEOcEjpEVluDwkkM-aCzXzys8WSy6ScJz8dEIF_DZlzIxqxqCwyKslSk01GXFwuSoRiR1CTqfURdcq4ew8O0u-dgGEQb70veLi3lChxCPB-xT2G82Yg2KOX74WiMex0jvaWL-8cEYmIY3YBThRCMBE25G_UG-IWR1Rf8xPktKGl9JLsrGBrU_kde_TTgM5S8Qq9gc0ik24edSqCL1LQ4Q3w2W1csb7Hr3zRV8aTG7my4KyXDoF6aLMnfxKW27rym5wHHQdydoO5vAYfkk4QW6ZlxPqD274gUF57iooZ-jtl10uaB2UXDinKVuyDVI19EiRQqb1Vg27oNYMoNhnr6vM3Z_ETvKANiCKZg-xZcYTRJ8BFpVU7IkKsx1TUuG_L98qUi2F3hNqXndKuDS2Yw0S3RzOVZgV2pds9kaCfI5P_Ll6ksjeaSYw1HEx4jjGH5bGZ7KOQGm4ryEjtGkfIUH0m9f1eCohkU7fwN0gc04Lel7USLw94aVLdBxDzB0llX71o-sABwTXrsVxMaa35ylLT3sNYY8dDuji2lyGzHynXQP5aqhukAvgiQdgcCgF2XgG23zi3LHmf5aeNYJeuuBOJJouPDlNMGEIWW7fk-2IOxjpX5gFih8L5XJVI8F0H6vPu7JShw7QroYuCBl-mJcy4EAD1DBnHwrIkEgljbOptSodgMob94qePnPE8q6mHy4-RnwijnsG1HzoGfLmKF3eqQKnjiiJF3EkxDYdRRPKsZ7Vx7IZl0mfb3_5y1bs2h42dfjdkhuL0pUmqI4C7wIvyRE5_4vR-aIu24_HdrWy8s2zhWXnmlACINRdPST2YcASqDClggiZ9O9uc58jEij2WSEL-EBdL6d72UlDPbNvtvTTnlFBdQWibBexKQoNOBtKV6lB7M1hCpywKKyyVhuMQgbLQd0ipyfXc8WkVcq0YBo3d-v1oGhZ75ey1Q5KbcdKTVYiw5kMkQKC1xTbeKBCFyofwy5g9JyyjXiEpL4hc_jdaTGmlZ-XoycMvpfxuCRBGb04T1sdnGnSE80mhvfErWykxin175ipYA7h-SFlfdaX2c1IDd2fExXHJxoDL66kSVI0mTv2SfdObq9O_VYAXM1WdUkNYCtTe5G92XAYpwEmXIaXtZkNRJtnsHGXCLtCx70ONX3xKfi_boFtEjHlFScaM8DftEsxt0AC68zYl69r1i9BAZacansGPS75IRteExUXMrGNmrIjd1TRyzmYWR9nFNdilB7WjjoDiooGAhVfBJW_J-nxgb_d3apyQu141nQATv-mPWoKHS22JNHtkSYw0fRzqCx6TIFJux-nrEMz7YQvlWWgbSAw7DLVj77ObfOavEtk6AxNmyeDClMZl4LrboZ6kxvKEm2xAwZMCFDnMtzGEqcv3bx0VFxq3CBcaSljn_cgVm0419TEopAzR68eshywKHXdreDcEXG7w9lrjrYwAG4P5BeSIhfberB9-Pm4W1ofsLCrXWCq-LopSP1j0liyDPjJWNZHlFvOPJvWd43kjCqcYs5w2R7_1ChwuvO0lcv4j6YdKpq6FLpUS8jBOh4-lhdJMiPNE2Og4CjpZN9XNjGv6zotnzHtCokY6ftEiHnwe6A6R4UYyu9pdYIOM1G_kmEHTNBgD2jPL5KfC-Nh_tIC8a6I6pp0yYkNFpKL9L3jhGCE-5KrodsrATjnyBC-7uyyo66UTOdkswpFuKVs5Eo_v0hnepUTJeb_eD_DMaMfDjWhbdGGx6zpRxYNeHRSSn3ICMSzvzXGzxJky_apGoBcfCblC5B5s8IO-6IR0Kv-Jg6oJ25vINRYANRalJXifZSBmp-r-E74vQCb5b2r8VqzzW_eYBF62tshzr8i22mCXt400uDcegug2e4XEGGtuHk0KZ6PmEh6GdFAP6FQQeTW2dAk9bO0efoXHalNIwXs8AoQbCzdsGENLYnHbnJQAClWpj51JZkNBJXE5wdZpONJi0vChth6irDJMW76HJFRb-p521rcW2hwF3VFc60ckme6dNA1DKPJV-p7b-OKpuAlH0NoIYVq7f3ozErjov9foiUVQ9GtEJNC_c3YBJGuhcGqTCY18j55G_z8W6VCObZjb_FYiD5Zy2FPK_jQJdMdh6F7iusnTf2_UM0gM5mZ4D68_uY1-RnNje5iDwe2rwbMPjYFPn3Lx1xj3O7XEeaztKQRsqKz4c-4ad5SUwME47OcCa-J7cfmrfSe7LeMxTYvmalcR-52wQ_egQG43NjJEpJqB7SsIfiEJMZp43DFCbowEEAhnLPJp93wzpY893tj3MBPRiDNXATq2CAFkxJHBFoJJ0FppSQFV4k59_1Dm2MCObX.ejzKTLJKPUDXraD0t38yGA";
        String cfClearance = "tctoPA5LT8qvEYiXp76WrW2xsNkKbYNZxKL1x.5AupM-1676008509-0-1-c69203ed.34592cf7.91935c0d-160";
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.78";

        Chatbot chatbot = new Chatbot(sessionToken, cfClearance, userAgent);
        Map<String, Object> chatResponse = chatbot.getChatResponse("hello");
        System.out.println(chatResponse.get("message"));
    }

    @Target({METHOD, TYPE, FIELD})
    @Retention(RUNTIME)
    @Documented
    @interface Anno {
        String name() default "";

        int age() default 8;
    }

    @Anno(name = "类测试")
    static class HasAnnoClass {

        @Anno(name = "字段测试")
        private String name;

        @Anno(name = "方法测试")
        private void print() {
            System.out.println("方法测试！");
        }
    }

}
