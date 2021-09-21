package org.inspirecenter.amazechallenge.client;

import java.util.ArrayList;

public class Simulation {

    private final ArrayList<SimulationClient> clients = new ArrayList<>();
    private int numOfPlayers;
    private boolean debug;
    private long startTime;
    private long endTime;

    public Simulation(int numOfPlayers, boolean debug) {
        this.debug = debug;
        this.startTime = System.currentTimeMillis();
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

    public ArrayList<SimulationClient> getClients() {
        return clients;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public static void main(String[] args) {
        new Simulation(1, true);
    }

}
