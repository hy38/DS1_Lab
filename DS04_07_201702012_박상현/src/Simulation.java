
public class Simulation {

	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static SimServer[] servers;
	static Client[] clients;
	static Queue queue = new SLinkedQueue();
	static java.util.Random randomArrival;
	static java.util.Random randomService;

	public static void main(String[] args) {
		init(args);

	
		run(); 
	}

	static void init(String[] args) {
		if (args.length < 4) {
			System.out.println(
					"Usage : java Simulation <numServers> " + "<numClients> <meanServiceTime> <meanInterarrivalTime> ");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0);
		}

		numServers = Integer.parseInt(args[0]);
		numClients = Integer.parseInt(args[1]);
		meanServiceTime = Integer.parseInt(args[2]);
		meanInterarrivalTime = Integer.parseInt(args[3]);

		servers = new SimServer[numServers];
		clients = new Client[numClients];
		randomService = new ExponentialRandom(meanServiceTime);
		randomArrival = new ExponentialRandom(meanInterarrivalTime);
		queue = new SLinkedQueue();

		for (int j = 0; j < numServers; j++) {
			servers[j] = new SimServer(j, randomService.nextInt());
		}

		System.out.println("	Number of servers = " + numServers);
		System.out.println("	Number of clients = " + numClients);
		System.out.println("	Mean service time = " + meanServiceTime);
		System.out.println("	Mean interarrival time = " + meanInterarrivalTime);

		for (int j = 0; j < numServers; j++) {
			System.out.println("Mean service time for " + servers[j] + "=" + servers[j].getMeanServiceTime());
		}
	}

	static void run() {
		int i = 0;
		int nextArrivalTime = 0;
		int temp = 0;
		for (int t = 0;; t++) {

			if (t == nextArrivalTime) {

				if (i >= numClients)
					break;

				Client client = clients[i] = new SimClient(i, t);

				servers[i % 4].queue().add(client);
				i++;

				nextArrivalTime = t + randomArrival.nextInt();

			}

			for (int j = 0; j < numServers; j++) {
				Server server = servers[j]; 

				if (t == server.getStopTime())
					server.stopServing(t); 
				if (server.isIdle() && !servers[j].queue().empty()) { 
					Client client = (SimClient) servers[j].queue().remove(); 
	
					server.startServing(client, t); 
						temp = temp +( server.getStopTime() - client.getStartTime());

				}
			}
		}
	
		System.out.println("	Mean service time = " + meanServiceTime);
		System.out.print(" "+temp / 1000);
	}
}