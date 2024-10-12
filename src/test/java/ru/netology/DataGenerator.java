package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.address().city();
    }

    public static String generateName(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.name().fullName();
    }

    public static String generatePhone(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.phoneNumber().phoneNumber();
    }

    public static String randomPhone(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.numerify("######");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String local) {
            return new UserInfo(generateCity(local), generateName(local), generatePhone(local));
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }


}