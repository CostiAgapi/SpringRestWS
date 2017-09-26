package security;

/**
 * Created by ConstantinAgapi on 25/09/2017.
 */
public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 30_000 ; // 30 sec
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static String USERNAME = "";
    public static String PASSWORD = "";
}
