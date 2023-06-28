import java.util.Scanner;
import java.time.*;
import java.io.*;

public class ToDo{
    public static String[] todos = new String[10];
    public static LocalDate fdate = LocalDate.of(2020, 12, 23);
    public static LocalDate[] daten = new LocalDate[10];

    public static boolean neueAufgabe(String titel){
        for(int i = 0; i < todos.length; i++){
            String pointer = todos[i];
            if(pointer == null){
                todos[i] = titel;
                return true;
            }
            if(pointer.equals(titel)){
                System.out.println("Die Aufgabe ist schon existiert");
                return false;
            }
        }
        System.out.println("Die Liste ist voll");
        return false;
    }

    public static String listeAlleAufgaben(){
        String ergibnis = "Aufgaben auf der Liste:\n";
        for(int i = 0; i < todos.length; i++){
            if(!(todos[i] == null)){
                ergibnis = ergibnis + todos[i] + "\n";
            }else{
                break;
            }
        }
        return ergibnis;
    }

    public static boolean loescheAufgabe(String titel){
        for(int i = 0; i < todos.length; i++){
            String pointer = todos[i];
            if(pointer == null){
                System.out.println("Die Aufgabe existiert nicht");
                return false;
            }
            if(pointer.equals(titel)){
                for(int j = i+1; j < todos.length; j++){
                    todos[j-1] = todos[j];
                    todos[j] = null;
                }
                return true;
            }
        }
        System.out.println("Die Aufgabe existiert nicht");
        return false;
    }

    public static boolean bearbeiteAufgabe(String alterTitel, String neuerTitel){
        for(int i = 0; i < todos.length; i++){
            if(todos[i] == null){
                System.out.println("Die alte Aufgabe existiert nicht");
                return false;
            }
            if(alterTitel.equals(todos[i])){
                todos[i] = neuerTitel;
                return true;
            }
        }
        System.out.println("Die alte Aufgabe existiert nicht");
        return false;
    }

    public static boolean setzeDatum(String titel, int jahr, int monat, int tag){
        LocalDate date = LocalDate.of(jahr,monat,tag);
        if(date.isBefore(fdate)){
            for(int i = 0; i < todos.length; i++){
                if(todos[i].equals(titel)){
                    daten[i] = date;
                    System.out.println("Fälligkeitsdatum für " + titel + " erfolgreich setzt");
                    return true;
                }
            }
            System.out.println("Die Aufgabe existiert nicht");
            return false;
        }
        System.out.println("Das Datum ist zu spät");
        return false;
    }

    public static String listeAlleAufgabenMitDatum(){
        String ergibnis = "Aufgaben auf der Liste:\n";
        for(int i = 0; i < todos.length; i++){
            if(!(todos[i] == null)){
                ergibnis = ergibnis + todos[i] + ", fällig am " + daten[i] + "\n";
            }else{
                break;
            }
        }
        return ergibnis;
    }

    public static String nachTitelSortieren(boolean aufsteigend){
        if(aufsteigend == true){
            int i = 0;
            while(i < todos.length){
                String temp = todos[i];
                LocalDate tempDate = daten[i];
                int pointer = i;
                for(int j = i+1; j < todos.length; j++){
                    if(todos[j] == null){
                        break;
                    }
                    if(temp.compareTo(todos[j]) > 0){
                        pointer = j;
                    }
                }
                todos[i] = todos[pointer];
                todos[pointer] = temp;
                daten[i] = daten[pointer];
                daten[pointer] = tempDate;
                i++; 
            }
            return listeAlleAufgabenMitDatum();
        }else{
            int i = 0;
            while(i < todos.length){
                String temp = todos[i];
                LocalDate tempDate = daten[i];
                int pointer = i;
                for(int j = i+1; j < todos.length; j++){
                    if(todos[j] == null){
                        break;
                    }
                    if(!(temp.compareTo(todos[j]) > 0)){
                        pointer = j;
                    }
                }
                todos[i] = todos[pointer];
                todos[pointer] = temp;
                daten[i] = daten[pointer];
                daten[pointer] = tempDate;
                i++; 
            }
            return listeAlleAufgabenMitDatum();
        }
        
    }

