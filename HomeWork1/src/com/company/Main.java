package com.company;

public class Main {

    public static void main(String[] args) {
        TeamMember[] teamArray = new TeamMember[4]; // создаем участников
        teamArray[0] = new TeamMember("Petr","male",74,180,30, 100, true);
        teamArray[1] = new TeamMember("Ivan","male",90,172,43, 100, true);
        teamArray[2] = new TeamMember("Elena","female",64,175,21, 100, true);
        teamArray[3] = new TeamMember("Gregor","male",85,190,28, 100,true);

        Team fuckers = new Team("Plankton", 2021, teamArray); // создаем команду
        fuckers.info(); // выводим информацию о команде

        Stage[] examination = new Stage[5]; // Создаем набор испытаний
        examination[0] = new Stage("Run 100m", 35f); // бег на 100 метров
        examination[1] = new Stage("Swim 50m", 60f); // плавание 50 метров
        examination[2] = new Stage("Jump 2 min.", 55f); // скакалка 2 минуты
        examination[3] = new Stage("Climb 5m", 75f); // скалолазание на высоту 5 метров
        examination[4] = new Stage("Sit down 50 times", 68f); // присесть 50 раз

        Course loop1 = new Course(examination); // Создаем полосу препятствий
        loop1.info(); // выводим на печать полосу препятствий

        loop1.doIt(fuckers); // Просим команду пройти полосу
        fuckers.showResults(); // Показываем результаты
    }
}
