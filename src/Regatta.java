import java.util.ArrayList;
import java.util.HashMap;

public class Regatta {

    private String navn;
    private ArrayList<Seilas> seilaser = new ArrayList<Seilas>();
    private ArrayList<Baat> baatene = new ArrayList<Baat>();

    public Regatta(String navn){
        this.navn = navn;
        this.seilaser = new ArrayList<Seilas>(); }

    public void nyBaat(int seilnr, String navn){
        Baat baaten = new Baat(seilnr, navn);
        baatene.add(baaten);
    }

    public void nySeilas(String name, int ID){
        Seilas seilas = new Seilas(name, ID);
        seilaser.add(seilas);
    }

    public void registrerMaalgang(int seilnr, int seilasID) {
        for (Baat baaten : baatene){
            if(baaten.Seilnr == seilnr){
                for (Seilas seilaset : seilaser){
                    if (seilaset.seilasID == seilasID){
                        baaten.incrementTotalPoengSum(seilaset.plasseringsIndeks);
                        seilaset.registrerResultat(baaten);

                        //Test for nå, legger resultatet direkte i båt
                        //baaten.addResult(seilaset.plasseringsIndeks);
                    }
                }
            }
        }
    }

    public void avsluttRegistrering(int ID){
        for (Seilas seilaset : seilaser){
            if(seilaset.getSeilasID() == ID){
                seilaset.isEnded = true;
            }
        }
    }

    public void skrivResultatListe(){
        sortBaatene();
        for(Baat baaten : baatene){
            System.out.format("Båten " + baaten.name + " med seilnr " + baaten.Seilnr + " har resultatene " + baaten.resultater + " og en total score på " + baaten.totalPoengSum);
            System.out.println();
        }
    }

    private void sortBaatene(){
        baatene.sort((Baat b1, Baat b2) -> {
            if (b1.totalPoengSum > b2.totalPoengSum)
                return 1;
            if (b1.totalPoengSum < b2.totalPoengSum)
                return -1;
            return 0;
        });
    }

    private class Baat {

        private int Seilnr;
        private String name;
        private ArrayList<Integer> resultater = new ArrayList<Integer>();
        private int totalPoengSum;

        public Baat (int Seilnr, String name){
            this.Seilnr = Seilnr;
            this.name = name;
            this.totalPoengSum = 0;
            this.resultater = new ArrayList<Integer>();
        }

        public void addResult(int poeng){
            resultater.add(poeng);
        }

        public void incrementTotalPoengSum(int poeng){
            totalPoengSum = totalPoengSum + poeng;
        }

        public void printResultater(){
            for (Integer resultat : resultater){
                System.out.println(resultat);
            }
        }
    }

    private class Seilas{

        private String navn;
        private int seilasID;
        private int plasseringsIndeks;
        private boolean isEnded;

        public Seilas(String navn, int seilasID) {
            this.navn = navn;
            this.seilasID = seilasID;
            this.plasseringsIndeks = 1;
        }

        public String getNavn() {
            return navn;
        }

        public void registrerResultat(Baat baaten){
            baaten.addResult(plasseringsIndeks);
            plasseringsIndeks ++;
        }

        public void setNavn(String navn) {
            this.navn = navn;
        }

        public int getSeilasID() {
            return seilasID;
        }

        public void setSeilasID(int seilasID) {
            this.seilasID = seilasID;
        }

        public int getPlasseringsIndeks() {
            return plasseringsIndeks;
        }

        public void setPlasseringsIndeks(int plasseringsIndeks) {
            this.plasseringsIndeks = plasseringsIndeks;
        }

        public boolean isEnded() {
            return isEnded;
        }

        public void setEnded(boolean ended) {
            isEnded = ended;
        }
    }
}