    public static String nachDatumSortieren(boolean aufsteigend){
        if(aufsteigend == true){
            int i = 0;
            while(i < daten.length){
                String temp = todos[i];
                LocalDate tempDate = daten[i];
                int pointer = i;
                for(int j = i+1; j < daten.length; j++){
                    if(todos[j] == null){
                        break;
                    }
                    if(tempDate.isAfter(daten[j])){
                        pointer = j;
                    }
                }
                todos[i] = todos[pointer];
                todos[pointer] = temp;
                daten[i] = daten[pointer];
                daten[pointer] = tempDate;
                i++; 
            }
            return listeAlleAufgabenMitDatum();
        }else{
            int i = 0;
            while(i < daten.length){
                String temp = todos[i];
                LocalDate tempDate = daten[i];
                int pointer = i;
                for(int j = i+1; j < daten.length; j++){
                    if(todos[j] == null){
                        break;
                    }
                    if(!tempDate.isAfter(daten[j])){
                        pointer = j;
                    }
                }
                todos[i] = todos[pointer];
                todos[pointer] = temp;
                daten[i] = daten[pointer];
                daten[pointer] = tempDate;
                i++; 
            }
            return listeAlleAufgabenMitDatum();
        }
        
    }
    public static void main(String[] args){

        File f = new File("12219130.txt");
        BufferedReader reader = null;

        try {
            for(int i = 0; i < daten.length; i++){
                daten[i] = fdate;
            }

            reader = new BufferedReader(new FileReader(f));
            String tempString = null;
            int line = 1;                
            int i = 0;
            int j = 0;
            while ((tempString = reader.readLine()) != null) {
                if((line%3 == 0) && (!tempString.equals("null"))){
                    todos[i] = tempString;
                    i++;
                }
                if(line%3 == 1 && line != 1){
                   String[] date = tempString.split("-");
                   int jahr = Integer.parseInt(date[0]);
                   int monat = Integer.parseInt(date[1]);
                   int tag = Integer.parseInt(date[2]);
                   LocalDate tempd = LocalDate.of(jahr,monat,tag);
                   daten[j] = tempd;
                   j++;
                }
                line++;
            }

            reader.close();
        }catch (IOException e){
            e.getMessage();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e1){
                    e1.getMessage();
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        scanner1.useDelimiter("\r\n");
        Boolean flag = true;

        while(flag){
            System.out.println("Willkommen in Ihrer To-Do-Liste, was möchten Sie tun?");
            System.out.println("[1] To-Dos anzeigen");
            System.out.println("[2] Eintrag hinzufügen");
            System.out.println("[3] Eintrag löschen");
            System.out.println("[4] Programm beenden");
            System.out.println("[5] Eintrag bearbeiten");
            System.out.println("[6] Datum setzen");
            System.out.println("[7] To-Dos mit Datum anzeigen");
            System.out.println("[8] To-Dos sortieren");
            
            int auswahl = scanner.nextInt();
            
            switch(auswahl){
                case 1:
                String erfolg1 = listeAlleAufgaben();
                System.out.println(erfolg1);
                break;

                case 2:
                System.out.println("Bitte geben Sie einen Titel ein:");
                String neuerTitel2 = scanner1.next();
                Boolean erfolg2 = neueAufgabe(neuerTitel2);
                if(erfolg2){
                    System.out.println("Die Aufgabe " + neuerTitel2 + " wurde hinzugefügt.");
                }else{
                    System.out.println("Die Aufgabe " + neuerTitel2 + " konnte nicht hinzugefügt werde.");
                }
                break;

                case 3:
                System.out.println("Bitte geben Sie einen Titel ein:");
                String neuerTitel3 = scanner1.next();
                Boolean erfolg3 = loescheAufgabe(neuerTitel3);
                if(erfolg3){
                    System.out.println("Die Aufgabe " + neuerTitel3 + " wurde gelöscht.");
                }else{
                    System.out.println("Die Aufgabe " + neuerTitel3 + " wurde nicht gelöscht.");
                }
                break;

                case 4:
                flag = false;
                scanner.close();
                scanner1.close();
                break;

                case 5:
                System.out.println("Bitte geben Sie einen Titel ein:");
                String alterTitel5 = scanner1.next();
                System.out.println("Bitte geben Sie einen neuen Titel ein:");
                String neuerTitel5 = scanner1.next();
                Boolean erfolg5 = bearbeiteAufgabe(alterTitel5, neuerTitel5);
                if(erfolg5){
                    System.out.println("Die Aufgabe " + alterTitel5 + " wurde umbenannt zu " + neuerTitel5);
                }else{
                    System.out.println("Die Aufgabe " + alterTitel5 + " konnte nicht umbenannt werden.");
                }
                break;

                case 6:
                System.out.println("Bitte geben Sie einen Titel ein:");
                String alterTitel6 = scanner1.next();
                System.out.println("Bitte geben Sie ein Datum ein:");
                int jahr = scanner.nextInt();
                int monat = scanner.nextInt();
                int tag = scanner.nextInt();
                LocalDate date6= LocalDate.of(jahr, monat, tag);
                Boolean erfolg6 = setzeDatum(alterTitel6, jahr, monat, tag);
                if(erfolg6){
                    System.out.println("Die Aufgabe " + alterTitel6 + " ist am " + date6 + " fällig.");
                }else{
                    System.out.println("Das Datum für " + alterTitel6 + " konnte nicht gesetzt werden.");
                }
                break;

                case 7:
                String erfolg7 = listeAlleAufgabenMitDatum();
                System.out.println(erfolg7);
                break;

                case 8:
                System.out.println("[1] nach Titel aufsteigend");
                System.out.println("[2] nach Titel absteigend");
                System.out.println("[3] nach Datum aufsteigend");
                System.out.println("[4] nach Datum absteigend");
                int auswahl8 = scanner.nextInt();
                switch(auswahl8){
                    case 1:
                    System.out.println(nachTitelSortieren(true)); 
                    break;

                    case 2:
                    System.out.println(nachTitelSortieren(false));
                    break;

                    case 3:
                    System.out.println(nachDatumSortieren(true));
                    break;

                    case 4:
                    System.out.println(nachDatumSortieren(false));
                    break;

                    default:
                    System.out.println("Ungültige Eingabe");
                    break;
                }
                break;

                default:
                System.out.println("Ungültige Eingabe");
                break;
            }
        }

        File file = new File("12219130.txt");
        LocalDateTime now = LocalDateTime.now();
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("Letzte Änderung: " + now + "\n\n");
            String s = "";
            for(int i = 0; i < todos.length; i++){
                s = s + todos[i] + "\n" + daten[i] + "\n\n";
            }
            fw.write(s);
            fw.flush();
            fw.close();
        }catch (IOException e){
           e.getMessage();
        }

        System.exit(0);
    }
}