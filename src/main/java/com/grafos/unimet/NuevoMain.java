package com.grafos.unimet;

import com.grafos.unimet.Edge;
import com.grafos.unimet.GraphDraw;
import com.grafos.unimet.Node;
import com.grafos.unimet.UndirectedGraph;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author isa
 */
public class NuevoMain extends JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;

    private GraphDraw draw;
    private UndirectedGraph g;
    private String fileRoute;
    private int idMax = 0;

    public static int nodeCount = 0;
    public static int pairCount = 0;
    public static int xPosition = 100;
    public static int yPosition = 200;

    private static List<Node> nodesList = new ArrayList<>();

    private boolean graphLoaded = false;

    public NuevoMain() {
        initComponents();
    }

    public static void main(String[] args) {
        new NuevoMain().setVisible(true);
    }

    private void initComponents() {

        //create an object
        draw = new GraphDraw();
        g = new UndirectedGraph();

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        draw = new GraphDraw();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar Grafo");

        jButton2.setText("Islas BFS");

        jButton3.setText("Islas DFS");

        jButton4.setText("Nuevo Usuario");

        jButton5.setText("Nueva Conexion");

        this.setPreferredSize(new Dimension(1800, 800));
        draw.setPreferredSize(new Dimension(2800, 800));
        jScrollPane1.setViewportView(draw);

        jButton6.setText("Puentes");

        jButton7.setText("Eliminar Usuario");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFile();

            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (graphLoaded) {

                    isConnected();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe cargar el archivo del grafo para continuar");
                }
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (graphLoaded) {

                    isConnectedDFS();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe cargar el archivo del grafo para continuar");
                }

            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (graphLoaded) {

                    newUser();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe cargar el archivo del grafo para continuar");
                }

            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (graphLoaded) {

                    deleteUser();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe cargar el archivo del grafo para continuar");
                }

            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (graphLoaded) {

                    addConnection();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe cargar el archivo del grafo para continuar");
                }

            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (graphLoaded) {

                    findBridges();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe cargar el archivo del grafo para continuar");
                }

            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField1)
                                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator1)
                                                .addComponent(jSeparator2)
                                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2)
                                                .addComponent(jTextField3))
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton7)
                                                .addGap(14, 14, 14)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton5)
                                                .addGap(0, 147, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void loadFile() {
        // create an object of JFileChooser class
        JFileChooser filePath = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsOpenDialog function to show the save dialog
        int r = filePath.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION) {

            fileRoute = filePath.getSelectedFile().getAbsolutePath();
            // set the label to the path of the selected file

            System.out.println(fileRoute);
            if (!fileRoute.endsWith("txt")) {
                JOptionPane.showMessageDialog(null, "formato de archivo no valido, intente de nuevo");
                return;
            }

            graphLoaded = true;
            File file = new File(
                    fileRoute);

            // Note:  Double backquote is to avoid compiler
            // interpret words
            // like \test as \t (ie. as a escape sequence)
            // Creating an object of BufferedReader class
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Declaring a string variable
            String st;
            try {
                boolean usuario = false;
                boolean relaciones = false;
                // Condition holds true till
                // there is character in a string
                while ((st = br.readLine()) != null) {

                    // Print the string
                    System.out.println(st);
                    if (st.equalsIgnoreCase("Usuarios")) {
                        usuario = true;
                    }
                    if (usuario == true && relaciones == false) {
                        String[] us = st.split(",");
                        if (us.length > 1) {
                            insertNode(us[1].trim(), Integer.parseInt(us[0].trim()), g, draw);
                        }

                    }
                    if (st.equalsIgnoreCase("Relaciones")) {
                        relaciones = true;
                    }
                    if (usuario == true && relaciones == true) {
                        String[] ed = st.split(",");
                        if (ed.length > 1) {
                            insertEdge(Integer.parseInt(ed[0].trim()), Integer.parseInt(ed[1].trim()), Integer.parseInt(ed[2].trim()), g, draw);
                        }
                    }
                }
                if (usuario == false || relaciones == false) {
                    JOptionPane.showMessageDialog(null, "archivo mal formado, no se puede leer el contenido");
                    System.out.println("archivo mal formado, no se puede leer el contenido");
                }
            } catch (IOException ex) {
                Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jPanel1.repaint();

    }

    private void loadFileRoute(String fileRoute) {

        nodeCount = 0;
        pairCount = 0;
        draw = new GraphDraw();
        g = new UndirectedGraph();
        draw.setPreferredSize(new Dimension(2800, 800));
        jScrollPane1.setViewportView(draw);

        // set the label to the path of the selected file
        System.out.println(fileRoute);

        File file = new File(
                fileRoute);

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
        // Creating an object of BufferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Declaring a string variable
        String st;
        try {
            boolean usuario = false;
            boolean relaciones = false;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {

                // Print the string
                System.out.println(st);
                if (st.equalsIgnoreCase("Usuarios")) {
                    System.out.println(" if (st.equalsIgnoreCase(\"Usuarios\")");
                    usuario = true;
                }
                if (usuario == true && relaciones == false) {
                    System.out.println(" if (usuario == true && relaciones == false)");
                    String[] us = st.split(",");
                    if (us.length > 1) {
                        insertNode(us[1].trim(), Integer.parseInt(us[0].trim()), g, draw);
                    }

                }
                if (st.equalsIgnoreCase("Relaciones")) {
                    System.out.println(" if (st.equalsIgnoreCase(\"Relaciones\")");
                    relaciones = true;
                }
                if (usuario == true && relaciones == true) {
                    System.out.println(" if (usuario == true && relaciones == true)");
                    String[] ed = st.split(",");
                    if (ed.length > 1) {
                        insertEdge(Integer.parseInt(ed[0].trim()), Integer.parseInt(ed[1].trim()), Integer.parseInt(ed[2].trim()), g, draw);
                    }
                }
            }
            if (usuario == false || relaciones == false) {
                JOptionPane.showMessageDialog(null, "archivo mal formado, no se puede leer el contenido");
                System.out.println("archivo mal formado, no se puede leer el contenido");
            }
        } catch (IOException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void findBridges() {

        String bridges = g.findBridges();
        JTextArea jta = new JTextArea(15, 30);
        jta.setText(bridges);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        JOptionPane.showMessageDialog(null, jsp, "puentes", 1);

    }

    private void isConnected() {
        String isConnected = g.isConnected();
        JOptionPane.showMessageDialog(null, isConnected);
    }

    private void isConnectedDFS() {
        String isConnected = g.isConnectedDFS();
        JOptionPane.showMessageDialog(null, isConnected);
    }

    private void newUser() {
        String fileContent = "";
        String nodeName = jTextField1.getText();

        File file = new File(
                fileRoute);

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
        // Creating an object of BufferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Declaring a string variable
        String st;
        try {
            boolean usuario = false;
            boolean relaciones = false;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {

                // Print the string
                System.out.println(st);

                if (st.equalsIgnoreCase("Usuarios")) {
                    usuario = true;
                }
                if (usuario == true && relaciones == false) {
                    String[] us = st.split(",");
                    if (us.length > 1) {
                        if (Integer.parseInt(us[0].trim()) > idMax) {
                            idMax = Integer.parseInt(us[0].trim());
                        }
                        // insertNode(us[1].trim(), Integer.parseInt(us[0].trim()), g, draw);
                    }

                }
                if (relaciones == false && st.equalsIgnoreCase("Relaciones")) {
                    relaciones = true;
                    int id = idMax + 1;
                    if (!nodeName.startsWith("@")) {
                        nodeName = "@" + nodeName;
                    }
                    String n = "" + id + ", " + nodeName + "\nRelaciones\n";
                    fileContent += n;
                } else {
                    fileContent += st + "\n";
                }

            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoute));
            System.out.println();
            System.out.println("***********FileContent");
            System.out.println(fileContent);
            writer.write(fileContent);
            writer.close();

            jTextField1.setText("");
            loadFileRoute(fileRoute);

        } catch (IOException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteUser() {
        String fileContent = "";
        String nodeName = jTextField1.getText();
        if (!nodeName.startsWith("@")) {
            nodeName = "@" + nodeName;
        }

        File file = new File(
                fileRoute);

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
        // Creating an object of BufferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Declaring a string variable
        String st;
        try {
            boolean usuario = false;
            boolean relaciones = false;
            String idEliminar = "";
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {

                // Print the string
                System.out.println(st);

                if (st.equalsIgnoreCase("Usuarios")) {
                    usuario = true;
                    fileContent += st + "\n";
                }
                if (usuario == true && relaciones == false) {
                    String[] us = st.split(",");
                    if (us.length > 1) {

                        if (!us[1].trim().equals(nodeName)) {
                            fileContent += st + "\n";
                        } else {
                            idEliminar = us[0].trim();
                            System.out.println("ID__ELIMINAR " + idEliminar);
                        }

                    }

                }
                if (usuario == true && relaciones == true) {
                    String[] us = st.split(",");
                    if (!us[0].trim().equals(idEliminar) && !us[1].trim().equals(idEliminar)) {
                        fileContent += st + "\n";
                    }
                }
                if (relaciones == false && st.equalsIgnoreCase("Relaciones")) {
                    relaciones = true;
                    fileContent += st + "\n";
                }

            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoute));
            System.out.println();
            System.out.println("***********FileContent");
            System.out.println(fileContent);
            writer.write(fileContent);
            writer.close();

            loadFileRoute(fileRoute);

        } catch (IOException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextField1.setText("");
    }

    public void addConnection() {
        String fileContent = "";
        String initNode = jTextField2.getText();
        String finishNode = jTextField3.getText();
        boolean initNodeExist = false;
        boolean finishNodeExist = false;
        String initNodeId = "";
        String finishNodeId = "";

        String years = String.valueOf(jSpinner1.getValue());

        if (!initNode.startsWith("@")) {
            initNode = "@" + initNode;
        }

        if (!finishNode.startsWith("@")) {
            finishNode = "@" + finishNode;
        }

        File file = new File(
                fileRoute);

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
        // Creating an object of BufferedReader class
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Declaring a string variable
        String st;
        try {
            boolean usuario = false;
            boolean relaciones = false;
            String idEliminar = "";
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {

                // Print the string
                System.out.println(st);

                if (st.equalsIgnoreCase("Usuarios")) {
                    usuario = true;
                }
                if (usuario == true && relaciones == false) {
                    String[] us = st.split(",");
                    if (us.length > 1) {

                        if (!us[1].trim().equals(initNode)) {
                            initNodeId = us[0].trim();
                            initNodeExist = true;
                        }
                        if (!us[1].trim().equals(finishNode)) {
                            finishNodeId = us[0].trim();
                            finishNodeExist = true;
                        }

                    }
                    fileContent += st + "\n";
                }
                if (usuario == true && relaciones == true) {
                    fileContent += st + "\n";
                }
                if (relaciones == false && st.equalsIgnoreCase("Relaciones")) {
                    relaciones = true;
                }

            }

            if (initNodeExist && finishNodeExist) {
                fileContent += initNodeId + ", " + finishNodeId + ", " + years + "\n";
            } else {
                System.out.println("Uno de los nodos no existe");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoute));
            System.out.println();
            System.out.println("***********FileContent");
            System.out.println(fileContent);
            writer.write(fileContent);
            writer.close();

            loadFileRoute(fileRoute);

        } catch (IOException ex) {
            Logger.getLogger(NuevoMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextField2.setText("");
        jTextField3.setText("");
    }

    public static void insertNode(String nodeName, int id, UndirectedGraph g, GraphDraw draw) {
        Node node = g.insertNode(nodeName, id);
        nodeCount++;
        if (nodeCount % 2 == 0) {
            node.setPosition(new Node.Position(xPosition + 150 * pairCount, yPosition - 100));
            pairCount++;
        } else {
            node.setPosition(new Node.Position(xPosition + 150 * pairCount, yPosition + 100));
        }
        draw.addNode(node);
    }

    public static void insertEdge(int firstNodeId, int secondNodeId, int years, UndirectedGraph g, GraphDraw draw) {
        Node n1 = draw.getNode(firstNodeId);
        Node n2 = draw.getNode(secondNodeId);
        Edge edge = g.insertEdge(n1, n2, years);
        draw.addEdge(edge);
    }
}
