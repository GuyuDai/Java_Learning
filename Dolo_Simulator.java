import java.util.Random;
import java.util.Scanner;

public class Dolo_Simulator {
    public static void main(String[] args){
        int key;
        int rubbish;
        int fliter;
        int normal;

        Scanner scan = new Scanner(System.in);
        
        System.out.println("How many Keys are in this deck :");
        key = scan.nextInt();
        System.out.println("How many Rubbishes are in this deck :");
        rubbish = scan.nextInt();
        System.out.println("How many Normals are in this deck :");
        normal = scan.nextInt();
        System.out.println("How many Fliters are in this deck :");
        fliter = scan.nextInt();
        
        scan.close();

        Deck myDeck = new Deck(key, rubbish, fliter, normal);
        myDeck.Rate5();
        myDeck.Rate6();
    }
}

enum Arte{
    Key, Rubbish, Fliter, Normal
}

class Kart{
    public Arte art;

    public Kart(Arte art){
        this.art = art;
    }

    public Arte getArte(){
        return art;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Kart){
            Kart o = (Kart)obj;
            return o.getArte().equals(this.getArte());
        }
        return false;
    }
}

class Deck{
    public Kart[] deck;
    public int amount;

    public Deck(int key, int rubbish, int fliter, int normal){
        this.amount = key + rubbish + fliter + normal;
        this.deck = new Kart[amount];

        int i = 0;
        while(i < key){
            deck[i] = new Kart(Arte.Key);
        }
        while(i < key + rubbish){
            deck[i] = new Kart(Arte.Rubbish);
        }
        while(i < key + rubbish + fliter){
            deck[i] = new Kart(Arte.Fliter);
        }
        while(i < amount){
            deck[i] = new Kart(Arte.Normal);
        }
    }

    public Kart[] dolo5(){
        Kart[] dolo5 = new Kart[5];
        Random random = new Random();

        int i = 0;
        while(i < 5){
            int x = random.nextInt(this.amount);
            if(deck[x] != null){
                dolo5[i] = deck[amount];
                deck[amount] = null;
                i++;
            }
        }

        return dolo5;
    }

    public Kart[] dolo6(){
        Kart[] dolo6 = new Kart[6];
        Random random = new Random();

        int i = 0;
        while(i < 6){
            int x = random.nextInt(this.amount);
            if(deck[x] != null){
                dolo6[i] = deck[amount];
                deck[amount] = null;
                i++;
            }
        }

        return dolo6;
    }

    public void Rate5(){
        Kart[] dolo = this.dolo5();
        int count_key = 0;
        int count_rubbish = 0;

        int i = 0;
        //while(i < 10){
        while(i < 100000){
            for(int j = 0; j < 5; j++){
                switch(dolo[j].getArte()){
                    case Key:
                    count_key++;
                    j++;
                    break;

                    case Rubbish:
                    count_rubbish++;
                    j++;
                    break;

                    case Normal:
                    j++;
                    break;

                    case Fliter:
                    Random random_in_Rate5 = new Random();
                    int x = random_in_Rate5.nextInt(this.amount);
                    if(this.deck[x] != null){
                        dolo[j] = this.deck[x];
                        this.deck[x] = null;
                    }
                    break;

                    default:
                    break;
                }
            }
        }

        float rate_key = count_key/(this.amount * 100000);
        float rate_rubbish = count_rubbish/(this.amount * 100000);
        System.out.println("rate in dolo5 of key is " + rate_key);
        System.out.println("rate in dolo5 of rubbish is " + rate_rubbish);
    }

    public void Rate6(){
        Kart[] dolo = this.dolo6();
        int count_key = 0;
        int count_rubbish = 0;

        int i = 0;
        //while(i < 10){
        while(i < 100000){
            for(int j = 0; j < 6; j++){
                switch(dolo[j].getArte()){
                    case Key:
                    count_key++;
                    j++;
                    break;

                    case Rubbish:
                    count_rubbish++;
                    j++;
                    break;

                    case Normal:
                    j++;
                    break;

                    case Fliter:
                    Random random_in_Rate6 = new Random();
                    int x = random_in_Rate6.nextInt(this.amount);
                    if(this.deck[x] != null){
                        dolo[j] = this.deck[x];
                        this.deck[x] = null;
                    }
                    break;

                    default:
                    break;
                }
            }
        }
        
        float rate_key = count_key/(this.amount * 100000);
        float rate_rubbish = count_rubbish/(this.amount * 100000);
        System.out.println("rate in dolo6 of key is " + rate_key);
        System.out.println("rate in dolo6 of rubbish is " + rate_rubbish);
    }
}