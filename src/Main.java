public class Main {

    public static void main(String[] args) {

        //Opprett en ny regatta
        Regatta reg1 = new Regatta("Fiskelopet");

        reg1.nySeilas("Oslofjorden games", 001);
        reg1.nySeilas("Mjøsa rundt", 002);

        reg1.nyBaat(01, "Båden");
        reg1.nyBaat(02, "Fury");
        reg1.nyBaat(03, "Degus");
        reg1.nyBaat(04, "Gazur");

        reg1.registrerMaalgang(02, 001);
        reg1.registrerMaalgang(01, 001);
        reg1.registrerMaalgang(04, 001);
        reg1.registrerMaalgang(03, 001);

        reg1.registrerMaalgang(02, 002);
        reg1.registrerMaalgang(04, 002);
        reg1.registrerMaalgang(03, 002);
        reg1.registrerMaalgang(01, 002);

        reg1.avsluttRegistrering(001);
        reg1.avsluttRegistrering(002);

        reg1.skrivResultatListe();
    }
}
