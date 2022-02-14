package com.company;
import java.util.Arrays;
import java.util.Random;

public class Team {
    final String teamName; // название команды
    final int founded; // Год основания
    private TeamMember[] teamMembers; // массив участников
    private float physicalCondition; // физическая форма
    private Random rand = new Random();
    private float genderFactor; // влияние пола на физическую форму

    Team ( String teamName, int founded, TeamMember[] teamMembers ) {
        this.teamName = teamName;
        this.founded = founded;
        this.teamMembers = teamMembers;
        //определение физического состояния каждого участника на момент формирования команды - дикий полет фантазии :о)
        for (TeamMember member : teamMembers) {
            genderFactor = ((member.getSex()).equals("male")) ? 1f : 0.9f;
            physicalCondition = (100+(65-member.getWeight()) + (member.getHeight() - 175) + (25 - member.getAge())) *
                    genderFactor * (70 + rand.nextInt(40))/100 ;
            member.setPhysicalCondition(physicalCondition);
        }
    }

    public TeamMember[] getTeamMembers (){
        return teamMembers;
    }

    public float getPhysicalCondition (){
        return physicalCondition;
    }

    public void info() {
        System.out.println ("--- TOTAL TEAM INFORMATION ---");
        System.out.println ("Team Name: " + teamName + "  Foundation Year: " + founded);
        for (TeamMember member : teamMembers) {
            System.out.println (member);
        }
        //System.out.println ("Team Name: " + teamName + "  Foundation Year: " + founded + Arrays.toString(teamMembers));
    }

    public void showResults() {
        System.out.println ("\n --- TOTAL TEAM RESULTS ---");
        System.out.println ("Team Name: " + teamName + "  Foundation Year: " + founded);
        for (TeamMember member : teamMembers) {
            System.out.println ("Result: " + member.getResult() + "     Name: " + member.getName());
        }
        //System.out.println ("Team Name: " + teamName + "  Foundation Year: " + founded + Arrays.toString(teamMembers));
    }

    @Override
    public String toString () {
        return ("Team Name: " + teamName + "   Foundation Year: " + founded + Arrays.toString(teamMembers));
    }
}
