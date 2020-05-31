
public class Marble {
	public static void main(String args[]) {
		Manager mg = new Manager();
		mg.start();
		
	}
}

class City{
	String name;
	int price;
	int owner;
	int toll;
	int player1;
	int player2;
	
	City(String city){
		this.name = city;
		this.price = 300;
		this.toll = 600;
	}
}

class Player{
	int pnum ;
	int balance = 5000;
	int location = 0;
	
	void move(int dice) {
		
		this.location += dice;
		if (location>=10) {
			location %= 10;
		}
		
	}
	void buy(City city) {
		int price = city.price;
		if (price > balance) {
			System.out.println("Can't buy"+city.name);
			System.out.println("player "+pnum+"'s balance is "+balance);
		}
		else {
			balance -= price;
			System.out.println("player "+pnum+" buys "+city.name);
			city.owner = pnum;
			city.name = city.name + "("+pnum+")";
			System.out.println("player "+pnum+"'s balance is "+balance);
		}
	}
	void pay(Player p) {
		System.out.println("Player"+p.pnum+"에게 통행료 지불");
		this.balance -= 600;
		p.balance += 600;
		System.out.println("Player"+pnum+"balance: "+balance);
	}
	Player(int i){
		this.pnum = i;
	}
}
class Manager{
	int turn = 0;
	int dice;
	Player p1 = new Player(1);
	Player p2 = new Player(2);
	City[] cityArray = new City[10];
	String[] cityName = {"Start","Seoul", "Tokyo","Sydney","LA","Cario",
			"Phuket","New delhi","Hanoi","Paris"};
	
	
	int dice() {
		return (int) (Math.random()*6)+1;
	}
	
	void program(Player h1, Player h2) {
		if (cityArray[h1.location].owner==0) {
			System.out.println(cityArray[h1.location].name+"(empty)");
			h1.buy(cityArray[h1.location]);
		}
		else if(cityArray[h1.location].owner == h1.pnum) {
			System.out.println(cityArray[h1.location].name);
			System.out.println("player "+h1.pnum+"'s balance is "+h1.balance);
		}
		else if(cityArray[h1.location].owner != h1.pnum) {
			h1.pay(h2);
		}
	}
	
	
	void showMap() {
		System.out.println("\n\n------------------------------------MAP----------------------------------");
		System.out.println("Turn"+ (turn+1));
		System.out.println("-------------  -------------  -------------  -------------  -------------");
		for (int i=0; i<cityArray.length/2; i++) {
			System.out.printf("ㅣ  %-11Sㅣ", cityArray[i].name);			
		}
		System.out.println();
		for(int i=0; i<cityArray.length/2; i++) {
			if (cityArray[i].player1 == 0 && cityArray[i].player2==0)
				System.out.print("ㅣ                           ㅣ");
			else if(cityArray[i].player1 == 1 && cityArray[i].player2==0)
				System.out.printf("ㅣ     (%d)       ㅣ",cityArray[i].player1);
			else if (cityArray[i].player1 == 0 && cityArray[i].player2==2)
				System.out.printf("ㅣ              (%d)  ㅣ",cityArray[i].player2);
			else 
				System.out.printf("ㅣ    (%d)  (%d) ㅣ",cityArray[i].player1, cityArray[i].player2);
			
		}
		System.out.println();
		System.out.println("-------------  -------------  -------------  -------------  -------------");
		System.out.println("     △                                                                                                                                       ㅣ            ");
		System.out.println("     ㅣ                                                                                                                                       ▽            ");
		System.out.println("-------------  -------------  -------------  -------------  -------------");
		for (int i=cityArray.length-1; i>4; i--) {
			System.out.printf("ㅣ  %-11Sㅣ", cityArray[i].name);			
		}
		System.out.println();
		for(int i=cityArray.length-1; i>4; i--) {
			if (cityArray[i].player1 == 0 && cityArray[i].player2==0)
				System.out.print("ㅣ                           ㅣ");
			else if(cityArray[i].player1 == 1 && cityArray[i].player2==0)
				System.out.printf("ㅣ     (%d)       ㅣ",cityArray[i].player1);
			else if (cityArray[i].player1 == 0 && cityArray[i].player2==2)
				System.out.printf("ㅣ              (%d)  ㅣ",cityArray[i].player2);
			else 
				System.out.printf("ㅣ    (%d)  (%d) ㅣ",cityArray[i].player1, cityArray[i].player2);
		}
		System.out.println();
		System.out.println("-------------  -------------  -------------  -------------  -------------\n\n");
	}
	
	void start() {
		for (int i=0; i<cityArray.length; i++)
			cityArray[i] = new City(cityName[i]);
		while (turn<30) {
			cityArray[p1.location].player1 = 0;
			cityArray[p2.location].player2= 0;
			dice = dice();
			p1.move(dice);
			System.out.println("player 1 got "+dice);
			if (p1.location == 0) {
				System.out.println("player 1 arrived at Start");
			}
			else {
				program(p1,p2);
				if (p1.balance<0)
					break;
			}
			cityArray[p1.location].player1 = 1;
			System.out.println("\n\n");
			dice = dice();
			p2.move(dice);
			System.out.println("player 2 got "+dice);
			if (p2.location == 0) {
				System.out.println("player 2 arrived at Start");
			}
			else {
				program(p2,p1);				
				if (p2.balance<0)
					break;
			}
			cityArray[p2.location].player2 = 2;
			
			showMap();
			turn ++;
			
			
		}
		if(p1.balance > p2.balance)
			System.out.println("Player 1 WINS");
		else if (p1.balance == p2.balance)
			System.out.println("GAME TIES");
		else
			System.out.println("Player 2 WINS");
		System.out.println("Game Over");
	}
	
}