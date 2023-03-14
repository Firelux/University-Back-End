package university;

public class University {

    private int MAX=1000;
    private int FIRST=10000;
    private int MAXIns=50;
    private int FIRSTcorso=10;
    private String nome;
    private String rettore;
    private Studenti[] studenti=new Studenti[MAX];
    private int nextStudentId=FIRST;
    private Insegnamenti[] insegnamenti=new Insegnamenti[MAXIns];
    private int nextCorsoId=FIRSTcorso;

    University(String name){
        nome=name;

    }
    public String getName(){
        return nome;
    }
    public void setRector(String nameRec, String surnameRec){
        rettore=nameRec+" "+surnameRec;
    }

    public String getRector(){

        return rettore;

    }

    public int enroll(String nomeStud, String cognomeStud){

        Studenti s=new Studenti();

        // Ricorda che non puoi fare direttamente studenti[nextStudentId-FIRST].matricola=nextStudId, ma devi prima creare un oggetto Studenti s
        // che contiene tutte le informazioni che ti servono e DOPO fare studenti[nextStudentId-FIRST]=s;

        s.matricola=nextStudentId;
        s.nomeStudente=nomeStud;
        s.cognomeStudente=cognomeStud;
        studenti[nextStudentId-FIRST]=s;
        nextStudentId++;
        return studenti[nextStudentId-FIRST-1].matricola;
    }

    public String student(int matricola){

        return studenti[matricola-FIRST].matricola+" "+studenti[matricola-FIRST].nomeStudente+" "+studenti[matricola-FIRST].cognomeStudente;

    }

    public int activate(String titolo, String docente){

        Insegnamenti i=new Insegnamenti();

        i.codice=nextCorsoId;
        i.titolo=titolo;
        i.docente=docente;

        insegnamenti[nextCorsoId-10]=i;
        nextCorsoId++;

        return insegnamenti[nextCorsoId-10-1].codice;


    }

    public String course(int cod){

        Insegnamenti i=new Insegnamenti();

        i=insegnamenti[cod-10];

        return i.codice+","+i.titolo+","+i.docente;

    }

    public void register(int matricola, int codice){

        studenti[matricola-FIRST].insegnamenti[studenti[matricola-FIRST].nextIns]=insegnamenti[codice-FIRSTcorso];
        insegnamenti[codice-FIRSTcorso].studenti[insegnamenti[codice-FIRSTcorso].nextStud]=studenti[matricola-FIRST];
        studenti[matricola-FIRST].nextIns++;
        insegnamenti[codice-FIRSTcorso].nextStud++;

    }

    public void listAttendees(int codice) {

        Insegnamenti i=new Insegnamenti();
        i=insegnamenti[codice-FIRSTcorso];
        System.out.println(i.titolo+","+i.docente+":");
        for (int j = 0; j < insegnamenti[codice - FIRSTcorso].nextStud; j++) {
            System.out.println(i.studenti[j].matricola+" "+i.studenti[j].nomeStudente+" "+i.studenti[j].cognomeStudente);
        }
        System.out.println();

    }
    public void studyPlan(int matricola){

        Studenti s=new Studenti();
        s=studenti[matricola-FIRST];
        System.out.println(s.matricola+" "+s.nomeStudente+" "+s.cognomeStudente+":");
        for(int j=0;j<s.nextIns;j++){

            System.out.println(s.insegnamenti[j].codice+","+s.insegnamenti[j].titolo+","+s.insegnamenti[j].docente);

        }


    }


}
