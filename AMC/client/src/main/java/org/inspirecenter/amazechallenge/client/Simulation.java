package org.inspirecenter.amazechallenge.client;

import java.util.ArrayList;

public class Simulation {

    private final ArrayList<SimulationClient> clients = new ArrayList<>();
    private int numOfPlayers;
    private boolean debug;

    public Simulation(int numOfPlayers, boolean debug) {
        this.debug = debug;
        this.numOfPlayers = numOfPlayers;
        System.out.print("Creating " + numOfPlayers + " clients...");

        //Create clients:
        for (int i = 0; i < numOfPlayers; i++) {
            SimulationClient simulationClient = new SimulationClient(this, "player" + i);
            clients.add(simulationClient);
        }

        System.out.println("[OK]");

        //Start clients:
        System.out.println("Starting clients...");
        for (SimulationClient client : clients) {
            client.start();
        }
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public boolean isDebug() {
        return debug;
    }

    public static void main(String[] args) {
        new Simulation(10, true);
    }

}
