/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grafos.unimet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Isa
 */
public class UndirectedGraph {
    
    public final int MAX_VERTICES = 30;
    
    private static final int INITIAL = 0;
    private static final int WAITING = 1;
    private static final int VISITED = 2;
    
    private static final int DINITIAL = 0;
    private static final int DVISITED = 1;
    private static final int DFINISHED = 2;
    private static int time;
    
    
    int n;
    int e;
    boolean [][] adj;
    Node [] nodeList;
    String bridges = "";
    
    public UndirectedGraph(){
        
        adj = new boolean [MAX_VERTICES][MAX_VERTICES];
        nodeList = new Node[MAX_VERTICES];
    }
    
    public String isConnected(){
        String isConnected;
    
        for(int v = 0; v < n; v++){
            nodeList[v].setState(INITIAL);
        }
        
        int cN = 1;
        bfsC(0,cN);
        
         for(int v = 0; v < n; v++){
            if(nodeList[v].getState() == INITIAL){
            
                cN++;
                bfsC(v, cN);
            }
        }
         
           if(cN == 1){
               isConnected = "El grafo esta completamente conectado";
                System.out.println(isConnected);
                return isConnected;
            }
            else{
                isConnected = "El grafo no esta completamente conectado, tiene "+cN+" islas";
                System.out.println(isConnected);
                return isConnected;
            }
    }
    
    public String isConnectedDFS(){
        String isConnected;
    
        for(int v = 0; v < n; v++){
            nodeList[v].setState(DINITIAL);
        }
        
        int cN = 1;
        bfsC(0,cN);
        
         for(int v = 0; v < n; v++){
            if(nodeList[v].getState() == DINITIAL){
            
                cN++;
                bfsC(v, cN);
            }
        }
         
           if(cN == 1){
               isConnected = "El grafo esta completamente conectado";
                System.out.println(isConnected);
                return isConnected;
            }
            else{
                isConnected = "El grafo no esta completamente conectado, tiene "+cN+" islas";
                System.out.println(isConnected);
                return isConnected;
            }
    }
    
