package TwitterAnalysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import Exceptions.NoPathException;
import Helpers.*;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.*;

public class TwitterAnalysis {
    static Graph aGraph;

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage:  <query file> <output file>");
            throw new RuntimeException();
        }

        FileInputStream queryFile;
        FileOutputStream outputFile;

        try {
//            File file = new File(".");
//            for(String fileNames : file.list()) System.out.println(fileNames);
            
            queryFile = new FileInputStream(args[0]);
            outputFile = new FileOutputStream(args[1]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Vertex vertexA = new Vertex(args[0]);
        Vertex vertexB = new Vertex(args[1]);

        BufferedReader queryReader = new BufferedReader(new InputStreamReader(queryFile));
        String line;
        List<Query> queryList = new ArrayList<Query>();
        List<String> uniqueLines = new ArrayList<String>();
        try {
            while ((line = queryReader.readLine()) != null) {
                // ignore duplicates
                if (!uniqueLines.contains(line)) {
                    uniqueLines.add(line);

                    String[] tokens = line.split(" ");

                    QueryTypeEnum type;
                    if (tokens[0].trim().equals("commonInfluencers")) {
                        type = QueryTypeEnum.commonInfluencers;
                    } else if (tokens[0].trim().equals("numRetweets")) {
                        type = QueryTypeEnum.numRetweets;
                    } else {
                        throw new RuntimeException("Syntax Error: Wrong query type");
                    }

                    if (tokens[3].trim().equals("?")) {
                        queryList.add(new Query(type, tokens[1].trim(), tokens[2].trim()));
                    }
                }
            }
            queryReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // read Twitter file
        readTwitterfile();

        // read queries and write to the file
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(outputFile));
        for (Query q : queryList) {
            StringBuilder result = new StringBuilder();
            if (q.type == QueryTypeEnum.commonInfluencers) {
                result = commonInfluencers(q.type, q.userA, q.userB);
            } else {
                result = numRetweets(q.type, q.userA, q.userB);
            }
            try {
                outputWriter.write(result.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            outputWriter.close();
            outputFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

    /**
     * 
     * @param type
     * @param userA
     * @param userB
     * @return
     */
    private static StringBuilder numRetweets(QueryTypeEnum type, String followedUser, String followerUser) {
        Vertex followed = new Vertex(followedUser);
        Vertex follower= new Vertex(followerUser);
        
        int distance = -1;
        try {
            distance = Algorithms.shortestDistance(aGraph, follower, followed);
        } catch (NoPathException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 

        StringBuilder result = new StringBuilder();
        result.append("query: " + type.toString() + " " + followedUser + " " + followerUser).append(System.getProperty("line.separator"));
        result.append("<result>").append(System.getProperty("line.separator"));
        if (distance != -1) {
            result.append(String.valueOf(distance)).append(System.getProperty("line.separator"));
        } else {
            result.append("No path!").append(System.getProperty("line.separator"));

        }

        result.append("</result>").append(System.getProperty("line.separator"));

        return result;
    }

    /**
     * 
     * @param type
     * @param userA
     * @param userB
     * @return
     */
    private static StringBuilder commonInfluencers(QueryTypeEnum type, String userA, String userB) {
        Vertex a = new Vertex(userA);
        Vertex b = new Vertex(userB);

        // find common downstreams veticies
        List<Vertex> intersectionList = Algorithms.commonDownStream(aGraph, a, b);


        StringBuilder result = new StringBuilder();
        result.append("query:" + type.toString() + " " + userA + " " + userB).append(System.getProperty("line.separator"));
        result.append("<result>").append(System.getProperty("line.separator"));
        System.out.println("The common parents list:");
        for (Vertex x : intersectionList) {
            result.append(x.getLabel()).append(System.getProperty("line.separator"));
            ;
        }
        result.append("</result>").append(System.getProperty("line.separator"));

        return result;

    }

    public static void readTwitterfile() {
        aGraph = new AdjacencyListGraph();
        // The name of the file to open.
        String fileName = "datasets/twitter.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("->");
                Vertex v1 = new Vertex(arr[0].trim());
                Vertex v2 = new Vertex(arr[1].trim());
                aGraph.addVertex(v1);
                aGraph.addVertex(v2);

                aGraph.addEdge(v1, v2);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

}
