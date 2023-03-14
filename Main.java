package university;

public class Main {

    public static void main(String[] args){

        University poli=new University("PoliTO");

        poli.setRector("Guido", "Saracco");


        System.out.println(poli.getName());
        System.out.println(poli.getRector());

        System.out.println(poli.enroll("Mario", "Rossi"));
        System.out.println(poli.enroll("Luigi", "Verdi"));
        System.out.println(poli.enroll("Wario", "Gialli"));
        System.out.println(poli.enroll("Waluigi", "Viole"));
        System.out.println(poli.enroll("Peach", "Rose"));



        poli.activate("Programmazione a oggetti", "Marco Torchiano");
        poli.activate("Fisica II", "Mauro Giorcelli");
        poli.activate("Elettrotecnica", "Michele Bonnin");
        poli.activate("Algoritmi e Strutture Dati", "Gianpiero Cabodi");
        poli.activate("Tecniche di programmazione", "Paolo Camurati");
        poli.activate("Analisi I", "Paolo Cortese");


        poli.register(10000, 15);
        poli.register(10003, 15);
        poli.register(10004, 15);

        poli.register(10000, 11);
        poli.register(10000, 12);
        poli.register(10000, 14);
        poli.register(10004, 13);

        System.out.println();

        poli.listAttendees(15);
        poli.studyPlan(10000);

    }

}