    public void dfsTraversal(){
    
        for(int v = 0; v < n; v++){
            nodeList[v].setState(DINITIAL);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce nodo inicial para Breadth First Search : ");
        String s = scan.next();
        dfs(getIndex(s));
    }
    
    public void dfsTraversal_All(){
    
        for(int v = 0; v < n; v++){
            nodeList[v].setState(DINITIAL);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce nodo inicial para Breadth First Search : ");
        String s = scan.next();
        dfs(getIndex(s));
        
        for(int v = 0; v < n; v++){
        
            if(nodeList[v].getState() == DINITIAL){
                dfs(v);
            }
        }
    }
    
     private void dfs(int v) {
     
         Stack<Integer> st = new Stack();
         st.push(v);
         
         while(!st.isEmpty()){
         
             v = st.pop();
             if(nodeList[v].getState() == DINITIAL){
             
                 System.out.println(nodeList[v]+" ");
                 nodeList[v].setState(DVISITED);
             }
             
             for(int i = n-1; i >= 0; i--){
                 
                 if(isAdjacent(v, i) && nodeList[v].getState() == DINITIAL){
                     st.push(i);
                 }
             }
         }
         System.out.println();
     }
     
     
     private void dfsC(int v, int cN) {
     
         Stack<Integer> st = new Stack();
         st.push(v);
         
         while(!st.isEmpty()){
         
             v = st.pop();
             if(nodeList[v].getState() == DINITIAL){
             
                 System.out.println(nodeList[v]+" ");
                 nodeList[v].setState(DVISITED);
                 nodeList[v].setComponentNumber(cN);
             }
             
             for(int i = n-1; i >= 0; i--){
                 
                 if(isAdjacent(v, i) && nodeList[v].getState() == DINITIAL){
                     st.push(i);
                 }
             }
         }
         System.out.println();
     }
    
    private void bfsC(int v, int cN) {

        Queue<Integer> qu = new LinkedList();
        qu.add(v);
        nodeList[v].setState(WAITING);
        
        while(!qu.isEmpty()){
            v = qu.remove();
            nodeList[v].setState(VISITED);
            nodeList[v].setComponentNumber(cN);
            
            for(int i = 0; i < n; i++){
                if(isAdjacent(v, i) && nodeList[i].getState() == INITIAL){
                    qu.add(i);
                    nodeList[i].setState(WAITING);
                }
            }
        }
    }
    
    public void bfsTraversal(){

        for(int v = 0; v < n; v++){
            nodeList[v].setState(INITIAL);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce nodo inicial para Breadth First Search : ");
        String s = scan.next();
        bfs(getIndex(s));
        
    }
    
    private void bfs(int v) {
        Queue<Integer> qu = new LinkedList();
        qu.add(v);
        nodeList[v].setState(WAITING);
        
        while(!qu.isEmpty()){
            
            v = qu.remove();
            System.out.println(nodeList[v] + " ");
            nodeList[v].setState(VISITED);
            
            for(int i = 0; i < n; i++){
                if(isAdjacent(v, i) && nodeList[i].getState() == INITIAL){
                    qu.add(i);
                    nodeList[i].setState(WAITING);
                }
            }
        }
        
        System.out.println();
    }
    
    public void bfsTraversal_All(){
        int v;
        
        for(v = 0; v < n; v++){
            nodeList[v].setState(INITIAL);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce nodo inicial para Breadth First Search : ");
        String s = scan.next();
        bfs(getIndex(s));
        
        for(v = 0; v < n; v++){
        
            if(nodeList[v].getState() == INITIAL){
                bfs(v);
            }
        }
    }
    
    private void dfsRecurrent(int v){
        System.out.println(v+" "+nodeList[v].getDisplayName());
        nodeList[v].setState(DVISITED);
        int t = ++time;
        nodeList[v].setDiscoveryTime(t);
        nodeList[v].setLowTime(t);
        
        for(int i =0 ; i < n; i++){
            if(isAdjacent(v, i) && nodeList[v].getDfsParent() != null && nodeList[v].getDfsParent().equals(nodeList[i])){
                continue;
            }
            if(isAdjacent(v, i) && nodeList[i].getState() == DVISITED){
                System.out.println("if(isAdjacent(v, i) && nodeList[i].getState() == DVISITED){");
                nodeList[v].setLowTime(Math.min(nodeList[v].getLowTime(), nodeList[i].getDiscoveryTime()));
            }
            if(isAdjacent(v, i) && nodeList[i].getState() == DINITIAL){
                System.out.println("if(isAdjacent(v, i) && nodeList[i].getState() == DINITIAL){");
                nodeList[i].setParent(nodeList[v]);
                dfsRecurrent(i);
                nodeList[v].setLowTime(Math.min(nodeList[v].getLowTime(), nodeList[i].getLowTime()));
                if(nodeList[i].getLowTime() > nodeList[v].getDiscoveryTime()){
                    System.out.println("if(nodeList[i].getLowTime() > nodeList[v].getDiscoveryTime()){");
                    bridges += nodeList[v].getDisplayName()+" - "+nodeList[i].getDisplayName()+", \n";
                    System.out.println("Bridges "+bridges);
                }
            }
        }
        nodeList[v].setState(DFINISHED);
        nodeList[v].setFinishingTime(++time);
    }
    
       public void dfsTraversalRecurrent(){
    
        for(int v = 0; v < n; v++){
            nodeList[v].setState(DINITIAL);
        }
        time = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce nodo inicial para Depth First Search : ");
        String s = scan.next();
        dfsRecurrent(getIndex(s));
        
        for(int v = 0; v < n; v++){
            System.out.println("Node "+nodeList[v]);
            System.out.println("Discovery Time "+nodeList[v].getDiscoveryTime());
            System.out.println("Finishing Time "+nodeList[v].getFinishingTime());
        }
    }
    
    public void dfsTraversal_AllRecurrent(){
    
        for(int v = 0; v < n; v++){
            nodeList[v].setState(DINITIAL);
        }
        time = 0;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Introduce nodo inicial para Breadth First Search : ");
//        String s = scan.next();
//        dfsRecurrent(getIndex(s));
        dfsRecurrent(0);
        
        for(int v = 0; v < n; v++){
        
            if(nodeList[v].getState() == DINITIAL){
                dfsRecurrent(v);
            }
        }
        
        for(int v = 0; v < n; v++){
            System.out.println("Node "+nodeList[v]);
            System.out.println("Discovery Time "+nodeList[v].getDiscoveryTime());
            System.out.println("Lower Time "+nodeList[v].getLowTime());
            System.out.println("Finishing Time "+nodeList[v].getFinishingTime());
        }
    }
    
    public String findBridges(){
    
        dfsTraversal_AllRecurrent();
        return bridges;
    }
    
    public int nodes(){
        return n;
    }
    
    public int edges(){
        return e;
    }
    
    public void display(){
        
        for(int i = 0; i < n; i++){
        
            for (int j = 0; j < n; j++){
            
                if(adj[i][j]){
                    System.out.println("1 ");
                }
                else{
                    System.out.println("0 ");
                }
                System.out.println();
            }
        }
    }
    
    
    
    private int getIndex(String s){
         for(int i = 0; i < n; i++){
             nodeList[i].getDisplayName();
             if(s.equals(nodeList[i].getDisplayName())){
                 return i;
             }
         }
         throw new RuntimeException("Nodo invalido");
    }
    
    public Node insertNode(String name, int id){
        Node node = new Node(name, id);
        nodeList[n++] = node;  
        return node;
    }
    
    public boolean edgeExist(String s1, String s2){
        return isAdjacent(getIndex(s1), getIndex(s2));
    }

    private boolean isAdjacent(int u, int v) {
       return adj[u][v];
    }
    
    public Edge insertEdge(Node n1, Node n2, int years){
        
        String s1 = n1.getDisplayName();
        String s2 = n2.getDisplayName();

        int u  = getIndex(s1);
        int v = getIndex(s2);
        
        if(adj[u][v] == true){
            System.out.println("Ya existe el eje");
        }
        else{
            adj[u][v] = true;
            adj[v][u] = true;
            e++;
        }
        Edge edge = new Edge(n1, n2, years);
        return edge;
    }
    
    public void deletetEdge(String s1, String s2){
        int u  = getIndex(s1);
        int v = getIndex(s2);
        
        if(adj[u][v] == false){
            System.out.println("Eje no existe");
        }
        else{
            adj[u][v] = false;
            adj[v][u] = false;
            e--;
        }
    }
    
    public int degree(String s){
        int u = getIndex(s);
        int deg = 0;
        
        for(int v = 0; v < n; v++){
            if(adj[u][v]){
                deg++;
            }
        }
        return deg;
    }

 
}
