package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getFirstName() { return dotenv.get("TEST_FIRST_NAME"); }
    public static String getLastName() { return dotenv.get("TEST_LAST_NAME"); }
    public static String getDob() { return dotenv.get("TEST_DOB"); }
    public static String getStreet() { return dotenv.get("TEST_STREET"); }
    public static String getPostalCode() { return dotenv.get("TEST_POSTAL_CODE"); }
    public static String getCity() { return dotenv.get("TEST_CITY"); }
    public static String getState() { return dotenv.get("TEST_STATE"); }
    public static String getCountry() { return dotenv.get("TEST_COUNTRY"); }
    public static String getPhone() { return dotenv.get("TEST_PHONE"); }
    public static String getEmail() { return dotenv.get("TEST_EMAIL"); }
    public static String getPassword() { return dotenv.get("TEST_PASSWORD"); }
}
