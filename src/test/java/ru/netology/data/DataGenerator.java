package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var city = new String[]{"Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск",
        "Владимир", "Волгоград", "Пермь", "Вологда", "Санкт-Петербург", "Москва", "Омск", "Орёл",};
        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String name) {
        var faker = new Faker(new Locale(name));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String phone) {
        var faker = new Faker(new Locale(phone));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}