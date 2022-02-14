package com.company;

public class Course {
    private Stage[] stage; // массив испытаний

    Course ( Stage[] stage ) {
        this.stage = stage;
    }

    public void info() {
        System.out.println ("\n--- TOTAL TOURNAMENT INFORMATION ---");
        for (int i=0; i < 5; i++) {
            System.out.println ("Stage " + (i+1) + "    Physical Condition Limit: " + stage[i].getPhyCondLimit() +
                    "    Examination: " + stage[i].getExName());
        }
    }

    public void doIt(Team team) {
        TeamMember[] member = team.getTeamMembers(); // получаем массив участников команды
        for (int i=0; i < 4; i++) { //перебираем участников
            boolean result = true; // изначально полагаем, что участник пройдет испытание
            for (int j=0; j < 5; j++) { // перебираем испытания
                // позволет ли физическая форма участинка пройти испытание j?
                result = stage[j].getPhyCondLimit() > member[i].getPhysicalCondition() ? false : true;
            }
            member[i].setResult(result); // записываем общий результат участника
        }
    }
}