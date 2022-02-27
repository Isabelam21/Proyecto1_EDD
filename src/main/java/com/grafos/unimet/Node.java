package com.grafos.unimet;

import java.awt.*;

public class Node {
    private boolean automaticName = true;
    private String displayName;
    
   private int state;
   private int componentNumber;

    private Color color = Color.black;

    private Position position;
    
    private int discoveryTime;
    
    private int lowTime;
    
    private int finishingTime;
    
    private Node dfsParent;

    public Node() {

    }

    public Node(Position edgePosition) { 
        this.position = edgePosition;
    }
    
     public Node(String name) {
         automaticName = false;
       this.displayName = name; 
    }
     
     public Node(String name, int componentNumber) {
         automaticName = false;
       this.displayName = name; 
       this.componentNumber = componentNumber;
    }

    public int getComponentNumber() {
        return componentNumber;
    }

    public void setComponentNumber(int componentNumber) {
        this.componentNumber = componentNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

  

    public void setDisplayName(String displayName) {
        automaticName = false;
        this.displayName = displayName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAutomaticName() {
        return automaticName;
    }

    public String getDisplayName() {
        if (isAutomaticName()) {
            displayName = NameUtil.getInstance().getName();
        }
        return displayName;
    }

    public Position getPosition() {
        return position;
    }

    void setDiscoveryTime(int i) {
        this.discoveryTime = i;
    }
    
    void setFinishingTime(int i) {
        this.finishingTime = i;
    }

    public int getDiscoveryTime() {
        return discoveryTime;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    void setLowTime(int i) {
        this.lowTime = i;
    }

     public int getLowTime() {
        return lowTime;
    }

    void setParent(Node node) {
        this.dfsParent = node;
    }

    public Node getDfsParent() {
        return dfsParent;
    }
     
    public static class Position {
        int posX;
        int posY;

        public Position() {
            this(0, 0);
        }

        public Position(int posX, int posY) {

            this.posX = posX;
            this.posY = posY;
        }
    }
}
